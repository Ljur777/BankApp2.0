package com.example.bankapp.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MVCConfig implements WebMvcConfigurer { // Класс, который прописываем реакции на запросы - аналог контроллера

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login.html"); // Мапинг для формы login
    }
}
