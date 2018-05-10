package com.example.android.observer;

import java.util.Observable;


/**
 * UserEntity will act as a Observer Class
 *
 */
public class UserEntity extends Observable {
    private String name;
    private int age;
    private String email;


    private static UserEntity INSTANCE;

    public static UserEntity getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserEntity();
        }

        return INSTANCE;
    }

    public String getName() {
        return name;
    }

    public UserEntity setName(String name) {
        this.name = name;
        setChanged();
        return this;
    }

    public int getAge() {
        return age;
    }

    public UserEntity setAge(int age) {
        this.age = age;
        setChanged();
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        setChanged();
        return this;
    }
}