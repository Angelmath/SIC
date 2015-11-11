/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Login.ventas;

import Login.Entidad.Ctepagar;
import Login.Entidad.Fempleado;
import Login.servicio.ServiceHb;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import rrhh.Entidad.Empleado;
/**
 *
 * @author homemig
 */
public class fproyectos5 extends javax.swing.JPanel {
    String cl;
    String mes;
    String anio;
    String depa="";
    Calendar rightNow=Calendar.getInstance();
    ArrayList<Fempleado> lt= new ArrayList<Fempleado>();
    DecimalFormat df = new DecimalFormat("#.##");
    String idinstalacion="";
    String idcliente="";
    ArrayList<metaemp> ltci;
    double total=0;
    /**
     * Creates new form cliente
     */
    public class metaemp{
        String ci;
        int cant=1;

        public metaemp(){
        }
        
        public String getCi() {
            return ci;
        }

        public void setCi(String ci) {
            this.ci = ci;
        }

        public int getCant() {
            return cant;
        }

        public void setCant(int cant) {
            this.cant = cant;
        }
        
        
    }
    
    public fproyectos5() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        String[] fecha= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        initComponents();
        Calendar rightNow = Calendar.getInstance();
        int ccyy = rightNow.get(Calendar.YEAR);
        int month = rightNow.get(Calendar.MONTH);
        mes= fecha[month];
        anio= ""+ccyy;
        int divpanel= (d.height-275)/(2);
        jScrollPane1.setSize(d.width-jScrollPane1.getX()-100-110, divpanel);
        jButton1.setLocation(jScrollPane1.getX()+jScrollPane1.getWidth()+25,jButton1.getY());
        jButton2.setLocation(jScrollPane1.getX()+jScrollPane1.getWidth()+25,jButton2.getY());
        jButton4.setLocation(jScrollPane1.getX()+jScrollPane1.getWidth()+25,jButton4.getY());
        jButton5.setLocation(jScrollPane1.getX()+jScrollPane1.getWidth()+25,jButton5.getY());
        jLabel2.setLocation(jScrollPane1.getX()+jScrollPane1.getWidth()-jLabel2.getWidth(), jScrollPane1.getY()+jScrollPane1.getHeight());
        setSize(d.width, d.height-95);
        setVisible(false);
    }

    public DecimalFormat getDf() {
        return df;
    }

    public void setDf(DecimalFormat df) {
        this.df = df;
    }

    public String getIdinstalacion() {
        return idinstalacion;
    }

    public void setIdinstalacion(String idinstalacion) {
        this.idinstalacion = idinstalacion;
    }

    public String getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public JButton getjButton5() {
        return jButton5;
    }

    public void setjButton5(JButton jButton5) {
        this.jButton5 = jButton5;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
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

    public ArrayList<Fempleado> getLt() {
        return lt;
    }

    public void setLt(ArrayList<Fempleado> lt) {
        this.lt = lt;
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

    public JButton getjButton4() {
        return jButton4;
    }

    public void setjButton4(JButton jButton4) {
        this.jButton4 = jButton4;
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

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getC1() {
        return c1;
    }

    public void setC1(JLabel c1) {
        this.c1 = c1;
    }

    public JLabel getC2() {
        return c2;
    }

    public void setC2(JLabel c2) {
        this.c2 = c2;
    }

    public JLabel getC3() {
        return c3;
    }

    public void setC3(JLabel c3) {
        this.c3 = c3;
    }

    public JLabel getC4() {
        return c4;
    }

    public void setC4(JLabel c4) {
        this.c4 = c4;
    }

    public JLabel getC5() {
        return c5;
    }

    public void setC5(JLabel c5) {
        this.c5 = c5;
    }

    public JLabel getC6() {
        return c6;
    }

    public void setC6(JLabel c6) {
        this.c6 = c6;
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        c1 = new javax.swing.JLabel();
        c2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        c3 = new javax.swing.JLabel();
        c4 = new javax.swing.JLabel();
        c5 = new javax.swing.JLabel();
        c6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        diasint = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(600, 450, 150, 30);

        jLabel3.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel3.setText("Cliente:");
        add(jLabel3);
        jLabel3.setBounds(30, 10, 110, 30);

        c1.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        add(c1);
        c1.setBounds(160, 10, 280, 30);

        c2.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        add(c2);
        c2.setBounds(160, 50, 280, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula", "Nombres", "Apellidos", "Departamento", "Cargo", "Concepto", "%", "Valor", "x", "Dias", "id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, true, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(24);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(8).setMinWidth(0);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(8).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(10).setMinWidth(0);
            jTable1.getColumnModel().getColumn(10).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(10).setMaxWidth(0);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 130, 720, 320);

        jLabel6.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel6.setText("Egreso:");
        add(jLabel6);
        jLabel6.setBounds(510, 50, 70, 30);

        jLabel7.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel7.setText("Ingreso:");
        add(jLabel7);
        jLabel7.setBounds(510, 10, 70, 30);

        c3.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        add(c3);
        c3.setBounds(640, 10, 110, 30);

        c4.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        add(c4);
        c4.setBounds(640, 50, 110, 30);

        c5.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        add(c5);
        c5.setBounds(940, 10, 110, 30);

        c6.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        add(c6);
        c6.setBounds(940, 50, 110, 30);

        jLabel12.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel12.setText("Total:");
        add(jLabel12);
        jLabel12.setBounds(810, 50, 110, 30);

        jLabel13.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel13.setText("Rentabilidad:");
        add(jLabel13);
        jLabel13.setBounds(810, 10, 110, 30);

        jButton1.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jButton1.setText("Quitar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(770, 200, 90, 60);

        jButton2.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jButton2.setText("Agregar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(770, 130, 90, 60);

        jButton3.setText("ASIGNAR");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(30, 90, 150, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Asesor Comercial", "Diseño de Proyecto", "Jefe Comercial", "Jefe Tecnico", "Cuadrilla de Instalación / Indiv.", "Cuadrilla de Configuración", "Bodega / PyL / Indiv." }));
        add(jComboBox1);
        jComboBox1.setBounds(190, 90, 230, 30);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "6", "3.5", "2.5", "1", "2", "0.25", "0.125" }));
        add(jComboBox2);
        jComboBox2.setBounds(440, 90, 53, 30);

        jButton4.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jButton4.setText("Guardar");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        add(jButton4);
        jButton4.setBounds(770, 270, 90, 60);

        jLabel1.setVisible(false);
        add(jLabel1);
        jLabel1.setBounds(0, 0, 0, 0);

        jLabel8.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel8.setText("Instalacion:");
        add(jLabel8);
        jLabel8.setBounds(30, 50, 110, 30);

        jButton5.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jButton5.setText("Tecnicos");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        add(jButton5);
        jButton5.setBounds(770, 340, 90, 60);
        add(diasint);
        diasint.setBounds(450, 10, 0, 30);
        diasint.setVisible(false);
        add(jTextField1);
        jTextField1.setBounds(510, 90, 50, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        Fvinculos1 f1= new Fvinculos1(null, true);
        Empleado emp=null;
        if(f1.getSelected()!=0){
        try{
            rrhh.servicio.ServiceHb helper = new rrhh.servicio.ServiceHb();
            helper.iniciarTransaccion();
            emp= (Empleado)helper.obtenerObjeto(Empleado.class, f1.getSelected());
            String c11=""+emp.getCi();
            String c22=emp.getNombre1()+" "+emp.getNombre2();
            String c33=emp.getApellido1()+" "+emp.getApellido2();
            String c44=f1.getDepartamentoo();
            String c55=emp.getPerfilpuesto();
            Fempleado fa= new Fempleado();
            fa.setCi(c11);
            fa.setNombre(c22);
            fa.setApellido(c33);
            fa.setDepartamento(c44);
            fa.setCargo(c55);
            fa.setPorcentaje("0");
            fa.setIdfcomisiones(jLabel1.getText());
            fa.setDias(diasint.getText());
            lt.add(fa);
        helper.cerrarSesion();
        }catch(Exception io){}
        }
        llenar();
    }//GEN-LAST:event_jButton2MouseClicked
    
    public void llenarlt(List<Fempleado> lt2){
        lt= new ArrayList<Fempleado>();
        if(lt2!=null){
            for(Fempleado i: lt2){
                lt.add(i);
            }
        }
        llenar();
    }
    
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        int row= jTable1.getSelectedRow();
        if(lt.size()!=0){
            lt.remove(row);
        }
        llenar();
    }//GEN-LAST:event_jButton1MouseClicked

    public ArrayList<metaemp> getLtci() {
        return ltci;
    }

    public void setLtci(ArrayList<metaemp> ltci) {
        this.ltci = ltci;
    }

    public JLabel getDiasint() {
        return diasint;
    }

    public void setDiasint(JLabel diasint) {
        this.diasint = diasint;
    }

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        int row = jTable1.getSelectedRow();
        String text= jComboBox1.getSelectedItem().toString();
        String text2="";
        if(jTextField1.getText().isEmpty()){
            text2= jComboBox2.getItemAt(jComboBox1.getSelectedIndex()).toString();
        }else{
            text2= jTextField1.getText();
        }
        lt.get(row).setCargo2(text);
        lt.get(row).setPorcentaje(text2);
        double dia= Double.parseDouble(lt.get(row).getDias());
        double tdias = Double.parseDouble(diasint.getText());
        double v1= Double.parseDouble(c3.getText().replace("$ ", ""));
        double v2= Double.parseDouble(c4.getText().replace("-$ ", ""));
        double v3= Double.parseDouble(text2);
        v1= ((((v1-v2)*v3)/100)*dia)/tdias;
        lt.get(row).setValor(df.format(v1).replace(",", "."));
        llenar();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            List<Fempleado> emptl= helper.getFempleado(jLabel1.getText());
            if(emptl!=null){
                for(Fempleado i: emptl){
                    helper.eliminarObjeto(i);
                }
            helper.confirmarTransaccion();
            }
            helper.cerrarSesion();
            
            helper = new ServiceHb();
            helper.iniciarTransaccion();
            for(Fempleado i: lt){
                
                helper.crearObjeto(i);
            }
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            JOptionPane.showMessageDialog(null, "Comisiones Guardadas");
        }catch(Exception io){
            System.out.println(io);
        }
    }//GEN-LAST:event_jButton4MouseClicked
    public void llenartecnicos(){
        try{
            ltci= new ArrayList<>();
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            List<Ctepagar> listct = helper.getlistaCtePagarvarioscomi(idcliente,idinstalacion," ci:");
            helper.cerrarSesion();
            if(listct!=null){
                for (Ctepagar i: listct) {
                    String[] cadena=i.getDetalle().split(" ci:");
                    if(cadena.length!=0){
                        
                        for(int x=1; x<cadena.length;x++){
                            String texto= cadena[x].split(" ")[0];
                                if(!buscar(texto)){
                                    metaemp m = new metaemp();
                                    m.setCi(texto);
                                    ltci.add(m);
                                }
                        }
                    }
                }
            }
        }catch(Exception io){
            System.out.println(io);
        }
        Empleado emp=null;
        try{
            rrhh.servicio.ServiceHb helper = new rrhh.servicio.ServiceHb();
            helper.iniciarTransaccion();
            for(metaemp i: ltci){
                emp= (Empleado)helper.obtenerObjeto(Empleado.class, Integer.parseInt(i.getCi()));
                String c11=""+emp.getCi();
                String c22=emp.getNombre1()+" "+emp.getNombre2();
                String c33=emp.getApellido1()+" "+emp.getApellido2();
                String c44=emp.getDeptEmpl().getDepartamento().getNombre();
                String c55=emp.getPerfilpuesto();
                Fempleado fa= new Fempleado();
                fa.setCi(c11);
                fa.setNombre(c22);
                fa.setApellido(c33);
                fa.setDepartamento(c44);
                fa.setCargo(c55);
                fa.setPorcentaje("0");
                fa.setIdfcomisiones(jLabel1.getText());
                fa.setDias(""+i.getCant());
                lt.add(fa);
            }
        helper.cerrarSesion();
        }catch(Exception io){}
        
        llenar();
    }
    public boolean buscar(String ci){
        if(ltci!=null){
            for(metaemp i: ltci){
                if(i.getCi().contains(ci)){
                    i.setCant(i.getCant()+1);
                    return true;
                }
            }
        }else{
            metaemp amp= new metaemp();
            amp.setCant(1);
            amp.setCi(ci);
            ltci.add(amp);
            return true;
        }
        return false;
    }
    

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
       llenartecnicos(); 
    }//GEN-LAST:event_jButton5MouseClicked
    
    public static void reiniciarJTable(javax.swing.JTable Tabla){
        DefaultTableModel modelo = (DefaultTableModel) Tabla.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);
    }
    
    public void llenar(){
        reiniciarJTable(jTable1);
        DefaultTableModel temp = (DefaultTableModel) jTable1.getModel();
        total=0;
        for(Fempleado i: lt){    
            String val = "";
            String val2 = "";
            if(i.getValor()!=null){
                try{
                    val="$ "+df.format(Double.parseDouble(i.getValor())).replace(",", ".");
                    val2="%" +i.getPorcentaje();
                    
                    total = total+Double.parseDouble(i.getValor());
                    jLabel2.setText("$ "+df.format(total).replace(",", "."));
                }catch(Exception io){}
            }
             
            Object nuevo[]= {i.getCi(),i.getNombre(),i.getApellido(),i.getDepartamento(),i.getCargo(),i.getCargo2(),val2,val,"",i.getDias()+"/"+diasint.getText()};
            temp.addRow(nuevo);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel c1;
    private javax.swing.JLabel c2;
    private javax.swing.JLabel c3;
    private javax.swing.JLabel c4;
    private javax.swing.JLabel c5;
    private javax.swing.JLabel c6;
    private javax.swing.JLabel diasint;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
