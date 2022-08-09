package com.wzw.wangziwei.ddd.infrastructure.repository.mybatis.mapper;

import com.wzw.wangziwei.ddd.infrastructure.repository.mybatis.dataobj.LogDO;
import com.wzw.wangziwei.ddd.infrastructure.repository.mybatis.dataobj.PeopleDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogMapper {
    /**
     * 单条插入
     * @return int
     */
    int insert(LogDO logDO);

    /**
     * 根据itemKey查
     * @param itemKey
     * @return
     */
    List<LogDO> findByKey(String itemKey);
}