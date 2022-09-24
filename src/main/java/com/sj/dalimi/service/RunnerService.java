package com.sj.dalimi.service;

import com.sj.dalimi.domain.entity.RunnerEntity;
import com.sj.dalimi.dto.RunnerDto;
import com.sj.dalimi.domain.repository.RunnerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor // repository 주입하기 위해 사용
@Service
@Slf4j
public class RunnerService{
    private RunnerRepository runnerRepository;
    private static final int BLOCK_PAGE_NUM_COUNT= 5;
    private static final int PAGE_POST_COUNT = 4;

    @Transactional
    public List<RunnerDto> getRunnerList(Integer pageNum){
        Page<RunnerEntity> page = runnerRepository.findAll(PageRequest.of(pageNum-1, PAGE_POST_COUNT,Sort.by(Sort.Direction.ASC,"createdDate")));

        List<RunnerEntity> runnerEntities = page.getContent();
        List<RunnerDto> runnerDtoList = new ArrayList<>();

        for(RunnerEntity runnerEntity:runnerEntities){
            runnerDtoList.add(this.convertEntityToDto(runnerEntity));
        }
        return runnerDtoList;
    }

    @Transactional
    public Long getRunnerCount(){
        return runnerRepository.count();
    }

    public Integer[] getPageList(Integer curPageNum){
        Integer[] pageList = new Integer[BLOCK_PAGE_NUM_COUNT];

        Double postsTotalcount = Double.valueOf(this.getRunnerCount());
        Integer totalLastPageNum = (int)(Math.ceil((postsTotalcount/PAGE_POST_COUNT)));
        Integer blockLastPageNum = (totalLastPageNum>curPageNum + BLOCK_PAGE_NUM_COUNT)?curPageNum + BLOCK_PAGE_NUM_COUNT : totalLastPageNum;
        curPageNum = (curPageNum<=3)? 1: curPageNum-2;

        for(int val = curPageNum, idx = 0; val<= blockLastPageNum; val++, idx++){
            pageList[idx] = val;
        }
        return pageList;
    }

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
