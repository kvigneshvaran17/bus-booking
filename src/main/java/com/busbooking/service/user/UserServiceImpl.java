package com.busbooking.service.user;

import com.busbooking.dao.UserDao;
import com.busbooking.model.user.User;
import com.busbooking.model.user.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Optional<User> getUser(int id) {
        return userDao.findById(id);
    }

    @Override
    public UserStatus addUser(User userData) {
        Optional<User> userOptional = userDao.findByLoginId(userData.getLoginId());
        if(userOptional.isPresent()){
            return new UserStatus(400, "Username already present", null);
        }
        User user = userDao.save(userData);
        return new UserStatus(200, "User added", user);
    }

    @Override
    public UserStatus validateUser(User userData) {
        Optional<User> userOptional = userDao.findByLoginId(userData.getLoginId());
        User user = userOptional.orElse(null);
        UserStatus userStatus = new UserStatus(404, "Not found", null);
        if(user!=null){
            if(user.getPassword().equals(userData.getPassword())){
                userStatus = new UserStatus(200, "Authenticated successfully", user);
            } else{
                userStatus = new UserStatus(404, "Password mismatch", null);
            }
        }
        return userStatus;
    }
}
