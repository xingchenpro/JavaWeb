package com.hly.shiro.authorization;

import java.security.acl.Permission;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/3
 */

/**
 *  规则
 *    +资源字符串+权限位+实例ID
 *
 *     以+开头 中间通过+分割
 *
 *  权限：
 *     0 表示所有权限
 *     1 新增 0001
 *     2 修改 0010
 *     4 删除 0100
 *     8 查看 1000
 *
 *  如 +user+10 表示对资源user拥有修改/查看权限
 *
 *  不考虑一些异常情况
 * */

public class BitPermission implements Permission {

    //资源字符串
    private String resourceIdentify;
    //权限位
    private int permissionBit;
    //实例ID
    private String instanceId;

    public  BitPermission(String permissionString){
        //split(String regex) \\+同+
        String[] array = permissionString.split("\\+");







    }







}
