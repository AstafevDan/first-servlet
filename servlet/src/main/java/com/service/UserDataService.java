package com.service;

import java.util.List;
import java.util.stream.Collectors;

import com.dao.UserDataDao;
import com.dto.UserDataDto;

public class UserDataService {
    private final static UserDataService userDataService = new UserDataService();

    public static UserDataService getUserdataservice() {
        return userDataService;
    }

    private final UserDataDao userDataDao = UserDataDao.getInstance();

    private UserDataService(){

    }

    public List<UserDataDto> findAll(){
        return userDataDao.findAll().stream()
        .map(userData -> new UserDataDto(userData.getId(), userData.getUsername(), userData.getEmail()))
        .collect(Collectors.toList());    
    }

    
}
