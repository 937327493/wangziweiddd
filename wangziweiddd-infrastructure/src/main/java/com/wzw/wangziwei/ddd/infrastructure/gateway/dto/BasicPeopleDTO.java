package com.wzw.wangziwei.ddd.infrastructure.gateway.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class BasicPeopleDTO implements Serializable {
    public static final long serialVersionUID = -1L;
    private String name;
    private Integer age;
    private BigDecimal height;
    private BigDecimal weight;
    private Long phoneNum;
    private String addr;
}
