/*
Name: Abdulrahman Adnan Thigah
Section: CS7 
Program No: 1
 */

public class Flight {

    // Declaring all needed variables
    private String flightNumber;
    private String departureCity;
    private String arrivalCity;
    private int gateNumber;
    private String[][] seatMap;
    private int row;
    private int column;

// ------------------------------------------------------------------------------------------------------------------

    // Constructor
    public Flight(String flightNumber, String departureCity, String arrivalCity, int gateNumber, int row, int column) {
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.gateNumber = gateNumber;
        this.row = row;
        this.column = column;

        // initializing seatMap for this flight
        initializeSeatMap();
    }

// ------------------------------------------------------------------------------------------------------------------
//    ************************************* Setters & Getters ************************************

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public String[][] getSeatMap() {
        return seatMap;
    }

// ------------------------------------------------------------------------------------------------------------------
    // method for assigning the seat with the passenger passportID
    public boolean bookSeat(int row, char column, String passengerID) {
        int columnIndex = column - 'A';

        // Check if the seat is available using the isSeatAvailable method
        if (isSeatAvailable(row, column)) {
            seatMap[row - 1][columnIndex] = passengerID; // Assign the passenger ID to the specified seat
            return true; // Seat booking successful
        } else {
            return false; // Seat not available or invalid seat location
        }
    }

// ------------------------------------------------------------------------------------------------------------------
    // Method to check if a seat is available or open
    public boolean isSeatAvailable(int row, char column) {
        int columnIndex = column - 'A';

        // Check if the row and column are valid 
        if (row < 1 || row > seatMap.length || columnIndex < 0 || columnIndex >= seatMap[0].length) {
            return false; // Invalid row or column
        }

        // Check if the seat is available
        return seatMap[row - 1][columnIndex].equals("O"); // 'O' represents an available seat
    }
// ------------------------------------------------------------------------------------------------------------------

    // returning all the class information
    @Override
    public String toString() {

        return "Flight Number = " + flightNumber + ", Departure City = " + departureCity
                + ", Arrival City = " + arrivalCity + ", Gate Number = " + gateNumber
                + ", (Row= " + row + ", Column= " + column + ")";
    }
// ------------------------------------------------------------------------------------------------------------------

    // creating the seat map
    private void initializeSeatMap() {
        seatMap = new String[row][column]; // Use the row and column fields for dimensions
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                seatMap[i][j] = "O"; // Initialize all seats as available
            }
        }
    }
// ------------------------------------------------------------------------------------------------------------------

    // Visually printing the seat map to be seen in the output
    public String printSeatPlan() {
        StringBuilder seatPlan = new StringBuilder();

        // Header row
        seatPlan.append("Row\t\t");
        for (int i = 0; i < column; i++) {
            seatPlan.append((char) ('A' + i)).append("\t\t");

        }

        seatPlan.append("\n");

        // Seat map
        for (int i = 0; i < row; i++) {
            seatPlan.append(i).append("\t\t"); // Row number
            for (int j = 0; j < column; j++) {
                seatPlan.append(seatMap[i][j]).append("\t\t"); 
            }
            seatPlan.append("\n");
        }

        return seatPlan.toString();
    }

} // end
