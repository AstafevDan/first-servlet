<%@ page import="com.service.TaskService" %>
<%@ page import="com.dto.TaskDto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Задачи пользователя:</h1>
    <ul>
    <%
        Long flightId = Long.valueOf(request.getParameter("userId"));
        List<TaskDto> tickets = TaskService.getInstance().findAllByUserId(flightId);
        for (TaskDto ticket : tickets) {
            out.write(String.format("<li>%s</li>", ticket.getTitle()));
        }
    %>
    </ul>
</body>
</html>