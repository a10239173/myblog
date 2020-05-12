package com.view.controller;

import com.common.util.Page4Navigator;
import com.common.vo.Result;
import com.common.vo.ResultCode;
import com.dataServer.entity.Role;
import com.view.service.ViewRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    ViewRoleService viewRoleService;

    @GetMapping(value = "/listRoleByPage")
    public Page4Navigator<Role> listRoleByPage(@RequestParam(value = "start",defaultValue = "0")int start,@RequestParam(value = "size",defaultValue = "5")int size){
        Page4Navigator<Role> rolePage4Navigator = viewRoleService.listRoleByPage(start, size);
        return rolePage4Navigator;
    }


    @DeleteMapping(value = "/{id}")
    public Result deleteRole(@PathVariable(value = "id")int id){

        viewRoleService.deleteRole(id);
        return new Result(ResultCode.SUCCESS);
    }


}
