/*
Course: CPCS 204
Name: Abdulrahman Thigah
Section: CS11
Name of lab instructor: Ayman Yafoz
Assignment number: #3
*/

public class Ticket {
    private Passenger passenger;
    private Train train;

    public Ticket(Passenger passenger, Train train) {
        this.passenger = passenger;
        this.train = train;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Train getTrain() {
        return train;
    }

    @Override
    public String toString() {
        return "Ticket [Passenger: " + passenger.toString() + ", Train ID: " + train.getTrainID() + "]";
    }
}
