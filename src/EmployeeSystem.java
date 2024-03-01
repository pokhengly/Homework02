import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeSystem {

    public Scanner scanner = new Scanner(System.in);
    public int id;
    public String name;
    public String address;


    // Array List
    public ArrayList<StaffMember> staffMembers = new ArrayList<>();


    // Display Method
    public void displayInformation() {

        Table table = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        table.setColumnWidth(0, 40, 50);

        table.addCell("Staff Management System", new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell(  " ".repeat(6) + "1. Insert Employee", new CellStyle(CellStyle.HorizontalAlign.left));
        table.addCell("2. Update Employee", new CellStyle(CellStyle.HorizontalAlign.left));
        table.addCell("3. Display Employee", new CellStyle(CellStyle.HorizontalAlign.left));
        table.addCell("4. Remove Employee", new CellStyle(CellStyle.HorizontalAlign.left));
        table.addCell("5. Exit", new CellStyle(CellStyle.HorizontalAlign.left));

        System.out.println(table.render());

        scanner = new Scanner(System.in);
        int option;

        // Display the menu
        do {

            System.out.println("==================== Staff Member System ====================");
            System.out.println("1. Insert Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Display Employee");
            System.out.println("4. Remove Employee");
            System.out.println("5. Exit");
            System.out.println("---------------------------------------------------");
            System.out.print("=> Choose option(1-5): ");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    insertEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    displayEmployee();
                    break;
                case 4:
                    removeEmployee();
                    break;
                case 5:
                    exit();
                    break;
            }
        } while (option != 6);
    }

    // Insert Method
    public void insertEmployee() {

        int option;

        // Display the menu
        do {

            System.out.println("1- Insert Volunteer Employee");
            System.out.println("2- Insert Hourly Salary Employee");
            System.out.println("3- Insert Salaries Employee");
            System.out.println("4- Exit");
            System.out.println("---------------------------------------------------");
            System.out.print("=> Choose option(1-4): ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    insertVolunteerEmployee();
                    break;
                case 2:
                    insertHourlySalaryEmployee();
                    break;
                case 3:
                    insertSalariesEmployee();
                    break;
                case 4:
                    exit();
                    break;
            }
        } while (option != 4);

    }

    // Insert Volunteer Employee Method
    public void insertVolunteerEmployee() {
        Volunteer volunteer = new Volunteer();
        volunteer.pay();

        System.out.println("===================== Insert Volunteer =====================");
        System.out.print("ID: ");
        id = scanner.nextInt();
        System.out.print("Name: ");
        scanner.nextLine();
        name = scanner.nextLine();
        System.out.print("Address: ");
        address = scanner.nextLine();
        System.out.print("Salary: ");
        double salary = scanner.nextDouble();

        volunteer.setId(id);
        volunteer.setName(name);
        volunteer.setAddress(address);
        volunteer.setSalary(salary);

        System.out.println("===================== VolunteerEmployee =====================");
        System.out.println("ID: " + volunteer.getId());
        System.out.println("Name: " + volunteer.getName());
        System.out.println("Address: " + volunteer.getAddress());
        System.out.println("Salary: " + volunteer.getSalary());
    }

    // Insert Hourly Salary Employee Method
    public void insertHourlySalaryEmployee() {
        HourlySalaryEmployee hourlySalaryEmployee = new HourlySalaryEmployee();
        hourlySalaryEmployee.pay();

        System.out.println("===================== Insert Hourly Salary =====================");
        System.out.print("ID: ");
        id = scanner.nextInt();
        System.out.print("Name: ");
        scanner.nextLine();
        name = scanner.nextLine();
        System.out.print("Address: ");
        address = scanner.nextLine();
        System.out.print("Hours Worked: ");
        int timeWork = scanner.nextInt();
        System.out.print("Hourly Rate: ");
        double timeRate = scanner.nextDouble();

        hourlySalaryEmployee.setId(id);
        hourlySalaryEmployee.setName(name);
        hourlySalaryEmployee.setAddress(address);
        hourlySalaryEmployee.setHoursWorked(timeWork);
        hourlySalaryEmployee.setHourlyRate(timeRate);

        System.out.println("===================== HourlyEmployee =====================");
        System.out.println("ID: " + hourlySalaryEmployee.getId());
        System.out.println("Name: " + hourlySalaryEmployee.getName());
        System.out.println("Address: " + hourlySalaryEmployee.getAddress());
        System.out.println("Hour Work: " + hourlySalaryEmployee.getHoursWorked());
        System.out.println("Rate: " + hourlySalaryEmployee.getHourlyRate());
        System.out.println("Payment: " + hourlySalaryEmployee.pay());

    }

    // Insert Salaries Employee Method
    public void insertSalariesEmployee() {
        SalariesEmployee salariesEmployee = new SalariesEmployee();
        salariesEmployee.pay();

        System.out.println("===================== Insert Salaries =====================");
        System.out.print("ID: ");
        id = scanner.nextInt();
        System.out.print("Name: ");
        scanner.nextLine();
        name = scanner.nextLine();
        System.out.print("Address: ");
        address = scanner.nextLine();
        System.out.print("Salary: ");
        double salary = scanner.nextDouble();
        System.out.print("Bonus: ");
        double bonus = scanner.nextDouble();

        salariesEmployee.setId(id);
        salariesEmployee.setName(name);
        salariesEmployee.setAddress(address);
        salariesEmployee.setSalary(salary);
        salariesEmployee.setBonus(bonus);

        System.out.println("===================== SalariesEmployee =====================");
        System.out.println("ID: " + salariesEmployee.getId());
        System.out.println("Name: " + salariesEmployee.getName());
        System.out.println("Address: " + salariesEmployee.getAddress());
        System.out.println("Salary: " + salariesEmployee.getSalary());
        System.out.println("Bonus: " + salariesEmployee.getBonus());
        System.out.println("Payment: " + salariesEmployee.pay());
    }

    // Update Method
    public void updateEmployee() {

        System.out.println("===================== Update Employee =====================");
        System.out.print("Enter or Search ID to Update: ");
        id = scanner.nextInt();


    }


    // Display Method
    public void displayEmployee() {

    }

    // Remove Method
    public void removeEmployee() {

    }

    // Exit Method
    public void exit() {

    }


}




