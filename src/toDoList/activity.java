package toDoList;

import java.util.Scanner;

public class activity {

    private String event;
    private boolean completion;
    private String description;
    private String dueDate;
    //private int order;


    public activity(String event) {
        this.event = event;
        this.description = setDescription();
        this.dueDate = setDueDate();
        //this.order = setOrder();
        this.completion = setCompletionStatus();
        if (completion == true) {
            System.out.println("This activity has been completed");
        }
    }

    private int setOrder() {
        System.out.print("Provide a priority index between 1-10: ");
        Scanner in = new Scanner(System.in);
        int order = in.nextInt();
        return order;
    }

    private String setDueDate() {
        System.out.print("When is this task due? (MM/DD/YY Format): ");
        Scanner in = new Scanner(System.in);
        String dueDate = in.nextLine();
        return dueDate;
    }



    private String setDescription() {
        System.out.print("Describe task: ");
        Scanner in = new Scanner(System.in);
        String description = in.nextLine();
        return description;
    }
    private boolean setCompletionStatus() {
        int i = 0;
        boolean out = false;
        while (i == 0) {
            System.out.print("Has this task been completed? (Answer yes/no): ");
            Scanner in = new Scanner(System.in);
            String compStatus = in.nextLine();
            compStatus = compStatus.toLowerCase();
            if (compStatus.equals("yes")) {
                out = true;
                i = 1;
            } else if (compStatus.equals("no")) {
                out = false;
                i = 1;
            } else {
                System.out.println("Please try again");
            }
        }
        return out;
    }

    public String getEvent() {
        return event;
    }
}
