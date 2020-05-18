package com.view.service;

import com.common.util.Page4Navigator;
import com.common.vo.Result;
import com.common.vo.ResultCode;
import com.dataServer.entity.User;
import com.view.client.ClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewUserService {

    @Autowired
   ClientFeign clientFeign;


    public List<User> findAll(){
        return clientFeign.findAll();
    }

  public Page4Navigator<User> list(int start, int size)
  {
        return clientFeign.list(start,size);
    }

    public void deleteUser(int id){
            clientFeign.deleteUser(id);

    }

    public void add(User user){
        clientFeign.add(user);
    }

    public User get(int id){
       return clientFeign.get(id);
    }

    public void update(int id,User user){
        clientFeign.update(id,user);
    }


}
