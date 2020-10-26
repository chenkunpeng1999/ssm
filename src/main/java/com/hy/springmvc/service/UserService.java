package com.hy.springmvc.service;

import com.hy.springmvc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    /*@Autowired
    private UserDao userDao;

    public List<User> query(){
        return userDao.query();
    }

    public Integer queryByName(User user){
        return userDao.queryByName(user);
    }*/

}
