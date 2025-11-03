public class OrderDetails {
    public void getOrderDetails(OrderList orderList){
        System.out.println("\n  Номер Вашего заказа: " + orderList.getOrderNum());
        orderList.printOrdersBook();
    }
}
