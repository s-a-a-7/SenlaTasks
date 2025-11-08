package request;

import book.Book;

import java.util.ArrayList;
import java.util.List;

public class RequestList {
    private List<Request> requests;

    {
        requests = new ArrayList<>();
    }

    public void addRequest(Request request, Book book){

        if (requests.contains(request)){

            request.addRequest();

        } else{
            request.setBook(book);

            request.addRequest();

            requests.add(request);
        }
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void printRequests(){
        System.out.println("\n▷ Список запросов:");
        for (Request request : requests){
            System.out.println(request.toString());
        }
    }
}
