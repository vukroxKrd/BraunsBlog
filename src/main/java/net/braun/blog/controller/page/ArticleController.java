package net.braun.blog.controller.page;

import net.braun.blog.Constants;
import net.braun.blog.controller.AbstractController;
import net.braun.blog.entity.Article;
import net.braun.blog.entity.Comment;
import net.braun.blog.exception.RedirectToValidUrlException;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/article/*")
public class ArticleController extends AbstractController {
    private static final long serialVersionUID = 4203908778119760106L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestUrl = req.getRequestURI();
        try {
            String id = StringUtils.split(requestUrl, "/")[1];
            Article article = getBusinessService().viewArticle(Long.parseLong(id), requestUrl);
            if (article == null) {
                resp.sendRedirect("/404?url="+requestUrl);
            } else {
                req.setAttribute("article", article);
                List<Comment> comments = getBusinessService().listComments(article.getId(),0, Constants.LIMIT_COMMENTS_PER_PAGE);
                req.setAttribute("comments", comments);
                forwardToPage("article.jsp", req, resp);
            }
        }catch (RedirectToValidUrlException e) {
            resp.sendRedirect(e.getUrl());
        }catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            resp.sendRedirect("/404?url="+requestUrl);
        }
    }
}
