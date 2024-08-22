package com.example.homecctv;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;
import java.io.IOException;

public class MjpegInputStream {
    private InputStream inputStream;

    public MjpegInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public Bitmap read() throws IOException {
        // MJPEG 스트림의 JPEG 이미지 프레임을 읽고 비트맵으로 변환합니다.
        // 실제 구현에서는 JPEG 이미지의 시작과 끝을 찾아 비트맵으로 디코딩하는 로직이 필요합니다.
        return BitmapFactory.decodeStream(inputStream);
    }
}
