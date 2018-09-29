package com.hly.jpa.model.manyToManyOfSingle;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/29
 */
@Entity
public class Student {

    @Id
    @GeneratedValue
    private int id;
    private String studentName;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "selectCourse",joinColumns = {@JoinColumn(name = "studentId",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "courseId",referencedColumnName = "id")})
    private Collection<Course> courses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return studentName;
    }

    public void setName(String studentName) {
        this.studentName = studentName;
    }

    public Collection<Course> getCourses() {
        return courses;
    }

    public void setCourses(Collection<Course> courses) {
        this.courses = courses;
    }
}
