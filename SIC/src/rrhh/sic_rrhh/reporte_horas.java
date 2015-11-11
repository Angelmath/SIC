/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.sic_rrhh;

import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import rrhh.Entidad.Departamento;
import rrhh.Entidad.Empleado;
import rrhh.Entidad.Horas;
import rrhh.servicio.ServiceHb;

/**
 *
 * @author Matheus
 */
public final class reporte_horas extends javax.swing.JPanel {
    Dimension d;
    Empleado emp;
    int turno=1;
    boolean temporal=false;
    String nivel;
    boolean trampa=false;
    boolean trampa2=false;
    /**
     * Creates new form inicio
     */
    public reporte_horas() {
        initComponents();
        d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width-100, d.height-61);
        jScrollPane8.setSize(d.width-100, d.height-61-80);
        jPanel9.setSize(d.width-100, d.height-61-80);
        fecha_update();
        setVisible(false);
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
    public void llenar(){
        if(!temporal){
            ServiceHb helper=null;
            try{
                helper = new ServiceHb();
                helper.iniciarTransaccion();
                List<Horas> hor = helper.getHorasByTipo((jLabel1.getText()));
                helper.cerrarSesion();
                temporal= true;
                JTable tabla = jTable1;
                
                DefaultTableModel temp = (DefaultTableModel) tabla.getModel();
                for(int i=temp.getRowCount()-1;i>=0;i--){
                    temp.removeRow(i);
                }
                int i=0;
                if(hor!=null){
                    for(Horas x: hor){
                        if(temporal){
                            if(tabla.getRowCount()< hor.size()){
                                DefaultTableModel tempa = (DefaultTableModel) tabla.getModel();
                                Object nuevo[]= {tempa.getRowCount()+1,"",""};
                                tempa.addRow(nuevo);
                            }
                            tabla.getModel().setValueAt(x.getMotivo(), i, 0);
                            tabla.getModel().setValueAt(x.getObservacion(), i, 1);
                            tabla.getModel().setValueAt(x.getFecha(), i, 2);
                            tabla.getModel().setValueAt(x.getTiempo(), i, 3);
                            tabla.getModel().setValueAt(x.getAnio()+" "+x.getMes(), i, 4);
                            if(x.getAccion()!=null){
                                if(x.getAccion().equalsIgnoreCase("A")){
                                    tabla.getModel().setValueAt(x.getValor()+" Aprobado", i, 5);
                                }else{
                                    tabla.getModel().setValueAt("No Aprobado", i, 5);
                                }
                            }else{
                                tabla.getModel().setValueAt("en Espera", i, 5);
                            }
                            tabla.getModel().setValueAt(x.getResponsable(), i, 6);
                            tabla.getModel().setValueAt(x.getId(), i, 7);
                            i++;
                        }else{
                            break;
                        }
                    }
                }
                
                
                temporal=false;
            }catch(Exception io){
            
            }
        }
    }
    
    public void actualizar(){
        reporteempleados per = new reporteempleados(1);
        per.start();
    }
    
    public void actualizarbusqueda(){
        reporteempleados per = new reporteempleados(2);
        per.start();
    }
    
    public void fecha_update(){
        String[] fecha= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        jComboBox5.removeAllItems();
        jComboBox6.removeAllItems();
        Date f = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(f);
        for(int i=2013; i<2021;i++){
            jComboBox5.addItem(i);
        }
        for(int i=0; i<12;i++){
            jComboBox6.addItem(fecha[i]);
        }
        jComboBox5.setSelectedItem(calendar.get(Calendar.YEAR));
        jComboBox6.setSelectedItem(fecha[calendar.get(Calendar.MONTH)]);
    }
    
    public void llenartablasselect(JComboBox combo, JTable tabla, JTextField texto){
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            List<Empleado> empleados=null;
            if(combo.getSelectedItem().toString().equalsIgnoreCase("ALL")){
                empleados = helper.getPersonasByTipoespecial(texto.getText());
            }else{
                empleados = helper.getPersonasByTipoespecialbusqueda(combo.getSelectedItem().toString(),texto.getText());
            }
            DefaultTableModel temp = (DefaultTableModel) tabla.getModel();
            for(int i=temp.getRowCount()-1;i>=0;i--){
                temp.removeRow(i);
            }
            DefaultTableModel tempa = (DefaultTableModel) tabla.getModel();
            if(empleados!=null){
                for (Empleado empleado : empleados) {
                    if(trampa){
                        trampa=!trampa;
                        helper.cerrarSesion();
                        break;
                    }
                    String campo1 = (empleado.getCid());
                    String campo2 = empleado.getNombre1() + " " + empleado.getNombre2() + " " + empleado.getApellido1() + " " + empleado.getApellido2();
                    String campo3 = empleado.getDeptEmpl().getDepartamento().getNombre();
                    Object nuevo[]= {campo1,campo2,campo3,campo1};
                    tempa.addRow(nuevo);
                }
            }
            helper.cerrarSesion();
        }
        catch(Exception io){
            
        }
    }
    
    public void llenartablas(){
        try{
            if(nivel.equalsIgnoreCase("Seguridad")){
                getjComboBox3().removeAllItems();
                getjComboBox3().addItem("Seguridad Fisica");
                actualizarbusqueda();
            }else{
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                List<Departamento> dept = helper.getdepartamentosByTipo();

                getjComboBox3().removeAllItems();

                getjComboBox3().addItem("ALL");

                for(Departamento i: dept){
                    getjComboBox3().addItem(i.getNombre());
                }
                helper.cerrarSesion();
                actualizarbusqueda();
            }
        }
        catch(Exception io){
            
        }
    }
    
    public class reporteempleados extends Thread {
        int num;
        
        public reporteempleados(int num){
            this.num=num;
        }
        
        public void run() {
            if(num==1){
                trampa2=true;
                llenartablas();
                trampa2=false;
            }
            if(num==2){
                llenartablasselect(getjComboBox3(),getjTable2(),getjTextField2());
            }
            if(num==3){
                temporal=false;
                llenar();
            }
        }
    }
    
    public JLabel getjLabel6() {
        return jLabel6;
    }
    
    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }
    
    public JPanel getjPanel9() {
        return jPanel9;
    }
    
    public void setjPanel9(JPanel jPanel9) {
        this.jPanel9 = jPanel9;
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
    
    public JScrollPane getjScrollPane8() {
        return jScrollPane8;
    }
    
    public void setjScrollPane8(JScrollPane jScrollPane8) {
        this.jScrollPane8 = jScrollPane8;
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
    
    public JTextField getjTextField4() {
        return jTextField4;
    }
    
    public void setjTextField4(JTextField jTextField4) {
        this.jTextField4 = jTextField4;
    }
    
    public JTextField getjTextField5() {
        return jTextField5;
    }
    
    public void setjTextField5(JTextField jTextField5) {
        this.jTextField5 = jTextField5;
    }
    
    public JComboBox getjComboBox3() {
        return jComboBox3;
    }
    
    public void setjComboBox3(JComboBox jComboBox3) {
        this.jComboBox3 = jComboBox3;
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
    
    public JDateChooser getjDateChooser1() {
        return jDateChooser1;
    }
    
    public void setjDateChooser1(JDateChooser jDateChooser1) {
        this.jDateChooser1 = jDateChooser1;
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
    
    public JLabel getjLabel14() {
        return jLabel14;
    }
    
    public void setjLabel14(JLabel jLabel14) {
        this.jLabel14 = jLabel14;
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
    
    public JLabel getjLabel5() {
        return jLabel5;
    }
    
    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }
    
    public Dimension getD() {
        return d;
    }
    
    public void setD(Dimension d) {
        this.d = d;
    }
    
    public Empleado getEmp() {
        return emp;
    }
    
    public void setEmp(Empleado emp) {
        this.emp = emp;
    }
    
    public int getTurno() {
        return turno;
    }
    
    public void setTurno(int turno) {
        this.turno = turno;
    }
    
    public JButton getjButton1() {
        return jButton1;
    }
    
    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane8 = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jComboBox5 = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jComboBox6 = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setEnabled(false);
        setLayout(null);

        jScrollPane8.setBorder(null);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Asunto", "Descripcion", "Fecha Asunto", "Tiempo", "Fecha Sistema", "Valor", "Responsable", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(24);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButton1.setText("Agregar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        jComboBox5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel16.setText("Año:");

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel14.setText("Tiempo(min):");

        jComboBox6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel15.setText("Empleado:");

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel5.setText("Fecha:");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel13.setText("Descripcion:");

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel12.setText("Asunto:");

        jTextField4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jTable2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CI", "Nombre", "Departamento", "id"
            }
        ));
        jTable2.setRowHeight(24);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMaxWidth(140);
            jTable2.getColumnModel().getColumn(3).setMinWidth(0);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(0);
            jTable2.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        jTextField2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
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

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel6.setText("Busqueda:");

        jComboBox3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });
        jComboBox3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jComboBox3MouseReleased(evt);
            }
        });
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel17.setText("Mes:");

        jTextField5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setOpaque(true);
        jLabel1.setVisible(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(424, 424, 424)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1060, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(150, 150, 150)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(510, 510, 510)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(20, 20, 20)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane8.setViewportView(jPanel9);

        add(jScrollPane8);
        jScrollPane8.setBounds(0, 0, 1170, 540);
    }// </editor-fold>//GEN-END:initComponents
    
    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        
    }//GEN-LAST:event_jComboBox3ActionPerformed
    
    private void jComboBox3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox3MouseReleased
        
    }//GEN-LAST:event_jComboBox3MouseReleased
    
    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
        if(!trampa2){
            actualizarbusqueda();
        }
    }//GEN-LAST:event_jComboBox3ItemStateChanged
    
    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int row = jTable2.rowAtPoint(evt.getPoint());
        jTextField4.setText(jTable2.getValueAt(row, 1).toString());
        jLabel1.setText(jTable2.getValueAt(row, 3).toString()); 
        reporteempleados per = new reporteempleados(3);
        per.start();
    }//GEN-LAST:event_jTable2MouseClicked
    
    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        
    }//GEN-LAST:event_jTextField2ActionPerformed
    
    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased

    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        char caracter = evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)
             ){
            /* lo que deseo colocar aqui es si ya se pulso el caracter (.) el mismo no se pueda repetir*/
            evt.consume();
            
        }
    }//GEN-LAST:event_jTextField3KeyTyped

    public boolean isTemporal() {
        return temporal;
    }

    public void setTemporal(boolean temporal) {
        this.temporal = temporal;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        if(evt.getKeyChar()=='\n') {
            actualizarbusqueda();        // TODO add your handling code here:
        }
    }//GEN-LAST:event_jTextField2KeyTyped
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
