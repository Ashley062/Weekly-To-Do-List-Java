import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ToDoList toDoList = new ToDoList();
    String[] daysOfWeek = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };

    // Loop through each day of the week
    for (String currentDay : daysOfWeek) {
      boolean addMoreTasks = true;
      System.out.println("\n--- Add tasks for " + currentDay + " ---");

      // Loop to add multiple tasks for the same day
      while (addMoreTasks) {
        System.out.print("Enter task name: ");
        String taskName = scanner.nextLine();

        System.out.print("Enter priority (Low, Medium, High): ");
        String priority = scanner.nextLine();

        System.out.print("Should this task repeat? (Yes/No): ");
        boolean repeat = scanner.nextLine().equalsIgnoreCase("Yes");

        // Create and add task
        Task task = new Task(taskName, currentDay, priority, repeat);
        toDoList.addTask(task);

        // Ask if the user wants to add another task for the same day
        System.out.print("Do you want to add another task for " + currentDay + "? (Yes/No): ");
        String continueTask = scanner.nextLine();
        if (!continueTask.equalsIgnoreCase("Yes")) {
          addMoreTasks = false;
        }
      }

      // Ask if the user wants to move to the next day
      System.out.print("Do you want to move to the next day? (Yes/No): ");
      String continueToNextDay = scanner.nextLine();
      if (!continueToNextDay.equalsIgnoreCase("Yes")) {
        break;
      }
    }

    // Display all tasks after adding
    System.out.println("\n--- Here is your weekly task list ---");
    toDoList.displayAllTasks();

    scanner.close();
  }
}
