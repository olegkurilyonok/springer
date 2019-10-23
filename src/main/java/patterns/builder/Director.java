package patterns.builder;

public class Director {
    CarBuilder builder;

    public Director() {
    }

    public Director(CarBuilder builder) {
        this.builder = builder;
    }

    public void setCarBuilder(CarBuilder builder) {
        this.builder = builder;
    }

    Car build() {
        builder.createCar();
        builder.buildModel();
        builder.buildTransmission();
        builder.buildMaxSpeed();
        builder.buildColor();
        return builder.getCar();
    }
}
