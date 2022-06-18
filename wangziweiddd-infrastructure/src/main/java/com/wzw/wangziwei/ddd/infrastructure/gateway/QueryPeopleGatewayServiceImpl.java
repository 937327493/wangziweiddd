package com.wzw.wangziwei.ddd.infrastructure.gateway;

import com.wzw.wangziwei.ddd.gateway.QueryPeopleGatewayService;
import com.wzw.wangziwei.ddd.gateway.dto.PeopleGatewayDTO;
import com.wzw.wangziwei.ddd.infrastructure.gateway.dto.BasicPeopleDTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class QueryPeopleGatewayServiceImpl implements QueryPeopleGatewayService {
    @Resource
    private MockExternalInterface mockExternalInterface;
    @Override
    public List<PeopleGatewayDTO> queryBasicPeopleDTO(List<Long> ids) {
        List<BasicPeopleDTO> basicPeopleDTOS = mockExternalInterface.queryBasicPeopleDTO(ids);
        List<PeopleGatewayDTO> collect = basicPeopleDTOS.stream().map(basicPeopleDTO -> {
            PeopleGatewayDTO build = PeopleGatewayDTO.builder()
                    .age(basicPeopleDTO.getAge())
                    .height(basicPeopleDTO.getHeight())
                    .name(basicPeopleDTO.getName())
                    .weight(basicPeopleDTO.getWeight())
                    .build();
            return build;
        }).collect(Collectors.toList());
        return collect;
    }
}
