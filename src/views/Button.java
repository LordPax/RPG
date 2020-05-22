package src.views;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Button extends JButton {
 
    private static final long serialVersionUID = 1L;
 
    public Button(String txt) {
        super(txt);
        setForeground(Color.WHITE);
        setBackground(new Color(0x2e, 0x9a, 0xfe));
         
        setOpaque(true);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
         
        setHorizontalAlignment(SwingConstants.CENTER);
        setHorizontalTextPosition(SwingConstants.CENTER);
         
        // setIcon(new ImageIcon(icon));
        // setRolloverIcon(new ImageIcon(iconHover));
    }
}