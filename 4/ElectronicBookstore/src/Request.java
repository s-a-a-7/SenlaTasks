public class Request {
    private boolean statusRequest = false;

    Order order = new Order();

    public void addRequest(Book book, Warehouse warehouse){
        order.setStatus("новый");
        System.out.println(order.getStatus() + " заказ на книгу: " + "«" + book.getName() +  "»");

        if (warehouse.isBookExist(book) && book.getStatus()){
            book.changeQuantity(-1);
            order.setStatus("выполнен");
            System.out.println("заказ " + order.getStatus());
        }
        else{
            System.out.println("книга отстутствует, сформирован запрос на книгу");
            this.statusRequest = true;
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
                System.out.println("книга " + "«" + book.getName() +  "»" + " появилась");
                book.changeQuantity(-1);
                order.setStatus("выполнен");
                System.out.println(order.getStatus() + " заказ на книгу: " + "«" + book.getName() +  "»");
            }
            else{
                System.out.println("книга " + "«" + book.getName() +  "»" + " еще не появилась");
            }
        }
    }

}
