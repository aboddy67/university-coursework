/*
Name: Abdulrahman Adnan Thigah
Section: CS7 
Program No: 1
*/

public class Ticket {

    // Declaring all needed variables
    private Flight flight;
    private Passenger passenger;
    private int seatRow;
    private String seatNumber;
    private String classType;
    private int reservationConfirmationNumber;
    static int reservationNumber = 100;

// ------------------------------------------------------------------------------------------------------------------

    // Constructor
    public Ticket(Flight flight, Passenger passenger, int seatRow, String seatNumber, String classType) {
        this.flight = flight;
        this.passenger = passenger;
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
        this.classType = classType;
        reservationConfirmationNumber = reservationNumber;
        reservationNumber++;
    }

// ------------------------------------------------------------------------------------------------------------------
//    ************************************* Setters & Getters ************************************

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public int getReservationConfirmationNumber() {
        return reservationConfirmationNumber;
    }

    public void setReservationConfirmationNumber(int reservationConfirmationNumber) {
        this.reservationConfirmationNumber = reservationConfirmationNumber;
    }

    // ------------------------------------------------------------------------------------------------------------------

    // Calculating the price according to the arrival City and class with adding the VAT percentage
    public double ticketPrice() {
        // assigning all price variables 
        final double standardTicket = 2000;
        final double HajjDiscountPercentage = 0.20;
        final double businessClassMultiplier = 2;
        final double firstClassMultiplier = 4;
        final double vatPercentage = 0.15;
        double totalTicket = standardTicket;

        // checking for all the price changing conditions
        if (classType.equalsIgnoreCase("BusinessClass")) {
            totalTicket += totalTicket * businessClassMultiplier;
        } else if (classType.equalsIgnoreCase("FirstClass")) {
            totalTicket += totalTicket * firstClassMultiplier;
        }

        if (flight.getArrivalCity().equalsIgnoreCase("JED")) {
            totalTicket -= totalTicket * HajjDiscountPercentage;
        }
        // lastly adding the 15% vat
        totalTicket += totalTicket * vatPercentage;

        return totalTicket;
    }

// ------------------------------------------------------------------------------------------------------------------
    
    // returning all the class information
    @Override
    public String toString() {
        return "Reservation Confirmation Number= " + reservationConfirmationNumber
                + ", Flight Number=" + flight.getFlightNumber()
                + ", Passenger Name= " + passenger.getName()
                + ", Seat Number= " + seatRow + seatNumber
                + ", classType= " + classType;
    }

} // end
