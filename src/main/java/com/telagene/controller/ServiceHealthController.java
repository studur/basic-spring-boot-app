package com.telagene.controller;


import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.telagene.model.ServiceHealth;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/service")
public class ServiceHealthController {

   private static final Logger log = LogManager.getLogger(ServiceHealthController.class);

   private ServiceHealth serviceHealth;

   @GetMapping
   public String getStatus() {
      return "Running as " + LocalDateTime.now().toString();
   }

   @GetMapping("/instance")
   public ServiceHealth getServiceHealth() {
      return  getInstance();
   }

   @PutMapping(value = "/ip/{ip}")
   @ResponseStatus(HttpStatus.OK)
   public void updateIp(@PathVariable("ip") String ip) {
      getInstance().setIp(ip);
      log.info("[updateId] ServiceHealth updated with ip=" + ip + " New ServiceHealth=" +  getInstance());

   }

   @PutMapping(value = "/name/{name}")
   @ResponseStatus(HttpStatus.OK)
   public void updateName(@PathVariable("name") String name) {
      getInstance().setName(name);
      log.info("[updateName] ServiceHealth updated with name=" + name + " New ServiceHealth=" + getInstance());

   }

   private ServiceHealth getInstance() {
      if (serviceHealth == null){
         log.info("[getInstance] Created new instance");
         serviceHealth = new ServiceHealth("Basic spring app", "127.0.0.1");
      }
      return serviceHealth;
   }

}
