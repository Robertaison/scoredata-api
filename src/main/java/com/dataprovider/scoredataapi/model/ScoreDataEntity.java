package com.dataprovider.scoredataapi.model;

import com.dataprovider.scoredataapi.model.dto.ScoreDataDto;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class ScoreDataEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String cpf;
  private String customerAge;
  private String address;
  private String sourceOfIncome;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "scoreData", fetch = FetchType.EAGER)
  private Set<PropertyEntity> properties = new HashSet<>();

  private LocalDateTime updatedAt;

  public static ScoreDataEntity newInstance(ScoreDataDto dto) {
    Set<PropertyEntity> properties = new HashSet<>();

    ScoreDataEntity scoreData = ScoreDataEntity.builder()
        .cpf(dto.getCpf())
        .customerAge(dto.getCustomerAge())
        .address(dto.getAddress())
        .sourceOfIncome(dto.getSourceOfIncome())
        .updatedAt(LocalDateTime.parse(dto.getUpdatedAt()))
        .build();

    dto.getProperties().forEach(
        propertyDto -> properties.add(PropertyEntity.newInstance(propertyDto, scoreData))
    );
    scoreData.setProperties(properties);
    return scoreData;
  }
}
