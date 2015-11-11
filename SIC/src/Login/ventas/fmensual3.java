/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Login.ventas;

import Login.Entidad.Ctecobrar;
import Login.Entidad.Fcomisiones;
import Login.Entidad.Fempleado;
import Login.Entidad.Retencionfactu;
import Login.servicio.Funcion;
import Login.servicio.ServiceHb;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jxl.CellView;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
/**
 *
 * @author homemig
 */
public class fmensual3 extends javax.swing.JPanel {
    String cl;
    String mes;
    String anio;
    String depa="";
    Calendar rightNow=Calendar.getInstance();;
    Fcomisiones comi=null;
    String ninstalacion="";
    String ncliente="";
    List<Fempleado> list=null;
    DecimalFormat df = new DecimalFormat("0.00");
    String id="";
    int numval=0;
    String[] fecha= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
    /**
     * Creates new form cliente
     */
    public fmensual3() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        
        initComponents();
        Calendar rightNow2 = Calendar.getInstance();
        int ccyy = rightNow2.get(Calendar.YEAR);
        int month = rightNow2.get(Calendar.MONTH);
        mes= fecha[month];
        anio= ""+ccyy;
        int divpanel= d.height-350;
        setSize(d.width, d.height-95);
        jScrollPane1.setSize(d.width-jScrollPane1.getX()-100, divpanel);
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

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);
        add(jDateChooser1);
        jDateChooser1.setBounds(170, 10, 190, 30);
        add(jDateChooser2);
        jDateChooser2.setBounds(170, 60, 190, 30);

        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel4.setText("Hasta:");
        add(jLabel4);
        jLabel4.setBounds(30, 60, 130, 30);

        jLabel5.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel5.setText("Desde:");
        add(jLabel5);
        jLabel5.setBounds(30, 10, 130, 30);

        jButton1.setText("Generar Excel");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(450, 60, 160, 30);

        jButton2.setText("VER");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(450, 10, 160, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "N° Factura", "N° Aut. Factura", "Subtotal", "Iva 12%", "Total", "Valor Retencion", "N° Retencion", "N° Aut. Retencion", "Fecha Retencion", "1%", "2%", "8%", "10%", "30%", "70%", "100%", "Total Cte Cobrar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setRowHeight(24);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(9).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(17).setPreferredWidth(120);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 110, 1150, 260);

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("base");
        add(jTextField1);
        jTextField1.setBounds(630, 60, 140, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            List<Ctecobrar> ltfact =null;
            if(jDateChooser1.getDate()!=null && jDateChooser2!=null){
                ltfact= helper.getbusquedaCtecobrar(jDateChooser1.getDate(),jDateChooser2.getDate());
            }
            DefaultTableModel temp2 = (DefaultTableModel) jTable1.getModel();
            for(int i=temp2.getRowCount()-1;i>=0;i--){
               temp2.removeRow(i);
            }
            if(ltfact!=null){
                for(Ctecobrar i: ltfact){
                    DefaultTableModel temp = (DefaultTableModel) jTable1.getModel();
                    Retencionfactu ret=null;
                    if(!i.getIdretencion().equalsIgnoreCase("")){
                        ret = helper.getrentencion(i.getIdretencion());
                    }
                    float c=0;
                    String c1="";
                    String c2="";
                    String c3="";
                    String c4="";
                    String c5="";
                    String c6="";
                    String c7="";
                    String c8="";
                    String c9="";
                    String c10="";
                    if(ret!=null){
                        if(ret.getTotal()!=null){
                            c=Float.parseFloat(ret.getTotal());
                        }
                        c1=ret.getIdnombre();
                        c2=ret.getSri();
                        c3=Funcion.DateFormatSql(ret.getFecha());
                        c4=df.format(Double.parseDouble(ret.getValor1())).replace(",", ".");
                        c5=df.format(Double.parseDouble(ret.getValor2())).replace(",", ".");
                        c6=df.format(Double.parseDouble(ret.getValor8())).replace(",", ".");
                        if(ret.getValor10()!=null){
                            c7=df.format(Double.parseDouble(ret.getValor10())).replace(",", ".");
                        }else{
                        c7="0.00";
                        }
                        c8=df.format(Double.parseDouble(ret.getValor30())).replace(",", ".");
                        c9=df.format(Double.parseDouble(ret.getValor70())).replace(",", ".");
                        c10=df.format(Double.parseDouble(ret.getValor100())).replace(",", ".");
                    }
                    String s1=df.format(Double.parseDouble(i.getSubmontos())).replace(",", ".");
                    String s3=df.format(Double.parseDouble(i.getIvamontos())).replace(",", ".");
                    String s4=df.format(Double.parseDouble(i.getMontos())).replace(",", ".");
                    float s = Float.parseFloat(i.getMontos());
                    Object nuevo[]= {i.getFecha(),i.getFactura(),i.getAutfactura(),df.format(c).replace(",","."),s1,s3,s4,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,df.format(s-c).replace(",",".")};
                    temp.addRow(nuevo);   
                }
            }
            helper.cerrarSesion();
        }catch(Exception io){
        
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if(jTable1.getRowCount()!=0){
            export();
            JOptionPane.showMessageDialog(null, "Excel Generado");
        }
    }//GEN-LAST:event_jButton1MouseClicked
    
    public boolean export(){ 
        try 
        { 
        String direccion="";
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int respuesta = chooser.showOpenDialog(null);
        String cadena="";
        if (respuesta == JFileChooser.APPROVE_OPTION)
        {
            direccion = chooser.getSelectedFile().getAbsolutePath();
        }
        File file = new File(direccion+"/"+jTextField1.getText()+".xls");
            //Representa nuestro archivo en excel y necesita un OutputStream para saber donde va locoar los datos
            try ( //Nuestro flujo de salida para apuntar a donde vamos a escribir
                    DataOutputStream out = new DataOutputStream(new FileOutputStream(file))) {
                //Representa nuestro archivo en excel y necesita un OutputStream para saber donde va locoar los datos
                WritableWorkbook w = Workbook.createWorkbook(out);
                
                WritableSheet s = w.createSheet("Proveedores", 0);
                String[] ftc= {"FECHA FACTURA","N° FACTURA","N° AUT. FACTURA","BASE","IVA 12%","TOTAL","TOTAL RETENCION","N° RETENCION","N° AUT. RETENCION","FECHA RETENCION","%1","%2","%8","%10","%30","%70","%100","TOTAL FACTURA"};
                for(int i=0;i< ftc.length;i++){
                    String objeto=ftc[i];
                    Label l = new Label(i, 0, objeto);
                    s.addCell(l);
                }
                
                for(int i=0;i< jTable1.getColumnCount();i++){
                    for(int j=0;j<jTable1.getRowCount();j++){
                        Object objeto=jTable1.getValueAt(j,i);
                        Label l = new Label(i, j+1, objeto.toString());
                        s.addCell(l);
                    }
                }
                //Como excel tiene muchas hojas esta crea o toma la hoja
                //Coloca el nombre del "tab" y el indice del tab
                for (int i = 0; i < jTable1.getColumnCount() ;i++) {
                    CellView cv = s.getColumnView(i);
                    cv.setAutosize(true);
                    s.setColumnView(i, cv);
                }
                
                w.write();
                //Cerramos el WritableWorkbook y DataOutputStream
                w.close();
            } 


        //si todo sale bien salimos de aqui con un true  
        return true; 

        }catch(IOException | WriteException ex){} 

        //Si llegamos hasta aqui algo salio mal 
        return false; 
        
    } 

    
    public void actualizartabla2(){
    
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
