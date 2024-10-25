/* 
Abdulrahman Thigah
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainSystem {
    public static void main(String[] args) {

        TrainTicketBookingSystem TrainSystem = new TrainTicketBookingSystem();

        Scanner scanFile = null;
        try {
            File inputFile = new File("input.txt");
            scanFile = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found");
        }

        while (scanFile.hasNextLine()) {
            String inputLine = scanFile.nextLine();
            String[] inputParts = inputLine.split(" ");
            String command = inputParts[0];

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
                    String trainIdToBook = inputParts[2];
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

        TrainSystem.closeOutputWriter();
    }
}
