package com.example.sugang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AllCoursesFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simple_list, container, false); // 재사용 가능한 레이아웃
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_simple);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<String> courseStrings = new ArrayList<>();
        for (Course course : DataSource.getSampleCourses()) {
            courseStrings.add(course.getCourseCode() + " " + course.getCourseName());
        }

        SimpleTextAdapter adapter = new SimpleTextAdapter(courseStrings);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
