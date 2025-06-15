package com.example.sugang;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.MaterialToolbar;

public class CartManageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_manage);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_cart_manage);
        toolbar.setNavigationOnClickListener(v -> finish());

        RecyclerView recyclerView = findViewById(R.id.recycler_view_cart_manage);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // CartManager에서 데이터를 가져와 새로 만든 CartManageAdapter에 연결
        CartManageAdapter adapter = new CartManageAdapter(CartManager.cartItems);
        recyclerView.setAdapter(adapter);
    }
}
