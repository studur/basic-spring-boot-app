package com.telagene;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.context.annotation.Configuration;

@Configuration
@Entity // This tells Hibernate to make a table out of this class
public class Analyse {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;

   private LocalDate date;
   private String productNumber;
   private String lotNumber;
   private String type;
   private String reason;
   private int numberRuns;
   private String notes;
   private String chemist;
   private LocalDateTime createdAt;


   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public LocalDate getDate() {
      return date;
   }

   public void setDate(LocalDate date) {
      this.date = date;
   }

   public String getProductNumber() {
      return productNumber;
   }

   public void setProductNumber(String productNumber) {
      this.productNumber = productNumber;
   }

   public String getLotNumber() {
      return lotNumber;
   }

   public void setLotNumber(String lotNumber) {
      this.lotNumber = lotNumber;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public String getReason() {
      return reason;
   }

   public void setReason(String reason) {
      this.reason = reason;
   }

   public int getNumberRuns() {
      return numberRuns;
   }

   public void setNumberRuns(int numberRuns) {
      this.numberRuns = numberRuns;
   }

   public String getNotes() {
      return notes;
   }

   public void setNotes(String notes) {
      this.notes = notes;
   }

   public String getChemist() {
      return chemist;
   }

   public void setChemist(String chemist) {
      this.chemist = chemist;
   }

   public LocalDateTime getCreatedAt() {
      return createdAt;
   }

   public void setCreatedAt(LocalDateTime createdAt) {
      this.createdAt = createdAt;
   }
}
