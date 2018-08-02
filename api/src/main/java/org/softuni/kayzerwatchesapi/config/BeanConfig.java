package org.softuni.kayzerwatchesapi.config;

import org.softuni.kayzerwatchesapi.web.interceptors.WatchViewsInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class BeanConfig {
    private final WatchViewsInterceptor watchViewsInterceptor;

    public BeanConfig(WatchViewsInterceptor watchViewsInterceptor) {
        this.watchViewsInterceptor = watchViewsInterceptor;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(watchViewsInterceptor);
            }
        };
    }
}
