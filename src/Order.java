import java.util.Date;

public class Order {
    private String status;
    private Date date;
    private int price;

    {
        status = "не оформлен";
        date = new Date();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void deleteOrder(Order order) {
        order.setStatus("отменен");
    }

    public void changeOrder(boolean flag) {
        if (!flag) {
            this.status = "выполнен";
            this.date = new Date(System.currentTimeMillis() + 3600 * 1000);
        } else {
            this.status = "в процессе";
        }
    }
}
