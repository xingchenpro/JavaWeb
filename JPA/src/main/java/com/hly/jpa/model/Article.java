package com.hly.jpa.model;

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

    @Override
    public String toString() {
        return "Article{" +
                "aricleId=" + aricleId +
                ", aricleName=" + aricleName +
                ", aricleContent=" + aricleContent +
                '}';
    }


}
