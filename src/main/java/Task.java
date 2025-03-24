import java.util.Comparator;

public class Task {
    private String name;
    private String day;
    private String priority;
    private boolean repeat;

    // Constructor
    public Task(String name, String day, String priority, boolean repeat) {
        this.name = name;
        this.day = day;
        this.priority = priority;
        this.repeat = repeat;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDay() {
        return day;
    }

    public String getPriority() {
        return priority;
    }

    public boolean isRepeat() {
        return repeat;
    }

    // Get priority value for sorting (High = 3, Medium = 2, Low = 1)
    public int getPriorityValue() {
        switch (priority) {
            case "High":
                return 3;
            case "Medium":
                return 2;
            case "Low":
                return 1;
            default:
                return 0;
        }
    }

    // Task details as a string
    @Override
    public String toString() {
        String repeatText = repeat ? " (Repeats)" : "";
        return name + " (Priority: " + priority + ")" + repeatText;
    }

    // Comparator for sorting by priority
    public static Comparator<Task> priorityComparator = (task1, task2) -> Integer.compare(task2.getPriorityValue(),
            task1.getPriorityValue());
}
