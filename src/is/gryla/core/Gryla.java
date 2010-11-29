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

        String inputText = "";

        if (args.length == 1){
            inputText = args[0];
        }

        String outTaggedAndParsedText = "";

        try {
            IceTaggerFacade tagger = new IceTaggerFacade(IceTagger.HmmModelType.startend);
            IceParserFacade parser = new IceParserFacade();

            Sentences sentences = tagger.tag(inputText);

            outTaggedAndParsedText = parser.parse(sentences.toString(), true, false);
            
        } catch (Exception e) {
            System.out.println("Tag and parsing error.");
        }

        Phrase thisPhrase = Phrase.parse(outTaggedAndParsedText, PhraseType.ROOT);
        RuleRunner roadRunner = new RuleRunner();
        roadRunner.run(thisPhrase);
        
        if (roadRunner.errors != null && roadRunner.errors.size() > 0){
            String outPut;
            for (is.gryla.core.Errors.Error error : roadRunner.errors){
                System.out.println(error.toString());
            }
        } else{
            System.out.println("ok");
        }

        return;
    }

}
