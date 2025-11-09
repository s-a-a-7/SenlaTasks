import book.Book;
import book.BooksList;
import book.PossibleBooks;
import bookstore.Bookstore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
// создание книг
        Book book1 = new Book(PossibleBooks.SHERLOCK.toString(), 2021, 239);
        Book book2 = new Book(PossibleBooks.EVIL_UNDER_SUN.toString(), 2023, 289);
        Book book3 = new Book(PossibleBooks.ALPHABETICAL_MURDER.toString(), 2023, 279);
// добавление их в список
        BooksList booksList = new BooksList();
        booksList.addBook(book1, 1);
        booksList.addBook(book2, 2);
        booksList.addBook(book3, 2);

        booksList.printBooksList(); // проверка правильно ли все добавилось

        Bookstore bookstore = new Bookstore(booksList);

        List<Integer> orderNums = new ArrayList<>(); // номера оформленных заказов
// оформление заказов
        orderNums.add(bookstore.makeOrder(book1)); // 0
        orderNums.add(bookstore.makeOrder(book1)); // 1
        orderNums.add(bookstore.makeOrder(book2)); // 2
        orderNums.add(bookstore.makeOrder(book2)); // 3
        orderNums.add(bookstore.makeOrder(book2)); // 4
        orderNums.add(bookstore.makeOrder(book2)); // 5
        orderNums.add(bookstore.makeOrder(book3)); // 6

///*
// проверка
        bookstore.getOrdersBunch().printOrders();
        bookstore.getOrdersBunch().printOrdersCompleted();
        bookstore.getRequestList().printRequests();

        booksList.printBooksList();
// */

/*
// проверка работы recheckRequests()
        bookstore.getRequestList().printRequests();
        bookstore.getOrdersBunch().printOrdersProcess();

        booksList.addBook(book2, 3);

        System.out.println("\n проверка появилась ли книга");
        bookstore.recheckRequests();
        bookstore.getRequestList().printRequests();

        bookstore.getOrdersBunch().printOrdersCompleted();
        bookstore.getOrdersBunch().printOrdersProcess();
 */

/*
// проверка работы cancelOrder
        System.out.println("\n отмена заказов");
        bookstore.cancelOrder(orderNums.get(1));
        bookstore.cancelOrder(orderNums.get(3));

        bookstore.getOrdersBunch().printOrders();
        bookstore.getOrdersBunch().printOrdersCompleted();
        bookstore.getRequestList().printRequests();
 */

/*
// проверка работы sortBooksList()
        booksList.printBooksList();
        System.out.println("\n сортировка");
        booksList.sortBooksList();
        booksList.printBooksList();
 */

/*
// проверка работы sortOrders()
        bookstore.getOrdersBunch().printOrders();
        System.out.println("\n сортировка");
        bookstore.getOrdersBunch().sortOrders();
        bookstore.getOrdersBunch().printOrders();
 */

/*
// проверка работы sortOrdersCompleted()
        bookstore.getOrdersBunch().printOrdersCompleted();
        System.out.println("\n сортировка");
        bookstore.getOrdersBunch().sortOrdersCompleted();
        bookstore.getOrdersBunch().printOrdersCompleted();
 */

/*
// проверка работы sortRequestList()
        bookstore.getRequestList().printRequests();
        System.out.println("\n сортировка");
        bookstore.getRequestList().sortRequestList();
        bookstore.getRequestList().printRequests();
 */

/*
// залежавшиеся книги
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(booksList::checkStaleBooks, 0, 1, TimeUnit.DAYS);
        booksList.printStaleBooks();
        executorService.schedule(executorService::shutdown, 10, TimeUnit.SECONDS);
 */

            System.out.println("Заработанная сумма: " + bookstore.getOrdersBunch().amountMoney + " рублей");
            System.out.println("Кол-во выполненных заказов: " + bookstore.getOrdersBunch().numOrdersCompleted);
    }
}