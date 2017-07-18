package com.akproject.WebLinkChecker.model;



import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 10, max = 255)
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

    @Size(min = 3, max = 255)
    public void setName(String name) {
        this.name = name;
    }
}
