package week1.day1.library_management;

import java.util.Date;

public class AudioBook extends Item implements Playable {

    public AudioBook(String title, String uniqueID,Date publishDate) {
        super(title, uniqueID,  publishDate);
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

    @Override
    public void play(int volume) {
        System.out.println("Playing the audio book with volume : "+volume + title);
    }
}