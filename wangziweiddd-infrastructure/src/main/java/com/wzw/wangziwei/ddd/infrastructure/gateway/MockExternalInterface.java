package com.wzw.wangziwei.ddd.infrastructure.gateway;

import com.wzw.wangziwei.ddd.infrastructure.gateway.dto.BasicPeopleDTO;

import java.util.List;

public interface MockExternalInterface {
    List<BasicPeopleDTO> queryBasicPeopleDTO(List<Long> ids);
}
