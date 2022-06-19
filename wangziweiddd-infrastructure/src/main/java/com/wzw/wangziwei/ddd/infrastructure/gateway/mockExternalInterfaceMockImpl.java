package com.wzw.wangziwei.ddd.infrastructure.gateway;

import com.wzw.wangziwei.ddd.infrastructure.gateway.dto.BasicPeopleDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 外部——人员基础信息接口测试Mock类
 */
@Component
public class mockExternalInterfaceMockImpl implements MockExternalInterface {
    @Override
    public List<BasicPeopleDTO> queryBasicPeopleDTO(List<Long> ids) {
        BasicPeopleDTO basicPeopleDTO = new BasicPeopleDTO();
        basicPeopleDTO.setName("迪迦奥特曼");
        basicPeopleDTO.setAddr("伊拉克");
        basicPeopleDTO.setAge(17);
        basicPeopleDTO.setHeight(new BigDecimal("169.291"));
        basicPeopleDTO.setWeight(new BigDecimal("67.921"));
        basicPeopleDTO.setPhoneNum(18112312333L);
        ArrayList<BasicPeopleDTO> basicPeopleDTOS = new ArrayList<>();
        basicPeopleDTOS.add(basicPeopleDTO);
        return basicPeopleDTOS;
    }
}
