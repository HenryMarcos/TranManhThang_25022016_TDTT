public class Book extends MediaItem {
    private String author;
    private int pageAmount;

    public Book(String id, String name, String author, int pageAmount) {
        super(id, name);
        this.author = author;
        this.pageAmount = pageAmount;
    }

    @Override
    public String toString() {
        return name + " - " + author + " - " + pageAmount;
    }
}
