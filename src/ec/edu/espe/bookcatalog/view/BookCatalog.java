package ec.edu.espe.bookcatalog.view;

import ec.edu.espe.bookcatalog.model.Book;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookCatalog {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BookCatalog catalog = new BookCatalog();
        catalog.initialize();
    }
    
    public void initialize() {
        List<Book> books = retrieveBooks();
        
        for (Book book : books) {
            System.out.println(book);
        }
        
        System.out.println();
        System.out.println();
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("ingresa el nombre del libro: ");
        String name = scanner.nextLine();
        
        System.out.print("ingresa el autor del libro: ");
        String author = scanner.nextLine();
        
        System.out.print("ingresa el año del libro: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        
        Book book = new Book(name, author, year);
        saveBook(book);
    }
    
    public boolean saveBook(Book book) {
        File database = new File("books.txt");
        List<Book> books = retrieveBooks();
        books.add(book);
        
        try {
            if (!database.exists()) {
                database.createNewFile();
            }

            FileOutputStream fileStream = new FileOutputStream(database, false);
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(books);
        } catch (Exception exception) {
            return false;
        }
        
        return true;
    }
    
    public List<Book> retrieveBooks() {
        File database = new File("books.txt");
        List<Book> books = new ArrayList<>();
        
        try {
            if (!database.exists()) {
                database.createNewFile();
            }

            FileInputStream fileStream = new FileInputStream(database);
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);
            books = (List<Book>)objectStream.readObject();        
        } catch (Exception exception) {}
        
        return books;
    }
}
