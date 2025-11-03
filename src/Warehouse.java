import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private List<Book> books = new ArrayList<>();

    public boolean isBookExist(Book book){
        return books.contains(book);
    }

    public void addBook(Book book){
        if (isBookExist(book)){
            System.out.println("＋ добавлен новый экземпляр книги: " + "«" + book.getName() +  "»");
            book.changeQuantity(1);
        }
        else{
            System.out.println("＋ добавлена новая книга: " + "«" + book.getName() +  "»");
            book.changeQuantity(1);
            books.add(book);
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public void printBooks(){
        System.out.println();
        System.out.println("▷ Наполняемость склада:");
        for (Book book : books) {
            System.out.print("   название: " + "«" + book.getName() +  "»");
            System.out.print(" | год издания: " + book.getYear());
            System.out.print(" | цена: " + book.getPrice());
            if (book.getStatus()){
                System.out.print(" | в наличии " + book.getQuantity());
            } else{
                System.out.print(" | нет в наличии");
            }
            System.out.println();
        }
        System.out.println();
    }
}