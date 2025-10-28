public class Book {
    private final String name;
    private boolean status = true;
    private int quantity = 1;

    public Book(String name){
        this.name = name;
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
    }
}