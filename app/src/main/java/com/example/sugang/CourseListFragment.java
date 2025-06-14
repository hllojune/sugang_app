package com.example.sugang;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

// CourseListFragment.java

public class CourseListFragment extends Fragment {

    private String fragmentType;

    // 프래그먼트를 생성할 때 타입을 전달받는 메소드
    public static CourseListFragment newInstance(String type) {
        CourseListFragment fragment = new CourseListFragment();
        Bundle args = new Bundle();
        args.putString("type", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            fragmentType = getArguments().getString("type");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_courses);

        // 1. fragmentType에 따라 다른 데이터를 가져온다.
        // 예: "search" -> 전체 강의 목록, "cart" -> 장바구니 목록
        ArrayList<Course> courseList = getCoursesByType(fragmentType);

        // 2. 어댑터를 생성할 때 fragmentType을 함께 전달한다.
        CourseListAdapter adapter = new CourseListAdapter(courseList, fragmentType);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    // ... (타입에 따라 다른 데이터를 가져오는 메소드 예시) ...
    private ArrayList<Course> getCoursesByType(String type) {
        // ...
        return new ArrayList<>();
    }
}