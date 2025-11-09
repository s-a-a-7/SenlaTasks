package book;

public class Book {
    private final String title;
    private int year;
    private int price;

    private boolean isExist;
    private int booksCount;

    private int requestsCount;

    {
        booksCount = 0;
        isExist = false;

        requestsCount = 0;
    }

    public Book(String title, int year, int price) {
        this.title = title;
        this.year = year;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isExist() {
        return isExist;
    }
    public void setIsExist(boolean isExist) {
        this.isExist = isExist;
    }
// количество книг
    public int getBooksCount() {
        return booksCount;
    }
    public void setBooksCount(int booksCount){
        this.booksCount = booksCount;
    }
    public void changeBooksCount(int numBooks, boolean isAdd, boolean isOrdered) {
        if (isAdd && !isOrdered){
            this.booksCount += numBooks;
        } else if(isOrdered && !isAdd){
            this.booksCount -= numBooks;
        }
        if (this.booksCount > 0) {
            this.isExist = true;
        } else {
            this.isExist = false;
            booksCount = 0;
        }
    }
// количесво запросов на книгу
    public int getRequestsCount() {
        return requestsCount;
    }
    public void changeRequestsCount(boolean isRequest) {
        if (isRequest) {
            requestsCount++;
        } else {
            requestsCount--;
        }
    }
// toString
    @Override
    public String toString() {
        String isEx;
        if (isExist){
            isEx = " | в наличии " + booksCount;
        } else{
            isEx = " | нет в наличии";
        }

        return "    название: «" + title + "»" +
                " | год издания: " + year +
                " | цена: " + price +
                isEx;
    }
}