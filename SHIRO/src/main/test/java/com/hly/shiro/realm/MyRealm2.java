package com.hly.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/1
 */
public class MyRealm2 implements Realm {
    /**
     * 返回一个唯一的名字
     * @return
     */
    @Override
    public String getName() {
        return "MyRealm2";
    }

    /**
     * 判断此Realm是否支持token
     * @param authenticationToken
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        //设置只支持UsernamePasswordToken类型的token
        return authenticationToken instanceof UsernamePasswordToken;
    }

    /**
     * 根据token获取认证信息
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户名
        String userId = (String)authenticationToken.getPrincipal();
        //获取密码
        String userPassword = new String((char[])authenticationToken.getCredentials());
        if(!"abc".equals(userId))
            throw new UnknownAccountException();
        if(!"123".equals(userPassword))
            throw new IncorrectCredentialsException();
        //身份验证成功
        return new SimpleAuthenticationInfo(userId,userPassword,getName());
    }
}
