package com.dataprovider.scoredataapi.model.dto;

import com.dataprovider.scoredataapi.model.Property;
import java.util.List;
import lombok.Data;

@Data
public class ScoreDataDto {

  private String cpf;
  private String address;
  private String sourceOfIncome;
  private List<Property> properties;
  private String updatedAt;
}
