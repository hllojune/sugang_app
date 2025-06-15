package com.example.sugang;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private final ArrayList<String> categoryList;

    public CategoryAdapter(ArrayList<String> categoryList) {
        this.categoryList = categoryList;
    }

    // ViewHolder: list_item_category.xml의 뷰들을 담는 그릇
    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        public TextView categoryTitle;
        public View itemView; // 배경색 변경을 위해 itemView 전체를 참조

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            categoryTitle = itemView.findViewById(R.id.tv_category_title);
        }
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        String currentCategory = categoryList.get(position);
        holder.categoryTitle.setText(currentCategory);

        // --- 이 부분이 핵심: 섹션 헤더 디자인 변경 ---
        if (currentCategory.startsWith("#")) {
            // #으로 시작하면 회색 배경과 진한 글씨로 설정
            holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.background_light_grey));
            holder.categoryTitle.setTextColor(Color.BLACK);
            holder.categoryTitle.setTextSize(14f); // 텍스트 크기 조절
        } else {
            // 일반 항목은 기본 배경과 색상으로 설정
            holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.white));
            holder.categoryTitle.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.text_primary));
            holder.categoryTitle.setTextSize(16f);
        }

        // 각 항목에 클릭 이벤트 설정
        holder.itemView.setOnClickListener(v -> {
            Intent intent = null;
            if (currentCategory.equals("#[교양강좌]")) {
                // '교양강좌'를 클릭하면 SubCategoryActivity로 이동
                intent = new Intent(v.getContext(), SubCategoryActivity.class);
                intent.putExtra("CATEGORY_TYPE", "general_course");
                intent.putExtra("CATEGORY_TITLE", "교양강좌");
            }
            else if (currentCategory.equals("## IT공과대학")) {
                intent = new Intent(v.getContext(), SubCategoryActivity.class);
                intent.putExtra("CATEGORY_TYPE", "it_college");
                intent.putExtra("CATEGORY_TITLE", "IT공과대학");
            }

            if (intent != null) {
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}
