package com.dataprovider.scoredataapi.repository;

import com.dataprovider.scoredataapi.model.ScoreDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreDataRepository extends JpaRepository<ScoreDataEntity, Integer> {
}
