package Part_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 3090;

    public static void main(String[] args) throws IOException{

        Socket socket = new Socket(SERVER_IP, SERVER_PORT);

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        while(true){

            String command = keyboard.readLine();

            if(command.equals("quit")) break;

            out.println(command);

            String serverResponse = input.readLine();

            System.out.println("<SERVER> " + serverResponse);
        }

        socket.close();
        System.exit(0);

    }
}
