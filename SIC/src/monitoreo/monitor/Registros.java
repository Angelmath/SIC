/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monitoreo.monitor;

import rrhh.sic_rrhh.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Matheus
 */
public class Registros extends javax.swing.JPanel {
    Dimension d;
    
    /**
     * Creates new form inicio
     */
    public Registros() {
        initComponents();
        d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width-100, d.height-61);
        jLabel14.setSize(d.width-100, d.height-61);
        jLabel14.setIcon(new ImageIcon(((ImageIcon) jLabel14.getIcon()).getImage().getScaledInstance(jLabel14.getWidth(), jLabel14.getHeight(), Image.SCALE_DEFAULT)));
        setVisible(false);
    }

    public Dimension getD() {
        return d;
    }

    public void setD(Dimension d) {
        this.d = d;
    }

   


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setEnabled(false);
        setLayout(null);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "CI", "Fecha", "Inicio", "Culminacion", "Tiempo Total"
            }
        ));
        jTable1.setRowHeight(26);
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(40, 20, 1090, 540);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/fondo SIC 2.jpg"))); // NOI18N
        add(jLabel14);
        jLabel14.setBounds(0, 0, 1200, 650);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel14;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
