package com.dataprovider.scoredataapi.service.impl;

import com.dataprovider.scoredataapi.model.ScoreDataEntity;
import com.dataprovider.scoredataapi.model.dto.ScoreDataDto;
import com.dataprovider.scoredataapi.repository.ScoreDataRepository;
import com.dataprovider.scoredataapi.service.ScoreDataService;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ScoreDataServiceImpl implements ScoreDataService {

  @Autowired
  private ScoreDataRepository repository;

  @Override
  public ScoreDataDto getScoreDataFromCustomer(String cpf) {
    return null;
  }

  @Override
  public void saveUpdateDataFromCustomer(ScoreDataDto dto) {
    log.info("M=saveUpdateDataFromCustomer, received dto={}", dto);
    ScoreDataEntity scoreDataEntity = ScoreDataEntity.builder()
        .cpf(dto.getCpf())
        .updatedAt(LocalDateTime.parse(dto.getUpdatedAt()))
        .build();

    repository.save(scoreDataEntity);
  }
}
