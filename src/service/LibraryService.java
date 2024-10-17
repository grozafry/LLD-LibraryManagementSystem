package service;

import javax.management.RuntimeErrorException;
import models.Book;
import models.Admin;
import models.Librarian;
import models.User;

import repository.BookRepository;
import repository.RepositoryException;

import utils.RetryUtil;


public class LibraryService {
    private BookRepository bookRepository;
    
    public LibraryService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public void addBook(Admin admin, Book book){

        try{
            boolean task_success = RetryUtil.retryExponentialOperation(() -> {
                try {
                    this.bookRepository.addBook(book);
                } catch (RepositoryException e) {
                    throw new RuntimeException(e); // Wrapping in RuntimeException to use in lambda
                }
            }, 3);  
            if (task_success){
                System.out.println("Service layer, admin " + admin.getName() + " added book successfully id: " + book.getId());
            }else{
                System.err.println("Unable to add book, max retries exceeded!" );
            }
        }catch(Exception e){
            System.err.println("Unable to add book, max retries exceeded! " + e.getMessage());
        }

        
    }

    public void removeBook(Admin admin, Book book){
        this.bookRepository.removeBook(book);
        System.out.println("Service layer, admin " + admin.getName() + "removed book successfully id: " + book.getId());
    }

    public void issueBook(User user, Book book, Librarian librarian){
        if (librarian.isActive()){
            this.bookRepository.issueBook(user, book, librarian);
        }else{
            System.out.println("Librarian is not active, unauthorized operation terminated.");
        }

    }

}
