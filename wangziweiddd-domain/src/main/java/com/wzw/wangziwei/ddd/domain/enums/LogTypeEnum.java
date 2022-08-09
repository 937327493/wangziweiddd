package com.wzw.wangziwei.ddd.domain.enums;

public enum LogTypeEnum {
    PEOPLENAMETYPE("PEOPLENAMETYPE", "人类别");
    private String index;
    private String content;
    private LogTypeEnum(String index, String content) {
        this.content = content;
        this.index = index;
    }
}
