import java.util.Date;

public class Book {
    private final String name;
    private int year;
    private int price;

    private int quantity;
    private boolean status;

    private int quantRequest;

    private Date dateReceive;
    private Date dateSeil;

    {
        quantity = 0;
        status = true;

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

    public void setDateReceive() {
        this.dateReceive = new Date();
    }

    public void setDateSeil() {
        this.dateSeil = new Date();
    }

    public void changeQuantRequest(boolean flag){
        if (flag){
            quantRequest --;
        } else{
            quantRequest ++;
        }
    }
}