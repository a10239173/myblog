package com.view.client;

import com.common.util.Page4Navigator;
import com.common.vo.Result;
import com.dataServer.entity.Role;
import com.dataServer.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "DATA-SERVER")
public interface ClientFeign {

    /*
    * user
    * */
    @GetMapping(value = "/user/findAll")
    public List<User> findAll();

   @GetMapping(value = "/user")
    public Page4Navigator<User> list(@RequestParam("start") int start, @RequestParam("size") int size);

   @DeleteMapping(value = "/user/{id}")
   public void deleteUser(@PathVariable(value = "id")int id);

   @PostMapping(value = "/user")
   public void add(@RequestBody User user);

   @GetMapping(value = "/user/{id}")
   public User get(@PathVariable(value = "id")int id);

   @PutMapping(value = "/user/{id}")
   public void update(@PathVariable(value = "id")int id,@RequestBody User user);

   /*
   * role角色
   * */

   @GetMapping("/role")
   public Page4Navigator<Role> listRoleByPage(@RequestParam(value = "start")int start, @RequestParam(value = "size")int size);

   @DeleteMapping(value = "/role/{id}")
    public void deleteRole(@PathVariable(value = "id")int id);

}
