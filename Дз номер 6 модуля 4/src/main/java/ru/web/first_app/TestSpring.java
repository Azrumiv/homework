package ru.web.first_app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main (String[] args) {
        // Создание контекста приложения на основе файла конфигурации applicationContext.xml
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Получение бина "HelloBean" из контекста Spring
        HelloBean test = context.getBean("HelloBean", HelloBean.class);

        // Вывод сообщения, полученного от HelloBean
        System.out.println(test.getMessage());
    }
}
