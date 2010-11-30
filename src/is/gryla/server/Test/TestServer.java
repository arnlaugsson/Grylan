package is.gryla.server.Test;

import java.io.*;
import java.net.Socket;

public class TestServer {
    public static void main(String[] args) throws IOException{
        String testString = "Hún er góði kennarans. Hann er stór strákar. Hún er góð kennari. Hún er góður. Hún hljóp í gegnum skóginum. Hann borðuðu mikið.";
        Socket clientSocket = new Socket("localhost",1337);

        System.out.println("Sending string:\n" + testString + "\n");
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        //out.println("0"+testString); // Shutdown message (0 in front)
        out.println("1"+testString);

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String line;
        String errors = "";

        while((line = inFromServer.readLine()) != null){
             errors += line + "\n";
        }

        if (errors != "ok"){
            System.out.println("Reply:\n"+errors);
        } else if (errors == ""){
            System.out.println("No reply.");  
        } else {
            System.out.println("No errors found.");
        }

        out.close();
        clientSocket.close();
    }
}
