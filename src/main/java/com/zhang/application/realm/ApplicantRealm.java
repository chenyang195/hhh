package com.zhang.application.realm;

import com.zhang.application.Entity.*;
import com.zhang.application.mapper.*;
import com.zhang.application.service.authorService.AuthorService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 15:15 2020/3/8
 */
public class ApplicantRealm extends AuthorizingRealm {

    @Resource
    ApplicantInfoMapper applicantInfoMapper;
    @Resource
    ApplicantRoleMapper applicantRoleMapper;
    @Autowired
    AuthorService<ApplicantRole,ApplicantInfo> authorService;
    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String)principalCollection.getPrimaryPrincipal();
        List<String> list  = new ArrayList<>();
        ApplicantInfo applicantInfo = new ApplicantInfo();
        applicantInfo.setPhoneNum(username);
        applicantInfo = applicantInfoMapper.selectOne(applicantInfo);
        if (applicantInfo!=null){
            list = authorService.getAuthorList(applicantInfo,applicantRoleMapper,ApplicantRole.class);
        }


        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (String permission: list ) {
            info.addStringPermission(permission);

        }


        return info;
    }

    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        Object principal= username;
        Object credentials = null;
        ApplicantInfo applicantInfo = new ApplicantInfo();
        applicantInfo.setPhoneNum(username);

        applicantInfo = applicantInfoMapper.selectOne(applicantInfo);
        if(applicantInfo==null){
            return null;
        }
        String pass = applicantInfo.getPassword();


        /*User user =userService.fingByUserName(username);

        if(null==user){
            return null;
        }

        String pass =user.getPassword();*/

        credentials = pass;
        ByteSource credentialsSalt = ByteSource.Util.bytes(principal);
        String realmName = getName();
        return new SimpleAuthenticationInfo(principal,credentials,credentialsSalt,realmName);
    }
    @Override
    public boolean supports(AuthenticationToken var1){
        return var1 instanceof UsernamePasswordToken;
    }
}
