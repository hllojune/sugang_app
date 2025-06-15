package com.example.sugang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CourseListFragment extends Fragment {

    private String listType;

    public static CourseListFragment newInstance(String type) {
        CourseListFragment fragment = new CourseListFragment();
        Bundle args = new Bundle();
        args.putString("LIST_TYPE", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            listType = getArguments().getString("LIST_TYPE");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_courses);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // --- 이 부분이 핵심적인 수정 포인트 ---

        // 1. listType에 따라 보여줄 데이터를 필터링합니다.
        ArrayList<Course> allCourses = DataSource.getSampleCourses();
        ArrayList<Course> filteredCourses = new ArrayList<>();

        if ("재이수".equals(listType)) {
            // "재이수" 타입일 경우, 이름에 "재이수"이 포함된 과목만 필터링
            for (Course course : allCourses) {
                if (course.getCourseName().contains("재이수")) {
                    filteredCourses.add(course);
                }
            }
        } else {
            // "개설강좌" 또는 다른 타입일 경우, 재이수 과목을 제외한 모든 과목을 표시
            for (Course course : allCourses) {
                if (!course.getCourseName().contains("재이수")) {
                    filteredCourses.add(course);
                }
            }
        }

        // 2. 필터링된 데이터를 어댑터에 전달합니다.
        // 어댑터 타입도 "search"로 고정하지 않고, 상황에 맞게 설정할 수 있습니다.
        CourseListAdapter adapter = new CourseListAdapter(filteredCourses, "search");
        recyclerView.setAdapter(adapter);

        return view;
    }
}