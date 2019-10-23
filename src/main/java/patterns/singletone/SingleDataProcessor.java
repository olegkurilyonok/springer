package patterns.singletone;

import lombok.Data;

@Data
public class SingleDataProcessor {
    private String data;
    private static SingleDataProcessor instance;

    private SingleDataProcessor() {
    }

    public static SingleDataProcessor getInstance() {
        if (instance == null)
            instance = new SingleDataProcessor();
        return instance;
    }
}
