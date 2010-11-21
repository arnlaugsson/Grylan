/**
 * Created by IntelliJ IDEA.
 * User: Kristjan
 * Date: 10.11.2010
 * Time: 15:04:38
 * To change this template use File | Settings | File Templates.
 */
package is.gryla.core;

import is.iclt.icenlp.core.tokenizer.Sentences;
import is.iclt.icenlp.core.icetagger.IceTagger;
import is.iclt.icenlp.facade.IceTaggerFacade;
import is.iclt.icenlp.facade.IceParserFacade;

class Gryla {
    public static void main(String[] args) {

        //TODO: Ætli það sé betra að nota StringBuffer???
        String inputText = args[0];
        inputText = "Test bla";
        String outTaggedAndParsedtext = "";

        //Jájá


        try {
            IceTaggerFacade tagger = new IceTaggerFacade(IceTagger.HmmModelType.startend);
            IceParserFacade parser = new IceParserFacade();

            //Here we tag the text and get it back in a Sentence form.
            Sentences sentences = tagger.tag(inputText);
            //Next we send the Sentences as string to the parser and get back a string.
            outTaggedAndParsedtext = parser.parse(sentences.toString(), true, true);

            System.out.println("Tagged text: " + sentences.toString());

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }

        System.out.println("Tagged and parsed: \n" + outTaggedAndParsedtext);
    }

}
