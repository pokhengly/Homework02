import java.util.Scanner;

public class Volunteer extends StaffMember {

    private double salary;

    public Volunteer(int id, String name, String address, double salary) {
        super(id, name, address);
        this.salary = salary;
    }

    public Volunteer() {

    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    double pay() {

        return salary;

    }

}
