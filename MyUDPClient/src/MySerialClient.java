import com.fazecast.jSerialComm.SerialPort;

public class MySerialClient {
    public static void main(String[] args) {
        SerialPort[] ports=SerialPort.getCommPorts();
        for(SerialPort port:ports){
            System.out.println(port.getSystemPortName());
        }
    }
}
