/*
Course: CPCS 204
Name: Abdulrahman Thigah
Section: CS11
Name of lab instructor: Ayman Yafoz
Assignment number: #3
*/

public class Train {
    private String trainID;
    private int capacity;
    private int availableSeats;

    public Train(String trainID, int capacity) {
        this.trainID = trainID;
        this.capacity = capacity;
        availableSeats = capacity;
    }

    public String getTrainID() {
        return trainID;
    }

    public int getCapacity() {
        return capacity;
    }

    public String bookSeats(Passenger passenger) {
        if (availableSeats > 0) {
            availableSeats--;
            return "Booking confirmed for Passenger " + passenger + ".";
        } else {
            return null; // meaning no seat is available
        }
    }

    public String cancelSeat(Passenger passenger) {
        if (availableSeats < capacity) {
            availableSeats++;
            return "Booking cancelled for Passenger " + passenger + ".";
        } else {
            return null; // as the train has no booked seats
        }
    }
}
