package com.example.sugang; // 본인의 패키지 이름에 맞게 수정

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
        View view = inflater.inflate(R.layout.fragment_department_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_departments);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // 이미지와 동일한 샘플 데이터 생성
        ArrayList<String> categories = new ArrayList<>(Arrays.asList(
                "#",
                "#[교양강좌]",
                "## IT공과대학",
                "전공/영역",
                "신학대학",
                "인문대학",
                "사회과학대학",
                "글로벌경영기술대학",
                "사범대학",
                "IT공과대학",
                "예술대학",
                "융합대학"
        ));

        // 새로 만든 CategoryAdapter를 사용
        CategoryAdapter adapter = new CategoryAdapter(categories);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
