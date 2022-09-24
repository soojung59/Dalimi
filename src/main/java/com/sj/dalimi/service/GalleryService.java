package com.sj.dalimi.service;

import com.sj.dalimi.domain.repository.GalleryRepository;
import com.sj.dalimi.dto.GalleryDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Slf4j
@Service
@AllArgsConstructor
public class GalleryService {
    private  GalleryRepository galleryRepository;


    public void savePost(GalleryDto galleryDto){
        galleryRepository.save(galleryDto.toEntity());
    }
}
