package com.dataprovider.scoredataapi.repository;

import com.dataprovider.scoredataapi.model.ScoreDataEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreDataRepository extends JpaRepository<ScoreDataEntity, Integer> {
  Optional<ScoreDataEntity> findByCpf(String cpf);

}
