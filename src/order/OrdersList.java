package order;

import book.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OrdersList {
    public static int amountMoney;
    public static int numOrdersCompleted;

    private final int orderNum;

    private List<Order> orders;
    private List<Order> ordersCompleted;
    private List<Order> ordersProcess;

    {
        amountMoney = 0;
        numOrdersCompleted = 0;

        orderNum = new Random().nextInt(1000);

        orders = new ArrayList<>();
        ordersCompleted = new ArrayList<>();
        ordersProcess = new ArrayList<>();
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void addOrder(Order order, Book book){
        order.addOrder();
        order.setBook(book);
        orders.add(order);
    }
    public void addOrderCompleted(Order order){
        order.completeOrder();
        ordersCompleted.add(order);

        amountMoney += order.getBook().getPrice();
        numOrdersCompleted ++;
    }

    public void addOrderProcess(Order order){
        order.processOrder();
        ordersProcess.add(order);
    }
    public void delOrderProcess(Order order){
        addOrderCompleted(order);
        ordersProcess.remove(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Order> getOrdersCompleted() {
        return orders;
    }

    public String toString() {
        System.out.println("\n▷ Заказы:");
        for (Order order : orders){
            return order.toString();
        }
        return "";
    }
    public String toStringComplete() {
        System.out.println("\n▷ Выполненные заказы:");
        for (Order order : ordersCompleted){
            return order.toString();
        }
        return "";
    }

    public String printOrdersBook(){
        System.out.println("\n▷ Заказанные книги:");
        for (Order order : orders) {
            return  "   книга: " + order.getBook().getTitle() +
                    " | статус заказа: " + order.getStatus() + "\n";
        }
        return "";
    }
}
