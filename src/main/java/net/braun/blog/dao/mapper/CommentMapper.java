package net.braun.blog.dao.mapper;

import net.braun.blog.entity.Account;
import net.braun.blog.entity.Comment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentMapper extends AbstractMapper<Comment>{
    private final boolean hasAccountData;

    public CommentMapper(boolean hasAccountData) {
        super();
        this.hasAccountData = hasAccountData;
    }

    @Override
    public Comment handleItem(ResultSet resultSet) throws SQLException {
        Comment comment =convert.toBean(resultSet, Comment.class);
        comment.setIdArticle(resultSet.getLong("id_article"));
        if (hasAccountData){
            Account account = convert.toBean(resultSet,Account.class);
            account.setId(resultSet.getLong("id_account"));
            account.setCreated(resultSet.getTimestamp("accountCreated"));
            comment.setAccount(account);
        }
        return comment;
    }
}
