package week1.day1.library_management;

import java.util.Date;

public abstract class Item {
    //
    protected String title;
    protected String uniqueID;
    protected boolean isBorrowed;

    protected Date publishedDate;

    public Item(String title, String uniqueID,Date publishedDate) {
        this.title = title;
        this.uniqueID = uniqueID;
        this.isBorrowed = false;
        this.publishedDate=publishedDate;
    }

    public String getTitle() {
        return title;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }
    public Date getPublishedDate() {
        return publishedDate;
    }


    public abstract void borrow();
    public abstract void returnItem();
}
