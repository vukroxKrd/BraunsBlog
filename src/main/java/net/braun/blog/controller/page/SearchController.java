package net.braun.blog.controller.page;

import net.braun.blog.Constants;
import net.braun.blog.controller.AbstractController;
import net.braun.blog.entity.Article;
import net.braun.blog.model.Items;
import net.braun.blog.model.Pagination;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/search")
public class SearchController extends AbstractController {
    private static final long serialVersionUID = 8413866589679113670L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getParameter("query");
        if (StringUtils.isNotBlank(query)) {
            int offset = getOffset(req, Constants.LIMIT_ARTICLES_PER_PAGE);
            Items<Article> items = getBusinessService().listArticlesBySearchQuery(query, offset, Constants.LIMIT_ARTICLES_PER_PAGE);
            req.setAttribute("list", items.getItems());
            req.setAttribute("count", items.getCount());
            req.setAttribute("searchQuery", query);
            Pagination pagination = new Pagination.Builder("/search?query=" + URLEncoder.encode(query, "utf8") + "&",
                    offset, items.getCount()).withLimit(Constants.LIMIT_ARTICLES_PER_PAGE).build();
            req.setAttribute("pagination", pagination);
            forwardToPage("search.jsp", req, resp);
        } else {
            resp.sendRedirect("/news");
        }
    }
}
