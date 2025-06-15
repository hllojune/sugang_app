package com.example.sugang;

// ProfessorAdapter.java
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ProfessorAdapter extends RecyclerView.Adapter<ProfessorAdapter.ProfessorViewHolder> {

    private ArrayList<String> professorList;

    public ProfessorAdapter(ArrayList<String> professorList) {
        this.professorList = professorList;
    }

    @NonNull
    @Override
    public ProfessorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ProfessorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfessorViewHolder holder, int position) {
        String professorName = professorList.get(position);
        holder.professorNameTextView.setText(professorName);
        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), professorName + " 교수님 선택됨", Toast.LENGTH_SHORT).show();
            // TODO: 해당 교수의 강의 목록을 보여주는 화면으로 이동하는 로직 구현
        });
    }

    @Override
    public int getItemCount() {
        return professorList.size();
    }

    public static class ProfessorViewHolder extends RecyclerView.ViewHolder {
        TextView professorNameTextView;
        public ProfessorViewHolder(@NonNull View itemView) {
            super(itemView);
            professorNameTextView = itemView.findViewById(android.R.id.text1);
        }
    }
}