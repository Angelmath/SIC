/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Login.ventas;

import Login.Entidad.Articulos;
import Login.Entidad.Clientes;
import Login.Entidad.Indexpresupuesto;
import Login.Entidad.Instalacion;
import Login.Entidad.Presupuesto;
import Login.servicio.ServiceHb;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import monitoreo.servicio.Funcion;
/**
 *
 * @author homemig
 */
public class fpresupuesto2 extends javax.swing.JPanel {
    String cl;
    String mes;
    String anio;
    String depa="";
    Calendar rightNow=Calendar.getInstance();;
    /**
     * Creates new form cliente
     */
    public fpresupuesto2() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        String[] fecha= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        initComponents();
        Calendar rightNow = Calendar.getInstance();
        int ccyy = rightNow.get(Calendar.YEAR);
        int month = rightNow.get(Calendar.MONTH);
        mes= fecha[month];
        anio= ""+ccyy;
        jLabel4.setText(fecha[month]+", "+ccyy);
        jLabel6.setText(Funcion.DateFormat(rightNow.getTime()));
        setSize(d.width, d.height-95);
        setVisible(false);
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getDepa() {
        return depa;
    }

    public void setDepa(String depa) {
        this.depa = depa;
    }

    public Calendar getRightNow() {
        return rightNow;
    }

    public void setRightNow(Calendar rightNow) {
        this.rightNow = rightNow;
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
    
    public void llenarpresu(String nombre){
        depa=nombre;
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            Clientes c2 = (Clientes)helper.obtenerObjeto(Clientes.class, 245);
            List<Instalacion>lt = helper.getlistaInstPresupuesto(c2,nombre+" "+ mes +" " +anio);
            helper.cerrarSesion();
            DefaultTableModel temp2 = (DefaultTableModel) getjTable1().getModel();
            for(int i=temp2.getRowCount()-1;i>=0;i--){
               temp2.removeRow(i);
            }
            if(lt!=null){
                for(Instalacion i: lt){
                    DefaultTableModel temp = (DefaultTableModel) getjTable1().getModel();
                    Object nuevo[]= {i.getDetalle(),i};
                    temp.addRow(nuevo);
                }
            }
            DefaultTableModel temp3 = (DefaultTableModel) getjTable2().getModel();
            for(int i=temp3.getRowCount()-1;i>=0;i--){
               temp3.removeRow(i);
            }
        }catch(Exception io){
        
        }
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

        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jLabel3.setText("Departamento");
        add(jLabel3);
        jLabel3.setBounds(30, 20, 180, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mes", "id"
            }
        ));
        jTable1.setRowHeight(26);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(1).setMinWidth(0);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(0);

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 70, 250, 270);

        jLabel5.setText("Periodo");
        add(jLabel5);
        jLabel5.setBounds(360, 20, 150, 30);

        jLabel4.setText("Octubre, 2015");
        add(jLabel4);
        jLabel4.setBounds(550, 20, 150, 30);

        jLabel6.setText("10/12/2015");
        add(jLabel6);
        jLabel6.setBounds(550, 60, 150, 30);

        jLabel7.setText("Fecha");
        add(jLabel7);
        jLabel7.setBounds(360, 60, 150, 30);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Categoria", "Concepto", "Valor", "Fecha", "id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowHeight(26);
        jScrollPane2.setViewportView(jTable2);
        jTable2.getColumnModel().getColumn(0).setResizable(false);
        jTable2.getColumnModel().getColumn(1).setResizable(false);
        jTable2.getColumnModel().getColumn(3).setResizable(false);
        jTable2.getColumnModel().getColumn(4).setMinWidth(0);
        jTable2.getColumnModel().getColumn(4).setPreferredWidth(0);
        jTable2.getColumnModel().getColumn(4).setMaxWidth(0);

        add(jScrollPane2);
        jScrollPane2.setBounds(350, 150, 730, 330);

        jLabel1.setText("Presupuesto:");
        add(jLabel1);
        jLabel1.setBounds(360, 100, 150, 30);
        add(jLabel2);
        jLabel2.setBounds(550, 100, 140, 30);

        jLabel8.setText("Total:");
        add(jLabel8);
        jLabel8.setBounds(760, 504, 140, 30);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        add(jLabel9);
        jLabel9.setBounds(900, 500, 180, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        int col = jTable1.getSelectedColumn();
        ServiceHb helper=null;
        try{
            helper = new ServiceHb();
            helper.iniciarTransaccion();
            List<Indexpresupuesto> lt = helper.getIndexpresupuesto(""+jTable1.getValueAt(row, col));
            helper.cerrarSesion();
            if(lt!=null){
                jLabel2.setText(lt.get(0).getMonto());
                llenartabla(""+jTable1.getValueAt(row, col));
            }else{
                helper = new ServiceHb();
                helper.iniciarTransaccion();
                Presupuesto p = helper.getPresupuestoindi(depa);
                Indexpresupuesto presu = new Indexpresupuesto();
                presu.setPresupuesto(""+jTable1.getValueAt(row, col));
                presu.setMonto(p.getMonto());
                presu.setMes(mes);
                presu.setAnio(anio);
                
                helper.crearOrActualizarObjeto(presu);
                helper.confirmarTransaccion();
                helper.cerrarSesion();
                jLabel2.setText(p.getMonto());
                llenartabla(""+jTable1.getValueAt(row, col));
            }
            
        }catch(Exception io){
        
        }
    }//GEN-LAST:event_jTable1MouseClicked
    
    public void llenartabla(String tab){
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            List<Articulos> art = helper.getListaArticulos2(tab);
            
            DefaultTableModel temp2 = (DefaultTableModel) getjTable2().getModel();
            for(int i=temp2.getRowCount()-1;i>=0;i--){
               temp2.removeRow(i);
            }
            DecimalFormat df = new DecimalFormat("0.00");
            Double suma=0.0;
            if(art!=null){
                for(Articulos i: art){
                    String c0=i.getIdinstalacionn();
                    String c1=i.getDescripcion();
                    String c2="";
                    if(i.getIva().equalsIgnoreCase("true")){
                        Double temp=(Double.parseDouble(i.getTotal())*1.12);
                        suma= suma+temp;
                        c2=""+df.format(temp).replace(",", ".");
                    }else{
                        c2=i.getTotal();
                    }
                    String c3=""+i;
                    String c4=Funcion.DateFormat(helper.getFactura2(i.getIdfactura()).getFecha());
                    Object nuevo[]= {c0,c1,c2,c4,c3};
                    temp2.addRow(nuevo);
                }
            }
            helper.cerrarSesion();
            Double result = Double.parseDouble(jLabel2.getText()) - suma;
            jLabel9.setText(""+df.format(result).replace(",", "."));
        }catch(Exception io){
        
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
