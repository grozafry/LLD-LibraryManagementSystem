package repository;

import models.User;

import java.util.HashMap;

public class UserRepository {
    private HashMap<String, User> users;

    public UserRepository(){
        this.users = new HashMap<>();
    }

    public void addUser(User user){
        this.users.put(user.getPhone(), user);
    }

    public User getUserByPhone(String phone){
        return this.users.get(phone);
    }
}
