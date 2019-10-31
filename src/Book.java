import java.time.LocalDate;

public class Book extends Item {
    private String title;
    private String author;
    private LocalDate publishDate;

    public Book(){
        super("Book");
        author = null;
        publishDate = LocalDate.now();
    }

    public Book(String title, String author, LocalDate publishDate, double baseRentPrice, double basePurchasePrice){
        super("Book", baseRentPrice, basePurchasePrice);
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
    return  "Book={" +
            "title='" + title + '\'' +
            ", author='" + author + '\'' +
            ", publishDate=" + publishDate +
            ", description='" + description + '\'' +
            ", baseRentPrice=" + baseRentPrice +
            ", basePurchasePrice=" + basePurchasePrice +
            '}';
    }
}
