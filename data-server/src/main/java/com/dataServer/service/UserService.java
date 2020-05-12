package com.dataServer.service;

import com.common.util.Page4Navigator;
import com.dataServer.dao.UserDao;
import com.dataServer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {


    @Autowired
    UserDao userDao;

    public void save(User user){
        userDao.save(user);
    }

    public void delete(int id){
        userDao.delete(id);
    }

    public void update(User user){
        User temp = userDao.getOne(user.getId());
        temp.setUserAccount(user.getUserAccount());
        temp.setUserPassword(user.getUserPassword());
        userDao.save(temp);
    }


    public Page4Navigator<User> list(int start, int size,int navigatePages){

        PageRequest pageRequest = new PageRequest(start, size);
        Page<User> pageFromJpa = userDao.findAll(pageRequest);
          return   new Page4Navigator<>(pageFromJpa,navigatePages);

    }


    public List<User> findAll(){
        return   userDao.findAll();
    }

    public User get(int id){
        return userDao.findOne(id);    }
}
