package com.view.controller;

import com.common.util.Page4Navigator;
import com.common.vo.Result;
import com.common.vo.ResultCode;
import com.dataServer.entity.User;
import com.view.service.ViewUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    ViewUserService viewUserService;

    @GetMapping("/showUsers")
    public Result findAll(){
        List<User> users = viewUserService.findAll();
        return new Result(ResultCode.SUCCESS,users);
    }

   @GetMapping("/showUsersPage")
    public  Page4Navigator<User> list(@RequestParam(value = "start",defaultValue = "0")int start,@RequestParam(value = "size",defaultValue = "5")int size){
       Page4Navigator<User> list = viewUserService.list(start, size);

       return list;

    }


    @DeleteMapping(value = "/deleteUser/{id}")
    public void delete(@PathVariable(value = "id")  int id){
        viewUserService.deleteUser(id);

    }


}
