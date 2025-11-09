package order;

import book.Book;

import java.util.*;

public class OrdersBunch {
    public static int amountMoney;
    public static int numOrdersCompleted;

    private LinkedHashMap<Integer, Order> orders;
    private LinkedHashMap <Integer, Order> ordersCompleted;
    private final LinkedHashMap <Integer, Order> ordersProcess;

    {
        amountMoney = 0;
        numOrdersCompleted = 0;

        orders = new LinkedHashMap<>();
        ordersCompleted = new LinkedHashMap<>();
        ordersProcess = new LinkedHashMap<>();
    }

// orders
    public void addOrder(Order order, Book book){
        order.addOrder();
        order.setBook(book);
        orders.put(order.getOrderNum(), order);
    }
// работа с ordersCompleted
    public void addOrderCompleted(Order order){
        order.completeOrder();
        ordersCompleted.put(order.getOrderNum(), order);

        amountMoney += order.getBook().getPrice();
        numOrdersCompleted ++;
    }
    public void cancelOrderCompleted(Order order){
        order.getBook().changeBooksCount(1, true, false);

        order.cancelOrder();
        ordersCompleted.remove(order.getOrderNum());

        amountMoney -= order.getBook().getPrice();
        numOrdersCompleted --;
    }
// работа с ordersProcess
    public void addOrderProcess(Order order){
        order.processOrder();
        ordersProcess.put(order.getOrderNum(), order);
    }
    public void delOrderProcess(Order order){
        addOrderCompleted(order);
        ordersProcess.remove(order.getOrderNum());
    }
    public void cancelOrderProcess(Order order){
        order.cancelOrder();
        ordersProcess.remove(order.getOrderNum());
    }
// get
    public LinkedHashMap<Integer, Order> getOrders() {
        return orders;
    }
    public LinkedHashMap<Integer, Order> getOrdersCompleted() {
        return ordersCompleted;
    }
    public LinkedHashMap<Integer, Order> getOrdersProcess() {
        return ordersProcess;
    }

//сортировка
    public void sortOrders(){
        orders = orders.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Order::getDateCreation).
                        thenComparing(Order::getDateCompletion).
                        thenComparing(Comparator.comparingInt(order -> order.getBook().getPrice())).
                        thenComparing(Order::getStatus)))
                .collect(LinkedHashMap::new, (map, entry) ->
                        map.put(entry.getKey(), entry.getValue()), Map::putAll);
    }

    public void sortOrdersCompleted(){
        ordersCompleted = ordersCompleted.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Order::getDateCompletion).
                        thenComparing(Comparator.comparingInt(order -> order.getBook().getPrice()))))
                .collect(LinkedHashMap::new, (map, entry) ->
                        map.put(entry.getKey(), entry.getValue()), Map::putAll);
    }

// вывод
    public void printOrders(){
        System.out.println("\n▷ Заказы:");
        for (Order order : orders.values()){
            System.out.println(order.toString());
        }
    }
    public void printOrdersCompleted(){
        System.out.println("\n▷ Выполненные заказы:");
        for (Order order : ordersCompleted.values()){
            System.out.println(order.toString());
        }
    }

    public void printOrdersProcess(){
        System.out.println("\n▷ Заказы в процессе:");
        for (Order order : ordersProcess.values()){
            System.out.println(order.toString());
        }
    }

    public void printOrdersBook(){
        System.out.println("\n▷ Заказанные книги:");
        for (Order order : orders.values()) {
            System.out.println("   книга: " + order.getBook().getTitle() +
                    " | статус заказа: " + order.getStatus());
        }
    }
}
