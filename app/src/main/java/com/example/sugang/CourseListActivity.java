package com.example.sugang;

// CourseListActivity.java

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

// CourseListActivity.java

public class CourseListActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        bottomNav = findViewById(R.id.bottom_nav_search);

        // 초기에 '조회' 화면을 로드
        loadFragmentAndMenu("search");

        // 하단 탭 클릭 리스너 설정 (이 부분은 메뉴가 교체될 때마다 다시 설정해야 할 수 있음)
        // 여기서는 간단하게, 다른 프래그먼트를 로드하는 방식으로만 구현
    }

    // 프래그먼트와 하단 탭 메뉴를 함께 로드하는 메소드
    private void loadFragmentAndMenu(String type) {
        Fragment fragment = CourseListFragment.newInstance(type);

        // 1. 프래그먼트 교체
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();

        // --- 이 부분이 핵심 ---
        // 2. 하단 탭 메뉴 교체
        updateBottomNavigation(type);
    }

    // 하단 네비게이션 메뉴를 동적으로 업데이트하는 메소드
    private void updateBottomNavigation(String type) {
        bottomNav.getMenu().clear(); // 기존 메뉴 아이템들을 모두 지운다.

        switch (type) {
            case "search":
                bottomNav.inflateMenu(R.menu.bottom_nav_search); // 조회용 메뉴를 새로 불러온다.
                // 여기에 조회용 메뉴 아이템 클릭 리스너 설정
                break;
            case "cart":
                bottomNav.inflateMenu(R.menu.bottom_nav_cart); // 장바구니용 메뉴를 새로 불러온다.
                // 여기에 장바구니용 메뉴 아이템 클릭 리스너 설정
                break;
            case "registration":
                bottomNav.inflateMenu(R.menu.bottom_nav_registration); // 수강신청용 메뉴를 새로 물러온다.
                // 여기에 수강신청용 메뉴 아이템 클릭 리스너 설정
                break;
        }
    }
}