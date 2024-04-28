package com.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

@WebFilter(
        filterName = "Filter2",
        urlPatterns = {"*.do"}
        ,initParams = {
        @WebInitParam(name = "filePath", value = "replace_ZH.properties")
}

)
public class Filter2 implements Filter {
    private Properties properties = new Properties();

    public void init(FilterConfig filterConfig) throws ServletException {

        String filePath = filterConfig.getInitParameter("filePath");
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);

    }

    public void destroy() {
    }

//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        HttpServletResponse res = (HttpServletResponse) response;
//        ResponseReplaceWrapper resp = new ResponseReplaceWrapper(res);
//        chain.doFilter(request, resp);
//        String outString = resp.getCharArrayWriter().toString();
//        for (Object o : properties.keySet()) {
//            String key = (String) o;
//            outString = outString.replace(key, properties.getProperty(key));
//        }
//        PrintWriter out = response.getWriter();
//        out.write(outString);
//    }
}
