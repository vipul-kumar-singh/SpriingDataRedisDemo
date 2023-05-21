package com.vkstech.SpringDataRedis.controller;

import com.vkstech.SpringDataRedis.UserDto;
import com.vkstech.SpringDataRedis.model.User;
import com.vkstech.SpringDataRedis.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @PostMapping()
    public User addUser(@RequestBody UserDto userDto) {
        LOG.info("UserController::addUser");
        return userService.createUser(userDto.getName(), userDto.getFollowers());
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId) {
        LOG.info("UserController::getUser, userId = {}", userId);
        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable String userId, @RequestBody UserDto userDto) {
        LOG.info("UserController::updateUser, userId = {}", userId);
        return userService.updateUser(userId, userDto.getName(), userDto.getFollowers());
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        LOG.info("UserController::deleteUser, userId = {}", userId);
        userService.deleteUserById(userId);
        return "User Deleted Successfully";
    }
}