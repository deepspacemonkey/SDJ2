import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.GregorianCalendar;

public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket serverSocket = new DatagramSocket(6969);
        while (true) {
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            serverSocket.receive(receivePacket);

            String sentence = new String(receivePacket.getData()).trim();
            System.out.println(sentence);

            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();

            byte[] sendData = new byte[1024];
            Message msg = new Message("me", "message", false);
            ByteArrayOutputStream bStream = new ByteArrayOutputStream();
            ObjectOutput oo = new ObjectOutputStream(bStream);
            oo.writeObject(msg);
            oo.close();
            sendData = bStream.toByteArray();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
    }
}
