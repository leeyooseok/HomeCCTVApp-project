package com.example.homecctv;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Executors;

public class CCTVActivity extends AppCompatActivity {

    private SurfaceView cctvSurfaceView1, cctvSurfaceView2;
    private Button buttonUp, buttonDown, buttonLeft, buttonRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cctv);

        cctvSurfaceView1 = findViewById(R.id.cctvSurfaceView1);
        cctvSurfaceView2 = findViewById(R.id.cctvSurfaceView2);
        buttonUp = findViewById(R.id.buttonUp);
        buttonDown = findViewById(R.id.buttonDown);
        buttonLeft = findViewById(R.id.buttonLeft);
        buttonRight = findViewById(R.id.buttonRight);

        // CCTV 화면 스트리밍 (MJPEG 이미지 수신)
        startStreaming();

        // CCTV 회전 버튼 설정
        buttonUp.setOnClickListener(v -> sendCCTVCommand("up"));
        buttonDown.setOnClickListener(v -> sendCCTVCommand("down"));
        buttonLeft.setOnClickListener(v -> sendCCTVCommand("left"));
        buttonRight.setOnClickListener(v -> sendCCTVCommand("right"));
    }

    private void sendCCTVCommand(String direction) {
        // 동일한 sendCCTVCommand 메서드를 사용
    }

    private void startStreaming() {
        String url1 = "http://220.233.144.165:8888/mjpg/video.mjpg";
        String url2 = "http://212.67.236.61/mjpg/video.mjpg";

        SurfaceHolder holder1 = cctvSurfaceView1.getHolder();
        SurfaceHolder holder2 = cctvSurfaceView2.getHolder();

        holder1.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                Surface surface = holder.getSurface();
                startMJPEGStream(holder, url1);
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {}
        });

        holder2.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                Surface surface = holder.getSurface();
                startMJPEGStream(holder, url2);
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {}
        });
    }

    private void startMJPEGStream(SurfaceHolder holder, String url) {
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                URL streamUrl = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) streamUrl.openConnection();
                connection.setDoInput(true);
                connection.connect();

                InputStream inputStream = connection.getInputStream();
                MjpegInputStream mjpegInputStream = new MjpegInputStream(inputStream);

                while (true) {
                    Bitmap bitmap = mjpegInputStream.read();
                    if (bitmap != null) {
                        runOnUiThread(() -> drawBitmapOnSurface(holder, bitmap));
                    }
                }
            } catch (Exception e) {
                Log.e("CCTVControl", "Error streaming CCTV", e);
            }
        });
    }

    private void drawBitmapOnSurface(SurfaceHolder holder, Bitmap bitmap) {
        Canvas canvas = null;
        try {
            canvas = holder.lockCanvas();
            if (canvas != null) {
                canvas.drawBitmap(bitmap, 0, 0, null);
            }
        } finally {
            if (canvas != null) {
                holder.unlockCanvasAndPost(canvas);
            }
        }
    }
}
