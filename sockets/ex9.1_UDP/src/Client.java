import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final int port = 6969;
        InetAddress IP = InetAddress.getByName("localhost");

        DatagramSocket clientSocket = new DatagramSocket();

        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        sendData = "hi".getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IP, port);
        clientSocket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);

        ObjectInputStream iStream = new ObjectInputStream(new ByteArrayInputStream(receiveData));
        Message msg = (Message) iStream.readObject();
        System.out.println("Server>" + msg);

        clientSocket.close();
    }
}