/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.sic_rrhh;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;

/**
 *
 * @author Matheus
 */
public class editar_empleado3 extends javax.swing.JPanel {
    Dimension d;
    String direccion;
    String fotot;
    String entrefoto;
    String directoriofoto;
    String directoriocv;
    float sueldot;
    float sueldo;
    float iess;
    float suple;
    int wid= 480;
    int xi=0;
    /**
     * Creates new form inicio
     */
    public editar_empleado3(String direccion) {
        initComponents();
        this.direccion=direccion;
        this.fotot= direccion+"foto_empleados\\temporal.jpeg";
        this.directoriofoto="foto_empleados\\";
        this.directoriocv="pdf_cajamarca\\";
        d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width-100, d.height-61);
        setVisible(false);
    }
    public Dimension getD() {
        return d;
    }

    public String getDirectoriofoto() {
        return directoriofoto;
    }

    public void setDirectoriofoto(String directoriofoto) {
        this.directoriofoto = directoriofoto;
    }

    public String getDirectoriocv() {
        return directoriocv;
    }

    public void setDirectoriocv(String directoriocv) {
        this.directoriocv = directoriocv;
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public int getXi() {
        return xi;
    }

    public void setXi(int xi) {
        this.xi = xi;
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jComboBox5 = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setEnabled(false);
        setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "IDIOMA", "NIVEL ORAL", "NIVEL ESCRITO", "ESTADO"
            }
        ));
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(40, 30, 1040, 250);

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel6.setText("Idioma:");
        add(jLabel6);
        jLabel6.setBounds(40, 320, 190, 22);

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel7.setText("Nivel Oral:");
        add(jLabel7);
        jLabel7.setBounds(40, 360, 190, 22);

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel8.setText("Nivel Escrito:");
        add(jLabel8);
        jLabel8.setBounds(40, 400, 190, 22);
        add(jSeparator1);
        jSeparator1.setBounds(40, 292, 1040, 10);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ingles", "Español", "Frances", "Quechua", "Mandarin", "Otros" }));
        jComboBox3.setPreferredSize(new java.awt.Dimension(93, 24));
        add(jComboBox3);
        jComboBox3.setBounds(270, 320, 230, 24);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Basico", "Intermedio", "Avanzado" }));
        jComboBox4.setPreferredSize(new java.awt.Dimension(93, 24));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        add(jComboBox4);
        jComboBox4.setBounds(270, 400, 230, 24);

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Basico", "Intermedio", "Avanzado" }));
        jComboBox5.setPreferredSize(new java.awt.Dimension(93, 24));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });
        add(jComboBox5);
        jComboBox5.setBounds(270, 360, 230, 24);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    public JComboBox getjComboBox3() {
        return jComboBox3;
    }

    public void setjComboBox3(JComboBox jComboBox3) {
        this.jComboBox3 = jComboBox3;
    }

    public JComboBox getjComboBox4() {
        return jComboBox4;
    }

    public void setjComboBox4(JComboBox jComboBox4) {
        this.jComboBox4 = jComboBox4;
    }

    public JComboBox getjComboBox5() {
        return jComboBox5;
    }

    public void setjComboBox5(JComboBox jComboBox5) {
        this.jComboBox5 = jComboBox5;
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

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JSeparator getjSeparator1() {
        return jSeparator1;
    }

    public void setjSeparator1(JSeparator jSeparator1) {
        this.jSeparator1 = jSeparator1;
    }

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ActionPerformed
        
    public String getEntrefoto() {
        return entrefoto;
    }
    
    public void setEntrefoto(String entrefoto) {
        this.entrefoto = entrefoto;
    }
    
    public float getSueldot() {
        return sueldot;
    }
    
    public void setSueldot(float sueldot) {
        this.sueldot = sueldot;
    }
    
    public float getSueldo() {
        return sueldo;
    }
    
    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }
    
    public float getIess() {
        return iess;
    }
    
    public void setIess(float iess) {
        this.iess = iess;
    }
    
    public float getSuple() {
        return suple;
    }
    
    public void setSuple(float suple) {
        this.suple = suple;
    }
                       
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getFotot() {
        return fotot;
    }
    
    public void setFotot(String fotot) {
        this.fotot = fotot;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
