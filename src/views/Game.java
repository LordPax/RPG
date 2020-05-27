package src.views;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Game implements View{
    private RPGWindow win;

    public Game(RPGWindow win) {
        this.win = win;
    }

    public RPGWindow getWindow() {
        return this.win;
    }

    public JPanel buildView() {
        JPanel pan = new JPanel();

        pan.add(new JLabel("test game"));

        return pan;
    }
}