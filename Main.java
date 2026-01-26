import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {

            System.out.println("\nВыберите задание:");
            System.out.println("1 — Точка (Point)");
            System.out.println("2 — Линии (Line)");
            System.out.println("3 — Студент (копирование оценок)");
            System.out.println("4 — Студент V2 (один конструктор)");
            System.out.println("5 — Студент-отличник (StudentV3)");
            System.out.println("0 — Выход");
            System.out.print("Ваш выбор: ");

            int choice = readInt(scanner);

            switch (choice) {
                case 1 -> taskPoint(scanner);
                case 2 -> taskLine();
                case 3 -> taskStudent();
                case 4 -> taskStudentV2(scanner);
                case 5 -> taskStudentV3();   // ⬅ БЕЗ ВВОДА
                case 0 -> {
                    System.out.println("Завершение работы.");
                    running = false;
                }
                default -> System.out.println("Нет такого задания.");
            }
        }

        scanner.close();
    }

    private static void taskPoint(Scanner scanner) {
        System.out.print("Введите X: ");
        int x = readInt(scanner);

        System.out.print("Введите Y: ");
        int y = readInt(scanner);

        Point p = new Point(x, y);
        System.out.println("Создана точка: " + p);
    }

    private static void taskLine() {

        Line line1 = new Line(new Point(1, 3), new Point(23, 8));
        Line line2 = new Line(new Point(5, 10), new Point(25, 10));
        Line line3 = new Line(line1.getStart(), line2.getEnd());

        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);

        line1.setStart(new Point(0, 0));
        line2.setEnd(new Point(30, 10));

        System.out.println("После изменения:");
        System.out.println(line3);

        line1.setStart(new Point(-5, -5));
        System.out.println("После замены линии 1:");
        System.out.println(line3);
    }

    private static void taskStudent() {

        int[] grades = {3, 4, 5};
        Student vasya = new Student("Вася", grades);
        Student petya = new Student("Петя", vasya.getGrades());

        petya.getGrades()[0] = 5;

        System.out.println(vasya);
        System.out.println(petya);
    }

    private static void taskStudentV2(Scanner scanner) {

        System.out.print("Введите имя: ");
        String name = scanner.next();

        System.out.print("Количество оценок: ");
        int count = readInt(scanner);

        if (count == 0) {
            StudentV2 student = new StudentV2(name);
            System.out.println(student);
            return;
        }

        int[] grades = new int[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Оценка " + (i + 1) + ": ");
            grades[i] = readInt(scanner);
        }

        StudentV2 student = new StudentV2(name, grades);
        System.out.println(student);
    }

    private static void taskStudentV3() {

        StudentV3 vasya = new StudentV3("Вася", 3, 4, 5, 4);
        StudentV3 petya = new StudentV3("Петя", 5, 5, 5, 5);

        printStudentInfo(vasya);
        System.out.println();
        printStudentInfo(petya);
    }

    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Ошибка! Введите целое число: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void printStudentInfo(StudentV3 student) {
        System.out.println(student);
        System.out.println("Средний балл: " + student.getAverageGrade());
        System.out.println("Отличник: " + student.isExcellentStudent());
    }
}
