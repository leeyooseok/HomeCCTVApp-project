import com.fazecast.jSerialComm.SerialPort;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MySerialClient2 {
    public static void main(String[] args) {
        SerialPort[] availablePorts=SerialPort.getCommPorts();

        SerialPort mySerialPort=availablePorts[2];
        int baudRate=9600;
        int datalBits=8;
        int stopBits=SerialPort.ONE_STOP_BIT;
        int parity=SerialPort.NO_PARITY;
        mySerialPort.setComPortParameters(baudRate,datalBits,stopBits,parity);
        mySerialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING,
                1000,0);
        mySerialPort.openPort();
        if(mySerialPort.isOpen()){
            System.out.println("opened!");
        }else{
            System.out.println("not opened");
        }
        //데이터 수신
//        try{
//            while(true) {
//                byte[] readBuffer = new byte[100];
//                int numRead = mySerialPort.readBytes(readBuffer, readBuffer.length);
//                System.out.println("Read " + numRead + "byte -");
//                String msg = new String(readBuffer, "UTF-8");
//                System.out.println("Received->" + msg);
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
        //데이터 전송
        try{
            while(true){
                String msg= new String("hello to Arduino from Java\r\n");
                mySerialPort.writeBytes(msg.getBytes(),msg.getBytes().length);
                Thread.sleep(1000);
            }
        }catch(Exception e){
            e.printStackTrace();
        }


        byte[] writeByte=new byte[100];
        writeByte[0]=65;
        int byteTxed=0;
        byteTxed=mySerialPort.writeBytes(writeByte,1);
        System.out.println("Bytes Transmitted->"+byteTxed);

        mySerialPort.closePort();
    }
}
