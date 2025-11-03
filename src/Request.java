import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Request {
    private boolean existRequest;

    private List<Book> requestList = new ArrayList<>();

    public void addRequest(Book book, Warehouse warehouse, OrderList orderList){
        existRequest = false;

        Order order = new Order();
        order.setStatus("новый");
        orderList.addOrder(order, book);
        System.out.println(order.getStatus() + " заказ на книгу: " + "«" + book.getName() +  "»");

        if (warehouse.isBookExist(book) && book.getStatus()){
            book.changeQuantity(-1);

            order.changeOrder(existRequest);
            orderList.addOrderCompleted(order, book);
            System.out.println("заказ " + order.getStatus());
        }
        else{
            System.out.println("книга отстутствует, сформирован запрос на книгу");
            existRequest = true;
            order.changeOrder(existRequest);

            if (requestList.contains(book)){
                book.changeQuantRequest(existRequest);
            }
            else{
                requestList.add(book);
                book.changeQuantRequest(existRequest);
            }
        }
    }

    public void deleteRequest(Book book, Warehouse warehouse, OrderList orderList){
        existRequest = false;

        int i = orderList.getOrdersBook().indexOf(book);
        Order order = orderList.getOrders().get(i);

        order.setStatus("отменен");
        System.out.println("заказ " + order.getStatus());

        book.changeQuantity(1);
    }

public void recheckRequest(Book book, Warehouse warehouse, OrderList orderList){
    if (warehouse.isBookExist(book) && book.getStatus()){
        for (Order order : orderList.getOrders()){
            existRequest = true;

            if (order.getStatus().equals("в процессе")){
                existRequest = false;
                book.changeQuantRequest(existRequest);

                System.out.println("книга " + "«" + book.getName() +  "»" + " появилась");
                book.changeQuantRequest(existRequest);
                book.changeQuantity(-1);

                order.changeOrder(existRequest);
                orderList.addOrderCompleted(order, book);
                System.out.println("заказ " + order.getStatus());
            }
        }
    }else{
        if (book.getQuantRequest() > 0){
            System.out.println("книга " + "«" + book.getName() +  "»" + " еще не появилась");
        }
    }
}

    public List<Book> getRequestList(){
        return requestList;
    }
    public void printRequestList(){
        System.out.println();
        System.out.println("▷ Список запросов на книги:");
        for (Book book : requestList) {
            System.out.print("   кол-во запросов: " + book.getQuantRequest());
            System.out.print(" | книга: " + "«" + book.getName() +  "»");
            System.out.println();
        }
        System.out.println();
    }

}

class RequestNameComparator implements Comparator<Book> {
    @Override
    public int compare(Book a, Book b) {
        return a.getName().compareTo(b.getName());
    }
}
class RequestQuantComparator implements Comparator<Book> {
    @Override
    public int compare(Book a, Book b) {
        return a.getQuantRequest() - b.getQuantRequest();
    }
}
