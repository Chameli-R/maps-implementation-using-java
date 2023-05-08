/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package waypoint;

import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.ImageIcon;

/**
 *
 * @author CHAMELI RAMESH
 */
public class buttonwaypoint extends JButton {
    public buttonwaypoint(){
        setContentAreaFilled(false);
        setIcon(new ImageIcon(getClass().getResource("/icon/pin.png")));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setSize(new Dimension(24,24));
    }
}
