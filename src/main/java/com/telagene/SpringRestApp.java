package com.telagene;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.telagene.model.StorageProperties;
import com.telagene.model.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class SpringRestApp {

   public static void main(String[] args) {
      SpringApplication.run(SpringRestApp.class, args);
   }

   @Bean
   CommandLineRunner init(StorageService storageService) {
      return (args) -> {
         storageService.deleteAll();
         storageService.init();
      };
   }

   @Bean
   public WebMvcConfigurer corsConfigurer() {
      return new WebMvcConfigurer() {
         @Override
         public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/service/**").allowedOrigins("*");
            registry.addMapping("/**").allowedOrigins("*");
         }
      };
   }

}
