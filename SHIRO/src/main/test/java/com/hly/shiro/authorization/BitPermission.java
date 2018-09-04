package com.hly.shiro.authorization;


import org.apache.commons.lang.StringUtils;

import org.apache.shiro.authz.Permission;

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

        //+user+1
        if(array.length>1){
            resourceIdentify = array[1];
        }

        //无资源匹配
        if(StringUtils.isEmpty(resourceIdentify)){
            resourceIdentify = "*";
        }

        //+user+1+1
        if(array.length>2){
            permissionBit = Integer.valueOf(array[2]);
        }

        //+user+1+1+1
        if(array.length>3){
            instanceId= array[3];
        }

        //无实例ID
        if(StringUtils.isEmpty(instanceId)) {
            instanceId = "*";
        }

    }

    @Override
    public boolean implies(Permission p) {
        if(!(p instanceof BitPermission)) {
            return false;
        }
        BitPermission other = (BitPermission) p;

        if(!("*".equals(this.resourceIdentify) || this.resourceIdentify.equals(other.resourceIdentify))) {
            return false;
        }

        if(!(this.permissionBit ==0 || (this.permissionBit & other.permissionBit) != 0)) {
            return false;
        }

        if(!("*".equals(this.instanceId) || this.instanceId.equals(other.instanceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BitPermission{" +
                "resourceIdentify='" + resourceIdentify + '\'' +
                ", permissionBit=" + permissionBit +
                ", instanceId='" + instanceId + '\'' +
                '}';
    }





}
