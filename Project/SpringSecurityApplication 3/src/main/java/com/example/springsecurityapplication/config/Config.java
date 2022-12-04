package com.example.springsecurityapplication.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {
    @Value("${upload.path}")
    private String uploadPath;

    @Value("${app.storage.path}")
    String appPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry
                .addResourceHandler("/**")
                .addResourceLocations("file:" + appPath + "src/main/resources/static/");

        registry.addResourceHandler("/bootstrap/**").addResourceLocations("/static/assets/bootstrap/");
        //registry.addResourceHandler("/css/**").addResourceLocations("/static/assets/css/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("/static/assets/fonts/");
        registry.addResourceHandler("/images/**").addResourceLocations("/static/assets/imag/");
        registry.addResourceHandler("/js/**").addResourceLocations("/static/js/");
        registry.addResourceHandler("/templates/**").addResourceLocations("/templates/");
    }
}
