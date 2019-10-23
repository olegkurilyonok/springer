package patterns.builder;

import org.junit.jupiter.api.Test;

public class BuilderPatternExample {

    @Test
    public void builderPatternExample() {
        Director director = new Director(new HondaCivicBuilder());
        Car hondaCivic = director.build();
        director.setCarBuilder(new MazdaCX9Builder());
        Car mazdaCX9 = director.build();
        director.setCarBuilder(new FordMustangBuilder());
        Car fordMustang = director.build();

        System.out.println(hondaCivic);
        System.out.println(mazdaCX9);
        System.out.println(fordMustang);
    }
}
