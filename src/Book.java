import java.util.Comparator;
import java.util.Date;

public class Book {
    private final String name;
    private int year;
    private int price;

    private boolean status;
    private int quantity;

    private int quantRequest;

    private Date dateReceive;
    private Date dateSeil;

    {
        quantity = 0;
        status = false;

        quantRequest = 0;
    }

    public Book(String name, int year, int price){
        this.name = name;
        this.year = year;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }
    public void changeQuantity(int num) {
        this.quantity += num;

        if (quantity > 0){
            this.status = true;
        } else{
            this.status = false;
            quantity = 0;
        }
    }

    public int getQuantRequest() {
        return quantRequest;
    }
    public void changeQuantRequest(boolean flag){
        if (flag){
            quantRequest --;
        } else{
            quantRequest ++;
        }
    }

    public Date getDateReceive() {
        return dateReceive;
    }
    public void setDateReceive() {
        this.dateReceive = new Date();
    }

    public Date getDateSeil() {
        return dateSeil;
    }
    public void setDateSeil() {
        this.dateSeil = new Date();
    }
}

class BookNameComparator implements Comparator<Book> {
    @Override
    public int compare(Book a, Book b){
        return a.getName().compareTo(b.getName());
    }
}
class BookYearComparator implements Comparator<Book>{
    @Override
    public int compare(Book a, Book b){
        return a.getYear()- b.getYear();
    }
}
class BookPriceComparator implements Comparator<Book>{
    @Override
    public int compare(Book a, Book b){
        return a.getPrice() - b.getPrice();
    }
}
class BookStatusComparator implements Comparator<Book>{
    @Override
    public int compare(Book a, Book b){
        return (a.getStatus() == b.getStatus()) ? 0 : (a.getStatus() ? 1 : -1);
    }
}