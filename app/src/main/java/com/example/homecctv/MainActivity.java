package com.example.homecctv;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button cctvButton;
    private Button lightControlButton;
    private Button temperatureCheckButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 각 버튼에 대한 참조 초기화
        cctvButton = findViewById(R.id.cctvControlButton);
        lightControlButton = findViewById(R.id.lightControlButton);
        temperatureCheckButton = findViewById(R.id.temperatureCheckButton);

        // CCTV 제어 화면으로 이동
        cctvButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CCTVActivity.class);
            startActivity(intent);
        });

//        // 전등 제어 화면으로 이동
//        lightControlButton.setOnClickListener(v -> {
//            Intent intent = new Intent(MainActivity.this, LightControlActivity.class);
//            startActivity(intent);
//        });
//
//        // 집안 온도 확인 화면으로 이동
//        temperatureCheckButton.setOnClickListener(v -> {
//            Intent intent = new Intent(MainActivity.this, TemperatureCheckActivity.class);
//            startActivity(intent);
//        });
    }
}
