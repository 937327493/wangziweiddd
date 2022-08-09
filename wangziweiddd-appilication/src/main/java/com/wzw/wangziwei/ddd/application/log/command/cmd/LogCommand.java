package com.wzw.wangziwei.ddd.application.log.command.cmd;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Getter
@Setter
public class LogCommand {
    /**
     * 修改人
     */
    private String opPeopleName;

    /**
     * 修改时间
     */
    private LocalDateTime logTime;


    private String before;
    /**
     * 身份证号
     */
    private String identifierKey;

    private String after;
}
