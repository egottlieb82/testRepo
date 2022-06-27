package toDoList;

import java.util.ArrayList;

public class createList {

    public ArrayList<activity> list;

    public createList() {
        list = new ArrayList<activity>();
        System.out.println("A new to-do list has been created");
    }

    public void addActivity(String event) {
        list.add(new activity(event));

    }

    public void showList() {
        int size = list.size();
        int i;
        for (i = 0; i < size; i ++) {
            System.out.println(i + ". " + list.get(i).getEvent());
        }
    }

}
