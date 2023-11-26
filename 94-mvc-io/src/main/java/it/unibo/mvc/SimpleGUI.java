package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final static int PROPORTION = 3;
    private final JFrame frame = new JFrame();
    private final Controller ctr = new SimpleController();

    public SimpleGUI() {
        final JPanel canvas = new JPanel(new BorderLayout());
        final JPanel buttons = new JPanel();
        final JButton print = new JButton("Print");
        final JButton showHistory = new JButton("Show History");
        final JTextField write = new JTextField("Write something... (delete me)");
        final JTextArea show = new JTextArea();

        buttons.add(print);
        buttons.add(showHistory);

        canvas.add(write, BorderLayout.NORTH);
        canvas.add(show, BorderLayout.CENTER);
        canvas.add(buttons, BorderLayout.SOUTH);

        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                final String s = write.getText();
                ctr.setNextString(s);
                ctr.printCurrentString();
            }
            
        });

        showHistory.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                final List<String> history = ctr.getHistory();
                show.setText("");
                for(String s : history) {
                    show.append(s + "\n");
                }
            }

        });

        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int h = (int) screen.getHeight();
        final int w = (int)screen.getWidth();
        frame.setSize(w/PROPORTION, h/PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main (String... args){
        new SimpleGUI().display();
    }
}
