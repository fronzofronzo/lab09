package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame("Simple GUI interface");
    private static final int PROPORTION = 3;
    private final Controller c = new Controller(); 

    public SimpleGUI() {
        final JPanel mainP = new JPanel();
        mainP.setLayout(new BorderLayout());
        final JTextArea text = new JTextArea();
        mainP.add(text, BorderLayout.CENTER);
        final JButton save = new JButton("Save");
        mainP.add(save, BorderLayout.PAGE_END);
        frame.setContentPane(mainP);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String s = text.getText();
                try {
                    c.printStringOnFile(s);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(save, e1.getMessage());
                }
            }
            
        });

    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int w = (int)screen.getWidth();
        final int h = (int)screen.getHeight();
        frame.setSize(w/PROPORTION, h/PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String...args ) {
        new SimpleGUI().display();
    }
}
