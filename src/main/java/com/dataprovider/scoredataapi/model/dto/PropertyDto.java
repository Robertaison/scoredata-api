package com.dataprovider.scoredataapi.model.dto;

import com.dataprovider.scoredataapi.model.PropertyEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PropertyDto {

  private String propertyName;
  private String propertyDocument;
  private String propertyEvaluatedPrice;

  public static PropertyDto newInstance(PropertyEntity entity) {
    return PropertyDto.builder()
        .propertyName(entity.getPropertyName())
        .propertyDocument(entity.getPropertyDocument())
        .propertyEvaluatedPrice(entity.getPropertyEvaluatedPrice())
        .build();
  }
}
