package com.inn.cafe.POJO;


import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NamedQuery(name = "User.findByEmailId", query = "select u from User u where u.email = ?1")

@NamedQuery(name = "User.getAllUser",query = "select new com.inn.cafe.wrapper.UserWrapper(u.id,u.name,u.email,u.contactNumber,u.status) from User u where u.role='user'")

@NamedQuery(name = "User.updateStatus", query = "update User u set u.status=:status where u.id=:id")

@NamedQuery(name = "User.getAllAdmin",query = "select u.email from User u where u.role='admin'")

@DynamicUpdate
@DynamicInsert
@Table( name = "user")
public class User implements Serializable {

    private static final long seralVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name = "id")
    private Integer id;

    @Column( name = "name")
    private String name;

    @Column( name = "contactNumber")
    private String contactNumber;

    @Column( name = "email")
    private String email;

    @Column( name = "password")
    private String password;

    @Column( name = "status")
    private  String status;

    @Column( name = "role")
    private String role;




}
