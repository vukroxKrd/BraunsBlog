package net.braun.blog.dao;

import net.braun.blog.dao.mapper.ArticleMapper;
import net.braun.blog.dao.mapper.ListMapper;
import net.braun.blog.dao.mapper.MapCategoryMapper;
import net.braun.blog.entity.Article;
import net.braun.blog.entity.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
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

    public List<Article> listArticles(Connection c, int offset, int limit) throws SQLException {
        return sql.query(c, "select * from article a order by a.id desc limit ? offset ?", new ListMapper<>(new ArticleMapper()), limit, offset);
    }

    public int countArticles(Connection c) throws SQLException {
        return sql.query(c, "select count(*) from article a", new ScalarHandler<Number>()).intValue();
    }

    public List<Article> listArticlesByCategory(Connection c, String categoryUrl, int offset, int limit) throws SQLException {
        return sql.query(c, "select a.* from article a, category c where c.id=a.id_category and c.url=? order by a.id desc limit ? offset ?",
                new ListMapper<>(new ArticleMapper()), categoryUrl, limit, offset);
    }

    public int countArticlesByCategory(Connection c, String categoryUrl) throws SQLException {
        return sql.query(c, "select count(a.id) from article a, category c where a.id_category=c.id and c.url=?",
                new ScalarHandler<Number>(), categoryUrl).intValue();
    }

    public Category findCategoryByUrl(Connection c, String categoryUrl) throws SQLException {
        return sql.query(c, "select * from category c where c.url = ?",
                new BeanHandler<>(Category.class), categoryUrl);
    }

    public List<Article> listArticlesBySearchQuery(Connection c, String searchQuery, int offset, int limit) throws SQLException {
        String q = "%" + searchQuery + "%";
        return sql.query(c, "select * from article a where (a.title ilike ? or a.content ilike ?) order by a.id desc limit ? offset ?",
                new ListMapper<>(new ArticleMapper()), q, q, limit, offset);
    }

    public int countArticlesBySearchQuery(Connection c, String searchQuery) throws SQLException {
        String q = "%" + searchQuery + "%";
        return new QueryRunner().query(c, "select count(a.id) from article a where (a.title ilike ? or a.content ilike ?)", new ScalarHandler<Number>(), q, q).intValue();
    }
}
