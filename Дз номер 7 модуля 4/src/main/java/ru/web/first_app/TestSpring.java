package ru.web.first_app;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Основной класс для тестирования Spring Framework
public class TestSpring {
    public static void main (String[] args) {
        // Создание контекста приложения на основе конфигурационного класса AppConfig
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Получение бина (компонента) HelloBean из контекста
        HelloBean helloBean = context.getBean(HelloBean.class);

        // Вывод сообщения, полученного из HelloBean
        System.out.println(helloBean.getMessage());
    }
}
