package src.views;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Menu implements View {
    private JButton single;
    private JButton local;

    public Menu() {}

    public JPanel buildView() {
        JPanel pan = new JPanel();
        pan.setLayout(new BorderLayout());

        pan.add(this.buildTitle(), BorderLayout.NORTH);
        pan.add(this.buildContent(), BorderLayout.CENTER);

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