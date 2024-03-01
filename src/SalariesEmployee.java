import java.util.Scanner;

public class SalariesEmployee extends StaffMember {

    private double salary;
    private double bonus;

    public SalariesEmployee(int id, String name, String address, double salary, double bonus) {
        super(id, name, address);
        this.salary = salary;
        this.bonus = bonus;
    }

    public SalariesEmployee() {

    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "SalariesEmployee{" +
                "salary=" + salary +
                ", bonus=" + bonus +
                '}';
    }

    @Override
    double pay() {

        return salary + bonus;
    }

}
