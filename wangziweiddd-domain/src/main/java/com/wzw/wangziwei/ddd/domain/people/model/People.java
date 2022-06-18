package com.wzw.wangziwei.ddd.domain.people.model;

import com.wzw.wangziwei.ddd.domain.people.PeopleRepository;
import lombok.Data;

/**
 * 人类领域模型
 */
@Data
public class People {
    /**
     * id唯一标识
     */
    private Long id;
    /**
     * 领域操作类
     */
    private PeopleRepository peopleRepository;
    /**
     * 名字
     */
    private String name;
    public void create() {
        peopleRepository.save(this);
    }
}
