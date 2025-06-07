package com.example.lab_sed01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnCalculator, btnMaxMin, btnQuadratic, btnLogin, btnProductList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalculator = findViewById(R.id.btnCalculator);
        btnMaxMin = findViewById(R.id.btnMaxMin);
        btnQuadratic = findViewById(R.id.btnQuadratic);
        btnLogin = findViewById(R.id.btnLogin);
        btnProductList = findViewById(R.id.btnProductList);

        btnCalculator.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CalculatorActivity.class)));
        btnMaxMin.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MaxMinActivity.class)));
        btnQuadratic.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, QuadraticEquationActivity.class)));
        btnLogin.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, LoginActivity.class)));
        btnProductList.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ProductListActivity.class)));

    }
}