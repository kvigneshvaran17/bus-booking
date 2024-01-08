package com.busbooking.controller;

import com.busbooking.exception.BadRequestException;
import com.busbooking.model.user.User;
import com.busbooking.model.user.UserType;
import com.busbooking.service.user.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/")
public class BaseController {
    @Autowired
    UserServiceImpl userService;
    public void checkUserViewAddAccess(HttpServletRequest headers) throws  BadRequestException{
        String userId = headers.getHeader("user-id");
        if(userId == null) throw new BadRequestException("Header user-id not found");
        User user = userService.getUser(Integer.parseInt(userId)).orElse(null);
        if(user==null){
            throw new BadRequestException("User not found");
        }
    }

    public void checkUserEditAccess(HttpServletRequest headers) throws BadRequestException {
        String userId = headers.getHeader("user-id");
        if(userId == null) throw new BadRequestException("Header user-id not found");
        User user = userService.getUser(Integer.parseInt(userId)).orElse(null);
        if(user==null){
            throw new BadRequestException("User not found");
        }
        if(user.getUserType().equals(UserType.USER)){
            throw new BadRequestException("User not Accessed for this API");
        };
    }
}
