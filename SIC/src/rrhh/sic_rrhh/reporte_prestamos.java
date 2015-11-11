/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.sic_rrhh;

import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import java.awt.Toolkit;
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
import rrhh.Entidad.Prestamos;
import rrhh.servicio.ServiceHb;

/**
 *
 * @author Matheus
 */
public final class reporte_prestamos extends javax.swing.JPanel {
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
    public reporte_prestamos() {
        initComponents();
        d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width-100, d.height-61);
        jScrollPane8.setSize(d.width-100, d.height-61-80);
        jPanel13.setSize(d.width-100, d.height-61-80);
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
        jComboBox39.removeAllItems();
        jComboBox33.removeAllItems();
        Date f = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(f);
        for(int i=2013; i<2021;i++){
            jComboBox39.addItem(i);
        }
        for(int i=0; i<12;i++){
            jComboBox33.addItem(fecha[i]);
        }
        jComboBox39.setSelectedItem(calendar.get(Calendar.YEAR));
        jComboBox33.setSelectedItem(fecha[calendar.get(Calendar.MONTH)]);
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
                    Object nuevo[]= {campo1,campo2,campo3,empleado.getCid()};
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
                getjComboBox32().removeAllItems();
                getjComboBox32().addItem("Seguridad Fisica");
            }else{
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                List<Departamento> dept = helper.getdepartamentosByTipo();

                getjComboBox32().removeAllItems();

                getjComboBox32().addItem("ALL");

                for(Departamento i: dept){
                    getjComboBox32().addItem(i.getNombre());
                }

                helper.cerrarSesion();
            }
        }
        catch(Exception io){
            
        }
    }

    public JButton getjButton11() {
        return jButton11;
    }

    public void setjButton11(JButton jButton11) {
        this.jButton11 = jButton11;
    }

    public JComboBox getjComboBox32() {
        return jComboBox32;
    }

    public void setjComboBox32(JComboBox jComboBox32) {
        this.jComboBox32 = jComboBox32;
    }

    public JComboBox getjComboBox33() {
        return jComboBox33;
    }

    public void setjComboBox33(JComboBox jComboBox33) {
        this.jComboBox33 = jComboBox33;
    }

    public JComboBox getjComboBox34() {
        return jComboBox34;
    }

    public void setjComboBox34(JComboBox jComboBox34) {
        this.jComboBox34 = jComboBox34;
    }

    public JComboBox getjComboBox39() {
        return jComboBox39;
    }

    public void setjComboBox39(JComboBox jComboBox39) {
        this.jComboBox39 = jComboBox39;
    }

    public JDateChooser getjDateChooser7() {
        return jDateChooser7;
    }

    public void setjDateChooser7(JDateChooser jDateChooser7) {
        this.jDateChooser7 = jDateChooser7;
    }

    public JLabel getjLabel21() {
        return jLabel21;
    }

    public void setjLabel21(JLabel jLabel21) {
        this.jLabel21 = jLabel21;
    }

    public JLabel getjLabel44() {
        return jLabel44;
    }

    public void setjLabel44(JLabel jLabel44) {
        this.jLabel44 = jLabel44;
    }

    public JLabel getjLabel53() {
        return jLabel53;
    }

    public void setjLabel53(JLabel jLabel53) {
        this.jLabel53 = jLabel53;
    }

    public JLabel getjLabel54() {
        return jLabel54;
    }

    public void setjLabel54(JLabel jLabel54) {
        this.jLabel54 = jLabel54;
    }

    public JLabel getjLabel68() {
        return jLabel68;
    }

    public void setjLabel68(JLabel jLabel68) {
        this.jLabel68 = jLabel68;
    }

    public JLabel getjLabel78() {
        return jLabel78;
    }

    public void setjLabel78(JLabel jLabel78) {
        this.jLabel78 = jLabel78;
    }

    public JPanel getjPanel13() {
        return jPanel13;
    }

    public void setjPanel13(JPanel jPanel13) {
        this.jPanel13 = jPanel13;
    }

    public JScrollPane getjScrollPane20() {
        return jScrollPane20;
    }

    public void setjScrollPane20(JScrollPane jScrollPane20) {
        this.jScrollPane20 = jScrollPane20;
    }

    public JScrollPane getjScrollPane21() {
        return jScrollPane21;
    }

    public void setjScrollPane21(JScrollPane jScrollPane21) {
        this.jScrollPane21 = jScrollPane21;
    }

    public JScrollPane getjScrollPane23() {
        return jScrollPane23;
    }

    public void setjScrollPane23(JScrollPane jScrollPane23) {
        this.jScrollPane23 = jScrollPane23;
    }

    public JTable getjTable10() {
        return jTable10;
    }

    public void setjTable10(JTable jTable10) {
        this.jTable10 = jTable10;
    }

    public JTable getjTable9() {
        return jTable9;
    }

    public void setjTable9(JTable jTable9) {
        this.jTable9 = jTable9;
    }

    public JTextArea getjTextArea7() {
        return jTextArea7;
    }

    public void setjTextArea7(JTextArea jTextArea7) {
        this.jTextArea7 = jTextArea7;
    }

    public JTextField getjTextField20() {
        return jTextField20;
    }

    public void setjTextField20(JTextField jTextField20) {
        this.jTextField20 = jTextField20;
    }

    public boolean isTemporal() {
        return temporal;
    }

    public void setTemporal(boolean temporal) {
        this.temporal = temporal;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel72() {
        return jLabel72;
    }

    public void setjLabel72(JLabel jLabel72) {
        this.jLabel72 = jLabel72;
    }

    public JScrollPane getjScrollPane8() {
        return jScrollPane8;
    }

    public void setjScrollPane8(JScrollPane jScrollPane8) {
        this.jScrollPane8 = jScrollPane8;
    }

    public JTextField getjTextField19() {
        return jTextField19;
    }

    public void setjTextField19(JTextField jTextField19) {
        this.jTextField19 = jTextField19;
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
            llenartablasselect(getjComboBox32(),getjTable10(),getjTextField20());
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
                List<Prestamos> hor = helper.getPrestamosByTipo((jLabel2.getText()));
                helper.cerrarSesion();
                temporal= true;
                JTable tabla = jTable9;
                
                DefaultTableModel temp = (DefaultTableModel) tabla.getModel();
                for(int i=temp.getRowCount()-1;i>=0;i--){
                    temp.removeRow(i);
                }
                int i=0;
                if(hor!=null){
                    for(Prestamos x: hor){
                        if(temporal){
                            if(tabla.getRowCount()< hor.size()){
                                DefaultTableModel tempa = (DefaultTableModel) tabla.getModel();
                                Object nuevo[]= {tempa.getRowCount()+1,"",""};
                                tempa.addRow(nuevo);
                            }
                            tabla.getModel().setValueAt(x.getMotivo(), i, 0);
                            tabla.getModel().setValueAt(x.getObservacion(), i, 1);
                            tabla.getModel().setValueAt(x.getFecha(), i, 2);
                            tabla.getModel().setValueAt(x.getAnio()+" "+x.getMes(), i, 3);
                            if(x.getAccion()!=null){
                                if(x.getAccion().equalsIgnoreCase("A")){
                                    tabla.getModel().setValueAt(x.getValor()+" Aprobado", i, 4);
                                }else{
                                    tabla.getModel().setValueAt("No Aprobado", i, 4);
                                }
                            }else{
                                tabla.getModel().setValueAt("en Espera", i, 4);
                            }
                            tabla.getModel().setValueAt(x.getResponsable(), i, 5);
                            tabla.getModel().setValueAt(x.getId(), i, 6);
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
        jPanel13 = new javax.swing.JPanel();
        jScrollPane20 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        jScrollPane21 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();
        jLabel68 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jTextField20 = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        jComboBox32 = new javax.swing.JComboBox();
        jLabel44 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jDateChooser7 = new com.toedter.calendar.JDateChooser();
        jComboBox33 = new javax.swing.JComboBox();
        jComboBox34 = new javax.swing.JComboBox();
        jLabel54 = new javax.swing.JLabel();
        jComboBox39 = new javax.swing.JComboBox();
        jLabel72 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        valor = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setEnabled(false);
        setLayout(null);

        jScrollPane8.setBorder(null);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(null);

        jTable9.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Asunto", "Descripcion", "Fecha Asunto", "fecha Sistema", "Valor", "Responsable", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable9.setRowHeight(24);
        jScrollPane20.setViewportView(jTable9);

        jPanel13.add(jScrollPane20);
        jScrollPane20.setBounds(20, 420, 1070, 213);

        jButton11.setText("Agregar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton11);
        jButton11.setBounds(450, 380, 71, 23);

        jTextArea7.setColumns(20);
        jTextArea7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextArea7.setRows(5);
        jScrollPane21.setViewportView(jTextArea7);

        jPanel13.add(jScrollPane21);
        jScrollPane21.setBounds(661, 300, 310, 60);

        jLabel68.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel68.setText("Descripcion:");
        jPanel13.add(jLabel68);
        jLabel68.setBounds(500, 300, 130, 30);

        jTable10.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CI", "Nombre", "Departamento", "id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable10.setRowHeight(24);
        jTable10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable10MouseClicked(evt);
            }
        });
        jScrollPane23.setViewportView(jTable10);
        if (jTable10.getColumnModel().getColumnCount() > 0) {
            jTable10.getColumnModel().getColumn(3).setMinWidth(0);
            jTable10.getColumnModel().getColumn(3).setPreferredWidth(0);
            jTable10.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        jPanel13.add(jScrollPane23);
        jScrollPane23.setBounds(20, 60, 1070, 180);

        jTextField20.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField20KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField20KeyTyped(evt);
            }
        });
        jPanel13.add(jTextField20);
        jTextField20.setBounds(188, 10, 312, 30);

        jLabel78.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel78.setText("Busqueda:");
        jPanel13.add(jLabel78);
        jLabel78.setBounds(20, 10, 100, 30);

        jComboBox32.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jComboBox32.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ALL" }));
        jComboBox32.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox32ItemStateChanged(evt);
            }
        });
        jPanel13.add(jComboBox32);
        jComboBox32.setBounds(930, 10, 160, 30);

        jLabel44.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel44.setText("Fecha:");
        jPanel13.add(jLabel44);
        jLabel44.setBounds(20, 340, 70, 30);

        jLabel53.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel53.setText("Mes:");
        jPanel13.add(jLabel53);
        jLabel53.setBounds(20, 300, 70, 30);

        jLabel21.setText("Asunto:");
        jPanel13.add(jLabel21);
        jLabel21.setBounds(500, 260, 70, 30);
        jPanel13.add(jDateChooser7);
        jDateChooser7.setBounds(100, 340, 150, 30);

        jComboBox33.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel13.add(jComboBox33);
        jComboBox33.setBounds(100, 300, 150, 30);

        jComboBox34.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Préstamo Empresa", "Préstamo Quirografario", "Préstamo Hipotecario", "Comisariato", "IESS: Extensión Conyuges", "Anticipo por Vacaciones", "Actividades Comunes", "Seguro de asistencia Médica" }));
        jPanel13.add(jComboBox34);
        jComboBox34.setBounds(640, 260, 310, 30);

        jLabel54.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel54.setText("Valor:");
        jPanel13.add(jLabel54);
        jLabel54.setBounds(260, 340, 60, 30);

        jComboBox39.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel13.add(jComboBox39);
        jComboBox39.setBounds(330, 300, 140, 30);

        jLabel72.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel72.setText("Empleado:");
        jPanel13.add(jLabel72);
        jLabel72.setBounds(20, 260, 79, 30);

        jTextField19.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel13.add(jTextField19);
        jTextField19.setBounds(100, 260, 310, 30);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setOpaque(true);
        jLabel2.setVisible(false);
        jPanel13.add(jLabel2);
        jLabel2.setBounds(430, 260, 42, 31);
        jPanel13.add(valor);
        valor.setBounds(330, 341, 140, 28);

        jLabel55.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel55.setText("Año:");
        jPanel13.add(jLabel55);
        jLabel55.setBounds(260, 300, 60, 30);

        jScrollPane8.setViewportView(jPanel13);

        add(jScrollPane8);
        jScrollPane8.setBounds(0, 0, 1170, 540);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable10MouseClicked
        int row = jTable10.rowAtPoint(evt.getPoint());
        jTextField19.setText(jTable10.getValueAt(row, 1).toString());
        jLabel2.setText(jTable10.getValueAt(row, 3).toString());  
        reporteempleados per = new reporteempleados(3);
        per.start();
    }//GEN-LAST:event_jTable10MouseClicked

    private void jComboBox32ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox32ItemStateChanged
        if(!trampa2){
            actualizarbusqueda();
        }
    }//GEN-LAST:event_jComboBox32ItemStateChanged

    private void jTextField20KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField20KeyReleased

    }//GEN-LAST:event_jTextField20KeyReleased

    private void jTextField20KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField20KeyTyped
        if(evt.getKeyChar()=='\n') {
            actualizarbusqueda();        // TODO add your handling code here:
        }
    }//GEN-LAST:event_jTextField20KeyTyped

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    public JTextField getValor() {
        return valor;
    }

    public void setValor(JTextField valor) {
        this.valor = valor;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton11;
    private javax.swing.JComboBox jComboBox32;
    private javax.swing.JComboBox jComboBox33;
    private javax.swing.JComboBox jComboBox34;
    private javax.swing.JComboBox jComboBox39;
    private com.toedter.calendar.JDateChooser jDateChooser7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField valor;
    // End of variables declaration//GEN-END:variables
}
