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
        System.out.println("Málgrýlan - A rule-based grammar checker for Icelandic");

        if (args.length < 1) {
            System.out.println("-------------------------------------");
            System.out.println("Usage: > java Gryla \"Text to check for errors.\"");
            System.out.println("Notkun: > java Gryla \"Texti til þess að athuga.\"");
            System.out.println("-------------------------------------");
            System.out.println("Note: Can also be run a server - see TCPServer.java");
            return;
        }

        String inputText = args[0];
        String outTaggedAndParsedText = "";


        System.out.println("-------------------------------------");
        System.out.println("Sentence: \"" + inputText + "\"");

        IceTaggerFacade tagger = new IceTaggerFacade(IceTagger.HmmModelType.startend);
        IceParserFacade parser = new IceParserFacade();

        Sentences sentences = tagger.tag(inputText);
        outTaggedAndParsedText = parser.parse(sentences.toString(), true, false);

        Phrase thisPhrase = Phrase.parse(outTaggedAndParsedText, PhraseType.ROOT);
        RuleRunner ruleRunner = new RuleRunner();
        ruleRunner.run(thisPhrase);

        if (ruleRunner.errors != null && ruleRunner.errors.size() > 0) {
            System.out.println("Error(s) found:");
            for (is.gryla.core.Errors.Error error : ruleRunner.errors) {
                System.out.println("\t" + error.toString());
            }
        } else {
            System.out.println("No errors found.");
        }
        System.out.println("-------------------------------------");
    }

}
