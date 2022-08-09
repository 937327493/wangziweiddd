package com.wzw.wangziwei.ddd.domain.Log.model;

import com.wzw.wangziwei.ddd.domain.enums.LogTypeEnum;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class OpLog {
    private Long id;
    private String opPeopleName;
    private LocalDateTime logTime;
    private LogTypeEnum logTypeEnum;
    private LogAttrKeyOb value;
    private String key;
}
