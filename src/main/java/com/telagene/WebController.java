package com.telagene;


import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foo")
public class WebController {

   private static final Logger log = LogManager.getLogger(WebController.class);

   private WebConfig webConfig;

   @GetMapping
   public String getStatus() {
      return "Running as " + LocalDateTime.now().toString();
   }

   @GetMapping("/config")
   public String getConfigName() {
      return  getInstance().getName();
   }

   @PutMapping(value = "/id/{id}")
   @ResponseStatus(HttpStatus.OK)
   public void updateId(@PathVariable("id") Integer id) {
      getInstance().setNumber(id);
      log.info("[updateId] WebConfig updated with number=" + id + " New WebConfig=" +  getInstance());

   }

   @PutMapping(value = "/name/{name}")
   @ResponseStatus(HttpStatus.OK)
   public void updateName(@PathVariable("name") String name) {
      getInstance().setName(name);
      log.info("[updateName] WebConfig updated with name=" + name + " New WebConfig=" + getInstance());

   }

   private WebConfig getInstance() {
      if (webConfig == null){
         log.info("[getInstance] Created new instance");
         webConfig = new WebConfig("Test", 0);
      }
      return webConfig;
   }

}
