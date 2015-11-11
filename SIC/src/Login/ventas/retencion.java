/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.ventas;

import Login.Entidad.Login;
import Login.Entidad.Retencionfactu;
import java.io.File;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Login.servicio.Funcion;
import Login.servicio.ServiceHb;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.text.DecimalFormat;

/**
 *
 * @author Angelmath
 */
public final class retencion extends javax.swing.JDialog {
    marco padre;
    instalacion empl;
    String cl;
    Login Usuario;
    String razon;
    String insta;
    String proforma;
    String nombre;
    int id;
    File archivoEntrada=null;
    File archivoEntrada2=null;
    String actual="";
    String prove="";
    Retencionfactu ret=null;
    facturaspago pago=null;
    Double dou=0.0;
    /**
     * Creates new form ingresoU
     */
    public retencion(java.awt.Frame parent, marco padre, boolean modal, Retencionfactu ret, facturaspago pago,Double dou) {
        super(parent,modal);
        this.padre=padre;
        this.ret=ret;
        this.pago=pago;
        this.dou=dou;
        initComponents();       
        setSize(500,560);
        setLocationRelativeTo(null);
        Date d = new Date();
        actual=Funcion.DateFormat(d);
        if(ret!=null){
            jTextField4.setText(ret.getIdnombre());
            jTextField5.setText(ret.getSri());
            jTextField6.setText(ret.getValor1());
            jTextField7.setText(ret.getValor2());
            jTextField10.setText(ret.getValor8());
            jTextField11.setText(ret.getValor10());
            jTextField12.setText(ret.getValor30());
            jTextField13.setText(ret.getValor70());
            jTextField14.setText(ret.getValor100());
            jTextField8.setText(ret.getTotal());
            jDateChooser1.setDate(ret.getFecha());
        }else{
            DecimalFormat df = new DecimalFormat("#0.00");
            jTextField6.setText(df.format((dou*0.01)).replace(",", "."));
            jTextField7.setText(df.format((dou*0.02)).replace(",", "."));
            jTextField10.setText(df.format((dou*0.08)).replace(",", "."));
            jTextField11.setText(df.format((dou*0.1)).replace(",", "."));
            jTextField12.setText(df.format((dou*0.3)).replace(",", "."));
            jTextField13.setText(df.format((dou*0.7)).replace(",", "."));
            jTextField14.setText(df.format((dou)).replace(",", "."));
        }
        setVisible(true);
        
    }
    
    public void suma(){
            float val1 = Float.parseFloat(jTextField6.getText());
            float val2 = Float.parseFloat(jTextField7.getText());
            float val3 = Float.parseFloat(jTextField10.getText());
            float val7 = Float.parseFloat(jTextField11.getText());
            float val4 = Float.parseFloat(jTextField12.getText());
            float val5 = Float.parseFloat(jTextField13.getText());
            float val6 = Float.parseFloat(jTextField14.getText());
            DecimalFormat df = new DecimalFormat("#0.00");
            jTextField8.setText(df.format(val1+val2+val3+val4+val5+val6+val7).replace(",", "."));
    }
    
    public Retencionfactu getRet() {
        return ret;
    }

    public void setRet(Retencionfactu ret) {
        this.ret = ret;
    }

    public JDateChooser getjDateChooser1() {
        return jDateChooser1;
    }

    public void setjDateChooser1(JDateChooser jDateChooser1) {
        this.jDateChooser1 = jDateChooser1;
    }

    public JLabel getjLabel11() {
        return jLabel11;
    }

    public void setjLabel11(JLabel jLabel11) {
        this.jLabel11 = jLabel11;
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

    public JLabel getjLabel23() {
        return jLabel23;
    }

    public void setjLabel23(JLabel jLabel23) {
        this.jLabel23 = jLabel23;
    }

    public JTextField getjTextField10() {
        return jTextField10;
    }

    public void setjTextField10(JTextField jTextField10) {
        this.jTextField10 = jTextField10;
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

    public JTextField getjTextField7() {
        return jTextField7;
    }

    public void setjTextField7(JTextField jTextField7) {
        this.jTextField7 = jTextField7;
    }

    public Login getUsuario() {
        return Usuario;
    }

    public void setUsuario(Login Usuario) {
        this.Usuario = Usuario;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getInsta() {
        return insta;
    }

    public void setInsta(String insta) {
        this.insta = insta;
    }

    public String getProforma() {
        return proforma;
    }

    public void setProforma(String proforma) {
        this.proforma = proforma;
    }

    public File getArchivoEntrada2() {
        return archivoEntrada2;
    }

    public void setArchivoEntrada2(File archivoEntrada2) {
        this.archivoEntrada2 = archivoEntrada2;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public File getArchivoEntrada() {
        return archivoEntrada;
    }

    public void setArchivoEntrada(File archivoEntrada) {
        this.archivoEntrada = archivoEntrada;
    }

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
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

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public marco getPadre() {
        return padre;
    }

    public void setPadre(marco padre) {
        this.padre = padre;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel24 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso");
        setMinimumSize(new java.awt.Dimension(500, 510));
        getContentPane().setLayout(null);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel11.setText("jLabel8");
        jLabel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(214, 214, 214), new java.awt.Color(214, 214, 214), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        jLabel11.setOpaque(true);
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, 0, 70, 25);
        jLabel11.setVisible(false);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-salir.png"))); // NOI18N
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(310, 480, 49, 29);

        jLabel2.setFont(new java.awt.Font("Roboto Light", 3, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Retencion");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 40, 340, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-aceptar.png"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(140, 480, 49, 29);

        jLabel8.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel8.setText("Numero:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(50, 90, 150, 30);

        jTextField8.setEditable(false);
        jTextField8.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField8.setOpaque(false);
        getContentPane().add(jTextField8);
        jTextField8.setBounds(250, 430, 190, 30);

        jTextField4.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField4.setText("001-001");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4);
        jTextField4.setBounds(250, 90, 190, 30);

        jTextField5.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField5.setText("111");
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5);
        jTextField5.setBounds(250, 120, 190, 30);

        jTextField6.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField6.setText("000.00");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField6KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField6);
        jTextField6.setBounds(250, 150, 190, 30);

        jLabel14.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel14.setText("Valor 1%:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(50, 150, 140, 30);

        jLabel9.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel9.setText("Total a Retencion:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(50, 430, 140, 30);

        jLabel10.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel10.setText("AUT. S.R.I.");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(50, 120, 130, 30);

        jTextField7.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField7.setText("000.00");
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField7KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField7);
        jTextField7.setBounds(250, 180, 190, 30);

        jLabel18.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel18.setText("Valor 2%:");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(50, 180, 140, 30);

        jLabel19.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel19.setText("Valor 10%:");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(50, 240, 140, 30);

        jTextField10.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField10.setText("000.00");
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField10KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField10);
        jTextField10.setBounds(250, 210, 190, 30);

        jTextField12.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField12.setText("000.00");
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField12KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField12);
        jTextField12.setBounds(250, 290, 190, 30);

        jLabel20.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel20.setText("Valor 30%:");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(50, 290, 140, 30);

        jTextField13.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField13.setText("000.00");
        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });
        jTextField13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField13KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField13);
        jTextField13.setBounds(250, 320, 190, 30);

        jLabel21.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel21.setText("Valor 70%:");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(50, 320, 140, 30);

        jLabel22.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel22.setText("Fecha:");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(50, 380, 140, 30);

        jTextField14.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField14.setText("000.00");
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });
        jTextField14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField14KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField14);
        jTextField14.setBounds(250, 350, 190, 30);

        jLabel23.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel23.setText("Valor 100%:");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(50, 350, 140, 30);
        getContentPane().add(jDateChooser1);
        jDateChooser1.setBounds(250, 380, 190, 30);

        jLabel24.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel24.setText("Valor 8%:");
        getContentPane().add(jLabel24);
        jLabel24.setBounds(50, 210, 140, 30);

        jTextField11.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField11.setText("000.00");
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField11KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField11);
        jTextField11.setBounds(250, 240, 190, 30);

        getAccessibleContext().setAccessibleParent(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        dispose(); 
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try{
            if(ret!=null){
                ret.setSri(jTextField5.getText());
                ret.setValor1(jTextField6.getText());
                ret.setValor2(jTextField7.getText());
                ret.setValor8(jTextField10.getText());
                ret.setValor30(jTextField12.getText());
                ret.setValor70(jTextField13.getText());
                ret.setValor100(jTextField14.getText());
                ret.setFecha(new java.sql.Date(jDateChooser1.getDate().getTime()));
                ret.setTotal(jTextField8.getText());
            }else{
                ret= new Retencionfactu();
                ret.setIdnombre(jTextField4.getText());
                ret.setSri(jTextField5.getText());
                ret.setValor1(jTextField6.getText());
                ret.setValor2(jTextField7.getText());
                ret.setValor8(jTextField10.getText());
                ret.setValor30(jTextField12.getText());
                ret.setValor70(jTextField13.getText());
                ret.setValor100(jTextField14.getText());
                ret.setFecha(new java.sql.Date(jDateChooser1.getDate().getTime()));
                ret.setTotal(jTextField8.getText());
            }
            pago.setRetencion(ret);
            pago.getjTextField5().setText(ret.getIdnombre());
            pago.getjTextField7().setText(ret.getTotal());
            pago.updatetable();
            JOptionPane.showMessageDialog(null,"Retencion Agregada");
            dispose();
        }catch(Exception io){
        
        }
    }//GEN-LAST:event_jButton1MouseClicked
    
    public boolean validacion(){

        if(getjTextField4().getText().equalsIgnoreCase("")){
            JOptionPane.showConfirmDialog(null, "Numero de la Retencion no Ingresado", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
            return false;
        }
        if(getjTextField5().getText().equalsIgnoreCase("")){
            JOptionPane.showConfirmDialog(null, "Valor de la Retencion No Ingresado", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
            return false;
        }
        if(getjTextField6().getText().equalsIgnoreCase("")){
            JOptionPane.showConfirmDialog(null, "PDF de la Retencion no Ingresado", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
            return false;
        }
        if(getjTextField8().getText().equalsIgnoreCase("")){
            JOptionPane.showConfirmDialog(null, "AUT. S.R.I. de la Retencion no Ingresado", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
            return false;
        }
        
    return true;
    }
    
    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    
    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed
    public void alt (Component bt, String text){
        jLabel11.setVisible(true);
        jLabel11.setText(text);
        jLabel11.setSize((int)jLabel11.getMinimumSize().getWidth(), 25);
        jLabel11.setLocation(bt.getX()+bt.getWidth(), bt.getY()-25);
    }  
    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
                alt(jButton1,"Aceptar");
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        alt(jButton4,"Salir");
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jLabel11.setVisible(false);
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        jLabel11.setVisible(false);
    }//GEN-LAST:event_jButton4MouseExited

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void jTextField6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyPressed
     suma();    
    }//GEN-LAST:event_jTextField6KeyPressed

    private void jTextField7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyPressed
suma();          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7KeyPressed

    private void jTextField10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyPressed
suma();          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10KeyPressed

    private void jTextField12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyPressed
suma();          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12KeyPressed

    private void jTextField13KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyPressed
suma();          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13KeyPressed

    private void jTextField14KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField14KeyPressed
suma();          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14KeyPressed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11KeyPressed
    
        
    public instalacion getEmpl() {
        return empl;
    }

    public void setEmpl(instalacion empl) {
        this.empl = empl;
    }

    public String getCl() {
        return cl;
    }

    public void setCl(String cl) {
        this.cl = cl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProve() {
        return prove;
    }

    public void setProve(String prove) {
        this.prove = prove;
    }

    public JLabel getjLabel14() {
        return jLabel14;
    }

    public void setjLabel14(JLabel jLabel14) {
        this.jLabel14 = jLabel14;
    }

    public JTextField getjTextField8() {
        return jTextField8;
    }

    public void setjTextField8(JTextField jTextField8) {
        this.jTextField8 = jTextField8;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public JButton getjButton4() {
        return jButton4;
    }

    public void setjButton4(JButton jButton4) {
        this.jButton4 = jButton4;
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(retencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(retencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(retencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(retencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
