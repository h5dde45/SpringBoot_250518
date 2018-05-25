package ru.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Article implements Serializable, Comparable<Article> {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String title;
    @Column(length = 1000_000)
    private String content;
    @Column
    private long creationTimestamp;

    public Article() {
    }

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
        this.creationTimestamp = System.currentTimeMillis();
    }

    @Override
    public int compareTo(Article that) {
        return Long.compare(this.creationTimestamp, that.creationTimestamp);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
