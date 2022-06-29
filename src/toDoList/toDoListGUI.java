package toDoList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class toDoListGUI extends JFrame {
    private JPanel mainPanel;
    private JTextField itemToAddTextField;
    private JLabel itemToAddLabel;
    private JButton itemToAddButton;
    public String value;
    public int count;
    public static boolean closed = false;

    public toDoListGUI(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        itemToAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Grab the text
                // Make sure it's a string
                // Add to to do list
                String item = itemToAddTextField.getText();
                value = item;
                count = 1;
            }
        });
    }

    public void setCount() {
        count = 0;
    }
//    public static int setClosed() {
//        closed = true;
//        return 0;
//    }

    public String getValue() {
        return value;
    }

//    public static void main(String[] args) {
//        JFrame frame = new toDoListGUI("Create a To-Do list");
//        frame.setVisible(true);
//    }
}
