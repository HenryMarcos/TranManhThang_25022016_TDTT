public class Main {
    public static void main(String[] args) {
        Library lib = new Library();

        Book b1 = new Book("Fish", "Cat", 1995);
        Book b2 = new Book("E", "Dog", 1997);
        Book b3 = new Book("The cat and not the dog", "Cow", 2099);
        Book b4 = new Book("Somtime", "Shakeapple", 600);
        Book b5 = new Book("Manual water pump", "Worker", 1977);

        lib.addBook(b1);
        lib.addBook(b2);
        lib.addBook(b3);
        lib.addBook(b4);
        lib.addBook(b5);

        lib.addBook2(b1);
        lib.addBook2(b2);
        lib.addBook2(b3);
        lib.addBook2(b4);
        lib.addBook2(b5);

        lib.addBook3(b1);
        lib.addBook3(b2);
        lib.addBook3(b3);
        lib.addBook3(b4);
        lib.addBook3(b5);

        Book searchedBook = lib.searchBook("2");
        Book searchedBook2 = lib.searchBook2("3");
        Book searchedBook3 = lib.searchBook3("4");

        System.out.println("Searched books:");
        System.out.println(searchedBook);
        System.out.println(searchedBook2);
        System.out.println(searchedBook3);

        lib.removeBook("2");
        lib.removeBook2("3");
        lib.removeBook3("4");

        System.out.println("Book List 1:");
        lib.printBooks();
        System.out.println("Book List 2:");
        lib.printBooks2();
        System.out.println("Book List 3:");
        lib.printBooks3();
    }

    // Số lượng sách nhỏ: ArrayList
    // Số lượng sách rất lớn: Hashmap
    // Sắp xếp theo id: Treemap
}
