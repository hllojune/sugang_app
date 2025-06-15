package com.example.sugang;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputEditText;
import java.util.Optional;

public class DirectAddActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direct_add);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_direct_add);
        toolbar.setNavigationOnClickListener(v -> finish());

        TextInputEditText etCourseCode = findViewById(R.id.et_course_code);
        Button btnAddToCart = findViewById(R.id.btn_add_to_cart);

        btnAddToCart.setOnClickListener(v -> {
            String courseCode = etCourseCode.getText().toString().trim();
            if (courseCode.isEmpty()) {
                Toast.makeText(this, "과목코드를 입력하세요.", Toast.LENGTH_SHORT).show();
                return;
            }

            // DataSource에서 해당 과목코드의 강의를 찾음
            Optional<Course> foundCourse = DataSource.getSampleCourses().stream()
                    .filter(c -> c.getCourseCode().equals(courseCode))
                    .findFirst();

            if (foundCourse.isPresent()) {
                // 과목을 찾았으면 CartManager에 추가
                CartManager.cartItems.add(foundCourse.get());
                Toast.makeText(this, foundCourse.get().getCourseName() + " 담기 완료", Toast.LENGTH_SHORT).show();
                finish(); // 추가 후 화면 닫기
            } else {
                Toast.makeText(this, "해당 과목코드를 찾을 수 없습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}