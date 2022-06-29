package toDoList;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class toDoListApp {

    public String toDoName;
    public static JFrame frameStart;

    private String setToDoName() {
        System.out.print("Name your To Do list: ");
        Scanner in = new Scanner(System.in);
        String toDoName = in.nextLine();
        return toDoName;
    }

    public static void main(String[] args) {

        frameStart = new startGUI();
        frameStart.setVisible(true);

        toDoListApp mine = new toDoListApp();

        createList myToDo = new createList(mine.setToDoName());

        JFrame frame = new toDoListGUI(myToDo.name);
        frame.setVisible(true);
        while (frame.isShowing() == true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (((toDoListGUI) frame).count == 1) {
                myToDo.addActivity(((toDoListGUI) frame).value);
                ((toDoListGUI) frame).setCount();
            }

        }


        //activity list1 = new activity();
        //list1.addItem("Create to do list");

        // activity newActivity = new activity("Bake cookies");
        // System.out.println(newActivity.event);

        myToDo.addActivity("Test event");
        myToDo.addActivity("Test event2");

        myToDo.showList();

        myToDo.writeList();

        System.exit(0);
        // new class to add activity to list

        // System.out.println("Hello world!");

        /*
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output2.txt"));
            writer.write("Write to a file.");
            writer.write("\nNew line here");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
         */

        /*
        try {
            BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
         */


    }
}
