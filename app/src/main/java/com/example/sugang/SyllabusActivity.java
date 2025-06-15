package com.example.sugang;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;

public class SyllabusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_syllabus);
        toolbar.setNavigationOnClickListener(v -> finish());

        // 이전 화면에서 전달받은 Course 객체
        Course course = (Course) getIntent().getSerializableExtra("COURSE_DATA");

        // UI 요소들 찾아오기
        TextView courseName = findViewById(R.id.tv_syllabus_course_name);
        TextView courseCode = findViewById(R.id.tv_syllabus_course_code);
        TextView professor = findViewById(R.id.tv_syllabus_professor);
        TextView details = findViewById(R.id.tv_syllabus_details);
        TextView timeAndPlace = findViewById(R.id.tv_syllabus_timeAndPlace);
        TextView target = findViewById(R.id.tv_syllabus_target);


        // 전달받은 데이터로 TextView 채우기
        if (course != null) {
            courseName.setText("과목명: " + course.getCourseName());
            courseCode.setText("과목코드: " + course.getCourseCode());
            professor.setText("교수성명: " + course.getProfessor());
            details.setText("상세정보: " + course.getDetails());
            timeAndPlace.setText("시간 및 장소: " + course.getTimeAndPlace());
            target.setText("학부(과):" + course.getTarget());

        }
    }
}
