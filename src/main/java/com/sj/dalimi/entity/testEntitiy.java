package com.sj.dalimi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class testEntitiy {
    @Id
    @GeneratedValue
    @Column(name = "test_id")
    private Long id;
    private String id2;

}
