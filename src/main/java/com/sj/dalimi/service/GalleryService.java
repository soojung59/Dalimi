package com.sj.dalimi.service;

import com.sj.dalimi.domain.entity.GalleryEntity;
import com.sj.dalimi.domain.repository.GalleryRepository;
import com.sj.dalimi.dto.GalleryDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class GalleryService {
    private  GalleryRepository galleryRepository;

    public List<GalleryDto> getList(){
        List<GalleryEntity> galleryEntityList = galleryRepository.findAll();
        List<GalleryDto> galleryDtoList = new ArrayList<>();

        for(GalleryEntity galleryEntity:galleryEntityList){
            galleryDtoList.add(convertEntityToDto(galleryEntity));
        }
        return galleryDtoList;
    }

    private GalleryDto convertEntityToDto(GalleryEntity galleryEntity){
        return GalleryDto.builder()
                .id(galleryEntity.getId())
                .title(galleryEntity.getTitle())
                .filePath(galleryEntity.getFilePath())
                .imgFullPath("https://"+ S3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + galleryEntity.getFilePath())
                .build();
    }

    public void savePost(GalleryDto galleryDto){
        galleryRepository.save(galleryDto.toEntity());
    }
}
