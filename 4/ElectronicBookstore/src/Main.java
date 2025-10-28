public static void main(String[] args){
    Book book1 = new Book("Шерлок Хомс");
    Book book2 = new Book("Зло под солнцем");
    Book book3 = new Book("Убийство по алфавиту");

    Warehouse warehouse = new Warehouse();
    warehouse.addBook(book1);
    warehouse.addBook(book2);
    warehouse.addBook(book2);
    warehouse.addBook(book3);

//    for (int i = 0; i < )
//    System.out.println(warehouse.getBooks() + "\n");


    Request request = new Request();
    request.addRequest(book1, warehouse);
    request.addRequest(book2, warehouse);
    request.addRequest(book3, warehouse);
    request.addRequest(book3, warehouse);

    System.out.println("\n");
    System.out.println(book1.getName() + " " + book1.getStatus() + " " + book1.getQuantity());
    System.out.println(book2.getName() + " " + book2.getStatus() + " " + book2.getQuantity());
    System.out.println(book3.getName() + " " + book3.getStatus() + " " + book3.getQuantity());
}