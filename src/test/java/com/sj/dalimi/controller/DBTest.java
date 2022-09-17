package com.sj.dalimi.controller;

import com.sj.dalimi.entity.RunnerEntity;
import com.sj.dalimi.repository.RunnerReository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class DBTest {

    @Autowired
    RunnerReository runnerReository;
    @Test
    public void SelectRunner(){
        Long id = 1L;

        Optional<RunnerEntity> tes = runnerReository.findById(id);
        if(tes.isPresent()) {
            RunnerEntity run = tes.get();
            System.out.println(run);
        }
    }
}
