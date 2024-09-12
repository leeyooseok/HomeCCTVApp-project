
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class MyUDPClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("보낼 메시지 입력 : ");
        String msg = scanner.nextLine();
        try {
            DatagramSocket ds=new DatagramSocket();
            InetAddress ia=InetAddress.getByName("192.168.0.109");
            DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.getBytes().length, ia, 7777);
            ds.send(dp);
            ds.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
