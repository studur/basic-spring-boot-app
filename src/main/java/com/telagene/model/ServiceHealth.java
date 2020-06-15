package com.telagene.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * This class is responsible to define the Service health infos and its related application properties.
 *
 * Any classes which has the @ConfigurationProperties annotation set will have its class members available to be set here as property values
 * in the resources/application.properties file.
 * The key-value names are automatically generated and documented in the target/classes/META-INF/spring-configuration-metadata.json.
 * For more infos, https://www.baeldung.com/spring-boot-configuration-metadata
 */
@ConfigurationProperties("service")
@Configuration
public class ServiceHealth {

   private String name;
   private String ip;

   public ServiceHealth() {
   }

   public ServiceHealth(String name, String ip) {
      this.name = name;
      this.ip = ip;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getIp() {
      return ip;
   }

   public void setIp(String ip) {
      this.ip = ip;
   }

   @Override
   public String toString() {
      return "ServiceHealth{" +
            "name='" + name + '\'' +
            ", number=" + ip +
            '}';
   }
}
