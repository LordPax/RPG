package src.views;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Window extends JFrame {
    private ArrayList<View> view;

    public Window(String title) {
        super(title);
        this.view = new ArrayList<View>();

        this.addView(new Menu());
        this.addView(new Game());

        this.initComponent();
        this.centrer(0.5);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void centrer(double d) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();

        int largeur = (int) (d * dim.width);
        int longueur = (int) (d * dim.height);
        
        this.setBounds((dim.width - largeur) / 2, (dim.height - longueur) / 2, largeur, longueur);
    }

    private void initComponent() {
        JPanel pan = new JPanel();
        JPanel v = getView(0).buildView();
 
        this.add(pan);
 
        pan.add(v);
    }

    public void addView(View v) {
        this.view.add(v);
    }

    public View getView(int i) {
        return this.view.get(i);
    }

    
}