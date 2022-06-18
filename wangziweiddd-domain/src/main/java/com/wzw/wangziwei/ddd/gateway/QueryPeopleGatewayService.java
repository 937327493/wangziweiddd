package com.wzw.wangziwei.ddd.gateway;

import com.wzw.wangziwei.ddd.gateway.dto.PeopleGatewayDTO;

import java.util.List;

public interface QueryPeopleGatewayService {
    /**
     * 向其他微服务批量查询具体信息
     * @param ids
     * @return
     */
    List<PeopleGatewayDTO> queryBasicPeopleDTO(List<Long> ids);
}
