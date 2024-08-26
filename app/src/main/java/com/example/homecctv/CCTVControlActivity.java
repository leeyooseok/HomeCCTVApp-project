package com.example.homecctv;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CCTVControlActivity extends AppCompatActivity {

    private MyHomeCCTV cctvSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cctv_control);

        // 뒤로가기 버튼 설정
        Button buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(v -> finish()); // 뒤로가기 버튼 클릭 시 현재 액티비티 종료

        // CCTV 서페이스 뷰 설정
        cctvSurfaceView = findViewById(R.id.cctvSurfaceView);

        // 이전 액티비티에서 전달된 URL을 받습니다.
        String streamUrl = getIntent().getStringExtra("streamUrl");
        cctvSurfaceView.setStreamUrl(streamUrl);

        Button buttonUp = findViewById(R.id.buttonUp);
        Button buttonDown = findViewById(R.id.buttonDown);
        Button buttonLeft = findViewById(R.id.buttonLeft);
        Button buttonRight = findViewById(R.id.buttonRight);

        // CCTV 회전 버튼 설정
        buttonUp.setOnClickListener(v -> sendCCTVCommand("up"));
        buttonDown.setOnClickListener(v -> sendCCTVCommand("down"));
        buttonLeft.setOnClickListener(v -> sendCCTVCommand("left"));
        buttonRight.setOnClickListener(v -> sendCCTVCommand("right"));
    }

    private void sendCCTVCommand(String direction) {
        // CCTV 제어 명령 처리 (이 부분은 CCTV의 API에 맞춰서 구현합니다.)
    }
}

