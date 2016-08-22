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
        Writer logger = LogWriter.getInstance();
        logger.init();
        
        // Init csv writer
        Writer csv = CsvWriter.getInstance();
        csv.init();
        
        logger.write("Server started");
        csv.write("Server started");
        
        while(true) {
           Socket connectionSocket = welcomeSocket.accept();
           BufferedReader inFromClient =
              new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
           clientSentence = inFromClient.readLine();
           logger.write(clientSentence);
           csv.write(clientSentence);
        }
	}

}
