package ec.edu.espe.bookcatalog.model;

import java.io.Serializable;

public class Book implements Serializable {
    private String name;
    private String author;
    private int year;
    
    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }
    
    @Override
    public String toString() {
        return name + ";" + author + ";" + year;
    }
}
