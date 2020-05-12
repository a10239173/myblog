package com.dataServer.dao;

import com.dataServer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserDao  extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

}
