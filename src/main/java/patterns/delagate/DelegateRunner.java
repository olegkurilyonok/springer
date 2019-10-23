package patterns.delagate;

import org.junit.jupiter.api.Test;

public class DelegateRunner {
    @Test
    public void runDelegatePattern(){
            GraphicCore core = new GraphicCore(new Circle());
            GraphicCore core1 = new GraphicCore(new Rectangle());
            GraphicCore core2 = new GraphicCore(new Triangle());
            GraphicCore core3 = new GraphicCore(new Squad());

            core.write();
            core1.write();
            core2.write();
            core3.write();
    }
}
