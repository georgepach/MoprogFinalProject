package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        String title = getIntent().getStringExtra("task_title");
        boolean status = getIntent().getBooleanExtra("task_status", false);

        TextView tvTitle = findViewById(R.id.detailTitle);
        TextView tvStatus = findViewById(R.id.detailStatus);

        if (title != null) {
            tvTitle.setText(title);
        }
        tvStatus.setText(status ? "Status: Completed" : "Status: Pending");
    }
}