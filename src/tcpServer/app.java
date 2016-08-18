package tcpServer;

import java.io.*;
import java.net.*;

public class app {

	public static void main(String[] args) throws IOException {
//        Init local vars
		String clientSentence;
        String capitalizedSentence;
        ServerSocket welcomeSocket = new ServerSocket(6789);
        // Init Message Logger
        MsgLogger logger = new MsgLogger();
        logger.write_log("Server started");
        
        while(true) {
           Socket connectionSocket = welcomeSocket.accept();
           BufferedReader inFromClient =
              new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
//           DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
           clientSentence = inFromClient.readLine();
           System.out.println("Received: " + clientSentence);
           
           logger.write_log(clientSentence);
           
           capitalizedSentence = clientSentence.toUpperCase() + '\n';
//           outToClient.writeBytes(capitalizedSentence);
        }
	}

}
