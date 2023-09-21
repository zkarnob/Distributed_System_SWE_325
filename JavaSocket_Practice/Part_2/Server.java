package Part_2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    private static final int PORT = 3090;
    private static final Logger logger = Logger.getLogger(Server.class.getName());

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);

        logger.info("<SERVER> Waiting for a client to connect");

        Socket clientSocket = serverSocket.accept();
        logger.info("<SERVER> A client is connected");

        PrintWriter clientWriter = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader clientReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        try {
            while (true) {
                String clientMessage = clientReader.readLine();
                logger.info("<CLIENT> " + clientMessage);
                clientWriter.println("<SERVER> Message received");
            }
        } finally {
            clientWriter.close();
            clientReader.close();
        }
    }
}
