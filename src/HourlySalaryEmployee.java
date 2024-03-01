import java.util.Scanner;

public class HourlySalaryEmployee extends StaffMember {

    private int hoursWorked;
    private double hourlyRate;

    public HourlySalaryEmployee(int id, String name, String address, int hoursWorked, double hourlyRate) {
        super(id, name, address);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public HourlySalaryEmployee() {

    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return "HourlySalaryEmployee{" +
                "hoursWorked=" + hoursWorked +
                ", hourlyRate=" + hourlyRate +
                '}';
    }

    @Override
    double pay() {

        return hoursWorked + hourlyRate;
    }

}

