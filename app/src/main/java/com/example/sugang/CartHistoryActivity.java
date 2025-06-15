package com.example.sugang;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.MaterialToolbar;
import java.util.ArrayList;

public class CartHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_history);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_cart_history);
        toolbar.setNavigationOnClickListener(v -> finish());

        RecyclerView recyclerView = findViewById(R.id.recycler_view_cart_history);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // CartManager에서 장바구니 목록을 가져옴
        ArrayList<Course> cartItems = CartManager.cartItems;

        // '강의계획서' 버튼이 있는 CourseSearchAdapter를 재사용
        CourseSearchAdapter adapter = new CourseSearchAdapter(cartItems);
        recyclerView.setAdapter(adapter);
    }
}
