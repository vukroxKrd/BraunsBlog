package net.braun.blog.controller.page;

import net.braun.blog.Constants;
import net.braun.blog.controller.AbstractController;
import net.braun.blog.entity.Article;
import net.braun.blog.entity.Category;
import net.braun.blog.model.Items;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/news", "/news/*"})
public class NewsController extends AbstractController {

    private static final long serialVersionUID = 2776341816708522400L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestUrl = req.getRequestURI();
        Items<Article> items = null;
        if (requestUrl.endsWith("/news") || requestUrl.endsWith("/news/")) {
            items = getBusinessService().listArticles(0, Constants.LIMIT_ARTICLES_PER_PAGE);
        } else {
            String categoryUrl = requestUrl.replace("/news", "");
            items = getBusinessService().listArticlesByCategory(categoryUrl, 0, Constants.LIMIT_ARTICLES_PER_PAGE);
            Category category = getBusinessService().findCategoryByUrl(categoryUrl);
            req.setAttribute("selectedCategory", category);
        }
        req.setAttribute("list", items.getItems());
        forwardToPage("news.jsp", req, resp);
    }
}