package com.hly.jpa.model.oneToManyByTableOfSingle;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/29
 */
@Entity
public class Author {
    @Id
    @GeneratedValue
    private int id;
    private String authorName;

    /**
     * Author和Book是一对多关系
     */
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    //name:public中间表一方的外键名称
    //referencedColumnName:public表的authorId外键参考了Author表的id主键
    @JoinTable(name = "public",joinColumns = {@JoinColumn(name = "authorId",referencedColumnName = "id")},
    //指定中间表多方外键
    //name:中间表多方外键的名称为bookId
    //referencedColumnName:bookId参考了book表的id主键
    inverseJoinColumns = {@JoinColumn(name = "bookId",referencedColumnName = "id")})

    private Collection<Book> books;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return authorName;
    }

    public void setName(String name) {
        this.authorName = name;
    }

    public int getAuthorId() {
        return id;
    }

    public void setAuthorId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}
