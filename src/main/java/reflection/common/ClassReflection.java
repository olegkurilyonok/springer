package reflection.common;

public class ClassReflection implements ClassReflectionExample{
    protected String parentName;

    public ClassReflection() {
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Override
    public String toString() {
        return "ClassReflection{" +
                "parentName='" + parentName + '\'' +
                '}';
    }
}
