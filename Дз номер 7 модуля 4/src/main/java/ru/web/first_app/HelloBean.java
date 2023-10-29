package ru.web.first_app;

import org.springframework.stereotype.Component;

// Аннотация @Component указывает, что этот класс является компонентом, который будет управляться Spring Framework.
@Component
public class HelloBean {

    private String message;

    // Конструктор класса HelloBean принимает строку и инициализирует поле сообщения.
    public HelloBean(String string) {
        this.message = string;
    }

    // Метод getMessage() возвращает сообщение, установленное в экземпляре класса HelloBean.
    public String getMessage() {
        return message;
    }

}
