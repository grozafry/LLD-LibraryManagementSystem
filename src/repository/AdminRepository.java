package repository;

import models.Admin;

import java.util.HashMap;

public class AdminRepository {
    private HashMap<String, Admin> admins;

    public AdminRepository(){
        this.admins = new HashMap<>();
    }

    public void addUser(Admin admin){
        this.admins.put(admin.getPhone(), admin);
    }

    public Admin getUserByPhone(String phone){
        return this.admins.get(phone);
    }
}
