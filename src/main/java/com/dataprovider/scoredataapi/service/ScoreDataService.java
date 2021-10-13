package com.dataprovider.scoredataapi.service;

import com.dataprovider.scoredataapi.model.dto.ScoreDataDto;

public interface ScoreDataService {
  ScoreDataDto getScoreDataFromCustomer(String cpf);
  void saveUpdateDataFromCustomer(ScoreDataDto dto);
}
