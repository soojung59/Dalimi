package com.sj.dalimi.domain.repository;

import com.sj.dalimi.domain.entity.RunnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RunnerRepository extends JpaRepository<RunnerEntity, Long> {
}
