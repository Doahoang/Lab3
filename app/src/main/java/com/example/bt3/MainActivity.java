package com.example.bt3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB;
    Button btnCong, btnTru, btnNhan, btnChia;
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ View
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        txtKetQua = findViewById(R.id.txtKetQua);

        // Xử lý nút cộng
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhToan("+");
            }
        });

        // Xử lý nút trừ
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhToan("-");
            }
        });

        // Xử lý nút nhân
        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhToan("*");
            }
        });

        // Xử lý nút chia
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhToan("/");
            }
        });
    }

    // Hàm tính toán
    private void tinhToan(String phepToan) {
        if (edtA.getText().toString().isEmpty() ||
                edtB.getText().toString().isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đủ số", Toast.LENGTH_SHORT).show();
            return;
        }

        double a = Double.parseDouble(edtA.getText().toString());
        double b = Double.parseDouble(edtB.getText().toString());
        double kq = 0;

        switch (phepToan) {
            case "+":
                kq = a + b;
                break;
            case "-":
                kq = a - b;
                break;
            case "*":
                kq = a * b;
                break;
            case "/":
                if (b == 0) {
                    Toast.makeText(this, "Không thể chia cho 0", Toast.LENGTH_SHORT).show();
                    return;
                }
                kq = a / b;
                break;
        }

        txtKetQua.setText("Kết quả: " + kq);
    }
}