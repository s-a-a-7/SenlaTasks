import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Order {
    private static int sum = 0;
    private static int numOrdersCompleted = 0;

    private String status = "не оформлен";
    private Date date;
    private int price;

    public static List<Order> orders = new ArrayList<>();
    public static List<Order> ordersCompleted = new ArrayList<>();


    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }


    public void setDate() {
        this.date = new Date();
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


    public void addOrder(Order order, Book book){
        order.setStatus("новый");
        order.setPrice(book.getPrice());
        orders.add(order);
    }
    public List<Order> getOrders(){
        return orders;
    }

    public void deleteOrder(Order order){
        order.setStatus("отменен");
    }

    public void completeOrder(Order order){
        order.setStatus("выполнен");
        order.setDate();
        ordersCompleted.add(order);

        sum += this.price;
        numOrdersCompleted ++;
    }
    public static List<Order> getOrdersCompleted() {
        return ordersCompleted;
    }
}

class DateOrderComparator implements Comparator<Order>{
    @Override
    public int compare(Order a, Order b) {
        return a.getDate().compareTo(b.getDate());
    }
}
class PriceOrderComparator implements Comparator<Order>{
    @Override
    public int compare(Order a, Order b) {
        return a.getPrice() - b.getPrice();
    }
}
class StatusOrderComparator implements Comparator<Order>{
    @Override
    public int compare(Order a, Order b) {
        return a.getStatus().compareTo(b.getStatus());
    }
}
