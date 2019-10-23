package patterns.factory.hitech;

import patterns.factory.FurnitureFactory;

public class HighTechFutureFactory implements FurnitureFactory {
    @Override
    public HighTechChair getChair() {
        return new HighTechChair();
    }

    @Override
    public HighTechTable getTable() {
        return new HighTechTable();
    }

    @Override
    public HighTechSofa getSofa() {
        return new HighTechSofa();
    }
}
