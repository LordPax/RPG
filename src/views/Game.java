package src.views;

import src.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Game extends JPanel implements View{
    private RPGWindow win;
    private Map map;

    public Game(RPGWindow win, Map map) {
        super();
        this.win = win;
        this.map = map;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawLine(100, 100, 50, 50);
        g.drawLine(50, 50, 30, 60);
    }

    public RPGWindow getWindow() {
        return this.win;
    }

    public JPanel buildView() {
        return this;
    }

    public void updateView() {
        this.repaint();
    }
}