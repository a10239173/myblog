package com.dataServer.controller;


import com.common.util.ListPageUtil;
import com.common.util.Page4Navigator;
import com.common.vo.Result;
import com.common.vo.ResultCode;
import com.dataServer.entity.User;
import com.dataServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    UserService userService;


    /*
     *存储user，顺便存储redis
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void add(@RequestBody User user) {
        userService.save(user);

        ListOperations listOperations = redisTemplate.opsForList();
        listOperations.leftPush("user", user);


    }


    /*
     *根据id删除user，顺便删除redis
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") int id) {
        userService.delete(id);
        this.refresh();
        /*return new Result(ResultCode.SUCCESS);*/
    }


    /*
     *更新user，顺便更新redis
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable(value = "id") int id, @RequestBody User user) {


        user.setId(id);
        userService.update(user);


    }

    /*
     *遍历所有user数据，并分页，会先从redis获取数据，利用ListPageUtil对从redis获取的数据集合进行分页
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Page4Navigator<User> list(@RequestParam("start") int start, @RequestParam("size") int size) {


        /*ListOperations listOperations = redisTemplate.opsForList();
        List users = listOperations.range("user", 0, -1);
        if (users.size() != 0) {
            ListPageUtil<User> pages = new ListPageUtil<User>(users, start, size);
            List<User> pagesUsers = pages.getData();
            return null;
        } else {*/
            Page4Navigator<User> usersPages = userService.list(start, size, 5);
        /*User user = list.get(0);
        String userAccount = user.getUserAccount();
        System.out.println(userAccount);
        ListOperations listOperations = redisTemplate.opsForList();
        listOperations.leftPushAll("userList-All",list);
       System.out.println(listOperations.range("userList-All",0,-1));*/

        return usersPages;

      /*  }*/
    }


    /*
     *根据Id获取user,先会从redis获取，如果redis没数据，则从数据库获取
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User get(@PathVariable(value = "id") int id) {

       /* ListOperations listOperations = redisTemplate.opsForList();
        List<User> users = listOperations.range("user", 0, -1);
        List<Integer> ids = new ArrayList<>();

        for (User user : users) {
            int id1 = user.getId();
            ids.add(id1);
        }*/

      /*  if (!ids.contains(id)) {

            User user = userService.get(id);
            if (user != null) {
                return new Result(ResultCode.SUCCESS, user);
            } else {
                return new Result(ResultCode.FAIL);
            }

        } else {

        }

       */
       /* if (users.size() != 0) {
            for (User user1 : users) {
                if (!ids.contains(id)) {
                    User user = userService.get(id);
                    if (user != null) {
                        return new Result(ResultCode.SUCCESS, user);
                    } else {
                        return new Result(ResultCode.FAIL);
                    }
                } else {
                    if (user1.getId() == id) {
                        return new Result(ResultCode.SUCCESS, user1);
                    } else {
                        continue;
                    }
                }

            }
            return null;
        } else {
            User user = userService.get(id);
            if (user != null) {
                return new Result(ResultCode.SUCCESS, user);
            } else {
                return new Result(ResultCode.FAIL);
            }
        }*/

        User user = userService.get(id);
        return user;

    }


    /*
     *刷新redis，让redis的数据和数据库的数据保持一致
     */
    @RequestMapping(value = "/refresh")
    public Result refresh() {
        redisTemplate.delete("user");
        List<User> users = userService.findAll();
        ListOperations listOperations = redisTemplate.opsForList();
        listOperations.leftPushAll("user", users);
        return new Result(ResultCode.SUCCESS);

    }

    @GetMapping(value = "/findAll")
    public List<User> findAll(){

        return userService.findAll();
    }


}
