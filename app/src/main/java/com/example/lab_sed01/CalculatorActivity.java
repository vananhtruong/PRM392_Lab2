package com.example.lab_sed01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {
    EditText edNumberA, edNumberB;
    Button btnAdd, btnSub, btnDiv, btnMul, btnBack;
    TextView tvResult, tvFormula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        edNumberA = findViewById(R.id.edtNumberA);
        edNumberB = findViewById(R.id.edtNumberB);
        tvResult = findViewById(R.id.txtResult);
        tvFormula = findViewById(R.id.txtFormula);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSubtract);
        btnMul = findViewById(R.id.btnMultiply);
        btnDiv = findViewById(R.id.btnDivide);
        btnBack = findViewById(R.id.btnBack);

        btnAdd.setOnClickListener(view -> calculate('+'));
        btnSub.setOnClickListener(view -> calculate('-'));
        btnMul.setOnClickListener(view -> calculate('*'));
        btnDiv.setOnClickListener(view -> calculate('/'));

        btnBack.setOnClickListener(v -> finish());
    }

    private void calculate(char operator) {
        try {
            double a = Double.parseDouble(edNumberA.getText().toString());
            double b = Double.parseDouble(edNumberB.getText().toString());
            double result = 0;
            String formula = "";

            switch (operator) {
                case '+':
                    result = a + b;
                    formula = a + " + " + b + " = " + result;
                    break;
                case '-':
                    result = a - b;
                    formula = a + " - " + b + " = " + result;
                    break;
                case '*':
                    result = a * b;
                    formula = a + " × " + b + " = " + result;
                    break;
                case '/':
                    if (b == 0) {
                        tvResult.setText("Không thể chia cho 0");
                        tvFormula.setText("");
                        return;
                    }
                    result = a / b;
                    formula = a + " ÷ " + b + " = " + result;
                    break;
            }

            tvResult.setText("Result: " + result);
            tvFormula.setText(formula);

        } catch (NumberFormatException e) {
            tvResult.setText("Vui lòng nhập số hợp lệ");
            tvFormula.setText("");
        }
    }
}
