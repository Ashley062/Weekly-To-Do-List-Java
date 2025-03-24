import java.util.*;

public class ToDoList {
  private Map<String, List<Task>> tasks;
  private List<String> daysInOrder;

  // Constructor: Initialize task map for each day
  public ToDoList() {
    tasks = new HashMap<>();
    daysInOrder = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");

    // Create an empty list for each day
    for (String day : daysInOrder) {
      tasks.put(day, new ArrayList<>());
    }
  }

  // Add task to the list
  public void addTask(Task task) {
    tasks.get(task.getDay()).add(task);
    System.out.println("Task added: " + task.toString());
  }

  // Sort tasks by priority before displaying
  private void sortTasksByPriority(List<Task> taskList) {
    taskList.sort(Task.priorityComparator);
  }

  // Display tasks for a given day
  public void displayTasks(String day) {
    List<Task> taskList = tasks.get(day);
    if (taskList.isEmpty()) {
      System.out.println(day + ":\nNo tasks for " + day + ".");
    } else {
      // Sort tasks for the current day before displaying
      sortTasksByPriority(taskList);
      System.out.println(day + ":");
      for (int i = 0; i < taskList.size(); i++) {
        System.out.println((i + 1) + ". " + taskList.get(i).toString());
      }
    }
  }

  // Display all tasks for the week in order (Monday to Sunday)
  public void displayAllTasks() {
    for (String day : daysInOrder) {
      displayTasks(day);
      System.out.println(); // Add a blank line after each day's tasks
    }
  }
}
