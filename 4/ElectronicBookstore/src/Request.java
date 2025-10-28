public class Request {
    private boolean statusRequest = false;

    Order order = new Order();

    public void addRequest(Book book, Warehouse warehouse){
        order.setStatus("новый");
        System.out.println(order.getStatus() + " заказ на книгу: " + book.getName());

        if (warehouse.isBookExist(book)){
            book.changeQuantity(-1);
            order.setStatus("выполнен");
            System.out.println("заказ " + order.getStatus());
        }
        else{
            System.out.println("Книга отстутствует. Сформирован запрос на книгу");
            this.statusRequest = true;
        }
    }

    public void deleteRequest(){
        statusRequest = false;
        order.setStatus("отменен");
        System.out.println("заказ " + order.getStatus());
    }
}
