package com.hly.shiro.dao;

import com.hly.shiro.entity.User;

import javax.jws.soap.SOAPBinding;

/**
 * @author :hly
 * @date :2018/6/21
 */
public interface UserDao {
    public User findUser(String username);
}
