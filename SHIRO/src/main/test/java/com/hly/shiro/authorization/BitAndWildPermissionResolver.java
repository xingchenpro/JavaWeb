package com.hly.shiro.authorization;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/3
 */

/**
 * 解析字符串到Permission
 */
public class BitAndWildPermissionResolver implements PermissionResolver {
    @Override
    //“+” 开头来解析权限字符串为 BitPermission 或 WildcardPermission。
    public Permission resolvePermission(String permissionString) {
        if(permissionString.startsWith("+")){
            return new BitPermission(permissionString);
        }

        return new WildcardPermission(permissionString);
    }
}
