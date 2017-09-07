package grTest;

import javax.swing.*;
import java.awt.*;

public class grTest extends JFrame implements Runnable {
    private int x = 10, y = 100;

    private grTest() throws HeadlessException {
        this.setSize(700, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLUE);
        g.fillOval(this.x, this.y, 50, 50);
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new grTest());

        t1.start();
    }

    @Override
    public void run() {
        for (; this.x < 500; this.x++) {
            this.x++;

            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }
}
