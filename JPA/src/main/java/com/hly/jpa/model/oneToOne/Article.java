package com.hly.jpa.model.oneToOne;

import javax.persistence.*;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/28
 */

@Entity
@Table(name = "article")
public class Article  {

    @Id
    @GeneratedValue
    @Column(name = "articleId")
    private int aricleId;
    @Column
    private String aricleName;
    @Column
    private String aricleContent;
    //双向一对一
    //todo mappedBy ="article"由article所属的类user维护关系，负责User外键articleId的更新
    @OneToOne(optional = false,cascade = CascadeType.ALL,mappedBy ="article" )
    private User user;

    public int getAricleId() {
        return aricleId;
    }

    public void setAricleId(int aricleId) {
        this.aricleId = aricleId;
    }

    public String getAricleName() {
        return aricleName;
    }

    public void setAricleName(String aricleName) {
        this.aricleName = aricleName;
    }

    public String getAricleContent() {
        return aricleContent;
    }

    public void setAricleContent(String aricleContent) {
        this.aricleContent = aricleContent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Article{" +
                "aricleId=" + aricleId +
                ", aricleName=" + aricleName +
                ", aricleContent=" + aricleContent +
                '}';
    }


}
