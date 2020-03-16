package com.zhang.application.service.authorService;

import com.zhang.application.Entity.User;
import com.zhang.application.Entity.UserRole;
import com.zhang.application.pojo.TkMapper;
import com.zhang.application.pojo.UserMapper;
import com.zhang.application.pojo.UserRoleMapper;

import java.util.List;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 18:04 2020/3/13
 */
public interface AuthorService<T,K> {
    List<String> getAuthorList(K k, UserRoleMapper userRoleMapper,Class<T> clazz);
}
