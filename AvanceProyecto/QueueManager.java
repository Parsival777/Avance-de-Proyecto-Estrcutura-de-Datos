import java.util.LinkedList;
import java.util.Queue;

public class QueueManager {
    private Queue<Task> scheduledTasks;

    public QueueManager() {
        scheduledTasks = new LinkedList<>();
    }

    public void enqueue(Task task) {
        scheduledTasks.add(task);
        System.out.println("Tarea programada agregada: " + task.getDescription());
    }

    public Task dequeue() {
        if (scheduledTasks.isEmpty()) {
            System.out.println("No hay tareas programadas pendientes");
            return null;
        }
        Task task = scheduledTasks.poll();
        System.out.println("Tarea programada completada: " + task.getDescription());
        return task;
    }

    public Task front() {
        if (scheduledTasks.isEmpty()) {
            System.out.println("No hay tareas programadas pendientes");
            return null;
        }
        return scheduledTasks.peek();
    }

    public boolean isEmpty() {
        return scheduledTasks.isEmpty();
    }

    public void display() {
        if (scheduledTasks.isEmpty()) {
            System.out.println("No hay tareas programadas pendientes");
            return;
        }
        System.out.println("\n=== TAREAS PROGRAMADAS (COLA) ===");
        int count = 1;
        for (Task task : scheduledTasks) {
            System.out.println(count++ + ". " + task);
        }
    }
}