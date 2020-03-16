package com.zhang.application.mapper;

import com.zhang.application.Entity.Referees;
import com.zhang.application.pojo.TkMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 20:53 2020/3/14
 */
@Mapper
@Component(value = "RefereesMapper")
public interface RefereesMapper extends TkMapper<Referees> {
}
