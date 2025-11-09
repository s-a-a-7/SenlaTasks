package request;

import book.Book;

public class Request {
    Book book;

    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }

    public void addRequest(){
        book.changeRequestsCount(true);
    }
    public void delRequest(){
        book.changeRequestsCount(false);
    }

    @Override
    public String toString() {
        return "    книга: " + book.getTitle() +
                " | кол-во запрсов: " + book.getRequestsCount();
    }
}