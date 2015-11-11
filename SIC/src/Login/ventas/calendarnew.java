/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.ventas;

import Bitacora.servicio.Funcion;
import Login.Entidad.Caldepartamento;
import Login.Entidad.Calendario;
import Login.Entidad.Calpermisos;
import Login.Entidad.Login;
import Login.Entidad.Noticalen;
import Login.servicio.ServiceHb;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JLabel;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Angelmath
 */
public final class calendarnew extends javax.swing.JDialog {
    calendarpanel padre;
    Login empl;
    List<Caldepartamento> lista2;
    List<Login> listalogin;
    List<Calpermisos> listpermi;
    Calendario calen=null;
    boolean nuevo=false;
    /**
     * Creates new form ingresoU
     */
    public calendarnew(java.awt.Frame parent, calendarpanel padre, boolean modal, Login log, List<Caldepartamento> listdepa, Calendar calFin2,List<Calpermisos> listpermi) {
        super(parent, modal);
        initComponents();
        this.empl=log;       
        lista2=listdepa;
        this.listpermi=listpermi;
        dispose();
        setUndecorated(true);
        setLocationRelativeTo(null);
        for(int i=0; i<jPanel1.getComponentCount();i++){
            ((JCheckBox)jPanel1.getComponent(i)).setText(lista2.get(i).getNombre());
                String[] cat = lista2.get(i).getColor().split(",");
                ((JCheckBox)jPanel1.getComponent(i)).setForeground(new Color(Integer.parseInt(cat[0]),Integer.parseInt(cat[1]),Integer.parseInt(cat[2])));
            }
        
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();    
            if(log.getDepartamento().equalsIgnoreCase("Gerencia General")){
                listpermi=helper.getCalpermisos(log.getDepartamento());
                for(Calpermisos x: listpermi){
                    for(int i=0; i<jPanel1.getComponentCount();i++){
                        JCheckBox jb = ((JCheckBox)jPanel1.getComponent(i));
                        if(jb.getText().equalsIgnoreCase(x.getCaldepartamentoByIdcaldepa2().getNombre())){
                            jb.setSelected(true);
                            break;
                        }
                    }
                }
            }else{
                listpermi=helper.getCalpermisos(log.getDepartamento());
                for(Calpermisos x: listpermi){
                    for(int i=0; i<jPanel1.getComponentCount();i++){
                        JCheckBox jb = ((JCheckBox)jPanel1.getComponent(i));
                        if(jb.getText().equalsIgnoreCase(x.getCaldepartamentoByIdcaldepa2().getNombre())){
                            jb.setSelected(true);
                            jb.setEnabled(false);
                            break;
                        }
                    }
                }
            }    
            helper.cerrarSesion();
        }catch(Exception io){
            System.out.println("");
        }
        jTextField2.setText(log.getNombre());
        jTextField3.setText(log.getDepartamento());
        String[] horas={"05:00","05:30","06:00","06:30","07:00","07:30", "08:00","08:30","09:00","09:30","10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30","14:00","14:30","15:00","15:30","16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30","20:00","20:30","21:00","21:30","22:00","22:30"};
        jComboBox5.removeAllItems();
        jComboBox12.removeAllItems();
        for(String i: horas){
            jComboBox5.addItem(i);
            jComboBox12.addItem(i);
        }
        jDateChooser2.setDate(calFin2.getTime());
        jDateChooser1.setDate(calFin2.getTime());
        if(calen!=null){
            if(calen.getLogin().getNombre().equalsIgnoreCase(log.getNombre())){
                nuevo=true;
            }
        }
        setVisible(true);
        this.padre=padre;
        
    }
    
    public calendarnew(java.awt.Frame parent, calendarpanel padre, boolean modal, Login log, List<Caldepartamento> listdepa, Calendar calFin2,List<Calpermisos> listpermi, String hora) {
        super(parent, modal);
        initComponents();
        this.empl=log;       
        lista2=listdepa;
        this.listpermi=listpermi;
        dispose();
        setUndecorated(true);
        setLocationRelativeTo(null);
        for(int i=0; i<jPanel1.getComponentCount();i++){
            ((JCheckBox)jPanel1.getComponent(i)).setText(lista2.get(i).getNombre());
                String[] cat = lista2.get(i).getColor().split(",");
                ((JCheckBox)jPanel1.getComponent(i)).setForeground(new Color(Integer.parseInt(cat[0]),Integer.parseInt(cat[1]),Integer.parseInt(cat[2])));
            }
        
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();    
            if(log.getDepartamento().equalsIgnoreCase("Gerencia General")){
                listpermi=helper.getCalpermisos(log.getDepartamento());
                for(Calpermisos x: listpermi){
                    for(int i=0; i<jPanel1.getComponentCount();i++){
                        JCheckBox jb = ((JCheckBox)jPanel1.getComponent(i));
                        if(jb.getText().equalsIgnoreCase(x.getCaldepartamentoByIdcaldepa2().getNombre())){
                            jb.setSelected(false);
                            break;
                        }
                    }
                }
            }else{
                listpermi=helper.getCalpermisos(log.getDepartamento());
                for(Calpermisos x: listpermi){
                    for(int i=0; i<jPanel1.getComponentCount();i++){
                        JCheckBox jb = ((JCheckBox)jPanel1.getComponent(i));
                        if(jb.getText().equalsIgnoreCase(x.getCaldepartamentoByIdcaldepa2().getNombre())){
                            jb.setSelected(true);
                            jb.setEnabled(false);
                            break;
                        }
                    }
                }
            }    
            helper.cerrarSesion();
        }catch(Exception io){
            System.out.println("");
        }
        jTextField2.setText(log.getNombre());
        jTextField3.setText(log.getDepartamento());
        String[] horas={"05:00","05:30","06:00","06:30","07:00","07:30", "08:00","08:30","09:00","09:30","10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30","14:00","14:30","15:00","15:30","16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30","20:00","20:30","21:00","21:30","22:00","22:30"};
        jComboBox5.removeAllItems();
        jComboBox12.removeAllItems();
        for(String i: horas){
            jComboBox5.addItem(i);
            jComboBox12.addItem(i);
        }
        jComboBox5.setSelectedItem(hora);
        jComboBox12.setSelectedItem(hora);
        if(calen.getLogin().getNombre().equalsIgnoreCase(log.getNombre())){
            nuevo=true;
        }
        jDateChooser2.setDate(calFin2.getTime());
        jDateChooser1.setDate(calFin2.getTime());
        setVisible(true);
        this.padre=padre;
        
    }
    public calendarnew(java.awt.Frame parent, calendarpanel padre, boolean modal, Login log, List<Caldepartamento> listdepa, Calendar calFin2,List<Calpermisos> listpermi, String hora, Calendario calendario) {
        super(parent, modal);
        initComponents();
        this.empl=log;       
        this.calen= calendario;
        lista2=listdepa;
        this.listpermi=listpermi;
        dispose();
        setUndecorated(true);
        setLocationRelativeTo(null);
        for(int i=0; i<jPanel1.getComponentCount();i++){
            ((JCheckBox)jPanel1.getComponent(i)).setText(lista2.get(i).getNombre());
                String[] cat = lista2.get(i).getColor().split(",");
                ((JCheckBox)jPanel1.getComponent(i)).setForeground(new Color(Integer.parseInt(cat[0]),Integer.parseInt(cat[1]),Integer.parseInt(cat[2])));
            }
        
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();    
            if(log.getDepartamento().equalsIgnoreCase("Gerencia General")){
                listpermi=helper.getCalpermisos(log.getDepartamento());
                for(Calpermisos x: listpermi){
                    for(int i=0; i<jPanel1.getComponentCount();i++){
                        JCheckBox jb = ((JCheckBox)jPanel1.getComponent(i));
                        if(jb.getText().equalsIgnoreCase(x.getCaldepartamentoByIdcaldepa2().getNombre())){
                            jb.setSelected(true);
                            break;
                        }
                    }
                }
            }else{
                listpermi=helper.getCalpermisos(log.getDepartamento());
                for(Calpermisos x: listpermi){
                    for(int i=0; i<jPanel1.getComponentCount();i++){
                        JCheckBox jb = ((JCheckBox)jPanel1.getComponent(i));
                        if(jb.getText().equalsIgnoreCase(x.getCaldepartamentoByIdcaldepa2().getNombre())){
                            jb.setSelected(true);
                            jb.setEnabled(false);
                            break;
                        }
                    }
                }
            }    
            
        
        String[] horas={"05:00","05:30","06:00","06:30","07:00","07:30", "08:00","08:30","09:00","09:30","10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30","14:00","14:30","15:00","15:30","16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30","20:00","20:30","21:00","21:30","22:00","22:30"};
        jComboBox5.removeAllItems();
        jComboBox12.removeAllItems();
        for(String i: horas){
            jComboBox5.addItem(i);
            jComboBox12.addItem(i);
        }
        if(calen!=null){
            jTextField4.setText(calen.getTitulo());
            jTextArea1.setText(calen.getDescripcion());
            jComboBox5.setSelectedItem(calen.getHora());
            jComboBox12.setSelectedItem(calen.getAllhour());
            jDateChooser2.setDate(calen.getFechafin());
            jDateChooser1.setDate(calen.getFechafin());
            jTextField2.setText(calen.getLogin().getNombre());
            jTextField3.setText(calen.getLogin().getDepartamento());
            if(calen.getLogin().getNombre().equalsIgnoreCase(log.getNombre())){
                nuevo=true;
            }
            if(!calen.getVisible().equalsIgnoreCase("")){
            String[] visibles = calen.getVisible().split(",");
                for(String x : visibles){
                    for(int i=0; i<jPanel1.getComponentCount();i++){
                        JCheckBox jb = ((JCheckBox)jPanel1.getComponent(i));
                        if(jb.getText().equalsIgnoreCase(x)){
                            jb.setSelected(true);
                            break;
                        }
                    }
                }
            }
            if(!calen.getVinculos().equalsIgnoreCase("")){
                String[] vinculos = calen.getVinculos().split(",");
                for(String x: vinculos){
                    jComboBox8.addItem(x);
                }
            }
        }
        helper.cerrarSesion();
        }catch(Exception io){
            System.out.println("");
        }
        setVisible(true);
        this.padre=padre;
        
    }
    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
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

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jComboBox5 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cm1 = new javax.swing.JCheckBox();
        cm2 = new javax.swing.JCheckBox();
        cm3 = new javax.swing.JCheckBox();
        cm4 = new javax.swing.JCheckBox();
        cm5 = new javax.swing.JCheckBox();
        cm6 = new javax.swing.JCheckBox();
        cm7 = new javax.swing.JCheckBox();
        cm8 = new javax.swing.JCheckBox();
        cm9 = new javax.swing.JCheckBox();
        cm10 = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jComboBox12 = new javax.swing.JComboBox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso");
        setBackground(new java.awt.Color(230, 230, 230));
        setMinimumSize(new java.awt.Dimension(920, 430));
        setPreferredSize(new java.awt.Dimension(930, 500));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 74, 151));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Crear Evento");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(350, 0, 220, 30);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(190, 170, 230, 170);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 30, 980, 1);

        jLabel1.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(101, 101, 101));
        jLabel1.setText("Descripcion:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 170, 130, 30);

        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(101, 101, 101));
        jLabel4.setText("Nombre de Evento:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 50, 130, 30);

        jLabel5.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(101, 101, 101));
        jLabel5.setText("Fecha Inicio");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(480, 50, 90, 30);

        jLabel6.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(101, 101, 101));
        jLabel6.setText("Hora Inicio");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(480, 90, 90, 30);

        jTextField2.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(101, 101, 101));
        jTextField2.setEnabled(false);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(190, 130, 230, 30);

        jComboBox5.setFont(new java.awt.Font("Roboto Medium", 0, 10)); // NOI18N
        getContentPane().add(jComboBox5);
        jComboBox5.setBounds(600, 90, 100, 30);

        jLabel7.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(101, 101, 101));
        jLabel7.setText("Responsable:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 130, 130, 30);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setOpaque(true);
        getContentPane().add(jLabel8);
        jLabel8.setBounds(455, 50, 1, 340);

        jLabel10.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(101, 101, 101));
        jLabel10.setText("Dpt. a Cargo:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(30, 90, 130, 30);

        jLabel11.setFont(new java.awt.Font("Roboto Light", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(101, 101, 101));
        jLabel11.setText("Visualización:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(480, 210, 130, 30);

        jComboBox8.setFont(new java.awt.Font("Roboto Medium", 0, 10)); // NOI18N
        getContentPane().add(jComboBox8);
        jComboBox8.setBounds(600, 170, 240, 30);

        jLabel12.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(101, 101, 101));
        jLabel12.setText("Vinculo");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(480, 170, 130, 30);

        jPanel1.setLayout(null);

        cm1.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        cm1.setText("jCheckBox2");
        jPanel1.add(cm1);
        cm1.setBounds(10, 0, 200, 23);

        cm2.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        cm2.setText("jCheckBox2");
        jPanel1.add(cm2);
        cm2.setBounds(10, 20, 200, 23);

        cm3.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        cm3.setText("jCheckBox2");
        jPanel1.add(cm3);
        cm3.setBounds(10, 40, 200, 23);

        cm4.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        cm4.setText("jCheckBox2");
        jPanel1.add(cm4);
        cm4.setBounds(10, 60, 200, 23);

        cm5.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        cm5.setText("jCheckBox2");
        jPanel1.add(cm5);
        cm5.setBounds(10, 80, 200, 23);

        cm6.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        cm6.setText("jCheckBox2");
        jPanel1.add(cm6);
        cm6.setBounds(210, 0, 200, 23);

        cm7.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        cm7.setText("jCheckBox2");
        jPanel1.add(cm7);
        cm7.setBounds(210, 20, 200, 23);

        cm8.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        cm8.setText("jCheckBox2");
        jPanel1.add(cm8);
        cm8.setBounds(210, 40, 200, 23);

        cm9.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        cm9.setText("jCheckBox2");
        jPanel1.add(cm9);
        cm9.setBounds(210, 60, 200, 23);

        cm10.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        cm10.setText("jCheckBox2");
        jPanel1.add(cm10);
        cm10.setBounds(210, 80, 200, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(480, 250, 420, 110);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-aceptar-grey.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });
        getContentPane().add(jLabel13);
        jLabel13.setBounds(250, 400, 111, 39);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-cancelar-grey.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
        });
        getContentPane().add(jLabel14);
        jLabel14.setBounds(570, 400, 110, 38);

        jLabel15.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(101, 101, 101));
        jLabel15.setText("Hora Término");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(480, 130, 100, 30);

        jLabel16.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(101, 101, 101));
        jLabel16.setText("Fecha Término");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(720, 90, 40, 30);
        jLabel16.setVisible(false);

        jComboBox12.setFont(new java.awt.Font("Roboto Medium", 0, 10)); // NOI18N
        getContentPane().add(jComboBox12);
        jComboBox12.setBounds(600, 130, 100, 30);
        getContentPane().add(jDateChooser1);
        jDateChooser1.setBounds(770, 90, 80, 30);
        jDateChooser1.setVisible(false);
        getContentPane().add(jDateChooser2);
        jDateChooser2.setBounds(600, 50, 240, 30);

        jTextField3.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(101, 101, 101));
        jTextField3.setEnabled(false);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(190, 90, 230, 30);

        jTextField4.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(101, 101, 101));
        getContentPane().add(jTextField4);
        jTextField4.setBounds(190, 50, 230, 30);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-addevent-lightblue.png"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
        });
        getContentPane().add(jLabel17);
        jLabel17.setBounds(850, 170, 17, 30);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-delete-lightblue.png"))); // NOI18N
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel18MouseExited(evt);
            }
        });
        getContentPane().add(jLabel18);
        jLabel18.setBounds(880, 170, 21, 30);

        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(840, 130, 40, 30);
        jComboBox1.setVisible(false);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-culminar-grey.png"))); // NOI18N
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel19MouseExited(evt);
            }
        });
        getContentPane().add(jLabel19);
        jLabel19.setBounds(10, 400, 111, 39);
        jLabel19.setVisible(false);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-eliminar-grey.png"))); // NOI18N
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel20MouseExited(evt);
            }
        });
        getContentPane().add(jLabel20);
        jLabel20.setBounds(400, 400, 111, 39);

        getAccessibleContext().setAccessibleParent(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-aceptar-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-aceptar-grey.png"))); // NOI18N
    }//GEN-LAST:event_jLabel13MouseExited

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-cancelar-grey.png"))); // NOI18N
    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-cancelar-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        calendariovinculos cla = new calendariovinculos(null, true);
        if(cla.getSelected()!=null){
            int con=0;
            for(int i=0; i< jComboBox8.getItemCount();i++){
                if(jComboBox8.getItemAt(i).toString().equalsIgnoreCase(cla.getSelected().getNombre())){
                    con=1;
                }
            }
            if(con==0){
                jComboBox8.addItem(cla.getSelected().getNombre());
                jComboBox1.addItem(cla.getSelected());
            }
        }
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        if(jComboBox8.getItemCount()>0){
            jComboBox1.removeItemAt(jComboBox8.getSelectedIndex());
            jComboBox8.removeItemAt(jComboBox8.getSelectedIndex());
        }
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        ServiceHb helper =null;
        ArrayList<String> ltnombres = new ArrayList<>();
        ArrayList<String> ltdepa = new ArrayList<>();
        
        try{
            if(calen==null){
                helper  = new ServiceHb();
                helper.iniciarTransaccion();
                calen = new Calendario();
                calen.setTitulo(jTextField4.getText());
                calen.setDescripcion(jTextArea1.getText());
                calen.setCaldepartamento(helper.getCaldepartamento(empl.getDepartamento()));
                calen.setLogin(empl);
                calen.setFechaini(jDateChooser2.getDate());
                calen.setFechafin(jDateChooser1.getDate());
                calen.setHora(jComboBox5.getSelectedItem().toString());
                calen.setAllhour(jComboBox12.getSelectedItem().toString());
                String vinculo="";
                if(jComboBox8.getItemCount()>0){
                    for(int i=0; i<jComboBox8.getItemCount();i++){
                        vinculo=vinculo+jComboBox8.getItemAt(i).toString()+",";
                        ltnombres.add(jComboBox8.getItemAt(i).toString());
                    }
                }
                calen.setVinculos(vinculo);
                String visible="";
                if(jPanel1.getComponentCount()>0){
                    for(int i=0; i< jPanel1.getComponentCount();i++){
                        if(((JCheckBox)jPanel1.getComponent(i)).isSelected()){
                            visible= visible+ ((JCheckBox)jPanel1.getComponent(i)).getText()+",";
                            ltdepa.add(((JCheckBox)jPanel1.getComponent(i)).getText());
                        }
                    }
                }
                calen.setVisible(visible);
                helper.crearObjeto(calen);
                for(String i: ltdepa){
                    List<Login> loginn = helper.getDepartamento(i);
                    if(loginn!=null){
                        for(Login j: loginn){
                            if(!ltnombres.contains(j.getNombre())){
                                ltnombres.add(j.getNombre());
                            }
                        }
                    }
                }
                
                helper.confirmarTransaccion();
                helper.cerrarSesion();
                
                helper = new ServiceHb();
                helper.iniciarTransaccion();
                for(String i: ltnombres){
                    helper.getLoginnombre(i);
                    Noticalen n = new Noticalen();
                    n.setDescripcion("Creado :"+calen.getTitulo());
                    n.setCreador(empl.getNombre());
                    n.setDueno(i);
                    n.setFecha(Funcion.DateFormatSql(calen.getFechaini()));
                    n.setIdcalendario(calen.getId());
                    n.setVisto("NO");
                    helper.crearObjeto(n);
                }
                helper.confirmarTransaccion();
                helper.cerrarSesion();
                
                JOptionPane.showMessageDialog(null, "Evento Creado");
                padre.actualizartiempo();
            }else{
                if(nuevo){
                helper  = new ServiceHb();
                helper.iniciarTransaccion();
                calen.setTitulo(jTextField4.getText());
                calen.setDescripcion(jTextArea1.getText());
                calen.setCaldepartamento(helper.getCaldepartamento(empl.getDepartamento()));
                calen.setLogin(empl);
                calen.setFechaini(jDateChooser2.getDate());
                calen.setFechafin(jDateChooser1.getDate());
                calen.setHora(jComboBox5.getSelectedItem().toString());
                calen.setAllhour(jComboBox12.getSelectedItem().toString());
                String vinculo="";
                if(jComboBox8.getItemCount()>0){
                    for(int i=0; i<jComboBox8.getItemCount();i++){
                        vinculo=vinculo+jComboBox8.getItemAt(i).toString()+",";
                        ltnombres.add(jComboBox8.getItemAt(i).toString());
                    }
                }
                calen.setVinculos(vinculo);
                String visible="";
                if(jPanel1.getComponentCount()>0){
                    for(int i=0; i< jPanel1.getComponentCount();i++){
                        if(((JCheckBox)jPanel1.getComponent(i)).isSelected()){
                            visible= visible+ ((JCheckBox)jPanel1.getComponent(i)).getText()+",";
                            ltdepa.add(((JCheckBox)jPanel1.getComponent(i)).getText());
                        }
                    }
                }
                calen.setVisible(visible);
                helper.actualizarObjeto(calen);
                for(String i: ltdepa){
                    List<Login> loginn = helper.getDepartamento(i);
                    if(loginn!=null){
                        for(Login j: loginn){
                            if(!ltnombres.contains(j.getNombre())){
                                ltnombres.add(j.getNombre());
                            }
                        }
                    }
                }
                helper.confirmarTransaccion();
                helper.cerrarSesion();
                
                
                helper = new ServiceHb();
                helper.iniciarTransaccion();
                for(String i: ltnombres){
                    helper.getLoginnombre(i);
                    Noticalen n = new Noticalen();
                    n.setDescripcion("Editado :"+calen.getTitulo());
                    n.setCreador(empl.getNombre());
                    n.setDueno(i);
                    n.setFecha(Funcion.DateFormatSql(calen.getFechaini()));
                    n.setIdcalendario(calen.getId());
                    n.setVisto("NO");
                    helper.crearObjeto(n);
                }
                helper.confirmarTransaccion();
                helper.cerrarSesion();
                
                JOptionPane.showMessageDialog(null, "Evento Editado");
                padre.actualizartiempo();
                }
            }
        }catch(Exception io){}
        dispose();
        
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        if(nuevo){
            JOptionPane.showMessageDialog(null, "Evento Culminado");
            padre.actualizartiempo();
            dispose();
            
        }
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseEntered
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-culminar-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel19MouseEntered

    private void jLabel19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseExited
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-culminar-grey.png"))); // NOI18N
    }//GEN-LAST:event_jLabel19MouseExited

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseEntered
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-addevent-darkblue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel17MouseEntered

    private void jLabel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseExited
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-addevent-lightblue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel17MouseExited

    private void jLabel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseExited
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-delete-lightblue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel18MouseExited

    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-delete-darkblue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel18MouseEntered

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        try{
            if(nuevo){
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                helper.eliminarObjeto(calen);
                helper.confirmarTransaccion();
                helper.cerrarSesion();
                JOptionPane.showMessageDialog(null, "Evento Eliminado");
                dispose();
            }
        }catch(Exception io){
        }
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseEntered
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-eliminar-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel20MouseEntered

    private void jLabel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseExited
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-eliminar-grey.png"))); // NOI18N
    }//GEN-LAST:event_jLabel20MouseExited

    public Login getEmpl() {
        return empl;
    }

    public void setEmpl(Login empl) {
        this.empl = empl;
    }
    
    public boolean validacion(){
        
    return true;
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(calendarnew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(calendarnew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(calendarnew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(calendarnew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                calendarnew dialog = new calendarnew(new javax.swing.JFrame(),null, true,null,null,null,null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cm1;
    private javax.swing.JCheckBox cm10;
    private javax.swing.JCheckBox cm2;
    private javax.swing.JCheckBox cm3;
    private javax.swing.JCheckBox cm4;
    private javax.swing.JCheckBox cm5;
    private javax.swing.JCheckBox cm6;
    private javax.swing.JCheckBox cm7;
    private javax.swing.JCheckBox cm8;
    private javax.swing.JCheckBox cm9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox12;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox8;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
