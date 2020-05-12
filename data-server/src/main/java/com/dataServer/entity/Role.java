package com.dataServer.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "blog_role")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {


    private static final long serialVersionUID = 2529719953527336014L;

    @Id
    private int id;

    private String name;

}
