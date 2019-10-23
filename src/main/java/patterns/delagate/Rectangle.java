package patterns.delagate;

public class Rectangle implements ShapeWriter {
    @Override
    public void write() {
        System.out.println("Write rectangle!");
    }
}
