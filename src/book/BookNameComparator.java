package book;

import java.util.Comparator;

class BookNameComparator implements Comparator<Book> {
    @Override
    public int compare(Book a, Book b){
        return a.getName().compareTo(b.getName());
    }
}
