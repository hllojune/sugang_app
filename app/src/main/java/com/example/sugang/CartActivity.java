package com.example.sugang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // 1. 뷰 초기화
        MaterialToolbar toolbar = findViewById(R.id.toolbar_cart);
        TabLayout tabLayout = findViewById(R.id.tab_layout_cart_filter);
        ViewPager2 viewPager = findViewById(R.id.view_pager_cart_content);
        SearchView searchView = findViewById(R.id.search_view);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation_cart);

        // 2. 툴바 설정 (뒤로가기 버튼)
        toolbar.setNavigationOnClickListener(v -> finish());

        // 3. ViewPager2에 카트용 어댑터 설정
        CartViewPagerAdapter pagerAdapter = new CartViewPagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);

        // 4. TabLayout과 ViewPager2 연결
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("학과강좌");
                    break;
                case 1:
                    tab.setText("개설강좌");
                    break;
                case 2:
                    tab.setText("교수강좌");
                    break;
                case 3:
                    tab.setText("재이수");
                    break;
            }
        }).attach();

        // 5. 탭 선택에 따른 SearchView 표시/숨김 로직
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 1 || tab.getPosition() == 2) {
                    searchView.setVisibility(View.VISIBLE);
                } else {
                    searchView.setVisibility(View.GONE);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

// 현재 화면에 해당하는 메뉴 아이템을 선택된 상태로 만듦
        bottomNav.setSelectedItemId(R.id.nav_cart_search);

        bottomNav.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.nav_cart_search) {
                // '강좌조회 신청' 클릭 시 SearchActivity로 이동
                // ...
            } else if (itemId == R.id.nav_cart_direct_add) {
                // '강좌코드 직접입력' 클릭 시 DirectAddActivity로 이동
                // ...
            } else if (itemId == R.id.nav_cart_manage) {
                // '장바구니 조회,삭제' 클릭 시 CartManageActivity로 이동
                Intent intent = new Intent(CartActivity.this, CartManageActivity.class);
                startActivity(intent);
                return true;
            }
            return false;
        });


    }
}