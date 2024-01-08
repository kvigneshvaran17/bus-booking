package com.busbooking.controller;


import com.busbooking.model.user.User;
import com.busbooking.model.user.UserStatus;
import com.busbooking.service.user.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends BaseController{

    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping("user/addUser")
    public ResponseEntity<UserStatus> addUser(@RequestBody User user, HttpServletRequest httpServletRequest) throws BadRequestException {
        checkUserEditAccess(httpServletRequest);
        return new ResponseEntity<>(userServiceImpl.addUser(user), HttpStatus.OK);
    }
    @PostMapping("user/validateUser")
    public ResponseEntity<UserStatus> validateUser(@RequestBody User user, HttpServletRequest httpServletRequest) throws BadRequestException {
        checkUserEditAccess(httpServletRequest);
        return new ResponseEntity<>(userServiceImpl.validateUser(user), HttpStatus.OK);
    }
}
