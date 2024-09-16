package com.myservlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cookies")
public class CookieServlet extends HttpServlet{

    private static final String UNIQUE_ID = "userId";
    private final AtomicInteger counter = new AtomicInteger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var cookies = req.getCookies();
        if (cookies == null || Arrays.stream(cookies)
        .filter(cookie -> UNIQUE_ID.equals(cookie.getName()))
        .findFirst()
        .isEmpty()) {
            var cookie = new Cookie(UNIQUE_ID, "34");
            cookie.setMaxAge(20 * 60);
            cookie.setPath("/servlet-1.1/cookies");
            resp.addCookie(cookie);
            counter.incrementAndGet();
        }    
        resp.setContentType("text/html");
        try (var writer = resp.getWriter()) {
            writer.write("<span>"+counter.get()+"</span>");
        }
    }
}
