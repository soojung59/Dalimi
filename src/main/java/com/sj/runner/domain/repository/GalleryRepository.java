package com.sj.runner.domain.repository;

import com.sj.runner.domain.entity.GalleryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GalleryRepository extends JpaRepository<GalleryEntity, Long>{

    @Override
    List<GalleryEntity> findAll();
}
