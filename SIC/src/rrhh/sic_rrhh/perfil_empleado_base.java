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
import javax.swing.JSeparator;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author Matheus
 */
public class perfil_empleado_base extends javax.swing.JPanel {
    Dimension d;
    
    /**
     * Creates new form inicio
     */
    public perfil_empleado_base() {
        initComponents();
        d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width-100, d.height-61-200);
        jScrollPane1.setSize(d.width-101, d.height-61-200);
        JScrollBar sb = jScrollPane1.getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        jPanel3.setSize(d.width-101, d.height-61-200);
        jSeparator4.setSize(d.width-180, 3);
        jSeparator5.setSize(d.width-180, 3);
        String ex ="";
        
        setVisible(false);
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }
    public void alt (Component bt, String text){
        jLabel25.setVisible(true);
        jLabel25.setText(text);
        jLabel25.setSize((int)jLabel25.getMinimumSize().getWidth(), 25);
        jLabel25.setLocation(bt.getX()+bt.getWidth(), bt.getY()+bt.getHeight());
    }  
    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JLabel getjLabel25() {
        return jLabel25;
    }

    public void setjLabel25(JLabel jLabel25) {
        this.jLabel25 = jLabel25;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
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

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public Dimension getD() {
        return d;
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

    public JLabel getjLabel14() {
        return jLabel14;
    }

    public void setjLabel14(JLabel jLabel14) {
        this.jLabel14 = jLabel14;
    }

    public JLabel getjLabel15() {
        return jLabel15;
    }

    public void setjLabel15(JLabel jLabel15) {
        this.jLabel15 = jLabel15;
    }

    public JLabel getjLabel16() {
        return jLabel16;
    }

    public void setjLabel16(JLabel jLabel16) {
        this.jLabel16 = jLabel16;
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

    public JLabel getjLabel19() {
        return jLabel19;
    }

    public void setjLabel19(JLabel jLabel19) {
        this.jLabel19 = jLabel19;
    }

    public JLabel getjLabel20() {
        return jLabel20;
    }

    public void setjLabel20(JLabel jLabel20) {
        this.jLabel20 = jLabel20;
    }

    public JLabel getjLabel21() {
        return jLabel21;
    }

    public void setjLabel21(JLabel jLabel21) {
        this.jLabel21 = jLabel21;
    }

    public JLabel getjLabel22() {
        return jLabel22;
    }

    public void setjLabel22(JLabel jLabel22) {
        this.jLabel22 = jLabel22;
    }

    public JLabel getjLabel23() {
        return jLabel23;
    }

    public void setjLabel23(JLabel jLabel23) {
        this.jLabel23 = jLabel23;
    }

    public JLabel getjLabel24() {
        return jLabel24;
    }

    public void setjLabel24(JLabel jLabel24) {
        this.jLabel24 = jLabel24;
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

    public JSeparator getjSeparator4() {
        return jSeparator4;
    }

    public void setjSeparator4(JSeparator jSeparator4) {
        this.jSeparator4 = jSeparator4;
    }

    public JSeparator getjSeparator5() {
        return jSeparator5;
    }

    public void setjSeparator5(JSeparator jSeparator5) {
        this.jSeparator5 = jSeparator5;
    }

    public JPanel getjPanel1() {
        return jPanel1;
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
    
    
    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
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

        jLabel25 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

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
        jLabel7.setText("INFORMACIÓN GENERAL");
        jLabel7.setOpaque(true);
        add(jLabel7);
        jLabel7.setBounds(0, 0, 250, 30);

        jScrollPane1.setBorder(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        jLabel24.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setText("EMAIL:");
        jPanel3.add(jLabel24);
        jLabel24.setBounds(50, 180, 120, 18);

        jSeparator4.setForeground(new java.awt.Color(200, 200, 200));
        jPanel3.add(jSeparator4);
        jSeparator4.setBounds(40, 240, 650, 10);

        jLabel20.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("ESTADO CIVIL:");
        jPanel3.add(jLabel20);
        jLabel20.setBounds(50, 100, 120, 18);

        jLabel23.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText("CELULAR:");
        jPanel3.add(jLabel23);
        jLabel23.setBounds(50, 160, 120, 18);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);
        jPanel3.add(jPanel2);
        jPanel2.setBounds(50, 350, 590, 20);

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Dato");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(180, 160, 280, 18);

        jLabel8.setFont(new java.awt.Font("Roboto Black", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("- DATOS PERSONALES -");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(50, 20, 200, 30);

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("LUGAR Y FECHA DE NACIMIENTO:");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(50, 60, 250, 20);

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Dato");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(180, 140, 260, 18);

        jLabel22.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("TELÉFONO:");
        jPanel3.add(jLabel22);
        jLabel22.setBounds(50, 140, 120, 18);

        jSeparator5.setForeground(new java.awt.Color(200, 200, 200));
        jPanel3.add(jSeparator5);
        jSeparator5.setBounds(40, 310, 650, 10);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);
        jPanel3.add(jPanel1);
        jPanel1.setBounds(50, 280, 590, 20);

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("EDAD:");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(50, 80, 90, 18);

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Dato");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(180, 80, 370, 20);

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Dato");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(180, 120, 220, 18);

        jLabel18.setFont(new java.awt.Font("Roboto Black", 0, 15)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("- ESTUDIOS REALIZADOS-");
        jPanel3.add(jLabel18);
        jLabel18.setBounds(50, 250, 270, 21);

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Dato");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(180, 100, 210, 18);

        jLabel17.setFont(new java.awt.Font("Roboto Black", 0, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("- EXPERIENCIA LABORAL -");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(50, 320, 280, 21);

        jLabel16.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Dato");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(180, 180, 300, 18);

        jLabel21.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("C.I:");
        jPanel3.add(jLabel21);
        jLabel21.setBounds(50, 120, 110, 18);

        jLabel19.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Dato");
        jPanel3.add(jLabel19);
        jLabel19.setBounds(270, 60, 270, 20);

        jScrollPane1.setViewportView(jPanel3);

        add(jScrollPane1);
        jScrollPane1.setBounds(0, 32, 1120, 480);

        jLabel2.setBackground(new java.awt.Color(51, 51, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/boton-redondo-antecedentes-lightblue.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });
        add(jLabel2);
        jLabel2.setBounds(370, 0, 40, 32);

        jLabel3.setBackground(new java.awt.Color(51, 51, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/boton-redondo-psicologica-lightblue.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });
        add(jLabel3);
        jLabel3.setBounds(270, 0, 40, 32);

        jLabel1.setBackground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/boton-redondo-perfilpuesto-lightblue.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
        add(jLabel1);
        jLabel1.setBounds(320, 0, 40, 32);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/boton-redondo-antecedentes-lightblue.png"))); // NOI18N
        jLabel25.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/boton-redondo-antecedentes-blue.png"))); // NOI18N
        alt(jLabel2,"Procesos Judiciales");
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/boton-redondo-psicologica-lightblue.png"))); // NOI18N
        jLabel25.setVisible(false);
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/boton-redondo-psicologica-blue.png"))); // NOI18N
        alt(jLabel3,"Prueba Psicologicas");
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/boton-redondo-perfilpuesto-lightblue.png"))); // NOI18N
        jLabel25.setVisible(false);
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/boton-redondo-perfilpuesto-blue.png"))); // NOI18N
        alt(jLabel1,"Perfil de Puesto");
    }//GEN-LAST:event_jLabel1MouseEntered

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    // End of variables declaration//GEN-END:variables
}
