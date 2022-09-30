package com.sj.runner.domain.repository;

import com.sj.runner.domain.entity.RecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordRepository extends JpaRepository<RecordEntity, Long> {
    List<RecordEntity> findByMemoContaining(String keyword);
}
