package com.hly.jpa;

import com.hly.jpa.model.manyToManyOfDuple.Classes;
import com.hly.jpa.model.manyToManyOfDuple.Teacher;
import com.hly.jpa.model.manyToManyOfSingle.Course;
import com.hly.jpa.model.manyToManyOfSingle.Student;
import com.hly.jpa.model.manyToOneOfSingle.Car;
import com.hly.jpa.model.manyToOneOfSingle.People;
import com.hly.jpa.model.oneToManyByTableOfSingle.Author;
import com.hly.jpa.model.oneToManyByTableOfSingle.Book;
import com.hly.jpa.model.oneToManyByForeignKeyLinkOfDuple.Boss;
import com.hly.jpa.model.oneToManyByForeignKeyLinkOfDuple.Employee;
import com.hly.jpa.model.oneToOneOfSingle.Article;
import com.hly.jpa.model.oneToOneOfSingle.User;
import com.hly.jpa.repository.UserDaoBean;
import org.junit.Test;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/27
 */
public class JPATest {

    /**
     * 获取应用管理的EntityManager
     */
    @Test
    public void testApplicationEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyJPA");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        User user = new User();
        user.setName("hly");
        //以上两行为新建状态
        //托管状态
        em.persist(user);
        //事务提交或调用flush()方法后会同步到数据库
        em.getTransaction().commit();
        //根据主键获取对象
        //System.err.println(em.find(User.class,1));
        //System.err.println(em.getReference(User.class,1));
        em.close();
        entityManagerFactory.close();
    }

    /**
     * 一对一关系OneToOne
     */
    @Test
    public void testOneToOneRelevance(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyJPA");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        User user  = new User();
        user.setName("hz");
        Article article = new Article();
        article.setAricleName("yx");
        user.setArticle(article);
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        entityManagerFactory.close();
    }

    /**
     * 双向一对多关系OneToMany中间表方式实现
     */
    @Test
    public void testOneToManyRelevance(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyJPA");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Author author = new Author();
        author.setAuthorName("hly");
        Book book1 = new Book();
        Book book2 = new Book();
        book1.setBookName("Java");
        book2.setBookName("Linux");
        Collection<Book> collection = new ArrayList<>();
        collection.add(book1);
        collection.add(book2);
        author.setBooks(collection);
        em.persist(author);
        em.getTransaction().commit();
        em.close();
        entityManagerFactory.close();
    }

    /**
     * 双向一对多关系OneToMany外键关联方式实现
     */
    @Test
    public void testOneToManyForeignKeyLink(){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyJPA");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Boss boss = new Boss();
        boss.setName("hly");
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        employee1.setName("aff");
        employee2.setName("gbd");
        Collection<Employee> collection = new ArrayList<Employee>();
        collection.add(employee1);
        collection.add(employee2);
        boss.setEmployees(collection);
        employee1.setBoss(boss);
        employee2.setBoss(boss);
        em.persist(boss);
        em.persist(employee1);
        em.persist(employee2);
        em.getTransaction().commit();
        em.close();
        entityManagerFactory.close();
    }

    /**
     * 单向多对一关系ManyToOne
     */
    @Test
    public  void testManyToOneRelevance(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyJPA");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Car car1 = new Car();
        Car car2 = new Car();
        People people  = new People();
        car1.setName("Porsche");
        car2.setName("Ferrari");
        people.setName("hly");
        car1.setPeople(people);
        car2.setPeople(people);
        em.persist(car1);
        em.persist(car2);
        em.getTransaction().commit();
        em.close();
        entityManagerFactory.close();
    }

    /**
     * 单向多对多关系ManyToMany
     */
    @Test
    public void manyToManyOfSingleTrack(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyJPA");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Student student = new Student();
        student.setName("hly");
        Course course1 = new Course();
        Course course2 = new Course();
        course1.setName("Java");
        course2.setName("数据库");
        Collection<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);
        student.setCourses(courses);
        em.persist(student);
        em.getTransaction().commit();
        em.close();
        entityManagerFactory.close();

    }

    /**
     * 双向多对多ManyToMany
     */
    @Test
    public void manyToManyOfDuple(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyJPA");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Teacher teacher1 = new Teacher();
        Teacher teacher2 = new Teacher();
        Classes classes1 = new Classes();
        Classes classes2 = new Classes();
        teacher1.setName("aaa");
        teacher2.setName("bbb");
        classes1.setName("161");
        classes2.setName("162");
        Collection<Teacher> teachers = new ArrayList<>();
        Collection<Classes> classes = new ArrayList<>();
        teachers.add(teacher1);
        teachers.add(teacher2);
        classes.add(classes1);
        classes.add(classes2);
        teacher1.setClasses(classes);
        classes2.setTeachers(teachers);
        em.persist(teacher1);
        em.persist(classes2);
        em.getTransaction().commit();
        em.close();
        entityManagerFactory.close();

    }

    /**
     * todo 同步实体到数据库,事务报错
     */
    @Test
    public void synchronizedEntity() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyJPA");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.setFlushMode(FlushModeType.COMMIT);
        User user = new User();
        user.setName("sir");
        String sql = "select user from User user where user.id =?1";
        Query query = em.createQuery(sql);
        query.setParameter(1, 1);
        query.executeUpdate();
        em.flush();
    }

    /**
     * todo 通过EJB获取EntityManager,无法实现
     */
    @Test
    public void testEJBEntityManager() {
        UserDaoBean userDaoBean = new UserDaoBean();
        User user = new User();
        user.setName("abc");
        userDaoBean.add(user);
    }

}
