package com.hly.shiro.authentication;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/1
 */
public class AuthenticatorTest {


    /**
     * 所有的身份认证都通过则成功
     */
    @Test
    public void testAllSuccessfulStrategyWithSuccess() {

        iniConfig("classpath:shiro/authentication/shiro-authentication-all-success.ini");
        Subject subject = SecurityUtils.getSubject();
        //得到身份集合，包含验证成功的身份信息
        PrincipalCollection principalCollection = subject.getPrincipals();
        Assert.assertEquals(1,principalCollection.asList().size());

    }

    /**
     * 没有全部成功就失败
     */
    @Test
    public  void textAllSuccessfulStrategyWithFail(){
        iniConfig("classpath:shiro/authentication/shiro-authentication-all-fail.ini");
    }

    /**
     * 一个认证成功就成功，返回第一个认证成功的信息
     */

    @Test
    public void testFirstOneSuccessfulStrategyWithSuccess() {
        iniConfig("classpath:shiro/authentication/shiro-authentication-first-success.ini");
        Subject subject = SecurityUtils.getSubject();

        //得到一个身份集合，其包含了第一个Realm验证成功的身份信息
        PrincipalCollection principalCollection = subject.getPrincipals();
        Assert.assertEquals(1, principalCollection.asList().size());
    }

    /**
     * 一个认证成功就成功，返回第所有认证成功的信息
     */
    @Test
    public void testAtLeastOneSuccessfulStrategyWithSuccess() {
        iniConfig("classpath:shiro/authentication/shiro-authentication-atLeastOne-success.ini");
        Subject subject = SecurityUtils.getSubject();

        //得到一个身份集合，其包含了Realm验证成功的身份信息
        PrincipalCollection principalCollection = subject.getPrincipals();
        Assert.assertEquals(2, principalCollection.asList().size());
    }

    private void iniConfig(String iniConfig) {

        //1.指定ini文件创建Security1Manager工厂
        Factory <SecurityManager> factory = new IniSecurityManagerFactory(iniConfig);
        //2.获取SecurityManager绑定到SecurityUtils，全局设置，设置一次即可
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3.得到Subject绑定到当前线程
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("hly", "123");

        try {
            //4.进行登录，委托给SecurityManager.login管理
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {
        ThreadContext.unbindSubject();//退出时请解除绑定Subject到线程 否则对下次测试造成影响
    }
}
