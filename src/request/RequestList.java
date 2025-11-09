package request;

import book.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RequestList {
    private List<Request> requests;
    private final List<String> requestsBookTitle;

    {
        requests = new ArrayList<>();
        requestsBookTitle = new ArrayList<>();
    }

    public void addRequest(Request request, Book book){
        request.setBook(book);

        if (requestsBookTitle.contains(book.getTitle())){

            request.addRequest();

        } else{
            request.addRequest();

            requests.add(request);
            requestsBookTitle.add(book.getTitle());
        }
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void sortRequestList(){
        requests = requests.stream().
                sorted(Comparator.comparingInt(r -> r.getBook().getRequestsCount())).
                sorted(Comparator.comparing(r -> r.getBook().getTitle())).
                toList();
    }

    public void printRequests(){
        System.out.println("\n▷ Список запросов:");
        for (Request request : requests){
            System.out.println(request.toString());
        }
    }
}
