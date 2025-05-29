import java.util.ArrayList;
import java.util.List;

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
}
