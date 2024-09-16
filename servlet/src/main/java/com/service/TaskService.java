package com.service;

import java.util.List;
import java.util.stream.Collectors;

import com.dao.TaskDao;
import com.dto.TaskDto;

public class TaskService {
    private static final TaskService INSTANCE = new TaskService();

    private TaskService(){

    }

    public static TaskService getInstance() {
        return INSTANCE;
    }
    
    private final TaskDao taskDao = TaskDao.getInstance();

    public List<TaskDto> findAllByUserId(Long userId){
        return taskDao.findAllByUserId(userId)
        .stream()
        .map(task -> new TaskDto(task.getId(), task.getTitle(), task.getCompleted(), task.getUserId()))
        .collect(Collectors.toList());
    }
}
