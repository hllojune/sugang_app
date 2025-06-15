package com.example.sugang;

// RetakeCourseListFragment.java
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

public class RetakeCourseListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_retake_course_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_retake_courses);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // 전체 강의 데이터에서 '재이수' 키워드가 포함된 과목만 필터링
        ArrayList<Course> allCourses = DataSource.getSampleCourses();
        ArrayList<Course> retakeCourses = (ArrayList<Course>) allCourses.stream()
                .filter(course -> course.getCourseName().contains("재이수"))
                .collect(Collectors.toList());

        // CourseListAdapter를 재사용하여 데이터를 RecyclerView에 연결
        // "search" 타입으로 설정하여 '담기' 버튼 등이 표시되도록 함
        CourseListAdapter adapter = new CourseListAdapter(retakeCourses, "search");
        recyclerView.setAdapter(adapter);

        return view;
    }
}