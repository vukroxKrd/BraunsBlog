package net.braun.blog.service;

import net.braun.blog.entity.Category;

import java.util.Map;

public interface BusinessService {

    Map<Integer, Category> mapCategories();
}
