package is.gryla.core.Phrase;

import is.gryla.core.Word.*;

import java.util.ArrayList;

public class Phrase {
    private ArrayList<Phrase> phrases;
    private ArrayList<InterfaceWord> words;
    private PhraseType type;
    private boolean questionMark; // Not currently used - see NPq grammar rule todo.
    private static int count = 0;

    private Phrase(ArrayList<Phrase> phrases, ArrayList<InterfaceWord> words, PhraseType type, boolean questionMark) {
        this.phrases = phrases;
        this.words = words;
        this.type = type;
    }

    public static Phrase resolve(String in, PhraseType type) {
        ArrayList<Phrase> phrases = new ArrayList<Phrase>();
        ArrayList<InterfaceWord> words = new ArrayList<InterfaceWord>();
        PhraseType token;
        boolean questionMark = false;

        if (type == PhraseType.NPq) {
            // TODO: add a new grammar rule for these kinds of NP's
            questionMark = true;
        }

        // New Implementation

        in = in.replace("\n"," ");

        while (in.length() > 0) {
            in = in.trim();
            String[] parts = in.split(" ", 2);

            if (parts[0].length() > 1) {
                if (parts[0].charAt(0) == '[' || parts[0].charAt(0) == '{') {

                    // Start of phrase
                    // .. but what type of phrase?? Let's find out.

                    String identifier = parts[0].substring(1); // Ignore [ or {
                    int upTo = parts[1].indexOf(identifier);

                    String name = identifier;
                    // Remove annoying characters ;)
                    name = name.replace("*","");
                    name = name.replace(">","");
                    name = name.replace("<","");

                    if (name.startsWith("MWE")){
                        // We are only interested in marking MWE, not what type of MWE it is!
                        name = name.substring(0,2);
                    }

                    switch (PhraseType.valueOf(name)) {
                        case AdvP:
                            phrases.add(resolve(parts[1].substring(0, upTo), PhraseType.AdvP));
                            break;
                        case AP:
                            phrases.add(resolve(parts[1].substring(0, upTo), PhraseType.AP));
                            break;
                        case NP:
                            phrases.add(resolve(parts[1].substring(0, upTo), PhraseType.NP));
                            break;
                        case NPq:
                            phrases.add(resolve(parts[1].substring(0, upTo), PhraseType.NPq));
                            break;
                        case PP:
                            phrases.add(resolve(parts[1].substring(0, upTo), PhraseType.PP));
                            break;
                        case VPb:
                            phrases.add(resolve(parts[1].substring(0, upTo), PhraseType.VPb));
                            break;
                        case VPi:
                            phrases.add(resolve(parts[1].substring(0, upTo), PhraseType.VPi));
                            break;
                        case VPs:
                            phrases.add(resolve(parts[1].substring(0, upTo), PhraseType.VPs));
                            break;
                        case VPg:
                            phrases.add(resolve(parts[1].substring(0, upTo), PhraseType.VPg));
                            break;
                        case VP:
                            phrases.add(resolve(parts[1].substring(0, upTo), PhraseType.VP));
                            break;
                        case CP:
                            phrases.add(resolve(parts[1].substring(0, upTo), PhraseType.CP));
                            break;
                        case SCP:
                            phrases.add(resolve(parts[1].substring(0, upTo), PhraseType.SCP));
                            break;
                        case InjP:
                            phrases.add(resolve(parts[1].substring(0, upTo), PhraseType.InjP));
                            break;
                        case APs:
                            phrases.add(resolve(parts[1].substring(0, upTo), PhraseType.APs));
                            break;
                        case NPs:
                            phrases.add(resolve(parts[1].substring(0, upTo), PhraseType.NPs));
                            break;
                        case MWE:
                            phrases.add(resolve(parts[1].substring(0, upTo), PhraseType.MWE));
                            break;
                        case QUAL:
                            phrases.add(resolve(parts[1].substring(0, upTo), PhraseType.QUAL));
                            break;
                        case SUBJ:
                            phrases.add(resolve(parts[1].substring(0, upTo), PhraseType.SUBJ));
                            break;
                        case OBJ:
                            phrases.add(resolve(parts[1].substring(0, upTo), PhraseType.OBJ));
                            break;
                        case OBJAP:
                            phrases.add(resolve(parts[1].substring(0, upTo), PhraseType.OBJAP));
                            break;
                        case OBJNOM:
                            phrases.add(resolve(parts[1].substring(0, upTo), PhraseType.OBJNOM));
                            break;
                        case IOBJ:
                            phrases.add(resolve(parts[1].substring(0, upTo), PhraseType.IOBJ));
                            break;
                        case COMP:
                            phrases.add(resolve(parts[1].substring(0, upTo), PhraseType.COMP));
                            break;
                        case TIMEX:
                            phrases.add(resolve(parts[1].substring(0, upTo), PhraseType.TIMEX));
                            break;
                        default:
                            throw new RuntimeException("No known phrase type starts with " + identifier + ".");
                    }
                    // Now our remaining text gets sent to the input variable to keep on parsing
                    in = parts[1].substring(upTo+identifier.length()+1);

                } else {

                    // Start of word

                    String tag = parts[1];
                    String word = parts[0];

                    String[] rest = {"", ""};
                    if (tag.contains(" ")) {
                        rest = tag.split(" ", 2);
                        tag = rest[0];
                    }

                    switch (tag.charAt(0)) {
                        case 'n':
                            words.add(Noun.resolve(word, tag, count));
                            break;
                        case 'l':
                            words.add(Adjective.resolve(word, tag, count));
                            break;
                        case 'f':
                            words.add(Pronoun.resolve(word, tag, count));
                            break;
                        case 'g':
                            words.add(Article.resolve(word, tag, count));
                            break;
                        case 't':
                            words.add(Numeral.resolve(word, tag, count));
                            break;
                        case 's':
                            words.add(Verb.resolve(word, tag, count));
                            break;
                        case 'a':
                            words.add(AdverbPreposition.resolve(word, tag, count));
                            break;
                        case 'c':
                            words.add(Conjunction.resolve(word, tag, count));
                            break;
                        case 'e':
                            words.add(Foreign.resolve(word, count));
                            break;
                        case 'x':
                            words.add(Unanalyzed.resolve(word, count));
                            break;
                        default:
                            words.add(Miscellaneous.resolve(word, count));
                            break;
                    }
                    count++;
                    in = rest[1];
                }
            } else {
                String word = parts[0];

                String[] rest = {"", ""};
                if (parts[1].contains(" ")) {
                    rest = parts[1].split(" ", 2);
                }

                words.add(Miscellaneous.resolve(word,count));
                count++;
                in = rest[1];
            }
        }
        return new Phrase(phrases, words, type, questionMark);
    }


    /**
     * Returns a list of all words belonging to the phrase and it's possible subphrases (recursive).
     * Note: words are not necessarily in the correct order..
     *
     * @return ArrayList of all words found beneath phrase
     */
    public ArrayList<InterfaceWord> getAllWords() {
        ArrayList<InterfaceWord> words = new ArrayList<InterfaceWord>();

        if (this.words != null) {
            words.addAll(this.words);
        }

        if (this.phrases != null) {
            for (Phrase phrase : this.phrases) {
                words.addAll(phrase.getAllWords());
            }
        }
        return words;
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

