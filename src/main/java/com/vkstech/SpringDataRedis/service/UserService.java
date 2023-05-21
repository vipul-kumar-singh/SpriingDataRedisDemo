package com.vkstech.SpringDataRedis.service;

import com.vkstech.SpringDataRedis.model.User;

public interface UserService {

    User createUser(String name, long followers);

    User getUserById(String userId);

    User updateUser(String userId, String name, long followers);

    void deleteUserById(String userId);
}
