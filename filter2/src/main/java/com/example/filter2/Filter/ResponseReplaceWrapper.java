package com.example.filter2.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class ResponseReplaceWrapper extends HttpServletResponseWrapper {
    private CharArrayWriter charArrayWriter=new CharArrayWriter();
    public ResponseReplaceWrapper(HttpServletResponse response) {
        super(response);
    }

    public PrintWriter getWriter() throws IOException{
        return new PrintWriter(charArrayWriter);
    }

    public CharArrayWriter getCharArrayWriter(){
        return charArrayWriter;
    }
}
