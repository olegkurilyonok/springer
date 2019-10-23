package reflection.common;

public class ClassReflectionExampleImpl extends ClassReflection implements ClassReflectionExample{
    private String name;
    private Integer uniqueId;

    public ClassReflectionExampleImpl() {
    }

    public ClassReflectionExampleImpl(String name, Integer uniqueId) {
        this.name = name;
        this.uniqueId = uniqueId;
    }

    public String getName() {
        return name;
    }

    public Integer getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Integer uniqueId) {
        this.uniqueId = uniqueId;
    }
}
