package models;

public class User {

    private String name;
    private String phone;

    public User(String name, String phone){
        this.name = name;
        this.phone = phone;
    }

    public String getName(){
        return this.name;
    }

    public String getPhone(){
        return this.phone;
    }
}
