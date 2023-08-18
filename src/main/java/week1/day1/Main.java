package week1.day1;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Book myBook = new Book("lord of rings", "504", "Beginning... End.",new Date());
        AudioBook myDVD = new AudioBook("Inception", "67890",new Date());

        myBook.borrow();
        myBook.getContents();
        myBook.returnItem();

        myDVD.borrow();
        myDVD.play(4);
        myDVD.returnItem();

    }
}