package com.wzw.wangziwei.ddd.infrastructure.repository.mybatis.mapper;

import com.wzw.wangziwei.ddd.infrastructure.repository.mybatis.dataobj.LogDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper {
    /**
     * 单条插入
     * @return int
     */
    int insert(LogDO logDO);
}