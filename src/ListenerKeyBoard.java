package src;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class ListenerKeyBoard implements KeyListener {

    public ListenerKeyBoard() {}

    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("j'ai appuyer sur A");
        }
    }

    public void keyReleased(KeyEvent e) {} 
}