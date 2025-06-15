package com.example.sugang;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;

public class RegistrationHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_history);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_reg_history);
        toolbar.setNavigationOnClickListener(v -> finish());
    }
}
