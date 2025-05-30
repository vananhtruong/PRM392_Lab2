package com.example.lab_sed01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MaxMinActivity extends AppCompatActivity {
    EditText edtA, edtB, edtC;
    Button btnFind, btnBack;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_max_min);
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtC = findViewById(R.id.edtC);
        btnFind = findViewById(R.id.btnFind);
        btnBack = findViewById(R.id.btnBack);
        txtResult = findViewById(R.id.txtResult);

        btnFind.setOnClickListener(v -> {
            try {
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                int c = Integer.parseInt(edtC.getText().toString());

                int max = Math.max(a, Math.max(b, c));
                int min = Math.min(a, Math.min(b, c));

                txtResult.setText("Max: " + max + "\nMin: " + min);
            } catch (NumberFormatException e) {
                txtResult.setText("Please enter valid integers.");
            }
        });

        btnBack.setOnClickListener(v -> finish());
    }
}