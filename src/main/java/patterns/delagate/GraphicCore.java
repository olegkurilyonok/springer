package patterns.delagate;

public class GraphicCore {
    ShapeWriter shapeForWrite;

    public GraphicCore(ShapeWriter shapeForWrite) {
        this.shapeForWrite = shapeForWrite;
    }

    public void setShapeForWrite(ShapeWriter shapeForWrite) {
        this.shapeForWrite = shapeForWrite;
    }

    public void write(){
        shapeForWrite.write();
    }

}
