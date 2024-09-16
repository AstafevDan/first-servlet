package com.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.entity.Task;
import com.util.ConnectionManager;

public class TaskDao implements Dao<Long, Task>{
    private static final TaskDao INSTANCE = new TaskDao();

    private final static String FIND_ALL_BY_USER_ID = """
            SELECT * 
            FROM todolist.task
            WHERE user_id = ?
            """;

    private TaskDao(){}

    public static TaskDao getInstance() {
        return INSTANCE;
    }

    public List<Task> findAllByUserId(Long userId){
        try (var connection = ConnectionManager.open();
        var statement = connection.prepareStatement(FIND_ALL_BY_USER_ID)) {
            statement.setObject(1, userId);
            var resultSet = statement.executeQuery();
            List<Task> list = new ArrayList<>(); 
            while (resultSet.next()) {
                list.add(buildTask(resultSet));
            }

            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Task buildTask(ResultSet resultSet) throws SQLException {
        return new Task(
            resultSet.getObject("id", Long.class),
            resultSet.getObject("title", String.class),
            resultSet.getObject("completed", BigDecimal.class),
            //resultSet.getObject("task_date", Timestamp.class).toLocalDateTime(),
            resultSet.getObject("category_id", Long.class),
            resultSet.getObject("priority_id", Long.class),
            resultSet.getObject("user_id", Long.class)
        );
    }

    @Override
    public boolean delete(Long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Task> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Task> findById(Long id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public Task save(Task entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(Task entity) {
        // TODO Auto-generated method stub
        
    }
    
}
