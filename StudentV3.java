import java.util.Arrays;

public class StudentV3 {

    private String name;
    private int[] grades;

    public StudentV3(String name, int... grades) {
        this.name = name;
        this.grades = grades;
    }

    // средний балл
    public double getAverageGrade() {
        if (grades.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    // проверка: отличник или нет
    public boolean isExcellentStudent() {
        if (grades.length == 0) {
            return false;
        }

        for (int grade : grades) {
            if (grade != 5) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return name + ": " + Arrays.toString(grades);
    }
}
