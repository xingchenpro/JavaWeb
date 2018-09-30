package com.hly.jpa.model.oneToManyByForeignKeyLinkOfDuple;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/29
 */
@Entity
public class Boss {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    //mappedBy:Boss类为多方关系维护方，负责数据库外键boss_id的更新
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "boss")
    private Collection<Employee> employees = new ArrayList<Employee>();

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

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }
}
