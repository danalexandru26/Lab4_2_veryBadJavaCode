import java.time.LocalDate;

public class Book {
    public Book(String title, String author, int publishingYear){
        this.title = title;
        this.author = author;
        this.publishingYear = publishingYear;
    }

    public String getTitle() {
        return title;
    }

    @Override public String toString() {
        return String.format("Title: %s, Author: %s, Publishing Year: %d", title, author, publishingYear);
    }

    String title;
    String author;
    int publishingYear;
    }
