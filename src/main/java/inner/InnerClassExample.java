package inner;

import org.junit.jupiter.api.Test;

public class InnerClassExample {
    @Test
    public void runInnerExamples() {
        MonitoringSystem general = new MonitoringSystem() {
            public void startMonitoring() {
                System.out.println("run general monitoring");
            }
        };

        MonitoringSystem network = new MonitoringSystem() {
            public void startMonitoring() {
                System.out.println("run network monitoring");
            }
        };

        MonitoringSystem filesystem = new MonitoringSystem() {
            public void startMonitoring() {
                System.out.println("run filesystem monitoring");
            }
        };

        general.startMonitoring();
        network.startMonitoring();
        filesystem.startMonitoring();
    }
}
