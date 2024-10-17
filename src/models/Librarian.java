package models;

public class Librarian extends User {
    private boolean isActive = true;
    public Librarian(String name, String phone) {
        super(name, phone);
    }

    public void assistUser() {
        System.out.println("Librarian " + this.getName() + " is assisting a user.");
    }

    public boolean isActive(){
        return this.isActive;
    }
}
