package com.sj.runner.service;

import com.sj.runner.domain.entity.RecordEntity;
import com.sj.runner.dto.RecordDto;
import com.sj.runner.domain.repository.RecordRepository;
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
public class RecordService {
    private RecordRepository recordRepository;
    private static final int BLOCK_PAGE_NUM_COUNT= 5;
    private static final int PAGE_POST_COUNT = 4;

    @Transactional
    public List<RecordDto> getRunnerList(Integer pageNum){
        Page<RecordEntity> page = recordRepository.findAll(PageRequest.of(pageNum-1, PAGE_POST_COUNT,Sort.by(Sort.Direction.ASC,"createdDate")));

        List<RecordEntity> runnerEntities = page.getContent();
        List<RecordDto> recordDtoList = new ArrayList<>();

        for(RecordEntity recordEntity :runnerEntities){
            recordDtoList.add(this.convertEntityToDto(recordEntity));
        }
        return recordDtoList;
    }

    @Transactional
    public Long getRunnerCount(){
        return recordRepository.count();
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
    public List<RecordDto> searchPosts(String keyword){
        List<RecordEntity> runnerEntities = recordRepository.findByMemoContaining(keyword);
        List<RecordDto> recordDtoList = new ArrayList<>();

        if(runnerEntities.isEmpty()) return recordDtoList;

        for(RecordEntity recordEntity : runnerEntities){
            recordDtoList.add(this.convertEntityToDto(recordEntity));
        }
        return recordDtoList;
    }

    private RecordDto convertEntityToDto(RecordEntity recordEntity){
        return RecordDto.builder()
                .record_id(recordEntity.getRecord_id())
                .start_latitude(recordEntity.getStart_latitude())
                .start_hardness(recordEntity.getStart_hardness())
                .arrival_latitude(recordEntity.getArrival_latitude())
                .arrival_hardness(recordEntity.getArrival_hardness())
                .time(recordEntity.getTime())
                .memo(recordEntity.getMemo())
                .level(recordEntity.getLevel())
                .build();
    }

    @Transactional
    public RecordDto getPost(Long record_id){
        Optional<RecordEntity> runnerEntityWrapper = recordRepository.findById(record_id);
        RecordEntity recordEntity = runnerEntityWrapper.get();

        RecordDto recordDto = RecordDto.builder()
                .record_id(recordEntity.getRecord_id())
                .start_latitude(recordEntity.getStart_latitude())
                .start_hardness(recordEntity.getStart_hardness())
                .arrival_latitude(recordEntity.getArrival_latitude())
                .arrival_hardness(recordEntity.getArrival_hardness())
                .time(recordEntity.getTime())
                .memo(recordEntity.getMemo())
                .level(recordEntity.getLevel())
                .build();
        return recordDto;
    }

    @Transactional
    public void deletePost(Long record_id){
        recordRepository.deleteById(record_id);
    }

    @Transactional
    public List<RecordDto> getRunnerList(){
        List<RecordEntity> runnerEntities = recordRepository.findAll();
        List<RecordDto> recordDtoList = new ArrayList<>();

        for(RecordEntity recordEntity :runnerEntities){
            RecordDto recordDto = RecordDto.builder()
                    .record_id(recordEntity.getRecord_id())
                    .start_latitude(recordEntity.getStart_latitude())
                    .start_hardness(recordEntity.getStart_hardness())
                    .arrival_latitude(recordEntity.getArrival_latitude())
                    .arrival_hardness(recordEntity.getArrival_hardness())
                    .time(recordEntity.getTime())
                    .memo(recordEntity.getMemo())
                    .level(recordEntity.getLevel())
                    .build();
            recordDtoList.add(recordDto);
        }
        return recordDtoList;
    }
    @Transactional
    public Long savePost(RecordDto recordDto){
        return recordRepository.save(recordDto.toEntity()).getRecord_id();
        //save jpaRepository 정의된 메서드, DB insert , update
    }
}
