package com.dataServer.controller;

import com.common.util.Page4Navigator;
import com.common.vo.Result;
import com.common.vo.ResultCode;
import com.dataServer.entity.Role;
import com.dataServer.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "",method = RequestMethod.POST)
    public void add(@RequestBody Role role){
        roleService.add(role);

    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id")int id){
        roleService.delete(id);

    }

    @RequestMapping(value = "",method = RequestMethod.PUT)
    public void update(@RequestBody Role role){
        roleService.update(role);

    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result getOne(@PathVariable(value = "id")int id){
        Role role = roleService.get(id);
        return new Result(ResultCode.SUCCESS,role);
    }

  /*  @RequestMapping(value = "",method = RequestMethod.GET)
    public Result listALL(){

        List<Role> roles = roleService.listAll();
        return new Result(ResultCode.SUCCESS,roles);

    }*/

    @RequestMapping(value = "",method = RequestMethod.GET)
    public Page4Navigator<Role> listByPage(@RequestParam(value = "start")int start,@RequestParam(value = "size")int size){

        Page4Navigator<Role> rolePage4Navigator = roleService.listByPage(start, size, 5);
        return rolePage4Navigator;


    }


}
