package order;

import book.Book;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Order {

    private Status status;

    private GregorianCalendar dateCreation;
    private GregorianCalendar dateCompletion;

    private int timeDeliveryDays;
    private int timeDeliveryHours;
    private int timeDeliveryMinutes;

    private final SimpleDateFormat df;

    private Book book;

    {
        df = new SimpleDateFormat("dd MMM yyyy HH:mm");

        timeDeliveryDays = 5;
        timeDeliveryHours = 17;
        timeDeliveryMinutes = 27;
    }

    private void setStatus(Status status) {
        this.status = status;
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

    public SimpleDateFormat getDf() {
        return df;
    }

    public void addOrder(){
        setStatus(Status.NEW);

        setDateCreation(new GregorianCalendar());
    }
    public void cancelOrder(){
        setStatus(Status.CANCEL);

//        if (status == Status.DONE){
//            book.changeBooksCount(book.getBooksCount(), true, false);
//        } else if (status == Status.PROCESS) {
//
//        }
    }
    public void processOrder(){
        setStatus(Status.PROCESS);
    }
    public void completeOrder(){
        setStatus(Status.DONE);

        setDateCompletion(dateCreation);
        // добавляем время доставки
        this.dateCompletion.add(GregorianCalendar.DATE, getTimeDeliveryDays());
        this.dateCompletion.add(GregorianCalendar.HOUR, getTimeDeliveryHours());
        this.dateCompletion.add(GregorianCalendar.MINUTE, getTimeDeliveryMinutes());
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

    @Override
    public String toString() {
        String s;
        if (getStatus() == Status.DONE){
            s = "выполнения :" + df.format(dateCompletion);
        }else {
            s = "создания: " + df.format(dateCreation);
        }

        return "   дата и время " + s +
                " | цена: " + book.getPrice() +
                " | статус: " + status +
                " | книга: " + book.getTitle() + "\n";
    }
}
