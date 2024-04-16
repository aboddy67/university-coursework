/*
Name: Abdulrahman Adnan Thigah
Section: CS7 
Program No: 1
*/

public class Passenger {
    
    // Declaring all needed variables
    private String passportNumber; 
    private String name;

// ------------------------------------------------------------------------------------------------------------------

    // Constructor
    public Passenger(String passportNumber, String name) {
        this.passportNumber = passportNumber;
        this.name = name;
    }
    
// ------------------------------------------------------------------------------------------------------------------
//    ************************************* Setters & Getters ************************************
    
    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
// ------------------------------------------------------------------------------------------------------------------

    // Set the newName if any Name updates were to happen
    public void updateDetails(String newName) {
        newName = name;
    }

// ------------------------------------------------------------------------------------------------------------------

    // returning all the class information
    @Override
    public String toString() {
     
        return "Passport Number: " + passportNumber + ", Name: " + name;
    }
    
// ------------------------------------------------------------------------------------------------------------------

} // end