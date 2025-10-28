import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private List<Book> books = new ArrayList<>();

    public boolean isBookExist(Book book){
        return books.contains(book);
    }

    public void addBook(Book book){
        if (isBookExist(book)){
            book.changeQuantity(1);
        }
        else{
            books.add(book);
        }
    }

    public List<Book> getBooks() {
        return books;
    }
}
