package order;

public class OrderDetails {
    public void getOrderDetails(OrdersList ordersList){
        System.out.println("\n  Номер Вашего заказа: " + ordersList.getOrderNum());
        ordersList.printOrdersBook();
    }
}
