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
import rrhh.Entidad.Empleado;
import rrhh.Entidad.Multa;
import rrhh.Entidad.Prestamos;
import rrhh.servicio.ServiceHb;

/**
 *
 * @author Matheus
 */
public final class egresos extends javax.swing.JPanel {
    Dimension d;
    Empleado emp;
    int turno=1;
    /**
     * Creates new form inicio
     */
    public egresos() {
        initComponents();
        d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width-100, d.height-61);
        jPanel3.setLocation((d.width-100)/2 - jPanel3.getWidth()/2,0);
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
    public void setD(Dimension d) {
        this.d = d;
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

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
    }

    public JLabel getjLabel11() {
        return jLabel11;
    }

    public void setjLabel11(JLabel jLabel11) {
        this.jLabel11 = jLabel11;
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

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
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

    public JPanel getjPanel5() {
        return jPanel5;
    }

    public void setjPanel5(JPanel jPanel5) {
        this.jPanel5 = jPanel5;
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

    public JScrollPane getjScrollPane6() {
        return jScrollPane6;
    }

    public void setjScrollPane6(JScrollPane jScrollPane6) {
        this.jScrollPane6 = jScrollPane6;
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

    public JTextArea getjTextArea1() {
        return jTextArea1;
    }

    public void setjTextArea1(JTextArea jTextArea1) {
        this.jTextArea1 = jTextArea1;
    }

    public JTextArea getjTextArea2() {
        return jTextArea2;
    }

    public void setjTextArea2(JTextArea jTextArea2) {
        this.jTextArea2 = jTextArea2;
    }
    
    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }

    public JTextField getjTextField10() {
        return jTextField10;
    }

    public void setjTextField10(JTextField jTextField10) {
        this.jTextField10 = jTextField10;
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

    public JTextField getjTextField6() {
        return jTextField6;
    }

    public void setjTextField6(JTextField jTextField6) {
        this.jTextField6 = jTextField6;
    }

    public JTextField getjTextField7() {
        return jTextField7;
    }

    public void setjTextField7(JTextField jTextField7) {
        this.jTextField7 = jTextField7;
    }

    public JTextField getjTextField8() {
        return jTextField8;
    }

    public void setjTextField8(JTextField jTextField8) {
        this.jTextField8 = jTextField8;
    }

    public JTextField getjTextField9() {
        return jTextField9;
    }

    public void setjTextField9(JTextField jTextField9) {
        this.jTextField9 = jTextField9;
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

        jPanel3 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setEnabled(false);
        setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        jButton4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jButton4.setText("Generar");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jPanel3.add(jButton4);
        jButton4.setBounds(530, 20, 90, 30);

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel1.setText("Fecha:");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(660, 20, 60, 30);

        jComboBox1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel3.add(jComboBox1);
        jComboBox1.setBounds(730, 20, 150, 30);

        jComboBox2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel3.add(jComboBox2);
        jComboBox2.setBounds(890, 20, 90, 30);
        jPanel3.add(jSeparator1);
        jSeparator1.setBounds(10, 70, 950, 10);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jButton3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButton3.setText("EDITAR");
        jPanel2.add(jButton3);
        jButton3.setBounds(710, 330, 90, 25);

        jTable3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(jTable3);

        jPanel2.add(jScrollPane6);
        jScrollPane6.setBounds(20, 20, 800, 290);

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel7.setText("Empleado:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(30, 330, 80, 30);

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel11.setText("Asunto:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(30, 370, 80, 30);

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel12.setText("Descripcion");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(30, 420, 80, 30);

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel13.setText("Fecha:");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(360, 330, 80, 30);

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel14.setText("Tiempo:");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(360, 370, 80, 30);

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel15.setText("Valor:");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(360, 410, 80, 30);

        jTextField6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel2.add(jTextField6);
        jTextField6.setBounds(460, 410, 230, 30);

        jTextField7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel2.add(jTextField7);
        jTextField7.setBounds(120, 370, 230, 30);

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(120, 420, 230, 50);

        jTextField8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel2.add(jTextField8);
        jTextField8.setBounds(120, 330, 230, 30);

        jTextField9.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel2.add(jTextField9);
        jTextField9.setBounds(460, 330, 230, 30);

        jTextField10.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel2.add(jTextField10);
        jTextField10.setBounds(460, 370, 230, 30);

        jTabbedPane1.addTab("Multas", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        jButton2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButton2.setText("EDITAR");
        jPanel4.add(jButton2);
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
        jScrollPane4.setViewportView(jTable2);

        jPanel4.add(jScrollPane4);
        jScrollPane4.setBounds(20, 20, 800, 290);

        jLabel22.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel22.setText("Empleado:");
        jPanel4.add(jLabel22);
        jLabel22.setBounds(30, 330, 80, 30);

        jLabel23.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel23.setText("Asunto:");
        jPanel4.add(jLabel23);
        jLabel23.setBounds(30, 370, 80, 30);

        jLabel24.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel24.setText("Descripcion");
        jPanel4.add(jLabel24);
        jLabel24.setBounds(30, 420, 80, 30);

        jLabel25.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel25.setText("Fecha:");
        jPanel4.add(jLabel25);
        jLabel25.setBounds(360, 330, 80, 30);

        jLabel26.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel26.setText("Tiempo:");
        jPanel4.add(jLabel26);
        jLabel26.setBounds(360, 370, 80, 30);

        jLabel27.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel27.setText("Valor:");
        jPanel4.add(jLabel27);
        jLabel27.setBounds(360, 410, 80, 30);

        jTextField16.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel4.add(jTextField16);
        jTextField16.setBounds(460, 410, 230, 30);

        jTextField17.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel4.add(jTextField17);
        jTextField17.setBounds(120, 370, 230, 30);

        jTextArea4.setColumns(20);
        jTextArea4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextArea4.setRows(5);
        jScrollPane7.setViewportView(jTextArea4);

        jPanel4.add(jScrollPane7);
        jScrollPane7.setBounds(120, 420, 230, 50);

        jTextField18.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel4.add(jTextField18);
        jTextField18.setBounds(120, 330, 230, 30);

        jTextField19.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel4.add(jTextField19);
        jTextField19.setBounds(460, 330, 230, 30);

        jTextField20.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel4.add(jTextField20);
        jTextField20.setBounds(460, 370, 230, 30);

        jTabbedPane1.addTab("Prestamos", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(null);

        jButton1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButton1.setText("EDITAR");
        jPanel5.add(jButton1);
        jButton1.setBounds(710, 330, 90, 25);

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

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(20, 20, 800, 290);

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setText("Empleado:");
        jPanel5.add(jLabel4);
        jLabel4.setBounds(30, 330, 80, 30);

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel5.setText("Asunto:");
        jPanel5.add(jLabel5);
        jLabel5.setBounds(30, 370, 80, 30);

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel6.setText("Descripcion");
        jPanel5.add(jLabel6);
        jLabel6.setBounds(30, 420, 80, 30);

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel8.setText("Fecha:");
        jPanel5.add(jLabel8);
        jLabel8.setBounds(360, 330, 80, 30);

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel9.setText("Tiempo:");
        jPanel5.add(jLabel9);
        jLabel9.setBounds(360, 370, 80, 30);

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel10.setText("Valor:");
        jPanel5.add(jLabel10);
        jLabel10.setBounds(360, 410, 80, 30);

        jTextField1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel5.add(jTextField1);
        jTextField1.setBounds(460, 410, 230, 30);

        jTextField2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel5.add(jTextField2);
        jTextField2.setBounds(120, 370, 230, 30);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel5.add(jScrollPane2);
        jScrollPane2.setBounds(120, 420, 230, 50);

        jTextField3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel5.add(jTextField3);
        jTextField3.setBounds(120, 330, 230, 30);

        jTextField4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel5.add(jTextField4);
        jTextField4.setBounds(460, 330, 230, 30);

        jTextField5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel5.add(jTextField5);
        jTextField5.setBounds(460, 370, 230, 30);

        jTabbedPane1.addTab("Abono", jPanel5);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.addTab("Alimentacion", jPanel1);

        jPanel3.add(jTabbedPane1);
        jTabbedPane1.setBounds(20, 120, 950, 520);

        jLabel2.setFont(new java.awt.Font("Roboto", 3, 19)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 74, 152));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Egresos");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(10, 20, 160, 26);

        add(jPanel3);
        jPanel3.setBounds(0, 0, 1000, 630);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
         try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            List<Multa> multa =helper.getMultamesByTipo2(getjComboBox1().getSelectedItem().toString(),getjComboBox2().getSelectedItem().toString());
            List<Prestamos> prestamo = helper.getPrestamosmesByTipo2(getjComboBox1().getSelectedItem().toString(),getjComboBox2().getSelectedItem().toString());
            helper.cerrarSesion();
            
            DefaultTableModel temp = (DefaultTableModel) getjTable3().getModel();
            for(int i=temp.getRowCount()-1;i>=0;i--){
               temp.removeRow(i);
            }
            if(multa!=null){
            for(int i=0; i<multa.size();i++){
                if(getjTable3().getRowCount()< multa.size()){
                    DefaultTableModel tempa = (DefaultTableModel) getjTable3().getModel();
                    Object nuevo[]= {tempa.getRowCount()+1,"",""};
                    tempa.addRow(nuevo);
                }
                    getjTable3().getModel().setValueAt(multa.get(i).getCi(), i, 0);
                    getjTable3().getModel().setValueAt(multa.get(i).getMotivo(), i, 1);
                    getjTable3().getModel().setValueAt(multa.get(i).getObservacion() , i, 2);
                    getjTable3().getModel().setValueAt(multa.get(i).getFecha(), i, 3);
                    getjTable3().getModel().setValueAt(multa.get(i).getValor(), i, 4);
                    getjTable3().getModel().setValueAt(multa.get(i).getResponsable(), i, 5);
                }
            }
            
            DefaultTableModel temp2 = (DefaultTableModel) getjTable2().getModel();
            for(int i=temp2.getRowCount()-1;i>=0;i--){
               temp2.removeRow(i);
            }
            if(prestamo!=null){
            for(int i=0; i<prestamo.size();i++){
                if(getjTable2().getRowCount()< prestamo.size()){
                    DefaultTableModel tempa = (DefaultTableModel) getjTable2().getModel();
                    Object nuevo[]= {tempa.getRowCount()+1,"",""};
                    tempa.addRow(nuevo);
                }
                    getjTable2().getModel().setValueAt(prestamo.get(i).getCi(), i, 0);
                    getjTable2().getModel().setValueAt(prestamo.get(i).getMotivo(), i, 1);
                    getjTable2().getModel().setValueAt(prestamo.get(i).getObservacion() , i, 2);
                    getjTable2().getModel().setValueAt(prestamo.get(i).getFecha(), i, 3);
                    getjTable2().getModel().setValueAt(prestamo.get(i).getValor(), i, 4);
                    getjTable2().getModel().setValueAt(prestamo.get(i).getResponsable(), i, 5);
                }
            }
            
        }
        catch(Exception io){
            
        }
    }//GEN-LAST:event_jButton4MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
