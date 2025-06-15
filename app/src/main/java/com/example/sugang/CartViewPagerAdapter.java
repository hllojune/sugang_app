package com.example.sugang;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CartViewPagerAdapter extends FragmentStateAdapter {

    public CartViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // '장바구니' 모드에 맞는 프래그먼트를 반환
        // 예를 들어, 조회 기능은 동일하지만 '담기' 버튼이 활성화된 CourseListFragment
        switch (position) {
            case 0: // 학과강좌
                return CourseListFragment.newInstance("cart_search");
            // ... 다른 탭에 대한 프래그먼트 반환
            default:
                return new Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4; // 탭 개수
    }
}