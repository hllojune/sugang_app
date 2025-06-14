package com.example.sugang;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class SearchActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // 0. 툴바(상단 바) 설정
        MaterialToolbar toolbar = findViewById(R.id.toolbar_search);
        // 뒤로가기 버튼 클릭 이벤트 처리
        toolbar.setNavigationOnClickListener(v -> {
            finish(); // 현재 액티비티를 종료하고 이전 화면으로 돌아감
        });

        tabLayout = findViewById(R.id.tab_layout_top_filter);
        viewPager = findViewById(R.id.view_pager_content);
        bottomNavigationView = findViewById(R.id.bottom_navigation_main);

        // 1. ViewPager2에 어댑터 설정
        SearchViewPagerAdapter pagerAdapter = new SearchViewPagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);

        // 2. TabLayout과 ViewPager2 연결
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0: tab.setText("학과강좌"); break;
                case 1: tab.setText("개설강좌"); break;
                case 2: tab.setText("교수강좌"); break;
                case 3: tab.setText("재이수"); break;
            }
        }).attach();

        // 3. 하단 네비게이션 탭 클릭 이벤트 처리

        // 1) BottomNavigationView를 ID로 찾아옵니다.
        bottomNavigationView = findViewById(R.id.bottom_navigation_main);

        // 2) 현재 화면에 해당하는 메뉴 아이템을 선택된 상태로 만듭니다.
        bottomNavigationView.setSelectedItemId(R.id.bottom_nav_search);

        // 3) 각 메뉴 아이템에 클릭 리스너를 설정합니다.
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.bottom_nav_search) {
                // 현재 화면이므로 아무 동작도 하지 않음
                return true;
            } else if (itemId == R.id.bottom_nav_cart) {
                // '장바구니' 탭 클릭 시 CartActivity로 이동
                // Intent intent = new Intent(SearchActivity.this, CartActivity.class);
                // startActivity(intent);
                return true;
            } else if (itemId == R.id.bottom_nav_registration_list) {
                // '수강신청 내역' 탭 클릭 시 RegistrationListActivity로 이동
                // Intent intent = new Intent(SearchActivity.this, RegistrationListActivity.class);
                // startActivity(intent);
                return true;
            }

            return false;
        });
    }
}