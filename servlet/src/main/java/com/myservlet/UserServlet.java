package com.myservlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import com.service.UserDataService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/users")
public class UserServlet extends HttpServlet{

    private final UserDataService userDataService = UserDataService.getUserdataservice();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try (var writer = resp.getWriter()) {
            
            writer.write("<h1>Список пользователей</h1>");
            writer.write("<ul>");
            userDataService.findAll().forEach(userDto -> {
                writer.write("""
                        <li>
                            <a href="/servlet-1.1/tasks?userId=%d">%s-%s</a>
                        </li>
                        """.formatted(userDto.getId(), userDto.getUsername(), userDto.getEmail())
                );
            });        
            writer.write("</ul>");
        }
    }
}
