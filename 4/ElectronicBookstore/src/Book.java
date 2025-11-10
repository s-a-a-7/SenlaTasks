public class Book {
    private final String name;
    private int quantity;
    private boolean status;

    {
        quantity = 0;
        status = true;

    }

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

        if (quantity > 0){
            this.status = true;
        } else{
            this.status = false;
            quantity = 0;
        }
    }
}