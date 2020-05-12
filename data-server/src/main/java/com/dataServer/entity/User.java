package com.dataServer.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "blog_user")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {


    private static final long serialVersionUID = 2197781690548388026L;
    @Id
    int id;

    String userAccount;

    String userPassword;

    String salt;




}