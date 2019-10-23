package reflection;

import org.junit.jupiter.api.Test;

public class ReflectionRunner {
    @Test
    public void runReflectionTest(){
        ReflectionExampleRunner reflectionExampleRunner = new ReflectionExampleRunner();
        try {
            reflectionExampleRunner.runReflection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
