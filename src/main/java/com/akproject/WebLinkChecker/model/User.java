package com.akproject.WebLinkChecker.model;


import com.sun.istack.internal.NotNull;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    //default constructor
    protected User() {}


    // Constructor for work with Database
    public User(String name){
        this.name = name;
    }


    @Override
    public String toString(){
        return String.format("User[id=%d, name='%s]", id, name );
    }

    // get's and set's
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
