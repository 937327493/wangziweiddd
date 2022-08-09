package com.wzw.wangziwei.ddd.infrastructure.repository.mybatis.dataobj;

import com.wzw.wangziwei.ddd.domain.Log.model.LogAttrKeyOb;
import com.wzw.wangziwei.ddd.domain.enums.LogTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LogDO {

    private Long id;
    private String opPeopleName;
    private LocalDateTime logTime;
    private LogTypeEnum logTypeEnum;
    private String value;
    private String itemkey;
}
