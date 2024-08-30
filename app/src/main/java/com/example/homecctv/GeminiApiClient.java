//package com.myapplication;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.speech.RecognizerIntent;
//import android.util.Log;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//import java.util.ArrayList;
//import java.util.Locale;
//
//public class voice extends Activity {
//
//    private static final int VOICE_REQUEST_CODE = 101;
//    private TextView voiceCommandResult;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.voice);
//
//        voiceCommandResult = findViewById(R.id.voiceCommandResult);
//        Button startVoiceRecognitionButton = findViewById(R.id.startVoiceRecognitionButton);
//
//        startVoiceRecognitionButton.setOnClickListener(v -> startVoiceRecognition());
//    }
//
//    private void startVoiceRecognition() {
//        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
//        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
//        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.KOREA);
//        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "명령어를 말하세요");
//
//        try {
//            startActivityForResult(intent, VOICE_REQUEST_CODE);
//        } catch (Exception e) {
//            Toast.makeText(this, "음성 인식에 실패했습니다.", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == VOICE_REQUEST_CODE && resultCode == RESULT_OK) {
//            ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
//            if (matches != null && !matches.isEmpty()) {
//                String command = matches.get(0);
//                voiceCommandResult.setText("인식된 명령어: " + command);
//                handleVoiceCommand(command);
//            } else {
//                voiceCommandResult.setText("음성 인식 결과가 없습니다.");
//            }
//        }
//    }
//
//    private void handleVoiceCommand(String command) {
//        String btCommand;
//        switch (command) {
//            case "위로":
//                btCommand = "U";
//                break;
//            case "아래로":
//                btCommand = "D";
//                break;
//            case "왼쪽":
//                btCommand = "L";
//                break;
//            case "오른쪽":
//                btCommand = "R";
//                break;
//            default:
//                Toast.makeText(this, "알 수 없는 명령: " + command, Toast.LENGTH_SHORT).show();
//                return;
//        }
//        Log.d("UDPClient", "Send: " + btCommand);
//        // 보낼 메시지(btCommand) 추가 코드
//    }
//}