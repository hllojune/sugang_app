package com.example.sugang;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * 간단한 텍스트 목록을 표시하기 위한 RecyclerView 어댑터입니다.
 * 학과 목록, 교수 목록 등에서 재사용할 수 있습니다.
 */
public class SimpleTextAdapter extends RecyclerView.Adapter<SimpleTextAdapter.SimpleTextViewHolder> {

    private final ArrayList<String> items;

    // 생성자에서 표시할 데이터 리스트를 받습니다.
    public SimpleTextAdapter(ArrayList<String> items) {
        this.items = items;
    }

    // ViewHolder: 목록의 각 항목을 구성하는 뷰들을 담는 그릇입니다.
    // 여기서는 안드로이드 기본 텍스트 뷰를 사용합니다.
    public static class SimpleTextViewHolder extends RecyclerView.ViewHolder {
        public final TextView textView;

        public SimpleTextViewHolder(@NonNull View itemView) {
            super(itemView);
            // 안드로이드 기본 레이아웃(simple_list_item_1)의 TextView ID는 android.R.id.text1 입니다.
            textView = itemView.findViewById(android.R.id.text1);
        }
    }

    @NonNull
    @Override
    public SimpleTextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 안드로이드가 기본으로 제공하는 간단한 한 줄 텍스트 레이아웃을 사용합니다.
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new SimpleTextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleTextViewHolder holder, int position) {
        // 현재 위치(position)에 해당하는 텍스트 데이터를 가져옵니다.
        String currentItem = items.get(position);

        // ViewHolder의 TextView에 데이터를 설정합니다.
        holder.textView.setText(currentItem);

        // 각 항목에 클릭 이벤트를 설정합니다.
        holder.itemView.setOnClickListener(v -> {
            // 1. '###'으로 시작하는 학과를 클릭했을 경우
            if (currentItem.startsWith("###")) {
                Intent intent = new Intent(v.getContext(), CourseDetailListActivity.class);
                intent.putExtra("COURSE_LIST_TYPE", "computer_science"); // 타입을 "computer_science"로 전달
                intent.putExtra("COURSE_LIST_TITLE", currentItem.replace("#","").trim());
                v.getContext().startActivity(intent);
            }
            // 2. '교양'이라는 단어가 포함된 항목을 클릭했을 경우
            else if (currentItem.contains("교양")) {
                Intent intent = new Intent(v.getContext(), CourseDetailListActivity.class);
                intent.putExtra("COURSE_LIST_TYPE", "general_essential"); // 타입을 "general_essential"로 전달
                intent.putExtra("COURSE_LIST_TITLE", currentItem);
                v.getContext().startActivity(intent);
            }
            // 3. 그 외의 경우
            else {
                Toast.makeText(v.getContext(), currentItem + " 선택됨", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        // 전체 아이템의 개수를 반환합니다.
        return items.size();
    }
}
