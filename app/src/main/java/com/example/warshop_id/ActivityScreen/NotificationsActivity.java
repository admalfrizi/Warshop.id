package com.example.warshop_id.ActivityScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.warshop_id.R;

public class NotificationsActivity extends AppCompatActivity {

    ImageView btnback ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        btnback = findViewById(R.id.btn_back);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationsActivity.super.onBackPressed();
            }
        });

    }
}