/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.sic_rrhh;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import rrhh.Entidad.Empleado;
import rrhh.servicio.ServiceHb;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import rrhh.Entidad.Bono;
import rrhh.Entidad.Comisiones;
import rrhh.Entidad.Horas;
import rrhh.Entidad.Multa;
import rrhh.Entidad.Prestamos;

/**
 *
 * @author Matheus
 */
public final class ver_multas extends javax.swing.JPanel {
    Dimension d;
    Empleado emp;
    int turno=1;
    /**
     * Creates new form inicio
     */
    public ver_multas() {
        initComponents();
        d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width-100, d.height-61);
        jTabbedPane1.setSize(d.width-200, jTabbedPane1.getHeight());
        int x=jTabbedPane1.getWidth()-50;
        int y=jTabbedPane1.getHeight()-50;
        jScrollPane1.setSize(x, y);
        jScrollPane2.setSize(x, y);
        jScrollPane3.setSize(x, y);
        jScrollPane4.setSize(x, y);
        jScrollPane5.setSize(x, y);
        jTable1.setSize(x, y);
        jTable2.setSize(x, y);
        jTable3.setSize(x, y);
        jTable4.setSize(x, y);
        jTable5.setSize(x, y);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jTable4.getTableHeader().setReorderingAllowed(false);
        jTable5.getTableHeader().setReorderingAllowed(false);
        fecha_update();
        setVisible(false);
    }
    
    public void fecha_update(){
        String[] fecha= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        jComboBox2.removeAllItems();
        jComboBox1.removeAllItems();
        Date f = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(f);
        for(int i=2013; i<2021;i++){
            jComboBox2.addItem(i);
        }
        for(int i=0; i<12;i++){
            jComboBox1.addItem(fecha[i]);
        }
        jComboBox2.setSelectedItem(calendar.get(Calendar.YEAR));
        jComboBox1.setSelectedItem(fecha[calendar.get(Calendar.MONTH)]);
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

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    public JPanel getjPanel4() {
        return jPanel4;
    }

    public void setjPanel4(JPanel jPanel4) {
        this.jPanel4 = jPanel4;
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

    public JScrollPane getjScrollPane4() {
        return jScrollPane4;
    }

    public void setjScrollPane4(JScrollPane jScrollPane4) {
        this.jScrollPane4 = jScrollPane4;
    }

    public JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    public void setjTabbedPane1(JTabbedPane jTabbedPane1) {
        this.jTabbedPane1 = jTabbedPane1;
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

    public JTable getjTable3() {
        return jTable3;
    }

    public void setjTable3(JTable jTable3) {
        this.jTable3 = jTable3;
    }

    public JTable getjTable4() {
        return jTable4;
    }

    public void setjTable4(JTable jTable4) {
        this.jTable4 = jTable4;
    }

    public JPanel getjPanel5() {
        return jPanel5;
    }

    public void setjPanel5(JPanel jPanel5) {
        this.jPanel5 = jPanel5;
    }

    public JScrollPane getjScrollPane5() {
        return jScrollPane5;
    }

    public void setjScrollPane5(JScrollPane jScrollPane5) {
        this.jScrollPane5 = jScrollPane5;
    }

    public JTable getjTable5() {
        return jTable5;
    }

    public void setjTable5(JTable jTable5) {
        this.jTable5 = jTable5;
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setEnabled(false);
        setLayout(null);

        jButton1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jButton1.setText("Ver Multas");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(510, 20, 110, 30);

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel1.setText("Fecha:");
        add(jLabel1);
        jLabel1.setBounds(660, 20, 60, 30);

        jComboBox1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        add(jComboBox1);
        jComboBox1.setBounds(730, 20, 150, 30);

        jComboBox2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        add(jComboBox2);
        jComboBox2.setBounds(890, 20, 90, 30);

        jPanel1.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Empleado", "Asunto", "Descripcion", "Fecha", "Tiempo", "Valor", "Aprobado", "Responsable", "Aprobar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, true, false, false, false
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

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(8, 5, 920, 470);

        jTabbedPane1.addTab("Reposiciones", jPanel1);

        jPanel2.setLayout(null);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Empleado", "Tipo", "Asunto", "Descripcion", "Fecha", "Valor", "Aprobacion", "Responsable", "Aprobar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowHeight(24);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(8, 5, 920, 470);

        jTabbedPane1.addTab("Multas", jPanel2);

        jPanel3.setLayout(null);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Empleado", "Asunto", "Descripcion", "Fecha", "Valor", "Aprobacion", "Responsable", "Aprobar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setRowHeight(24);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(8, 5, 920, 470);

        jTabbedPane1.addTab("Bonos", jPanel3);

        jPanel4.setLayout(null);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Empleado", "Asunto", "Descripcion", "Fecha", "Valor", "Aprobacion", "Responsable", "Aprobar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setRowHeight(24);
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jPanel4.add(jScrollPane4);
        jScrollPane4.setBounds(8, 5, 920, 470);

        jTabbedPane1.addTab("Prestamos", jPanel4);

        jPanel5.setLayout(null);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Empleado", "Asunto", "Descripcion", "Fecha", "Valor", "Aprobacion", "Responsable", "Aprobar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable5.setRowHeight(24);
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable5);

        jPanel5.add(jScrollPane5);
        jScrollPane5.setBounds(8, 5, 920, 470);

        jTabbedPane1.addTab("Comisiones", jPanel5);

        add(jTabbedPane1);
        jTabbedPane1.setBounds(30, 70, 950, 510);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try{
            String mes=jComboBox1.getSelectedItem().toString();
            String anio=jComboBox2.getSelectedItem().toString();
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            List<Multa> multas =helper.getMultamesByTipo2(mes,anio);
            List<Horas> horas =helper.getHorasmesByTipo2(mes, anio);
            List<Bono> bono =helper.getBonomesByTipo2(mes, anio);
            List<Prestamos> prestamos =helper.getPrestamosmesByTipo2(mes, anio);
            
            DefaultTableModel temp = (DefaultTableModel) jTable1.getModel();
            for(int i=temp.getRowCount()-1;i>=0;i--){
               temp.removeRow(i);
            }
            
            DefaultTableModel temp2 = (DefaultTableModel) jTable2.getModel();
            for(int i=temp2.getRowCount()-1;i>=0;i--){
               temp2.removeRow(i);
            }
            
            DefaultTableModel temp3 = (DefaultTableModel) jTable3.getModel();
            for(int i=temp3.getRowCount()-1;i>=0;i--){
               temp3.removeRow(i);
            }
            
            DefaultTableModel temp4 = (DefaultTableModel) jTable4.getModel();
            for(int i=temp4.getRowCount()-1;i>=0;i--){
               temp4.removeRow(i);
            }
            
            if(multas!=null){
            int i=0;
            for(Multa x: multas){
                if(jTable2.getRowCount()< multas.size()){
                    DefaultTableModel tempa = (DefaultTableModel) jTable2.getModel();
                    Object nuevo[]= {tempa.getRowCount()+1,"",""};
                    tempa.addRow(nuevo);
                }
                Empleado empleado=(Empleado)helper.obtenerObjeto(Empleado.class, Integer.parseInt(x.getCi()));
                String nombre= empleado.getNombre1()+" "+empleado.getNombre2()+" "+empleado.getApellido1()+" "+empleado.getApellido2();
                jTable2.getModel().setValueAt(nombre, i, 0);
                if(x.getTipo().equalsIgnoreCase("FC")){
                    jTable2.getModel().setValueAt("F. Inj. - Av. con T.", i, 1);
                }else
                if(x.getTipo().equalsIgnoreCase("FS")){
                    jTable2.getModel().setValueAt("F. Inj. - Av. sin T.", i, 1);
                }else
                if(x.getTipo().equalsIgnoreCase("F")){
                    jTable2.getModel().setValueAt("F. Inj. - No Avisó", i, 1);
                }else
                if(x.getTipo().equalsIgnoreCase("FL")){
                    jTable2.getModel().setValueAt("F. R.I. - Leve", i, 1);
                }else
                if(x.getTipo().equalsIgnoreCase("FM")){
                    jTable2.getModel().setValueAt("F. R.I. - Media", i, 1);
                }else
                if(x.getTipo().equalsIgnoreCase("FG")){
                    jTable2.getModel().setValueAt("F. R.I. - Grave", i, 1);
                }else
                if(x.getTipo().equalsIgnoreCase("A")){
                    jTable2.getModel().setValueAt("Atraso - Avisó", i, 1);
                }else
                if(x.getTipo().equalsIgnoreCase("AS")){
                    jTable2.getModel().setValueAt("Atraso - No Avisó", i, 1);
                }else
                if(x.getTipo().equalsIgnoreCase("O")){
                    jTable2.getModel().setValueAt("Otros", i, 1);
                }else{
                    jTable2.getModel().setValueAt(x.getTipo(), i, 1);
                }
                
                if(x.getTipo().equalsIgnoreCase("A")||(x.getTipo().equalsIgnoreCase("AS"))){
                    jTable2.getModel().setValueAt(x.getMotivo()+" minutos de atraso", i, 2);
                }else{
                    jTable2.getModel().setValueAt(x.getMotivo(), i, 2);
                }
                jTable2.getModel().setValueAt(x.getObservacion() , i, 3);
                jTable2.getModel().setValueAt(x.getFecha(), i, 4);
                if(x.getAccion()!=null){
                    if(x.getAccion().equalsIgnoreCase("A")){
                        jTable2.getModel().setValueAt(x.getValor()+" Aprobado", i, 5);
                    }else{
                        jTable2.getModel().setValueAt("No Aprobado", i, 5);
                    }
                }else{
                    jTable2.getModel().setValueAt("en Espera", i, 5);
                }
                jTable2.getModel().setValueAt(x.getResponsable(), i, 6);
                i++;
                }
            }
            if(horas!=null){
            int i=0;    
            for(Horas x: horas){
                if(jTable1.getRowCount()< horas.size()){
                    DefaultTableModel tempa = (DefaultTableModel) jTable1.getModel();
                    Object nuevo[]= {tempa.getRowCount()+1,"",""};
                    tempa.addRow(nuevo);
                }
                Empleado empleado=(Empleado)helper.obtenerObjeto(Empleado.class, Integer.parseInt(x.getCi()));
                String nombre= empleado.getNombre1()+" "+empleado.getNombre2()+" "+empleado.getApellido1()+" "+empleado.getApellido2();
                jTable1.getModel().setValueAt(nombre, i, 0);
                jTable1.getModel().setValueAt(x.getMotivo(), i, 1);
                jTable1.getModel().setValueAt(x.getObservacion() , i, 2);
                jTable1.getModel().setValueAt(x.getFecha(), i, 3);
                jTable1.getModel().setValueAt(x.getTiempo(), i, 4);
                if(x.getAccion()!=null){
                    if(x.getAccion().equalsIgnoreCase("A")){
                        jTable1.getModel().setValueAt(x.getValor()+" Aprobado", i, 5);
                    }else{
                        jTable1.getModel().setValueAt("No Aprobado", i, 5);
                    }
                }else{
                    jTable1.getModel().setValueAt("en Espera", i, 5);
                }
                jTable1.getModel().setValueAt(x.getResponsable(), i, 6);
                i++;    
            }    
            }
            if(bono!=null){
            int i=0;    
            for(Bono x: bono){
                if(jTable3.getRowCount()< bono.size()){
                    DefaultTableModel tempa = (DefaultTableModel) jTable3.getModel();
                    Object nuevo[]= {tempa.getRowCount()+1,"",""};
                    tempa.addRow(nuevo);
                }
                Empleado empleado=(Empleado)helper.obtenerObjeto(Empleado.class, Integer.parseInt(x.getCi()));
                String nombre= empleado.getNombre1()+" "+empleado.getNombre2()+" "+empleado.getApellido1()+" "+empleado.getApellido2();
                jTable3.getModel().setValueAt(nombre, i, 0);
                jTable3.getModel().setValueAt(x.getMotivo(), i, 1);
                jTable3.getModel().setValueAt(x.getObservacion() , i, 2);
                jTable3.getModel().setValueAt(x.getFecha(), i, 3);
                if(x.getAccion()!=null){
                    if(x.getAccion().equalsIgnoreCase("A")){
                        jTable3.getModel().setValueAt(x.getValor()+" Aprobado", i, 4);
                    }else{
                        jTable3.getModel().setValueAt("No Aprobado", i, 4);
                    }
                }else{
                    jTable3.getModel().setValueAt("en Espera", i, 4);
                }
                jTable3.getModel().setValueAt(x.getResponsable(), i, 5);
                i++;
            }
                
            }
            if(prestamos!=null){
            int i=0;    
            for(Prestamos x: prestamos){
                if(jTable4.getRowCount()< prestamos.size()){
                    DefaultTableModel tempa = (DefaultTableModel) jTable4.getModel();
                    Object nuevo[]= {tempa.getRowCount()+1,"",""};
                    tempa.addRow(nuevo);
                }
                Empleado empleado=(Empleado)helper.obtenerObjeto(Empleado.class, Integer.parseInt(x.getCi()));
                String nombre= empleado.getNombre1()+" "+empleado.getNombre2()+" "+empleado.getApellido1()+" "+empleado.getApellido2();
                jTable4.getModel().setValueAt(nombre, i, 0);
                jTable4.getModel().setValueAt(x.getMotivo(), i, 1);
                jTable4.getModel().setValueAt(x.getObservacion() , i, 2);
                jTable4.getModel().setValueAt(x.getFecha(), i, 3);
                if(x.getAccion()!=null){
                    if(x.getAccion().equalsIgnoreCase("A")){
                        jTable4.getModel().setValueAt(x.getValor()+" Aprobado", i, 4);
                    }else{
                        jTable4.getModel().setValueAt("No Aprobado", i, 4);
                    }
                }else{
                    jTable4.getModel().setValueAt("en Espera", i, 4);
                }
                jTable4.getModel().setValueAt(x.getResponsable(), i, 5);
                i++;    
            }
                
            }
            helper.cerrarSesion();
            
        }
        catch(Exception io){
            
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        JTable table = jTable1;
        int row= table.getSelectedRow();
        int col=table.getSelectedColumn();
        if(col==8){
            if(!table.getValueAt(row, col-2).toString().equalsIgnoreCase("SI")){
                try {
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    Horas h = (Horas)table.getValueAt(row, col);
                    h.setValor(table.getValueAt(row, col-3).toString());
                    h.setAccion("A");
                    helper.actualizarObjeto(h);
                    helper.confirmarTransaccion();
                    helper.cerrarSesion();
                    table.setValueAt("SI", row, col-2);
                    JOptionPane.showMessageDialog(null,"Hora Aprobada");
                }catch(Exception io){

                }
            }else{
                try {
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    Horas h = (Horas)table.getValueAt(row, col);
                    h.setAccion("Q");
                    helper.actualizarObjeto(h);
                    helper.confirmarTransaccion();
                    helper.cerrarSesion();
                    table.setValueAt("NO", row, col-2);
                    JOptionPane.showMessageDialog(null,"Hora No Aprobada");
                }catch(Exception io){

                }
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        JTable table = jTable2;
        int row= table.getSelectedRow();
        int col=table.getSelectedColumn();
        if(col==8){
            //            String selectedSiteName = JOptionPane.showInputDialog(null,"Aprobar (A) / Desaprobar (D)");
            if(!table.getValueAt(row, col-2).toString().equalsIgnoreCase("SI")){
                try {
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    Multa h = (Multa)table.getValueAt(row, col);
                    h.setValor(table.getValueAt(row, col-3).toString());
                    h.setAccion("A");
                    helper.actualizarObjeto(h);
                    helper.confirmarTransaccion();
                    helper.cerrarSesion();
                    table.setValueAt("SI", row, col-2);
                    JOptionPane.showMessageDialog(null,"Multa Aprobada");
                }catch(Exception io){

                }
            }
            else{
                try {
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    Multa h = (Multa)table.getValueAt(row, col);
                    h.setAccion("Q");
                    helper.actualizarObjeto(h);
                    helper.confirmarTransaccion();
                    helper.cerrarSesion();
                    table.setValueAt("NO", row, col-2);
                    JOptionPane.showMessageDialog(null,"Multa No Aprobada");
                }catch(Exception io){

                }
            }
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        JTable table = jTable3;
        int row= table.getSelectedRow();
        int col=table.getSelectedColumn();
        if(col==7){
            //            String selectedSiteName = JOptionPane.showInputDialog(null,"Aprobar (A) / Desaprobar (D)");
            if(!table.getValueAt(row, col-2).toString().equalsIgnoreCase("SI")){
                try {
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    Bono h = (Bono)table.getValueAt(row, col);
                    h.setValor(table.getValueAt(row, col-3).toString());
                    h.setAccion("A");
                    helper.actualizarObjeto(h);
                    helper.confirmarTransaccion();
                    helper.cerrarSesion();
                    table.setValueAt("SI", row, col-2);
                    JOptionPane.showMessageDialog(null,"Bono Aprobado");
                }catch(Exception io){

                }
            }else{
                try {
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    Bono h = (Bono)table.getValueAt(row, col);
                    h.setAccion("Q");
                    helper.actualizarObjeto(h);
                    helper.confirmarTransaccion();
                    helper.cerrarSesion();
                    table.setValueAt("NO", row, col-2);
                    JOptionPane.showMessageDialog(null,"Bono No Aprobado");
                }catch(Exception io){

                }
            }
        }
    }//GEN-LAST:event_jTable3MouseClicked

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        JTable table = jTable4;
        int row= table.getSelectedRow();
        int col=table.getSelectedColumn();
        if(col==7){
            //            String selectedSiteName = JOptionPane.showInputDialog(null,"Aprobar (A) / Desaprobar (D)");
            if(!table.getValueAt(row, col-2).toString().equalsIgnoreCase("SI")){
                try {
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    Prestamos h = (Prestamos)table.getValueAt(row, col);
                    h.setValor(table.getValueAt(row, col-3).toString());
                    h.setAccion("A");
                    helper.actualizarObjeto(h);
                    helper.confirmarTransaccion();
                    helper.cerrarSesion();
                    table.setValueAt("SI", row, col-2);
                    JOptionPane.showMessageDialog(null,"Prestamos Aprobado");
                }catch(Exception io){

                }
            }else{
                try {
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    Prestamos h = (Prestamos)table.getValueAt(row, col);
                    h.setAccion("Q");
                    helper.actualizarObjeto(h);
                    helper.confirmarTransaccion();
                    helper.cerrarSesion();
                    table.setValueAt("NO", row, col-2);
                    JOptionPane.showMessageDialog(null,"Prestamos No Aprobado");
                }catch(Exception io){

                }
            }
        }
        if(col==2){
            JOptionPane.showMessageDialog(null, table.getValueAt(row, col));
        }
    }//GEN-LAST:event_jTable4MouseClicked

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        JTable table = jTable5;
        int row= table.getSelectedRow();
        int col=table.getSelectedColumn();
        if(col==7){
            //            String selectedSiteName = JOptionPane.showInputDialog(null,"Aprobar (A) / Desaprobar (D)");
            if(!table.getValueAt(row, col-2).toString().equalsIgnoreCase("SI")){
                try {
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    Comisiones h = (Comisiones)table.getValueAt(row, col);
                    h.setValor(table.getValueAt(row, col-3).toString());
                    h.setAccion("A");
                    helper.actualizarObjeto(h);
                    helper.confirmarTransaccion();
                    helper.cerrarSesion();
                    table.setValueAt("SI", row, col-2);
                    JOptionPane.showMessageDialog(null,"Comision Aprobado");
                }catch(Exception io){

                }
            }else{
                try {
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    Comisiones h = (Comisiones)table.getValueAt(row, col);
                    h.setAccion("Q");
                    helper.actualizarObjeto(h);
                    helper.confirmarTransaccion();
                    helper.cerrarSesion();
                    table.setValueAt("NO", row, col-2);
                    JOptionPane.showMessageDialog(null,"Comision No Aprobado");
                }catch(Exception io){

                }
            }
        }
        if(col==2){
            JOptionPane.showMessageDialog(null, table.getValueAt(row, col));
        }
    }//GEN-LAST:event_jTable5MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    // End of variables declaration//GEN-END:variables
}
