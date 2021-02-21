package net.braun.blog.dao.mapper;

import net.braun.blog.entity.Article;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleMapper extends AbstractMapper<Article>{

    @Override
    public Article handleItem(ResultSet resultSet) throws SQLException {
        Article a = convert.toBean(resultSet, Article.class);
        a.setIdCategory(resultSet.getInt("id_category"));
        return a;
    }
}
