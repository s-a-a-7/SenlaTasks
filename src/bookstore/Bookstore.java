package bookstore;

import book.Book;
import book.BooksList;
import order.Order;
import order.OrdersBunch;
import order.Status;
import request.Request;
import request.RequestList;

import java.util.List;

public class Bookstore {
    private final BooksList booksList;
    private final OrdersBunch ordersBunch;
    private final RequestList requestList;

    public Bookstore (BooksList booksList){
        this.booksList = booksList;

        ordersBunch = new OrdersBunch();
        requestList = new RequestList();
    }

    public OrdersBunch getOrdersBunch() {
        return ordersBunch;
    }
    public RequestList getRequestList() {
        return requestList;
    }

    public int makeOrder(Book book){ // создать заказ
        Order order = new Order();
        ordersBunch.addOrder(order, book);

        if (booksList.isBookExist(book)){

            ordersBunch.addOrderCompleted(order);

        } else{
            ordersBunch.addOrderProcess(order);

            requestList.addRequest(order.getRequest(), book);
        }

        return order.getOrderNum();
    }

    public void recheckRequests(){ // проверка появилась ли книга, на которую есть запрос
        List<Order> ordersProcess = ordersBunch.getOrdersProcess().values().stream().toList();
        for (Order order : ordersProcess) {
            Request request = order.getRequest();

            if (booksList.isBookExist(order.getBook())) {
                request.delRequest();
                ordersBunch.delOrderProcess(order);
            }
        }
    }

    public void cancelOrder(Integer oderNum){ //отмена заказа
        Order order = ordersBunch.getOrders().get(oderNum);
        Status status = order.getStatus();
        Request request = order.getRequest();

        if (status == Status.DONE){
            ordersBunch.cancelOrderCompleted(order);
        } else if (status == Status.PROCESS) {
            ordersBunch.cancelOrderProcess(order);
            request.delRequest();
        }
    }

}
