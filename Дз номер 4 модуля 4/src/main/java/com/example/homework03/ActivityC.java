package com.example.homework03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ActivityC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        // Находим кнопку для открытия ActivityA
        Button btOpenActAFromC = findViewById(R.id.btOpenActAFromC);

        // Устанавливаем слушатель клика для открытия ActivityA
        btOpenActAFromC.setOnClickListener(view -> {
            // Создаем новый Intent для перехода к ActivityA
            Intent intent = new Intent(this, ActivityA.class);
            // Запускаем ActivityA
            startActivity(intent);
        });

        // Находим кнопку для открытия ActivityD
        Button btOpenActD = findViewById(R.id.btOpenActD);

        // Устанавливаем слушатель клика для открытия ActivityD
        btOpenActD.setOnClickListener(view -> {
            // Создаем новый Intent для перехода к ActivityD
            Intent intent = new Intent(this, ActivityD.class);
            // Запускаем ActivityD
            startActivity(intent);
        });

        // Находим кнопку для закрытия ActivityC
        Button btCloseActC = findViewById(R.id.btCloseActC);

        // Устанавливаем слушатель клика для закрытия ActivityB
        btCloseActC.setOnClickListener(view -> {
            // Создаем новый Intent для перехода к ActivityB (ошибка: должно быть закрытие ActivityC)
            Intent intent = new Intent(this, ActivityB.class);
            // Запускаем ActivityB (ошибка: должно быть зак
