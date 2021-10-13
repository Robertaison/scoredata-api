package com.dataprovider.scoredataapi.model;

import com.dataprovider.scoredataapi.model.dto.PropertyDto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PropertyEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @ManyToOne
  private ScoreDataEntity scoreData;

  private String propertyName;
  private String propertyDocument;
  private String propertyEvaluatedPrice;

  public static PropertyEntity newInstance(PropertyDto dto, ScoreDataEntity scoreData) {

    return PropertyEntity.builder()
        .scoreData(scoreData)
        .propertyName(dto.getPropertyName())
        .propertyDocument(dto.getPropertyDocument())
        .propertyEvaluatedPrice(dto.getPropertyEvaluatedPrice())
        .build();
  }
}
