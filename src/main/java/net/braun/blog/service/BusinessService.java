package net.braun.blog.service;

import net.braun.blog.entity.Article;
import net.braun.blog.entity.Category;
import net.braun.blog.model.Items;

import java.util.Map;

public interface BusinessService {

    Map<Integer, Category> mapCategories();

    Items<Article> listArticles(int offset, int limit);
}
