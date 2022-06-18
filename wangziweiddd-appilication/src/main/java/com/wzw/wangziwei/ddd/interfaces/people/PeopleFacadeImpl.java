package com.wzw.wangziwei.ddd.interfaces.people;

import com.wzw.wangziwei.ddd.api.servcie.people.PeopleFacade;
import com.wzw.wangziwei.ddd.api.servcie.people.dto.PeopleDTO;
import com.wzw.wangziwei.ddd.api.servcie.people.dto.PeopleQueryDTO;
import com.wzw.wangziwei.ddd.api.utils.UmsResult;
import com.wzw.wangziwei.ddd.application.people.command.PeopleApplication;
import com.wzw.wangziwei.ddd.application.people.command.cmd.PeopleCreateCommand;
import com.wzw.wangziwei.ddd.application.people.command.cmd.PeopleModifyCommand;
import com.wzw.wangziwei.ddd.application.people.query.PeopleQueryService;
import com.wzw.wangziwei.ddd.interfaces.converter.PeopleConvert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class PeopleFacadeImpl implements PeopleFacade {
    @Resource
    private PeopleApplication peopleApplication;

    @Resource
    private PeopleQueryService peopleQueryService;

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
            if (peopleQueryDTO.getIds() == null) {
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
            return UmsResult.buildSuccess(peopleDTO);
        } catch (Exception e) {
            //可以打日志
            return UmsResult.buildFailed(500, "PeopleFacadeImpl#getPeople任务执行失败:" + e.getMessage());
        }
    }
}
