package patterns.delagate;

public class Squad implements ShapeWriter {
    @Override
    public void write() {
        System.out.println("Write squad!");
    }
}
