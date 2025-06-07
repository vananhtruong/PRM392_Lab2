package com.example.lab_sed01;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {

    TextView txtDetailName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        txtDetailName = findViewById(R.id.txtDetailName);

        // Nhận dữ liệu từ Intent
        String productName = getIntent().getStringExtra("productName");
        txtDetailName.setText(productName);
    }
}
