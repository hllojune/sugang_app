package com.example.sugang;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CartManageAdapter extends RecyclerView.Adapter<CartManageAdapter.CartViewHolder> {

    private final ArrayList<Course> cartItems;

    public CartManageAdapter(ArrayList<Course> cartItems) {
        this.cartItems = cartItems;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Course currentCourse = cartItems.get(position);
        holder.courseName.setText(currentCourse.getCourseName());
        holder.courseDetails.setText(currentCourse.getDetails());

        holder.deleteButton.setOnClickListener(v -> {
            // 현재 목록(cartItems)에서 해당 아이템 제거
            cartItems.remove(position);
            // 어댑터에 아이템이 제거되었음을 알려 애니메이션 효과를 줌
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, cartItems.size());
            Toast.makeText(v.getContext(), currentCourse.getCourseName() + " 삭제 완료", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        public TextView courseName;
        public TextView courseDetails;
        public Button deleteButton;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            courseName = itemView.findViewById(R.id.tv_course_name_cart);
            courseDetails = itemView.findViewById(R.id.tv_course_details_cart);
            deleteButton = itemView.findViewById(R.id.btn_delete_from_cart);
        }
    }
}
