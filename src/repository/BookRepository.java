package repository;

import models.Book;
import models.Librarian;
import models.User;

import repository.RepositoryException;

import java.util.ArrayList;
import java.util.HashMap;

public class BookRepository {
    private ArrayList<Book> bookList;
    private HashMap<Book, ArrayList<User>> issuedBookList;
    
    public BookRepository(){
        this.bookList = new ArrayList<>();
        this.issuedBookList = new HashMap<>();
    }

    public void addBook(Book book) throws RepositoryException{
        try {
            // System.out.println("Here!");
            // int a = 1/0;
            this.bookList.add(book);    
        } catch (Exception e) {
            System.err.println("Book Repository error while adding book: " + e.getMessage());
            throw new RepositoryException("custome exception message: " + e.getMessage(), e);
        }
        
    }

    public void removeBook(Book book){
        this.bookList.remove(book);
    } 

    public void issueBook(User user, Book book, Librarian librarian){
        if(book.getAvailableCount() > 0){
            book.getOneBook();
            ArrayList<User> book_value = issuedBookList.get(book);
            if (book_value == null){
                book_value = new ArrayList<>();
            }
            book_value.add(user);
            issuedBookList.put(book, book_value);
            System.out.println("Book: " + book.getName() + " successfully issued to user: " + user.getName());
        }
        else{
            System.out.println("Insufficient number of books! Request declined.");
        }
    }

}
