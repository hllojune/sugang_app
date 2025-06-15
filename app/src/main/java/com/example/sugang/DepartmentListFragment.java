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
import java.util.Arrays;

public class DepartmentListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 1. 프래그먼트의 레이아웃을 불러옴
        View view = inflater.inflate(R.layout.fragment_department_list, container, false);

        // 2. RecyclerView 초기화
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_departments);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // 3. 샘플 학과 데이터 생성
        ArrayList<String> departments = new ArrayList<>(Arrays.asList("신학대학", "인문대학", "사회과학대학", "글로벌경영기술대학", "사범대학", "IT공과대학", "예술대학", "융합대학"));

        // 4. 어댑터 설정 (여기서는 간단한 텍스트 어댑터 사용)
        SimpleTextAdapter adapter = new SimpleTextAdapter(departments);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
