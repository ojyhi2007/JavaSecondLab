public class PointV2 {
    private int x;
    private int y;

    // единственный конструктор
    public PointV2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}
