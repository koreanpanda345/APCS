package Main;

import java.applet.Applet;
import java.awt.*;

public class program3 extends Applet{
        public void paint(Graphics page){
            final int MID = 150;
            final int TOP = 50;

            setBackground(Color.cyan);

            page.setColor(Color.blue);
            page.fillRect(0, 175, 300, 50);

            page.setColor(Color.yellow);
            page.fillOval(+240, -40, 80, 80);

            page.setColor(Color.white);
            page.fillOval(MID, TOP, 40, 40);
            page.fillOval(MID - 5, TOP + 35, 70, 50);
            page.fillOval(MID - 30, TOP + 80, 100, 60);

            page.setColor(Color.red);
            page.fillOval(MID, TOP+50, 5, 5);
            page.fillOval(MID, TOP+50, 5, 5);
            page.setColor(Color.black);
            page.fillOval(MID +10, TOP + 10, 5, 5);
            page.fillOval(MID + 25, TOP + 10, 5, 5);

            page.drawArc(MID +20, TOP + 20, 20, 10, -190, -160);

            page.drawLine(MID -5, TOP + 60, MID - 50, TOP + 40);
            page.drawLine(MID + 5, TOP + 60, MID + 55, TOP + 60);

            page.drawLine(MID , TOP + 5, MID + 20, TOP + 5);
            page.fillRect(MID +15, TOP - 20, 30, 25);

            page.drawString("Cody Spratford", 30, 30);
        }

}
