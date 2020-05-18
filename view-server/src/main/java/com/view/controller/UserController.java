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

    @PostMapping(value = "/addUser")
    public Result add(@RequestBody User user){
        viewUserService.add(user);
        return new Result(ResultCode.SUCCESS);
    }


    @DeleteMapping(value = "/deleteUser/{id}")
    public void delete(@PathVariable(value = "id")  int id){
        viewUserService.deleteUser(id);

    }

    @GetMapping(value = "/getUser/{id}")
    public Result get(@PathVariable(value = "id")int id){
        User user = viewUserService.get(id);
        return new Result(ResultCode.SUCCESS,user);
    }

    @PutMapping(value = "/updateUser/{id}")
    public Result update(@PathVariable(value = "id")int id,@RequestBody User user){

        viewUserService.update(id,user);
        return new Result(ResultCode.SUCCESS);

    }




}
