import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static java.lang.System.exit;

public class EmployeeSystem {

    private final Scanner scanner = new Scanner(System.in);
    private int nextId = 1;
    private String name;
    private String address;

    // Array List
    public ArrayList<StaffMember> staffMembers = new ArrayList<>(
            List.of(
                    new Volunteer(nextId++, "John", "123 Main St.", 0.0),
                    new SalariesEmployee(nextId++, "Lisa", "456 Main St.", 0.0, 0.0),
                    new HourlySalaryEmployee(nextId++, "Tom", "789 Main St.", 0, 0.0),
                    new Volunteer(nextId++, "Jerry", "101 Main St.", 0.0),
                    new SalariesEmployee(nextId++, "Marry", "202 Main St.", 0.0, 0.0),
                    new HourlySalaryEmployee(nextId++, "Bob", "303 Main St.", 0, 0.0)
            )
    );

    // Insert Method
    public void insertEmployee() {

        Table table = new Table(4, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND_HEADER_AND_COLUMNS);

        table.setColumnWidth(0, 20, 30);
        table.setColumnWidth(1, 30, 50);
        table.setColumnWidth(2, 30, 50);
        table.setColumnWidth(3, 15, 25);

        System.out.println("\n==============* Insert Employee *==============");
        System.out.println("Choose Type: ");

        table.addCell("1. Volunteer", new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("2. Salaries Employee", new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("3. Hourly Salary Employee", new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("4. Back", new CellStyle(CellStyle.HorizontalAlign.center));

        System.out.println(table.render());

        int option;

        // Display the menu
        do {

            System.out.print("=> Enter Type Number: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    insertVolunteerEmployee();
                    break;
                case 2:
                    insertSalariesEmployee();
                    break;
                case 3:
                    insertHourlySalaryEmployee();
                    break;
                case 4:
                    displayInformation();
                    break;
            }
        } while (option != 4);

    }

    // Insert Volunteer Employee Method
    public void insertVolunteerEmployee() {
        Volunteer volunteer = new Volunteer();
        volunteer.pay();

        System.out.println("ID: " + nextId);
        System.out.print("=> Enter Name: ");
        scanner.nextLine();
        name = scanner.nextLine();
        System.out.print("=> Enter Address: ");
        address = scanner.nextLine();
        System.out.print("=> Enter Salary: ");
        double salary = scanner.nextDouble();

        volunteer.setId(nextId++);
        volunteer.setName(name);
        volunteer.setAddress(address);
        volunteer.setSalary(salary);

        if (staffMembers.add(volunteer)) {
            System.out.println("* You added " + name + " of type Volunteer successfully! *\n");
        } else {
            System.out.println("* You failed to added a type of Volunteer! *");
        }
    }

    // Insert Salaries Employee Method
    public void insertSalariesEmployee() {
        SalariesEmployee salariesEmployee = new SalariesEmployee();
        salariesEmployee.pay();

        System.out.println("ID: " + nextId);
        System.out.print("=> Enter Name: ");
        scanner.nextLine();
        name = scanner.nextLine();
        System.out.print("=> Enter Address: ");
        address = scanner.nextLine();
        System.out.print("=> Enter Salary: ");
        double salary = scanner.nextDouble();
        System.out.print("=> Enter Bonus: ");
        double bonus = scanner.nextDouble();

        salariesEmployee.setId(nextId++);
        salariesEmployee.setName(name);
        salariesEmployee.setAddress(address);
        salariesEmployee.setSalary(salary);
        salariesEmployee.setBonus(bonus);

        if (staffMembers.add(salariesEmployee)) {
            System.out.println("* You added " + name + " of type Salaries Employee successfully! *\n");
        } else {
            System.out.println("* You failed to added a type of Salaries Employee! *\n");
        }
    }

    // Insert Hourly Salary Employee Method
    public void insertHourlySalaryEmployee() {
        HourlySalaryEmployee hourlySalaryEmployee = new HourlySalaryEmployee();
        hourlySalaryEmployee.pay();

        System.out.println("ID: " + nextId);
        System.out.print("=> Enter Name: ");
        scanner.nextLine();
        name = scanner.nextLine();
        System.out.print("=> Enter Address: ");
        address = scanner.nextLine();
        System.out.print("=> Enter Hours: ");
        int timeWork = scanner.nextInt();
        System.out.print("=> Enter Rate: ");
        double timeRate = scanner.nextDouble();

        hourlySalaryEmployee.setId(nextId++);
        hourlySalaryEmployee.setName(name);
        hourlySalaryEmployee.setAddress(address);
        hourlySalaryEmployee.setHoursWorked(timeWork);
        hourlySalaryEmployee.setHourlyRate(timeRate);

        if (staffMembers.add(hourlySalaryEmployee)) {
            System.out.println("* You added " + name + " of type Hourly Salary Employee successfully! *\n");
        } else {
            System.out.println("* You failed to added a type of Hourly Salary Employee! *");
        }
    }

    // Update Method
    public void updateEmployee() {
        System.out.println("\n==============* Update Employee *==============");
        System.out.print("=> Enter or Search ID to Update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (StaffMember staffMember : staffMembers) {
            if (staffMember.getId() == id) {
                if (staffMember instanceof Volunteer) {
                    updateVolunteer(staffMember);
                } else if (staffMember instanceof SalariesEmployee) {
                    updateSalariesEmployee(staffMember);
                } else if (staffMember instanceof HourlySalaryEmployee) {
                    updateHourlySalaryEmployee(staffMember);
                }
            }
        }
    }

    // Update Volunteer Employee Method
    private void updateHourlySalaryEmployee(StaffMember staffMember) {
        displayHourlySalaryUpdateTable(staffMember);

        System.out.println("=> Choose one column to update: ");
        System.out.println("1. Name \t 2. Address \t 3. Hours Worked \t 4. Hourly Rate \t 0. Cancel");

        System.out.print("=> Select Column Number: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                System.out.print("=> Enter New Name: ");
                name = scanner.nextLine();
                staffMember.setName(name);
                System.out.println("* Name updated successfully! *\n");
                updateHourlySalaryEmployee(staffMember);
                break;
            case 2:
                System.out.print("=> Enter New Address: ");
                address = scanner.nextLine();
                staffMember.setAddress(address);
                System.out.println("* Address updated successfully! *\n");
                updateHourlySalaryEmployee(staffMember);
                break;
            case 3:
                System.out.print("=> Enter Hours Worked: ");
                int hoursWorked = scanner.nextInt();
                ((HourlySalaryEmployee) staffMember).setHoursWorked(hoursWorked);
                System.out.println("* Hours Worked updated successfully! *\n");
                updateHourlySalaryEmployee(staffMember);
                break;
            case 4:
                System.out.print("=> Enter New Hourly Rate: ");
                double hourlyRate = Double.parseDouble(scanner.nextLine());
                ((HourlySalaryEmployee) staffMember).setHourlyRate(hourlyRate);
                System.out.println("* Hourly Rate updated successfully! *\n");
                updateHourlySalaryEmployee(staffMember);
                break;
            case 0:
                displayInformation();
                break;
        }
    }

    // Update Salaries Employee Method
    private void updateSalariesEmployee(StaffMember staffMember) {
        displaySalariesUpdateTable(staffMember);

        System.out.println("=> Choose one column to update: ");
        System.out.println("1. Name \t 2. Address \t 3. Salary \t 4. Bonus \t 0. Cancel");

        System.out.print("=> Select Column Number: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                System.out.print("=> Enter New Name: ");
                name = scanner.nextLine();
                staffMember.setName(name);
                System.out.println("* Name updated successfully! *");
                updateSalariesEmployee(staffMember);
                break;
            case 2:
                System.out.print("=> Enter New Address: ");
                address = scanner.nextLine();
                staffMember.setAddress(address);
                System.out.println("* Address updated successfully! *");
                updateSalariesEmployee(staffMember);
                break;
            case 3:
                System.out.print("=> Enter New Salary: ");
                double salary = Double.parseDouble(scanner.nextLine());
                ((SalariesEmployee) staffMember).setSalary(salary);
                System.out.println("* Salary updated successfully! *");
                updateSalariesEmployee(staffMember);
                break;
            case 4:
                System.out.print("=> Enter New Bonus: ");
                double bonus = Double.parseDouble(scanner.nextLine());
                ((SalariesEmployee) staffMember).setBonus(bonus);
                System.out.println("* Bonus updated successfully! *");
                updateSalariesEmployee(staffMember);
                break;
            case 0:
                displayInformation();
                break;
        }
    }

    // Update Hourly Salary Employee Table Method
    private void displayHourlySalaryUpdateTable(StaffMember staffMember) {
        Table table = new Table(7, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        table.setColumnWidth(0, 30, 50);
        table.setColumnWidth(1, 15, 25);
        table.setColumnWidth(2, 30, 50);
        table.setColumnWidth(3, 20, 40);
        table.setColumnWidth(4, 20, 30);
        table.setColumnWidth(5, 20, 30);
        table.setColumnWidth(6, 20, 30);

        table.addCell("Type", new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("ID", new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("Name", new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("Address", new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("Hours Worked", new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("Hourly Rate", new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("Payment", new CellStyle(CellStyle.HorizontalAlign.center));

        table.addCell(staffMember.getClass().getSimpleName(), new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell(String.valueOf(staffMember.getId()), new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell(staffMember.getName(), new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell(staffMember.getAddress(), new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell(String.valueOf(((HourlySalaryEmployee) staffMember).getHoursWorked()), new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("$" + String.valueOf(((HourlySalaryEmployee) staffMember).getHourlyRate()), new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("$" + String.valueOf(staffMember.pay()), new CellStyle(CellStyle.HorizontalAlign.center));

        System.out.println(table.render());
    }

    // Update Salaries Employee Table Method
    private void displaySalariesUpdateTable(StaffMember staffMember) {
        Table table = new Table(7, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        table.setColumnWidth(0, 30, 50);
        table.setColumnWidth(1, 15, 25);
        table.setColumnWidth(2, 30, 50);
        table.setColumnWidth(3, 20, 40);
        table.setColumnWidth(4, 20, 30);
        table.setColumnWidth(5, 20, 30);
        table.setColumnWidth(6, 20, 30);

        table.addCell("Type", new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("ID", new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("Name", new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("Address", new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("Salary", new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("Bonus", new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("Payment", new CellStyle(CellStyle.HorizontalAlign.center));

        table.addCell(staffMember.getClass().getSimpleName(), new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell(String.valueOf(staffMember.getId()), new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell(staffMember.getName(), new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell(staffMember.getAddress(), new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("$" + String.valueOf(((SalariesEmployee) staffMember).getSalary()), new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("$" + String.valueOf(((SalariesEmployee) staffMember).getBonus()), new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("$" + String.valueOf(staffMember.pay()), new CellStyle(CellStyle.HorizontalAlign.center));

        System.out.println(table.render());
    }

    // Update Volunteer Employee Method
    private void updateVolunteer(StaffMember staffMember) {

        displayVolunteerUpdateTable(staffMember);

        System.out.println("=> Choose one column to update: ");
        System.out.println("1. Name \t 2. Address \t 3. Salary \t 0. Cancel");

        System.out.print("=> Select Column Number: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                System.out.print("=> Enter New Name: ");
                name = scanner.nextLine();
                staffMember.setName(name);
                System.out.println("* Name updated successfully! *");
                updateVolunteer(staffMember);
                break;
            case 2:
                System.out.print("=> Enter New Address: ");
                address = scanner.nextLine();
                staffMember.setAddress(address);
                System.out.println("* Address updated successfully! *");
                updateVolunteer(staffMember);
                break;
            case 3:
                System.out.print("=> Enter New Salary: ");
                double salary = Double.parseDouble(scanner.nextLine());
                ((Volunteer) staffMember).setSalary(salary);
                System.out.println("* Salary updated successfully! *");
                updateVolunteer(staffMember);
                break;
            case 0:
                displayInformation();
                break;
        }
    }

    // Update Volunteer Employee Table Method
    private static void displayVolunteerUpdateTable(StaffMember staffMember) {
        Table table = new Table(6, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND_HEADER_AND_COLUMNS);

        table.setColumnWidth(0, 30, 50);
        table.setColumnWidth(1, 15, 25);
        table.setColumnWidth(2, 30, 50);
        table.setColumnWidth(3, 20, 40);
        table.setColumnWidth(4, 20, 30);
        table.setColumnWidth(5, 20, 30);

        table.addCell("Type", new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("ID", new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("Name", new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("Address", new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("Salary", new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("Payment", new CellStyle(CellStyle.HorizontalAlign.center));

        table.addCell(staffMember.getClass().getSimpleName(), new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell(String.valueOf(staffMember.getId()), new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell(staffMember.getName(), new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell(staffMember.getAddress(), new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("$" + String.valueOf(((Volunteer) staffMember).getSalary()), new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("$" + String.valueOf(staffMember.pay()), new CellStyle(CellStyle.HorizontalAlign.center));

        System.out.println(table.render());
    }

    // Display Method
    public void displayInformation() {

        int option;

        // Display the menu of the system
        do {

            Table table = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
            table.setColumnWidth(0, 40, 50);

            System.out.println("\n");
            System.out.println("==============* Staff Management System *==============");

            table.addCell("Staff Management System", new CellStyle(CellStyle.HorizontalAlign.center));
            table.addCell(" ".repeat(6) + "1. Insert Employee", new CellStyle(CellStyle.HorizontalAlign.left));
            table.addCell(" ".repeat(6) + "2. Update Employee", new CellStyle(CellStyle.HorizontalAlign.left));
            table.addCell(" ".repeat(6) + "3. Display Employee", new CellStyle(CellStyle.HorizontalAlign.left));
            table.addCell(" ".repeat(6) + "4. Remove Employee", new CellStyle(CellStyle.HorizontalAlign.left));
            table.addCell(" ".repeat(6) + "5. Exit", new CellStyle(CellStyle.HorizontalAlign.left));

            System.out.println(table.render());

            System.out.println("---------------------------------------------------");
            System.out.print("-> Choose an option(): ");
            option = scanner.nextInt();

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
                case 5: {
                    System.out.println("\n(^-^) Good bye...! (^-^)");
                    exit(0);
                }
                default:
                    System.out.println("Invalid option! Please try again...!");
            }
        } while (option != 5);
    }

    // Display Method
    public void displayEmployee() {

        Table table = new Table(9, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        CellStyle numberCellStyle = new CellStyle(CellStyle.HorizontalAlign.center);

        table.addCell("Type", numberCellStyle);
        table.addCell("ID", numberCellStyle);
        table.addCell("Name", numberCellStyle);
        table.addCell("Address", numberCellStyle);
        table.addCell("Bonus", numberCellStyle);
        table.addCell("Hour", numberCellStyle);
        table.addCell("Rate", numberCellStyle);
        table.addCell("Salary", numberCellStyle);
        table.addCell("Payment", numberCellStyle);

        table.setColumnWidth(0, 30, 50);
        table.setColumnWidth(1, 15, 25);
        table.setColumnWidth(2, 30, 50);
        table.setColumnWidth(3, 20, 40);
        table.setColumnWidth(4, 20, 30);
        table.setColumnWidth(5, 20, 30);
        table.setColumnWidth(6, 20, 30);
        table.setColumnWidth(7, 20, 30);
        table.setColumnWidth(8, 20, 30);

        System.out.println("\n==============* Display Employee *==============");

        if (staffMembers.isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }

        for (StaffMember staffMember : staffMembers) {
            if (staffMember instanceof Volunteer) {
                Volunteer volunteer = (Volunteer) staffMember;

                table.addCell("Volunteer", numberCellStyle);
                table.addCell(String.valueOf(staffMember.getId()), numberCellStyle);
                table.addCell(staffMember.getName(), numberCellStyle);
                table.addCell(staffMember.getAddress(), numberCellStyle);
                table.addCell("$" + String.valueOf(volunteer.getSalary()), numberCellStyle);
                table.addCell("---", numberCellStyle);
                table.addCell("---", numberCellStyle);
                table.addCell("---", numberCellStyle);
                table.addCell("$" + String.valueOf(staffMember.pay()), numberCellStyle);

            } else if (staffMember instanceof SalariesEmployee) {
                SalariesEmployee salariesEmployee = (SalariesEmployee) staffMember;

                table.addCell("Salaries Employee", numberCellStyle);
                table.addCell(String.valueOf(staffMember.getId()), numberCellStyle);
                table.addCell(staffMember.getName(), numberCellStyle);
                table.addCell(staffMember.getAddress(), numberCellStyle);
                table.addCell("$" + String.valueOf(salariesEmployee.getSalary()), numberCellStyle);
                table.addCell("$" + String.valueOf(salariesEmployee.getBonus()), numberCellStyle);
                table.addCell("---", numberCellStyle);
                table.addCell("---", numberCellStyle);
                table.addCell("$" + String.valueOf(staffMember.pay()), numberCellStyle);

            } else if (staffMember instanceof HourlySalaryEmployee) {
                HourlySalaryEmployee hourlySalaryEmployee = (HourlySalaryEmployee) staffMember;

                table.addCell("Hourly Salary Employee", numberCellStyle);
                table.addCell(String.valueOf(staffMember.getId()), numberCellStyle);
                table.addCell(staffMember.getName(), numberCellStyle);
                table.addCell(staffMember.getAddress(), numberCellStyle);
                table.addCell("---", numberCellStyle);
                table.addCell("---", numberCellStyle);
                table.addCell("$" + String.valueOf(hourlySalaryEmployee.getHoursWorked()), numberCellStyle);
                table.addCell("$" + String.valueOf(hourlySalaryEmployee.getHourlyRate()), numberCellStyle);
                table.addCell("$" + String.valueOf(staffMember.pay()), numberCellStyle);
            }
        }
        System.out.println(table.render());
    }

    // Remove Method
    private void removeEmployee() {
        System.out.println("\n==============* Remove Employee *==============");
        System.out.print("=> Enter ID to Remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Optional<StaffMember> staffMember = staffMembers.stream().filter(s -> s.getId() == id).findFirst();

        if (staffMember.isPresent()) {
            staffMembers.remove(staffMember.get());
            System.out.println("* Employee removed successfully! *\n");
        } else {
            System.out.println("* Employee not found! *");
        }
    }
}




