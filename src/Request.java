import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Request {
    private boolean statusRequest = false;

    private List<Book> requestList = new ArrayList<>();

    Order order = new Order();

    public void addRequest(Book book, Warehouse warehouse){
        order.addOrder(order, book);
        System.out.println(order.getStatus() + " заказ на книгу: " + "«" + book.getName() +  "»");

        if (warehouse.isBookExist(book) && book.getStatus()){
            book.changeQuantity(-1);

            order.completeOrder(order);
            System.out.println("заказ " + order.getStatus());
        }
        else{
            System.out.println("книга отстутствует, сформирован запрос на книгу");
            this.statusRequest = true;

            if (requestList.contains(book)){
                requestList.add(book);
                book.changeQuantRequest(statusRequest);
            }
            else{
                book.changeQuantRequest(statusRequest);
            }

        }
    }

    public void deleteRequest(Book book, Warehouse warehouse){
        statusRequest = false;
        order.setStatus("отменен");
        System.out.println("заказ " + order.getStatus());
        book.changeQuantity(1);
    }

    public void recheckRequest(Book book, Warehouse warehouse){
        if (statusRequest){
            if (warehouse.isBookExist(book) && book.getStatus()){
                statusRequest = false;
                book.changeQuantRequest(statusRequest);

                System.out.println("книга " + "«" + book.getName() +  "»" + " появилась");
                book.changeQuantity(-1);

                order.completeOrder(order);
                System.out.println(order.getStatus() + " заказ на книгу: " + "«" + book.getName() +  "»");
            }
            else{
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
            System.out.print(" | на книгу: " + "«" + book.getName() +  "»");
        }
        System.out.println("\n");
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
