package patterns.singletone;

import org.junit.jupiter.api.Test;

public class SingletonRunnerExample {

    @Test
    public void executeSingletonExample(){
        createSingletonFirst();
        createSingletonSecond();
    }

    private void createSingletonFirst() {
        SingleDataProcessor singleDataProcessor = SingleDataProcessor.getInstance();
        singleDataProcessor.setData("some data in singleton");
    }

    private void createSingletonSecond() {
        SingleDataProcessor singleDataProcessor = SingleDataProcessor.getInstance();
        System.out.println(singleDataProcessor.getData());
    }
}
