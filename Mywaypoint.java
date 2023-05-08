package waypoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;

public class Mywaypoint extends DefaultWaypoint {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public Mywaypoint(String name,EventWaypoint event, GeoPosition coord) {
        super(coord);
        this.name = name;
        initButton(event);
    }

    public Mywaypoint() {
    }

    private String name;
    private JButton button;

    private void initButton(EventWaypoint event) {
        button = new buttonwaypoint();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.selected(Mywaypoint.this);            }
        });
    }
}