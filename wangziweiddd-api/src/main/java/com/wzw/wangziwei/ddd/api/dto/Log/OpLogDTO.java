package com.wzw.wangziwei.ddd.api.dto.Log;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class OpLogDTO implements Serializable {
    private static final long serialVersionUID = -1l;
    private Long id;

    /**
     * 修改人
     */
    private String opPeopleName;

    /**
     * 修改时间
     */
    private Date logTime;

    /**
     * 曾用名
     */
    private String beforeName;
    /**
     * 身份证号
     */
    private String identifierKey;
    /**
     * 现用名
     */
    private String afterName;
}
