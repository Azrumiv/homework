package ru.web.first_app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // Конфигурация бина Spring, который создает экземпляр класса HelloBean
    @Bean
    public HelloBean helloBean() {
        // Возвращает новый экземпляр HelloBean
        return new HelloBean("Привет, боб!");
    }

}
