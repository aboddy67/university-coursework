/* 
Abdulrahman Thigah
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class MainSystem {
    // ---------------------------- MAIN METHOD ----------------------------
    public static void main(String[] args) throws FileNotFoundException {

        File employmentManagementFile = new File("input.txt");
        File outputFile = new File("output.txt");

        // check for any missing files
        if (!outputFile.exists() || !employmentManagementFile.exists()) {
            System.out.println("One or more files are not found!");
            System.exit(0);
        }

        // Create Print Writer to write in the output file
        PrintWriter pw = new PrintWriter(outputFile);

        // A scanner for the command file
        Scanner fileScanner = new Scanner(employmentManagementFile);

        // Create an object of the system
        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        while (fileScanner.hasNextLine()) {
            String commandLine = fileScanner.nextLine();
            handleCommand(commandLine, ems, pw);
        }
        pw.close();
    }
// --------------------------------------------------------------------------------------------------------------

    public static void handleCommand(String commandLine, EmployeeManagementSystem ems, PrintWriter pw) {
        String[] parts = commandLine.split(",");

        switch (parts[0].trim()) {
            case "Add_Manager":
                Employee manager = new Manager(parts[1].trim(), Integer.parseInt(parts[2].trim()), Double.parseDouble(parts[3].trim()));
                pw.println(ems.addEmployee(manager));
                break;

            case "Add_Developer":
                Employee developer = new Developer(parts[1].trim(), Integer.parseInt(parts[2].trim()), Double.parseDouble(parts[3].trim()));
                pw.println(ems.addEmployee(developer));
                break;

            case "Add_Designer":
                Employee designer = new Designer(parts[1].trim(), Integer.parseInt(parts[2].trim()), Double.parseDouble(parts[3].trim()));
                pw.println(ems.addEmployee(designer));
                break;

            case "Give_Leave":
                pw.println(ems.approveLeave(Integer.parseInt(parts[1].trim()), Integer.parseInt(parts[2].trim()), LocalDate.parse(parts[3].trim()), Integer.parseInt(parts[4].trim())));
                break;

            case "Change_State":
                if (parts[3].trim().equalsIgnoreCase("Working")) {
                    pw.println(ems.markEmployeeAsWorking(Integer.parseInt(parts[1].trim()), Integer.parseInt(parts[2].trim())));
                } else if (parts[3].trim().equalsIgnoreCase("On Leave")) {
                    return;
                }
                break;

            case "del_Employee":
                pw.println(ems.removeEmployee(Integer.parseInt(parts[1].trim())));
                break;

            case "printAllEmployees":
                pw.println(ems.printAllEmployees());
                break;

            case "print_Leave_Records":
                pw.println(ems.printEmployeeLeaveRecords(Integer.parseInt(parts[1].trim())));
                break;

        }
    }
// --------------------------------------------------------------------------------------------------------------
}
