import java.util.Scanner;

public class Main {
    static void useString() {
        long startTime = System.currentTimeMillis();
        String noo = "";
        for(int i = 0; i < 100000; i++) {
            noo += "Hello";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime));
    }

    static void useStringBuffer() {
        long startTime = System.currentTimeMillis();
        StringBuffer noo = new StringBuffer("");
        for(int i = 0; i < 100000; i++) {
            noo.append("Hello");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime));
    }

    static void contentAnalysis(String whatever) {
        System.out.println("Amount of sentence: " + (2 * whatever.length() - whatever.replace(".", "").length() - whatever.replace(",", "").length()));
        whatever = whatever.replaceAll("Java", "Python");
        System.out.println(whatever);
    }

    public static void main(String[] args) {
        useString();
        useStringBuffer();

        contentAnalysis("Cat is Java, I think.");        
    }
}
