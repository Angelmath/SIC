/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Login.ventas;

import Login.Entidad.Fcomisiones;
import Login.Entidad.Fempleado;
import Login.servicio.ServiceHb;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import rrhh.Entidad.Comisiones;
import rrhh.servicio.Funcion;
/**
 *
 * @author homemig
 */
public class fproyectos6 extends javax.swing.JPanel {
    String cl;
    String mes;
    String anio;
    String depa="";
    Calendar rightNow=Calendar.getInstance();;
    Fcomisiones comi=null;
    String ninstalacion="";
    String ncliente="";
    List<Fempleado> list=null;
    DecimalFormat df = new DecimalFormat("#.##");
    String id="";
    int numval=0;
    String[] fecha= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
    /**
     * Creates new form cliente
     */
    public fproyectos6() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        
        initComponents();
        Calendar rightNow = Calendar.getInstance();
        int ccyy = rightNow.get(Calendar.YEAR);
        int month = rightNow.get(Calendar.MONTH);
        mes= fecha[month];
        anio= ""+ccyy;
        int divpanel= (d.height-350)/2;
        jScrollPane1.setSize(d.width-jScrollPane1.getX()-100, divpanel);
        jScrollPane2.setSize(d.width-jScrollPane2.getX()-100, divpanel);
        jScrollPane2.setLocation(jScrollPane2.getX(), jScrollPane1.getY()+jScrollPane1.getHeight()+25);
        jPanel1.setLocation(jPanel1.getX(), jScrollPane2.getY()+jScrollPane2.getHeight());
        setSize(d.width, d.height-95);
        setVisible(false);
    }

    public Fcomisiones getComi() {
        return comi;
    }

    public void setComi(Fcomisiones comi) {
        this.comi = comi;
    }

    public String getNinstalacion() {
        return ninstalacion;
    }

    public void setNinstalacion(String ninstalacion) {
        this.ninstalacion = ninstalacion;
    }

    public String getNcliente() {
        return ncliente;
    }

    public void setNcliente(String ncliente) {
        this.ncliente = ncliente;
    }

    public List<Fempleado> getList() {
        return list;
    }

    public void setList(List<Fempleado> list) {
        this.list = list;
    }

    public DecimalFormat getDf() {
        return df;
    }

    public void setDf(DecimalFormat df) {
        this.df = df;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumval() {
        return numval;
    }

    public void setNumval(int numval) {
        this.numval = numval;
    }

    public String[] getFecha() {
        return fecha;
    }

    public void setFecha(String[] fecha) {
        this.fecha = fecha;
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

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public JButton getjButton2() {
        return jButton2;
    }

    public void setjButton2(JButton jButton2) {
        this.jButton2 = jButton2;
    }

    public JButton getjButton3() {
        return jButton3;
    }

    public void setjButton3(JButton jButton3) {
        this.jButton3 = jButton3;
    }

    public JComboBox getjComboBox1() {
        return jComboBox1;
    }

    public void setjComboBox1(JComboBox jComboBox1) {
        this.jComboBox1 = jComboBox1;
    }

    public JComboBox getjComboBox2() {
        return jComboBox2;
    }

    public void setjComboBox2(JComboBox jComboBox2) {
        this.jComboBox2 = jComboBox2;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JTable getjTable2() {
        return jTable2;
    }

    public void setjTable2(JTable jTable2) {
        this.jTable2 = jTable2;
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
        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Instalacion", "Fecha", "Valor +", "Valor -", "Rentabilidad", "Ver"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 30, 750, 180);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pendientes", "Culminados" }));
        add(jComboBox1);
        jComboBox1.setBounds(30, 0, 150, 30);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CI", "Nombre", "Valor", "Fecha", "Descripcion", "id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowHeight(24);
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(5).setMinWidth(0);
            jTable2.getColumnModel().getColumn(5).setPreferredWidth(0);
            jTable2.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        add(jScrollPane2);
        jScrollPane2.setBounds(30, 240, 750, 220);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(0, 0, 170, 40);

        jButton1.setText("Generar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(190, 0, 150, 40);

        jButton3.setText("Eliminar");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(350, 0, 150, 40);

        jButton2.setText("Finalizar Comisiones");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(600, 0, 150, 40);

        add(jPanel1);
        jPanel1.setBounds(30, 460, 750, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        int col = jTable1.getSelectedColumn();
        if(col==6){
            id = jTable1.getValueAt(row, col).toString();
            try{
            ServiceHb serv = new ServiceHb();
            serv.iniciarTransaccion();
            list = serv.getFempleado(id);
            comi= (Fcomisiones)serv.obtenerObjeto(Fcomisiones.class, Integer.parseInt(id));
            ninstalacion= comi.getInstalacion().getDetalle();
            ncliente= comi.getClientes().getApellido();
            serv.cerrarSesion();
            actualizartabla2();
            
            }catch(Exception io){
            
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try{
            if(list!=null){
                rrhh.servicio.ServiceHb helper = new rrhh.servicio.ServiceHb();
                helper.iniciarTransaccion();
                for(Fempleado i: list){
                    Comisiones c = new Comisiones();
                    c.setCi(i.getCi());
                    c.setDetalle("Pago de Comision "+jComboBox2.getSelectedItem().toString()+" de "+ncliente+" - "+ninstalacion);
                    c.setObservacion("Pago de Comision "+jComboBox2.getSelectedItem().toString()+" de "+ncliente+" - "+ninstalacion);
                    c.setValor(""+df.format((Double.parseDouble(i.getValor())/numval)).replace(",", "."));
                    c.setMotivo("Pago Comisiones Cajamarca");
                    c.setResponsable("Antonio Jurado");
                    c.setAccion("A");
                    Calendar cal = Calendar.getInstance();
                    c.setMes(fecha[cal.get(Calendar.MONTH)]);
                    c.setAnio(""+cal.get(Calendar.YEAR));
                    c.setFecha(Funcion.DateFormatSql(cal.getTime()));
                    c.setRelacion(id);
                    helper.crearObjeto(c);
                }
                helper.confirmarTransaccion();
                helper.cerrarSesion();
                actualizartabla2();
            }
        }catch(Exception io){
        
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        int row = jTable2.getSelectedRow();
        int col = jTable2.getSelectedColumn();
        try{
            rrhh.servicio.ServiceHb helper = new rrhh.servicio.ServiceHb();
            helper.iniciarTransaccion();
            int c = Integer.parseInt(jTable2.getValueAt(row,5).toString());
            helper.eliminarObjeto((Comisiones)helper.obtenerObjeto(Comisiones.class,c));
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            actualizartabla2();
        }catch(Exception io){
        
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            comi.setPendiente("SI");
            helper.actualizarObjeto(comi);
            helper.confirmarTransaccion();
            helper.cerrarSesion();
        }catch(Exception io){
        
        }
    }//GEN-LAST:event_jButton2MouseClicked
    public void actualizartabla2(){
        try{
            rrhh.servicio.ServiceHb helper = new rrhh.servicio.ServiceHb();
            helper.iniciarTransaccion();
            List<Comisiones> lt = helper.getComisionesByTipo2(id);
            DefaultTableModel temp2 = (DefaultTableModel) jTable2.getModel();
            for(int i=temp2.getRowCount()-1;i>=0;i--){
               temp2.removeRow(i);
            }
            if(lt!=null){
                for(Comisiones i: lt){
                    DefaultTableModel temp = (DefaultTableModel) jTable2.getModel();
                    String nombre="";
                    for(Fempleado z: list){
                        if(i.getCi().equalsIgnoreCase(z.getCi())){
                            nombre=z.getNombre()+" "+z.getApellido();
                        }
                    }
                    Object nuevo[]= {i.getCi(),nombre,i.getValor(),i.getFecha(),i.getDetalle(),i.getId()};
                    temp.addRow(nuevo);
                }
            }
            helper.cerrarSesion();
            jComboBox2.removeAllItems();
            int val = Integer.parseInt(comi.getDiferido());
            if(val==0){
                numval=1;
                jComboBox2.addItem(1+"/"+1);                
            }else{
                for(int i=1; i<=val;i++){
                    jComboBox2.addItem(i+"/"+val);
                }
                numval=val;
            }
        }catch(Exception io){}
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
