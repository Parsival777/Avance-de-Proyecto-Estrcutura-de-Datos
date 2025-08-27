import java.util.Stack;

public class StackManager {
    private Stack<Task> urgentTasks;

    public StackManager() {
        urgentTasks = new Stack<>();
    }

    public void push(Task task) {
        urgentTasks.push(task);
        System.out.println("Tarea urgente agregada: " + task.getDescription());
    }

    public Task pop() {
        if (urgentTasks.isEmpty()) {
            System.out.println("No hay tareas urgentes pendientes");
            return null;
        }
        Task task = urgentTasks.pop();
        System.out.println("Tarea urgente completada: " + task.getDescription());
        return task;
    }

    public Task peek() {
        if (urgentTasks.isEmpty()) {
            System.out.println("No hay tareas urgentes pendientes");
            return null;
        }
        return urgentTasks.peek();
    }

    public boolean isEmpty() {
        return urgentTasks.isEmpty();
    }

    public void display() {
        if (urgentTasks.isEmpty()) {
            System.out.println("No hay tareas urgentes pendientes");
            return;
        }
        System.out.println("\n=== TAREAS URGENTES (PILA) ===");
        for (int i = urgentTasks.size() - 1; i >= 0; i--) {
            System.out.println((urgentTasks.size() - i) + ". " + urgentTasks.get(i));
        }
    }
}