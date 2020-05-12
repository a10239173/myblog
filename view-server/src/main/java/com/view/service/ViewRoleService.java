package com.view.service;

import com.common.util.Page4Navigator;
import com.dataServer.entity.Role;
import com.view.client.ClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;

@Service
public class ViewRoleService {

    @Autowired
    ClientFeign clientFeign;

    public Page4Navigator<Role> listRoleByPage(int start,int size){
        return    clientFeign.listRoleByPage(start,size);
    }

    public void deleteRole(int id){
        clientFeign.deleteRole(id);
    }
}
