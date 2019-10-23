package patterns;

import org.junit.jupiter.api.Test;
import patterns.factory.ApplicationPatternContext;
import patterns.factory.hitech.HighTechFutureFactory;
import patterns.factory.modern.ModernFurnitureFactory;
import patterns.factory.victorian.VictorianFurnitureFactory;

public class PatternsRunner {
    @Test
    public void main() {

        ApplicationPatternContext patternContext = new ApplicationPatternContext(new HighTechFutureFactory());
        System.out.println(patternContext.getFactory().getChair().getClass());

        patternContext = new ApplicationPatternContext(new ModernFurnitureFactory());
        System.out.println(patternContext.getFactory().getChair().getClass());

        patternContext = new ApplicationPatternContext(new VictorianFurnitureFactory());
        System.out.println(patternContext.getFactory().getChair().getClass());
    }
}
