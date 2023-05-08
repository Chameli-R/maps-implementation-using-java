/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author CHAMELI RAMESH
 */
import com.sun.tools.javac.Main;
import java.util.HashSet;
import java.util.Set;
import javax.swing.event.MouseInputListener;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.VirtualEarthTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import waypoint.Mywaypoint;
import waypoint.WaypointRender;
import org.jxmapviewer.viewer.WaypointPainter;
import waypoint.EventWaypoint;
import javax.swing.JOptionPane;

public class main extends javax.swing.JFrame {

    /** Creates new form main */
    private final Set<Mywaypoint>waypoints = new HashSet<>();
    private EventWaypoint event;
    public main() {
        initComponents();
        init();
    }
    private void init(){
    TileFactoryInfo info = new OSMTileFactoryInfo();
    DefaultTileFactory tilefactory = new DefaultTileFactory(info);
            jXMapViewer.setTileFactory(tilefactory);
        GeoPosition geo = new GeoPosition(11.0345038,76.9880711);
        jXMapViewer.setAddressLocation(geo);
        jXMapViewer.setZoom(12);
        
        //  Create event mouse move
        MouseInputListener mm = new PanMouseInputListener(jXMapViewer);
        jXMapViewer.addMouseListener(mm);
        jXMapViewer.addMouseMotionListener(mm);
        jXMapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCenter(jXMapViewer));
        event=getEvent();
    }
    
    private void addWaypoint(Mywaypoint waypoint) {
        for (Mywaypoint d : waypoints) {
            jXMapViewer.remove(d.getButton());
        }
        waypoints.add(waypoint);
        initWaypoint();
    }
    
    private void initWaypoint(){
        WaypointPainter<Mywaypoint> wp = new WaypointRender();
        wp.setWaypoints(waypoints);
        jXMapViewer.setOverlayPainter(wp);
        for (Mywaypoint d : waypoints) {
            jXMapViewer.add(d.getButton());
        }
    }
    
    private void clearWaypoint() {
        for (Mywaypoint d : waypoints) {
            jXMapViewer.remove(d.getButton());
        }
        waypoints.clear();
        initWaypoint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXMapViewer = new org.jxmapviewer.JXMapViewer();
        combomaptype = new javax.swing.JComboBox<>();
        addwaypoint = new javax.swing.JButton();
        clearwaypoint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        combomaptype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "open street ", "virtual earth ", "hybrid ", "satellite", " " }));
        combomaptype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combomaptypeActionPerformed(evt);
            }
        });

        addwaypoint.setText("jButton1");
        addwaypoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addwaypointActionPerformed(evt);
            }
        });

        clearwaypoint.setText("jButton1");
        clearwaypoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearwaypointActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXMapViewerLayout = new javax.swing.GroupLayout(jXMapViewer);
        jXMapViewer.setLayout(jXMapViewerLayout);
        jXMapViewerLayout.setHorizontalGroup(
            jXMapViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXMapViewerLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(addwaypoint)
                .addGap(18, 18, 18)
                .addComponent(clearwaypoint)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 434, Short.MAX_VALUE)
                .addComponent(combomaptype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jXMapViewerLayout.setVerticalGroup(
            jXMapViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXMapViewerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXMapViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combomaptype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addwaypoint)
                    .addComponent(clearwaypoint))
                .addContainerGap(454, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jXMapViewer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jXMapViewer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void combomaptypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combomaptypeActionPerformed
        TileFactoryInfo info = new OSMTileFactoryInfo();
        int index = combomaptype.getSelectedIndex();
        if (index==0){
            info = new OSMTileFactoryInfo();
        }
        else if(index==1){
            info = new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.MAP);
        }
        else if(index==2){
            info = new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.HYBRID);
        }
        else if(index==3){
            info = new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.SATELLITE);
            
        }
        DefaultTileFactory tilefactory = new DefaultTileFactory(info);
            jXMapViewer.setTileFactory(tilefactory);
    }//GEN-LAST:event_combomaptypeActionPerformed

    private void addwaypointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addwaypointActionPerformed
        // TODO add your handling code here:
        addWaypoint(new Mywaypoint("test 001",event ,new GeoPosition(11.0241339,76.9893863)));
        addWaypoint(new Mywaypoint("test 002",event, new GeoPosition(11.0119273,76.9465563)));
    }//GEN-LAST:event_addwaypointActionPerformed

    private void clearwaypointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearwaypointActionPerformed
        // TODO add your handling code here:
        clearWaypoint();
    }//GEN-LAST:event_clearwaypointActionPerformed

    private EventWaypoint getEvent(){
        return new EventWaypoint(){
            public void selected(Mywaypoint waypoint) {
                
            }
        };
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addwaypoint;
    private javax.swing.JButton clearwaypoint;
    private javax.swing.JComboBox<String> combomaptype;
    private org.jxmapviewer.JXMapViewer jXMapViewer;
    // End of variables declaration//GEN-END:variables

}
