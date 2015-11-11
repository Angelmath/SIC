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
import rrhh.Entidad.Multa;
import rrhh.servicio.ServiceHb;

/**
 *
 * @author Matheus
 */
public final class reporte_multa extends javax.swing.JPanel {
    Dimension d;
    Empleado emp;
    int turno=1;
    boolean temporal=false;
    boolean trampa=false;
    boolean trampa2=false;
    String nivel;
    /**
     * Creates new form inicio
     */
    public reporte_multa() {
        initComponents();
        d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width-100, d.height-61);
        jScrollPane8.setSize(d.width-100, d.height-61-80);
        jPanel10.setSize(d.width-100, d.height-61-80);
        jLabel26.setLocation(jLabel28.getLocation());
        jTextField7.setLocation(jTextField10.getLocation());
        fecha_update();
        setVisible(false);
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
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
    public void actualizar(){
        reporteempleados per = new reporteempleados(1);
        per.start();
    }
    
    public void actualizarbusqueda(){
        reporteempleados per = new reporteempleados(2);
        per.start();
    }
    public void llenartablas(){
        try{
            if(nivel.equalsIgnoreCase("Seguridad")){
                getjComboBox10().removeAllItems();
                getjComboBox10().addItem("Seguridad Fisica");
            }else{
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                List<Departamento> dept = helper.getdepartamentosByTipo();

                getjComboBox10().removeAllItems();

                getjComboBox10().addItem("ALL");

                for(Departamento i: dept){
                    getjComboBox10().addItem(i.getNombre());
                }
                helper.cerrarSesion();
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
            llenartablasselect(getjComboBox10(),getjTable5(),getjTextField9());
            }
            if(num==3){
                temporal=false;
                llenar();
            }
        }
      }
    
    
    public void llenar(){
        if(!temporal){
            ServiceHb helper=null;
            try{
                helper = new ServiceHb();
                helper.iniciarTransaccion();
                List<Multa> hor = helper.getMultaByTipo((jLabel2.getText()));
                helper.cerrarSesion();
                temporal= true;
                JTable tabla = jTable4;
                
                DefaultTableModel temp = (DefaultTableModel) tabla.getModel();
                for(int i=temp.getRowCount()-1;i>=0;i--){
                    temp.removeRow(i);
                }
                int i=0;
                if(hor!=null){
                    for(Multa x: hor){
                        if(temporal){
                            if(tabla.getRowCount()< hor.size()){
                                DefaultTableModel tempa = (DefaultTableModel) tabla.getModel();
                                Object nuevo[]= {tempa.getRowCount()+1,"",""};
                                tempa.addRow(nuevo);
                            }
                            if(x.getTipo().equalsIgnoreCase("FC")){
                                tabla.getModel().setValueAt("F. Inj. - Av. con T.", i, 0);
                            }else
                            if(x.getTipo().equalsIgnoreCase("FS")){
                                tabla.getModel().setValueAt("F. Inj. - Av. sin T.", i, 0);
                            }else
                            if(x.getTipo().equalsIgnoreCase("F")){
                                tabla.getModel().setValueAt("F. Inj. - No Avisó", i, 0);
                            }else
                            if(x.getTipo().equalsIgnoreCase("FL")){
                                tabla.getModel().setValueAt("F. R.I. - Leve", i, 0);
                            }else
                            if(x.getTipo().equalsIgnoreCase("FM")){
                                tabla.getModel().setValueAt("F. R.I. - Media", i, 0);
                            }else
                            if(x.getTipo().equalsIgnoreCase("FG")){
                                tabla.getModel().setValueAt("F. R.I. - Grave", i, 0);
                            }else
                            if(x.getTipo().equalsIgnoreCase("A")){
                                tabla.getModel().setValueAt("Atraso - Avisó", i, 0);
                            }else
                            if(x.getTipo().equalsIgnoreCase("AS")){
                                tabla.getModel().setValueAt("Atraso - No Avisó", i, 0);
                            }else
                            if(x.getTipo().equalsIgnoreCase("O")){
                                tabla.getModel().setValueAt("Otros", i, 0);
                            }else{
                                tabla.getModel().setValueAt(x.getTipo(), i, 0);
                            }
                            
                            
                            if(x.getTipo().equalsIgnoreCase("A")||(x.getTipo().equalsIgnoreCase("AS"))){
                                tabla.getModel().setValueAt(x.getMotivo()+" minutos de atraso", i, 1);
                            }else{
                                tabla.getModel().setValueAt(x.getMotivo(), i, 1);
                            }
                            
                            tabla.getModel().setValueAt(x.getObservacion(), i, 2);
                            tabla.getModel().setValueAt(x.getFecha(), i, 3);
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
    
    
    public Dimension getD() {
        return d;
    }

    public JButton getjButton3() {
        return jButton3;
    }

    public void setjButton3(JButton jButton3) {
        this.jButton3 = jButton3;
    }

    public JComboBox getjComboBox10() {
        return jComboBox10;
    }

    public void setjComboBox10(JComboBox jComboBox10) {
        this.jComboBox10 = jComboBox10;
    }

    public JComboBox getjComboBox14() {
        return jComboBox14;
    }

    public void setjComboBox14(JComboBox jComboBox14) {
        this.jComboBox14 = jComboBox14;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel25() {
        return jLabel25;
    }

    public void setjLabel25(JLabel jLabel25) {
        this.jLabel25 = jLabel25;
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

    public JPanel getjPanel10() {
        return jPanel10;
    }

    public void setjPanel10(JPanel jPanel10) {
        this.jPanel10 = jPanel10;
    }

    public JScrollPane getjScrollPane5() {
        return jScrollPane5;
    }

    public void setjScrollPane5(JScrollPane jScrollPane5) {
        this.jScrollPane5 = jScrollPane5;
    }

    public JScrollPane getjScrollPane7() {
        return jScrollPane7;
    }

    public void setjScrollPane7(JScrollPane jScrollPane7) {
        this.jScrollPane7 = jScrollPane7;
    }

    public JScrollPane getjScrollPane9() {
        return jScrollPane9;
    }

    public void setjScrollPane9(JScrollPane jScrollPane9) {
        this.jScrollPane9 = jScrollPane9;
    }

    public JTable getjTable4() {
        return jTable4;
    }

    public void setjTable4(JTable jTable4) {
        this.jTable4 = jTable4;
    }

    public JTable getjTable5() {
        return jTable5;
    }

    public void setjTable5(JTable jTable5) {
        this.jTable5 = jTable5;
    }

    public JTextArea getjTextArea3() {
        return jTextArea3;
    }

    public void setjTextArea3(JTextArea jTextArea3) {
        this.jTextArea3 = jTextArea3;
    }

    public JTextField getjTextField7() {
        return jTextField7;
    }

    public void setjTextField7(JTextField jTextField7) {
        this.jTextField7 = jTextField7;
    }

    public JTextField getjTextField9() {
        return jTextField9;
    }

    public void setjTextField9(JTextField jTextField9) {
        this.jTextField9 = jTextField9;
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


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane8 = new javax.swing.JScrollPane();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jComboBox14 = new javax.swing.JComboBox();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jTextField9 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jComboBox10 = new javax.swing.JComboBox();
        jTextField8 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox();
        jComboBox5 = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jComboBox15 = new javax.swing.JComboBox();
        jTextField10 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setEnabled(false);
        setLayout(null);

        jScrollPane8.setBorder(null);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(960, 740));

        jTable4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Asunto", "Descripcion", "Fecha Asunto", "Fecha Sistema", "Valor", "Responsable", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setRowHeight(24);
        jScrollPane7.setViewportView(jTable4);

        jButton3.setText("Agregar");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextArea3.setRows(5);
        jScrollPane5.setViewportView(jTextArea3);

        jLabel1.setText("Tipo:");

        jTextField7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel25.setText("Descripcion:");

        jLabel26.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel26.setText("Tiempo(min):");

        jComboBox14.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aviso con Tiempo", "Aviso sin Tiempo", "Sin Avisar" }));

        jTable5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CI", "Nombre", "Departamento", "id"
            }
        ));
        jTable5.setRowHeight(24);
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jTable5);
        if (jTable5.getColumnModel().getColumnCount() > 0) {
            jTable5.getColumnModel().getColumn(3).setMinWidth(0);
            jTable5.getColumnModel().getColumn(3).setPreferredWidth(0);
            jTable5.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        jTextField9.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField9KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField9KeyTyped(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel27.setText("Busqueda:");

        jComboBox10.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ALL" }));
        jComboBox10.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox10ItemStateChanged(evt);
            }
        });
        jComboBox10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox10MouseClicked(evt);
            }
        });

        jTextField8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel32.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel32.setText("Empleado:");

        jLabel17.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel17.setText("Mes:");

        jComboBox6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jComboBox5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel16.setText("Año:");

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel5.setText("Fecha:");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setOpaque(true);
        jLabel2.setVisible(false);

        jComboBox15.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Falta Injustificadas", "Falta Reglamento Interno", "Atrasos", "Otros" }));
        jComboBox15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox15ActionPerformed(evt);
            }
        });

        jTextField10.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel28.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel28.setText("Asunto:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(160, 160, 160)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jComboBox15, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jComboBox14, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(457, 457, 457)
                            .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addGap(470, 470, 470)
                            .addComponent(jButton3))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jButton3)
                .addGap(17, 17, 17)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTextField7.setVisible(false);
        jLabel26.setVisible(false);

        jScrollPane8.setViewportView(jPanel10);

        add(jScrollPane8);
        jScrollPane8.setBounds(0, 0, 1170, 540);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        int row = jTable5.rowAtPoint(evt.getPoint());
        jTextField8.setText(jTable5.getValueAt(row, 1).toString());
        jLabel2.setText(jTable5.getValueAt(row, 3).toString()); 
        reporteempleados per = new reporteempleados(3);
        per.start();
    }//GEN-LAST:event_jTable5MouseClicked

    public boolean isTemporal() {
        return temporal;
    }

    public void setTemporal(boolean temporal) {
        this.temporal = temporal;
    }

    public JComboBox getjComboBox15() {
        return jComboBox15;
    }

    public void setjComboBox15(JComboBox jComboBox15) {
        this.jComboBox15 = jComboBox15;
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

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel28() {
        return jLabel28;
    }

    public void setjLabel28(JLabel jLabel28) {
        this.jLabel28 = jLabel28;
    }

    public JLabel getjLabel32() {
        return jLabel32;
    }

    public void setjLabel32(JLabel jLabel32) {
        this.jLabel32 = jLabel32;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JScrollPane getjScrollPane8() {
        return jScrollPane8;
    }

    public void setjScrollPane8(JScrollPane jScrollPane8) {
        this.jScrollPane8 = jScrollPane8;
    }

    public JTextField getjTextField10() {
        return jTextField10;
    }

    public void setjTextField10(JTextField jTextField10) {
        this.jTextField10 = jTextField10;
    }

    public JTextField getjTextField8() {
        return jTextField8;
    }

    public void setjTextField8(JTextField jTextField8) {
        this.jTextField8 = jTextField8;
    }

    private void jComboBox10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox10MouseClicked

    private void jComboBox10ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox10ItemStateChanged
        if(!trampa2){
            actualizarbusqueda();
        }
    }//GEN-LAST:event_jComboBox10ItemStateChanged

    private void jTextField9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyReleased

    }//GEN-LAST:event_jTextField9KeyReleased

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        char caracter = evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)
             ){
            /* lo que deseo colocar aqui es si ya se pulso el caracter (.) el mismo no se pueda repetir*/
            evt.consume();
            
        }
    }//GEN-LAST:event_jTextField7KeyTyped

    public void cambioasunto(int num){
        if(num==1){
            jLabel28.setVisible(true);
            jTextField10.setVisible(true);
            jLabel26.setVisible(false);
            jTextField7.setVisible(false); 
        }else{
            jLabel28.setVisible(false);
            jTextField10.setVisible(false);
            jLabel26.setVisible(true);
            jTextField7.setVisible(true); 
        }
        
    }
    
    private void jComboBox15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox15ActionPerformed
        if(jComboBox15.getSelectedItem().toString().equalsIgnoreCase("Falta Injustificadas")){
            jComboBox14.removeAllItems();
            jComboBox14.addItem("Aviso con Tiempo");
            jComboBox14.addItem("Aviso sin Tiempo");
            jComboBox14.addItem("Sin Avisar");
            cambioasunto(1);
        }
        if(jComboBox15.getSelectedItem().toString().equalsIgnoreCase("Falta Reglamento Interno")){
            jComboBox14.removeAllItems();
            jComboBox14.addItem("Leve");
            jComboBox14.addItem("Media");
            jComboBox14.addItem("Grave");
            cambioasunto(1);
        }
        if(jComboBox15.getSelectedItem().toString().equalsIgnoreCase("Atrasos")){
            jComboBox14.removeAllItems();
            jComboBox14.addItem("Aviso");
            jComboBox14.addItem("No Aviso");
            cambioasunto(2);
        }
        if(jComboBox15.getSelectedItem().toString().equalsIgnoreCase("Otros")){
            jComboBox14.removeAllItems();
            cambioasunto(1);
        }
    }//GEN-LAST:event_jComboBox15ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseClicked

    private void jTextField9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyTyped
        if(evt.getKeyChar()=='\n') {
            actualizarbusqueda();        // TODO add your handling code here:
        }
    }//GEN-LAST:event_jTextField9KeyTyped
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox10;
    private javax.swing.JComboBox jComboBox14;
    private javax.swing.JComboBox jComboBox15;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
