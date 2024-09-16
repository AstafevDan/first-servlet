package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.entity.UserData;
import com.util.ConnectionManager;

public class UserDataDao implements Dao<Long, UserData>{

    private final static UserDataDao INSTANCE = new UserDataDao();

    public static UserDataDao getInstance() {
        return INSTANCE;
    }

    private UserDataDao(){
        
    }

    private final static String FIND_ALL = """
            SELECT * 
            FROM todolist.user_data
            """;

    @Override
    public boolean delete(Long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<UserData> findAll() {
        try (var connection = ConnectionManager.open();
        var statement = connection.prepareStatement(FIND_ALL)) {
            var resultSet = statement.executeQuery();
            List<UserData> users = new ArrayList<>();

            while (resultSet.next()) {
                users.add(buildUser(resultSet));
            }

            return users;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    private UserData buildUser(ResultSet resultSet) throws SQLException {
        return new UserData(
            resultSet.getObject("id", Long.class),
            resultSet.getObject("username", String.class),
            resultSet.getObject("userpassword", String.class),
            resultSet.getObject("email", String.class)
        );
    }

    @Override
    public Optional<UserData> findById(Long id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public UserData save(UserData entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(UserData entity) {
        // TODO Auto-generated method stub
        
    }

}
