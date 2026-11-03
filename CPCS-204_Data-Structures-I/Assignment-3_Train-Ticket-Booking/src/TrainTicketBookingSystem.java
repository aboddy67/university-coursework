/*
Course: CPCS 204
Name: Abdulrahman Thigah
Section: CS11
Name of lab instructor: Ayman Yafoz
Assignment number: #3
*/

import java.io.PrintWriter;

public class TrainTicketBookingSystem {
    private Queue<Passenger> passengerQueue;
    private Stack<Ticket> confirmStack;
    private Queue<Ticket> waitingQueue;
    private Train train;
    private PrintWriter outputWriter;

    // --------------------------------------------------------------------------------------------------
    public TrainTicketBookingSystem() {
        passengerQueue = new Queue<>();
        confirmStack = new Stack<>();
        waitingQueue = new Queue<>();

        // try-catch for PrintWriter to hold any exception and print them
        try {
            outputWriter = new PrintWriter("output.txt");
        } catch (Exception e) {
            System.out.println("Error initializing Print Writer for output file...\n Error: " + e.getMessage());
        }
    }

    // --------------------------------------------------------------------------------------------------
    public void addTrain(String trainID, int capacity) {
        train = new Train(trainID, capacity);
        outputWriter.println("Train " + train.getTrainID() + " with capacity " + train.getCapacity() + " has been added.");
    }

    // --------------------------------------------------------------------------------------------------
    public void addPassenger(String passengerID, String name) {
        Passenger newPassenger = new Passenger(passengerID, name);
        passengerQueue.enqueue(newPassenger);
        outputWriter.println("Passenger " + newPassenger + " has been added to the system.");
    }

    // --------------------------------------------------------------------------------------------------
    public void bookSeat(String passengerID) {
        Passenger bookingPassenger = findPassengerByID(passengerID);

        // if passenger found
        if (bookingPassenger != null) {
            Ticket newTicket = new Ticket(bookingPassenger, train);
            String bookResult = train.bookSeats(bookingPassenger);

            // if train has available seats
            if (bookResult != null) {
                confirmStack.push(newTicket);
                outputWriter.println(bookResult);

            } else { //  no available seats
                waitingQueue.enqueue(newTicket);
                outputWriter.println("No seats for " + bookingPassenger + ", added to waiting list.");

            }
        } else { // no passenger found
            outputWriter.println("Passenger with ID: " + passengerID + " not found.");
        }
    }

    // --------------------------------------------------------------------------------------------------
    public void cancelBooking(String passengerID) {
        Passenger cancellingPassenger = findPassengerByID(passengerID);

        // if passenger found
        if (cancellingPassenger != null) {
            String cancelResult = train.cancelSeat(cancellingPassenger);

            // if train has available seats
            if (cancelResult != null) {
                Ticket removedTicket = removePassengerFromConfirmed(cancellingPassenger);

                // if there was a ticket removed
                if (removedTicket != null) {
                    outputWriter.println(cancelResult);

                    // if there is passengers waiting in the queue book them
                    if (!waitingQueue.isEmpty()) {
                        Ticket waitingQueueTicket = waitingQueue.dequeue();
                        String bookResult = train.bookSeats(waitingQueueTicket.getPassenger());

                        // if the train has available seats book from waiting
                        if (bookResult != null) {
                            confirmStack.push(waitingQueueTicket);
                            outputWriter.println(bookResult);
                        }
                    }
                }
            } else outputWriter.println("No booking found for " + cancellingPassenger + "."); // no seats booked on train
        } else outputWriter.println("Passenger with ID: " + passengerID + " not found."); // passenger not found
    }

    // --------------------------------------------------------------------------------------------------
    public void showConfirmedTickets() {
        outputWriter.printf("%-17s%-17s%-17s%n", "------------------CONFIRMED PASSENGER------------------", "", "");
        outputWriter.printf("| %-15s | %-15s | %-15s |%n", "Passenger ID", "Name", "Train ID");
        outputWriter.printf("| %-15s | %-15s | %-15s |%n", "---------------", "---------------", "---------------");

        // temporary stack to iterate over confirmed stack and print passengers
        Stack<Ticket> tempStack = new Stack<>();
        while (!confirmStack.isEmpty()) {
            Ticket currentTicket = confirmStack.pop();
            outputWriter.printf("| %-15s | %-15s | %-15s |%n", currentTicket.getPassenger().getPassengerID(), currentTicket.getPassenger().getName(), currentTicket.getTrain().getTrainID());
            tempStack.push(currentTicket);
        }

        // return original stack
        while (!tempStack.isEmpty()) {
            confirmStack.push(tempStack.pop());
        }
    }

    // --------------------------------------------------------------------------------------------------
    public void showWaitingTickets() {
        outputWriter.printf("%-17s%-17s%-17s%n", "------------------WAITING PASSENGER--------------------", "", "");
        outputWriter.printf("| %-15s | %-15s | %-15s |%n", "Passenger ID", "Name", "Train ID");
        outputWriter.printf("| %-15s | %-15s | %-15s |%n", "---------------", "---------------", "---------------");

        // temporary queue to iterate over the waiting queue to display waiting passengers
        Queue<Ticket> tempQueue = new Queue<>();
        while (!waitingQueue.isEmpty()) {
            Ticket currentTicket = waitingQueue.dequeue();
            outputWriter.printf("| %-15s | %-15s | %-15s |%n", currentTicket.getPassenger().getPassengerID(), currentTicket.getPassenger().getName(), currentTicket.getTrain().getTrainID());
            tempQueue.enqueue(currentTicket);
        }

        // return original queue
        while (!tempQueue.isEmpty()) {
            waitingQueue.enqueue(tempQueue.dequeue());
        }
    }

    // --------------------------------------------------------------------------------------------------
    public Passenger findPassengerByID(String passengerID) {
        Node<Passenger> helpPointer = passengerQueue.peak();
        while (helpPointer != null) {
            if (helpPointer.data.getPassengerID().equals(passengerID))
                return helpPointer.data; // return the passenger object from the queue

            helpPointer = helpPointer.next; // continue if not
        }
        return null; // passenger not found
    }

    // --------------------------------------------------------------------------------------------------
    public Ticket removePassengerFromConfirmed(Passenger passenger) {
        //temporary stack to iterate over the confirmed stack and remove passenger then revert the original stack
        Stack<Ticket> tempStack = new Stack<>();
        Ticket removedTicket = null;

        while (!confirmStack.isEmpty()) {
            Ticket currentTicket = confirmStack.pop();

            if (currentTicket.getPassenger().equals(passenger)) {
                removedTicket = currentTicket; // return if found
            } else {
                tempStack.push(currentTicket); // continue if not
            }
        }

        // return original stack
        while (!tempStack.isEmpty()) {
            confirmStack.push(tempStack.pop());
        }

        return removedTicket;
    }

    // --------------------------------------------------------------------------------------------------
    // PrinterWriter close method to print everything to the output file
    public void closeOutputWriter() {
        if (outputWriter != null) {
            outputWriter.close();
        }
    }
    // --------------------------------------------------------------------------------------------------
}
