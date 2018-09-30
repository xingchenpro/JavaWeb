package com.hly.jpa.model.oneToManyByTableOfSingle;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/29
 */
public class Publish {

    private int authorId;
    private int bookId;

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "Publish{" +
                "authorId=" + authorId +
                ", bookId=" + bookId +
                '}';
    }
}
