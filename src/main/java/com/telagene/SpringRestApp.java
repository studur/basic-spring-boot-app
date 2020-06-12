package com.telagene;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.telagene.storage.StorageProperties;
import com.telagene.storage.StorageService;

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

}
