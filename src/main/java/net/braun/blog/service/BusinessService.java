package net.braun.blog.service;

import net.braun.blog.entity.Article;
import net.braun.blog.entity.Category;
import net.braun.blog.entity.Comment;
import net.braun.blog.exception.RedirectToValidUrlException;
import net.braun.blog.model.Items;

import java.util.List;
import java.util.Map;

public interface BusinessService {

    Map<Integer, Category> mapCategories();

    Items<Article> listArticles(int offset, int limit);

    Items<Article> listArticlesByCategory(String categoryUrl, int offset, int limit);

    //return null if entity not found
    Category findCategoryByUrl(String categoryUrl);

    Items<Article> listArticlesBySearchQuery(String searchQuery, int offset, int limit);
    //return null if entity not found by id article
    Article viewArticle (Long idArticle, String requestUrl) throws RedirectToValidUrlException;

    List<Comment> listComments(long idArticle, int offset, int limit);
}
