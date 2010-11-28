/**
 * Created by IntelliJ IDEA.
 * User: Kristján og Skúli
 * Date: 10.11.2010
 * Time: 15:04:38
 */

package is.gryla.core;

import is.gryla.core.Errors.*;
import is.gryla.core.Phrase.Phrase;
import is.gryla.core.Phrase.PhraseType;
import is.gryla.core.Rules.RuleRunner;
import is.gryla.core.Word.InterfaceWord;
import is.iclt.icenlp.core.tokenizer.Sentences;
import is.iclt.icenlp.core.icetagger.IceTagger;
import is.iclt.icenlp.facade.IceTaggerFacade;
import is.iclt.icenlp.facade.IceParserFacade;

import java.util.ArrayList;

class Gryla {
    public static void main(String[] args) {

        //TODO: Ætli það sé betra að nota StringBuffer???
        String inputText = "";

        //Input should be a text inside parentheses ""
        if (args.length == 1){
            inputText = args[0];
        }

        //inputText = "Test lína til að parsa og tagga ef það sé ekkert inntak.";
        String outTaggedAndParsedText = "";


        try {
            IceTaggerFacade tagger = new IceTaggerFacade(IceTagger.HmmModelType.startend);
            IceParserFacade parser = new IceParserFacade();

            //Here we tag the text and get it back in a Sentence form.
            Sentences sentences = tagger.tag(inputText);

            //Next we send the Sentences as strings to the parser and get back a string.
            outTaggedAndParsedText = parser.parse(sentences.toString(), true, false);
            
        } catch (Exception e) {
            System.out.println("Tag and parsing error.");
            //System.err.println("Error: " + e);
        }

        Phrase thisPhrase = Phrase.parse(outTaggedAndParsedText, PhraseType.ROOT);
        RuleRunner roadRunner = new RuleRunner();
        roadRunner.run(thisPhrase);

        
        if (roadRunner.errors != null && roadRunner.errors.size() > 0){
            for (is.gryla.core.Errors.Error error : roadRunner.errors){
                System.out.println(error.toString());
            }
        } else{
            System.out.println("ok");
        }

        return;
    }

}
