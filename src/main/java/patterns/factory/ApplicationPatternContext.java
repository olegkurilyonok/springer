package patterns.factory;

public class ApplicationPatternContext {
    private FurnitureFactory factory;

    public ApplicationPatternContext(FurnitureFactory factory) {
        this.factory = factory;
    }

    public FurnitureFactory getFactory() {
        return factory;
    }
}
