package com.dataprovider.scoredataapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Property {

  @Id
  private Integer id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id", referencedColumnName = "id")
  private ScoreDataEntity scoreData;
  private String propertyName;
  private String propertyDocument;
  private String propertyEvaluatedPrice;
}
