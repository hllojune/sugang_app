package com.example.sugang;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.MaterialToolbar;
import java.util.ArrayList;
import java.util.Arrays;

public class SubCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category); // 아래에서 만들 레이아웃 파일

        // 1. Intent로부터 어떤 종류의 카테고리를 보여줄지 정보를 받음
        String categoryType = getIntent().getStringExtra("CATEGORY_TYPE");
        String categoryTitle = getIntent().getStringExtra("CATEGORY_TITLE");

        // 2. 툴바 설정
        MaterialToolbar toolbar = findViewById(R.id.toolbar_sub_category);
        toolbar.setTitle(categoryTitle); // 전달받은 제목으로 설정
        toolbar.setNavigationOnClickListener(v -> finish()); // 뒤로가기

        // 3. RecyclerView 설정
        RecyclerView recyclerView = findViewById(R.id.recycler_view_sub_category);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 4. 카테고리 타입에 따라 다른 데이터를 가져와 어댑터에 연결
        ArrayList<String> subCategories = getSubCategories(categoryType);
        SimpleTextAdapter adapter = new SimpleTextAdapter(subCategories);
        recyclerView.setAdapter(adapter);
    }

    // 카테고리 타입에 따라 다른 목록을 반환하는 메소드
    private ArrayList<String> getSubCategories(String type) {
        if ("general_course".equals(type)) {
            return new ArrayList<>(Arrays.asList(
                    "교양 1.교양필수",
                    "교양 2.교양선택(채플)",
                    "교양 2.교양선택-제1영역(기독교인성교육)",
                    "교양 2.교양선택-제2영역(세계시민교육)",
                    "고양 2.교양선택-제3영역(소통·협력교육)",
                    "교양 2.교양선택-제4영역(창의·융합교육)",
                    "교양 3.온라인학점교류(KCU)",
                    "교양 4.전공탐색입문(자율전공학부)"
                    // ... 등등
            ));
        }
        else if ("it_college".equals(type)) {
            return new ArrayList<>(Arrays.asList(
                    "### 컴퓨터공학과",
                    "#정보통신공학과",
                    "#미디어소프트웨어학과",
                    "#도시디자인정보공학과"
            ));
        }
        return new ArrayList<>(); // 기본값
    }


}
