package com.dataprovider.scoredataapi.resource;

import com.dataprovider.scoredataapi.model.dto.ScoreDataDto;
import com.dataprovider.scoredataapi.service.ScoreDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ScoreDataResource {

  @Autowired
  private ScoreDataService service;

  @GetMapping(value = "/score-data")
  public ResponseEntity<ScoreDataDto> getScoreDataFromCustomer(@RequestParam String cpf) {
    log.info("ScoreDataResource.getScoreDataFromCustomer, cpf={}", cpf);

      ScoreDataDto scoreDataDto = service.getScoreDataFromCustomer(cpf);
      return ResponseEntity.ok(scoreDataDto);
  }
}
