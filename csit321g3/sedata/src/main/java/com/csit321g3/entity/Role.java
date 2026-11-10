package com.csit321g3.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

@Entity 
@Table(name="Role")
public class Role {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer role_id;
    private String role_name;

    public Role(){}
    public Role(String role_name, Integer role_id){
        this.role_name = role_name;
        this.role_id = role_id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

}