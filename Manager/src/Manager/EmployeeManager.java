import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Optional;

public class EmployeeManager {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void printAllEmployees() {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    public Employee findByName(String name) {
        for (Employee e : employees) {
            if (e.getName().equalsIgnoreCase(name)) {
                return e;
            }
        }
        return null;
    }

    public boolean eliminarPorNombre(String nombre) {
        Optional<Employee> emp = employees.stream().filter(e -> e.getName().equalsIgnoreCase(nombre)).findFirst();
        if (emp.isPresent()) {
            employees.remove(emp.get());
            return true;
        }
        return false;
    }

    public void mostrarEstadisticas() {
        if (employees.isEmpty()) {
            System.out.println("No hay empleados para mostrar estadísticas.");
            return;
        }
        double suma = 0, max = Double.MIN_VALUE, min = Double.MAX_VALUE;
        for (Employee e : employees) {
            double s = e.getSalary();
            suma += s;
            if (s > max) max = s;
            if (s < min) min = s;
        }
        System.out.println("Salario promedio: " + (suma / employees.size()));
        System.out.println("Salario máximo: " + max);
        System.out.println("Salario mínimo: " + min);
    }

    public void guardarEnArchivo(String archivo) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Employee e : employees) {
                bw.write(e.getName() + "," + e.getDepartment() + "," + e.getSalary());
                bw.newLine();
            }
        }
    }

    public void cargarDesdeArchivo(String archivo) throws IOException {
        employees.clear();
        File f = new File(archivo);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    String nombre = partes[0];
                    String depto = partes[1];
                    double salario = Double.parseDouble(partes[2]);
                    employees.add(new Employee(nombre, depto, salario));
                }
            }
        }
    }
}
