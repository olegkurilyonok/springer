package patterns.builder;

public class MazdaCX9Builder extends CarBuilder{
    @Override
    void buildModel() {
        car.setModel("Mazda CX9");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Car.Transmission.MANUAL);
    }

    @Override
    void buildMaxSpeed() {
        car.setMaxSpeed(300);
    }

    @Override
    void buildColor() {
        car.setColor(Car.CardColor.RED);
    }
}
