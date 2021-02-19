package net.braun.blog.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "ErrorHandlerFilter", urlPatterns = "/")
public class ErrorHandlerFilter extends AbstractFilter {

    public void doFilter(HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Throwable th) {
            String requestUrl = servletRequest.getRequestURI();
            LOGGER.error("Error during the request: " + requestUrl, th);
            if (requestUrl.startsWith("/ajax")) {
                servletResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            } else if (!requestUrl.startsWith("/error")) {
                servletResponse.sendRedirect("/error");
            } else {
                throw new ServletException();
            }
        }
    }
}
