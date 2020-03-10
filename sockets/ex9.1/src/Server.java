import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        final int PORT = 6969;
        System.out.println("Starting server... ");

        ServerSocket welcomeSocket = new ServerSocket(PORT);
        while (true) {
            System.out.println("Waiting for a client... ");
            Socket socket = welcomeSocket.accept();
            new Thread(() -> {
                try {
                    System.out.printf("%s connected\n", socket.getInetAddress().toString());
//                    Socket socket = serve;
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                    String request = in.readLine();

                    if (!request.equals("connect"))
                        out.println("Disconnected");
                    else {
                        out.println("Username?");
                        in.readLine(); //username
                        out.println("Password?");
                        in.readLine(); //password
                        out.println("Approved");
                    }

                    socket.close();
                } catch (IOException e) {
                    //at least we tried
                }
            }).start();
        }
    }
}
