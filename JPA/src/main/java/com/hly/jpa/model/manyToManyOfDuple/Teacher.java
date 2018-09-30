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
public class Teacher {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "teaching",joinColumns = {@JoinColumn(name = "teacherId",referencedColumnName = "id")},
            inverseJoinColumns ={@JoinColumn(name = "classesId",referencedColumnName = "id")} )
    private Collection<Classes> classes = new ArrayList<Classes>();

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

    public Collection<Classes> getClasses() {
        return classes;
    }

    public void setClasses(Collection<Classes> classes) {
        this.classes = classes;
    }
}
