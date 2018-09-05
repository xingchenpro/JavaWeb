package com.hly.shiro.iniConfig;

import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import sun.security.krb5.Realm;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/5
 */
public class MyAuthenticator extends ModularRealmAuthenticator {

    public void setBytes(byte [] bytes){
        System.err.println(new String(bytes));
    }

    public void setArray(int[] ints){
        System.out.println(Arrays.toString(ints));
    }

    public void setSet(Set<Realm> realms){
        System.out.println(realms);
    }

    public void setMap(Map<Object,Object> maps){
        System.out.println(maps);
        System.out.println(maps.get("1"));
    }



}
