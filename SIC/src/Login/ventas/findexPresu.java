/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Login.ventas;

import Login.Entidad.Indexitem;
import Login.Entidad.Indexpresupuesto;
import Login.Entidad.Presupuesto;
import Login.servicio.ServiceHb;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author homemig
 */
public class findexPresu extends javax.swing.JPanel {
    String cl;
    /**
     * Creates new form cliente
     */
    public findexPresu() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        String[] fecha= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        initComponents();
        Calendar rightNow = Calendar.getInstance();
        int ccyy = rightNow.get(Calendar.YEAR);
        int month = rightNow.get(Calendar.MONTH);
        setSize(d.width, d.height-95);
        jTable1.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        setVisible(false);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jTable1.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Presupuesto", "Valor", "Eliminar"
            }
        ));
        jTable1.setRowHeight(26);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(2).setMinWidth(60);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(2).setMaxWidth(60);

        add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 580, 170);

        jLabel22.setText("Presupuesto:");
        add(jLabel22);
        jLabel22.setBounds(0, 200, 140, 30);

        jLabel23.setText("Valor:");
        add(jLabel23);
        jLabel23.setBounds(0, 240, 140, 30);
        add(jTextField4);
        jTextField4.setBounds(160, 190, 190, 40);
        add(jTextField5);
        jTextField5.setBounds(160, 230, 190, 40);

        jButton11.setText("Agregar / Actualizar");
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
        });
        add(jButton11);
        jButton11.setBounds(400, 230, 140, 40);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Presupuesto", "Monto", "Mes", "Año"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        add(jScrollPane2);
        jScrollPane2.setBounds(0, 330, 570, 260);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Historial Presupuesto");
        add(jLabel1);
        jLabel1.setBounds(210, 290, 140, 30);
        add(jLabel2);
        jLabel2.setBounds(350, 190, 20, 40);
        jLabel2.setText(null);
        jLabel2.setVisible(false);

        jButton1.setText("Limpiar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(400, 190, 140, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            Presupuesto index;
            if(jLabel2.getText()!=null){
                index = (Presupuesto)helper.obtenerObjeto(Presupuesto.class,Integer.parseInt(jLabel2.getText()));
            }else{
                index = new Presupuesto();
            }
            index.setMonto(jTextField5.getText());
            index.setPresupuesto(jTextField4.getText());
                       
            helper.crearOrActualizarObjeto(index);
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            JOptionPane.showMessageDialog(null, "Presupuesto Agregado");
            limpiar();
            llenartabla1();
            llenartabla2();
        }catch(Exception io){

        }
    }//GEN-LAST:event_jButton11MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        limpiar();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row= jTable1.getSelectedRow();
        int col= jTable1.getSelectedColumn();
        if(col==2){
            String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
            if(selectedSiteName.equalsIgnoreCase("cajamarca")){
                try{
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    Presupuesto p = (Presupuesto)jTable1.getValueAt(row, col);
                    helper.eliminarObjeto(p);
                    helper.confirmarTransaccion();
                    helper.cerrarSesion();
                    JOptionPane.showMessageDialog(null, "Presupuesto Eliminado");
                    llenartabla1();
                    llenartabla2();
                }catch(Exception io){
                
                }
            }
        }
        if(col==0){
            try{
                ServiceHb helper= new ServiceHb();
                helper.iniciarTransaccion();
                Presupuesto p =(Presupuesto)jTable1.getValueAt(row, 2);
                helper.cerrarSesion();
                jTextField4.setText(p.getPresupuesto());
                jTextField5.setText(p.getMonto());
                jLabel2.setText(""+p.getId());
                llenartabla1();
                llenartabla2();
            }catch(Exception io){
                
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

        public void llenartabla1(){
            try{
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                List<Presupuesto> index = helper.getPresupuesto();
                helper.cerrarSesion();
                DefaultTableModel temp2 = (DefaultTableModel) jTable1.getModel();
                for(int i=temp2.getRowCount()-1;i>=0;i--){
                    temp2.removeRow(i);
                }
                if(index!=null){
                    
                    for(Presupuesto i: index){
                        DefaultTableModel temp = (DefaultTableModel) jTable1.getModel();
                        Object nuevo[]= {i.getPresupuesto(),i.getMonto(),i};
                        temp.addRow(nuevo);
                    }
                }
            }catch(Exception io){
            
            }
        }
        
        public void llenartabla2(){
            try{
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                List<Indexpresupuesto> index = helper.getIndexpresupuesto();
                helper.cerrarSesion();
                DefaultTableModel temp2 = (DefaultTableModel) jTable2.getModel();
                for(int i=temp2.getRowCount()-1;i>=0;i--){
                    temp2.removeRow(i);
                }
                if(index!=null){
                    for(Indexpresupuesto i: index){
                        DefaultTableModel temp = (DefaultTableModel) jTable2.getModel();
                        Object nuevo[]= {i.getPresupuesto(),i.getMonto(),i.getMes(),i.getAnio()};
                        temp.addRow(nuevo);
                    }
                }
            }catch(Exception io){
            
            }
        }
        
        public void limpiar(){
            jTextField4.setText(null);
            jTextField5.setText(null);
            jLabel2.setText(null);
        }
    
        public void cargarindexitem(){
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            List<Indexitem> list = helper.getListaIndexitem();
            helper.cerrarSesion();
            DefaultTableModel temp2 = (DefaultTableModel) jTable1.getModel();
            for(int i=temp2.getRowCount()-1;i>=0;i--){
                temp2.removeRow(i);
            }
            for(Indexitem i: list){
                DefaultTableModel temp = (DefaultTableModel) jTable1.getModel();
                Object nuevo[]= {i.getTipo(),i.getFormula(),i.getId()};
                temp.addRow(nuevo);
            }
        }catch(Exception io){
        
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}