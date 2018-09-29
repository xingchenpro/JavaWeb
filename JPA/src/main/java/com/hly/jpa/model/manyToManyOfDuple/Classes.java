package com.hly.jpa.model.manyToManyOfDuple;

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
public class Classes {

    @Id
    @GeneratedValue
    private int id ;
    private String name;

    //mapperBy为Teacher的Classes属性
    @ManyToMany(mappedBy = "classes",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Collection<Teacher> teachers = new ArrayList<Teacher>();

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

    public Collection<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Collection<Teacher> teachers) {
        this.teachers = teachers;
    }
}
