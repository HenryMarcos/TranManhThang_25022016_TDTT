public class Book {
    private static int idNumber = 0;
    private String id;
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.id = String.valueOf(idNumber);
        this.title = title;
        this.author = author;
        this.year = year;

        idNumber += 1;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Title: " + title + ", Author: " + author + ", Year: " + year;
    }
}
