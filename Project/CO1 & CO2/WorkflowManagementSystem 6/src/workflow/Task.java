package workflow;

public class Task {
    private String name;
    private int complexityLevel;

    public Task(String name, int complexityLevel) {
        this.name = name;
        this.complexityLevel = complexityLevel;
    }

    public String getName() {
        return name;
    }

    public int getComplexityLevel() {
        return complexityLevel;
    }
}
