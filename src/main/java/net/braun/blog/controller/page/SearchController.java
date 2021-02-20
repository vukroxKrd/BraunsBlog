package net.braun.blog.controller.page;

import net.braun.blog.controller.AbstractController;

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
        forwardToPage("search.jsp", req, resp);
    }
}
