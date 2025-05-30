package com.example.lab_sed01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuadraticEquationActivity extends AppCompatActivity {
    EditText edtA, edtB, edtC;
    Button btnSolve, btnBack;
    TextView txtResult, txtFormula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadratic_equation);

        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtC = findViewById(R.id.edtC);
        btnSolve = findViewById(R.id.btnSolve);
        btnBack = findViewById(R.id.btnBack);
        txtResult = findViewById(R.id.txtResult);
        txtFormula = findViewById(R.id.txtFormula);

        // Cập nhật công thức khi người dùng nhập xong (ở đây dùng nút Solve để cập nhật)
        btnSolve.setOnClickListener(v -> {
            try {
                double a = Double.parseDouble(edtA.getText().toString());
                double b = Double.parseDouble(edtB.getText().toString());
                double c = Double.parseDouble(edtC.getText().toString());

                // Hiển thị công thức chính xác với số nhập
                String formula = formatEquation(a, b, c);
                txtFormula.setText("Phương trình: " + formula + " = 0");

                if (a == 0) {
                    txtResult.setText("a không được bằng 0.");
                    return;
                }

                double delta = b * b - 4 * a * c;

                if (delta > 0) {
                    double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                    txtResult.setText("2 nghiệm phân biệt:\nx1 = " + x1 + "\nx2 = " + x2);
                } else if (delta == 0) {
                    double x = -b / (2 * a);
                    txtResult.setText("Nghiệm kép:\nx1 = x2 = " + x);
                } else {
                    txtResult.setText("Vô nghiệm thực.");
                }
            } catch (NumberFormatException e) {
                txtResult.setText("Vui lòng nhập số hợp lệ.");
                txtFormula.setText("Phương trình: ax² + bx + c = 0");
            }
        });

        btnBack.setOnClickListener(v -> finish());
    }

    // Hàm format phương trình đẹp hơn
    private String formatEquation(double a, double b, double c) {
        StringBuilder sb = new StringBuilder();

        // a*x^2
        if (a == 0) {
            // Không hiển thị nếu a=0 (chỉ hiện bx + c)
        } else {
            if (a == 1) sb.append("x²");
            else if (a == -1) sb.append("-x²");
            else sb.append(formatDouble(a)).append("x²");
        }

        // b*x
        if (b != 0) {
            if (b > 0) {
                if (sb.length() > 0) sb.append(" + ");
                if (b == 1) sb.append("x");
                else sb.append(formatDouble(b)).append("x");
            } else {
                if (sb.length() > 0) sb.append(" - ");
                else sb.append("-");
                if (Math.abs(b) == 1) sb.append("x");
                else sb.append(formatDouble(Math.abs(b))).append("x");
            }
        }

        // c
        if (c != 0) {
            if (c > 0) {
                if (sb.length() > 0) sb.append(" + ");
                sb.append(formatDouble(c));
            } else {
                if (sb.length() > 0) sb.append(" - ");
                else sb.append("-");
                sb.append(formatDouble(Math.abs(c)));
            }
        }

        if (sb.length() == 0) return "0";

        return sb.toString();
    }

    private String formatDouble(double num) {
        if (num == (long) num)
            return String.format("%d", (long) num);
        else
            return String.format("%.2f", num);
    }
}
