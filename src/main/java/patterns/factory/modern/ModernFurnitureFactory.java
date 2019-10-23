package patterns.factory.modern;

import patterns.factory.FurnitureFactory;

public class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public ModernChair getChair() {
        return new ModernChair();
    }

    @Override
    public ModernTable getTable() {
        return new ModernTable();
    }

    @Override
    public ModernSofa getSofa() {
        return new ModernSofa();
    }
}
