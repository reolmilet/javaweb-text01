
package com.example.filter2.Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

@WebFilter(
        description="内容替换过滤器",
        filterName = "ReplaceFilter",
        urlPatterns = {"/*"},
        initParams = {@WebInitParam(name = "filePath",value = "replace_ZH.properties")}
)
public class ReplaceFilter implements Filter {
    private Properties propert=new Properties();
    public void init(FilterConfig filterConfig) throws ServletException {
        String filePath=filterConfig.getInitParameter("filePath");
        try {
            propert.load(ReplaceFilter.class.getClassLoader().getResourceAsStream(filePath));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
           e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse res=(HttpServletResponse) response;

        ResponseReplaceWrapper resp=new ResponseReplaceWrapper(res);
        chain.doFilter(request,resp);
        String outString=resp.getCharArrayWriter().toString();
        for(Object o:propert.keySet()){
            String key=(String) o;
            outString=outString.replace(key,propert.getProperty(key));
        }
        PrintWriter out=res.getWriter();
        out.write(outString);
    }
    public void destroy() {
    }
}

