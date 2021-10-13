package com.dataprovider.scoredataapi.service.impl;

import com.dataprovider.scoredataapi.model.PropertyEntity;
import com.dataprovider.scoredataapi.model.ScoreDataEntity;
import com.dataprovider.scoredataapi.model.dto.ScoreDataDto;
import com.dataprovider.scoredataapi.repository.ScoreDataRepository;
import com.dataprovider.scoredataapi.service.ScoreDataService;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
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
    log.info("M=ScoreDataService.getScoreDataFromCustomer, cpf={}", cpf);
    Optional<ScoreDataEntity> scoreDataEntity = repository.findByCpf(cpf);
    return scoreDataEntity.map(ScoreDataDto::newInstance).orElse(null);
  }

  @Override
  public void saveUpdateDataFromCustomer(ScoreDataDto dto) {
    log.info("M=ScoreDataService.saveUpdateDataFromCustomer, received dto={}", dto);
    Optional<ScoreDataEntity> entityOptional = repository.findByCpf(dto.getCpf());
    entityOptional.ifPresentOrElse(
        entity -> updateAndSaveEntity(entity, dto),
            () -> repository.save(ScoreDataEntity.newInstance(dto))
    );
  }

  private void updateAndSaveEntity(ScoreDataEntity entity, ScoreDataDto dto) {
    Set<PropertyEntity> properties = new HashSet<>();
    dto.getProperties().forEach(
        propertyDto -> properties.add(PropertyEntity.newInstance(propertyDto, entity))
    );

    entity.setAddress(dto.getAddress());
    entity.setCustomerAge(dto.getCustomerAge());
    entity.setSourceOfIncome(dto.getSourceOfIncome());
    entity.setProperties(properties);
    repository.saveAndFlush(entity);
  }
}
