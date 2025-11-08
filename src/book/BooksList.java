package book;

import java.util.ArrayList;
import java.util.List;

public class BooksList {
    private List<Book> books = new ArrayList<>();

    public boolean isBookExist(Book book){
        return books.contains(book) && book.isExist();
    }

    public void addBook(Book book, int numBooks){
        if (isBookExist(book)){
            book.changeBooksCount(numBooks, true,false);
        } else{
            books.add(book);
            book.changeBooksCount(numBooks, true,false);
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public void printBooksList(){
        System.out.println("\n▷ Наполняемость склада:");
        for(Book book : books){
            System.out.println(book.toString());
        }
    }
}
