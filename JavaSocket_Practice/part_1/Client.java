package part_1;

import java.io.*;
import java.net.Socket;

public class Client {

    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 3090;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String serverResponse = input.readLine();

            System.out.println(serverResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
