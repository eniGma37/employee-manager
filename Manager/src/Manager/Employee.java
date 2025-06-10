public class Employee {

    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }aaaaaaaaaaaaaa

    // Getters
    public String getName() {
        return name;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    // Getters
    public String getDepartment() {
        return department;
    }

    // Setters
    public void setDepartment(String department) {
        this.department = department;
    }

    // Getters
    public double getSalary() {
        return salary;
    }

    // Setters
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // toString method
    @Override
    public String toString() {
        return name + " (" + department + ") - $" + salary;
    }
}

