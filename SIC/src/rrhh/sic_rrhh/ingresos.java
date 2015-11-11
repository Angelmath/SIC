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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import rrhh.Entidad.Bono;
import rrhh.Entidad.Empleado;
import rrhh.Entidad.Horas;
import rrhh.servicio.ServiceHb;

/**
 *
 * @author Matheus
 */
public final class ingresos extends javax.swing.JPanel {
    Dimension d;
    Empleado emp;
    int turno=1;
    /**
     * Creates new form inicio
     */
    public ingresos() {
        initComponents();
        d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width-100, d.height-61);
        jPanel4.setLocation((d.width-100)/2 - jPanel4.getWidth()/2, 0);
        llenarcombo1();
        llenarcombo2();
        setVisible(false);
    }

    public Dimension getD() {
        return d;
    }
    public void llenarcombo1(){
        getjComboBox1().removeAll();
        getjComboBox1().addItem("Enero");
        getjComboBox1().addItem("Febrero");
        getjComboBox1().addItem("Marzo");
        getjComboBox1().addItem("Abril");
        getjComboBox1().addItem("Mayo");
        getjComboBox1().addItem("Junio");
        getjComboBox1().addItem("Julio");
        getjComboBox1().addItem("Agosto");
        getjComboBox1().addItem("Septiembre");
        getjComboBox1().addItem("Octubre");
        getjComboBox1().addItem("Noviembre");
        getjComboBox1().addItem("Diciembre");
    }
    
    public void llenarcombo2(){
        getjComboBox2().removeAll();
        int temp=2014;
        while(temp<2030){
            getjComboBox2().addItem(temp);
            temp++;
        }
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

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
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

    public JTextArea getjTextArea1() {
        return jTextArea1;
    }

    public void setjTextArea1(JTextArea jTextArea1) {
        this.jTextArea1 = jTextArea1;
    }


    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
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


    public void setD(Dimension d) {
        this.d = d;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
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

    public JSeparator getjSeparator1() {
        return jSeparator1;
    }

    public void setjSeparator1(JSeparator jSeparator1) {
        this.jSeparator1 = jSeparator1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setEnabled(false);
        setLayout(null);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);
        jPanel4.add(jSeparator1);
        jSeparator1.setBounds(10, 70, 970, 10);

        jTabbedPane1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jTable1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Empleado", "Asunto", "Descripcion", "Fecha", "Tiempo", "Valor", "Responsable"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 20, 800, 290);

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setText("Empleado:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 330, 80, 30);

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel5.setText("Asunto:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 370, 80, 30);

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel6.setText("Descripcion");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 420, 80, 30);

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel8.setText("Fecha:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(360, 330, 80, 30);

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel9.setText("Tiempo:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(360, 370, 80, 30);

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel10.setText("Valor:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(360, 410, 80, 30);

        jButton1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButton1.setText("EDITAR");
        jPanel1.add(jButton1);
        jButton1.setBounds(710, 330, 90, 25);

        jTextField1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel1.add(jTextField1);
        jTextField1.setBounds(460, 410, 230, 30);

        jTextField2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel1.add(jTextField2);
        jTextField2.setBounds(120, 370, 230, 30);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(120, 420, 230, 50);

        jTextField3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel1.add(jTextField3);
        jTextField3.setBounds(120, 330, 230, 30);

        jTextField4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel1.add(jTextField4);
        jTextField4.setBounds(460, 330, 230, 30);

        jTextField5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel1.add(jTextField5);
        jTextField5.setBounds(460, 370, 230, 30);

        jTabbedPane1.addTab("Horas Extra", jPanel1);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        jButton2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButton2.setText("EDITAR");
        jPanel3.add(jButton2);
        jButton2.setBounds(710, 330, 90, 25);

        jTable2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Empleado", "Asunto", "Descripcion", "Fecha", "Tiempo", "Valor", "Responsable"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setOpaque(false);
        jScrollPane4.setViewportView(jTable2);

        jPanel3.add(jScrollPane4);
        jScrollPane4.setBounds(20, 20, 800, 290);

        jLabel16.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel16.setText("Empleado:");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(30, 330, 80, 30);

        jLabel17.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel17.setText("Asunto:");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(30, 370, 80, 30);

        jLabel18.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel18.setText("Descripcion");
        jPanel3.add(jLabel18);
        jLabel18.setBounds(30, 420, 80, 30);

        jLabel19.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel19.setText("Fecha:");
        jPanel3.add(jLabel19);
        jLabel19.setBounds(360, 330, 80, 30);

        jLabel20.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel20.setText("Tiempo:");
        jPanel3.add(jLabel20);
        jLabel20.setBounds(360, 370, 80, 30);

        jLabel21.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel21.setText("Valor:");
        jPanel3.add(jLabel21);
        jLabel21.setBounds(360, 410, 80, 30);

        jTextField11.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel3.add(jTextField11);
        jTextField11.setBounds(460, 410, 230, 30);

        jTextField12.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel3.add(jTextField12);
        jTextField12.setBounds(120, 370, 230, 30);

        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextArea3.setRows(5);
        jScrollPane5.setViewportView(jTextArea3);

        jPanel3.add(jScrollPane5);
        jScrollPane5.setBounds(120, 420, 230, 50);

        jTextField13.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel3.add(jTextField13);
        jTextField13.setBounds(120, 330, 230, 30);

        jTextField14.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel3.add(jTextField14);
        jTextField14.setBounds(460, 330, 230, 30);

        jTextField15.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel3.add(jTextField15);
        jTextField15.setBounds(460, 370, 230, 30);

        jTabbedPane1.addTab("Bonos", jPanel3);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.addTab("Fondos de Reserva", jPanel2);

        jPanel4.add(jTabbedPane1);
        jTabbedPane1.setBounds(20, 120, 960, 530);

        jLabel2.setFont(new java.awt.Font("Roboto", 3, 19)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 74, 152));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ingresos");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(10, 20, 160, 26);

        jComboBox1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel4.add(jComboBox1);
        jComboBox1.setBounds(730, 20, 150, 30);

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel1.setText("Fecha:");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(660, 20, 60, 30);

        jButton3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jButton3.setText("Generar");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel4.add(jButton3);
        jButton3.setBounds(530, 20, 90, 30);

        jComboBox2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel4.add(jComboBox2);
        jComboBox2.setBounds(890, 20, 90, 30);

        add(jPanel4);
        jPanel4.setBounds(0, 0, 1000, 630);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            List<Horas> horas =helper.getHorasmesByTipo2(getjComboBox1().getSelectedItem().toString(),getjComboBox2().getSelectedItem().toString());
            List<Bono> bono = helper.getBonomesByTipo2(getjComboBox1().getSelectedItem().toString(),getjComboBox2().getSelectedItem().toString());
            helper.cerrarSesion();
            
            DefaultTableModel temp = (DefaultTableModel) getjTable1().getModel();
            for(int i=temp.getRowCount()-1;i>=0;i--){
               temp.removeRow(i);
            }
            if(horas!=null){
            for(int i=0; i<horas.size();i++){
                if(getjTable1().getRowCount()< horas.size()){
                    DefaultTableModel tempa = (DefaultTableModel) getjTable1().getModel();
                    Object nuevo[]= {tempa.getRowCount()+1,"",""};
                    tempa.addRow(nuevo);
                }
                    getjTable1().getModel().setValueAt(horas.get(i).getCi(), i, 0);
                    getjTable1().getModel().setValueAt(horas.get(i).getMotivo(), i, 1);
                    getjTable1().getModel().setValueAt(horas.get(i).getObservacion() , i, 2);
                    getjTable1().getModel().setValueAt(horas.get(i).getFecha(), i, 3);
                    getjTable1().getModel().setValueAt(horas.get(i).getValor(), i, 4);
                    getjTable1().getModel().setValueAt(horas.get(i).getResponsable(), i, 5);
                }
            }
            
            DefaultTableModel temp2 = (DefaultTableModel) getjTable2().getModel();
            for(int i=temp2.getRowCount()-1;i>=0;i--){
               temp2.removeRow(i);
            }
            if(bono!=null){
            for(int i=0; i<bono.size();i++){
                if(getjTable2().getRowCount()< bono.size()){
                    DefaultTableModel tempa = (DefaultTableModel) getjTable2().getModel();
                    Object nuevo[]= {tempa.getRowCount()+1,"",""};
                    tempa.addRow(nuevo);
                }
                    getjTable2().getModel().setValueAt(bono.get(i).getCi(), i, 0);
                    getjTable2().getModel().setValueAt(bono.get(i).getMotivo(), i, 1);
                    getjTable2().getModel().setValueAt(bono.get(i).getObservacion() , i, 2);
                    getjTable2().getModel().setValueAt(bono.get(i).getFecha(), i, 3);
                    getjTable2().getModel().setValueAt(bono.get(i).getValor(), i, 4);
                    getjTable2().getModel().setValueAt(bono.get(i).getResponsable(), i, 5);
                }
            }
            
        }
        catch(Exception io){
            
        }
        
    }//GEN-LAST:event_jButton3MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
