# Sistema de Gestión de Tareas - Starbucks

## Descripción
Sistema de gestión de tareas para Starbucks que utiliza diferentes estructuras de datos para organizar tareas según su tipo y prioridad. El sistema permite agregar, visualizar y completar tareas de manera eficiente.

## Estructuras de Datos Implementadas

### 1. StackManager - Tareas Urgentes
- **Estructura**: Pila (Stack)
- **Funcionalidades**: 
  - `push()`: Agregar tarea urgente
  - `pop()`: Completar última tarea urgente
  - `peek()`: Ver próxima tarea urgente
  - `display()`: Mostrar todas las tareas urgentes

### 2. QueueManager - Tareas Programadas
- **Estructura**: Cola (Queue)
- **Funcionalidades**:
  - `enqueue()`: Agregar tarea programada
  - `dequeue()`: Completar primera tarea programada
  - `front()`: Ver próxima tarea programada
  - `display()`: Mostrar tareas en orden de ejecución

### 3. ListManager - Tareas Departamentales
- **Estructura**: Lista (ArrayList)
- **Funcionalidades**:
  - `insert()`: Agregar tarea departamental
  - `delete()`: Eliminar tarea por descripción
  - `find()`: Buscar tarea específica
  - `findByDepartment()`: Filtrar tareas por departamento
  - `display()`: Mostrar todas las tareas departamentales

### 4. PriorityQueueManager - Tareas Prioritarias
- **Estructura**: Cola de Prioridad (PriorityQueue)
- **Funcionalidades**:
  - `add()`: Agregar tarea prioritaria
  - `remove()`: Completar tarea de mayor prioridad
  - `peek()`: Ver tarea más prioritaria
  - `display()`: Mostrar tareas ordenadas por prioridad

## Clases del Sistema

### Task.java
Clase que representa una tarea con los siguientes atributos:
- `description`: Descripción de la tarea
- `department`: Departamento asignado (Baristas, Cocina, Limpieza, Administración)
- `priority`: Nivel de prioridad (1-5)
- `type`: Tipo de tarea (Urgente, Programada, Departamental, Prioritaria)

### StarbucksTaskManager.java
Clase principal que coordina todas las estructuras y proporciona la interfaz de usuario con las siguientes funcionalidades:

#### Menú Principal
1. **Agregar tarea**: Permite crear tareas de diferentes tipos
2. **Ver tareas**: Visualiza tareas por tipo o departamento
3. **Completar tarea**: Marca tareas como completadas
4. **Ver todas las tareas**: Muestra un resumen completo
5. **Salir**: Finaliza la aplicación

#### Departamentos Soportados
- Baristas
- Cocina  
- Limpieza
- Administración

## Características del Sistema

- **Validación de entrada**: Control de errores en entradas del usuario
- **Búsqueda por departamento**: Filtrado cruzado entre todas las estructuras
- **Interfaz intuitiva**: Menús claros y opciones numeradas
- **Mensajes informativos**: Feedback claro para el usuario
- **Organización eficiente**: Cada tipo de tarea en su estructura óptima

## Uso del Sistema

1. Ejecutar `StarbucksTaskManager.main()`
2. Seguir las instrucciones del menú interactivo
3. Las tareas se organizan automáticamente según su tipo
4. Las tareas prioritarias se ordenan por nivel de prioridad (1-5)
5. Las tareas urgentes siguen el principio LIFO (Last-In-First-Out)
6. Las tareas programadas siguen el principio FIFO (First-In-First-Out)

## Ventajas del Diseño

- **Separación de responsabilidades**: Cada manager maneja su propia estructura
- **Escalabilidad**: Fácil agregar nuevos tipos de tareas o departamentos
- **Eficiencia**: Cada operación utiliza la estructura de datos óptima
- **Mantenibilidad**: Código modular y bien organizado

Este sistema proporciona una solución robusta y eficiente para la gestión de tareas en un entorno Starbucks, optimizando el flujo de trabajo según la urgencia y prioridad de cada actividad.


## Instrucciones de Ejecución

### 1. Preparar los archivos
Guarda todos los archivos `.java` en la misma carpeta:
- `Task.java`
- `StackManager.java`
- `QueueManager.java`
- `ListManager.java`
- `PriorityQueueManager.java`
- `StarbucksTaskManager.java`

### 2. Compilar el programa
Abre una terminal/consola y navega hasta la carpeta donde guardaste los archivos.

Ejecuta el siguiente comando para compilar todos los archivos:
```bash
javac * StarbucksTaskManager.java
