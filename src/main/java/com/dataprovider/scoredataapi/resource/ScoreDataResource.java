package com.dataprovider.scoredataapi.resource;

import com.dataprovider.scoredataapi.model.dto.ScoreDataDto;
import com.dataprovider.scoredataapi.service.ScoreDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreDataResource {

  @Autowired
  private ScoreDataService service;

  @GetMapping
  public void getScoreDataFromCustomer(@PathVariable String cpf) {
      ScoreDataDto scoreDataDto = service.getScoreDataFromCustomer(cpf);
  }
}
