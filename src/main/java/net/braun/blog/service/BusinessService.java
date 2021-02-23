package net.braun.blog.service;

import net.braun.blog.entity.Article;
import net.braun.blog.entity.Category;
import net.braun.blog.model.Items;

import java.util.Map;

public interface BusinessService {

    Map<Integer, Category> mapCategories();

    Items<Article> listArticles(int offset, int limit);

    Items<Article> listArticlesByCategory(String categoryUrl, int offset, int limit);

    Category findCategoryByUrl(String categoryUrl);

    Items<Article> listArticlesBySearchQuery(String searchQuery, int offset, int limit);
}
