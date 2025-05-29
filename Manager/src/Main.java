public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();

        manager.addEmployee(new Employee("Alice Johnson", "Engineering", 75000));
        manager.addEmployee(new Employee("Bob Smith", "Marketing", 62000));

        System.out.println("All employees:");
        manager.printAllEmployees();

        System.out.println("\nSearching for Bob Smith:");

        Employee found = manager.findByName("Bob Smith");
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Employee not found.");
        }
    }
}