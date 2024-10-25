/*
Course: CPCS 204
Name: Abdulrahman Thigah
Section: CS11
Name of lab instructor: Ayman Yafoz
Assignment number: #3
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainSystem {
    // --------------------------------------------------------------------------------------------------
    public static void main(String[] args) {

        // instance of the train system
        TrainTicketBookingSystem TrainSystem = new TrainTicketBookingSystem();

        // Create a scanner to scan the input file and try-catch if file not found
        Scanner scanFile = null;
        try {
            File inputFile = new File("input.txt");
            scanFile = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found");
        }

        // if the input file contains text
        if (scanFile != null) {

            // iterate over each line of the input file
            while (scanFile.hasNextLine()) {
                String inputLine = scanFile.nextLine(); // scan the line
                String[] inputParts = inputLine.split(" "); // split the line into parts and store them into an array
                String command = inputParts[0]; // take the first part as the command

                // check the command and execute accordingly
                // with each command taking it's needed parts from the array
                switch (command) {
                    case "add_train":
                        String trainIdToAdd = inputParts[1];
                        int trainCapacity = Integer.parseInt(inputParts[2]);
                        TrainSystem.addTrain(trainIdToAdd, trainCapacity);
                        break;
                    case "add_passenger":
                        String passengerIdToAdd = inputParts[1];
                        String passengerName = inputParts[2];
                        TrainSystem.addPassenger(passengerIdToAdd, passengerName);
                        break;
                    case "book":
                        String passengerIdToBook = inputParts[1];
                        String trainIdToBook = inputParts[2]; // this won't be used because assignment assumes 1 train as uml states
                        TrainSystem.bookSeat(passengerIdToBook);
                        break;
                    case "cancel":
                        String passengerIdToCancel = inputParts[1];
                        TrainSystem.cancelBooking(passengerIdToCancel);
                        break;
                    case "show_waiting":
                        TrainSystem.showWaitingTickets();
                        break;
                    case "show_confirmed":
                        TrainSystem.showConfirmedTickets();
                        break;
                }
            }
        } else System.out.println("Error: The input file is empty."); // input file is null

        // close PrintWriter to print to the output file
        TrainSystem.closeOutputWriter();
    }
    // --------------------------------------------------------------------------------------------------
}
