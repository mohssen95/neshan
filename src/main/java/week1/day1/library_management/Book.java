package week1.day1.library_management;

import java.util.Date;

public class Book extends Item implements Readable {

    private String contents;

    public Book(String title, String uniqueID, String contents, Date publishDate) {
        super(title, uniqueID,publishDate);
        this.contents = contents;
    }

    @Override
    public void borrow() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println(title + " has been returned.");
        } else {
            System.out.println(title + " wasn't borrowed.");
        }
    }

    public void getContents() {
        System.out.println("Contents of this book: " + contents);
    }

    @Override
    public void read() {
        //read book with volume v and speed s
        System.out.println("read book"+contents);
    }
}