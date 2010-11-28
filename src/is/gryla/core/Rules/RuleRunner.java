package is.gryla.core.Rules;

import is.gryla.core.Errors.Error;
import is.gryla.core.Phrase.Phrase;
import is.gryla.core.Phrase.PhraseType;
import is.gryla.core.Word.InterfaceWord;
import is.gryla.core.Word.TagAttributes.*;
import is.gryla.core.Word.TagAttributes.Number;


import java.util.ArrayList;

public class RuleRunner {
    public ArrayList<Error> errors;
    private Phrase root;

    public RuleRunner() {
        this.errors = new ArrayList<Error>();
        this.root = null;
    }

    public void run(Phrase sentence){
        this.root = sentence;

        NPCaseDisagreement(this.root);
        NPNumberDisagreement(this.root);
        NPGenderDisagreement(this.root);
        PPCaseDisagreement(this.root);
        SubjCompGenderNumberDisagreement(this.root);
    }

    private void NPCaseDisagreement(Phrase phrase){
        int ruleNumber = 1;
        if (phrase.getType() == PhraseType.NP){
            ArrayList<InterfaceWord> words = phrase.getAllWords();

            Case base = null;

            for (InterfaceWord word : words){
                if (word.getCase() != null && word.getType() != WordClass.VERB){
                    if (base == null){
                        base = word.getCase();
                    }
                    if (base != word.getCase()){
                        // An error was found
                        Error thisError = new Error(word.getCount(),word.getWord(),ruleNumber,null);
                        errors.add(thisError);
                    }
                }
            }

        } else {
            if (phrase.getPhrases() != null){
                for (Phrase subphrase : phrase.getPhrases()){
                    // Recursively call this rule to all possible sub-phrases
                    NPCaseDisagreement(subphrase);
                }
            }
        }
    }

    private void NPNumberDisagreement(Phrase phrase){
        int ruleNumber = 2;
        if (phrase.getType() == PhraseType.NP){
            ArrayList<InterfaceWord> words = phrase.getAllWords();

            Number base = null;

            for (InterfaceWord word : words){
                if (word.getNumber() != null && word.getType() != WordClass.VERB){
                    if (base == null){
                        base = word.getNumber();
                    }
                    if (base != word.getNumber()){
                        // An error was found
                        Error thisError = new Error(word.getCount(),word.getWord(),ruleNumber,null);
                        errors.add(thisError);
                    }
                }
            }

        } else {
            if (phrase.getPhrases() != null){
                for (Phrase subphrase : phrase.getPhrases()){
                    // Recursively call this rule to all possible sub-phrases
                    NPNumberDisagreement(subphrase);
                }
            }
        }
    }

    private void NPGenderDisagreement(Phrase phrase){
        int ruleNumber = 3;
        if (phrase.getType() == PhraseType.NP){
            ArrayList<InterfaceWord> words = phrase.getAllWords();

            GenderPerson base = null;

            for (InterfaceWord word : words){
                if (word.getGenderPerson() != null && word.getType() != WordClass.VERB){
                    if (base == null){
                        base = word.getGenderPerson();
                    }
                    if (base != word.getGenderPerson()){
                        // An error was found
                        Error thisError = new Error(word.getCount(),word.getWord(),ruleNumber,null);
                        errors.add(thisError);
                    }
                }
            }

        } else {
            if (phrase.getPhrases() != null){
                for (Phrase subphrase : phrase.getPhrases()){
                    // Recursively call this rule to all possible sub-phrases
                    NPGenderDisagreement(subphrase);
                }
            }
        }
    }

    private void SubjCompGenderNumberDisagreement(Phrase phrase){
        // TODO: Improve function! 
        // Can only handle 1 sentence segments and only when the SUBJ is before the COMP ("Hún er góð" not "Góð er hún").
        int ruleNumber = 4;

        Number n = Number.NONE;
        GenderPerson gp = GenderPerson.NONE;

        for (Phrase subphrase : phrase.getPhrases()){

            if (subphrase.getType() == PhraseType.SUBJ){

                ArrayList<InterfaceWord> words = subphrase.getAllWords();
                for (InterfaceWord word : words){
                    if (word.getType() == WordClass.NOUN || word.getType() == WordClass.ADJECTIVE
                            || word.getType() == WordClass.PRONOUN || word.getType() == WordClass.ARTICLE){

                        gp = word.getGenderPerson();
                        n = word.getNumber();
                    }
                }

            } else if (subphrase.getType() == PhraseType.COMP){
                if (n != Number.NONE){
                    ArrayList<InterfaceWord> compWords = subphrase.getAllWords();
                    for (InterfaceWord word : compWords){
                        if (word.getType() == WordClass.ADJECTIVE){
                            if (gp != word.getGenderPerson() || n != word.getNumber()){
                                // Error
                                Error thisError = new Error(word.getCount(),word.getWord(),ruleNumber,null);
                                errors.add(thisError);
                            }
                        }
                    }
                }
            }
        }
    }

    private void PPCaseDisagreement(Phrase phrase){
        int ruleNumber = 5;
        if (phrase.getType() == PhraseType.PP){

            AdverbCategory govern = AdverbCategory.DOES_NOT; // default

            ArrayList<InterfaceWord> words = phrase.getWords();

            for (Phrase possible : phrase.getPhrases()){
                if (possible.getType() == PhraseType.MWE_PP){
                    words.addAll(possible.getWords());
                }
            }

            for (InterfaceWord word : words){
                if (word.getType() == WordClass.ADVERB){
                    if (word.getAdverbCategory() != AdverbCategory.DOES_NOT && word.getAdverbCategory() != AdverbCategory.EXCLAMATION){

                        // This preposition governs a certain case
                        // We need to make sure that all nouns in nested noun phrases have the same case!

                        govern = word.getAdverbCategory();
                    }
                }
            }

            if (govern != AdverbCategory.DOES_NOT){
               for (Phrase subphrase : phrase.getPhrases()){
                   if (subphrase.getType() == PhraseType.NPs || subphrase.getType() == PhraseType.NP){

                       words = subphrase.getAllWords();

                       for (InterfaceWord word : words){
                           WordClass wc = word.getType();
                           if (wc == WordClass.NOUN || wc == WordClass.ADJECTIVE
                                   || wc == WordClass.PRONOUN || wc == WordClass.ARTICLE
                                   || wc == WordClass.NUMERAL){

                               Case ncase = word.getCase();

                               if (ncase != Case.NO_CASE && ncase != Case.NOMINATIVE){
                                    AdverbCategory ac = AdverbCategory.valueOf(ncase.toString());
                                    if (govern != ac)  {
                                        // An error was found
                                        Error thisError = new Error(word.getCount(),word.getWord(),ruleNumber,null);
                                        errors.add(thisError);
                                    }
                               }
                           }
                       }
                   }
               }
            }
        } else {
            if (phrase.getPhrases() != null){
                for (Phrase subphrase : phrase.getPhrases()){
                    // Recursively call this rule to all possible sub-phrases
                    PPCaseDisagreement(subphrase);
                }
            }
        }
    }
}
