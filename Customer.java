// SE L2T07 - Capstone Project I - OOP

// 'Customer' class used to create new customer instances.
public class Customer {

    // Attributes
    private final String name;
    private final String telephone;
    private final String emailAddress;
    private final String physicalAddress;

    // Constructor
    public Customer(String name, String telephone, String emailAddress, String physicalAddress) {
        this.name = name;
        this.telephone = telephone;
        this.emailAddress = emailAddress;
        this.physicalAddress = physicalAddress;
    }

    // toString method
    public String toString() {
        String output = "Name: " + name;
        output += "\nTelephone: " + telephone;
        output += "\nEmail Address: " + emailAddress;
        output += "\nPhysical Address: " + physicalAddress + "\n";

        return output;
    }
}