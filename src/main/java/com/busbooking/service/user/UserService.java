package com.busbooking.service.user;

import com.busbooking.model.user.User;
import com.busbooking.model.user.UserStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    Optional<User> getUser(int id);
    UserStatus addUser(User user);
    UserStatus validateUser(User user);
}
