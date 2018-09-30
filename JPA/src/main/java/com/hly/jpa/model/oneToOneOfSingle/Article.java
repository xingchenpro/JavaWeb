package com.hly.jpa.model.oneToOneOfSingle;
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
    private int article;
    @Column
    private String articleName;
    @Column
    private String articleContent;

    public int getAricleId() {
        return article;
    }

    public void setAricleId(int article) {
        this.article = article;
    }

    public String getAricleName() {
        return articleName;
    }

    public void setAricleName(String articleName) {
        this.articleName = articleName;
    }

    public String getAricleContent() {
        return articleContent;
    }

    public void setAricleContent(String articleContent) {
        this.articleContent = articleContent;
    }


}
