package com.zhang.application.pojo;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;


public interface TkMapper<T> extends Mapper<T>, MySqlMapper<T>{
}
