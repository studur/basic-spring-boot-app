package com.telagene;

import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

   private String name;
   private int number;

   public WebConfig() {
   }

   public WebConfig(String name, int number) {
      this.name = name;
      this.number = number;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getNumber() {
      return number;
   }

   public void setNumber(int number) {
      this.number = number;
   }

   @Override
   public String toString() {
      return "WebConfig{" +
            "name='" + name + '\'' +
            ", number=" + number +
            '}';
   }
}
