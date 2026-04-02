import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;

        int mediaAmount = sc.nextInt();

        LibrarySection<Book> bookLibrarySection = new LibrarySection<>();
        LibrarySection<DVD> dvdLibrarySection = new LibrarySection<>();

        for (int i = 0; i < mediaAmount; i++) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();
            String author = sc.next();
            int number = sc.nextInt();
            switch (type) {
                case "B":
                    Book bk = new Book(id, name, author, number);
                    bookLibrarySection.addMedia(bk);
                    break;
                case "D":
                    DVD dvd = new DVD(id, name, author, number);
                    dvdLibrarySection.addMedia(dvd);
                    break;
                default:
                    break;
            }
            sc.nextLine();
        }

        System.out.println("Khu vực Sách:");
        bookLibrarySection.showInventoryInfo();

        System.out.println();

        System.out.println("Khu vực DVD");
        dvdLibrarySection.showInventoryInfo();

        sc.close();
    }
}
