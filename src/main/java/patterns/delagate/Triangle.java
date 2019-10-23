package patterns.delagate;

public class Triangle implements ShapeWriter {
    @Override
    public void write() {
        System.out.println("Write triangle!");
    }
}
