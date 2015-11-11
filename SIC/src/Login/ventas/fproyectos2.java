/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Login.ventas;

import Login.Entidad.Instalacion;
import Login.servicio.ServiceHb;
import java.awt.Dimension;
import java.awt.Toolkit;
import static java.lang.Thread.sleep;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author homemig
 */
public class fproyectos2 extends javax.swing.JPanel {
    String cl;
    int breakhilo=0;
    /**
     * Creates new form cliente
     */
    public fproyectos2() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        String[] fecha= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        initComponents();
        Calendar rightNow = Calendar.getInstance();
        int ccyy = rightNow.get(Calendar.YEAR);
        int month = rightNow.get(Calendar.MONTH);
        setSize(d.width, d.height-95);
        jScrollPane1.setSize(d.width-jScrollPane1.getX()-100, d.height-jScrollPane1.getY()-250);
        jLabel22.setLocation(d.width-(jLabel22.getWidth()*2), d.height-95-(jLabel22.getHeight()*2));
        
        setVisible(false);
    }
    
    public JLabel getjLabel22() {
        return jLabel22;
    }
    public class updateTablas extends Thread {
        int turno;
        public updateTablas(int turno){
            this.turno=turno;
        }
        
        @Override
        public void run() {
            breakhilo=1;
            try{
                sleep(800);
                breakhilo=0;
            }catch(Exception io){
            }
            
            if(turno==1){
                llenar();
            }
            if(turno==2){
                llenartexto();
            }
            
        }
    }
    public void llenarhilo(){
        updateTablas up = new updateTablas(1);
        up.start();
    }
    public void llenarhilo2(){
        updateTablas up = new updateTablas(2);
        up.start();
    }
    public void setjLabel22(JLabel jLabel22) {
        this.jLabel22 = jLabel22;
    }
    
    public void llenartexto(){
        ServiceHb helper =null;
        List<Instalacion> lt=null;
        try{
            helper= new ServiceHb();
            helper.iniciarTransaccion();
            lt=helper.getlistaInstalacionFinan2(jComboBox1.getSelectedIndex(), jTextField1.getText(), jTextField2.getText());
            DefaultTableModel temp2 = (DefaultTableModel) jTable1.getModel();
            for(int i=temp2.getRowCount()-1;i>=0;i--){
               temp2.removeRow(i);
            }
            if(lt!=null){
                for(Instalacion i: lt){
                    if(breakhilo==1){break;}
                    DefaultTableModel temp = (DefaultTableModel) jTable1.getModel();
                    Object nuevo[]= {i.getClientes().getApellido(),i.getClientes().getNombre(),i.getDetalle(),i.getProceso(),i,i.getClientes().getId(),i.getId()};
                    temp.addRow(nuevo);
                }
            }
            helper.cerrarSesion();
        }catch(Exception io){
        }
        
    }
    
    public void llenar(){
        ServiceHb helper =null;
        List<Instalacion> lt=null;
        try{
            helper= new ServiceHb();
            helper.iniciarTransaccion();
            lt=helper.getlistaInstalacionFinan(jComboBox1.getSelectedIndex());
            DefaultTableModel temp2 = (DefaultTableModel) jTable1.getModel();
            for(int i=temp2.getRowCount()-1;i>=0;i--){
               temp2.removeRow(i);
            }
            if(lt!=null){
                for(Instalacion i: lt){
                    if(breakhilo==1){break;}
                    DefaultTableModel temp = (DefaultTableModel) jTable1.getModel();
                    Object nuevo[]= {i.getClientes().getApellido(),i.getClientes().getNombre(),i.getDetalle(),i.getProceso(),i,i.getClientes().getId(),i.getId()};
                    temp.addRow(nuevo);
                }
            }
            helper.cerrarSesion();
        }catch(Exception io){
        }
        
    }
    public static Date getPrimerDiaDelMes() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.getActualMinimum(Calendar.DAY_OF_MONTH),
                cal.getMinimum(Calendar.HOUR_OF_DAY),
                cal.getMinimum(Calendar.MINUTE),
                cal.getMinimum(Calendar.SECOND));
        return cal.getTime();
    }
    
    public static Date getUltimoDiaDelMes() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.getActualMaximum(Calendar.DAY_OF_MONTH),
                cal.getMaximum(Calendar.HOUR_OF_DAY),
                cal.getMaximum(Calendar.MINUTE),
                cal.getMaximum(Calendar.SECOND));
        return cal.getTime();
    }
    
    public static Date getPrimerDiaDelMes3() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -3);
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.getActualMinimum(Calendar.DAY_OF_MONTH),
                cal.getMinimum(Calendar.HOUR_OF_DAY),
                cal.getMinimum(Calendar.MINUTE),
                cal.getMinimum(Calendar.SECOND));
        
        return cal.getTime();
    }
    
    public static Date getUltimoDiaDelMes3() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, +3);
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.getActualMaximum(Calendar.DAY_OF_MONTH),
                cal.getMaximum(Calendar.HOUR_OF_DAY),
                cal.getMaximum(Calendar.MINUTE),
                cal.getMaximum(Calendar.SECOND));
        return cal.getTime();
    }
    
    public void carga1(){
    }
    
    
    public void carga2(){
        
    }

    public JComboBox getjComboBox1() {
        return jComboBox1;
    }

    public void setjComboBox1(JComboBox jComboBox1) {
        this.jComboBox1 = jComboBox1;
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

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }
    
    
    public String getCl() {
        return cl;
    }
    
    public void setCl(String cl) {
        this.cl = cl;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel22 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 204));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/back.png"))); // NOI18N
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel22MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel22MouseExited(evt);
            }
        });
        add(jLabel22);
        jLabel22.setBounds(930, 530, 50, 50);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Contacto", "Instalacion", "Estado", "Iniciar", "idCliente", "idInstalacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(24);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(4).setMinWidth(50);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(5).setMinWidth(0);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(6).setMinWidth(0);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(320, 0, 730, 430);

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        add(jTextField1);
        jTextField1.setBounds(30, 170, 260, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Espera Aprobación Financiera", "Aprobación Financiera", "En Curso", "Culminada", "Facturado", "Cancelado" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1);
        jComboBox1.setBounds(140, 100, 150, 30);

        jLabel1.setFont(new java.awt.Font("Roboto Thin", 0, 14)); // NOI18N
        jLabel1.setText("Cliente");
        add(jLabel1);
        jLabel1.setBounds(30, 210, 90, 30);

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel2.setText("Clientes Pendientes");
        add(jLabel2);
        jLabel2.setBounds(30, 40, 220, 30);

        jLabel3.setFont(new java.awt.Font("Roboto Thin", 0, 14)); // NOI18N
        jLabel3.setText("Busqueda:");
        add(jLabel3);
        jLabel3.setBounds(30, 100, 90, 30);

        jLabel4.setFont(new java.awt.Font("Roboto Thin", 0, 14)); // NOI18N
        jLabel4.setText("Instalacion");
        add(jLabel4);
        jLabel4.setBounds(30, 140, 90, 30);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        add(jTextField2);
        jTextField2.setBounds(30, 240, 260, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked

    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseEntered

    }//GEN-LAST:event_jLabel22MouseEntered

    private void jLabel22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseExited

    }//GEN-LAST:event_jLabel22MouseExited

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        llenarhilo2();
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        llenarhilo2();
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        llenarhilo2();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed
            
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
