package com.telagene;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/analysis")
@CrossOrigin(origins = "*")
public class AnalysesRepositoryController {

   @Autowired
   private AnalyseRepository analyseRepository;

   @PostMapping(path = "/add")
   public @ResponseBody
   String addNewAnalysis(@RequestBody Analyse analyse) {

      Analyse newAnalyse = new Analyse();
      newAnalyse.setDate(LocalDate.now());
      newAnalyse.setProductNumber(analyse.getProductNumber());
      newAnalyse.setLotNumber(analyse.getLotNumber());
      newAnalyse.setType(analyse.getType());
      newAnalyse.setReason(analyse.getReason());
      newAnalyse.setNumberRuns(analyse.getNumberRuns());
      newAnalyse.setNotes(analyse.getNotes());
      newAnalyse.setChemist(analyse.getChemist());
      newAnalyse.setCreatedAt(LocalDateTime.now());
      analyseRepository.save(newAnalyse);
      return "Saved";
   }

   @GetMapping(path = "/all")
   public @ResponseBody
   Iterable<Analyse> getAllAnalyses() {
      // This returns a JSON or XML with the users
      return analyseRepository.findAll();
   }
}

