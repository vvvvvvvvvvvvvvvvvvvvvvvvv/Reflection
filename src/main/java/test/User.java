package test;

import java.io.Serializable;

public class User extends Person implements Serializable, Comparable<User> {
    @MinAge
    private int age;
    private String name;
    public User(int id, String name) {
        this.age = id;
        this.name = name;
    }

    @Override
    public int compareTo(User o) {
        return 0;
    }
}
