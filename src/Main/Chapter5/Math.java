package Main.Chapter5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Math extends JApplet
{
    private int APPLET_WIDTH = 300, APPLET_HEIGHT = 300;
    private int num;
    private JLabel label;
    private JButton add, substract;

    /*********************
     * Setting up the GUI*
     *********************/
    public void init()
    {
        num = 50;

        add = new JButton("Add");
        add.addActionListener(new ButtonListenerAdd());

        substract = new JButton("Subtract");
        substract.addActionListener(new ButtonListenerSubtract());

        label = new JLabel("Number: " + Integer.toString(num));

        Container cp = getContentPane();
        cp.setBackground(Color.decode("#ff0cf6"));
        cp.setLayout(new FlowLayout());
        cp.add(add);
        cp.add(substract);

        setSize(APPLET_WIDTH, APPLET_HEIGHT);
    }

    /*********************************************************************
     * Represents a listener for button add and substract(action) events.*
     *********************************************************************/
    private class ButtonListenerAdd implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            ++num;
            label.setText("Number: " + Integer.toString(num));
            repaint();
        }
    }
    private  class ButtonListenerSubtract implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            --num;
            label.setText("Number: " + Integer.toString(num));
            repaint();
        }
    }
}
