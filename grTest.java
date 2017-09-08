package grTest;

import javax.swing.*;
import java.awt.*;

public class grTest extends JFrame implements Runnable {
    private int x1=10, y1=100, x2=10, y2=200, x3=10, y3=300;

    private grTest() throws HeadlessException {
        super();

        this.setSize(700, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.BLUE);
        g.fillOval(this.x1, this.y1, 50, 50);

        g.setColor(Color.RED);
        g.fillOval(this.x2, this.y2, 50, 50);

        g.setColor(Color.GREEN);
        g.fillOval(this.x3, this.y3, 50, 50);
    }

    public static void main(String[] args) {
        Runnable r1 = new grTest();
        Thread t1 = new Thread(r1,"BLUE");
        Thread t2 = new Thread(r1,"RED");
        Thread t3 = new Thread(r1,"GREEN");

        t1.start();
        t2.start();
        t3.start();
    }

    @Override
    public void run() {

        for (;this.x1<500 |this.x2<500|this.x3<500; ) {

            this.x1++;
            this.x2++;
            this.x3++;

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }
}
