package com.hly.java.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author :hly
 * @date :2018/6/9
 */
public class PersonMain {
    public static void main(String[] arv) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //返回一个类型为Class的对象
        Class per = new Person().getClass();
        System.out.println("得到该类的包名:" + per.getPackage());//得到该类的包名
        System.out.println("得到该类的名称:" + per.getName());
        System.out.println("得到该类继承的类:" + per.getSuperclass());


        //返回Constructor对象
        Constructor conPerson = per.getDeclaredConstructor(String.class, String.class, String.class);
        //构造方法修饰为private，则不允许newInstance创建对象，如果先执行该方法设置为true,则允许
        conPerson.setAccessible(true);
        //通过该构造方法用指定的参数创建一个对象，如果未设置参数，采用无参数方法，连接jdbc用到的
        Person hly =(Person)conPerson.newInstance("hly", "28", "架构师");
        System.out.println("hly对象为:"+hly);



    }
}
