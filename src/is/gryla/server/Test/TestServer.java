package is.gryla.server.Test;

import java.io.*;
import java.net.Socket;
import java.rmi.UnknownHostException;

public class TestServer {
    public static void main(String[] args) throws IOException{

        System.out.println("Málgrýlan test server");
        System.out.println("------------------------------");
        String testString;
        int port;

        try {
            port = Integer.parseInt(args[0]);
            testString = args[1];
        }
        catch (Exception e) {
            testString = "Hún er góði kennarans. Hann er stór strákar. Hún er góð kennari. Hún er góður. Hún hljóp í gegnum skóginum. Hann borðuðu mikið.";
            port = 1337;
            System.out.println("Invalid or missing parameters, using port number " + port + " (default)");
        }

        try {
            Socket clientSocket = new Socket("localhost",port);


            System.out.println("Sending string:\n" + testString + "\n");
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            //out.println("0"+testString); // Shutdown message (0 in front)
            out.println("1" + testString);

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String line;
            String errors = "";

            while ((line = inFromServer.readLine()) != null) {
                errors += line + "\n";
            }

            if (errors != "ok") {
                System.out.println("Reply:\n" + errors);
            } else if (errors == "") {
                System.out.println("No reply.");
            } else {
                System.out.println("No errors found.");
            }

            out.close();
            clientSocket.close();
        }
        catch (UnknownHostException e) {
            System.out.println("Could not resolve host at port " + port);
            return;
        }
    }
}
