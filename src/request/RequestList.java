package request;

import book.Book;

import java.util.ArrayList;
import java.util.List;

public class RequestList {
    private List<Request> requests;

    {
        requests = new ArrayList<>();
    }

    public void addRequest(Request request, Book book, int numBooks){
        request.setBook(book);

        request.addRequest(numBooks);

        requests.add(request);
    }
}
