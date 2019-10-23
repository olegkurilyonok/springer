package generics;

public class Animal<T> {
    T animal;

    public Animal() {
    }

    public Animal(T animal) {
        this.animal = animal;
    }

    public T getAnimal() {
        return animal;
    }

    public void setAnimal(T animal) {
        this.animal = animal;
    }
}
