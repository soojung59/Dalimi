package com.sj.dalimi.domain.repository;

import com.sj.dalimi.domain.entity.RunnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RunnerRepository extends JpaRepository<RunnerEntity, Long> {
    List<RunnerEntity> findByEmailContaining(String keyword);
}
