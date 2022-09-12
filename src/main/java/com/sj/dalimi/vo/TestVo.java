package com.sj.dalimi.vo;

import lombok.Data;

@Data
public class TestVo {
    
    private String id;
    private String name;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        // this.text = text;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        // this.name = name;
    }

}
