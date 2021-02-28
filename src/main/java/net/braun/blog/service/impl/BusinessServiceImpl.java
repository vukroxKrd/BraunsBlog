package net.braun.blog.service.impl;

import net.braun.blog.dao.SqlDAO;
import net.braun.blog.entity.Article;
import net.braun.blog.entity.Category;
import net.braun.blog.exception.ApplicationException;
import net.braun.blog.exception.RedirectToValidUrlException;
import net.braun.blog.model.Items;
import net.braun.blog.service.BusinessService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

class BusinessServiceImpl implements BusinessService {

    private final DataSource dataSource;
    private final SqlDAO sql;

    BusinessServiceImpl(ServiceManager serviceManager) {
        super();
        this.dataSource = serviceManager.dataSource;
        this.sql = new SqlDAO();
    }

    @Override
    public Map<Integer, Category> mapCategories() {
        try (Connection c = dataSource.getConnection()) {
            Map<Integer, Category> categoryMap = sql.mapCategories(c);
            return categoryMap;
        } catch (SQLException throwables) {
            throw new ApplicationException("Can't execute db (Mapping Categories) command: " + throwables.getMessage());
        }
    }

    @Override
    public Items<Article> listArticles(int offset, int limit) {
        try (Connection c = dataSource.getConnection()) {
            Items<Article> items = new Items<>();
            items.setItems(sql.listArticles(c, offset, limit));
            items.setCount(sql.countArticles(c));
            return items;
        } catch (SQLException e) {
            throw new ApplicationException("Can not get Articles from a data base: " + e.getMessage(), e);
        }
    }

    @Override
    public Items<Article> listArticlesByCategory(String categoryUrl, int offset, int limit) {
        try (Connection c = dataSource.getConnection()) {
            Items<Article> items = new Items<>();
            items.setItems(sql.listArticlesByCategory(c, categoryUrl, offset, limit));
            items.setCount(sql.countArticlesByCategory(c, categoryUrl));
            return items;
        } catch (SQLException e) {
            throw new ApplicationException("Can not get Articles by Categories from a data base: " + e.getMessage(), e);
        }
    }

    @Override
    public Category findCategoryByUrl(String categoryUrl) {
        try (Connection c = dataSource.getConnection()) {
            return sql.findCategoryByUrl(c, categoryUrl);
        } catch (SQLException throwables) {
            throw new ApplicationException("Can't execute db (findCategoryByUrl) command: " + throwables.getMessage());
        }
    }

    @Override
    public Items<Article> listArticlesBySearchQuery(String searchQuery, int offset, int limit) {
        try (Connection c = dataSource.getConnection()) {
            Items<Article> items = new Items<>();
            items.setItems(sql.listArticlesBySearchQuery(c, searchQuery, offset, limit));
            items.setCount(sql.countArticlesBySearchQuery(c, searchQuery));
            return items;
        } catch (SQLException e) {
            throw new ApplicationException("Can not get Articles by Search from a data base: " + e.getMessage(), e);
        }
    }

    @Override
    public Article viewArticle(Long idArticle, String requestUrl) throws RedirectToValidUrlException {
        try(Connection c = dataSource.getConnection()) {
            Article article = sql.findArticleById(c,idArticle);
            if (article == null) {
                return null;
            }
            if (!article.getArticleLink().equals(requestUrl)){
                throw new RedirectToValidUrlException(article.getArticleLink());
            } else {
                article.setViews(article.getViews()+1);
                sql.updateArticleViews(c,article);
                c.commit();
                return article;
            }
        } catch (SQLException sqlException) {

        }
        return null;
    }
}

