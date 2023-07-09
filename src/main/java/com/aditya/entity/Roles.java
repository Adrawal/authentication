package com.aditya.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name ="roles")
public class Roles implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "role_id",unique=true, nullable = false)
    private Long id;

    private String authority;

    public Roles() {
        super();
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Roles(String authority) {
        this.authority = authority;
    }

    public Roles(Long id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    @Override
    public String getAuthority() {
         return this.authority;
    }
}
