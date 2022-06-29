package toDoList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class createList {

    public ArrayList<activity> list;
    public String name;

    public createList(String name) {
        this.name = name;
        list = new ArrayList<activity>();
        System.out.println(this.name + " has been created.");
    }

    public void addActivity(String event) {
        System.out.println(event + " is being added to To-Do list: " + name);
        list.add(new activity(event));
        System.out.println(event + " has been added to To-Do list: " + name);

    }

    public void showList() {
        int size = list.size();
        int i;
        for (i = 1; i < size + 1; i ++) {
            System.out.println(i + ". " + list.get(i-1).getEvent());
        }
    }

    public void writeList() {
        int size = list.size();
        int i;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(name + ".txt"));
            writer.write(name + ":");
            for (i = 1; i < size + 1; i ++) {
                writer.write("\n");
                writer.write("\n" + i + ". " + list.get(i-1).getEvent());
                writer.write("\n        Task description: " + list.get(i-1).getDescription());
                writer.write("\n        Task due date: " + list.get(i-1).getDueDate());
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
