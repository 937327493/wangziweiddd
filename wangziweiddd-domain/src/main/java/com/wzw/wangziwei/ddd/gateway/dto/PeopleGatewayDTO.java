package com.wzw.wangziwei.ddd.gateway.dto;

import lombok.Builder;
import lombok.Getter;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Builder
public class PeopleGatewayDTO implements Serializable {
    public static final long serialVersionUID = -1L;
    private String name;
    private Integer age;
    private BigDecimal height;
    private BigDecimal weight;
}
