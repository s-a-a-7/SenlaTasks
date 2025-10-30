public static void main(String[] args){
    Book book1 = new Book("Шерлок Хомс");
    Book book2 = new Book("Зло под солнцем");
    Book book3 = new Book("Убийство по алфавиту");

    Warehouse warehouse = new Warehouse();
    warehouse.addBook(book1);
    warehouse.addBook(book2);
    warehouse.addBook(book2);
    warehouse.addBook(book3);

    warehouse.printBooks();

    Request request = new Request();
    request.addRequest(book1, warehouse);
    request.addRequest(book2, warehouse);
    request.addRequest(book2, warehouse);
    request.addRequest(book2, warehouse);
    request.addRequest(book3, warehouse);
    request.addRequest(book3, warehouse);

    warehouse.addBook(book3);

    request.recheckRequest(book2, warehouse);
    request.recheckRequest(book3, warehouse);

    warehouse.printBooks();
}