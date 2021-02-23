package net.braun.blog.controller.page;

import net.braun.blog.Constants;
import net.braun.blog.controller.AbstractController;
import net.braun.blog.entity.Article;
import net.braun.blog.model.Items;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/search")
public class SearchController extends AbstractController {
    private static final long serialVersionUID = 8413866589679113670L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getParameter("query");
        if (StringUtils.isNotBlank(query)) {
            Items<Article> items = getBusinessService().listArticlesBySearchQuery(query, 0, Constants.LIMIT_ARTICLES_PER_PAGE);
            req.setAttribute("list", items.getItems());
            req.setAttribute("count", items.getCount());
            req.setAttribute("searchQuery", query);
            forwardToPage("search.jsp", req, resp);
        } else {
            resp.sendRedirect("/news");
        }
    }
}
