package com.example.homecctv;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyHomeCCTV extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    Thread threadSView;
    boolean threadRunning = true;
    private String streamUrl;

    public MyHomeCCTV(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);
    }

    public void setStreamUrl(String url) {
        this.streamUrl = url;
        if (threadSView == null || !threadSView.isAlive()) {
            threadSView = new Thread(this);
            threadSView.start();
        }
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        if (threadSView == null || !threadSView.isAlive()) {
            threadSView = new Thread(this);
            threadSView.start();
        }
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        threadRunning = false;
        if (threadSView != null) {
            try {
                threadSView.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        final int maxImgSize = 10000000;
        byte[] arr = new byte[maxImgSize];
        try {
            URL url = new URL(streamUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            InputStream in = con.getInputStream();
            while (threadRunning) {
                int i = 0;
                for (; i < 2000; i++) {
                    int b = in.read();
                    if (b == 0xff) {
                        int b2 = in.read();
                        if (b2 == 0xd8)
                            break;
                    }
                }
                if (i > 999) {
                    Log.e("MyHomeCCTV", "Bad head!");
                    continue;
                }
                arr[0] = (byte) 0xff;
                arr[1] = (byte) 0xd8;
                i = 2;
                for (; i < maxImgSize; i++) {
                    int b = in.read();
                    arr[i] = (byte) b;
                    if (b == 0xff) {
                        i++;
                        int b2 = in.read();
                        arr[i] = (byte) b2;
                        if (b2 == 0xd9) {
                            break;
                        }
                    }
                }
                i++;
                int nBytes = i;
                Log.e("MyHomeCCTV", "got an image, " + nBytes + " bytes!");

                Bitmap bitmap = BitmapFactory.decodeByteArray(arr, 0, nBytes);
                bitmap = Bitmap.createScaledBitmap(bitmap, getWidth(), getHeight(), false);

                SurfaceHolder holder = getHolder();
                Canvas canvas = null;
                canvas = holder.lockCanvas();
                if (canvas != null) {
                    canvas.drawColor(Color.TRANSPARENT);
                    canvas.drawBitmap(bitmap, 0, 0, null);
                    holder.unlockCanvasAndPost(canvas);
                }
            }
        } catch (Exception e) {
            Log.e("MyHomeCCTV", "Error:" + e.toString());
        }
    }
}
