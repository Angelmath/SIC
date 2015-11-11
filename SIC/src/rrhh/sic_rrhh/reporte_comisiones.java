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
import rrhh.Entidad.Comisiones;
import rrhh.Entidad.Departamento;
import rrhh.Entidad.Empleado;
import rrhh.servicio.ServiceHb;

/**
 *
 * @author Matheus
 */
public final class reporte_comisiones extends javax.swing.JPanel {
    Dimension d;
    Empleado emp;
    int turno=1;
    boolean temporal=false;
    String nivel;
    boolean trampa2=false;
    boolean trampa=false;
    /**
     * Creates new form inicio
     */
    public reporte_comisiones() {
        initComponents();
        d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width-100, d.height-61);
        jScrollPane8.setSize(d.width-100, d.height-61-80);
        jPanel11.setSize(d.width-100, d.height-61-80);
        fecha_update();
        setVisible(false);
    }

    public JLabel getjLabel44() {
        return jLabel44;
    }

    public void setjLabel44(JLabel jLabel44) {
        this.jLabel44 = jLabel44;
    }

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }
    
    public void llenar(){
        if(!temporal){
            ServiceHb helper=null;
            try{
                helper = new ServiceHb();
                helper.iniciarTransaccion();
                List<Comisiones> hor = helper.getComisionesByTipo((jLabel1.getText()));
                helper.cerrarSesion();
                temporal= true;
                JTable tabla = jTable7;
                
                DefaultTableModel temp = (DefaultTableModel) tabla.getModel();
                for(int i=temp.getRowCount()-1;i>=0;i--){
                    temp.removeRow(i);
                }
                int i=0;
                if(hor!=null){
                    for(Comisiones x: hor){
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
    
    public void fecha_update(){
        String[] fecha= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        jComboBox27.removeAllItems();
        jComboBox21.removeAllItems();
        Date f = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(f);
        for(int i=2013; i<2021;i++){
            jComboBox27.addItem(i);
        }
        for(int i=0; i<12;i++){
            jComboBox21.addItem(fecha[i]);
        }
        jComboBox27.setSelectedItem(calendar.get(Calendar.YEAR));
        jComboBox21.setSelectedItem(fecha[calendar.get(Calendar.MONTH)]);
    }
    
    public void actualizar(){
        reporteempleados per = new reporteempleados(1);
        per.start();
    }
    
    public void actualizarbusqueda(){
        reporteempleados per = new reporteempleados(2);
        per.start();
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

    public JButton getjButton5() {
        return jButton5;
    }

    public void setjButton5(JButton jButton5) {
        this.jButton5 = jButton5;
    }

    public JComboBox getjComboBox15() {
        return jComboBox15;
    }

    public void setjComboBox15(JComboBox jComboBox15) {
        this.jComboBox15 = jComboBox15;
    }

    public JComboBox getjComboBox21() {
        return jComboBox21;
    }

    public void setjComboBox21(JComboBox jComboBox21) {
        this.jComboBox21 = jComboBox21;
    }

    public JComboBox getjComboBox27() {
        return jComboBox27;
    }

    public void setjComboBox27(JComboBox jComboBox27) {
        this.jComboBox27 = jComboBox27;
    }
    public JDateChooser getjDateChooser5() {
        return jDateChooser5;
    }

    public void setjDateChooser5(JDateChooser jDateChooser5) {
        this.jDateChooser5 = jDateChooser5;
    }

    public JLabel getjLabel32() {
        return jLabel32;
    }

    public void setjLabel32(JLabel jLabel32) {
        this.jLabel32 = jLabel32;
    }

    public JLabel getjLabel36() {
        return jLabel36;
    }

    public void setjLabel36(JLabel jLabel36) {
        this.jLabel36 = jLabel36;
    }

    public JLabel getjLabel37() {
        return jLabel37;
    }

    public void setjLabel37(JLabel jLabel37) {
        this.jLabel37 = jLabel37;
    }

    public JLabel getjLabel41() {
        return jLabel41;
    }

    public void setjLabel41(JLabel jLabel41) {
        this.jLabel41 = jLabel41;
    }

    public JLabel getjLabel42() {
        return jLabel42;
    }

    public void setjLabel42(JLabel jLabel42) {
        this.jLabel42 = jLabel42;
    }

    public JLabel getjLabel43() {
        return jLabel43;
    }

    public void setjLabel43(JLabel jLabel43) {
        this.jLabel43 = jLabel43;
    }

    public JPanel getjPanel11() {
        return jPanel11;
    }

    public void setjPanel11(JPanel jPanel11) {
        this.jPanel11 = jPanel11;
    }

    public JScrollPane getjScrollPane11() {
        return jScrollPane11;
    }

    public void setjScrollPane11(JScrollPane jScrollPane11) {
        this.jScrollPane11 = jScrollPane11;
    }

    public JScrollPane getjScrollPane12() {
        return jScrollPane12;
    }

    public void setjScrollPane12(JScrollPane jScrollPane12) {
        this.jScrollPane12 = jScrollPane12;
    }

    public JScrollPane getjScrollPane13() {
        return jScrollPane13;
    }

    public void setjScrollPane13(JScrollPane jScrollPane13) {
        this.jScrollPane13 = jScrollPane13;
    }

    public JTable getjTable6() {
        return jTable6;
    }

    public void setjTable6(JTable jTable6) {
        this.jTable6 = jTable6;
    }

    public JTable getjTable7() {
        return jTable7;
    }

    public void setjTable7(JTable jTable7) {
        this.jTable7 = jTable7;
    }

    public JTextArea getjTextArea4() {
        return jTextArea4;
    }

    public void setjTextArea4(JTextArea jTextArea4) {
        this.jTextArea4 = jTextArea4;
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
    
    public void llenartablas(){
        try{
            if(nivel.equalsIgnoreCase("Seguridad")){
                getjComboBox15().removeAllItems();
                getjComboBox15().addItem("Seguridad Fisica");
                //actualizarbusqueda();
            }else{
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                List<Departamento> dept = helper.getdepartamentosByTipo();

                getjComboBox15().removeAllItems();

                getjComboBox15().addItem("ALL");

                for(Departamento i: dept){
                    getjComboBox15().addItem(i.getNombre());
                }
                helper.cerrarSesion();
                //actualizarbusqueda();
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
            llenartablasselect(getjComboBox15(),getjTable6(),getjTextField10());
            }
            if(num==3){
                temporal=false;
                llenar();
            }
        }
      }

    public Dimension getD() {
        return d;
    }

    public void setD(Dimension d) {
        this.d = d;
    }

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

    public JLabel getjLabel38() {
        return jLabel38;
    }

    public void setjLabel38(JLabel jLabel38) {
        this.jLabel38 = jLabel38;
    }

    public JScrollPane getjScrollPane8() {
        return jScrollPane8;
    }

    public void setjScrollPane8(JScrollPane jScrollPane8) {
        this.jScrollPane8 = jScrollPane8;
    }

    public JTextField getjTextField9() {
        return jTextField9;
    }

    public void setjTextField9(JTextField jTextField9) {
        this.jTextField9 = jTextField9;
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
        jPanel11 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jComboBox15 = new javax.swing.JComboBox();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel36 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel37 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jComboBox21 = new javax.swing.JComboBox();
        jLabel43 = new javax.swing.JLabel();
        jComboBox27 = new javax.swing.JComboBox();
        jLabel38 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setEnabled(false);
        setLayout(null);

        jScrollPane8.setBorder(null);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(null);

        jLabel32.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel32.setText("Busqueda:");
        jPanel11.add(jLabel32);
        jLabel32.setBounds(20, 10, 100, 30);

        jTextField10.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField10KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField10KeyTyped(evt);
            }
        });
        jPanel11.add(jTextField10);
        jTextField10.setBounds(157, 11, 276, 30);

        jComboBox15.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jComboBox15.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ALL" }));
        jComboBox15.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox15ItemStateChanged(evt);
            }
        });
        jPanel11.add(jComboBox15);
        jComboBox15.setBounds(930, 10, 160, 30);

        jTable6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CI", "Nombre", "Departamento", "id"
            }
        ));
        jTable6.setRowHeight(24);
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(jTable6);
        if (jTable6.getColumnModel().getColumnCount() > 0) {
            jTable6.getColumnModel().getColumn(3).setMinWidth(0);
            jTable6.getColumnModel().getColumn(3).setPreferredWidth(0);
            jTable6.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        jPanel11.add(jScrollPane11);
        jScrollPane11.setBounds(20, 60, 1070, 180);

        jLabel36.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel36.setText("Asunto:");
        jPanel11.add(jLabel36);
        jLabel36.setBounds(510, 250, 130, 30);

        jTextField8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel11.add(jTextField8);
        jTextField8.setBounds(660, 250, 310, 30);

        jTextArea4.setColumns(20);
        jTextArea4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextArea4.setRows(5);
        jScrollPane12.setViewportView(jTextArea4);

        jPanel11.add(jScrollPane12);
        jScrollPane12.setBounds(660, 300, 310, 60);

        jLabel37.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel37.setText("Descripcion:");
        jPanel11.add(jLabel37);
        jLabel37.setBounds(510, 300, 130, 30);

        jButton5.setText("Agregar");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jPanel11.add(jButton5);
        jButton5.setBounds(454, 380, 71, 23);

        jTable7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Asunto", "Descripcion", "Fecha Asunto", "Fecha Sistema", "Valor", "Responsable", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable7.setRowHeight(24);
        jScrollPane13.setViewportView(jTable7);

        jPanel11.add(jScrollPane13);
        jScrollPane13.setBounds(20, 409, 1070, 200);

        jLabel41.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel41.setText("Fecha:");
        jPanel11.add(jLabel41);
        jLabel41.setBounds(20, 340, 70, 30);

        jLabel42.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel42.setText("Mes:");
        jPanel11.add(jLabel42);
        jLabel42.setBounds(20, 300, 70, 30);
        jPanel11.add(jDateChooser5);
        jDateChooser5.setBounds(100, 340, 150, 30);

        jComboBox21.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel11.add(jComboBox21);
        jComboBox21.setBounds(100, 300, 150, 30);

        jLabel43.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel43.setText("Valor:");
        jPanel11.add(jLabel43);
        jLabel43.setBounds(270, 340, 60, 30);

        jComboBox27.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel11.add(jComboBox27);
        jComboBox27.setBounds(330, 300, 150, 30);

        jLabel38.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel38.setText("Empleado:");
        jPanel11.add(jLabel38);
        jLabel38.setBounds(20, 250, 70, 30);

        jTextField9.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel11.add(jTextField9);
        jTextField9.setBounds(100, 251, 310, 30);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setOpaque(true);
        jLabel1.setVisible(false);
        jPanel11.add(jLabel1);
        jLabel1.setBounds(440, 250, 42, 31);

        jLabel44.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel44.setText("Año:");
        jPanel11.add(jLabel44);
        jLabel44.setBounds(270, 300, 80, 30);
        jPanel11.add(jTextField1);
        jTextField1.setBounds(330, 340, 150, 30);

        jScrollPane8.setViewportView(jPanel11);

        add(jScrollPane8);
        jScrollPane8.setBounds(0, 0, 1170, 540);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyReleased
        
    }//GEN-LAST:event_jTextField10KeyReleased

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        int row = jTable6.rowAtPoint(evt.getPoint());
        jTextField9.setText(jTable6.getValueAt(row, 1).toString());
        jLabel1.setText(jTable6.getValueAt(row, 3).toString());  
        reporteempleados per = new reporteempleados(3);
        per.start();
    }//GEN-LAST:event_jTable6MouseClicked

    private void jComboBox15ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox15ItemStateChanged
        if(!trampa2){
            actualizarbusqueda();
        }
    }//GEN-LAST:event_jComboBox15ItemStateChanged

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseClicked

    private void jTextField10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyTyped
        if(evt.getKeyChar()=='\n') {
            actualizarbusqueda();        // TODO add your handling code here:
        }
    }//GEN-LAST:event_jTextField10KeyTyped

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public boolean isTrampa() {
        return trampa;
    }

    public void setTrampa(boolean trampa) {
        this.trampa = trampa;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox15;
    private javax.swing.JComboBox jComboBox21;
    private javax.swing.JComboBox jComboBox27;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
