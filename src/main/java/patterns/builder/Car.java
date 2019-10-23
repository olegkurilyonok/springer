package patterns.builder;

import lombok.Data;

@Data
public class Car {
    private String model;
    private Transmission transmission;
    private Integer maxSpeed;
    private CardColor color;

    public enum Transmission {
        AUTO,
        MANUAL
    }

    public enum CardColor {
        WHITE,
        RED,
        BLUE,
        BLACK,
        GREEN,
        BROWN,
        GRAY,
        YELLOW
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", transmission=" + transmission +
                ", maxSpeed=" + maxSpeed +
                ", color=" + color +
                '}';
    }
}
