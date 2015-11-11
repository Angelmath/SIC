/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Login.ventas;

import Login.Entidad.Indexitem;
import Login.servicio.ServiceHb;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author homemig
 */
public class findex extends javax.swing.JPanel {
    String cl;
    findexPresu f1 = new findexPresu();
    findexContable f2 = new findexContable();
    /**
     * Creates new form cliente
     */
    public findex() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        String[] fecha= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        initComponents();
        f1.setLocation(jPanel2.getX(), jPanel2.getY());
        f2.setLocation(jPanel2.getX(), jPanel2.getY());
        add(f1);
        add(f2);
        Calendar rightNow = Calendar.getInstance();
        int ccyy = rightNow.get(Calendar.YEAR);
        int month = rightNow.get(Calendar.MONTH);
        setSize(d.width, d.height-95);
        jLabel22.setLocation(d.width-(jLabel22.getWidth()*2), d.height-95-(jLabel22.getHeight()*2));
        //jTable1.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        setVisible(false);
    }
    
    public void cambio(JPanel pane){
        jPanel2.setVisible(false);
        f1.setVisible(false);
        f2.setVisible(false);
        pane.setVisible(true);
    }

    public findexPresu getF1() {
        return f1;
    }

    public void setF1(findexPresu f1) {
        this.f1 = f1;
    }

    public findexContable getF2() {
        return f2;
    }

    public void setF2(findexContable f2) {
        this.f2 = f2;
    }

    public JTextField getCampA() {
        return campA;
    }

    public void setCampA(JTextField campA) {
        this.campA = campA;
    }

    public JTextField getCampB() {
        return campB;
    }

    public void setCampB(JTextField campB) {
        this.campB = campB;
    }

    public JTextField getCampC() {
        return campC;
    }

    public void setCampC(JTextField campC) {
        this.campC = campC;
    }

    public JTextField getCampD() {
        return campD;
    }

    public void setCampD(JTextField campD) {
        this.campD = campD;
    }

    public JTextField getCampE() {
        return campE;
    }

    public void setCampE(JTextField campE) {
        this.campE = campE;
    }

    public JTextField getCampF() {
        return campF;
    }

    public void setCampF(JTextField campF) {
        this.campF = campF;
    }

    public JTextField getCampG() {
        return campG;
    }

    public void setCampG(JTextField campG) {
        this.campG = campG;
    }

    public JTextField getInf1() {
        return inf1;
    }

    public void setInf1(JTextField inf1) {
        this.inf1 = inf1;
    }

    public JTextField getInf2() {
        return inf2;
    }

    public void setInf2(JTextField inf2) {
        this.inf2 = inf2;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public JButton getjButton10() {
        return jButton10;
    }

    public void setjButton10(JButton jButton10) {
        this.jButton10 = jButton10;
    }

    public JButton getjButton11() {
        return jButton11;
    }

    public void setjButton11(JButton jButton11) {
        this.jButton11 = jButton11;
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

    public JButton getjButton5() {
        return jButton5;
    }

    public void setjButton5(JButton jButton5) {
        this.jButton5 = jButton5;
    }

    public JButton getjButton6() {
        return jButton6;
    }

    public void setjButton6(JButton jButton6) {
        this.jButton6 = jButton6;
    }

    public JButton getjButton7() {
        return jButton7;
    }

    public void setjButton7(JButton jButton7) {
        this.jButton7 = jButton7;
    }

    public JButton getjButton8() {
        return jButton8;
    }

    public void setjButton8(JButton jButton8) {
        this.jButton8 = jButton8;
    }

    public JButton getjButton9() {
        return jButton9;
    }

    public void setjButton9(JButton jButton9) {
        this.jButton9 = jButton9;
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

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
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

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
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

    public JTextField getResultadotext() {
        return resultadotext;
    }

    public void setResultadotext(JTextField resultadotext) {
        this.resultadotext = resultadotext;
    }

    public JTextField getSup1() {
        return sup1;
    }

    public void setSup1(JTextField sup1) {
        this.sup1 = sup1;
    }

    public JTextField getSup2() {
        return sup2;
    }

    public void setSup2(JTextField sup2) {
        this.sup2 = sup2;
    }
    
    public static Date getPrimerDiaDelMes() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.getActualMinimum(Calendar.DAY_OF_MONTH),
                cal.getMinimum(Calendar.HOUR_OF_DAY),
                cal.getMinimum(Calendar.MINUTE),
                cal.getMinimum(Calendar.SECOND));
        return cal.getTime();
    }
    
    public static Date getUltimoDiaDelMes() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.getActualMaximum(Calendar.DAY_OF_MONTH),
                cal.getMaximum(Calendar.HOUR_OF_DAY),
                cal.getMaximum(Calendar.MINUTE),
                cal.getMaximum(Calendar.SECOND));
        return cal.getTime();
    }
    
    public static Date getPrimerDiaDelMes3() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -3);
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.getActualMinimum(Calendar.DAY_OF_MONTH),
                cal.getMinimum(Calendar.HOUR_OF_DAY),
                cal.getMinimum(Calendar.MINUTE),
                cal.getMinimum(Calendar.SECOND));
        
        return cal.getTime();
    }
    
    public static Date getUltimoDiaDelMes3() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, +3);
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.getActualMaximum(Calendar.DAY_OF_MONTH),
                cal.getMaximum(Calendar.HOUR_OF_DAY),
                cal.getMaximum(Calendar.MINUTE),
                cal.getMaximum(Calendar.SECOND));
        return cal.getTime();
    }
    
    public void carga1(){
    }
    
    
    public void carga2(){
        
    }
    
    
    public String getCl() {
        return cl;
    }
    
    public void setCl(String cl) {
        this.cl = cl;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        campG = new javax.swing.JTextField();
        campA = new javax.swing.JTextField();
        campB = new javax.swing.JTextField();
        campC = new javax.swing.JTextField();
        campD = new javax.swing.JTextField();
        campE = new javax.swing.JTextField();
        campF = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        resultadotext = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        sup2 = new javax.swing.JTextField();
        inf1 = new javax.swing.JTextField();
        inf2 = new javax.swing.JTextField();
        sup1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jPanel1.setLayout(null);

        jButton4.setText("FACTURACION");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(30, 20, 250, 40);

        jButton3.setText("INDICE DE ENDEUDAMIENTO");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(30, 200, 250, 40);

        jButton2.setText("CPC VS CPP");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(30, 260, 250, 40);

        jButton5.setText("AVERAGE ROI");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(30, 80, 250, 40);

        jButton6.setText("INDICE DE SOLVENCIA");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(30, 140, 250, 40);

        jButton1.setText("FORMULA ITEMS");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(30, 320, 250, 40);

        jButton10.setText("INDICE PRESUPUESTO");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
        });
        jPanel1.add(jButton10);
        jButton10.setBounds(30, 380, 250, 40);

        jButton11.setText("INDICE CONTABLE");
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
        });
        jPanel1.add(jButton11);
        jButton11.setBounds(30, 440, 250, 40);

        add(jPanel1);
        jPanel1.setBounds(30, 80, 310, 500);

        jLabel1.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jLabel1.setText("Modulo Financiero - Contable");
        add(jLabel1);
        jLabel1.setBounds(30, 10, 330, 30);

        jLabel2.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jLabel2.setText("Indices Financieros");
        add(jLabel2);
        jLabel2.setBounds(30, 40, 180, 30);

        jPanel2.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Categoria", "Formula", "Eliminar"
            }
        ));
        jTable1.setRowHeight(24);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(2).setMinWidth(70);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(2).setMaxWidth(70);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 670, 150);

        jLabel3.setText("Tipo:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 200, 110, 30);
        jPanel2.add(jTextField1);
        jTextField1.setBounds(130, 160, 170, 30);

        jLabel4.setText("Formula Base:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 240, 100, 30);

        jTextField2.setEditable(false);
        jTextField2.setText("y=-(0,000003*(X)^3)+(0,0048*(X)^2)-(0,1685*(X))+281,3");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField2);
        jTextField2.setBounds(130, 240, 420, 30);

        jLabel5.setText("y = -(A • x^B) + (C • x^D  ) - (E • x^F ) + G");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(130, 270, 420, 30);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("G");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(10, 510, 50, 30);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("A");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(10, 330, 50, 30);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("B");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(10, 360, 50, 30);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("C");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(10, 390, 50, 30);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("D");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(10, 420, 50, 30);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("E");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(10, 450, 50, 30);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("F");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(10, 480, 50, 30);

        campG.setText("2.20066906");
        jPanel2.add(campG);
        campG.setBounds(80, 510, 240, 30);

        campA.setText("1.124432332");
        jPanel2.add(campA);
        campA.setBounds(80, 330, 240, 30);

        campB.setText("0");
        jPanel2.add(campB);
        campB.setBounds(80, 360, 240, 30);

        campC.setText("-6");
        jPanel2.add(campC);
        campC.setBounds(80, 390, 240, 30);

        campD.setText("2");
        jPanel2.add(campD);
        campD.setBounds(80, 420, 240, 30);

        campE.setText("3.082294841");
        jPanel2.add(campE);
        campE.setBounds(80, 450, 240, 30);

        campF.setText("-3");
        jPanel2.add(campF);
        campF.setBounds(80, 480, 240, 30);

        jLabel13.setText("Resultado:");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(30, 560, 70, 30);
        jPanel2.add(resultadotext);
        resultadotext.setBounds(120, 560, 430, 30);

        jButton7.setText("Actualizar/Crear");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jPanel2.add(jButton7);
        jButton7.setBounds(470, 510, 130, 30);

        jButton8.setText("Nuevo");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jPanel2.add(jButton8);
        jButton8.setBounds(430, 160, 110, 30);

        jLabel14.setVisible(false);
        jPanel2.add(jLabel14);
        jLabel14.setBounds(310, 160, 80, 30);

        jButton9.setText("Generar");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });
        jPanel2.add(jButton9);
        jButton9.setBounds(350, 510, 100, 30);

        jLabel15.setText("Categoria:");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(10, 160, 110, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Formula", "Valor Fijo", "Margen" }));
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(130, 200, 190, 30);

        jLabel16.setText("Limite Superior:");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(360, 420, 90, 30);

        jLabel17.setText("Margen:");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(360, 480, 90, 30);

        jLabel18.setText("Limite Inferior:");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(360, 330, 90, 30);

        jLabel19.setText("Valor:");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(360, 360, 90, 30);

        jLabel20.setText("Margen:");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(360, 390, 90, 30);

        jLabel21.setText("Valor:");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(360, 450, 90, 30);

        sup2.setText("0");
        jPanel2.add(sup2);
        sup2.setBounds(460, 480, 140, 30);

        inf1.setText("0");
        jPanel2.add(inf1);
        inf1.setBounds(460, 360, 140, 30);

        inf2.setText("0");
        jPanel2.add(inf2);
        inf2.setBounds(460, 390, 140, 30);

        sup1.setText("0");
        jPanel2.add(sup1);
        sup1.setBounds(460, 450, 140, 30);

        add(jPanel2);
        jPanel2.setBounds(410, 30, 670, 630);
        jPanel2.setVisible(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 204));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/back.png"))); // NOI18N
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel22MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel22MouseExited(evt);
            }
        });
        add(jLabel22);
        jLabel22.setBounds(930, 530, 50, 50);
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        carga1();
    }//GEN-LAST:event_jButton3MouseClicked
    
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        carga2();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        cambio(jPanel2);
        cargarindexitem();
        limpiar();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row= jTable1.getSelectedRow();
        int col= jTable1.getSelectedColumn();
        if(col==0){
            try{
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                Indexitem index = (Indexitem)helper.obtenerObjeto(Indexitem.class,(Integer)jTable1.getValueAt(row, 2));
                helper.cerrarSesion();
                if(index.getCategoria()!=null){
                    jComboBox1.setSelectedItem(index.getCategoria());
                }else{
                
                }
                jLabel14.setText(Integer.toString(index.getId()));
                jTextField1.setText(index.getTipo());
                resultadotext.setText(index.getFormula());
                campA.setText(index.getTipoa());
                campB.setText(index.getTipob());
                campC.setText(index.getTipoc());
                campD.setText(index.getTipod());
                campE.setText(index.getTipoe());
                campF.setText(index.getTipof());
                campG.setText(index.getTipog());
                sup1.setText(index.getSup1());
                sup2.setText(index.getSup2());
                inf1.setText(index.getInf1());
                inf2.setText(index.getInf2());
            }catch(Exception io){
            
            }
        }
        if(col==2){
            try{
                String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
                if(selectedSiteName.equalsIgnoreCase("cajamarca")){
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    Indexitem index = (Indexitem)helper.obtenerObjeto(Indexitem.class,(Integer)jTable1.getValueAt(row, 2));
                    helper.eliminarObjeto(index);
                    helper.confirmarTransaccion();
                    helper.cerrarSesion();
                    cargarindexitem();
                }
            }catch(Exception io){
            
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        limpiar();
    }//GEN-LAST:event_jButton8MouseClicked

    public void limpiar(){
        jLabel14.setText(null);
        jTextField1.setText(null);
        resultadotext.setText(null);
    }
    
    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            Indexitem index;
            if(jLabel14.getText()!=null){
                index = (Indexitem)helper.obtenerObjeto(Indexitem.class,Integer.parseInt(jLabel14.getText()));
            }else{
                index = new Indexitem();
            }
            index.setTipo(jTextField1.getText());
            index.setCategoria(jComboBox1.getSelectedItem().toString());
            index.setFormula(resultadotext.getText());
            index.setTipoa(campA.getText());
            index.setTipob(campB.getText());
            index.setTipoc(campC.getText());
            index.setTipod(campD.getText());
            index.setTipoe(campE.getText());
            index.setTipof(campF.getText());
            index.setTipog(campG.getText());
            index.setSup1(sup1.getText());
            index.setSup2(sup2.getText());
            index.setInf1(inf1.getText());
            index.setInf2(inf2.getText());
            
            Date d = new Date();
            index.setFecha(new java.sql.Date(d.getTime()));
            helper.crearOrActualizarObjeto(index);
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            cargarindexitem();
            limpiar();
        }catch(Exception io){

        }
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        if(jComboBox1.getSelectedItem().toString().equalsIgnoreCase("Margen")){
            resultadotext.setText("y = x • (1+"+campA.getText()+") ");
        }
        if(jComboBox1.getSelectedItem().toString().equalsIgnoreCase("Valor Fijo")){
            resultadotext.setText("y = x");
        }
        if(jComboBox1.getSelectedItem().toString().equalsIgnoreCase("Formula")){
            resultadotext.setText("y = ("+campA.getText()+"•x^"+campB.getText()+" ) + (("+campC.getText()+"•x^"+campD.getText()+" )) + (("+campE.getText()+"•x^"+campF.getText()+" )) + " +campG.getText());
        }
        
    }//GEN-LAST:event_jButton9MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
        cambio(f1);
        f1.llenartabla1();
        f1.llenartabla2();
    }//GEN-LAST:event_jButton10MouseClicked

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        cambio(f2);
        f2.llenartabla1();
    }//GEN-LAST:event_jButton11MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked

    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseEntered

    }//GEN-LAST:event_jLabel22MouseEntered

    private void jLabel22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseExited

    }//GEN-LAST:event_jLabel22MouseExited
    public void cargarindexitem(){
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            List<Indexitem> list = helper.getListaIndexitem();
            helper.cerrarSesion();
            DefaultTableModel temp2 = (DefaultTableModel) jTable1.getModel();
            for(int i=temp2.getRowCount()-1;i>=0;i--){
                temp2.removeRow(i);
            }
            for(Indexitem i: list){
                DefaultTableModel temp = (DefaultTableModel) jTable1.getModel();
                Object nuevo[]= {i.getTipo(),i.getFormula(),i.getId()};
                temp.addRow(nuevo);
            }
        }catch(Exception io){
        
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campA;
    private javax.swing.JTextField campB;
    private javax.swing.JTextField campC;
    private javax.swing.JTextField campD;
    private javax.swing.JTextField campE;
    private javax.swing.JTextField campF;
    private javax.swing.JTextField campG;
    private javax.swing.JTextField inf1;
    private javax.swing.JTextField inf2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField resultadotext;
    private javax.swing.JTextField sup1;
    private javax.swing.JTextField sup2;
    // End of variables declaration//GEN-END:variables
}
