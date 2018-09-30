package com.hly.jpa.model.oneToManyByForeignKeyLinkOfDuple;

import javax.persistence.*;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/29
 */
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    //多方设置指向一方的主键
    //todo 外键为null
    @ManyToOne
    @JoinColumn(name = "bossId")
    private Boss boss;

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

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }
}
