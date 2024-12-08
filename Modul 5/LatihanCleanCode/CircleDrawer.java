package LatihanCleanCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class CircleDrawer extends JPanel implements MouseMotionListener {
    private int mouseX = 0;
    private int mouseY = 0;
    private static final int NUM_CIRCLES = 6;

    public CircleDrawer() {
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCircles(g);
    }

    private void drawCircles(Graphics g) {
        for (int i = NUM_CIRCLES; i > 1; i--) {
            int radius = i * 7;
            if (mouseX > 100 && mouseX < 300) {
                g.setColor(Color.WHITE); // Warna putih jika mouse dalam rentang
            } else {
                g.setColor(new Color(80, 204, 55)); // Warna hijau jika mouse di luar rentang
            }
            g.fillOval(mouseX - radius / 2, mouseY - radius / 2, radius, radius);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Tidak digunakan tetapi harus diimplementasikan
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle Drawer");
        CircleDrawer circleDrawer = new CircleDrawer();
        frame.add(circleDrawer);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

