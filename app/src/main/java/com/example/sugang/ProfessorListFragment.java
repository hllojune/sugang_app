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
        View view = inflater.inflate(R.layout.fragment_professor_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_professors);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // 샘플 교수 데이터
        ArrayList<String> professors = new ArrayList<>(Arrays.asList("최정열", "한경수", "임태수", "최보라", "나교수", "김경영"));

        ProfessorAdapter adapter = new ProfessorAdapter(professors);
        recyclerView.setAdapter(adapter);

        return view;
    }
}