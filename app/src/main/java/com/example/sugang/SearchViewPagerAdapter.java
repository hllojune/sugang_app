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
        switch (position) {
            case 0:
                return new DepartmentListFragment();    // '학과강좌' 탭
            case 1:
                return new AllCoursesFragment();        // '개설강좌' 탭
            case 2:
                return new ProfessorListFragment();     // '교수강좌' 탭
            case 3:
                return new RetakeCourseListFragment();      // '재이수' 탭
            default:
                return new Fragment(); // 기본값
        }
    }


    @Override
    public int getItemCount() {
        return 4; // 상단 탭의 총 개수
    }
}