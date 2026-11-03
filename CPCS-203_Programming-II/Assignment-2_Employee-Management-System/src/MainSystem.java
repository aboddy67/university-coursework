/*
Name: Abdulrahman Adnan Thigah
Section: CS7
Program No: 2
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

// --------------------------------------------------------------------------------------------------------------
// Main class handles all system features and uses them
public class MainSystem {
    /*
     ************************************* MAIN METHOD ************************************
     * OVERVIEW:
     * THIS METHOD CREATES AND INITIALIZES ALL FILES AND CHECKS FOR THEIR EXISTENCE
     * IT ALSO CREATES THE PRINTWRITER AND SCANNER IN ORDER TO READ AND WRITE FROM AND ONTO THOSE FILES
     * THEN CREATES AND HANDLES AN OBJECT FOR THE SYSTEM IN ORDER TO PERFORM ACTIONS ON EMPLOYEES FROM THE INPUT FILE
     */
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

        // Check for all lines in the file and parses them
        while (fileScanner.hasNextLine()) {
            String commandLine = fileScanner.nextLine();
            handleCommand(commandLine, ems, pw);
        }
        // Close the print writer and the scanner to free resources and print
        pw.close();
        fileScanner.close();
    }
// --------------------------------------------------------------------------------------------------------------

    // This method parses lines from an input file, identifying commands and executing them accordingly.
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
                // check whether the command needs to change to working or to on leave
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
} // End Main Class
