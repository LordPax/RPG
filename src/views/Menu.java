package src.views;

import src.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Menu implements View {
    private JButton single;
    private JButton local;
    private RPGWindow win;

    public Menu(RPGWindow win) {
        this.win = win;
    }

    public RPGWindow getWindow() {
        return this.win;
    }

    private void initListener() {
        this.single.addActionListener(new ListenerMenu(1, this));
        this.local.addActionListener(new ListenerMenu(2, this));
    }

    public JPanel buildView() {
        JPanel pan = new JPanel();
        pan.setLayout(new BorderLayout());

        pan.add(this.buildTitle(), BorderLayout.NORTH);
        pan.add(this.buildContent(), BorderLayout.CENTER);

        this.initListener();

        return pan;
    }

    public JPanel buildTitle() {
        JPanel pan = new JPanel();
        pan.setLayout(new BorderLayout());

        pan.add(new JLabel("Test Titre"), BorderLayout.CENTER);

        return pan;
    }

    public JPanel buildContent() {
        JPanel pan = new JPanel();
        pan.setLayout(new GridLayout(2, 1));

        this.single = new JButton("Solo");
        pan.add(this.single);
        this.local = new JButton("local");
        pan.add(this.local);

        return pan;
    }
}