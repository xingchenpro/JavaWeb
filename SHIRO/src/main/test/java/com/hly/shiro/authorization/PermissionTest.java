package com.hly.shiro.authorization;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
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
 * @date :2018/9/2
 */
public class PermissionTest {

    @Test
    public void testPermission(){

        iniConfig("classpath:shiro/authorization/shiro-permission.ini","hly","123");
        Assert.assertTrue(subject().isPermitted("user:create"));
        Assert.assertTrue(subject().isPermittedAll("user:create","user:delete"));
        Assert.assertFalse(subject().isPermitted("user:view"));

    }

    @Test(expected = UnauthorizedException.class)
    public void testCheckPermission(){
        iniConfig("classpath:shiro/authorization/shiro-permission.ini","hly","123");
        subject().checkPermission("user:create");
        subject().checkPermissions("user:create","user:view");
    }


    private void iniConfig(String iniConfig,String username,String password) {

        //1.指定ini文件创建Security1Manager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(iniConfig);
        //2.获取SecurityManager绑定到SecurityUtils，全局设置，设置一次即可
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3.得到Subject绑定到当前线程
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try{
            //4.进行登录，委托给SecurityManager.login管理
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }

    public  Subject subject(){
        return SecurityUtils.getSubject();
    }

    @After
    public void tearDown() throws Exception {
        ThreadContext.unbindSubject();//退出时请解除绑定Subject到线程 否则对下次测试造成影响
    }
}


