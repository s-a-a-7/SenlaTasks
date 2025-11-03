import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class OrderList {
    public static int amountMoney = 0;
    public static int numOrdersCompleted = 0;

    private int orderNum = new Random().nextInt(1000);;

    public List<Order> orders = new ArrayList<>();
    public List<Book> ordersBook = new ArrayList<>();
    public List<Order> ordersCompleted = new ArrayList<>();
    public List<Book> ordersBookCompleted = new ArrayList<>();

    public int getOrderNum() {
        return orderNum;
    }

    public void addOrder(Order order, Book book){
        orders.add(order);
        ordersBook.add(book);

        order.setPrice(book.getPrice());
    }
    public void addOrderCompleted(Order order, Book book){
        ordersCompleted.add(order);
        ordersBookCompleted.add(book);

        amountMoney += book.getPrice();
        numOrdersCompleted ++;
    }

    public List<Order> getOrders() {
        return orders;
    }
    public List<Book> getOrdersBook() {
        return ordersBook;
    }

    public List<Order> getOrdersCompleted() {
        return orders;
    }
    public List<Book> getOrdersBookCompleted() {
        return ordersBook;
    }

    public void printOrders(){
        System.out.println();
        int i = 0;
        System.out.println("▷ Заказы:");
        for (Order order : orders) {
            System.out.println("   дата и время: " + order.getDate() +
                    " | цена: " + ordersBook.get(i).getPrice() +
                    " | статус: " + order.getStatus() +
                    " | книга: " + ordersBook.get(i).getName());
            ++i;
        }
        System.out.println();
    }

    public void printOrdersCompleted(){
        System.out.println();
        int i = 0;
        System.out.println("▷ Выполненные заказы:");
        for (Order order : ordersCompleted) {
            System.out.println("   дата и время: " + order.getDate() +
                    " | цена: " + ordersBookCompleted.get(i).getPrice() +
                    " | статус: " + order.getStatus() +
                    " | книга: " + ordersBookCompleted.get(i).getName());
            ++i;
        }
        System.out.println();
    }

    public void printOrdersBook(){
        System.out.println();
        int i = 0;
        System.out.println("▷ Заказанные книги:");
        for (Book book : ordersBook) {
            System.out.println("   книга: " + book.getName() +
                    " | статус: " + orders.get(i).getStatus());
            ++i;
        }
        System.out.println();
    }
}

class DateOrderComparator implements Comparator<Order> {
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