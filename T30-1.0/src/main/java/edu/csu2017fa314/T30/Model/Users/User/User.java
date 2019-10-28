package edu.csu2017fa314.T30.Model.Users.User;

import javax.persistence.*;

@Entity
@Table(name = "ExampleUsers")
@NamedQuery(name= "findUsers", query="from User e")

public class User {

    // Each @Entity needs an @Id - this is the primary key in the database.

    public String firstName;
    public String lastName;
    public String email;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int id;

    public User(){};

    public User(String firstName, String lastName, String email)
    {
        this.firstName =  firstName;
        this.lastName =  lastName;
        this.email =  email;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

// getter/setter
}