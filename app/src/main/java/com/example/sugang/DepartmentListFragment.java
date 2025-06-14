package com.example.sugang;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DepartmentListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_department_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_departments);

        // 여기에 RecyclerView에 학과 목록 데이터를 연결하는 코드를 작성합니다.
        // 예: ArrayList<String> departments = ...
        //    DepartmentAdapter adapter = new DepartmentAdapter(departments);
        //    recyclerView.setAdapter(adapter);

        return view;
    }
}