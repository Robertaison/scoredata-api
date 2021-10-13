package com.dataprovider.scoredataapi.model.dto;

import java.util.Set;
import lombok.Data;

@Data
public class ScoreDataDto {

  private String cpf;
  private String customerAge;
  private String address;
  private String sourceOfIncome;
  private Set<PropertyDto> properties;
  private String updatedAt;
}
