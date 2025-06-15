package com.example.sugang; // 본인의 패키지 이름에 맞게 수정

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.MaterialToolbar;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CourseDetailListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail_list); // 툴바와 RecyclerView가 있는 레이아웃

        String title = getIntent().getStringExtra("COURSE_LIST_TITLE");
        String type = getIntent().getStringExtra("COURSE_LIST_TYPE"); // 타입을 받아옵니다.

        MaterialToolbar toolbar = findViewById(R.id.toolbar_course_detail);
        toolbar.setTitle(title);
        toolbar.setNavigationOnClickListener(v -> finish());

        RecyclerView recyclerView = findViewById(R.id.recycler_view_course_detail);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // --- 이 부분이 수정됩니다 ---
        // 1. 전체 강의 목록을 가져옵니다.
        ArrayList<Course> allCourses = DataSource.getSampleCourses();
        ArrayList<Course> filteredCourses = new ArrayList<>();

        // 2. 전달받은 타입에 따라 강의 목록을 필터링합니다.
        if ("general_essential".equals(type)) {
            // "교양필수" 타입일 경우, 예시 데이터 필터링
            for(Course course : allCourses) {
                if(course.getCourseName().equals("사회봉사") || course.getCourseName().equals("기초글쓰기")) {
                    filteredCourses.add(course);
                }
            }
        } else if ("computer_science".equals(type)) {
            // "컴퓨터공학과" 타입일 경우, 해당 학과 과목 필터링
            for(Course course : allCourses) {
                if(course.getTarget().contains("컴퓨터공학과")) {
                    filteredCourses.add(course);
                }
            }
        } else {
            // 기본적으로는 모든 강의를 보여줌 (또는 빈 목록)
            filteredCourses.addAll(allCourses);
        }

        // 3. 필터링된 목록을 어댑터에 전달하여 화면에 표시합니다.
        CourseSearchAdapter adapter = new CourseSearchAdapter(filteredCourses);
        recyclerView.setAdapter(adapter);
    }
}
