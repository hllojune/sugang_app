package com.example.sugang;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;

public class NoticeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        // 툴바(상단 바)를 찾아와 뒤로가기 버튼 기능 설정
        MaterialToolbar toolbar = findViewById(R.id.toolbar_notice);
        toolbar.setNavigationOnClickListener(v -> {
            finish(); // 현재 액티비티를 종료하고 이전 화면으로 돌아감
        });
    }
}
