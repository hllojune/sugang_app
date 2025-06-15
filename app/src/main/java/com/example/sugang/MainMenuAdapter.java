package com.example.sugang;

// MainMenuAdapter.java

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuAdapter.MenuViewHolder> {

    private final ArrayList<MenuItem> menuItems;

    // 생성자에서 데이터 리스트를 받음
    public MainMenuAdapter(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    // ViewHolder: list_item_main_menu.xml의 뷰(View)들을 담는 그릇
    public static class MenuViewHolder extends RecyclerView.ViewHolder {
        public ImageView icon;
        public TextView title;
        public TextView subtitle;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.iv_menu_icon);
            title = itemView.findViewById(R.id.tv_menu_title);
            subtitle = itemView.findViewById(R.id.tv_menu_subtitle);
        }
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // list_item_main_menu.xml 레이아웃을 가져와서 ViewHolder를 생성
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_main_menu, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        // 현재 위치(position)에 해당하는 MenuItem 데이터를 가져온다.
        MenuItem currentItem = menuItems.get(position);

        // 가져온 데이터로 ViewHolder 안의 뷰들을 채운다.
        holder.icon.setImageResource(currentItem.getIconResId());
        holder.title.setText(currentItem.getTitle());
        holder.subtitle.setText(currentItem.getSubtitle());

        // 각 아이템 뷰에 클릭 이벤트를 설정합니다.
        holder.itemView.setOnClickListener(v -> {
            String clickedTitle = currentItem.getTitle();
            Context context = v.getContext();
            Intent intent = null; // Intent를 미리 선언

            // 클릭된 아이템의 제목에 따라 다른 액티비티로 이동
            if (clickedTitle.equals("공지사항")) {
                intent = new Intent(context, NoticeActivity.class);
            } else if (clickedTitle.equals("조회")) {
                intent = new Intent(context, SearchActivity.class);
            } else if (clickedTitle.equals("장바구니")) {
                intent = new Intent(context, CartActivity.class);
            } else if (clickedTitle.equals("수강신청")) {
                // TODO: RegistrationActivity를 만들고 연결
            }

            if (intent != null) {
                context.startActivity(intent);
            } else {
                Toast.makeText(context, clickedTitle + " 메뉴 클릭됨", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        // 전체 아이템 개수를 반환
        return menuItems.size();
    }
}