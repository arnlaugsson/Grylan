package is.gryla.core.Rules;

import is.gryla.core.Errors.Errors;
import is.gryla.core.Phrase.Phrase;
import is.gryla.core.Phrase.PhraseType;
import is.gryla.core.Word.InterfaceWord;
import is.gryla.core.Word.Noun;
import is.gryla.core.Word.TagAttributes.Case;
import is.gryla.core.Word.TagAttributes.WordClass;

import java.util.ArrayList;

public class RuleRunner {
    public ArrayList<Errors> errors;
    private Phrase root;

    public RuleRunner() {
        this.errors = null; // No errors before parsing silly!!! :D :) :O) TODO: taka þetta í burtu !! :)
        this.root = null;
    }

    public void run(Phrase sentence){
        this.root = sentence;

        NPCaseDisagreement(this.root);

    }

    private void NPCaseDisagreement(Phrase phrase){
        if (phrase.getType() == PhraseType.NP){
            ArrayList<InterfaceWord> words = phrase.getAllWords();
            for (InterfaceWord word : words){
                if (word.getType() == WordClass.NOUN){
                    Noun noun = (Noun) word;
                    System.out.print(noun.getCase() + " ");
                }
            }
            System.out.println("\n");
        } else {
            // Köllum recursively á öll föll
            if (phrase.getPhrases() != null){
                for (Phrase subphrase : phrase.getPhrases()){
                    NPCaseDisagreement(subphrase);
                }
            }
        }
    }
}
