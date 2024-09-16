package com.myservlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.dto.TaskDto;
import com.service.TaskService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/tasks")
public class TaskServlet extends HttpServlet{
    private final TaskService taskService = TaskService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long userId = Long.valueOf(req.getParameter("userId"));

        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try (var writer = resp.getWriter()) {
            writer.write("<h1>Задачи пользователя</h1>");
            writer.write("<ul>");
            List<TaskDto> list = taskService.findAllByUserId(userId);
            for (TaskDto l : list){
                writer.write(String.format("<li>%s</li>", l.getTitle()));
            }
            writer.write("</ul>");
        }
    }
}
