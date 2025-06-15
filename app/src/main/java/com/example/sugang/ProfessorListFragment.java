package com.example.sugang;

// ProfessorListFragment.java
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

public class ProfessorListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simple_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_simple);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // 샘플 교수 데이터 (실제로는 DataSource에서 가져와야 함)
        ArrayList<String> professors = new ArrayList<>();
        professors.add("# 김교수 인문대학 국어국문학과");
        // ... 다른 교수 추가

        SimpleTextAdapter adapter = new SimpleTextAdapter(professors);
        recyclerView.setAdapter(adapter);

        return view;
    }

}