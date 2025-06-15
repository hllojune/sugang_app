package com.example.sugang;

// SearchViewPagerAdapter.java
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class SearchViewPagerAdapter extends FragmentStateAdapter {

    public SearchViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // 각 탭의 위치(position)에 따라 다른 프래그먼트를 반환
        switch (position) {
            case 0:
                return new DepartmentListFragment();    // '학과강좌' 탭
            case 1:
                return CourseListFragment.newInstance("개설강좌"); // '개설강좌' 탭
            case 2:
                return new ProfessorListFragment();     // '교수강좌' 탭
            case 3:
                return new RetakeCourseListFragment();  // '재이수' 탭 (수정됨)
            default:
                return new DepartmentListFragment(); // 기본값
        }
    }

    @Override
    public int getItemCount() {
        return 4; // 상단 탭의 총 개수
    }
}