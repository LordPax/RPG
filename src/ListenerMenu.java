package src;

import src.views.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class ListenerMenu implements ActionListener {
    private int button;
    private View view;
    private RPGWindow win;

    public ListenerMenu(int btn, View v) {
        this.button = btn;
        this.view = v;
        this.win = this.view.getWindow();
    }

    public void actionPerformed(ActionEvent e) {
        if (button == 1) {
            System.out.println("single");
            this.win.initComponent(1);
        }
        else
            System.out.println("local");
    }
}