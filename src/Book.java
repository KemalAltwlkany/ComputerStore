import java.time.LocalDate;

public class Book extends Item {
    private String title;
    private String author;
    private LocalDate publishDate;

    public Book(){
        super();
        author = null;
        publishDate = LocalDate.now();
    }

    public Book(String title, String author, LocalDate publishDate, String name, int baseRentPrice, int basePurchasePrice){
        super(name, baseRentPrice, basePurchasePrice);
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }
}
