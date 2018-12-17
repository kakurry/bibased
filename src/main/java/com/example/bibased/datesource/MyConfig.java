package com.example.bibased.datesource;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 *  Spring Boot 无法访问 static 的css，js等静态资源的问题
 *    https://blog.csdn.net/yu514950381/article/details/78015088
 */
@Configuration
public class MyConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/templates/**");
    }
}
