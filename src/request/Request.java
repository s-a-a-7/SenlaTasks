package request;

import book.Book;

public class Request {
    Book book;
    private boolean isRequest;

    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }

    public boolean getIsRequest() {
        return isRequest;
    }
    public void setIsRequest(boolean isRequest) {
        this.isRequest = isRequest;
    }

    public void addRequest(int numBooks){
        setIsRequest(true);

        book.changeRequestsCount(isRequest);
    }
    public void delRequest(int numBooks){
        setIsRequest(false);

        book.changeRequestsCount(isRequest);
    }

    @Override
    public String toString() {
        return "    кол-во запрсов: " + book.getRequestsCount() +
                " | книга: " + book.getTitle() + "\n";
    }
}