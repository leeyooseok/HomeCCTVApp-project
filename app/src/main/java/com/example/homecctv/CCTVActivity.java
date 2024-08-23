package com.example.homecctv;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class CCTVActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cctv);

        MyHomeCCTV cctvSurfaceView1 = findViewById(R.id.cctvSurfaceView1);
        MyHomeCCTV cctvSurfaceView2 = findViewById(R.id.cctvSurfaceView2);

        // 각 뷰에 다른 URL 설정
        cctvSurfaceView1.setStreamUrl("http://220.233.144.165:8888/mjpg/video.mjpg");
        cctvSurfaceView2.setStreamUrl("http://63.142.183.154:6103/mjpg/video.mjpg");
        //cctvSurfaceView2.setStreamUrl("http://192.168.0.109:8000/camera/mjpeg");

        Button buttonUp = findViewById(R.id.buttonUp);
        Button buttonDown = findViewById(R.id.buttonDown);
        Button buttonLeft = findViewById(R.id.buttonLeft);
        Button buttonRight = findViewById(R.id.buttonRight);

        // 첫 번째 CCTV 클릭 시
        cctvSurfaceView1.setOnClickListener(v -> openCCTVControlActivity("http://220.233.144.165:8888/mjpg/video.mjpg"));

        // 두 번째 CCTV 클릭 시
        cctvSurfaceView2.setOnClickListener(v -> openCCTVControlActivity("http://87.101.127.24/mjpg/video.mjpg"));
    }

    private void openCCTVControlActivity(String url) {
        Intent intent = new Intent(this, CCTVControlActivity.class);
        intent.putExtra("streamUrl", url);
        startActivity(intent);
    }
}


