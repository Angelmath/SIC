/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.sic_rrhh;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Matheus
 */
public class editar_empleado6 extends javax.swing.JPanel {
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
    public editar_empleado6(String direccion) {
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

    public JComboBox getjComboBox6() {
        return jComboBox6;
    }

    public void setjComboBox6(JComboBox jComboBox6) {
        this.jComboBox6 = jComboBox6;
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

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
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

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
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

    public JTextField getjTextField3() {
        return jTextField3;
    }

    public void setjTextField3(JTextField jTextField3) {
        this.jTextField3 = jTextField3;
    }

    public JTextField getjTextField4() {
        return jTextField4;
    }

    public void setjTextField4(JTextField jTextField4) {
        this.jTextField4 = jTextField4;
    }

    public JTextField getjTextField7() {
        return jTextField7;
    }

    public void setjTextField7(JTextField jTextField7) {
        this.jTextField7 = jTextField7;
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
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jComboBox6 = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jComboBox5 = new javax.swing.JComboBox();
        jTextField7 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setEnabled(false);
        setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ASPIRACION SALARIAL", "DISCAPACIDAD", "CONADIS", "TIPO", "PORCENTAJE", "TIPO CONOCIMIENTO", "NIVEL CONOCIMIENTO", "ESTADO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(40, 30, 1040, 250);
        add(jSeparator1);
        jSeparator1.setBounds(40, 292, 1040, 10);

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel5.setText("Aspiracion Salarial:");
        add(jLabel5);
        jLabel5.setBounds(40, 320, 190, 22);

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel6.setText("Tiene alguna Discapacidad?");
        add(jLabel6);
        jLabel6.setBounds(40, 360, 190, 22);

        jTextField3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });
        add(jTextField3);
        jTextField3.setBounds(270, 320, 230, 24);

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel11.setText("Agregar Conocimiento:");
        add(jLabel11);
        jLabel11.setBounds(620, 400, 190, 22);
        jLabel11.setVisible(false);

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel12.setText("Nivel Conocimiento:");
        add(jLabel12);
        jLabel12.setBounds(620, 320, 190, 22);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AGROINDUSTRIAS", "CARPINTERIA", "COMERCIO", "CONTABILIDAD", "DESARROLLO DE SOFTWARE", "DISEÑO GRAFICO", "DISEÑO INTERIORES", "ELECTRICIDAD", "OFICCE", "GESTION DE TALENTO HUMANO", "LIDERAZGO", "MANTENIMIENTO DE COMPUTADORES", "MARKETING", "PLOMERIA", "VENTAS", "OTROS" }));
        jComboBox3.setPreferredSize(new java.awt.Dimension(93, 24));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        add(jComboBox3);
        jComboBox3.setBounds(850, 360, 230, 24);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO", "SI" }));
        jComboBox4.setPreferredSize(new java.awt.Dimension(93, 24));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        add(jComboBox4);
        jComboBox4.setBounds(270, 360, 230, 24);

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AVANZADO", "INTERMEDIO" }));
        jComboBox6.setPreferredSize(new java.awt.Dimension(93, 24));
        add(jComboBox6);
        jComboBox6.setBounds(850, 320, 230, 24);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel7.setText("No. Carnet (CONADIS):");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 10, 190, 22);

        jTextField4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField4);
        jTextField4.setBounds(240, 10, 230, 24);

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AUDITIVA", "FISICA", "INTELECTUAL", "LENGUAJE", "LENGUAJE/AUDITIVA", "MENTAL", "MENTAL FISICA", "PROFUNDA", "PSICOLOGICA", "SINDROME DE DOWN", "VISUAL" }));
        jComboBox5.setPreferredSize(new java.awt.Dimension(93, 24));
        jPanel1.add(jComboBox5);
        jComboBox5.setBounds(240, 50, 230, 24);

        jTextField7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField7);
        jTextField7.setBounds(240, 90, 230, 24);

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel10.setText("Porcentaje (%):");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(10, 90, 190, 22);

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel9.setText("Tipo Discapacidad:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 50, 190, 22);

        add(jPanel1);
        jPanel1.setBounds(30, 390, 510, 150);
        jPanel1.setVisible(false);

        jLabel13.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel13.setText("Tipo Conocimiento:");
        add(jLabel13);
        jLabel13.setBounds(620, 360, 190, 22);

        jTextField5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });
        add(jTextField5);
        jTextField5.setBounds(850, 400, 230, 24);
        jTextField5.setVisible(false);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7KeyTyped

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        if(jComboBox4.getSelectedItem().toString().equalsIgnoreCase("SI")){
            jPanel1.setVisible(true);
        }else{
            jPanel1.setVisible(false);
        }
    }//GEN-LAST:event_jComboBox4ActionPerformed

    public JLabel getjLabel13() {
        return jLabel13;
    }

    public void setjLabel13(JLabel jLabel13) {
        this.jLabel13 = jLabel13;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JTextField getjTextField5() {
        return jTextField5;
    }

    public void setjTextField5(JTextField jTextField5) {
        this.jTextField5 = jTextField5;
    }

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        if(jComboBox3.getSelectedItem().toString().equalsIgnoreCase("OTROS")){
            jLabel11.setVisible(true);
            jTextField5.setVisible(true);
        }else{
            jLabel11.setVisible(false);
            jTextField5.setVisible(false);
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed
        
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
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
