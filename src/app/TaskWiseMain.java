package app;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.Period;

public class TaskWiseMain {
    public static void main(String[] args) {
        // Create instances of tasks
        Task regularTask = new Task(1L, "Complete Documentation", "Finish writing project documentation", LocalDate.of(2024, 11, 15));

        // Event Task
        EventTask eventTask = new EventTask(
                2L, "Team Meeting", "Discuss project progress", LocalDate.of(2024, 11, 14),
                LocalDateTime.of(2024, 11, 14, 9, 0), LocalDateTime.of(2024, 11, 14, 10, 0),
                "Conference Room 1", new String[]{"Alice", "Bob", "Charlie"}
        );

        // Reminder Task
        ReminderTask reminderTask = new ReminderTask(
                3L, "Buy Supplies", "Purchase office supplies", LocalDate.of(2024, 11, 20),
                LocalDateTime.of(2024, 11, 19, 15, 30), "Reminder: Don't forget to buy the office supplies!"
        );

        // Recurring Task
        RecurringTask recurringTask = new RecurringTask(
                4L, "Weekly Sync", "Weekly team meeting", LocalDate.of(2024, 11, 10),
                Period.ofDays(7), LocalDate.of(2024, 11, 17), "Occurs every Sunday"
        );

        // Create Task Manager
        TaskManager<Task> taskManager = new TaskManagerImpl<>();

        // Add tasks to task manager
        taskManager.addTask(regularTask);
        taskManager.addTask(eventTask);
        taskManager.addTask(reminderTask);
        taskManager.addTask(recurringTask);

        // Display tasks
        System.out.println("All Tasks:");
        taskManager.getAllTasks().forEach(System.out::println);

        // Test EventTask specific functionality
        System.out.println("\nTesting EventTask functionality:");
        eventTask.displayEventDetails();
        System.out.println("Is the event ongoing? " + eventTask.isEventOnGoing());

        // Test ReminderTask functionality
        System.out.println("\nTesting ReminderTask functionality:");
        reminderTask.sendReminder();
        System.out.println("Is the reminder due? " + reminderTask.isReminderDue());

        // Test RecurringTask functionality
        System.out.println("\nTesting RecurringTask functionality:");
        recurringTask.executeRecurringTask();
        System.out.println("Next occurrence of the recurring task: " + recurringTask.calculateNextOccurrenceDate());

        // Remove a task and display again
        taskManager.removeTask(regularTask);
        System.out.println("\nTasks after removal:");
        taskManager.getAllTasks().forEach(System.out::println);
    }
}
