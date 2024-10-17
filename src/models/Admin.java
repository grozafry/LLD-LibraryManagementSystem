package models;

public class Admin extends User{

    public Admin(String name, String phone){
        super(name, phone);
    }

    public void addBook(Book book){
        System.out.println("Admin " + this.getName() + " added book " + book.getName() + "!");
    }

    public void removeBook(Book book){
        System.out.println("Admin " + this.getName() + " removed book " + book.getName() + "!");
    }
}
