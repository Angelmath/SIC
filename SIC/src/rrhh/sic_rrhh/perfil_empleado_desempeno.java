/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.sic_rrhh;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Matheus
 */
public class perfil_empleado_desempeno extends javax.swing.JPanel {
    Dimension d;
    
    /**
     * Creates new form inicio
     */
    public perfil_empleado_desempeno() {
        initComponents();
        d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width-100, d.height-61-200);
        jScrollPane1.setSize((d.width-102)/2, d.height-61-320);
        jPanel2.setSize((d.width-102)/2, d.height-61-200-jPanel3.getHeight()-100);
        jScrollPane2.setSize((d.width-102)/2, d.height-61-200-jPanel3.getHeight()-100);
        jPanel3.setLocation(((jScrollPane2.getWidth())/2)-jPanel3.getWidth()/2, jScrollPane2.getY()+jScrollPane2.getHeight()+10);
        jScrollPane1.setLocation((d.width-102)/2, jScrollPane1.getY());
        
        jLabel8.setLocation((d.width-102)/2, jLabel7.getY());
        jLabel5.setLocation(jLabel8.getX()+jLabel8.getWidth()+50, jLabel8.getY());
        jLabel3.setLocation(jLabel5.getX()+jLabel5.getWidth()+50, jLabel8.getY());
        jComboBox1.setLocation((d.width-102)/2, jComboBox1.getY());
        jLabel53.setLocation(jComboBox1.getX()+jComboBox1.getWidth()+50, jComboBox1.getY());
        jLabel52.setLocation(jLabel53.getX()+jLabel53.getWidth()+50, jComboBox1.getY());
        
        
        String ex ="";
        
        setVisible(false);
    }
    
    public JComboBox getjComboBox1() {
        return jComboBox1;
    }

    public void setjComboBox1(JComboBox jComboBox1) {
        this.jComboBox1 = jComboBox1;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel24() {
        return jLabel24;
    }

    public void setjLabel24(JLabel jLabel24) {
        this.jLabel24 = jLabel24;
    }

    public JLabel getjLabel27() {
        return jLabel27;
    }

    public void setjLabel27(JLabel jLabel27) {
        this.jLabel27 = jLabel27;
    }

    public JLabel getjLabel34() {
        return jLabel34;
    }

    public void setjLabel34(JLabel jLabel34) {
        this.jLabel34 = jLabel34;
    }

    public JLabel getjLabel45() {
        return jLabel45;
    }

    public void setjLabel45(JLabel jLabel45) {
        this.jLabel45 = jLabel45;
    }

    public JLabel getjLabel54() {
        return jLabel54;
    }

    public void setjLabel54(JLabel jLabel54) {
        this.jLabel54 = jLabel54;
    }

    public JLabel getjLabel55() {
        return jLabel55;
    }

    public void setjLabel55(JLabel jLabel55) {
        this.jLabel55 = jLabel55;
    }

    public JLabel getjLabel56() {
        return jLabel56;
    }

    public void setjLabel56(JLabel jLabel56) {
        this.jLabel56 = jLabel56;
    }

    public JLabel getjLabel57() {
        return jLabel57;
    }

    public void setjLabel57(JLabel jLabel57) {
        this.jLabel57 = jLabel57;
    }

    public JLabel getjLabel58() {
        return jLabel58;
    }

    public void setjLabel58(JLabel jLabel58) {
        this.jLabel58 = jLabel58;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
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

    public JLabel getjLabel20() {
        return jLabel20;
    }

    public void setjLabel20(JLabel jLabel20) {
        this.jLabel20 = jLabel20;
    }
    
    public JLabel getjLabel22() {
        return jLabel22;
    }

    public void setjLabel22(JLabel jLabel22) {
        this.jLabel22 = jLabel22;
    }

    public JLabel getjLabel23() {
        return jLabel23;
    }

    public void setjLabel23(JLabel jLabel23) {
        this.jLabel23 = jLabel23;
    }


    public JLabel getjLabel26() {
        return jLabel26;
    }

    public void setjLabel26(JLabel jLabel26) {
        this.jLabel26 = jLabel26;
    }

    public JLabel getjLabel29() {
        return jLabel29;
    }

    public void setjLabel29(JLabel jLabel29) {
        this.jLabel29 = jLabel29;
    }

    public JLabel getjLabel30() {
        return jLabel30;
    }

    public void setjLabel30(JLabel jLabel30) {
        this.jLabel30 = jLabel30;
    }

    public JLabel getjLabel31() {
        return jLabel31;
    }

    public void setjLabel31(JLabel jLabel31) {
        this.jLabel31 = jLabel31;
    }

    public JLabel getjLabel32() {
        return jLabel32;
    }

    public void setjLabel32(JLabel jLabel32) {
        this.jLabel32 = jLabel32;
    }

    public JLabel getjLabel35() {
        return jLabel35;
    }

    public void setjLabel35(JLabel jLabel35) {
        this.jLabel35 = jLabel35;
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

    public JLabel getjLabel38() {
        return jLabel38;
    }

    public void setjLabel38(JLabel jLabel38) {
        this.jLabel38 = jLabel38;
    }

    public JLabel getjLabel39() {
        return jLabel39;
    }

    public void setjLabel39(JLabel jLabel39) {
        this.jLabel39 = jLabel39;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel40() {
        return jLabel40;
    }

    public void setjLabel40(JLabel jLabel40) {
        this.jLabel40 = jLabel40;
    }

    public JLabel getjLabel41() {
        return jLabel41;
    }

    public void setjLabel41(JLabel jLabel41) {
        this.jLabel41 = jLabel41;
    }

    public JLabel getjLabel52() {
        return jLabel52;
    }

    public void setjLabel52(JLabel jLabel52) {
        this.jLabel52 = jLabel52;
    }

    public JLabel getjLabel53() {
        return jLabel53;
    }

    public void setjLabel53(JLabel jLabel53) {
        this.jLabel53 = jLabel53;
    }

    public JLabel getjLabel43() {
        return jLabel43;
    }

    public void setjLabel43(JLabel jLabel43) {
        this.jLabel43 = jLabel43;
    }

    public JLabel getjLabel44() {
        return jLabel44;
    }

    public void setjLabel44(JLabel jLabel44) {
        this.jLabel44 = jLabel44;
    }

    public JLabel getjLabel46() {
        return jLabel46;
    }

    public void setjLabel46(JLabel jLabel46) {
        this.jLabel46 = jLabel46;
    }

    public JLabel getjLabel47() {
        return jLabel47;
    }

    public void setjLabel47(JLabel jLabel47) {
        this.jLabel47 = jLabel47;
    }

    public JLabel getjLabel48() {
        return jLabel48;
    }

    public void setjLabel48(JLabel jLabel48) {
        this.jLabel48 = jLabel48;
    }

    public JLabel getjLabel49() {
        return jLabel49;
    }

    public void setjLabel49(JLabel jLabel49) {
        this.jLabel49 = jLabel49;
    }

    public JLabel getjLabel51() {
        return jLabel51;
    }

    public void setjLabel51(JLabel jLabel51) {
        this.jLabel51 = jLabel51;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }

    public JTextField getjTextField10a() {
        return jTextField10a;
    }

    public void setjTextField10a(JTextField jTextField10a) {
        this.jTextField10a = jTextField10a;
    }

    public JTextField getjTextField11a() {
        return jTextField11a;
    }

    public void setjTextField11a(JTextField jTextField11a) {
        this.jTextField11a = jTextField11a;
    }

    public JTextField getjTextField12a() {
        return jTextField12a;
    }

    public void setjTextField12a(JTextField jTextField12a) {
        this.jTextField12a = jTextField12a;
    }

    public JTextField getjTextField13a() {
        return jTextField13a;
    }

    public void setjTextField13a(JTextField jTextField13a) {
        this.jTextField13a = jTextField13a;
    }

    public JTextField getjTextField14a() {
        return jTextField14a;
    }

    public void setjTextField14a(JTextField jTextField14a) {
        this.jTextField14a = jTextField14a;
    }

    public JTextField getjTextField15a() {
        return jTextField15a;
    }

    public void setjTextField15a(JTextField jTextField15a) {
        this.jTextField15a = jTextField15a;
    }

    public JTextField getjTextField16a() {
        return jTextField16a;
    }

    public void setjTextField16a(JTextField jTextField16a) {
        this.jTextField16a = jTextField16a;
    }

    public JTextField getjTextField17a() {
        return jTextField17a;
    }

    public void setjTextField17a(JTextField jTextField17a) {
        this.jTextField17a = jTextField17a;
    }

    public JTextField getjTextField18a() {
        return jTextField18a;
    }

    public void setjTextField18a(JTextField jTextField18a) {
        this.jTextField18a = jTextField18a;
    }

    public JTextField getjTextField19a() {
        return jTextField19a;
    }

    public void setjTextField19a(JTextField jTextField19a) {
        this.jTextField19a = jTextField19a;
    }

    public JTextField getjTextField1a() {
        return jTextField1a;
    }

    public void setjTextField1a(JTextField jTextField1a) {
        this.jTextField1a = jTextField1a;
    }

    public JTextField getjTextField20a() {
        return jTextField20a;
    }

    public void setjTextField20a(JTextField jTextField20a) {
        this.jTextField20a = jTextField20a;
    }

    public JTextField getjTextField21a() {
        return jTextField21a;
    }

    public void setjTextField21a(JTextField jTextField21a) {
        this.jTextField21a = jTextField21a;
    }

    public JTextField getjTextField2a() {
        return jTextField2a;
    }

    public void setjTextField2a(JTextField jTextField2a) {
        this.jTextField2a = jTextField2a;
    }

    public JTextField getjTextField3a() {
        return jTextField3a;
    }

    public void setjTextField3a(JTextField jTextField3a) {
        this.jTextField3a = jTextField3a;
    }

    public JTextField getjTextField3a1() {
        return jTextField3a1;
    }

    public void setjTextField3a1(JTextField jTextField3a1) {
        this.jTextField3a1 = jTextField3a1;
    }

    public JTextField getjTextField3a2() {
        return jTextField3a2;
    }

    public void setjTextField3a2(JTextField jTextField3a2) {
        this.jTextField3a2 = jTextField3a2;
    }

    public JTextField getjTextField3a3() {
        return jTextField3a3;
    }

    public void setjTextField3a3(JTextField jTextField3a3) {
        this.jTextField3a3 = jTextField3a3;
    }

    public JTextField getjTextField3a4() {
        return jTextField3a4;
    }

    public void setjTextField3a4(JTextField jTextField3a4) {
        this.jTextField3a4 = jTextField3a4;
    }

    public JTextField getjTextField3a5() {
        return jTextField3a5;
    }

    public void setjTextField3a5(JTextField jTextField3a5) {
        this.jTextField3a5 = jTextField3a5;
    }

    public JTextField getjTextField3a7() {
        return jTextField3a7;
    }

    public void setjTextField3a7(JTextField jTextField3a7) {
        this.jTextField3a7 = jTextField3a7;
    }

    public JTextField getjTextField4a() {
        return jTextField4a;
    }

    public void setjTextField4a(JTextField jTextField4a) {
        this.jTextField4a = jTextField4a;
    }

    public JTextField getjTextField5a() {
        return jTextField5a;
    }

    public void setjTextField5a(JTextField jTextField5a) {
        this.jTextField5a = jTextField5a;
    }

    public JTextField getjTextField6a() {
        return jTextField6a;
    }

    public void setjTextField6a(JTextField jTextField6a) {
        this.jTextField6a = jTextField6a;
    }

    public JTextField getjTextField7a() {
        return jTextField7a;
    }

    public void setjTextField7a(JTextField jTextField7a) {
        this.jTextField7a = jTextField7a;
    }

    public JTextField getjTextField8a() {
        return jTextField8a;
    }

    public void setjTextField8a(JTextField jTextField8a) {
        this.jTextField8a = jTextField8a;
    }

    public JTextField getjTextField9a() {
        return jTextField9a;
    }

    public void setjTextField9a(JTextField jTextField9a) {
        this.jTextField9a = jTextField9a;
    }

    public Dimension getD() {
        return d;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JLabel getjLabel25() {
        return jLabel25;
    }

    public void setjLabel25(JLabel jLabel25) {
        this.jLabel25 = jLabel25;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel8() {
        return jLabel8;
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

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JPanel getjPanel1() {
        return jPanel2;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel2 = jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel1;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel1 = jPanel2;
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

    public void setD(Dimension d) {
        this.d = d;
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel25 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField19a = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField1a = new javax.swing.JTextField();
        jTextField11a = new javax.swing.JTextField();
        jTextField2a = new javax.swing.JTextField();
        jTextField12a = new javax.swing.JTextField();
        jTextField3a = new javax.swing.JTextField();
        jTextField13a = new javax.swing.JTextField();
        jTextField4a = new javax.swing.JTextField();
        jTextField16a = new javax.swing.JTextField();
        jTextField17a = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField18a = new javax.swing.JTextField();
        jTextField5a = new javax.swing.JTextField();
        jTextField14a = new javax.swing.JTextField();
        jTextField6a = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField15a = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTextField7a = new javax.swing.JTextField();
        jTextField21a = new javax.swing.JTextField();
        jTextField8a = new javax.swing.JTextField();
        jTextField9a = new javax.swing.JTextField();
        jTextField10a = new javax.swing.JTextField();
        jTextField20a = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jTextField3a1 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jTextField3a2 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jTextField3a3 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jTextField3a4 = new javax.swing.JTextField();
        jTextField3a5 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jTextField3a7 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setEnabled(false);
        setLayout(null);

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel25.setText("jLabel25");
        add(jLabel25);
        jLabel25.setBounds(0, 0, 70, 25);
        jLabel25.setVisible(false);

        jLabel7.setBackground(new java.awt.Color(230, 230, 230));
        jLabel7.setFont(new java.awt.Font("Roboto", 3, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 74, 151));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("COMENTARIOS:");
        jLabel7.setOpaque(true);
        add(jLabel7);
        jLabel7.setBounds(0, 0, 250, 30);

        jLabel8.setBackground(new java.awt.Color(230, 230, 230));
        jLabel8.setFont(new java.awt.Font("Roboto", 3, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 74, 151));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("EVALUACIÓN DE DESEMPEÑO:");
        jLabel8.setOpaque(true);
        add(jLabel8);
        jLabel8.setBounds(550, 0, 250, 30);

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);
        jScrollPane2.setViewportView(jPanel2);

        add(jScrollPane2);
        jScrollPane2.setBounds(0, 40, 550, 430);

        jScrollPane1.setBorder(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel20.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel20.setText("dedicación requeridos.");

        jLabel17.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel17.setText("3.- Se anticipa a las dificultades");

        jTextField19a.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jTextField19a.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField19a.setEnabled(false);
        jTextField19a.setOpaque(false);

        jLabel9.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel9.setText("2.- Brinda una adecuada atención a los clientes.");

        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel4.setText("1.- Realiza las rondas y el patrullaje oportunamente.");

        jLabel6.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel6.setText("2.- Cumple con las tareas que se le encomienda.");

        jLabel10.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel10.setText("3.- Evita conflictos con sus compañeros de trabajo.");

        jLabel12.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel12.setText("2.- Se presenta limpio e impecable al trabajo.");

        jLabel11.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Promedio");

        jLabel13.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel13.setText("3.- Se presenta al trabajo en forma puntual.");

        jTextField1a.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jTextField1a.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1a.setEnabled(false);
        jTextField1a.setOpaque(false);

        jTextField11a.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jTextField11a.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11a.setEnabled(false);
        jTextField11a.setOpaque(false);

        jTextField2a.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jTextField2a.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2a.setEnabled(false);
        jTextField2a.setOpaque(false);
        jTextField2a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2aActionPerformed(evt);
            }
        });

        jTextField12a.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jTextField12a.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12a.setEnabled(false);
        jTextField12a.setOpaque(false);
        jTextField12a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12aActionPerformed(evt);
            }
        });

        jTextField3a.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jTextField3a.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3a.setEnabled(false);
        jTextField3a.setOpaque(false);

        jTextField13a.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jTextField13a.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField13a.setEnabled(false);
        jTextField13a.setOpaque(false);

        jTextField4a.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jTextField4a.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4a.setEnabled(false);
        jTextField4a.setOpaque(false);

        jTextField16a.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jTextField16a.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField16a.setEnabled(false);
        jTextField16a.setOpaque(false);
        jTextField16a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16aActionPerformed(evt);
            }
        });

        jTextField17a.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jTextField17a.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField17a.setEnabled(false);
        jTextField17a.setOpaque(false);
        jTextField17a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17aActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N

        jTextField18a.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jTextField18a.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField18a.setEnabled(false);
        jTextField18a.setOpaque(false);

        jTextField5a.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jTextField5a.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5a.setEnabled(false);
        jTextField5a.setOpaque(false);
        jTextField5a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5aActionPerformed(evt);
            }
        });

        jTextField14a.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jTextField14a.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField14a.setEnabled(false);
        jTextField14a.setOpaque(false);

        jTextField6a.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jTextField6a.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6a.setEnabled(false);
        jTextField6a.setOpaque(false);

        jLabel15.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel15.setText("1.- Se apega a las normas y procedimientos establecidos.");

        jTextField15a.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jTextField15a.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField15a.setEnabled(false);
        jTextField15a.setOpaque(false);

        jLabel23.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel23.setText("4.- Procura no ausentarse del trabajo.");

        jLabel19.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel19.setText("2.- Se muestra asequible al cambio");

        jLabel22.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel22.setText("1.- Es honesto y transparente con sus superiores y con la  compañía.");

        jLabel18.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel18.setText("equipamiento de seguridad entregado.");

        jLabel26.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel26.setText("1.- Se muestra respetuoso y amable en el trato con los");

        jTextField7a.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jTextField7a.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7a.setEnabled(false);
        jTextField7a.setOpaque(false);

        jTextField21a.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jTextField21a.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField21a.setEnabled(false);
        jTextField21a.setOpaque(false);
        jTextField21a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField21aActionPerformed(evt);
            }
        });

        jTextField8a.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jTextField8a.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8a.setEnabled(false);
        jTextField8a.setOpaque(false);
        jTextField8a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8aActionPerformed(evt);
            }
        });

        jTextField9a.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jTextField9a.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9a.setEnabled(false);
        jTextField9a.setOpaque(false);

        jTextField10a.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jTextField10a.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10a.setEnabled(false);
        jTextField10a.setOpaque(false);

        jTextField20a.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jTextField20a.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField20a.setEnabled(false);
        jTextField20a.setOpaque(false);
        jTextField20a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField20aActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel29.setText("computadoras, etc) en asuntos de interés personal.");

        jLabel30.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel30.setText("2.- Utiliza de manera adecuada y responsable el ");

        jLabel31.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel31.setText("clientes, compañeros y superiores.");

        jLabel32.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel32.setText("1.- Utiliza la indumentaria requerida (Chaleco, gorra,etc).");

        jTextField3a1.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jTextField3a1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3a1.setEnabled(false);
        jTextField3a1.setOpaque(false);

        jLabel39.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N

        jLabel40.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel40.setText("2.- Muestra lealtad a la compañía para la cual trabaja.");

        jLabel41.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel41.setText("3.- Es colaborador y predispuesto.");

        jLabel43.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel43.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel44.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel44.setText("6.- Se muestra profesional en el trabajo.");

        jTextField3a2.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jTextField3a2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3a2.setEnabled(false);
        jTextField3a2.setOpaque(false);
        jTextField3a2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3a2ActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Promedio");

        jTextField3a3.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jTextField3a3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3a3.setEnabled(false);
        jTextField3a3.setOpaque(false);

        jLabel47.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("Promedio");

        jTextField3a4.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jTextField3a4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3a4.setEnabled(false);
        jTextField3a4.setOpaque(false);

        jTextField3a5.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jTextField3a5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3a5.setEnabled(false);
        jTextField3a5.setOpaque(false);

        jLabel48.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("Promedio");

        jLabel49.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Promedio");

        jTextField3a7.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jTextField3a7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3a7.setEnabled(false);
        jTextField3a7.setOpaque(false);

        jLabel51.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Promedio Total");

        jLabel34.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        jLabel34.setText("ORIENTACIÓN A RESULTADOS");

        jLabel45.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        jLabel45.setText("CALIDAD DE TRABAJO.");

        jLabel54.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        jLabel54.setText("RELACIONES INTERPERSONALES.");

        jLabel55.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        jLabel55.setText("FORMALIDAD Y BUENA PRESENCIA.");

        jLabel56.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        jLabel56.setText("VALORES ORGANIZACIONALES.");

        jLabel57.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel57.setText("3.- Muestra una mejora continua en su desempeño  físico y laboral.");

        jLabel58.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel58.setText("4.- No utiliza los equipos de trabajo entregados (celulares, ");

        jLabel24.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel24.setText("5.- Asiste a las capacitaciones y charlas cuando le  corresponde.");

        jLabel27.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel27.setText("5.- Realiza el trabajo asignado con el esmero y la ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField1a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField2a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField3a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jTextField4a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField5a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField3a1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField6a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField7a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField8a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField9a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField10a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField11a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField3a2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField12a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField13a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField14a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField3a3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField15a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField16a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField17a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField18a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField3a4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField19a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField20a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jTextField21a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField3a5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField3a7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel34)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTextField2a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel57)
                    .addComponent(jTextField3a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel58)
                    .addComponent(jLabel39)
                    .addComponent(jTextField4a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jLabel29)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jTextField5a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jTextField3a1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jLabel16)
                .addGap(10, 10, 10)
                .addComponent(jLabel45)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jTextField6a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jTextField7a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jLabel18)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jTextField8a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jTextField9a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jTextField10a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jLabel20)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addComponent(jTextField11a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46)
                    .addComponent(jTextField3a2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel54)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jTextField12a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jLabel31)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jTextField13a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jTextField14a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47)
                    .addComponent(jTextField3a3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel55)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(jTextField15a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jTextField16a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jTextField17a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jTextField18a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48)
                    .addComponent(jTextField3a4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel56)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jTextField19a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40)
                    .addComponent(jTextField20a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel43))
                    .addComponent(jTextField21a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49)
                    .addComponent(jTextField3a5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51)
                    .addComponent(jTextField3a7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1);
        jScrollPane1.setBounds(550, 80, 550, 520);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/boton-redondo-pruebafisica-lightblue.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });
        add(jLabel2);
        jLabel2.setBounds(260, 0, 40, 32);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("VER");
        jLabel3.setOpaque(true);
        add(jLabel3);
        jLabel3.setBounds(950, 0, 40, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/agregar-icon-blue.png"))); // NOI18N
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel5);
        jLabel5.setBounds(920, 0, 30, 30);

        jComboBox1.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        add(jComboBox1);
        jComboBox1.setBounds(550, 40, 180, 30);

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-eliminar.png"))); // NOI18N
        jLabel52.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel52);
        jLabel52.setBounds(900, 40, 49, 30);

        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-editar.png"))); // NOI18N
        jLabel53.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel53);
        jLabel53.setBounds(840, 40, 49, 30);

        jPanel3.setOpaque(false);

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel35.setText("Muy bajo: 1       Inferior: Rendimiento laboral no aceptable\t ");
        jLabel35.setOpaque(true);

        jLabel36.setBackground(new java.awt.Color(255, 255, 255));
        jLabel36.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel36.setText("Bajo:  2              Inferior al promedio: Rendimiento laboral deficiente");
        jLabel36.setOpaque(true);

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel37.setText("Moderado: 3\t      Promedio: Rendimiento laboral regular");
        jLabel37.setOpaque(true);

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel38.setText("Alto:  4              Superior al promedio: Rendimiento laboral aceptable");
        jLabel38.setOpaque(true);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel1.setText("Alto:  5              Superior: Rendimiento laboral excelente");
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        add(jPanel3);
        jPanel3.setBounds(60, 480, 340, 100);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/boton-redondo-pruebafisica-blue.png"))); // NOI18N
        alt(jLabel2,"Pruebas Fisicas");
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/boton-redondo-pruebafisica-lightblue.png"))); // NOI18N
        jLabel25.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseExited

    private void jTextField2aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2aActionPerformed

    private void jTextField12aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12aActionPerformed

    private void jTextField17aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17aActionPerformed

    private void jTextField5aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5aActionPerformed

    private void jTextField8aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8aActionPerformed

    private void jTextField20aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField20aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20aActionPerformed

    private void jTextField16aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField16aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16aActionPerformed

    private void jTextField21aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField21aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField21aActionPerformed

    private void jTextField3a2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3a2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3a2ActionPerformed
    public void alt (Component bt, String text){
        jLabel25.setVisible(true);
        jLabel25.setText(text);
        jLabel25.setSize((int)jLabel25.getMinimumSize().getWidth(), 25);
        jLabel25.setLocation(bt.getX()+bt.getWidth(), bt.getY()+bt.getHeight());
    } 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField10a;
    private javax.swing.JTextField jTextField11a;
    private javax.swing.JTextField jTextField12a;
    private javax.swing.JTextField jTextField13a;
    private javax.swing.JTextField jTextField14a;
    private javax.swing.JTextField jTextField15a;
    private javax.swing.JTextField jTextField16a;
    private javax.swing.JTextField jTextField17a;
    private javax.swing.JTextField jTextField18a;
    private javax.swing.JTextField jTextField19a;
    private javax.swing.JTextField jTextField1a;
    private javax.swing.JTextField jTextField20a;
    private javax.swing.JTextField jTextField21a;
    private javax.swing.JTextField jTextField2a;
    private javax.swing.JTextField jTextField3a;
    private javax.swing.JTextField jTextField3a1;
    private javax.swing.JTextField jTextField3a2;
    private javax.swing.JTextField jTextField3a3;
    private javax.swing.JTextField jTextField3a4;
    private javax.swing.JTextField jTextField3a5;
    private javax.swing.JTextField jTextField3a7;
    private javax.swing.JTextField jTextField4a;
    private javax.swing.JTextField jTextField5a;
    private javax.swing.JTextField jTextField6a;
    private javax.swing.JTextField jTextField7a;
    private javax.swing.JTextField jTextField8a;
    private javax.swing.JTextField jTextField9a;
    // End of variables declaration//GEN-END:variables
}
