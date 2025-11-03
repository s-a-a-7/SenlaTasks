public static void main(String[] args){
    Book book1 = new Book("Шерлок Хомс", 2021, 400);
    Book book2 = new Book("Зло под солнцем", 2021, 370);
    Book book3 = new Book("Убийство по алфавиту", 2022, 390);

    Description description = new Description();
    description.getDescription(PossibleBooks.EvilUnderSun);

    Warehouse warehouse = new Warehouse();
    warehouse.addBook(book1);
    warehouse.addBook(book2);
    warehouse.addBook(book2);
    warehouse.addBook(book3);

    Request request = new Request();
    OrderList orderList = new OrderList();

    request.addRequest(book1, warehouse, orderList);
    request.addRequest(book2, warehouse, orderList);
    request.addRequest(book2, warehouse, orderList);
    request.addRequest(book2, warehouse, orderList);
    request.addRequest(book3, warehouse, orderList);
    request.addRequest(book3, warehouse, orderList);
    request.addRequest(book3, warehouse, orderList);

    OrderDetails orderDetails = new OrderDetails();
    orderDetails.getOrderDetails(orderList);

//    warehouse.addBook(book3);

//    request.recheckRequest(book2, warehouse, orderList);
//    request.recheckRequest(book3, warehouse, orderList);

    Comparator<Order> orderComparator = new DateOrderComparator().thenComparing(new PriceOrderComparator());
//    orderList.getOrders().sort(orderComparator.thenComparing(new StatusOrderComparator()));
//    orderList.getOrdersCompleted().sort(orderComparator);

    orderList.printOrders();
    orderList.printOrdersCompleted();


//    request.getRequestList().sort(new RequestQuantComparator().thenComparing(new RequestNameComparator()));

    request.printRequestList();

    Comparator<Book> warehouseComparator = new BookNameComparator().thenComparing(new BookYearComparator()).
            thenComparing(new BookPriceComparator()).thenComparing(new BookStatusComparator());
//    warehouse.getBooks().sort(warehouseComparator);

    warehouse.printBooks();
}