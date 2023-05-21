package com.vkstech.SpringDataRedis.service.impl;

import com.vkstech.SpringDataRedis.model.User;
import com.vkstech.SpringDataRedis.repository.UserRepository;
import com.vkstech.SpringDataRedis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(String name, long followers) {
        LOG.info("UserService::createUser");
        User user = new User(name, followers);
        return userRepository.save(user);
    }

    @Override
    public User getUserById(String userId) {
        LOG.info("UserService::getUserById, userId = {}", userId);
        return userRepository.findById(Long.valueOf(userId)).get();
    }

    @Override
    public User updateUser(String userId, String name, long followers) {
        LOG.info("UserService::updateUser, userId = {}", userId);
        User user = getUserById(userId);
        user.setName(name);
        user.setFollowers(followers);
        return userRepository.save(user);
    }

    @Override
    @Transactional
    @Modifying
    public void deleteUserById(String userId) {
        LOG.info("UserService::deleteUserById, userId = {}", userId);
        userRepository.deleteById(Long.valueOf(userId));
    }


}
