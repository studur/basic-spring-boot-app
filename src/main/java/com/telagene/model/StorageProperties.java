package com.telagene.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * This class is responsible to define application properties.
 * Any classes which has the @ConfigurationProperties annotation set will have its class members available to be set here as property values
 * in the resources/application.properties file.
 * The key-value names are automatically generated and documented in the target/classes/META-INF/spring-configuration-metadata.json.
 * For more infos, https://www.baeldung.com/spring-boot-configuration-metadata
 */
@ConfigurationProperties("storage")
public class StorageProperties {

   /**
    * Folder location for storing files.
    */
   private String location = "upload-dir";

   public String getLocation() {
      return location;
   }

   public void setLocation(String location) {
      this.location = location;
   }

}
