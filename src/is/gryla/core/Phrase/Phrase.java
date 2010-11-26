package is.gryla.core.Phrase;

import is.gryla.core.Word.*;
import is.gryla.core.Word.TagAttributes.WordClass;

import java.util.ArrayList;

public class Phrase {
    private ArrayList<Phrase> phrases;
    private ArrayList<InterfaceWord> words;
    private PhraseType type;
    private boolean questionMark;

    private Phrase(ArrayList<Phrase> phrases, ArrayList<InterfaceWord> words, PhraseType type, boolean questionMark) {
        this.phrases = phrases;
        this.words = words;
        this.type = type;
    }

    private static Phrase resolve(String in, PhraseType type) {
        ArrayList<Phrase> phrases = new ArrayList<Phrase>();
        ArrayList<InterfaceWord> words = new ArrayList<InterfaceWord>();
        boolean questionMark = false;

        if (type == PhraseType.NPq) {
            // IceNLP marked NP as suspicious
            questionMark = true;
        }

        // Við þurfum þetta ekki - notum type !!!
        PhraseType token = PhraseType.ROOT;

        while (in.length() > 0) {
            in = in.trim();
            String[] tokens = in.split(" ", 2);

            if (tokens[0].charAt(0) == '[' && tokens[0].length() > 1) {
                if (tokens[0] == "[NP?") {
                    // A new feature of IceNLP marks dubious NP with a question mark
                    token = PhraseType.NPq;
                } else {
                    token = PhraseType.valueOf(tokens[0].substring(1, tokens[0].length()));
                }
            } else if (tokens[0].charAt(0) == '{' && tokens[0].length() > 1) {
                if (tokens[0].charAt(tokens[0].length() - 1) == '<' || tokens[0].charAt(tokens[0].length() - 1) == '>') {
                    token = PhraseType.valueOf(tokens[0].substring(2, tokens[0].length() - 1));
                } else {
                    token = PhraseType.valueOf(tokens[0].substring(2, tokens[0].length()));
                }
            } else if (tokens[0].matches("[a-záéðíóúýþæöA-ZÁÉÐÍÓÚÝÞÆÖ0-9]*")) { // [a-záéðíóúýþæöA-ZÁÉÐÍÓÚÝÞÆÖ0-9]*

                // Word! Create an instance of a correct word class and add to wordList

                String tag = tokens[1];
                String word = tokens[0];

                String[] rest = {"", ""};
                if (tokens[1].contains(" ")) {
                    rest = tokens[1].split(" ", 2);
                    tag = rest[0];
                }
                
                switch (tag.charAt(0)) {
                    case 'n':
                        words.add(Noun.resolve(word, tag)); // Here is the first error in TestSentence
                        break;
                    case 'l':
                        words.add(Adjective.resolve(word, tag));
                        break;
                    case 'f':
                        words.add(Pronoun.resolve(word, tag));
                        break;
                    case 'g':
                        words.add(Article.resolve(word, tag));
                        break;
                    case 't':
                        words.add(Numeral.resolve(word, tag));
                        break;
                    case 's':
                        words.add(Verb.resolve(word, tag));
                        break;
                    case 'a':
                        words.add(AdverbPreposition.resolve(word, tag));
                        break;
                    case 'c':
                        words.add(Conjunction.resolve(word, tag));
                        break;
                    case 'e':
                        words.add(Foreign.resolve(word));
                        break;
                    case 'x':
                        words.add(Unanalyzed.resolve(word));
                        break;
                    default:
                        break;
                }

                in = rest[1];
                continue; // Next steps are only for Subphrases - not words, so we quit.
            } else {
                // punktur, punktur, komma strik
                String[] rest = {"", ""};
                if (tokens[1].contains(" ")) {
                    rest = tokens[1].split(" ", 2);
                }
                in = rest[1];
                continue;
            }

            Phrase phrase = null;
            int position;


            switch (token) {
                case AdvP:
                    position = tokens[1].indexOf("AdvP]");
                    phrases.add(resolve(tokens[1].substring(0, position), token));
                    in = tokens[1].substring(position + 5, tokens[1].length());
                    break;
                case AP:
                    position = tokens[1].indexOf("AP]");
                    //phrase = resolve(tokens[1], token);
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 3, tokens[1].length());
                    break;
                case NP:
                    position = tokens[1].indexOf("NP]");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 3, tokens[1].length());
                    break;
                case NPq:
                    position = tokens[1].indexOf("NP?]");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 4, tokens[1].length());
                    break;
                case PP:
                    position = tokens[1].indexOf("PP]");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 3, tokens[1].length());
                    break;
                case VPb:
                    position = tokens[1].indexOf("VPb]");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 4, tokens[1].length());
                    break;
                case VPi:
                    position = tokens[1].indexOf("VPi]");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 4, tokens[1].length());
                    break;
                case VPs:
                    position = tokens[1].indexOf("VPs]");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 4, tokens[1].length());
                    break;
                case VPg:
                    position = tokens[1].indexOf("VPg]");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 4, tokens[1].length());
                    break;
                case VP:
                    position = tokens[1].indexOf("VP]");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 3, tokens[1].length());
                    break;
                case CP:
                    position = tokens[1].indexOf("CP]");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 3, tokens[1].length());
                    break;
                case SCP:
                    position = tokens[1].indexOf("SCP]");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 4, tokens[1].length());
                    break;
                case InjP:
                    position = tokens[1].indexOf("InjP]");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 5, tokens[1].length());
                    break;
                case APs:
                    position = tokens[1].indexOf("APs]");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 4, tokens[1].length());
                    break;
                case NPs:
                    position = tokens[1].indexOf("NPs]");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 4, tokens[1].length());
                    break;
                case MWE:
                    position = tokens[1].indexOf("MWE]");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 4, tokens[1].length());
                    break;
                case QUAL:
                    position = tokens[1].indexOf("*QUAL");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    if (tokens[1].charAt(position + 5) == '}') {
                        in = tokens[1].substring(position + 6, tokens[1].length());
                    } else {
                        in = tokens[1].substring(position + 7, tokens[1].length());
                    }
                    break;
                case SUBJ:
                    position = tokens[1].indexOf("*SUBJ");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    if (tokens[1].charAt(position + 5) == '}') {
                        in = tokens[1].substring(position + 6, tokens[1].length());
                    } else {
                        in = tokens[1].substring(position + 7, tokens[1].length());
                    }
                    break;
                case OBJ:
                    position = tokens[1].indexOf("*OBJ");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    if (tokens[1].charAt(position + 4) == '}') {
                        in = tokens[1].substring(position + 5, tokens[1].length());
                    } else {
                        in = tokens[1].substring(position + 6, tokens[1].length());
                    }
                    break;
                case OBJAP:
                    position = tokens[1].indexOf("*OBJAP");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    if (tokens[1].charAt(position + 6) == '}') {
                        in = tokens[1].substring(position + 7, tokens[1].length());
                    } else {
                        in = tokens[1].substring(position + 8, tokens[1].length());
                    }
                    break;
                case OBJNOM:
                    position = tokens[1].indexOf("*OBJNOM");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    if (tokens[1].charAt(position + 7) == '}') {
                        in = tokens[1].substring(position + 8, tokens[1].length());
                    } else {
                        in = tokens[1].substring(position + 9, tokens[1].length());
                    }
                    break;
                case IOBJ:
                    position = tokens[1].indexOf("*IOBJ");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    if (tokens[1].charAt(position + 5) == '}') {
                        in = tokens[1].substring(position + 6, tokens[1].length());
                    } else {
                        in = tokens[1].substring(position + 7, tokens[1].length());
                    }
                    break;
                case COMP:
                    position = tokens[1].indexOf("*COMP");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    if (tokens[1].charAt(position + 5) == '}') {
                        in = tokens[1].substring(position + 6, tokens[1].length());
                    } else {
                        in = tokens[1].substring(position + 7, tokens[1].length());
                    }
                    break;
                case TIMEX:
                    position = tokens[1].indexOf("*TIMEX");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    if (tokens[1].charAt(position + 6) == '}') {
                        in = tokens[1].substring(position + 7, tokens[1].length());
                    } else {
                        in = tokens[1].substring(position + 8, tokens[1].length());
                    }
                    break;
                default:
                    break;
            }
            if (phrase != null) {
                phrases.add(phrase);
            }

        }
        return new Phrase(phrases, words, type, questionMark);
    }

    public static Phrase start(String in) {
        /* Called for the first time */

        ArrayList<Phrase> phrases = new ArrayList<Phrase>();
        PhraseType token = PhraseType.ROOT;

        while (in.length() > 0) {
            in = in.trim();
            String[] tokens = in.split(" ", 2);

            if (tokens[0].charAt(0) == '[' && tokens[0].length() > 1) {
                if (tokens[0] == "[NP?") {
                    // A new feature of IceNLP marks dubious NP with a question mark
                    token = PhraseType.NPq;
                } else {
                    token = PhraseType.valueOf(tokens[0].substring(1, tokens[0].length()));
                }
            } else if (tokens[0].charAt(0) == '{' && tokens[0].length() > 1) {
                if (tokens[0].charAt(tokens[0].length() - 1) == '<' || tokens[0].charAt(tokens[0].length() - 1) == '>') {
                    token = PhraseType.valueOf(tokens[0].substring(2, tokens[0].length() - 1));
                } else {
                    token = PhraseType.valueOf(tokens[0].substring(2, tokens[0].length()));
                }
            } else {
                // punktur, punktur, komma strik
                String[] rest = {"", ""};
                if (tokens[1].contains(" ")) {
                    rest = tokens[1].split(" ", 2);
                }
                in = rest[1];
                continue;
            }


            Phrase phrase = null;
            int position = 0;


            switch (token) {
                // TODO: Make a function that does this for all cases and call function everywhere :)
                case AdvP:
                    position = tokens[1].indexOf("AdvP]");
                    phrases.add(resolve(tokens[1].substring(0, position), token));
                    in = tokens[1].substring(position + 5, tokens[1].length() - 1);
                    break;
                case AP:
                    position = tokens[1].indexOf("AP]");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 3, tokens[1].length());
                    break;
                case NP:
                    position = tokens[1].indexOf("NP]");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 3, tokens[1].length());
                    break;
                case NPq:
                    position = tokens[1].indexOf("NP?]");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 4, tokens[1].length());
                    break;
                case PP:
                    position = tokens[1].indexOf("PP]");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 3, tokens[1].length());
                    break;
                case VPb:
                    position = tokens[1].indexOf("VPb]");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 4, tokens[1].length());
                    break;
                case VPi:
                    position = tokens[1].indexOf("VPi]");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 4, tokens[1].length());
                    break;
                case VPs:
                    position = tokens[1].indexOf("VPs]");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 4, tokens[1].length());
                    break;
                case VPg:
                    position = tokens[1].indexOf("VPg]");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 4, tokens[1].length());
                    break;
                case VP:
                    position = tokens[1].indexOf("VP]");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 3, tokens[1].length());
                    break;
                case CP:
                    position = tokens[1].indexOf("CP]");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 3, tokens[1].length());
                    break;
                case SCP:
                    position = tokens[1].indexOf("SCP]");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 4, tokens[1].length());
                    break;
                case InjP:
                    position = tokens[1].indexOf("InjP]");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 5, tokens[1].length());
                    break;
                case APs:
                    position = tokens[1].indexOf("APs]");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 4, tokens[1].length());
                    break;
                case NPs:
                    position = tokens[1].indexOf("NPs]");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 4, tokens[1].length());
                    break;
                case MWE:
                    position = tokens[1].indexOf("MWE]");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    in = tokens[1].substring(position + 4, tokens[1].length());
                    break;
                case QUAL:
                    position = tokens[1].indexOf("*QUAL");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    if (tokens[1].charAt(position + 5) == '}') {
                        in = tokens[1].substring(position + 6, tokens[1].length());
                    } else {
                        in = tokens[1].substring(position + 7, tokens[1].length());
                    }
                    break;
                case SUBJ:
                    position = tokens[1].indexOf("*SUBJ");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    if (tokens[1].charAt(position + 5) == '}') {
                        in = tokens[1].substring(position + 6, tokens[1].length());
                    } else {
                        in = tokens[1].substring(position + 7, tokens[1].length());
                    }
                    break;
                case OBJ:
                    position = tokens[1].indexOf("*OBJ");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    if (tokens[1].charAt(position + 4) == '}') {
                        in = tokens[1].substring(position + 5, tokens[1].length());
                    } else {
                        in = tokens[1].substring(position + 6, tokens[1].length());
                    }
                    break;
                case OBJAP:
                    position = tokens[1].indexOf("*OBJAP");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    if (tokens[1].charAt(position + 6) == '}') {
                        in = tokens[1].substring(position + 7, tokens[1].length());
                    } else {
                        in = tokens[1].substring(position + 8, tokens[1].length());
                    }
                    break;
                case OBJNOM:
                    position = tokens[1].indexOf("*OBJNOM");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    if (tokens[1].charAt(position + 7) == '}') {
                        in = tokens[1].substring(position + 8, tokens[1].length());
                    } else {
                        in = tokens[1].substring(position + 9, tokens[1].length());
                    }
                    break;
                case IOBJ:
                    position = tokens[1].indexOf("*IOBJ");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    if (tokens[1].charAt(position + 5) == '}') {
                        in = tokens[1].substring(position + 6, tokens[1].length());
                    } else {
                        in = tokens[1].substring(position + 7, tokens[1].length());
                    }
                    break;
                case COMP:
                    position = tokens[1].indexOf("*COMP");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    if (tokens[1].charAt(position + 5) == '}') {
                        in = tokens[1].substring(position + 6, tokens[1].length());
                    } else {
                        in = tokens[1].substring(position + 7, tokens[1].length());
                    }
                    break;
                case TIMEX:
                    position = tokens[1].indexOf("*TIMEX");
                    phrase = resolve(tokens[1].substring(0, position), token);
                    if (tokens[1].charAt(position + 6) == '}') {
                        in = tokens[1].substring(position + 7, tokens[1].length());
                    } else {
                        in = tokens[1].substring(position + 8, tokens[1].length());
                    }
                    break;
                default:
                    // Todo: laga fyrir enda setninga!!!
                    //in = tokens[1].split(" ", 3)[2]; // Throw out of string
                    break;
            }
            if (phrase != null) {
                phrases.add(phrase);
            }
        }
        return new Phrase(phrases, null, PhraseType.ROOT, false);
    }

    /**
     *  Returns a list of all words belonging to the phrase and it's possible subphrases (recursive).
     *  Note: words are not necessarily in the correct order..
     *
     * @return ArrayList of all words found beneath phrase
     */
    public ArrayList<InterfaceWord> getAllWords(){
        ArrayList<InterfaceWord> words = new ArrayList<InterfaceWord>();

        if (this.words != null){
            words.addAll(this.words);
        }

        if (this.phrases != null){
            for (Phrase phrase : this.phrases){
                words.addAll(phrase.getAllWords());
            }
        }
        return words;
    }

    public void runRules(){
        
    }

    public PhraseType getType() {
        return type;
    }

    public boolean isQuestionMark() {
        return questionMark;
    }

    public ArrayList<Phrase> getPhrases() {
        return phrases;
    }

    public ArrayList<InterfaceWord> getWords() {
        return words;
    }
}

