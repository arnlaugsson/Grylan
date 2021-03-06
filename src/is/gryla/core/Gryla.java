/**
 * Created by IntelliJ IDEA.
 * User: Kristján og Skúli
 * Date: 10.11.2010
 * Time: 15:04:38
 */

package is.gryla.core;

import is.gryla.core.Phrase.Phrase;
import is.gryla.core.Phrase.PhraseType;
import is.gryla.core.Rules.RuleRunner;
import is.iclt.icenlp.core.icetagger.IceTagger;
import is.iclt.icenlp.core.tokenizer.Sentences;
import is.iclt.icenlp.facade.IceParserFacade;
import is.iclt.icenlp.facade.IceTaggerFacade;

import java.io.IOException;

class Gryla {
    public static void main(String[] args) throws IOException {

        String inputText = args[0];
        String outTaggedAndParsedText = "";


        IceTaggerFacade tagger = new IceTaggerFacade(IceTagger.HmmModelType.startend);
        IceParserFacade parser = new IceParserFacade();

        Sentences sentences = tagger.tag(inputText);
        outTaggedAndParsedText = parser.parse(sentences.toString(), true, false);

        Phrase thisPhrase = Phrase.parse(outTaggedAndParsedText, PhraseType.ROOT);
        RuleRunner ruleRunner = new RuleRunner();
        ruleRunner.run(thisPhrase);

        if (ruleRunner.errors != null && ruleRunner.errors.size() > 0) {
            for (is.gryla.core.Errors.Error error : ruleRunner.errors) {
                System.out.println(error.toString());
            }
        } else {
            System.out.println("ok");
        }
    }

}
