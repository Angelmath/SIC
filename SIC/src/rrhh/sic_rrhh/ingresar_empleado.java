/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.sic_rrhh;

import Login.servicio.Funcion;
import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import rrhh.Entidad.Departamento;
import rrhh.Entidad.DeptEmpl;
import rrhh.Entidad.Empleado;
import rrhh.servicio.ServiceHb;

/**
 *
 * @author Matheus
 */
public class ingresar_empleado extends javax.swing.JPanel {
    Dimension d;
    String direccion;
    String fotot;
    String entrefoto;
    String directoriofoto;
    String directoriocv;
    float sueldot;
    float sueldo;
    float iess;
    float suple;
    /**
     * Creates new form inicio
     * @param direccion
     */
    public ingresar_empleado(String direccion) {
        initComponents();
        this.direccion=direccion;
        this.fotot= direccion+"foto_empleados\\temporal.jpeg";
        this.directoriofoto="foto_empleados\\";
        this.directoriocv="pdf_cajamarca\\";
        d = Toolkit.getDefaultToolkit().getScreenSize();
        List<Departamento> dept=null;
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            dept= helper.getdepartamentosByTipo();
            helper.cerrarSesion();
        }catch(Exception io){
            
        }
        jComboBox1.removeAllItems();
        for(Departamento i: dept){
            jComboBox1.addItem(i.getNombre());
        }
        setSize(d.width-100, d.height-61);
        jSeparator1.setSize(d.width-180, 3);
        jLabel3.setLocation(jSeparator1.getX()+jSeparator1.getWidth()-jLabel3.getWidth(), jLabel3.getY());
        jButton1.setLocation((jPanel2.getWidth()/2)-jButton1.getWidth()/2, jButton1.getY());
        jLabel20.setLocation((jPanel2.getWidth()/2)-jLabel20.getWidth()/2, jLabel20.getY());
        setVisible(false);
    }
    
    public Dimension getD() {
        return d;
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
    
    public JComboBox getjComboBox3() {
        return jComboBox3;
    }
    
    public void setjComboBox3(JComboBox jComboBox3) {
        this.jComboBox3 = jComboBox3;
    }
    
    public JDateChooser getjDateChooser1() {
        return jDateChooser1;
    }
    
    public void setjDateChooser1(JDateChooser jDateChooser1) {
        this.jDateChooser1 = jDateChooser1;
    }
    
    public JDateChooser getjDateChooser2() {
        return jDateChooser2;
    }
    
    public void setjDateChooser2(JDateChooser jDateChooser2) {
        this.jDateChooser2 = jDateChooser2;
    }
    
    public JDateChooser getjDateChooser3() {
        return jDateChooser3;
    }
    
    public void setjDateChooser3(JDateChooser jDateChooser3) {
        this.jDateChooser3 = jDateChooser3;
    }
    
    public JLabel getjLabel21() {
        return jLabel21;
    }
    
    public void setjLabel21(JLabel jLabel21) {
        this.jLabel21 = jLabel21;
    }
    
    public JLabel getjLabel22() {
        return jLabel22;
    }
    
    public void setjLabel22(JLabel jLabel22) {
        this.jLabel22 = jLabel22;
    }
    
    public void setD(Dimension d) {
        this.d = d;
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
    
    public JLabel getjLabel18() {
        return jLabel18;
    }
    
    public void setjLabel18(JLabel jLabel18) {
        this.jLabel18 = jLabel18;
    }
    
    public JLabel getjLabel19() {
        return jLabel19;
    }
    
    public void setjLabel19(JLabel jLabel19) {
        this.jLabel19 = jLabel19;
    }
    
    public JLabel getjLabel2() {
        return jLabel2;
    }
    
    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }
    
    public JLabel getjLabel20() {
        return jLabel20;
    }
    
    public void setjLabel20(JLabel jLabel20) {
        this.jLabel20 = jLabel20;
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
    
    public JSeparator getjSeparator1() {
        return jSeparator1;
    }
    
    public void setjSeparator1(JSeparator jSeparator1) {
        this.jSeparator1 = jSeparator1;
    }
    
    public JTextField getjTextField1() {
        return jTextField1;
    }
    
    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }
    
    public JTextField getjTextField11() {
        return jTextField11;
    }
    
    public void setjTextField11(JTextField jTextField11) {
        this.jTextField11 = jTextField11;
    }
    
    public JTextField getjTextField12() {
        return jTextField12;
    }
    
    public void setjTextField12(JTextField jTextField12) {
        this.jTextField12 = jTextField12;
    }
    
    public JTextField getjTextField13() {
        return jTextField13;
    }
    
    public void setjTextField13(JTextField jTextField13) {
        this.jTextField13 = jTextField13;
    }
    
    public JTextField getjTextField14() {
        return jTextField14;
    }
    
    public void setjTextField14(JTextField jTextField14) {
        this.jTextField14 = jTextField14;
    }
    
    public JTextField getjTextField15() {
        return jTextField15;
    }
    
    public void setjTextField15(JTextField jTextField15) {
        this.jTextField15 = jTextField15;
    }
    
    public JTextField getjTextField16() {
        return jTextField16;
    }
    
    public void setjTextField16(JTextField jTextField16) {
        this.jTextField16 = jTextField16;
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
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jTextField11 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setEnabled(false);
        setLayout(null);
        add(jSeparator1);
        jSeparator1.setBounds(30, 90, 710, 10);

        jLabel2.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 74, 152));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Agregar Empleado");
        add(jLabel2);
        jLabel2.setBounds(30, 50, 160, 24);

        jLabel3.setBackground(new java.awt.Color(0, 74, 152));
        jLabel3.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("LISTO");
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
        });
        add(jLabel3);
        jLabel3.setBounds(580, 50, 160, 24);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel6.setText("Primer Nombre:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 60, 190, 22);

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel7.setText("Segundo Nombre:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(0, 100, 190, 22);

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel8.setText("Apellido Paterno:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(0, 140, 190, 22);

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel9.setText("Apellido Materno:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(0, 180, 190, 22);

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel10.setText("Género:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(0, 220, 190, 22);

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel11.setText("Fecha de Nacimiento:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(0, 260, 190, 22);

        jLabel13.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel13.setText("Estado Civil:");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(0, 300, 190, 22);

        jLabel15.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel15.setText("Email:");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(0, 340, 190, 22);

        jLabel17.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel17.setText("Direccion:");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(0, 380, 190, 22);

        jLabel19.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel19.setText("Celular:");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(0, 420, 190, 22);

        jTextField3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(jTextField3);
        jTextField3.setBounds(230, 60, 230, 24);

        jTextField4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(jTextField4);
        jTextField4.setBounds(230, 100, 230, 24);

        jTextField5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(jTextField5);
        jTextField5.setBounds(230, 140, 230, 24);

        jTextField6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(jTextField6);
        jTextField6.setBounds(230, 180, 230, 24);

        jTextField12.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(jTextField12);
        jTextField12.setBounds(230, 340, 230, 24);

        jTextField14.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(jTextField14);
        jTextField14.setBounds(230, 380, 230, 24);

        jTextField16.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(jTextField16);
        jTextField16.setBounds(230, 420, 230, 24);

        jDateChooser2.setPreferredSize(new java.awt.Dimension(87, 24));
        jPanel1.add(jDateChooser2);
        jDateChooser2.setBounds(230, 260, 230, 24);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));
        jComboBox2.setPreferredSize(new java.awt.Dimension(93, 24));
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(230, 220, 230, 24);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Soltero (A)", "Divorciado (A)", "Casado (A)", "Viudo (A)", "Union Libre" }));
        jComboBox3.setPreferredSize(new java.awt.Dimension(93, 24));
        jPanel1.add(jComboBox3);
        jComboBox3.setBounds(230, 300, 230, 24);

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel5.setText("Cédula de Identidad");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(0, 20, 190, 22);

        jTextField2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField2);
        jTextField2.setBounds(230, 20, 230, 24);

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel4.setText("Descripcion:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 460, 190, 22);

        jTextField1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(jTextField1);
        jTextField1.setBounds(230, 460, 230, 24);

        jLabel23.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel23.setText("Sueldo Total:");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(0, 500, 190, 22);

        jTextField7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField7);
        jTextField7.setBounds(230, 500, 230, 24);

        jLabel24.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel24.setText("Sueldo:");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(0, 540, 190, 22);

        jTextField8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField8KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField8);
        jTextField8.setBounds(230, 540, 230, 24);

        add(jPanel1);
        jPanel1.setBounds(30, 90, 480, 570);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel20.setBackground(new java.awt.Color(204, 204, 204));
        jLabel20.setOpaque(true);
        jPanel2.add(jLabel20);
        jLabel20.setBounds(60, 10, 160, 160);

        jButton1.setText("Cargar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(90, 170, 100, 30);

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel12.setText("CV:");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(0, 220, 190, 22);

        jDateChooser3.setPreferredSize(new java.awt.Dimension(87, 24));
        jPanel2.add(jDateChooser3);
        jDateChooser3.setBounds(230, 260, 230, 24);

        jTextField11.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.add(jTextField11);
        jTextField11.setBounds(230, 300, 230, 24);

        jLabel14.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel14.setText("Nacionalidad:");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(0, 300, 190, 22);

        jLabel16.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel16.setText("Cuidad de Residencia:");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(0, 340, 190, 22);

        jTextField13.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.add(jTextField13);
        jTextField13.setBounds(230, 340, 230, 24);

        jTextField15.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.add(jTextField15);
        jTextField15.setBounds(230, 380, 230, 24);

        jComboBox1.setPreferredSize(new java.awt.Dimension(93, 24));
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(230, 420, 230, 24);

        jDateChooser1.setPreferredSize(new java.awt.Dimension(87, 24));
        jPanel2.add(jDateChooser1);
        jDateChooser1.setBounds(230, 460, 230, 24);

        jLabel21.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel21.setText("Salida:");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(0, 460, 190, 22);

        jLabel18.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel18.setText("Departamento:");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(0, 420, 190, 22);

        jLabel22.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel22.setText("Telefono:");
        jPanel2.add(jLabel22);
        jLabel22.setBounds(0, 380, 190, 22);

        jLabel26.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel26.setText("Suplementario:");
        jPanel2.add(jLabel26);
        jLabel26.setBounds(0, 540, 190, 22);

        jTextField10.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField10KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField10);
        jTextField10.setBounds(230, 540, 230, 24);

        jTextField9.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField9KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField9);
        jTextField9.setBounds(230, 500, 230, 24);

        jLabel25.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel25.setText("IESS:");
        jPanel2.add(jLabel25);
        jLabel25.setBounds(0, 500, 190, 22);

        jLabel27.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel27.setText("Fecha de Ingreso:");
        jPanel2.add(jLabel27);
        jLabel27.setBounds(0, 260, 190, 22);

        jTextField17.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jTextField17.setEnabled(false);
        jPanel2.add(jTextField17);
        jTextField17.setBounds(230, 220, 200, 24);

        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(430, 220, 30, 24);

        add(jPanel2);
        jPanel2.setBounds(510, 90, 480, 570);
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        JFileChooser chooser = new JFileChooser();
        
        //Mostrar la ventana para abrir archivo y recoger la respuesta
        //En el parámetro del showOpenDialog se indica la ventana
        //  al que estará asociado. Con el valor this se asocia a la
        //  ventana que la abre.
        int valido=0;
        int respuesta = chooser.showOpenDialog(this);
        File archivoEntrada=null;
        if (respuesta == JFileChooser.APPROVE_OPTION)
        {
            //Crear un objeto File con el archivo elegido
            archivoEntrada = chooser.getSelectedFile();
            //Mostrar el nombre del archvivo en un campo de texto
            
            File archivoSalida = new File(direccion+"foto_empleados\\temporal.jpeg");
            FileChannel source = null;
            
            FileChannel destination = null;
            
            try {
                if(!archivoSalida.exists()) {
                    archivoSalida.createNewFile();
                    
                }
                
                source = new FileInputStream(archivoEntrada).getChannel();
                
                destination = new FileOutputStream(archivoSalida).getChannel();
                
                destination.transferFrom(source, 0, source.size());
                
            } catch(Exception io){
                
            }
            finally {
                if(source != null) {
                    try {
                        source.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ingresar_empleado.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                
                if(destination != null) {
                    try {
                        destination.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ingresar_empleado.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        }
        String ex ="";
        try{
            ImageIcon icon = new ImageIcon(fotot);//Iniciamos imagen en un ImageIcon y luego la
            //redimensionamos al tamaño de la etiqueta
            ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(jLabel20.getWidth(), getjLabel20().getHeight(), Image.SCALE_DEFAULT));
            jLabel20.setIcon(icono);
            entrefoto=archivoEntrada.getPath();
        }catch(Exception io){
            
        }
        
    }//GEN-LAST:event_jButton1MouseClicked
    
    public String getEntrefoto() {
        return entrefoto;
    }
    
    public void setEntrefoto(String entrefoto) {
        this.entrefoto = entrefoto;
    }
    
    public float getSueldot() {
        return sueldot;
    }
    
    public void setSueldot(float sueldot) {
        this.sueldot = sueldot;
    }
    
    public float getSueldo() {
        return sueldo;
    }
    
    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }
    
    public float getIess() {
        return iess;
    }
    
    public void setIess(float iess) {
        this.iess = iess;
    }
    
    public float getSuple() {
        return suple;
    }
    
    public void setSuple(float suple) {
        this.suple = suple;
    }
    
    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        
    }//GEN-LAST:event_jTextField2ActionPerformed
    
    public JLabel getjLabel23() {
        return jLabel23;
    }
    
    public void setjLabel23(JLabel jLabel23) {
        this.jLabel23 = jLabel23;
    }
    
    public JLabel getjLabel24() {
        return jLabel24;
    }
    
    public void setjLabel24(JLabel jLabel24) {
        this.jLabel24 = jLabel24;
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
    
    public JTextField getjTextField10() {
        return jTextField10;
    }
    
    public void setjTextField10(JTextField jTextField10) {
        this.jTextField10 = jTextField10;
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
    
    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        char caracter = evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)
                ){
            /* lo que deseo colocar aqui es si ya se pulso el caracter (.) el mismo no se pueda repetir*/
            evt.consume();
        }
    }//GEN-LAST:event_jTextField2KeyTyped
    
    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        char caracter = evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)
                && (caracter !='.')){
            /* lo que deseo colocar aqui es si ya se pulso el caracter (.) el mismo no se pueda repetir*/
            evt.consume();
            
        }
    }//GEN-LAST:event_jTextField7KeyTyped
    
    private void jTextField8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyTyped
        char caracter = evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)
                && (caracter !='.')){
            /* lo que deseo colocar aqui es si ya se pulso el caracter (.) el mismo no se pueda repetir*/
            evt.consume();
        }
    }//GEN-LAST:event_jTextField8KeyTyped
    
    private void jTextField9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyTyped
        char caracter = evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)
                && (caracter !='.')){
            /* lo que deseo colocar aqui es si ya se pulso el caracter (.) el mismo no se pueda repetir*/
            evt.consume();
        }
    }//GEN-LAST:event_jTextField9KeyTyped
    
    private void jTextField10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyTyped
        char caracter = evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)
                && (caracter !='.')){
            /* lo que deseo colocar aqui es si ya se pulso el caracter (.) el mismo no se pueda repetir*/
            evt.consume();
        }
    }//GEN-LAST:event_jTextField10KeyTyped
    
    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        sueldot= Float.parseFloat(jTextField7.getText());
        sueldo= (float)(sueldot-(sueldot*0.20));
        iess= (float)(sueldo*0.0945);
        suple= (float)(sueldot*0.20);
        jTextField8.setText(Float.toString(sueldo));
        jTextField9.setText(Float.toString(iess));
        jTextField10.setText(Float.toString(suple));
    }//GEN-LAST:event_jTextField7KeyReleased
    
    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
        sueldot= Float.parseFloat(jTextField7.getText());
        sueldo= Float.parseFloat(jTextField8.getText());
        iess= (float)(sueldo*0.0945);
        suple= (float)(sueldot-sueldo);
        jTextField9.setText(Float.toString(iess));
        jTextField10.setText(Float.toString(suple));
    }//GEN-LAST:event_jTextField8KeyReleased
    public void limpiar(){
        jTextField1.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField4.setText(null);
        jTextField5.setText(null);
        jTextField6.setText(null);
        jTextField7.setText(null);
        jTextField8.setText(null);
        jTextField9.setText(null);
        jTextField10.setText(null);
        jTextField11.setText(null);
        jTextField12.setText(null);
        jTextField13.setText(null);
        jTextField14.setText(null);
        jTextField15.setText(null);
        jTextField16.setText(null);
        jTextField17.setText(null);
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        jDateChooser3.setDate(null);
        entrefoto=null;
        //redimensionamos al tamaño de la etiqueta
        jLabel20.setIcon(null);
    }
    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        Empleado em = new Empleado();
        /*** CI  ***/
        em.setCid(""+Integer.parseInt(jTextField2.getText()));
        /***  1 Nombre ***/
        em.setNombre1(jTextField3.getText());
        /***  2 Nombre ***/
        em.setNombre2(jTextField4.getText());
        /***  1 Apellido ***/
        em.setApellido1(jTextField5.getText());
        /***  2 Apellido ***/
        em.setApellido2(jTextField6.getText());
        /***  genero ***/
        if(jComboBox2.getSelectedItem().toString().equalsIgnoreCase("Masculino")){
            em.setGenero('M');
        }else{
            em.setGenero('F');
        }
        /***  fecha nacimiento ***/
        em.setFechaNacimiento(jDateChooser2.getDate());
        /***  estado civil  ***/
        if(jComboBox3.getSelectedItem().toString().equalsIgnoreCase("Casado (A)")){em.setEstadoCivil('C');}
        if(jComboBox3.getSelectedItem().toString().equalsIgnoreCase("Divorciado (A)")){em.setEstadoCivil('D');}
        if(jComboBox3.getSelectedItem().toString().equalsIgnoreCase("Soltero (A)")){em.setEstadoCivil('S');}
        if(jComboBox3.getSelectedItem().toString().equalsIgnoreCase("Viudo (A)")){em.setEstadoCivil('V');}
        if(jComboBox3.getSelectedItem().toString().equalsIgnoreCase("Union Libre")){em.setEstadoCivil('U');}
        /***  email ***/
        em.setCorreo(jTextField12.getText());
        /***  direccion ***/
        em.setFondos("No Acumula");
        em.setDireccion(jTextField14.getText());
        /***  celular ***/
        em.setCelular(jTextField16.getText());
        /***  direccion ***/
        em.setDireccion(jTextField14.getText());
        /***  descripcion ***/
        em.setCiudad(jTextField1.getText());
        /***  fecha ingreso ***/
        em.setFechaIngreso(jDateChooser3.getDate());
        /***  nacionalidad ***/
        em.setPais(jTextField11.getText());
        /***  ciudad residencia ***/
        em.setCuidadResidencia(jTextField13.getText());
        /***  telefono ***/
        em.setTelefono(jTextField15.getText());
        
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            
            /***  fecha salida ***/
            em.setSalidaemp(Funcion.DateFormat(jDateChooser1.getDate()));
            
            /***  Sueldo Total ***/
            em.setCumple2(jTextField7.getText());
            /***  Sueldo ***/
            em.setDato1(jTextField8.getText());
            /***  IESS ***/
            em.setDato2(jTextField9.getText());
            /***  Suplementario ***/
            em.setDato3(jTextField10.getText());
            /***  ACTIVO  ***/
            em.setEstado("Activo");
            /***  Foto  ***/
            if(entrefoto!=null){
                File archivoEntrada = new File(entrefoto);
                //Mostrar el nombre del archvivo en un campo de texto
                if(archivoEntrada.exists()){
                    File archivoSalida = new File(direccion + directoriofoto+Integer.toString(Integer.parseInt(jTextField2.getText()))+".jpeg");
                    FileChannel source = null;
                    
                    FileChannel destination = null;
                    
                    try {
                        if(!archivoSalida.exists()) {
                            archivoSalida.createNewFile();
                        }
                        
                        source = new FileInputStream(archivoEntrada).getChannel();
                        
                        destination = new FileOutputStream(archivoSalida).getChannel();
                        
                        destination.transferFrom(source, 0, source.size());
                        
                    } catch(Exception io){
                        
                    }
                    finally {
                        if(source != null) {
                            try {
                                source.close();
                            } catch (IOException ex) {
                                Logger.getLogger(ingresar_empleado.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }
                        
                        if(destination != null) {
                            try {
                                destination.close();
                            } catch (IOException ex) {
                                Logger.getLogger(ingresar_empleado.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }
                    }
                    em.setFoto(directoriofoto+Integer.toString(Integer.parseInt(jTextField2.getText()))+".jpeg");
                }
                
            }
            /***  CV  ***/
            if(jTextField17.getText()!=null){
                File archivoEntrada = new File(jTextField17.getText());
                //Mostrar el nombre del archvivo en un campo de texto
                if(archivoEntrada.exists()){
                    File archivoSalida = new File(direccion + directoriocv+Integer.toString(Integer.parseInt(jTextField2.getText()))+".pdf");
                    FileChannel source = null;
                    
                    FileChannel destination = null;
                    
                    try {
                        if(!archivoSalida.exists()) {
                            archivoSalida.createNewFile();
                        }
                        
                        source = new FileInputStream(archivoEntrada).getChannel();
                        
                        destination = new FileOutputStream(archivoSalida).getChannel();
                        
                        destination.transferFrom(source, 0, source.size());
                        
                    } catch(Exception io){
                        
                    }
                    finally {
                        if(source != null) {
                            try {
                                source.close();
                            } catch (IOException ex) {
                                Logger.getLogger(ingresar_empleado.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }
                        
                        if(destination != null) {
                            try {
                                destination.close();
                            } catch (IOException ex) {
                                Logger.getLogger(ingresar_empleado.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }
                    }
                    em.setCv(directoriocv+Integer.toString(Integer.parseInt(jTextField2.getText()))+".pdf");
                }
            }
            /***  departamento tabla ***/
            helper.crearObjeto(em);
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            
            helper = new ServiceHb();
            helper.iniciarTransaccion();
            Departamento d1 = helper.getDepartamento(jComboBox1.getSelectedItem().toString());
            /***  departamento celda ***/
            em.setDepartamento(d1.getNombre());
            
            DeptEmpl dp = new DeptEmpl();
            dp.setDepartamento(d1);
            dp.setEmpleado(em);
            helper.crearObjeto(dp);
            helper.confirmarTransaccion();
            helper.cerrarTransaccion();
            em.setDeptEmpl(dp);
            helper= new ServiceHb();
            helper.iniciarTransaccion();
            helper.actualizarObjeto(em);
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            JOptionPane.showMessageDialog(null,"Cedula: "+em.getCi()+" Agregado");
            limpiar();
        }
        
        catch(Exception io){
            
        }
    }//GEN-LAST:event_jLabel3MouseClicked
    
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        JFileChooser chooser = new JFileChooser();
        
        //Mostrar la ventana para abrir archivo y recoger la respuesta
        //En el parámetro del showOpenDialog se indica la ventana
        //  al que estará asociado. Con el valor this se asocia a la
        //  ventana que la abre.
        int valido=0;
        int respuesta = chooser.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION)
        {
            //Crear un objeto File con el archivo elegido
            File archivoEntrada = chooser.getSelectedFile();
            //Mostrar el nombre del archvivo en un campo de texto
            jTextField17.setText(archivoEntrada.getPath());
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseEntered
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getFotot() {
        return fotot;
    }
    
    public void setFotot(String fotot) {
        this.fotot = fotot;
    }
    
    public JButton getjButton1() {
        return jButton1;
    }
    
    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }
    
    public JLabel getjLabel3() {
        return jLabel3;
    }
    
    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
