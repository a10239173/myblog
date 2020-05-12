package com.dataServer.service;

import com.common.util.Page4Navigator;
import com.dataServer.dao.RoleDao;
import com.dataServer.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleDao roleDao;

    public void add(Role role){
        roleDao.save(role);
    }

    public void delete(int id){
        roleDao.delete(id);
    }

    public void update(Role role){
        Role temp = roleDao.getOne(role.getId());
       temp.setName(role.getName());
       roleDao.save(temp);
    }

    public Page4Navigator<Role> listByPage(int start,int size,int navigatePages){

        Pageable pageRequest = new PageRequest(start, size);
        Page<Role> roles = roleDao.findAll(pageRequest);
        return new Page4Navigator<>(roles,navigatePages);

    }

    public List<Role> listAll(){
        return roleDao.findAll();
    }

    public Role get(int id){
        return roleDao.getOne(id);
    }


}
