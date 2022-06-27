package emailApp;

import java.util.Locale;
import java.util.Scanner;

public class email {
    private String firstName = "Jeff";
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String altEmail;
    private String companySuffix = "mycompany.com";

    //Constructor to receive first name and last name
    public email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED FOR: " + this.firstName + " " + this.lastName);

        //Call a method asking for the department and return department
        this.department = setDepartment();
        //System.out.println("Department: " + this.department);

        //Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        //System.out.println("Your password is: " + this.password);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + companySuffix;
        //System.out.println("Your email is: " + email);
    }

    //Ask for the department
    private String setDepartment() {
        System.out.print("Enter the department code:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) { return "sales."; }
        else if (depChoice == 2) { return "development."; }
        else if (depChoice == 3) { return "accounting."; }
        else { return ""; }

    }

    //Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";
        char[] password = new char[length];
        for (int i=0; i<length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    //Set the alt email
    public void setAltEmail(String altEmail) {
        this.altEmail = altEmail;
    }

    //Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    // Get the mailbox capacity
    public int getMailboxCapacity() { return mailboxCapacity; }

    // Get the alt email
    public String getAltEmail() { return altEmail; }

    // Get password
    public String getPassword() { return password; }

    // Get all info

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }

}
