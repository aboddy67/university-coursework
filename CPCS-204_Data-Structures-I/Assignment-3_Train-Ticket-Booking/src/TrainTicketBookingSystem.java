/*
Course: CPCS 204
Name: Abdulrahman Thigah
Section: CS11
Name of lab instructor: Ayman Yafoz
Assignment number: #3
*/

import java.io.File;
import java.io.PrintWriter;

public class TrainTicketBookingSystem {
    private Queue<Passenger> passengerQueue;
    private Stack<Ticket> confirmStack;
    private Queue<Ticket> waitingQueue;
    private Train train;
    private PrintWriter outputWriter;


    public TrainTicketBookingSystem() {
        passengerQueue = new Queue<>();
        confirmStack = new Stack<>();
        waitingQueue = new Queue<>();
        try {
            outputWriter = new PrintWriter(new File("output.txt"));
        } catch (Exception e) {
            System.out.println("Error initializing Print Writer for output file...\n Error: " + e.getMessage());
        }
    }

    public void addTrain(String trainID, int capacity) {
        train = new Train(trainID, capacity);
        outputWriter.println("Train " + train.getTrainID() + " with capacity " + train.getCapacity() + " has been added.");
    }

    public void addPassenger(String passengerID, String name) {
        Passenger newPassenger = new Passenger(passengerID, name);
        passengerQueue.enqueue(newPassenger);
        outputWriter.println("Passenger " + newPassenger.toString() + " has been added to the system.");
    }

    public void bookSeat(String passengerID) {
        Passenger bookingPassenger = findPassengerByID(passengerID);

        if (bookingPassenger != null) {
            Ticket newTicket = new Ticket(bookingPassenger, train);
            String bookResult = train.bookSeats(bookingPassenger);

            if (bookResult != null) {
                confirmStack.push(newTicket);
                outputWriter.println(bookResult);

            } else {
                waitingQueue.enqueue(newTicket);
                outputWriter.println("No seats for " + bookingPassenger.toString() + ", added to waiting list.");

            }
        } else {
            outputWriter.println("Passenger with ID: " + passengerID + " not found.");
        }
    }

    public void cancelBooking(String passengerID) {
        Passenger cancellingPassenger = findPassengerByID(passengerID);

        if (cancellingPassenger != null) {
            String cancelResult = train.cancelSeat(cancellingPassenger);

            if (cancelResult != null) {
                removePassengerFromConfirmed(cancellingPassenger);
                outputWriter.println(cancelResult);

                if (!waitingQueue.isEmpty()) {
                    Ticket waitingQueueTicket = waitingQueue.dequeue();
                    String bookResult = train.bookSeats(waitingQueueTicket.getPassenger());

                    if (bookResult != null) {
                        confirmStack.push(waitingQueueTicket);
                        outputWriter.println(bookResult);
                    }
                }
            } else
                outputWriter.println("No booking found for " + cancellingPassenger.toString() + ".");
        } else
            outputWriter.println("Passenger with ID: " + passengerID + " not found.");
    }

    public void showConfirmedTickets() {

    }

    public void showWaitingTickets() {

    }

    public Passenger findPassengerByID(String passengerID) {
        Node<Passenger> helpPointer = passengerQueue.peak();
        while (helpPointer != null) {
            if (helpPointer.data.getPassengerID().equals(passengerID))
                return helpPointer.data; // return the passenger object from the queue

            helpPointer = helpPointer.next; // continue if not
        }
        return null; // passenger not found
    }

    public Ticket removePassengerFromConfirmed(Passenger passenger) {
        Stack<Ticket> tempStack = new Stack<>();
        Ticket removedTicket = null;

        while (!confirmStack.isEmpty()) {
            Ticket currentTicket = confirmStack.pop();

            if (currentTicket.getPassenger().equals(passenger)) {
                removedTicket = currentTicket;
            } else {
                tempStack.push(currentTicket);
            }
        }

        while (!tempStack.isEmpty()) {
            confirmStack.push(tempStack.pop());
        }

        return removedTicket;
    }
}
