package toDoList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class inputNameGUI extends JFrame {
    private JTextField listName;
    private JPanel newNamePanel;
    private JLabel askName;
    private JButton confirm;

    public inputNameGUI() {
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setContentPane(newNamePanel);
        this.pack();

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Grab the text
                // Make sure it's a string
                // Create to do list
                // Close and proceed to next GUI
                String item = listName.getText();
            }
        });
    }
}
