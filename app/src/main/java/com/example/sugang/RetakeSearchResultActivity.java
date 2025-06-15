package com.example.sugang;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.MaterialToolbar;
import java.util.ArrayList;

public class RetakeSearchResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retake_search_result);

        // 이전 화면에서 전달받은 과목명으로 툴바 제목 설정
        String courseName = getIntent().getStringExtra("COURSE_NAME");
        MaterialToolbar toolbar = findViewById(R.id.toolbar_retake_result);
        toolbar.setTitle(courseName + " 재이수");
        toolbar.setNavigationOnClickListener(v -> finish());

        RecyclerView recyclerView = findViewById(R.id.recycler_view_retake_result);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 재수강 가능한 과목 샘플 데이터 생성
        ArrayList<String> availableCourses = new ArrayList<>();
        availableCourses.add("35123001 기초디자인");
        availableCourses.add("35123002 기초디자인");

        // 간단한 텍스트 목록 어댑터 재사용
        SimpleTextAdapter adapter = new SimpleTextAdapter(availableCourses);
        recyclerView.setAdapter(adapter);
    }
}
