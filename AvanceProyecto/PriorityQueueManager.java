import java.util.PriorityQueue;
import java.util.Comparator;

public class PriorityQueueManager {
    private PriorityQueue<Task> priorityTasks;

    public PriorityQueueManager() {
        priorityTasks = new PriorityQueue<>(Comparator.comparingInt(Task::getPriority));
    }

    public void add(Task task) {
        priorityTasks.add(task);
        System.out.println("Tarea prioritaria agregada: " + task.getDescription());
    }

    public Task remove() {
        if (priorityTasks.isEmpty()) {
            System.out.println("No hay tareas prioritarias pendientes");
            return null;
        }
        Task task = priorityTasks.poll();
        System.out.println("Tarea prioritaria completada: " + task.getDescription());
        return task;
    }

    public Task peek() {
        if (priorityTasks.isEmpty()) {
            System.out.println("No hay tareas prioritarias pendientes");
            return null;
        }
        return priorityTasks.peek();
    }

    public boolean isEmpty() {
        return priorityTasks.isEmpty();
    }

    public PriorityQueue<Task> getQueue() {
        return new PriorityQueue<>(priorityTasks);
    }

    public void display() {
        if (priorityTasks.isEmpty()) {
            System.out.println("No hay tareas prioritarias pendientes");
            return;
        }
        System.out.println("\n=== TAREAS PRIORITARIAS (COLA DE PRIORIDAD) ===");

        PriorityQueue<Task> copy = new PriorityQueue<>(priorityTasks);
        int count = 1;
        while (!copy.isEmpty()) {
            System.out.println(count++ + ". " + copy.poll());
        }
    }
}