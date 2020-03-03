package com.zhang.application.realm;



import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;


import java.util.ArrayList;
import java.util.List;

public class UserRealm extends AuthorizingRealm {

    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
       String username = (String)principalCollection.getPrimaryPrincipal();
       List<String> list = new ArrayList<>();
       list.add("user:read");


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


        /*User user =userService.fingByUserName(username);

        if(null==user){
            return null;
        }

        String pass =user.getPassword();*/

        credentials = 123;
        ByteSource credentialsSalt = ByteSource.Util.bytes("aaa");
        String realmName = getName();
        return new SimpleAuthenticationInfo(principal,credentials,credentialsSalt,realmName);
    }
}
