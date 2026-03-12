public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override 
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Book)) return false;

        Book otherBook = (Book) other;

        return this.title == otherBook.title && 
               this.author == otherBook.author && 
               this.price == otherBook.price;
    }

    public static void main(String[] args) {
        Book book1 = new Book("Fish cat", "Fhis", 69420);
        Book book2 = new Book("Fish cat", "Fhis", 69420);
        if (book1.equals(book2)) System.out.println("2 book are the same");
    }
}
