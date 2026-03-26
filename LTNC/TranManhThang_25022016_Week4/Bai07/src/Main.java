import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;

        int studentAmount = sc.nextInt();

        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < studentAmount; i++) {
            students.add(new Student(sc.next(), sc.next(), sc.nextDouble()));
            sc.nextLine();
        }

        students.removeIf(student -> student.getGpa() < 5.0);

        System.out.println("After removing GPA < 5.0:");

        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }

        System.out.println();

        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
        System.out.println("After sorting by name:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
    }
}
