package part_1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    private static final int PORT = 3090;
    private static final Logger logger = Logger.getLogger(Server.class.getName());

    public static void main(String[] args) {
        try (ServerSocket listener = new ServerSocket(PORT)) {
            logger.info("<SERVER> Waiting for client to connect");

            try (Socket client = listener.accept();
                 PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {

                logger.info("<SERVER> A client is connected");
                out.println("<SERVER> Connected to the server");
                logger.info("<SERVER> Single interaction done. Server closed!");
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "An error occurred", e);
        }
    }
}
