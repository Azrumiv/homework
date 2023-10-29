package com.example.homework03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        Button btOpenActC = findViewById(R.id.btOpenActC);

        // Устанавливаем слушатель клика на кнопку
        btOpenActC.setOnClickListener(view -> {
            // Создаем новый Intent для перехода к ActivityC
            Intent intent = new Intent(this, ActivityC.class);
            // Запускаем ActivityC
            startActivity(intent);
        });
    }
}
