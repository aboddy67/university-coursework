/*
Name: Abdulrahman Adnan Thigah
Section: CS7 
Program No: 1
*/

// Importing necessary packages/classes for file handling and I/O operations
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BookingSystem {

// -------------------------------------------------------------------------------------------------------------------
    /*
    ************************************* MAIN METHOD ************************************
    * OVERVIEW:
    * THIS METHOD IS RESPONSIBLE FOR INITIALIZING AND HANDLING ALL NECESSARY FILES, SCANNERS, PRINTWRITERS AND ARRAYS.
    * IT THEN EXECUTES ALL THE METHODS FOR HANDLING THE INFORMATION GATHERED FROM THE INPUT FILES AND EXECUTES THEM.
    * AFTER IT'S DONE IT IT FREES THE RESOURCES TO AVOID ANY RESOURCE LEAKS.
    * LASTLY FLUSHING THE PRINTER TO PRINT THE EXECUTED CODE IN THE OUTPUT FILE.
    */
    
    public static void main(String[] args) throws FileNotFoundException {
        
//************************************ INITIALIZE ************************************
        // Initialize the output file and the printWriter
        File output_F = new File("output.txt");
        PrintWriter pw = new PrintWriter(output_F);

        // Initialize the files and scanners to read the input files
        File flight_passenger = new File("flight_passenger.txt");
        File inputCommands = new File("inputCommands.txt");
        Scanner scan_flightPassenger = new Scanner(flight_passenger);
        Scanner scan_inputCommands = new Scanner(inputCommands);


        // Check if the input files exist
        if (!flight_passenger.exists() || !inputCommands.exists()) {
            if (!flight_passenger.exists()) {
                System.out.println("Input file " + flight_passenger.getName() + " was not found!");
                System.out.println("Check: " + flight_passenger.getAbsolutePath());
            }
            if (!inputCommands.exists()) {
                System.out.println("Input file " + inputCommands.getName() + " was not found!");
                System.out.println("Check: " + inputCommands.getAbsolutePath());
            }
            System.exit(0);
        }


        // Read the first line of the file to get the number of flights and passengers to create the arrays
        int flightCount = scan_flightPassenger.nextInt();
        int passengerCount = scan_flightPassenger.nextInt();

        Flight[] storedFlights = new Flight[flightCount];
        Passenger[] storedPassengers = new Passenger[passengerCount];

        // Assumed max number of tickets.
        final int MAX_TICKET = 100;
        Ticket[] storedTickets = new Ticket[MAX_TICKET];


//************************************ EXECUTION ************************************
        // processing the Flights and Passengers file
        processFileFlightPassenger(storedFlights, storedPassengers, pw, scan_flightPassenger);

        // processing the Input Commands file
        processFileInputCommands(storedTickets, storedFlights, storedPassengers, scan_inputCommands, pw);

        // free the resources
        scan_flightPassenger.close();
        scan_inputCommands.close();

        // flush and close the printWriter to print to the output file
        pw.close();
    }

    //------------------------------------------------------------------------------------------------------------------
    /*
    ************************************* Processing the Flights and Passengers File ************************************
    * METHOD GROUP OVERVIEW:
    * This group of methods creates a loop iterating the command for taking a line from the file as long there exist a line.
    * Then it splits the line to parts and stores it in an array of string.
    * The first part of the line carries the command, so a switch case is made to handle each command accordingly.
    * Lastly when the command is read the rest of the line is sent and handled by the command called methods.
    * Sending the data to the according array either for Flights or Passengers, with finding the next open index to store.
    */
    
    // Loop as long as a line (command) exists
    public static void processFileFlightPassenger(Flight[] storedFlights, Passenger[] storedPassengers, PrintWriter pw, Scanner scan_flightPassenger) {
        while (scan_flightPassenger.hasNextLine()) {
            String command = scan_flightPassenger.nextLine();

            // sending the objects arrays and command line to the method to process them
            processFlightPassenger(command, storedFlights, storedPassengers, pw);
        }
        // add spacing
        pw.println();
    }
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // split the line (command) into parts to store in array send it to other methods
    public static void processFlightPassenger(String commandLine, Flight[] storedFlights, Passenger[] storedPassengers, PrintWriter pw) {
        String[] parts = commandLine.split(" ");

        String commandType = parts[0];
        
        // switch case to handle each type of command
        switch (commandType) {
            case "AddFlight":
                addFlight(parts, storedFlights, pw);
                break;
            case "AddPassenger":
                addPassenger(parts, storedPassengers, pw);
                break;
        }
    }
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public static void addFlight(String[] parts, Flight[] storedFlights, PrintWriter pw) {
        String flightNumber = parts[1];
        String departureCity = parts[2];
        String arrivalCity = parts[3];
        int gateNumber = Integer.parseInt(parts[4]);
        int rows = Integer.parseInt(parts[5]);
        int columns = Integer.parseInt(parts[6]);

        int index = nextAvailableIndex(storedFlights);

        if (index != -1) {
            storedFlights[index] = new Flight(flightNumber, departureCity, arrivalCity, gateNumber, rows, columns);
            pw.println("Flight " + flightNumber + " added successfully");
        } else {
            System.out.println("Cannot store flight, no available space");
        }
    }
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public static void addPassenger(String[] parts, Passenger[] storedPassengers,  PrintWriter pw) {
        String passportNumber = parts[1];
        String passengerName = parts[2];

        int index = nextAvailableIndex(storedPassengers);

        if (index != -1) {
            storedPassengers[index] = new Passenger(passportNumber, passengerName);
            pw.println("Passenger " + passengerName + " added successfully");
        } else {
            System.out.println("Cannot store Passenger, no available space");
        }
    }
//------------------------------------------------------------------------------------------------------------------
    /*
    ************************************* Processing Input Commands File ************************************
    * METHOD GROUP OVERVIEW:
    * This group of methods similarly creates a loop iterating the command for taking a line.
    * and also splits the line to parts and stores it in an array of string.
    * The first part as well carries the command, so a switch case is made.
    * Lastly when the command is read the rest of the line is sent and handled by the command called methods
    * Each method handles its own conditions if a ticket is not found, or booking etc.
    * And data is sent, either storing a Ticket or creating the Invoices.
    */
    
    // Loop as long as a line (command) exists
    public static void processFileInputCommands(Ticket[] storedTickets, Flight[] storedFlights, Passenger[] storedPassengers, Scanner scan_inputCommands, PrintWriter pw) {
        while (scan_inputCommands.hasNextLine()) {
            String commandLine = scan_inputCommands.nextLine();
            processInputCommands(commandLine, storedTickets, storedFlights, storedPassengers, pw);
        }
    }
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // split the line (command) into parts to store in to send it to other methods
    public static void processInputCommands(String commandLine, Ticket[] storedTickets, Flight[] storedFlights, Passenger[] storedPassengers, PrintWriter pw) {
        String[] parts = commandLine.split(" ");

        String commandType = parts[0];

        // switch case to handle each type of command
        switch (commandType) {
            case "BookTicket":
                bookTicket(parts, storedTickets, storedFlights, storedPassengers, pw);
                break;
            case "GenerateInvoice":
                GenerateInvoice(parts, storedTickets, pw);
                break;
            case "GenerateIFlightInvoice":
                GenerateFlightInvoice(parts, storedTickets, storedFlights, pw);
                break;
        }
    }

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // command book ticket, searches for the passenger and flight and checks if they exist
    public static void bookTicket(String[] parts, Ticket[] storedTickets, Flight[] storedFlights, Passenger[] storedPassengers, PrintWriter pw) {
        String passportNumber = parts[1];
        String flightNumber = parts[2];
        int row = Integer.parseInt(parts[3]);
        String seatNumber = parts[4];
        String classType = parts[5];
        
        // search for the passenger and flight
        int passengerIndex = SearchPassenger(storedPassengers, passportNumber);
        int flightIndex = SearchFlight(storedFlights, flightNumber);
        
        if (passengerIndex == -1) {

            pw.println("*********************BookTicket**************************\n");
            pw.println("Passenger with Passport number " + passportNumber + " is not Registered\n");
            return;
        }

        if (flightIndex == -1) {

            pw.println("*********************BookTicket**************************\n");
            pw.println("Flight " + flightNumber + " Not Found\n");
            return;
        }

        // Check if the seat is already reserved
        Passenger passenger = storedPassengers[passengerIndex];

        Flight flight = storedFlights[flightIndex];
        if (!flight.isSeatAvailable(row, seatNumber.charAt(0))) {
            pw.println("*********************BookTicket**************************\n");
            pw.println("Seat " + row + seatNumber + " is already Reserved or Not found\n");
            return;
        }

        // Store the ticket
        int index = nextAvailableIndex(storedTickets);
        storedTickets[index] = new Ticket(flight, passenger, row, seatNumber, classType);

        // Book the seat
        storedFlights[flightIndex].bookSeat(row, seatNumber.charAt(0), passportNumber);

        // print the successful booking
        pw.println("*********************BookTicket**************************\n");
        pw.println("Seat booked successfully\nTicket information: ");
        pw.println(storedTickets[index]);
        pw.println();

    }

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    

    // make an invoice using the ticketPrice method in  ticket class and print its information
    public static void GenerateInvoice(String[] parts, Ticket[] storedTickets, PrintWriter pw) {
        int RCN = Integer.parseInt(parts[1]);
        int indexRCN = SearchRCN(RCN, storedTickets);

        if (indexRCN == -1) {
            pw.println("*********************Generate Ticket Invoice**************************\n");
            pw.println("Reservation Number " + RCN + " is not available.\n");
        } else {
            pw.println("*********************Generate Ticket Invoice**************************\n");
            pw.println("Ticket information:\n" + storedTickets[indexRCN]);
            pw.println("Total ticket price = " + storedTickets[indexRCN].ticketPrice());

        }
        pw.println(); // add spacing 

    }
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    // search for the reservation confirmation number in the stored tickets
    public static int SearchRCN(int RCN, Ticket[] storedTickets) {
        for (int i = 0; i < storedTickets.length; i++) {
            if (storedTickets[i] == null) {
                continue; // to skip the iteration and move to the next one
            }
            int storedRCN = storedTickets[i].getReservationConfirmationNumber();

            if (storedRCN == RCN) {
                return i;
            }
        }
        return -1; // return if the RCN is not found
    }

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    // generate the flight invoice by searching for the flight number and then the tickets for that flight
    // then it prints the seat plan and the ticket information for the flight
    public static void GenerateFlightInvoice(String[] parts, Ticket[] storedTickets, Flight[] storedFlights, PrintWriter pw) {

        String flightNumberNoConversion = parts[1];
        int invoiceFlightNumber = Integer.parseInt(parts[1]);

        Ticket[] thisFlightTickets = new Ticket[storedTickets.length];
        int flightIndex = SearchFlight(storedFlights, flightNumberNoConversion);
        // to add the total each time a ticket is encountered 
        double totalInvoicePrice = 0;

        // Check if the flight is found
        if (flightIndex == -1 || storedFlights[flightIndex] == null) {
            pw.println("*********************Generate Flight Invoice**************************\n");
            pw.println("Flight Not Found or No Ticket booked for this flight\n");
            return; // Exit the method if the flight is not found or null
        }
        
        // flag to check if the seat plan is printed
        boolean seatPlanPrinted = false;
        
        // loop to search for the tickets for the flight
        for (int i = 0; i < storedTickets.length; i++) {
            if (storedTickets[i] != null) {
                int searchFlightNumber = Integer.parseInt(storedTickets[i].getFlight().getFlightNumber());
                if (searchFlightNumber == invoiceFlightNumber) {
                    // Store the ticket
                    thisFlightTickets[i] = storedTickets[i];
                    
                    // Add the ticket price to the total invoice price
                    totalInvoicePrice += thisFlightTickets[i].ticketPrice();

                    // Print the seat plan only once
                    if (!seatPlanPrinted) {
                        pw.println("*********************Generate Flight Invoice**************************\n");
                        pw.println("Seat Plan for flight " + invoiceFlightNumber + " is: \n" + "************************************");

                        if (flightIndex != -1) {
                            pw.println(storedFlights[flightIndex].printSeatPlan());
                        }

                        seatPlanPrinted = true; // Set the flag to true to avoid printing the seat plan again
                    }
                }
            }
        }

        // Print the ticket information for the flight
        for (Ticket thisFlightTicket : thisFlightTickets) {
            if (thisFlightTicket != null) { // Check if the Ticket object is not null

                // print all the tickets information
                pw.println("Ticket information\n" + thisFlightTicket);

            }

        }
        // print the total invoice price 
        pw.println("\nTotal Invoice price = " + totalInvoicePrice + "\n");
    }

// -------------------------------------------------------------------------------------------------------------------
    /*
    ************************************* Extra helping methods ************************************
    * METHOD GROUP OVERVIEW:
    * these methods are needed by other methods to do the task of searching and finding and return an answer.
    * Mostly 1 means successful and -1 means not.
    * conditions for handling the success are made in each method accordingly.
    */
    
    // find the next available index in the array
    private static int nextAvailableIndex(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                return i;
            }
        }
        return -1; // return if array is full 
    }

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    //searching for a requested passenger
    public static int SearchPassenger(Passenger[] passengers, String passportNumber) {
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i].getPassportNumber().equals(passportNumber)) {
                return i; // Return the index of the matching passenger
            }
        }
        return -1; // Return if the passenger is not found
    }
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    //searching for a requested flight
    public static int SearchFlight(Flight[] flights, String flightNumber) {
        for (int i = 0; i < flights.length; i++) {
            if (flights[i].getFlightNumber().equals(flightNumber)) {
                return i; // Return the index of the matching flight
            }
        }
        return -1; // Return if the flight is not found
    }
// -------------------------------------------------------------------------------------------------------------------

}// END MAIN CLASS
