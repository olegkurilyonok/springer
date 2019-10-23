package generics;

import org.junit.jupiter.api.Test;

public class GenericRunner {
    @Test
    public void runGenerics() {
        Animal<Cat> animal = new Animal<Cat>(new Cat());
        System.out.println(animal.getAnimal().getClass());
    }
}
