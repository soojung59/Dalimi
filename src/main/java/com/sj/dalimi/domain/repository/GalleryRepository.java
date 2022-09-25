package com.sj.dalimi.domain.repository;

import com.sj.dalimi.domain.entity.GalleryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GalleryRepository extends JpaRepository<GalleryEntity, Long>{

    @Override
    List<GalleryEntity> findAll();
}
