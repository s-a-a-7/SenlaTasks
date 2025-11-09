package order;

import book.Book;
import request.Request;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class Order {
    private final int orderNum;

    private Status status;

    private GregorianCalendar dateCreation;
    private GregorianCalendar dateCompletion;

    private int timeDeliveryDays;
    private int timeDeliveryHours;
    private int timeDeliveryMinutes;

    private final SimpleDateFormat df;

    private Book book;
    private final Request request;

    {
        orderNum = new Random().nextInt(1000);

        df = new SimpleDateFormat("dd MMMM yyyy HH:mm");

        timeDeliveryDays = 5;
        timeDeliveryHours = 17;
        timeDeliveryMinutes = 27;

        request = new Request();
    }

    public int getOrderNum() {
        return orderNum;
    }

    public Status getStatus() {
        return status;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    public Book getBook() {
        return book;
    }

    public Request getRequest(){
        return request;
    }

    private void setDateCreation(GregorianCalendar dateCreation) {
        this.dateCreation = dateCreation;
    }
    public Date getDateCreation() {
        return dateCreation.getTime();
    }

    private void setDateCompletion(GregorianCalendar dateCompletion) {
        this.dateCompletion = dateCompletion;
    }
    public Date getDateCompletion() {
        return dateCompletion.getTime();
    }

    public int getTimeDeliveryDays() {
        return timeDeliveryDays;
    }
    public int getTimeDeliveryHours() {
        return timeDeliveryHours;
    }
    public int getTimeDeliveryMinutes() {
        return timeDeliveryMinutes;
    }

    public void setTimeDelivery(int days, int hours, int minutes) {
        this.timeDeliveryDays = days;
        this.timeDeliveryHours = hours;
        this.timeDeliveryMinutes = minutes;
    }

    public SimpleDateFormat getDf() {
        return df;
    }

    public void addOrder(){
        this.status = Status.NEW;

        setDateCreation(new GregorianCalendar());
    }

    public void cancelOrder(){
        this.status = Status.CANCEL;
    }

    public void processOrder(){
        this.status = Status.PROCESS;
    }

    public void completeOrder(){
        this.status = Status.DONE;

        this.book.changeBooksCount(1, false, true);

        setDateCompletion(dateCreation);
        // добавляем время доставки
        this.dateCompletion.add(GregorianCalendar.DATE, getTimeDeliveryDays());
        this.dateCompletion.add(GregorianCalendar.HOUR, getTimeDeliveryHours());
        this.dateCompletion.add(GregorianCalendar.MINUTE, getTimeDeliveryMinutes());
    }


    @Override
    public String toString() {
        String s;
        if (getStatus() == Status.DONE){
            s = "выполнения: " + df.format(dateCompletion.getTime());
        }else {
            s = "создания: " + df.format(dateCreation.getTime());
        }

        return "    номер: " + orderNum +
                " | дата и время " + s +
                " | цена: " + book.getPrice() +
                " | статус: " + status +
                " | книга: " + book.getTitle();
    }
}
