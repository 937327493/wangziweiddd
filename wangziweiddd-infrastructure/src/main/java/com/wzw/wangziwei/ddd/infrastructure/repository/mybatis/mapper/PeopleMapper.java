package com.wzw.wangziwei.ddd.infrastructure.repository.mybatis.mapper;

import com.wzw.wangziwei.ddd.infrastructure.repository.mybatis.dataobj.PeopleDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PeopleMapper {
    /**
     * 单条插入
     * @param name
     * @return
     */
    int insert(@Param("name") String name);

    /**
     * 单条更新
     * @param id
     * @param name
     * @return
     */
    int update(@Param("id") Long id, @Param("name") String name);

    /**
     * 根据id查
     * @param id
     * @return
     */
    PeopleDO findById(Long id);

    /**
     * 批量查询
     * @param ids
     * @param pagestart
     * @param pageSize
     * @return
     */
    List<PeopleDO> select(@Param("ids") List<Long> ids, @Param("pageStart") Integer pagestart, @Param("pageSize") Integer pageSize);
}
