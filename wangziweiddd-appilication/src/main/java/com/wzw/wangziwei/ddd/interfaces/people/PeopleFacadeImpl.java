package com.wzw.wangziwei.ddd.interfaces.people;

import com.wzw.wangziwei.ddd.api.servcie.people.PeopleFacade;
import com.wzw.wangziwei.ddd.api.servcie.people.dto.PeopleDTO;
import com.wzw.wangziwei.ddd.api.servcie.people.dto.PeopleQueryDTO;
import com.wzw.wangziwei.ddd.api.utils.UmsResult;
import com.wzw.wangziwei.ddd.application.people.command.PeopleApplication;
import com.wzw.wangziwei.ddd.application.people.command.cmd.PeopleCreateCommand;
import com.wzw.wangziwei.ddd.application.people.command.cmd.PeopleModifyCommand;
import com.wzw.wangziwei.ddd.application.people.query.PeopleQueryService;
import com.wzw.wangziwei.ddd.gateway.QueryPeopleGatewayService;
import com.wzw.wangziwei.ddd.gateway.dto.PeopleGatewayDTO;
import com.wzw.wangziwei.ddd.interfaces.converter.PeopleConvert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class PeopleFacadeImpl implements PeopleFacade {
    @Resource
    private PeopleApplication peopleApplication;

    @Resource
    private PeopleQueryService peopleQueryService;

    @Resource
    private QueryPeopleGatewayService queryPeopleGatewayService;

    @RequestMapping("/put")
    @Override
    public UmsResult put(PeopleDTO peopleDTO) {
        try {
            PeopleCreateCommand peopleCreateCommand = PeopleConvert.buildCreateCommand(peopleDTO);
            peopleApplication.create(peopleCreateCommand);
            return UmsResult.buildSuccess();
        } catch (Exception e) {
            return UmsResult.buildFailed(500, "PeopleFacadeImpl#put任务执行失败:" + e.getMessage());
        }
    }

    @RequestMapping("/update")
    @Override
    public UmsResult update(PeopleDTO peopleDTO) {
        try {
            PeopleModifyCommand peopleModifyCommand = PeopleConvert.buildUpdateCommand(peopleDTO);
            peopleApplication.update(peopleModifyCommand);
            return UmsResult.buildSuccess();
        } catch (Exception e) {
            return UmsResult.buildFailed(500, "PeopleFacadeImpl#update任务执行失败:" + e.getMessage());
        }
    }

    @PostMapping("/get")
    @Override
    public UmsResult getPeople(@RequestBody PeopleQueryDTO peopleQueryDTO) {
        List<PeopleDTO> peopleDTO = null;
        try {
            if (peopleQueryDTO == null) {
                throw new RuntimeException("PeopleFacadeImpl#getPeople#peopleQueryDTO为null");
            }
            if (peopleQueryDTO.getPageNum() == null || peopleQueryDTO.getPageNum() <= 0) {
                peopleQueryDTO.setPageNum(1);
            }
            if (peopleQueryDTO.getPageSize() == null || peopleQueryDTO.getPageSize() > 200
                    || peopleQueryDTO.getPageSize() <= 0) {
                peopleQueryDTO.setPageSize(200);
            }
            peopleDTO = peopleQueryService.queryPeople(peopleQueryDTO);
            if (peopleQueryDTO.getIds() != null) {
                //远程调用查询对象年龄
                List<PeopleGatewayDTO> peopleGatewayDTOS = queryPeopleGatewayService.queryBasicPeopleDTO(peopleQueryDTO.getIds());
                //只返回成年的人
                peopleDTO = peopleDTO.stream()
                        .map(peopleDTO1 -> {
                            Optional<PeopleGatewayDTO> first = peopleGatewayDTOS.stream().filter(peopleGatewayDTO ->
                                    peopleGatewayDTO.getName().equalsIgnoreCase(peopleDTO1.getName())
                            ).collect(Collectors.toList()).stream().findFirst();
                            Integer age = first.map(PeopleGatewayDTO::getAge).orElse(18);
                            if (age < 18) {
                                return null;
                            }
                            return peopleDTO1;
                        })
                        .filter(peopleDTO1 -> peopleDTO1 != null)
                        .collect(Collectors.toList());
            }
            return UmsResult.buildSuccess(peopleDTO);
        } catch (Exception e) {
            //可以打日志
            return UmsResult.buildFailed(500, "PeopleFacadeImpl#getPeople任务执行失败:" + e.getMessage());
        }
    }
}
