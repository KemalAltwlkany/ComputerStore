import java.time.LocalDate;
import java.util.Comparator;

public class Book extends Item {
    private String title; //maximum 100 characters
    private String author; //maximum 50 characters
    private LocalDate publishDate;

    public Book(){
        super();
        author = null;
        title = null;
        publishDate = LocalDate.now();
    }

    public Book(String title, String author, LocalDate publishDate, double baseRentPrice, double basePurchasePrice){
        super(baseRentPrice, basePurchasePrice);
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
    }

    //copy constructor
    public Book(Book other) {
        super(other);
        this.title = other.title;
        this.author = other.author;
        this.publishDate = other.publishDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        //max title length 100 characters
        if (title.length() > 100){
            return;
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        //max author length 50 characters
        if (author.length() > 50){
            return;
        }
        this.author = author;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        //the LocalDate class itself ensures the date is valid.
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", baseRentPrice=" + baseRentPrice +
                ", basePurchasePrice=" + basePurchasePrice +
                ", available=" + available +
                '}';
    }

    @Override
    public String verboseToString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishDate=" + publishDate +
                ", description=" + description +
                ", baseRentPrice=" + baseRentPrice +
                ", basePurchasePrice=" + basePurchasePrice +
                ", available=" + available +
                '}';
    }

    //Update 02.12.2019.
    //Two books are equal if they have the same author, publish date and title

    @Override
    public boolean equals(Object obj) {
        //Are the references pointing to the same address in memory?
        if (obj == this) {
            return true;
        }

        //If obj isn't an instance of class Book then it is obviously not a book
        if (!(obj instanceof Book)) {
            return false;
        }

        //obj is certainly an instance of class Book and can be casted to Book
        Book b2 = (Book) obj;
        if (this.getTitle().equals(b2.getTitle()) && this.getAuthor().equals(b2.getAuthor()) && this.getPublishDate().equals(b2.getPublishDate())){
            return true;
        }
        return false;
    }

}
