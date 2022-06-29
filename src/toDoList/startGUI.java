package toDoList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class startGUI extends JFrame {
    private JPanel startPanel;
    private JButton createNew;
    private JButton editOld;

    public startGUI() {
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setContentPane(startPanel);
        this.pack();

        createNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add new box to insert name of new To-Do List
                toDoListApp.frameStart.dispose();
                JFrame frame = new inputNameGUI();
                frame.setVisible(true);
            }
        });


        editOld.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open box with list of existing To-Do lists. Once you click on a list, there will be tbd features.
            }
        });
    }
}
