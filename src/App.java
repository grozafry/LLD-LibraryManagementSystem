import models.Admin;
import models.Book;
import models.Librarian;
import models.User;
import repository.BookRepository;
import service.LibraryService;

public class App {

    
    public static void main(String[] args){
        System.out.println("Hello, World!");

        Admin admin1 = new Admin("suraj", "8130733505") ;       
        Admin admin2 = new Admin("surajb", "9130733505") ;   
        
        User user1 = new User("user1", "8822998765");
        
        Librarian lib1 = new Librarian("lib1", "8877656676");

        BookRepository bookRepository = new BookRepository();

        LibraryService libraryService = new LibraryService(bookRepository);

        Book book1 = new Book("abc", "11212", "author1", 10);
        Book book2 = new Book("abc2", "91212", "author2", 18);

        libraryService.addBook(admin1, book1);
        libraryService.addBook(admin2, book2);


        libraryService.issueBook(user1, book2, lib1);

    }
}
