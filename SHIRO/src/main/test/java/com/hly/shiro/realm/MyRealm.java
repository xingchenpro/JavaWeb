package com.hly.shiro.realm;

import com.hly.shiro.authorization.BitPermission;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/3
 */
/**
 * 自定义Realm
 */
public class MyRealm extends AuthorizingRealm {
    @Override
    //表示根据用户身份获取授权信息
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //添加角色
        authorizationInfo.addRole("role1");
        authorizationInfo.addRole("role2");
        //添加权限
        authorizationInfo.addObjectPermission(new BitPermission("+user1+10+1+1"));
        authorizationInfo.addObjectPermission(new BitPermission("+user1+4"));
        authorizationInfo.addObjectPermission(new BitPermission("+user1+2"));
        authorizationInfo.addObjectPermission(new BitPermission("+user1+8"));
        authorizationInfo.addObjectPermission(new WildcardPermission("user1:*"));
        authorizationInfo.addStringPermission("+user2+10");
        authorizationInfo.addStringPermission("user2:*");

        return authorizationInfo;
    }

    @Override
    //表示获取身份验证信息
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String username = (String)authenticationToken.getPrincipal();//用户名
        String password = new String((char[])authenticationToken.getCredentials());//密码
        if(!"hly".equals(username)) {
            throw new UnknownAccountException(); //如果用户名错误
        }
        if(!"123".equals(password)) {
            throw new IncorrectCredentialsException(); //如果密码错误
        }
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(username, password, getName());

    }
}
