// SE L2T07 - Capstone Project I - OOP

// 'Project' class used to create new project instances and allow data to be changed.
public class Project {

    // Attributes
    private final int projectNum;
    private final String projectName;
    private final String buildingType;
    private final String physicalAddress;
    private final int erfNum;
    private final int totalFee;
    private int totalPaid;
    private String deadline;

    private final Architect architect;
    private Contractor contractor;
    private final Customer customer;

    // Constructor
    public Project(int projectNum, String projectName, String buildingType, String physicalAddress, int erfNum,
                   int totalFee, int totalPaid, String deadline, Architect architect, Contractor contractor,
                   Customer customer) {
        this.projectNum = projectNum;
        this.projectName = projectName;
        this.buildingType = buildingType;
        this.physicalAddress = physicalAddress;
        this.erfNum = erfNum;
        this.totalFee = totalFee;
        this.totalPaid = totalPaid;
        this.deadline = deadline;
        this.architect = architect;
        this.contractor = contractor;
        this.customer = customer;
    }

    // Setters
    // These setters are used to change specific data for a project.
    public void setTotalPaid(int totalPaid) {  // Changing amount paid
        this.totalPaid = totalPaid;
    }

    public void setDeadline(String deadline) {  // Changing deadline
        this.deadline = deadline;
    }

    public void setContractor(Contractor contractor) {  // Changing contractor details
        this.contractor = contractor;
    }

    // toString method
    public String toString() {
        return "\n\nProject Number: " + projectNum + "\n" +
                "Project Name: " + projectName + "\n" +
                "Type of building: " + buildingType + "\n" +
                "ERF Number: " + erfNum + "\n" +
                "Physical Address: " + physicalAddress + "\n" +
                "Total fee charged for project: " + totalFee + "\n" +
                "Total amount already paid: " + totalPaid + "\n" +
                "Deadline of the project: " + deadline + "\n" +
                "\nArchitect details: \n" + architect + "\n" + "\n" +
                "Contractor details: \n" + contractor + "\n" + "\n" +
                "Customer details: \n" + customer;
    }
}