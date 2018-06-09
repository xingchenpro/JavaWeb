package com.hly.java.Reflect;

/**
 * @author :hly
 * @date :2018/6/9
 */
public class Person extends God implements evil{
    public String name;
    private String age;
    private String profession;

    public Person(String name, String age, String profession) {
        this.name = name;
        this.age = age;
        this.profession = profession;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public void evil() {

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }
}
