package com.sj.dalimi.service;

import com.sj.dalimi.repository.RunnerReository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class RunnerService{
    private RunnerReository runnerReository;

}
