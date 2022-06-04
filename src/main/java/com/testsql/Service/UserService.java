package com.testsql.Service;

import com.testsql.Dao.UserDao;
import com.testsql.pojo.User;

import java.util.ArrayList;

public class UserService {

    public UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void register() throws Exception { userDao.save(); }

    public void delete() throws Exception { userDao.delete(); }

    public User getUserById() throws Exception { return userDao.getUserById(); }

    public boolean logcheck() throws Exception { return userDao.logcheck(); }

    public ArrayList<User> fetchAll(int order) throws Exception {
        return userDao.fetchAll(order);
    }
}
