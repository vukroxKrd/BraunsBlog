package net.braun.blog.controller.page;

import net.braun.blog.controller.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/error", "/404"})
public class ErrorController extends AbstractController {

    private static final long serialVersionUID = -28581472654078282L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean is404 ="/404".equals(req.getRequestURI());
        req.setAttribute("is404", is404);
        req.setAttribute("url", req.getParameter("url"));
        forwardToPage("error.jsp",req,resp);
    }
}
