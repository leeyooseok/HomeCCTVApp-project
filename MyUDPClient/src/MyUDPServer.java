import java.net.DatagramPacket;
import java.net.DatagramSocket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MyUDPServer {
    public static void main(String[] args) {

        try{
            DatagramSocket ds=new DatagramSocket(7777);
            byte[] data=new byte[65536];
            DatagramPacket dp=new DatagramPacket(data,data.length);
            System.out.println("데이터 수신 준비 완료");
            while(true){
                ds.receive(dp);
                System.out.println("송신 ip : "+ dp.getAddress());
                String msg=new String(dp.getData(),"UTF-8");
                System.out.println("보내 온 내용 : "+msg);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}