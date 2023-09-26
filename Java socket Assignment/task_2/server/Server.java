    package task_2.server;

    import task_2.clients.ClientHandler;

    import java.io.IOException;
    import java.net.ServerSocket;
    import java.net.Socket;
    import java.util.Scanner;
    import java.util.concurrent.ExecutorService;
    import java.util.concurrent.Executors;

    public class Server {

        // Server socket that accepts client and handles data flow.
        private ServerSocket serverSocket;
        private ExecutorService executor;

        public Server(ServerSocket serverSocket, int numberOfParticipants) {
            this.serverSocket = serverSocket;
            executor = Executors.newFixedThreadPool(numberOfParticipants);
        }


        public void starServer() {
            try {
                while (!serverSocket.isClosed()) {

                    Socket socket = serverSocket.accept();
                    System.out.println("A new client has been connected!");
                    executor.execute(new ClientHandler(socket));
                }
            } catch (IOException e) {
                e.printStackTrace();
                closeServerSocket();
            }
        }

        public void closeServerSocket() {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) throws IOException {
            ServerSocket serverSocket = new ServerSocket(3090);
            System.out.println("Server started listening on port: 3090");



          int numberOfParticipants = 3;

            Server server = new Server(serverSocket, numberOfParticipants);
            server.starServer();
        }

    }