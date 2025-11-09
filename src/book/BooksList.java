package book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BooksList {
    private List<Book> books = new ArrayList<>();
    private final List<String> booksTitle = new ArrayList<>();

    public boolean isBookExist(Book book){
        return books.contains(book) && book.isExist();
    }

    public void addBook(Book book, int numBooks){

        if (booksTitle.contains(book.getTitle())){
            book.changeBooksCount(numBooks, true,false);
        } else{
            books.add(book);
            book.changeBooksCount(numBooks, true,false);

            booksTitle.add(book.getTitle());
        }
    }

    public List<Book> getBooks() {
        return books;
    }
// сортировка
    public void sortBooksList(){
        books = books.stream().
                sorted(Comparator.comparing(Book::getTitle).
                        thenComparing(Book::getYear).
                        thenComparing(Book::getPrice).
                        thenComparing(Book::isExist)).toList();
    }
// вывод
    public void printBooksList(){
        System.out.println("\n▷ Наполняемость склада:");
        for(Book book : books){
            System.out.println(book.toString());
        }
    }
}
