import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Library {
    List<Book> arraylistBooks;
    Map<String, Book> hashmapBooks;
    TreeMap<String, Book> treemapBooks;

    public Library() {
        arraylistBooks = new ArrayList<>();
        hashmapBooks = new HashMap<>();
        treemapBooks = new TreeMap<>();
    }

    public void addBook(Book book) {
        arraylistBooks.add(book); // O(1)
    }

    public void addBook2(Book book) {
        hashmapBooks.put(book.getId(), book); // O(1)
    }

    public void addBook3(Book book) {
        treemapBooks.put(book.getId(), book); // O(log n)
    }

    public Book searchBook(String id) {
        for (int i = 0; i < arraylistBooks.size(); i++) {
            if (arraylistBooks.get(i).getId().equals(id)) {
                return arraylistBooks.get(i); // O(n) tùy thuộc vào vị trí của sách
            }
        }
        return null;
    }

    public Book searchBook2(String id) {
        return hashmapBooks.get(id); // O(1)
    }

    public Book searchBook3(String id) {
        return treemapBooks.get(id); // O(log n)
    }

    public void removeBook(String id) {
        for (int i = 0; i < arraylistBooks.size(); i++) {
            if (arraylistBooks.get(i).getId().equals(id)) {
                arraylistBooks.remove(i); // O(1) đến O(n)
                break;
            }
        }
    }

    public void removeBook2(String id) {
        hashmapBooks.remove(id); // O(1) nhanh nhất, O(log n) chậm nhất nếu comparable, O(n) nếu không comparable
    }

    public void removeBook3(String id) {
        treemapBooks.remove(id); // O(log n)
    }

    public void printBooks() {
        for (int i = 0; i < arraylistBooks.size(); i++) {
            System.out.println(arraylistBooks.get(i)); // O(n)
        }
    }

    public void printBooks2() {
        for (String id : hashmapBooks.keySet()) {
            System.out.println(hashmapBooks.get(id)); // O(n)
        }
    }

    public void printBooks3() {
        for (String id : treemapBooks.keySet()) {
            System.out.println(treemapBooks.get(id)); // O(n log n)
        }
    }
}
