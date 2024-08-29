package com.example.homecctv;

import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import android.Manifest;

import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;

public class CCTVControlActivity extends AppCompatActivity {

    private MyHomeCCTV cctvSurfaceView;
//    private BluetoothController bluetoothController;
//    private static final String DEVICE_ADDRESS = "98:DA:60:07:6C:5B"; // 아두이노의 블루투스 주소
    private static final String SERVER_IP = "192.168.0.109"; // 여기에 서버의 IP 주소 입력
    private static final int SERVER_PORT = 7777; // 서버의 포트 번호

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cctv_control);


        // 나머지 초기화 코드

        // 뒤로가기 버튼 설정
        Button buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(v -> openCCTVlActivity("url"));

        // CCTV 서페이스 뷰 설정
        cctvSurfaceView = findViewById(R.id.cctvSurfaceView);

        // 이전 액티비티에서 전달된 URL을 받습니다.
        String streamUrl = getIntent().getStringExtra("streamUrl");
        cctvSurfaceView.setStreamUrl(streamUrl);

//        bluetoothController = new BluetoothController(this);
//
//        // 블루투스 디바이스 연결 시도
//        if (!bluetoothController.connectToDevice(DEVICE_ADDRESS)) {
//            return; // 연결 실패 시 더 이상 진행하지 않음
//        }

        Button buttonUp = findViewById(R.id.buttonUp);
        Button buttonDown = findViewById(R.id.buttonDown);
        Button buttonLeft = findViewById(R.id.buttonLeft);
        Button buttonRight = findViewById(R.id.buttonRight);

        // CCTV 회전 버튼 설정
//        buttonUp.setOnClickListener(v -> bluetoothController.sendCommand("U"));
//        buttonDown.setOnClickListener(v -> bluetoothController.sendCommand("D"));
//        buttonLeft.setOnClickListener(v -> bluetoothController.sendCommand("L"));
//        buttonRight.setOnClickListener(v -> bluetoothController.sendCommand("R"));
        // 버튼 클릭 시 UDP 패킷으로 명령 전송
        buttonUp.setOnClickListener(v -> sendCommand("U"));
        buttonDown.setOnClickListener(v -> sendCommand("D"));
        buttonLeft.setOnClickListener(v -> sendCommand("L"));
        buttonRight.setOnClickListener(v -> sendCommand("R"));
    }

    public void sendCommand(String msgText) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    DatagramSocket ds = new DatagramSocket();
                    InetAddress ia=InetAddress.getByName(SERVER_IP);
                    byte[] data = msgText.getBytes();
                    DatagramPacket dp = new DatagramPacket(data,data.length,ia,SERVER_PORT);
                    ds.send(dp);
                    ds.close();
                }catch (Exception e){
                    Log.d("UDPClient","Error: " + e.getMessage());
                }
            }
        }).start();
    }


    private void openCCTVlActivity(String url) {
        Intent intent = new Intent(this, CCTVActivity.class);
        intent.putExtra("streamUrl", url);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        // 새 액티비티 시작
        startActivity(intent);
        finish(); // 현재 액티비티 종료
    }
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        bluetoothController.closeConnection();
//    }
}

