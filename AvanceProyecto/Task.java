public class Task {
    private String description;
    private String department;
    private int priority;
    private String type;

    public Task(String description, String department, int priority, String type) {
        this.description = description;
        this.department = department;
        this.priority = priority;
        this.type = type;
    }

    public String getDescription() { return description; }
    public String getDepartment() { return department; }
    public int getPriority() { return priority; }
    public String getType() { return type; }

    @Override
    public String toString() {
        return String.format("[%s] %s - %s (Prioridad: %d)", 
                            type, description, department, priority);
    }
}