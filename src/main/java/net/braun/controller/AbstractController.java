package net.braun.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AbstractController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    public final void forwardToPage(String jspPage, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("currentPage", "page/"+jspPage);
        request.getRequestDispatcher("/WEB-INF/JSP/page-template.jsp").forward(request, response);
    }

    public final void forwardToFragment(String jspPage, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("currentPage", jspPage);
        request.getRequestDispatcher("/WEB-INF/JSP/fragment/"+jspPage).forward(request, response);
    }
}
