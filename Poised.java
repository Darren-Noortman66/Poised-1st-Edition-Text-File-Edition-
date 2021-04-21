// Poised Management System
// SE L2T07 - Capstone Project I - OOP

// Importing the needed packages

import java.util.ArrayList;
import java.util.Scanner;

// This is the 'main' task file. All code will be executed in the main-driver within the 'Poised' class.
public class Poised {

    public static void main(String[] args) {

        // Creating an array to store the user's input.
        // An 'ArrayList' is used because the size of the list is not known and an ArrayList is resizable.
        ArrayList<Project> projects = new ArrayList<>();

        Scanner input = new Scanner(System.in);  // Creating instance for Scanner package.

        // Printing option list
        System.out.println("""
                Insert your Choice:
                1. Add a Project
                2. Update Deadline
                3. Update Fees
                4. Update Contractor details
                5. Exit
                                                
                """);

        int choice = input.nextInt();  // Requesting user's choice

        // Using a while-loop to keep the program running until the user is finished/ inserts 5.
        while (choice != 5) {

            // Each user-defined method is passed the ArrayList value, 'projects'
            // which will be used to work with our created data.
            if (choice == 1) {
                createProject(projects);
            } else if (choice == 2) {
                updateDeadline(projects);
            } else if (choice == 3) {
                updateFee(projects);
            } else if (choice == 4) {
                updateContractor(projects);
            } else {
                System.out.println("Invalid Input");
            }

            System.out.println("""
                                                    
                                                    
                    Select your choice:
                    1. Add a project
                    2. Update deadline
                    3. Update fees
                    4. Update Contractor details
                    5. Exit

                    """);

            choice = input.nextInt();  // Requesting user's choice
        }
    }

    // Creating a method named 'createProject' that will be used to create new projects.
    private static void createProject(ArrayList<Project> projects) {

        Scanner input = new Scanner(System.in);  // Creating instance for Scanner package.

        // Requesting each needed piece of information and storing it in the appropriate variable.
        System.out.print("\nInsert Project Number:\t");
        int projectNum = Integer.parseInt(input.nextLine());

        System.out.print("\nInsert Project Name:\t");
        String projectName = input.nextLine();

        System.out.print("\nInsert Building Type (Home, Office-Building, etc):\t");
        String typeOfBuilding = input.nextLine();

        System.out.println("\nInsert Physical Address of Building:\t");
        String physicalAddress = input.nextLine();

        System.out.print("\nInsert ERF Number:\t");
        int erfNum = Integer.parseInt(input.nextLine());

        System.out.print("\nInsert Total Fee for Project:\t");
        int totalFee = Integer.parseInt(input.nextLine());

        System.out.print("\nInsert Total Amount Already Paid:\t");
        int totalPaid = Integer.parseInt(input.nextLine());

        System.out.print("\nInsert Deadline for Project:\t");
        String deadline = input.nextLine();

        // Making a string array for each person working on the project with
        // the values gathered from the 'getDetails' method.

        // An instance of "Architect" is then created with the values gathered in getDetails. ('Details' used here)
        String[] details = getDetails("architect");
        Architect architect = new Architect(details[0], details[1], details[2], details[3]);

        // An instance of "Contractor" is then created with the values gathered in getDetails. ('Details1' used here)
        String[] details1 = getDetails("contractor");
        Contractor contractor = new Contractor(details1[0], details1[1], details1[2], details1[3]);

        // An instance of "Customer" is then created with the values gathered in getDetails. ('Details2' used here)
        String[] details2 = getDetails("customer");
        Customer customer = new Customer(details2[0], details2[1], details2[2], details2[3]);

        // Creating an instance of "Project" with all the information gathered in this method.
        // The arguments given for the class are the attributes of this method
        Project proj = new Project(projectNum, projectName, typeOfBuilding, physicalAddress, erfNum, totalFee,
                totalPaid, deadline, architect, contractor, customer);

        //  Adding the created 'proj' instance to the 'projects' arraylist.
        projects.add(proj);

        // Finalising the project by printing the information to the user.
        // This information will be put into a text-file in a later project.
        System.out.println("New Project added: \n" + proj);
    }

    // Creating a method named 'getDetails' that will be used to get the details of each person involved in a project.
    public static String[] getDetails(String role) {

        Scanner input = new Scanner(System.in);  // Instance for Scanner package.

        // Requesting each needed piece of information and storing it in the appropriate variable.
        System.out.println("\nInsert Name of " + role + ":\t");
        String name = input.nextLine();

        System.out.println("\nInsert Telephone Number of " + role + ":\t");
        String telephone = input.nextLine();

        System.out.println("\nInsert Email-Address of " + role + ":\t");
        String emailAddress = input.nextLine();

        System.out.println("\nInsert Physical Home Address of " + role + ":\t");
        String PhysicalAddress = input.nextLine();

        // Returning a string array with the information gathered in this method.
        return new String[]{name, telephone, emailAddress, PhysicalAddress};
    }

    // Creating a method named 'updateDeadline' that will be used to update the deadline for a chosen project.
    private static void updateDeadline(ArrayList<Project> projects) {

        Scanner input = new Scanner(System.in);  // Instance for Scanner package.

        // Requesting the index number of the project the user would like to work with.
        System.out.println("\nInput Project Index to Adjust Deadline Date:\t");
        int index = Integer.parseInt(input.nextLine());

        // Requesting the new Deadline date from the user.
        System.out.println("\nInput New Deadline Date:\t");
        String deadline1 = input.nextLine();

        // Finding the specific 'Project' object in the 'projects' arraylist by using the 'index' value given above.
        Project proj1 = projects.get(index);

        // Using the setter from the 'Project' class file to change the Deadline for the project.
        proj1.setDeadline(deadline1);

        System.out.println("\n\nDeadline Date Adjusted: \n" + projects);
    }

    // Creating a method named 'updateFee' that will be used to update the amount of money paid by the customer to date.
    private static void updateFee(ArrayList<Project> projects) {

        Scanner input = new Scanner(System.in);  // Instance for Scanner package.

        // Requesting the index number of the project the user would like to work with.
        System.out.println("\nInput Project Index to Adjust Amount Paid for Project Fee:\t");
        int index1 = input.nextInt();

        // Requesting the new amount paid by the customer to date.
        System.out.println("\nInput New Amount Paid for Project Fee :\t");
        int totalPaidNew = input.nextInt();

        // Get an index reference to the actual object using the ArrayList
        Project proj2 = projects.get(index1);

        // Using the setter from the 'Project' class file to change the Amount Paid by customer for the project.
        proj2.setTotalPaid(totalPaidNew);

        System.out.println("\n\nTotal Fee Paid Adjusted: \n" + projects);
    }

    // Creating a method named 'updateContractor' that will be used to update the contractor's contact details.
    private static void updateContractor(ArrayList<Project> projects) {

        Scanner input = new Scanner(System.in);  // Instance for Scanner package.

        // Requesting the index number of the project the user would like to work with.
        System.out.println("\nInput Project Index to Change Contractor Contact Details:\t");
        int index2 = input.nextInt();

        // An instance of "Contractor" is created with the values gathered in getDetails.
        // This is to replace the previously given details.
        String[] details = getDetails("contractor");
        Contractor newContractor = new Contractor(details[0], details[1], details[2], details[3]);

        // Finding the specific 'Project' object in the 'projects' arraylist by using the 'index2' value given above.
        Project proj2 = projects.get(index2);

        // Using the setter from the 'Project' class file to change the contractor's details.
        proj2.setContractor(newContractor);

        System.out.println("\n\nContractor Contact Details Changed: \n\n" + projects);
    }

}

/*

References:

- HyperionDev (2021). SE L2T07 - Capstone Project I - OOP - Task 7. Retrieved 15 April 2021,
  from Dropbox/ Darren Noortman/ Task 7/ SE L2T07 - Capstone Project I - OOP.pdf

- Previous tasks on level 2 of my course.

I used Eclipse to make the class diagrams and not IntelliJ. I was having some issues with IntelliJ, but I will get it.
If the diagram file gives any issues or doesn't work, then I will happily redo it. I wasn't too sure on how to do it, so
I hope this is fine.

I used Eclipse along with the Plugin 'objectAid' to make this diagram.
I also included a jpeg image file in the Task 6 file just to make it easy to read.

- Unknown Hero (?). Java ArrayList - w3schools. Retrieved 15 April 2021,
from https://www.w3schools.com/java/java_arraylist.asp

- Aveshnee (2020). Capstone Project systems - GitHub. Retrieved 15 April 2021,
from https://github.com/Aveshnee/Capstone-Project-systems

*/