package patterns.builder;

public class HondaCivicBuilder extends CarBuilder {
    @Override
    void buildModel() {
        car.setModel("Honda Civic");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Car.Transmission.AUTO);
    }

    @Override
    void buildMaxSpeed() {
        car.setMaxSpeed(260);
    }

    @Override
    void buildColor() {
        car.setColor(Car.CardColor.BLACK);
    }
}
