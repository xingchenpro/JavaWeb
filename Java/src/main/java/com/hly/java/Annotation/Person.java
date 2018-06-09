package com.hly.java.Annotation;

/**
 * @author :hly
 * @date :2018/6/9
 */
//使用注解
@PersonAnnotation
public class Person {
    @PersonAnnotation(name = "hly",type = String.class)//注解字段
    private String name;
    private String profession;
    @PersonAnnotation(name = "hly",type = String.class)//注解构造方法
    public Person() {
    }
    @PersonAnnotation(name = "hly",type = String.class)
    public String getName() {
        return name;
    }

    public void setName(@PersonAnnotation(name = "hly",type = String.class)String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
