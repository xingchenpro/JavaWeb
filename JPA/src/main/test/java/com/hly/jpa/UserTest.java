package com.hly.jpa;

import com.hly.jpa.model.Article;
import com.hly.jpa.model.User;
import com.hly.jpa.repository.UserDaoBean;

import org.junit.Test;

import javax.persistence.*;
import javax.transaction.Transactional;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/27
 */
public class UserTest {

    /**
     * 获取应用管理的EntityManager
     */
    @Test

    public void testApplicationEntityManager(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyJPA");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        User user = new User();
        user.setName("hly");
        Article article = new Article();
        article.setAricleName("123");
        //以上两行为新建状态
        //托管状态
        em.persist(user);
        //事务提交或调用flush()方法后会同步到数据库
        em.getTransaction().commit();
        //根据主键获取对象
        System.err.println(em.find(User.class,1));
        System.err.println(em.getReference(User.class,1));
        em.close();
        entityManagerFactory.close();
    }

    /**
     * 同步实体到数据库
     */
    @Test
    public void synchronizedEntity(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyJPA");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.setFlushMode(FlushModeType.COMMIT);
        User user = new User();
        user.setName("sir");
        String sql = "select user from User user where user.id =?1";
        Query query = em.createQuery(sql);
        query.setParameter(1,1);
        query.executeUpdate();
        em.flush();
    }

    /**
     * 通过EJB获取EntityManager
     */
    @Test
    public void testEJBEntityManager(){
        UserDaoBean userDaoBean = new UserDaoBean();
        User user = new User();
        user.setName("abc");
        userDaoBean.add(user);
    }

}
