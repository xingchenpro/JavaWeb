package com.hly.shiro.service.serviceImpl;

import com.hly.shiro.dao.UserDao;
import com.hly.shiro.entity.User;
import com.hly.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author :hly
 * @date :2018/6/21
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    public UserDao userDao;

    @Override
    public User findUser(String username) {
        return userDao.findUser(username);
    }
}
