import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private final List<Book> books = new ArrayList<>();

    public boolean isBookExist(Book book){
        return books.contains(book);
    }

    public void addBook(Book book){
        if (isBookExist(book)){
            System.out.println("добавлен новый экземпляр книги: " + "«" + book.getName() +  "»");
            book.changeQuantity(1);
        }
        else{
            System.out.println("добавлена новая книга: " + "«" + book.getName() +  "»");
            books.add(book);
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public void printBooks(){
        System.out.println("\n");
        System.out.println("Наполняемость склада:");
        for (Book book : books) {
            System.out.println("название: " + "«" + book.getName() +  "»" +
                    " | количество: " + book.getQuantity()  +
                    " | статус: " + book.getStatus());
        }
        System.out.println("\n");
    }
}
