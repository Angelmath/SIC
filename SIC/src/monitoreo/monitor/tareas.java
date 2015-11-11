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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.OptionPaneUI;

/**
 *
 * @author Matheus
 */
public class tareas extends javax.swing.JPanel {
    Dimension d;
    
    /**
     * Creates new form inicio
     */
    public tareas() {
        initComponents();
        d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width-100, d.height-61);
        jLabel14.setSize(d.width-100, d.height-61);
        jLabel14.setIcon(new ImageIcon(((ImageIcon) jLabel14.getIcon()).getImage().getScaledInstance(jLabel14.getWidth(), jLabel14.getHeight(), Image.SCALE_DEFAULT)));
        
        setVisible(false);
    }

    public JComboBox getjComboBox1() {
        return jComboBox1;
    }

    public void setjComboBox1(JComboBox jComboBox1) {
        this.jComboBox1 = jComboBox1;
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

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
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

    public JLabel getjLabel26() {
        return jLabel26;
    }

    public void setjLabel26(JLabel jLabel26) {
        this.jLabel26 = jLabel26;
    }

    public JLabel getjLabel27() {
        return jLabel27;
    }

    public void setjLabel27(JLabel jLabel27) {
        this.jLabel27 = jLabel27;
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

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    public void setjScrollPane3(JScrollPane jScrollPane3) {
        this.jScrollPane3 = jScrollPane3;
    }

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

    public JTable getjTable2() {
        return jTable2;
    }

    public void setjTable2(JTable jTable2) {
        this.jTable2 = jTable2;
    }

    public JTextArea getjTextArea1() {
        return jTextArea1;
    }

    public void setjTextArea1(JTextArea jTextArea1) {
        this.jTextArea1 = jTextArea1;
    }

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }

    public JTextField getjTextField2() {
        return jTextField2;
    }

    public void setjTextField2(JTextField jTextField2) {
        this.jTextField2 = jTextField2;
    }

    public JTextField getjTextField3() {
        return jTextField3;
    }

    public void setjTextField3(JTextField jTextField3) {
        this.jTextField3 = jTextField3;
    }

    public Dimension getD() {
        return d;
    }
    
    public void tiempo(){
        Random r = new Random();
        int leap=0;
        while(true){
            Double d = r.nextDouble()*3+1;
            if(d==1){
                leap=20;
                while(leap!=0){
                    try {
                        jLabel17.setText(leap+" segundos");
                        leap--;
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(tareas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                JOptionPane.showMessageDialog(null, "Valor", "Vaciar", 1);
                        
            }
            if(d==2){
                leap=10;
                while(leap!=0){
                    try {
                        jLabel17.setText(leap+" segundos");
                        leap--;
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(tareas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                JOptionPane.showMessageDialog(null, "Valor", "Vaciar", 1);
            }
            if(d==3){
                leap=15;
                while(leap!=0){
                    try {
                        jLabel17.setText(leap+" segundos");
                        leap--;
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(tareas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                JOptionPane.showMessageDialog(null, "Valor", "Vaciar", 1);
            }
            
        }
        
    }
    
    public void setD(Dimension d) {
        this.d = d;
    }

    public JLabel getjLabel14() {
        return jLabel14;
    }

    public void setjLabel14(JLabel jLabel14) {
        this.jLabel14 = jLabel14;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

   


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField3 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setEnabled(false);
        setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);
        jPanel2.add(jLabel1);
        jLabel1.setBounds(430, 0, 160, 220);

        jLabel4.setFont(new java.awt.Font("Roboto Light", 3, 14)); // NOI18N
        jLabel4.setText("Nombre:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(0, 0, 100, 30);

        jLabel5.setFont(new java.awt.Font("Roboto Light", 3, 14)); // NOI18N
        jLabel5.setText("Tipo:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(0, 30, 100, 30);

        jLabel6.setFont(new java.awt.Font("Roboto Light", 3, 14)); // NOI18N
        jLabel6.setText("RUC:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(0, 60, 100, 30);

        jLabel7.setFont(new java.awt.Font("Roboto Light", 3, 14)); // NOI18N
        jLabel7.setText("Telefono 2:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(0, 120, 100, 30);

        jLabel8.setFont(new java.awt.Font("Roboto Light", 3, 14)); // NOI18N
        jLabel8.setText("Correo:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(0, 150, 100, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/isla sol.jpg"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(590, 0, 530, 220);
        jLabel2.setIcon(new ImageIcon(((ImageIcon) jLabel2.getIcon()).getImage().getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_DEFAULT)));

        jLabel3.setFont(new java.awt.Font("Roboto Light", 2, 14)); // NOI18N
        jLabel3.setText("Desconocido");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(170, 150, 210, 30);

        jLabel9.setFont(new java.awt.Font("Roboto Light", 3, 14)); // NOI18N
        jLabel9.setText("Telefono 1:");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(0, 90, 100, 30);

        jLabel10.setFont(new java.awt.Font("Roboto Light", 2, 14)); // NOI18N
        jLabel10.setText("Desconocido");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(170, 0, 210, 30);

        jLabel11.setFont(new java.awt.Font("Roboto Light", 2, 14)); // NOI18N
        jLabel11.setText("Desconocido");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(170, 30, 210, 30);

        jLabel12.setFont(new java.awt.Font("Roboto Light", 2, 14)); // NOI18N
        jLabel12.setText("Desconocido");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(170, 60, 210, 30);

        jLabel13.setFont(new java.awt.Font("Roboto Light", 2, 14)); // NOI18N
        jLabel13.setText("Desconocido");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(170, 90, 210, 30);

        jLabel15.setFont(new java.awt.Font("Roboto Light", 2, 14)); // NOI18N
        jLabel15.setText("Desconocido");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(170, 120, 210, 30);

        add(jPanel2);
        jPanel2.setBounds(50, 90, 1120, 220);

        jLabel16.setText("Tiempo de Espera:");
        add(jLabel16);
        jLabel16.setBounds(30, 10, 110, 30);
        add(jLabel17);
        jLabel17.setBounds(180, 10, 170, 30);

        jLabel18.setFont(new java.awt.Font("Roboto Light", 3, 14)); // NOI18N
        jLabel18.setText("Extra:");
        add(jLabel18);
        jLabel18.setBounds(50, 460, 140, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Informacion", "Prioridad"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(50, 490, 480, 100);

        jLabel23.setFont(new java.awt.Font("Roboto Light", 3, 14)); // NOI18N
        jLabel23.setText("Descripcion:");
        add(jLabel23);
        jLabel23.setBounds(640, 400, 100, 30);

        jLabel26.setFont(new java.awt.Font("Roboto Light", 3, 14)); // NOI18N
        jLabel26.setText("Imagen:");
        add(jLabel26);
        jLabel26.setBounds(640, 490, 100, 30);

        jLabel22.setFont(new java.awt.Font("Roboto Light", 3, 14)); // NOI18N
        jLabel22.setText("Tarea:");
        add(jLabel22);
        jLabel22.setBounds(640, 370, 100, 30);

        jLabel27.setFont(new java.awt.Font("Roboto Light", 3, 14)); // NOI18N
        jLabel27.setText("Prioridad:");
        add(jLabel27);
        jLabel27.setBounds(640, 540, 100, 30);

        jLabel19.setFont(new java.awt.Font("Roboto Light", 3, 14)); // NOI18N
        jLabel19.setText("ID:");
        add(jLabel19);
        jLabel19.setBounds(640, 340, 100, 30);
        add(jTextField1);
        jTextField1.setBounds(760, 370, 230, 30);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        add(jTextField2);
        jTextField2.setBounds(760, 340, 140, 30);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        add(jScrollPane2);
        jScrollPane2.setBounds(760, 400, 330, 90);
        add(jTextField3);
        jTextField3.setBounds(760, 490, 230, 40);

        jLabel20.setText("Verificador");
        add(jLabel20);
        jLabel20.setBounds(1000, 490, 90, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Baja", "Media", "Alta" }));
        add(jComboBox1);
        jComboBox1.setBounds(760, 530, 230, 40);

        jLabel21.setFont(new java.awt.Font("Roboto Light", 3, 14)); // NOI18N
        jLabel21.setText("Tareas a Realizar:");
        add(jLabel21);
        jLabel21.setBounds(50, 310, 140, 30);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tarea", "Estado"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        add(jScrollPane3);
        jScrollPane3.setBounds(50, 340, 480, 100);

        jLabel14.setFont(new java.awt.Font("Roboto Light", 3, 14)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/fondo SIC 2.jpg"))); // NOI18N
        add(jLabel14);
        jLabel14.setBounds(0, 0, 1200, 650);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
