package com.sj.dalimi.service;

import com.sj.dalimi.domain.entity.RunnerEntity;
import com.sj.dalimi.dto.RunnerDto;
import com.sj.dalimi.domain.repository.RunnerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor // repository 주입하기 위해 사용
@Service
public class RunnerService{
    private RunnerRepository runnerRepository;

    @Transactional
    public List<RunnerDto> searchPosts(String keyword){
        List<RunnerEntity> runnerEntities = runnerRepository.findByEmailContaining(keyword);
        List<RunnerDto> runnerDtoList = new ArrayList<>();

        if(runnerEntities.isEmpty()) return runnerDtoList;

        for(RunnerEntity runnerEntity : runnerEntities){
            runnerDtoList.add(this.convertEntityToDto(runnerEntity));
        }
        return runnerDtoList;
    }

    private RunnerDto convertEntityToDto(RunnerEntity runnerEntity){
        return RunnerDto.builder()
                .runner_id(runnerEntity.getRunner_id())
                .email(runnerEntity.getEmail())
                .nickname(runnerEntity.getNickname())
                .build();
    }

    @Transactional
    public RunnerDto getPost(Long runner_id){
        Optional<RunnerEntity> runnerEntityWrapper = runnerRepository.findById(runner_id);
        RunnerEntity runnerEntity = runnerEntityWrapper.get();

        RunnerDto runnerDto = RunnerDto.builder()
                .runner_id(runnerEntity.getRunner_id())
                .email(runnerEntity.getEmail())
                .nickname(runnerEntity.getNickname())
                .build();
        return runnerDto;
    }

    @Transactional
    public void deletePost(Long runner_id){
        runnerRepository.deleteById(runner_id);
    }

    @Transactional
    public List<RunnerDto> getRunnerList(){
        List<RunnerEntity> runnerEntities = runnerRepository.findAll();
        List<RunnerDto> runnerDtoList = new ArrayList<>();

        for(RunnerEntity runnerEntity:runnerEntities){
            RunnerDto runnerDto = RunnerDto.builder()
                    .runner_id(runnerEntity.getRunner_id())
                    .nickname(runnerEntity.getNickname())
                    .email(runnerEntity.getEmail())
                    .build();
            runnerDtoList.add(runnerDto);
        }
        return runnerDtoList;
    }
    @Transactional
    public Long savePost(RunnerDto runnerDto){
        return runnerRepository.save(runnerDto.toEntity()).getRunner_id();
        //save jpaRepository 정의된 메서드, DB insert , update
    }
}
