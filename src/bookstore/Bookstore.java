package bookstore;

import book.Book;
import book.BooksList;
import order.Order;
import order.OrdersList;
import request.Request;
import request.RequestList;

public class Bookstore {
    private BooksList booksList;
    private OrdersList ordersList;
    private RequestList requestList;

    public void makeOrder(Book book, int numBooks){
        Order order = new Order();
        ordersList.addOrder(order, book);

        if (booksList.isBookExist(book)){

            if (book.getBooksCount() >= numBooks){

                ordersList.addOrderCompleted(order);

                book.changeBooksCount(numBooks, false, true);
            }else{

            }
        }


        if (booksList.isBookExist(book) && book.getBooksCount() >= numBooks){

            ordersList.addOrderCompleted(order);

            book.changeBooksCount(numBooks, false, true);
        } else{
            Request request = new Request();
            ordersList.addOrderProcess(order);

            requestList.addRequest(request, book, numBooks);
        }
    }



}
