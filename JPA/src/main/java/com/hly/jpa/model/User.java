package com.hly.jpa.model;

import javax.persistence.*;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/27
 */

@Entity
//指定表名，指定唯一约束
@Table(name = "user",uniqueConstraints = {@UniqueConstraint(columnNames = {"id","name"})})
public class User {
    @Id//指定主键
    @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column
    private String password;

    //一对一映射
    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "articleId", unique = true)
    public Article article;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    /**
     * persist()之前调用
     */
    @PrePersist
    void beforePersist(){
        System.err.println("beforePersist...");
    }

    @PostPersist
    void afterPersist(){
        System.err.println("afterPersist...");
    }
}
