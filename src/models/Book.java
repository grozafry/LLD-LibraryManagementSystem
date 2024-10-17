package models;

public class Book {
    private String name;
    private String id;
    private String author;
    private int totalCount;
    private int availableCount;

    public Book(String name, String id, String author, int totalCount){
        this.name = name;
        this.id = id;
        this.author = author;
        this.totalCount = totalCount;
        this.availableCount = totalCount;
    }

    public String getId(){
        return this.id;
    }

    public int getTotalCount(){
        return this.totalCount;
    }

    public int getAvailableCount(){
        return this.availableCount;
    }

    public void getOneBook(){
        this.availableCount -= 1;
    }

    public String getName(){
        return this.name;
    }

}
