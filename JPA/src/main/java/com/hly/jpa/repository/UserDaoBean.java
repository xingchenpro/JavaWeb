package com.hly.jpa.repository;

import com.hly.jpa.model.oneToOneOfSingle.User;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/28
 */
@Remote
@Stateless
public class UserDaoBean implements UserDao {

    @PersistenceContext(unitName = "MyJPA")
     EntityManager em;

    @Override
    public void add(User user) {
        em.persist(user);
    }
}
