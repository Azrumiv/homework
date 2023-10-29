package ru.web.first_app;

public class HelloBean {

    private String message; // Приватное строковое поле для хранения сообщения

    public HelloBean(String message) {
        this.message = message; // Конструктор класса, устанавливает сообщение при создании объекта
    }

    public String getMessage() {
        return message; // Метод для получения сообщения
    }

}
