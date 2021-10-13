package com.dataprovider.scoredataapi.model.dto;

import com.dataprovider.scoredataapi.model.ScoreDataEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScoreDataDto {

  private String cpf;
  private String customerAge;
  private String address;
  private String sourceOfIncome;
  private Set<PropertyDto> properties;
  private String updatedAt;

  public static ScoreDataDto newInstance(ScoreDataEntity entity) {
    Set<PropertyDto> properties = new HashSet<>();
    entity.getProperties().forEach(property -> properties.add(PropertyDto.newInstance(property)));
    return ScoreDataDto.builder()
        .cpf(entity.getCpf())
        .customerAge(entity.getCustomerAge())
        .address(entity.getAddress())
        .sourceOfIncome(entity.getSourceOfIncome())
        .properties(properties)
        .updatedAt(entity.getUpdatedAt().toString())
        .build();
  }
}

