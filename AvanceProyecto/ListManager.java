import java.util.ArrayList;
import java.util.List;

public class ListManager {
    private List<Task> departmentTasks;

    public ListManager() {
        departmentTasks = new ArrayList<>();
    }

    public void insert(Task task) {
        departmentTasks.add(task);
        System.out.println("Tarea departamental agregada: " + task.getDescription());
    }

    public boolean delete(String description) {
        for (int i = 0; i < departmentTasks.size(); i++) {
            if (departmentTasks.get(i).getDescription().equalsIgnoreCase(description)) {
                Task removed = departmentTasks.remove(i);
                System.out.println("Tarea departamental eliminada: " + removed.getDescription());
                return true;
            }
        }
        System.out.println("Tarea no encontrada: " + description);
        return false;
    }

    public Task find(String description) {
        for (Task task : departmentTasks) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                return task;
            }
        }
        return null;
    }

    public List<Task> findByDepartment(String department) {
        List<Task> result = new ArrayList<>();
        for (Task task : departmentTasks) {
            if (task.getDepartment().equalsIgnoreCase(department)) {
                result.add(task);
            }
        }
        return result;
    }

    public void display() {
        if (departmentTasks.isEmpty()) {
            System.out.println("No hay tareas departamentales pendientes");
            return;
        }
        System.out.println("\n=== TAREAS DEPARTAMENTALES (LISTA) ===");
        for (int i = 0; i < departmentTasks.size(); i++) {
            System.out.println((i + 1) + ". " + departmentTasks.get(i));
        }
    }

    public void displayByDepartment(String department) {
        List<Task> deptTasks = findByDepartment(department);
        if (deptTasks.isEmpty()) {
            System.out.println("No hay tareas para el departamento: " + department);
            return;
        }
        System.out.println("\n=== TAREAS DEL DEPARTAMENTO " + department.toUpperCase() + " ===");
        for (int i = 0; i < deptTasks.size(); i++) {
            System.out.println((i + 1) + ". " + deptTasks.get(i));
        }
    }
}