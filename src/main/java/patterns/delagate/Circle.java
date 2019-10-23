package patterns.delagate;

public class Circle implements ShapeWriter {

    @Override
    public void write() {
        System.out.println("Write circle!");
    }
}
