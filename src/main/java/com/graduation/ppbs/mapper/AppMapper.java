package com.graduation.ppbs.mapper;

import com.graduation.ppbs.dao.App;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AppMapper {

    @Select("SELECT * FROM APP")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "router", column = "router"),
            @Result(property = "type", column = "type") })
    List<App> queryAllApp();

    @Select("SELECT * FROM APP WHERE TYPE>=#{type}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "router", column = "router"),
            @Result(property = "type", column = "type") })
    List<App> queryAppListByType(Integer type);
}
