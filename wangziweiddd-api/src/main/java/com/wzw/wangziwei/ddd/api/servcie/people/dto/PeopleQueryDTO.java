package com.wzw.wangziwei.ddd.api.servcie.people.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 查询dto
 */
@Data
public class PeopleQueryDTO implements Serializable {
    public static final long serialVersionUID = -123l;
    private List<Long> ids;

    private Integer pageNum;

    private Integer pageSize;
}
