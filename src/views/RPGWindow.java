package src.views;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class RPGWindow extends JFrame {
    private ArrayList<View> view;
    private JPanel v;

    public RPGWindow(String title) {
        super(title);
        this.view = new ArrayList<View>();

        this.addView(new Menu(this));
        this.addView(new Game(this));

        this.initComponent(0);
        this.centrer(0.6);
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

    public void initComponent(int i) {
        JPanel pan = new JPanel();
        this.v = getView(i).buildView();

        this.add(pan);
 
        pan.add(this.v);
    }

    public void changeView(int i) {
        JPanel pan = new JPanel();
        this.v = getView(i).buildView();

        this.removeAll(); 
        this.add(pan);
        this.v.repaint();
        
        pan.add(this.v);

    }

    public void addView(View v) {
        this.view.add(v);
    }

    public View getView(int i) {
        return this.view.get(i);
    }

    
}