package is.gryla.server;

import is.gryla.core.Phrase.Phrase;
import is.gryla.core.Phrase.PhraseType;
import is.gryla.core.Rules.RuleRunner;
import is.iclt.icenlp.core.icetagger.IceTagger;
import is.iclt.icenlp.core.tokenizer.Sentences;
import is.iclt.icenlp.facade.IceParserFacade;
import is.iclt.icenlp.facade.IceTaggerFacade;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {
    public static void main(String args[]) throws IOException {
        int port;

        System.out.println("Málgrýlan TCP server starting up..");

        // IceNLP facades
        IceTaggerFacade tagger = new IceTaggerFacade(IceTagger.HmmModelType.startend);
        IceParserFacade parser = new IceParserFacade();

        try {
            port = Integer.parseInt(args[0]);
            System.out.println("Server running at port " + port);
        }
        catch (Exception e) {
            port = 1337;
            System.out.println("Server running at port " + port + " (default)");
        }

        ServerSocket server_socket = new ServerSocket(port);
        System.out.println("Server waiting for requests on port " +
                server_socket.getLocalPort());

        // server infinite loop
        Phrase thisPhrase = new Phrase();
        while (true) {
            Socket socket = server_socket.accept();
            System.out.println("New request accepted " +
                    socket.getInetAddress() +
                    ":" + socket.getPort());

            //Scanner scanner = new Scanner(socket.getInputStream());
            BufferedReader bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // print received data

            //int command = bReader.read(); 
            String message = bReader.readLine();

            if (message == null) continue;
            System.out.println("-------------------------------------");
            System.out.println("Sentence: \"" + message + "\"");

            // Here we do the parsing and the error detection
            Sentences sentences = tagger.tag(message);
            String outTaggedAndParsedText = parser.parse(sentences.toString(), true, false);

            thisPhrase.resetCount();
            thisPhrase = Phrase.parse(outTaggedAndParsedText, PhraseType.ROOT);
            
            RuleRunner ruleRunner = new RuleRunner();
            ruleRunner.run(thisPhrase);

            PrintWriter outstream = new PrintWriter(socket.getOutputStream(), true);
            if (ruleRunner.errors != null && ruleRunner.errors.size() > 0) {
                System.out.println("Error(s) found:");
                for (is.gryla.core.Errors.Error error : ruleRunner.errors) {
                    outstream.println(error.toString());
                    System.out.println("\t" + error.toString());
                }
            } else {
                outstream.println("ok");
                System.out.println("No errors found, \"ok\" message sent.");
            }
            System.out.println("-------------------------------------");
            bReader.close();
            outstream.close();
            socket.close();
            //break; 
        }
    }
}