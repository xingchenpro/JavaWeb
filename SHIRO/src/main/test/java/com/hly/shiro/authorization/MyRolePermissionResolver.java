package com.hly.shiro.authorization;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/3
 */
public class MyRolePermissionResolver implements RolePermissionResolver {
    @Override
    public Collection<Permission> resolvePermissionsInRole(String roleString) {
        //如果拥有role1角色，则可以匹配以下权限
      if("role1".equals(roleString)){
          return Arrays.asList((Permission) new WildcardPermission("menu:*"));
      }

        return null;
    }
}
