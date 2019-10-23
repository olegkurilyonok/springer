package patterns.builder;

public abstract class CarBuilder {
    protected Car car;

    void createCar() {
        car = new Car();
    }

    abstract void buildModel();

    abstract void buildTransmission();

    abstract void buildMaxSpeed();

    abstract void buildColor();

    Car getCar() {
        return car;
    }
}
