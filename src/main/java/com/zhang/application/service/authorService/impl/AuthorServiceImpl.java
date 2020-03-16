package com.zhang.application.service.authorService.impl;

import com.zhang.application.Entity.*;
import com.zhang.application.mapper.ActionInfoMapper;
import com.zhang.application.mapper.RoleActionMapper;
import com.zhang.application.mapper.RoleInfoMapper;
import com.zhang.application.pojo.UserRoleMapper;
import com.zhang.application.service.authorService.AuthorService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 18:14 2020/3/13
 */
@Service
public class AuthorServiceImpl<T,K> implements AuthorService<T,K> {
    @Resource
    RoleInfoMapper roleInfoMapper;
    @Resource
    RoleActionMapper roleActionMapper;
    @Resource
    ActionInfoMapper actionInfoMapper;
    @Override
    public List<String> getAuthorList(K k, UserRoleMapper userRoleMapper,Class<T> clazz) {
        List<String> list = new ArrayList<>();


        Example example = new Example(clazz);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",((User) k).getId());

        //System.out.println(((User) k).getId());

        List<UserRole> userRoles = userRoleMapper.selectByExample(example);
        //System.out.println(userRoles);

        if (userRoles!=null){
            RoleAction roleAction = new RoleAction();
            RoleInfo roleInfo;
            for (UserRole u: userRoles) {

                //System.out.println(u.getRoleId());
                roleInfo = roleInfoMapper.selectByPrimaryKey(u.getRoleId());
                //System.out.println(roleInfo);
                roleAction.setRoleId(u.getRoleId());
                //System.out.println(roleAction);
                List<RoleAction> roleActions = roleActionMapper.select(roleAction);
                //System.out.println(roleActions);
                if (roleActions!=null){
                    ActionInfo actionInfo;
                    for (RoleAction r: roleActions) {
                       // System.out.println(r.getActionId());
                        actionInfo = actionInfoMapper.selectByPrimaryKey(r.getActionId());
                        //System.out.println(actionInfo);
                        list.add(roleInfo.getRoleName()+":"+actionInfo.getActionName());
                    }
                }
            }
        }
        return list;
    }
}
