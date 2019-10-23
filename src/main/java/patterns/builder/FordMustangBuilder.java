package patterns.builder;

public class FordMustangBuilder extends CarBuilder {
    @Override
    void buildModel() {
        car.setModel("Ford Mustang");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Car.Transmission.AUTO);
    }

    @Override
    void buildMaxSpeed() {
        car.setMaxSpeed(320);
    }

    @Override
    void buildColor() {
        car.setColor(Car.CardColor.WHITE);
    }
}
