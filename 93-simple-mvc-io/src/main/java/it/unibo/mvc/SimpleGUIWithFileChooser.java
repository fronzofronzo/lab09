package it.unibo.mvc;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame("Simple GUI interface");
    private static final int PROPORTION = 3;
    private final Controller c = new Controller(); 

    public SimpleGUIWithFileChooser() {
        final JPanel mainP = new JPanel();
        mainP.setLayout(new BorderLayout());
        final JTextArea text = new JTextArea();
        mainP.add(text, BorderLayout.CENTER);
        final JButton save = new JButton("Save");
        mainP.add(save, BorderLayout.PAGE_END);
        frame.setContentPane(mainP);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel chooser = new JPanel(new BorderLayout());
        chooser.setBorder(new LineBorder(Color.BLACK));
        mainP.add(chooser, BorderLayout.NORTH);
        final JTextArea pathArea = new JTextArea(c.getPath());
        pathArea.setEditable(false);
        chooser.add(pathArea,BorderLayout.CENTER);
        final JButton browse = new JButton("Browse...");
        chooser.add(browse, BorderLayout.LINE_END);


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

        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               final JFileChooser ch = new JFileChooser("Save location");
               final int res = ch.showSaveDialog(browse);
               if(res == JFileChooser.APPROVE_OPTION) {
                c.setFile(ch.getSelectedFile());
                pathArea.setText(c.getPath());
               }
               if(res == JFileChooser.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(browse, "Error has occured, no file selected");
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
        new SimpleGUIWithFileChooser().display();
    }
}
