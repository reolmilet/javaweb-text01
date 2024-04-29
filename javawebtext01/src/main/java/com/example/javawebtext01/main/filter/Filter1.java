package com.example.javawebtext01.main.filter;

import com.example.javawebtext01.main.pojo.Userdata;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "Filter1",urlPatterns =
{"/questionText/*"})
public class Filter1 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String path = req.getRequestURI().substring(req.getContextPath().length());
        if (path.startsWith("/index")) {
            chain.doFilter(request, response);
            return;
        }
        Userdata userdata = (Userdata) session.getAttribute("userdata");
        if (userdata == null) {
            res.sendRedirect(((HttpServletRequest) request).getContextPath()+"/index.jsp");
            return;
        }

        chain.doFilter(request, response);
    }
}
