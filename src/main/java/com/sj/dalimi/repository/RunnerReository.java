package com.sj.dalimi.repository;

import com.sj.dalimi.entity.RunnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RunnerReository extends JpaRepository<RunnerEntity, Long> {
}
