Starbucks Task Manager
Un sistema de gestion de tareas completo desarrollado en Java para administrar diferentes tipos de tareas en un entorno Starbucks utilizando diversas estructuras de datos.

Características
Cuatro tipos de tareas con diferentes estructuras de datos: Tareas Urgentes gestionadas con una pila (LIFO), Tareas Programadas gestionadas con una cola (FIFO), Tareas Departamentales gestionadas con una lista, y Tareas Prioritarias gestionadas con una cola de prioridad.

Interfaz de consola intuitiva con validación de entrada, gestion por departamentos (Baristas, Cocina, Limpieza, Administracion), sistema de prioridades (1-5) para tareas prioritarias, y visualizacion organizada de todas las tareas.

Estructura del Proyecto
StarbucksTaskManager/

StarbucksTaskManager.java: Clase principal con menu e interfaz

Task.java: Modelo de datos para las tareas

StackManager.java: Gestor de tareas urgentes (Pila)

QueueManager.java: Gestor de tareas programadas (Cola)

ListManager.java: Gestor de tareas departamentales (Lista)

PriorityQueueManager.java: Gestor de tareas prioritarias (Cola de prioridad)

Funcionalidades
Agregar Tareas: Seleccion del tipo de tarea (urgente, programada, departamental, prioritaria), descripcion personalizada, asignacion a departamentos especificos, y definicion de prioridad para tareas prioritarias.

Ver Tareas: Visualizacion por tipo especifico, filtrado por departamento, y vista consolidada de todas las tareas.

Completar/Eliminar Tareas: Completar tareas urgentes (desapilar), completar tareas programadas (desencolar), eliminar tareas departamentales por descripcion, y completar tareas prioritarias (mayor prioridad primero).
