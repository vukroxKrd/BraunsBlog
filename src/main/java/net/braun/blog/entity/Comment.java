package net.braun.blog.entity;

import java.sql.Timestamp;

public class Comment extends AbstractEntity<Long> {
    private Long idArticle;
    private Account account;
    private String content;
    private Timestamp created;

    public Comment(Long idArticle, Account account, String content, Timestamp created) {
        this.idArticle = idArticle;
        this.account = account;
        this.content = content;
        this.created = created;
    }

    public Comment() {
    }

    public Long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }
}
