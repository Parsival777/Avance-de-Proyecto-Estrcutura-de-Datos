import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.List;

public class StarbucksTaskManager {
    private StackManager urgentStack;
    private QueueManager scheduledQueue;
    private ListManager departmentList;
    private PriorityQueueManager priorityQueue;
    private Scanner scanner;

    public StarbucksTaskManager() {
        urgentStack = new StackManager();
        scheduledQueue = new QueueManager();
        departmentList = new ListManager();
        priorityQueue = new PriorityQueueManager();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("====================================");
        System.out.println("   SISTEMA DE GESTION DE TAREAS");
        System.out.println("            STARBUCKS");
        System.out.println("====================================");

        while (true) {
            displayMainMenu();
            int choice = getValidatedIntInput("Opcion: ", 1, 5);

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> completeTask();
                case 4 -> viewAllTasks();
                case 5 -> {
                    System.out.println("Saliendo del sistema... ¡Hasta pronto!");
                    return;
                }
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1. Agregar tarea");
        System.out.println("2. Ver tareas");
        System.out.println("3. Completar tarea");
        System.out.println("4. Ver todas las tareas");
        System.out.println("5. Salir");
        System.out.println("----------------------");
    }

    private void addTask() {
        System.out.println("\n--- AGREGAR TAREA ---");
        System.out.println("1. Urgente");
        System.out.println("2. Programada");
        System.out.println("3. Departamental");
        System.out.println("4. Prioritaria");
        System.out.println("----------------------");

        int typeChoice = getValidatedIntInput("Tipo de tarea: ", 1, 4);

        System.out.print("Descripcion: ");
        String description = scanner.nextLine();

        String department = getValidatedDepartmentInput();

        int priority = 1;
        if (typeChoice == 4) {
            priority = getValidatedIntInput("Prioridad (1-5): ", 1, 5);
        }

        Task task = new Task(description, department, priority, getTypeName(typeChoice));

        switch (typeChoice) {
            case 1 -> urgentStack.push(task);
            case 2 -> scheduledQueue.enqueue(task);
            case 3 -> departmentList.insert(task);
            case 4 -> priorityQueue.add(task);
        }

        System.out.println("Tarea agregada correctamente");
    }

    private String getTypeName(int type) {
        return switch (type) {
            case 1 -> "URGENTE";
            case 2 -> "PROGRAMADA";
            case 3 -> "DEPARTAMENTAL";
            case 4 -> "PRIORITARIA";
            default -> "GENERAL";
        };
    }

    private void viewTasks() {
        System.out.println("\n--- VER TAREAS ---");
        System.out.println("1. Tareas urgentes");
        System.out.println("2. Tareas programadas");
        System.out.println("3. Tareas departamentales");
        System.out.println("4. Tareas prioritarias");
        System.out.println("5. Por departamento");
        System.out.println("-------------------");

        int choice = getValidatedIntInput("Opcion: ", 1, 5);

        switch (choice) {
            case 1 -> urgentStack.display();
            case 2 -> scheduledQueue.display();
            case 3 -> departmentList.display();
            case 4 -> priorityQueue.display();
            case 5 -> {
                String dept = getValidatedDepartmentInput();
                displayTasksByDepartment(dept);
            }
        }
    }

    private void displayTasksByDepartment(String department) {
        System.out.println("\n=== TAREAS DEL DEPARTAMENTO " + department.toUpperCase() + " ===");
        
        boolean found = false;
        
        // Buscar en tareas urgentes
        if (!urgentStack.isEmpty()) {
            for (int i = 0; i < urgentStack.getSize(); i++) {
                Task task = urgentStack.getTaskAt(i);
                if (task.getDepartment().equalsIgnoreCase(department)) {
                    System.out.println("[URGENTE] " + task);
                    found = true;
                }
            }
        }
        
        // Buscar en tareas programadas
        if (!scheduledQueue.isEmpty()) {
            for (Task task : scheduledQueue.getAllTasks()) {
                if (task.getDepartment().equalsIgnoreCase(department)) {
                    System.out.println("[PROGRAMADA] " + task);
                    found = true;
                }
            }
        }
        
        // Buscar en tareas departamentales
        List<Task> deptTasks = departmentList.findByDepartment(department);
        for (Task task : deptTasks) {
            System.out.println("[DEPARTAMENTAL] " + task);
            found = true;
        }
        
        // Buscar en tareas prioritarias
        if (!priorityQueue.isEmpty()) {
            PriorityQueue<Task> copy = new PriorityQueue<>(priorityQueue.getQueue());
            while (!copy.isEmpty()) {
                Task task = copy.poll();
                if (task.getDepartment().equalsIgnoreCase(department)) {
                    System.out.println("[PRIORITARIA] " + task);
                    found = true;
                }
            }
        }
        
        if (!found) {
            System.out.println("No hay tareas para el departamento: " + department);
        }
    }

    private void completeTask() {
        System.out.println("\n--- COMPLETAR TAREA ---");
        System.out.println("1. Tarea urgente");
        System.out.println("2. Tarea programada");
        System.out.println("3. Eliminar departamental");
        System.out.println("4. Tarea prioritaria");
        System.out.println("-----------------------");

        int choice = getValidatedIntInput("Opcion: ", 1, 4);

        switch (choice) {
            case 1 -> urgentStack.pop();
            case 2 -> scheduledQueue.dequeue();
            case 3 -> {
                System.out.print("Descripcion a eliminar: ");
                String desc = scanner.nextLine();
                departmentList.delete(desc);
            }
            case 4 -> priorityQueue.remove();
        }
    }

    private void viewAllTasks() {
        System.out.println("\n--- TODAS LAS TAREAS ---");

        System.out.println("\nTAREAS PRIORITARIAS:");
        priorityQueue.display();

        System.out.println("\nTAREAS URGENTES:");
        urgentStack.display();

        System.out.println("\nTAREAS PROGRAMADAS:");
        scheduledQueue.display();

        System.out.println("\nTAREAS DEPARTAMENTALES:");
        departmentList.display();
    }

    private int getValidatedIntInput(String message, int min, int max) {
        int value;
        while (true) {
            try {
                System.out.print(message);
                value = Integer.parseInt(scanner.nextLine());

                if (value >= min && value <= max) {
                    break;
                } else {
                    System.out.printf("Ingrese un numero entre %d y %d\n", min, max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido");
            }
        }
        return value;
    }

    private String getValidatedDepartmentInput() {
        String[] validDepartments = { "Baristas", "Cocina", "Limpieza", "Administracion" };

        System.out.println("\n--- SELECCIONAR DEPARTAMENTO ---");
        for (int i = 0; i < validDepartments.length; i++) {
            System.out.println((i + 1) + ". " + validDepartments[i]);
        }
        System.out.println("-------------------------------");

        int choice = getValidatedIntInput("Seleccione departamento (1-4): ", 1, 4);
        return validDepartments[choice - 1];
    }

    public static void main(String[] args) {
        StarbucksTaskManager manager = new StarbucksTaskManager();
        manager.start();
    }
}
