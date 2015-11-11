/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.sic_rrhh;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author Matheus
 */
public class perfil_empleado_historia extends javax.swing.JPanel {
    Dimension d;
    
    /**
     * Creates new form inicio
     */
    public perfil_empleado_historia() {
        initComponents();
        d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width-100, d.height-61-200);
        jScrollPane1.setSize(d.width-102, d.height-61-200);
        JScrollBar sb = jScrollPane1.getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        jPanel4.setSize(d.width-102, d.height-61-200);
        String ex ="";
        setVisible(false);
    }
    public void alt (Component bt, String text){
        jLabel25.setVisible(true);
        jLabel25.setText(text);
        jLabel25.setSize((int)jLabel25.getMinimumSize().getWidth(), 25);
        jLabel25.setLocation(bt.getX()+bt.getWidth(), bt.getY()+bt.getHeight());
    } 
    public Dimension getD() {
        return d;
    }

    public void setD(Dimension d) {
        this.d = d;
    }

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
    }

    public JLabel getjLabel11() {
        return jLabel11;
    }

    public void setjLabel11(JLabel jLabel11) {
        this.jLabel11 = jLabel11;
    }

    public JLabel getjLabel12() {
        return jLabel12;
    }

    public void setjLabel12(JLabel jLabel12) {
        this.jLabel12 = jLabel12;
    }

    public JLabel getjLabel13() {
        return jLabel13;
    }

    public void setjLabel13(JLabel jLabel13) {
        this.jLabel13 = jLabel13;
    }

    public JLabel getjLabel17() {
        return jLabel17;
    }

    public void setjLabel17(JLabel jLabel17) {
        this.jLabel17 = jLabel17;
    }

    public JLabel getjLabel18() {
        return jLabel18;
    }

    public void setjLabel18(JLabel jLabel18) {
        this.jLabel18 = jLabel18;
    }

    public JLabel getjLabel30() {
        return jLabel30;
    }

    public void setjLabel30(JLabel jLabel30) {
        this.jLabel30 = jLabel30;
    }

    public JLabel getjLabel31() {
        return jLabel31;
    }

    public void setjLabel31(JLabel jLabel31) {
        this.jLabel31 = jLabel31;
    }

    public JLabel getjLabel32() {
        return jLabel32;
    }

    public void setjLabel32(JLabel jLabel32) {
        this.jLabel32 = jLabel32;
    }

    public JLabel getjLabel33() {
        return jLabel33;
    }

    public void setjLabel33(JLabel jLabel33) {
        this.jLabel33 = jLabel33;
    }

    public JLabel getjLabel34() {
        return jLabel34;
    }

    public void setjLabel34(JLabel jLabel34) {
        this.jLabel34 = jLabel34;
    }

    public JLabel getjLabel35() {
        return jLabel35;
    }

    public void setjLabel35(JLabel jLabel35) {
        this.jLabel35 = jLabel35;
    }

    public JLabel getjLabel36() {
        return jLabel36;
    }
    
    public class MyScrollbarUI extends BasicScrollBarUI {

       private Image imageThumb, imageTrack;
        private JButton b = new JButton() {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(0, 0);
            }

        };

        MyScrollbarUI() {
            imageThumb = FauxImage.create(32, 32, new Color(0,74,151));
            imageTrack = FauxImage.create(32, 32, Color.lightGray);
        }

        @Override
        protected void paintThumb(Graphics g, JComponent c, java.awt.Rectangle r) {
            g.setColor(Color.blue);
            ((Graphics2D) g).drawImage(imageThumb,
                r.x, r.y, r.width, r.height, null);
        }

        @Override
        protected void paintTrack(Graphics g, JComponent c, java.awt.Rectangle r) {
            ((Graphics2D) g).drawImage(imageTrack,
                r.x, r.y, r.width, r.height, null);
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return b;
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return b;
        }
    }
    
    private static class FauxImage {

        static public Image create(int w, int h, Color c) {
            BufferedImage bi = new BufferedImage(
                w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = bi.createGraphics();
            g2d.setPaint(c);
            g2d.fillRect(0, 0, w, h);
            g2d.dispose();
            return bi;
        }
    }
    
    public void setjLabel36(JLabel jLabel36) {
        this.jLabel36 = jLabel36;
    }

    public JLabel getjLabel37() {
        return jLabel37;
    }

    public void setjLabel37(JLabel jLabel37) {
        this.jLabel37 = jLabel37;
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

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    public JPanel getjPanel4() {
        return jPanel4;
    }

    public void setjPanel4(JPanel jPanel4) {
        this.jPanel4 = jPanel4;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel25 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setEnabled(false);
        setLayout(null);

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel25.setText("jLabel25");
        add(jLabel25);
        jLabel25.setBounds(0, 0, 70, 25);
        jLabel25.setVisible(false);

        jLabel7.setBackground(new java.awt.Color(230, 230, 230));
        jLabel7.setFont(new java.awt.Font("Roboto", 3, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 74, 151));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("HISTORIAL LABORAL");
        jLabel7.setOpaque(true);
        add(jLabel7);
        jLabel7.setBounds(0, 0, 250, 30);

        jScrollPane1.setBorder(null);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        jLabel31.setBackground(new java.awt.Color(230, 230, 230));
        jLabel31.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 173, 218));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("OBSERVACIÓN");
        jLabel31.setOpaque(true);
        jPanel4.add(jLabel31);
        jLabel31.setBounds(270, 150, 310, 30);

        jLabel35.setBackground(new java.awt.Color(230, 230, 230));
        jLabel35.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 173, 218));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("RESPONSABLE");
        jLabel35.setOpaque(true);
        jPanel4.add(jLabel35);
        jLabel35.setBounds(740, 240, 240, 30);

        jLabel33.setBackground(new java.awt.Color(230, 230, 230));
        jLabel33.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 173, 218));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("RESPONSABLE");
        jLabel33.setOpaque(true);
        jPanel4.add(jLabel33);
        jLabel33.setBounds(740, 150, 240, 30);

        jLabel17.setFont(new java.awt.Font("Roboto Black", 0, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("MULTAS:");
        jPanel4.add(jLabel17);
        jLabel17.setBounds(50, 200, 190, 21);

        jLabel8.setFont(new java.awt.Font("Roboto Black", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("BONOS:");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(50, 20, 200, 30);

        jLabel13.setBackground(new java.awt.Color(230, 230, 230));
        jLabel13.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 173, 218));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("RESPONSABLE");
        jLabel13.setOpaque(true);
        jPanel4.add(jLabel13);
        jLabel13.setBounds(740, 60, 240, 30);

        jLabel34.setBackground(new java.awt.Color(230, 230, 230));
        jLabel34.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 173, 218));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("TIPO");
        jLabel34.setOpaque(true);
        jPanel4.add(jLabel34);
        jLabel34.setBounds(50, 240, 220, 30);

        jLabel12.setBackground(new java.awt.Color(230, 230, 230));
        jLabel12.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 173, 218));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("FECHA");
        jLabel12.setOpaque(true);
        jPanel4.add(jLabel12);
        jLabel12.setBounds(580, 60, 160, 30);

        jLabel11.setBackground(new java.awt.Color(230, 230, 230));
        jLabel11.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 173, 218));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("OBSERVACIÓN");
        jLabel11.setOpaque(true);
        jPanel4.add(jLabel11);
        jLabel11.setBounds(270, 60, 310, 30);

        jLabel10.setBackground(new java.awt.Color(230, 230, 230));
        jLabel10.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 173, 218));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("TIPO");
        jLabel10.setOpaque(true);
        jPanel4.add(jLabel10);
        jLabel10.setBounds(50, 60, 220, 30);

        jLabel37.setBackground(new java.awt.Color(230, 230, 230));
        jLabel37.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 173, 218));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("FECHA");
        jLabel37.setOpaque(true);
        jPanel4.add(jLabel37);
        jLabel37.setBounds(580, 240, 160, 30);

        jLabel36.setBackground(new java.awt.Color(230, 230, 230));
        jLabel36.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 173, 218));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("OBSERVACIÓN");
        jLabel36.setOpaque(true);
        jPanel4.add(jLabel36);
        jLabel36.setBounds(270, 240, 310, 30);

        jLabel30.setBackground(new java.awt.Color(230, 230, 230));
        jLabel30.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 173, 218));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("CANTIDAD");
        jLabel30.setOpaque(true);
        jPanel4.add(jLabel30);
        jLabel30.setBounds(50, 150, 220, 30);

        jLabel32.setBackground(new java.awt.Color(230, 230, 230));
        jLabel32.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 173, 218));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("FECHA ENTREGA");
        jLabel32.setOpaque(true);
        jPanel4.add(jLabel32);
        jLabel32.setBounds(580, 150, 160, 30);

        jLabel18.setFont(new java.awt.Font("Roboto Black", 0, 15)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("PRÉSTAMOS:");
        jPanel4.add(jLabel18);
        jLabel18.setBounds(50, 110, 190, 21);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        jPanel1.setLayout(null);
        jPanel4.add(jPanel1);
        jPanel1.setBounds(50, 90, 930, 0);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        jPanel2.setLayout(null);
        jPanel4.add(jPanel2);
        jPanel2.setBounds(50, 180, 930, 0);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        jPanel3.setLayout(null);
        jPanel4.add(jPanel3);
        jPanel3.setBounds(50, 270, 930, 0);

        jScrollPane1.setViewportView(jPanel4);

        add(jScrollPane1);
        jScrollPane1.setBounds(0, 30, 1110, 570);

        jLabel2.setBackground(new java.awt.Color(51, 51, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/boton-redondo-ausentismo-lightblue.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });
        add(jLabel2);
        jLabel2.setBounds(270, 0, 40, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/boton-redondo-ausentismo-blue.png"))); // NOI18N
        alt(jLabel2,"Ausentismo");
    }//GEN-LAST:event_jLabel2MouseEntered

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel25() {
        return jLabel25;
    }

    public void setjLabel25(JLabel jLabel25) {
        this.jLabel25 = jLabel25;
    }

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/boton-redondo-ausentismo-lightblue.png"))); // NOI18N
        jLabel25.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
