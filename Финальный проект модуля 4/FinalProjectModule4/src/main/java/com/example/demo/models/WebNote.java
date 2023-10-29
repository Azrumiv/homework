package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Генерация геттеров, сеттеров, equals, hashCode, и toString
@AllArgsConstructor // Создание конструктора с параметрами для всех полей класса
@NoArgsConstructor // Создание конструктора без параметров

public class WebNote {
    private int id; // Идентификатор заметки
    private String note; // Текстовое содержание заметки
}
