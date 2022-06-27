package toDoList;

public class toDoListApp {

    public static void main(String[] args) {

        //activity list1 = new activity();
        //list1.addItem("Create to do list");

        createList myToDo = new createList();

        // activity newActivity = new activity("Bake cookies");
        // System.out.println(newActivity.event);

        myToDo.addActivity("Test event");
        myToDo.addActivity("Test event2");

        myToDo.showList();

        // new class to add activity to list

        // System.out.println("Hello world!");

    }
}
