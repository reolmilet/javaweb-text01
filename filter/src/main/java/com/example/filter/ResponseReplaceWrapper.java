package com.example.filter;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


public class ResponseReplaceWrapper extends HttpServletResponseWrapper {
    private CharArrayWriter charWriter = new CharArrayWriter();
    public ResponseReplaceWrapper(HttpServletResponse response) {
        super(response);
    }
    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(charWriter);
    }
    public CharArrayWriter getCharArrayWriter() {
        return charWriter;
    }
}