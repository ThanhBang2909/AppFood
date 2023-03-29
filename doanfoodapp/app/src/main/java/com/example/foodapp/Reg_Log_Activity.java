package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Reg_Log_Activity extends AppCompatActivity {

    Button btnlog, btnreg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_log);
        btnlog = findViewById(R.id.btnlogin);
        btnreg = findViewById(R.id.btnreg);

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reg_Log_Activity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reg_Log_Activity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}