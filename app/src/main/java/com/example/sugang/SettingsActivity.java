package com.example.sugang;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // 1. 툴바(상단 바) 설정
        MaterialToolbar toolbar = findViewById(R.id.toolbar_settings);
        // 뒤로가기 버튼 클릭 이벤트 처리
        toolbar.setNavigationOnClickListener(v -> {
            finish(); // 현재 액티비티를 종료하고 이전 화면으로 돌아감
        });

        // 2. 로그아웃 메뉴 설정
        LinearLayout logoutButton = findViewById(R.id.setting_logout);
        logoutButton.setOnClickListener(v -> {
            // 여기에 로그아웃 관련 로직을 구현합니다.
            // 예를 들어 확인 다이얼로그를 띄우거나, 바로 로그인 화면으로 이동할 수 있습니다.
            Toast.makeText(this, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show();
            // Intent intent = new Intent(this, LoginActivity.class);
            // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            // startActivity(intent);
        });

        // 3. 세션 시간 SeekBar 설정
        SeekBar sessionSeekBar = findViewById(R.id.seekbar_session);
        TextView sessionTimeText = findViewById(R.id.tv_session_time);

        // SeekBar의 값이 변경될 때마다 이벤트를 처리하는 리스너 설정
        sessionSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // SeekBar를 드래그하는 동안 실시간으로 텍스트를 업데이트
                sessionTimeText.setText(progress + " 분");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // 사용자가 터치를 시작했을 때 (필요시 코드 추가)
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // 사용자가 터치를 멈췄을 때 최종 값을 Toast 메시지로 보여줌
                Toast.makeText(SettingsActivity.this, "세션 시간이 " + seekBar.getProgress() + "분으로 설정되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}