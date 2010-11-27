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

    }

    private void NPCaseDisagreement(Phrase phrase){
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
                        Error thisError = new Error(word.getCount(),word.getWord(),1,null);
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
                        Error thisError = new Error(word.getCount(),word.getWord(),2,null);
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
                        Error thisError = new Error(word.getCount(),word.getWord(),2,null);
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
}
