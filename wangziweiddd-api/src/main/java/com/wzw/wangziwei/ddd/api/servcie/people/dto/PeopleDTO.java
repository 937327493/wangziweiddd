package com.wzw.wangziwei.ddd.api.servcie.people.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 人类
 */
@Data
@ToString
public class PeopleDTO implements Serializable {
    public static final long serialVersionUID = -1l;
    /**
     * 姓名
     */
    private String name;

    /**
     * id
     */
    private Long id;
}
