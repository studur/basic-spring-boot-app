package com.telagene;


import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

   private static final Logger log = LogManager.getLogger(UserController.class);

   private User user;

   @GetMapping("/status")
   public String getStatus() {
      return "Running as " + LocalDateTime.now().toString();
   }

   @GetMapping("/config")
   public String getUserName() {
      return  getInstance().getName();
   }

   @PutMapping(value = "/id/{id}")
   @ResponseStatus(HttpStatus.OK)
   public void updateId(@PathVariable("id") Integer id) {
      getInstance().setId(id);
      log.info("[updateId] User updated with id=" + id + " New User=" +  getInstance());

   }

   @PutMapping(value = "/name/{name}")
   @ResponseStatus(HttpStatus.OK)
   public void updateName(@PathVariable("name") String name) {
      getInstance().setName(name);
      log.info("[updateName] User updated with name=" + name + " New User=" + getInstance());

   }

   private User getInstance() {
      if (user == null){
         log.info("[getInstance] Created new instance");
         user = new User("Test", 0);
      }
      return user;
   }

}
