package repository;

public class RepositoryException extends Exception {
    public RepositoryException(String msg, Exception exc){
        super(msg, exc);
    }
}
