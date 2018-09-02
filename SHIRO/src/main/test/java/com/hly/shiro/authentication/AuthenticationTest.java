package com.hly.shiro.authentication;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
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

public class AuthenticationTest {

    /**
     * 登录验证
     */
    @Test
    public void testLogin(){
        //1.指定ini文件创建Security1Manager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro/authentication/shiro.ini");
        //2.获取SecurityManager绑定到SecurityUtils，全局设置，设置一次即可
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3.得到Subject绑定到当前线程
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("hly","123");

        try {
            //4.进行登录，委托给SecurityManager.login管理
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        //判断用户已经登录
        //自动化测试junit Assert类，第一个的期望值，第二个是实际值，可以指出报错信息，调用A equal B 都是null为true
        Assert.assertEquals(true,subject.isAuthenticated());
        //5.退出
        subject.logout();

    }

    /**
     * 指定单个realm
     */
    @Test
    public void testMyRealm(){
        //1.指定ini文件创建Security1Manager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro/authentication/shiro-realm.ini");
        //2.获取SecurityManager绑定到SecurityUtils，全局设置，设置一次即可
        SecurityManager securityManager = factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);
        //3.得到Subject绑定到当前线程
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("hly","123");

        try {
            //4.进行登录，委托给SecurityManager.login管理
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        //判断用户已经登录
        //自动化测试junit Assert类，第一个的期望值，第二个是实际值，可以指出报错信息，调用A equal B 都是null为true
        Assert.assertEquals(true,subject.isAuthenticated());
        //5.退出
        subject.logout();
    }

    /**
     * 指定多个realm,不一致则不能通过
     */
    @Test
    public void testMultiRealm(){
        //1.指定ini文件创建Security1Manager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro/authentication/shiro-multi-realm.ini");
        //2.获取SecurityManager绑定到SecurityUtils，全局设置，设置一次即可
        SecurityManager securityManager = factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);
        //3.得到Subject绑定到当前线程
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("hly","123");

        try{
            //4.进行登录，委托给SecurityManager.login管理
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        //判断用户已经登录
        //自动化测试junit Assert类，第一个的期望值，第二个是实际值，可以指出报错信息，调用A equal B 都是null为true
        Assert.assertEquals(true,subject.isAuthenticated());
        //5.退出
        subject.logout();

    }

    /**
     * 表名:users(必须)
     * username:hly(必须)
     * password:123(必须)
     */
    @Test
    public void testJDBCRealm(){
        //1.指定ini文件创建Security1Manager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro/authentication/shiro-jdbc-realm.ini");
        //2.获取SecurityManager绑定到SecurityUtils，全局设置，设置一次即可
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3.得到Subject绑定到当前线程
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("hly","123");

        try {
            //4.进行登录，委托给SecurityManager.login管理
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        //判断用户已经登录
        //自动化测试junit Assert类，第一个的期望值，第二个是实际值，可以指出报错信息，调用A equal B 都是null为true
        Assert.assertEquals(true,subject.isAuthenticated());
        //5.退出
        subject.logout();

    }


    @After
    public void tearDown() throws Exception {
        ThreadContext.unbindSubject();//退出时请解除绑定Subject到线程 否则对下次测试造成影响
    }







}
