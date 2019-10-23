package concurrency.lesson2;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Storage {
    private long id;
    private String model;
    private Long capacity;
}
