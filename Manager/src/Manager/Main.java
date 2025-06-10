import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);
        String archivo = "empleados.txt";
        try {
            manager.cargarDesdeArchivo(archivo);
        } catch (IOException e) {
            System.out.println("No se pudo cargar el archivo de empleados. Se iniciará vacío.");
        }
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Menú de Gestión de Empleados ---");
            System.out.println("1. Listar empleados");
            System.out.println("2. Agregar empleado");
            System.out.println("3. Buscar empleado por nombre");
            System.out.println("4. Eliminar empleado por nombre");
            System.out.println("5. Actualizar salario de empleado");
            System.out.println("6. Estadísticas de salarios");
            System.out.println("7. Guardar y salir");
            System.out.print("Seleccione una opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1:
                    manager.printAllEmployees();
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Departamento: ");
                    String depto = scanner.nextLine();
                    System.out.print("Salario: ");
                    double salario = Double.parseDouble(scanner.nextLine());
                    manager.addEmployee(new Employee(nombre, depto, salario));
                    System.out.println("Empleado agregado.");
                    break;
                case 3:
                    System.out.print("Nombre a buscar: ");
                    String buscar = scanner.nextLine();
                    Employee encontrado = manager.findByName(buscar);
                    if (encontrado != null) {
                        System.out.println("Encontrado: " + encontrado);
                    } else {
                        System.out.println("Empleado no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Nombre a eliminar: ");
                    String eliminar = scanner.nextLine();
                    if (manager.eliminarPorNombre(eliminar)) {
                        System.out.println("Empleado eliminado.");
                    } else {
                        System.out.println("Empleado no encontrado.");
                    }
                    break;
                case 5:
                    System.out.print("Nombre del empleado: ");
                    String nomAct = scanner.nextLine();
                    Employee empAct = manager.findByName(nomAct);
                    if (empAct != null) {
                        System.out.print("Nuevo salario: ");
                        double nuevoSal = Double.parseDouble(scanner.nextLine());
                        empAct.setSalary(nuevoSal);
                        System.out.println("Salario actualizado.");
                    } else {
                        System.out.println("Empleado no encontrado.");
                    }
                    break;
                case 6:
                    manager.mostrarEstadisticas();
                    break;
                case 7:
                    try {
                        manager.guardarEnArchivo(archivo);
                        System.out.println("Empleados guardados. ¡Hasta luego!");
                    } catch (IOException e) {
                        System.out.println("Error al guardar empleados.");
                    }
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }
}