import java.util.Arrays;

public class StudentV2 {

    private String name;
    private int[] grades;

    public StudentV2(String name, int... grades) {
        this.name = name;

        if (grades.length == 0) {
            this.grades = new int[0];
        } else {
            this.grades = grades;
        }
    }

    @Override
    public String toString() {
        return name + ": " + Arrays.toString(grades);
    }
}
