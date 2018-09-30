package com.hly.jpa.repository;

import com.hly.jpa.model.oneToOneOfSingle.User;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/28
 */
public interface UserDao {

    /**
     * 获取应用管理UserDao
     * @param user
     */
    public void add(User user);
}
