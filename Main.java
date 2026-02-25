import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {

            System.out.println("\nВыберите задание:");
            System.out.println("1 — Point (3 точки)");
            System.out.println("2 — Line (3 линии по условию)");
            System.out.println("3 — Student (копирование оценок: Вася/Петя/Андрей)");
            System.out.println("4 — StudentV2 (Вася с оценками, Максим без)");
            System.out.println("5 — StudentV3 (средний балл и отличник)");
            System.out.println("0 — Выход");
            System.out.print("Ваш выбор: ");

            int choice = readInt(scanner);

            switch (choice) {
                case 1 -> taskPoint();
                case 2 -> taskLine();
                case 3 -> taskStudent();
                case 4 -> taskStudentV2();
                case 5 -> taskStudentV3();
                case 0 -> {
                    System.out.println("Завершение работы.");
                    running = false;
                }
                default -> System.out.println("Нет такого задания.");
            }
        }

        scanner.close();
    }

    private static void taskPoint() {

        Point p1 = new Point(3, 5);
        Point p2 = new Point(25, 6);
        Point p3 = new Point(7, 8);

        System.out.println("Точки:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }

    private static void taskLine() {
        Line line1 = new Line(new Point(1, 3), new Point(23, 8));

        Line line2 = new Line(new Point(5, 10), new Point(25, 10));

        Line line3 = new Line(line1.getStart(), line2.getEnd());

        System.out.println("После создания:");
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);

        line1.setStart(new Point(0, 0));
        line2.setEnd(new Point(30, 10));

        line3.setStart(line1.getStart());
        line3.setEnd(line2.getEnd());

        System.out.println("\nПосле изменения line1 и line2 (п.4):");
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);

        line1.setStart(new Point(-5, -5));

        System.out.println("\nПосле изменения line1 (п.5, line3 не меняется):");
        System.out.println(line1);
        System.out.println(line3);
    }

    private static void taskStudent() {

        int[] grades = {3, 4, 5};
        Student vasya = new Student("Вася", grades);

        Student petya = new Student("Петя", vasya.getGrades());

        petya.getGrades()[0] = 5;

        System.out.println("После изменения оценки Пети:");
        System.out.println(vasya);
        System.out.println(petya);

        int[] copy = vasya.getGrades().clone();
        Student andrey = new Student("Андрей", copy);

        vasya.getGrades()[1] = 2;

        System.out.println("\nПосле изменения оценки Васи:");
        System.out.println(vasya);
        System.out.println(andrey);
    }

    private static void taskStudentV2() {

        StudentV2 vasya = new StudentV2("Вася", new int[]{3, 4, 5});
        StudentV2 maxim = new StudentV2("Максим");

        System.out.println(vasya);
        System.out.println(maxim);
    }

    private static void taskStudentV3() {

        StudentV3 vasya = new StudentV3("Вася", 3, 4, 5, 4);
        StudentV3 petya = new StudentV3("Петя", 5, 5, 5, 5);

        printStudentInfo(vasya);
        System.out.println();
        printStudentInfo(petya);
    }

    private static void printStudentInfo(StudentV3 student) {
        System.out.println(student);
        System.out.println("Средний балл: " + student.getAverageGrade());
        System.out.println("Отличник: " + student.isExcellentStudent());
    }

    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Ошибка! Введите целое число: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
