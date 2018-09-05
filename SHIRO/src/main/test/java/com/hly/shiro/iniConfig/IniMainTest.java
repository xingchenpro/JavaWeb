package com.hly.shiro.iniConfig;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/5
 */
public class IniMainTest {

    /**
     * shiro-config-main.ini
     */

    @Test
    public void test(){

        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro/iniConfig/shiro-config-main.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("hly","123");
        subject.login(token);
        Assert.assertTrue(subject.isAuthenticated());


    }
}
