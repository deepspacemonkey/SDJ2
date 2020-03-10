import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        final String HOST = "localhost";
        final int PORT = 6969;

        Scanner input = new Scanner(System.in);

        Socket clientSocket = new Socket(HOST, PORT);

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        out.println(input.nextLine());
        String response = in.readLine();
        System.out.println(response);

        if (response.equals("Username?")) {
            out.println(input.nextLine()); //username
            System.out.println(in.readLine());
            out.println(input.nextLine()); //password
            System.out.println(in.readLine());
        }

        clientSocket.close();
    }
}
