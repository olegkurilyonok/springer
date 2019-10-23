package patterns.factory.victorian;

import patterns.factory.FurnitureFactory;

public class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public VictorianChair getChair() {
        return new VictorianChair();
    }

    @Override
    public VictorianTable getTable() {
        return new VictorianTable();
    }

    @Override
    public VictorianSofa getSofa() {
        return new VictorianSofa();
    }
}
