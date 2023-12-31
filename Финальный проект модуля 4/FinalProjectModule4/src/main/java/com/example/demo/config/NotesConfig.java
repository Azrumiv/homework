package com.example.demo.config;

import com.example.demo.dao.WebNoteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@ComponentScan("com.example.demo") // Сканирование пакетов для компонентов
@EnableWebMvc // Включение поддержки веб MVC
public class NotesConfig implements WebMvcConfigurer {

    private final ApplicationContext applicationContext; // Контекст приложения

    @Autowired
    public NotesConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext; // Инициализация контекста приложения
    }

    @Bean
    WebNoteDAO webNoteDAO() {
        return new WebNoteDAO(); // Создание объекта WebNoteDAO для взаимодействия с данными
    }

}
