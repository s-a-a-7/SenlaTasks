package book;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BooksList {
    private List<Book> books = new ArrayList<>();
    private final List<String> booksTitle = new ArrayList<>();
    private List<Book> staleBooks = new ArrayList<>();

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

// залежавшиеся книги
    public void checkStaleBooks(){
        LocalDate now = LocalDate.now();
        for(Book book : books){
            if (!staleBooks.contains(book)){
                long monthsSinceArrival = ChronoUnit.MONTHS.between(book.getArrivalDate(), now);
                if (monthsSinceArrival >= 6 && !book.isSold()){
                    staleBooks.add(book);
                }
            }
        }
    }

// сортировка
    public void sortBooksList(){
        books = books.stream().
                sorted(Comparator.comparing(Book::getTitle).
                        thenComparing(Book::getYear).
                        thenComparing(Book::getPrice).
                        thenComparing(Book::isExist)).
                toList();
    }

    public void sortStaleBooks(){
        staleBooks = staleBooks.stream().
                sorted(Comparator.comparing(Book::getArrivalDate).
                        thenComparing(Book::getPrice))
                .toList();
    }
// вывод
    public void printBooksList(){
        System.out.println("\n▷ Наполняемость склада:");
        for(Book book : books){
            System.out.println(book.toString());
        }
    }

    public void printStaleBooks(){
        System.out.println("\n▷ Залежавшиеся книги:");
        for(Book book : staleBooks){
            System.out.println(book.toString());
        }
    }
}
