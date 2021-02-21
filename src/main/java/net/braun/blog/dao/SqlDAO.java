package net.braun.blog.dao;

import net.braun.blog.dao.mapper.ArticleMapper;
import net.braun.blog.dao.mapper.ListMapper;
import net.braun.blog.dao.mapper.MapCategoryMapper;
import net.braun.blog.entity.Article;
import net.braun.blog.entity.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public final class SqlDAO {
    private final QueryRunner sql = new QueryRunner();

    public Map<Integer, Category> mapCategories(Connection connection) throws SQLException {
        return sql.query(connection, "select * from category", new MapCategoryMapper());
    }

    public List<Article> listArticles(Connection c, int offset, int limit) throws SQLException{
        return sql.query(c, "select * from article a order by a.id desc limit ? offset ?", new ListMapper<>(new ArticleMapper()), limit, offset);
    }
    public int countArticles(Connection c) throws SQLException{
        return sql.query(c, "select count(*) from article a", new ScalarHandler<Number>()).intValue();
    }
}