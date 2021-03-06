package com.zhang.application.config;


import com.zhang.application.realm.AdminRealm;
import com.zhang.application.realm.ApplicantRealm;
import com.zhang.application.realm.StaffRealm;
import org.apache.http.client.AuthenticationStrategy;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();



        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        /**
         * shiro内置过滤器，可以实现权限相关的拦截器
         *  常用的过滤器
         *      anon:无需认证
         *      authc:必须认证
         *      user:如果使用remeberMe可以直接访问
         *      perms:该资源必须得到资源权限才能访问
         *      role:该资源必须得到角色权限才可以访问
         */
        Map<String,String> filterMap = new LinkedHashMap<>();
        //放行静态资源
        filterMap.put("/layui/**","anon");
        filterMap.put("/css/**","anon");
        filterMap.put("/js/**","anon");
        filterMap.put("/release/**","anon");
        filterMap.put("/question","perms[answerer:answer]");
        filterMap.put("/","anon");
        filterMap.put("/*","anon");






        //设置未认证跳转页面
        shiroFilterFactoryBean.setLoginUrl("/index");
        //设置未授权跳转页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }


    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("applicantRealm") ApplicantRealm applicantRealm,
                                                                  @Qualifier("staffRealm") StaffRealm staffRealm,
                                                                  @Qualifier("adminRealm") AdminRealm adminRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置Realm
        MultiRealmAuthenticator modularRealmAuthenticator = new MultiRealmAuthenticator();

        modularRealmAuthenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        securityManager.setAuthenticator(modularRealmAuthenticator);
        Collection<Realm> realms = new ArrayList<>();
        realms.add(applicantRealm);
        realms.add(staffRealm);
        realms.add(adminRealm);

        securityManager.setRealms(realms);
       /* ModularRealmAuthorizer modularRealmAuthorizer = new ModularRealmAuthorizer();
        securityManager.setAuthorizer(modularRealmAuthorizer);*/
        securityManager.setRememberMeManager(rememberMeManager());

        return securityManager;
    }
    /**
     * 创建Realm
     */
    @Bean(name ="applicantRealm" )
    public ApplicantRealm getApplicantRealm(HashedCredentialsMatcher hashedCredentialsMatcher){
        ApplicantRealm applicantRealm = new ApplicantRealm();
        //配置加密
        applicantRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return applicantRealm;
    }
    @Bean(name ="staffRealm" )
    public StaffRealm getStaffRealm(HashedCredentialsMatcher hashedCredentialsMatcher){
        StaffRealm staffRealm = new StaffRealm();
        //配置加密
        staffRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return staffRealm;
    }
    @Bean(name ="adminRealm" )
    public AdminRealm getAdminRealm(HashedCredentialsMatcher hashedCredentialsMatcher){
        AdminRealm adminRealm = new AdminRealm();
        //配置加密
        adminRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return adminRealm;
    }


    @Bean(name = "hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        // 采用MD5方式加密
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        // 设置加密次数
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }
/**
  * cookie对象;
   * rememberMeCookie()方法是设置Cookie的生成模版，比如cookie的name，cookie的有效时间等等。
   * @return
*/
    @Bean
    public SimpleCookie rememberMeCookie(){
              //System.out.println("ShiroConfiguration.rememberMeCookie()");
            //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
              SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
               //<!-- 记住我cookie生效时间30天 ,单位秒;-->
               simpleCookie.setMaxAge(60*60*24*30);
              return simpleCookie;
    }
    /**
     * cookie管理对象;
     * rememberMeManager()方法是生成rememberMe管理器，而且要将这个rememberMe管理器设置到securityManager中
      * @return
     */
 @Bean
 public CookieRememberMeManager rememberMeManager(){
               //System.out.println("ShiroConfiguration.rememberMeManager()");
             CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
               cookieRememberMeManager.setCookie(rememberMeCookie());
              //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)

              cookieRememberMeManager.setCipherKey(Base64.decode("6ZmI6I2j5Y+R5aSn5ZOlAA=="));
           return cookieRememberMeManager;
         }



/*
    @Bean(name = "shiroDialect")

    public ShiroDialect shiroDialect(){

        return new ShiroDialect();

    }
*/



}
