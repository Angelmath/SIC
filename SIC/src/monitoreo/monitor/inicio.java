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
public class inicio extends javax.swing.JPanel {
    Dimension d;
    
    /**
     * Creates new form inicio
     */
    public inicio() {
        initComponents();
        d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width-100, d.height-61);
        jLabel14.setSize(d.width-100, d.height-61);
        getjPanel1().setLocation(((d.width-100)/2)-(getjPanel1().getWidth()/2), getjPanel1().getY());
        jLabel14.setIcon(new ImageIcon(((ImageIcon) jLabel14.getIcon()).getImage().getScaledInstance(jLabel14.getWidth(), jLabel14.getHeight(), Image.SCALE_DEFAULT)));
        setVisible(true);
    }

    public Dimension getD() {
        return d;
    }

    public void setD(Dimension d) {
        this.d = d;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setEnabled(false);
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/cajamarca1-icon-black.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(221, 11, 280, 80);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/icono-monitoreo.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });
        jPanel1.add(jLabel2);
        jLabel2.setBounds(48, 139, 143, 122);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/icono-master.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });
        jPanel1.add(jLabel3);
        jLabel3.setBounds(287, 139, 180, 119);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/icono-config.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        jPanel1.add(jLabel4);
        jLabel4.setBounds(537, 139, 180, 117);

        jLabel8.setFont(new java.awt.Font("Roboto", 3, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 74, 152));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("MASTER");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(297, 274, 170, 30);

        jLabel6.setFont(new java.awt.Font("Roboto", 3, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 74, 152));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("CONFIGURACION");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(537, 270, 180, 30);

        jLabel7.setFont(new java.awt.Font("Roboto", 3, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 74, 152));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("MONITOREO");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(48, 274, 140, 30);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/linea-separadora-4.png"))); // NOI18N
        jPanel1.add(jLabel10);
        jLabel10.setBounds(266, 148, 15, 100);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/linea-separadora-4.png"))); // NOI18N
        jPanel1.add(jLabel9);
        jLabel9.setBounds(477, 147, 15, 100);

        add(jPanel1);
        jPanel1.setBounds(40, 130, 740, 360);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/fondo SIC 2.jpg"))); // NOI18N
        add(jLabel14);
        jLabel14.setBounds(0, 0, 880, 620);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        //jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/usersgrande-icon-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        //jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/usersgrande-icon-lightblue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
//        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/dptosgrande-icon-lightblue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
//        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/dptosgrande-icon-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
//        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/accountsgrande-icon-lightblue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
//        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/accountsgrande-icon-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel4MouseEntered

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
