/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.sic_rrhh;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import rrhh.Entidad.Departamento;
import rrhh.servicio.ServiceHb;

/**
 *
 * @author Matheus
 */
public final class lista_empleados extends javax.swing.JPanel {
    Dimension d;
    int X=40;
    int Y=150;
    
    /**
     * Creates new form inicio
     */
    public lista_empleados() {
        initComponents();
        d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width-100, d.height-61);
        jComboBox1.setLocation(((d.width-100)/2)-(jComboBox1.getWidth()/2), jComboBox1.getY());
        
        setVisible(false);
    }

    public void actdepa() {
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            List<Departamento> dep = helper.getdepartamentosByTipo();
            jComboBox1.removeAllItems();
            jComboBox1.addItem("Todos");
            for(Departamento i:dep){
                jComboBox1.addItem(i.getNombre());
            }
            jComboBox1.addItem("Inactivo");
            helper.cerrarSesion();
        }catch(Exception io){
        
        }
    }
    
    public JComboBox getjComboBox1() {
        return jComboBox1;
    }

    public void setjComboBox1(JComboBox jComboBox1) {
        this.jComboBox1 = jComboBox1;
    }

    public void imagenes(String direccion, JLabel label){
        String ex ="";
        
        try{
            URL url = new URL("http://181.198.26.33"+direccion);
            URLConnection urlCon = url.openConnection();
            if (urlCon.getContentType() != null) {//Si hay formato de imagen (No estoy seguro...) 
                    ex = urlCon.getContentType();//Obtiene el tipo de imgen  por Ej.: image/jpg 
                    ex = "." + ex.substring(ex.length() - 3, ex.length());//Cambiamos lo anterior por Ej.: por ".jpg"                     
                    ImageIcon icon = new ImageIcon(url);//Iniciamos imagen en un ImageIcon y luego la 
                    //redimensionamos al tamaño de la etiqueta 
                    ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT)); 
                    label.setIcon(icono);
            }else {//Si urlCon.getContentType()==null 
                    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));//Ponemos cursor x defecto 
                    label.setIcon(null);
            }     
        }catch(Exception io){
        
        }
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }
    
    public JSeparator getjSeparator4() {
        return jSeparator4;
    }

    public void setjSeparator4(JSeparator jSeparator4) {
        this.jSeparator4 = jSeparator4;
    }

    public JSeparator getjSeparator5() {
        return jSeparator5;
    }

    public void setjSeparator5(JSeparator jSeparator5) {
        this.jSeparator5 = jSeparator5;
    }

    public JSeparator getjSeparator6() {
        return jSeparator6;
    }

    public void setjSeparator6(JSeparator jSeparator6) {
        this.jSeparator6 = jSeparator6;
    }

    public JSeparator getjSeparator7() {
        return jSeparator7;
    }

    public void setjSeparator7(JSeparator jSeparator7) {
        this.jSeparator7 = jSeparator7;
    }

    public Dimension getD() {
        return d;
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

    

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

        public JSeparator getjSeparator1() {
        return jSeparator1;
    }

    public void setjSeparator1(JSeparator jSeparator1) {
        this.jSeparator1 = jSeparator1;
    }

    public JSeparator getjSeparator2() {
        return jSeparator2;
    }

    public void setjSeparator2(JSeparator jSeparator2) {
        this.jSeparator2 = jSeparator2;
    }

    public JTextField getjTextField2() {
        return jTextField2;
    }

    public void setjTextField2(JTextField jTextField2) {
        this.jTextField2 = jTextField2;
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
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setEnabled(false);
        setLayout(null);
        add(jSeparator1);
        jSeparator1.setBounds(30, 90, 1020, 10);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator4);
        jSeparator4.setBounds(480, 110, 10, 30);

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator5);
        jSeparator5.setBounds(880, 110, 10, 30);

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator7);
        jSeparator7.setBounds(690, 110, 10, 30);

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator6);
        jSeparator6.setBounds(320, 110, 10, 30);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/agregar-icon-lightblue.png"))); // NOI18N
        add(jLabel3);
        jLabel3.setBounds(270, 50, 30, 20);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator2);
        jSeparator2.setBounds(260, 50, 10, 20);

        jLabel2.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 74, 152));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Lista Empleados");
        add(jLabel2);
        jLabel2.setBounds(30, 50, 220, 24);

        jTextField2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        add(jTextField2);
        jTextField2.setBounds(790, 50, 260, 24);
        jTextField2.setVisible(false);

        jLabel6.setBackground(new java.awt.Color(230, 230, 230));
        jLabel6.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 173, 218));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("CELULAR");
        jLabel6.setOpaque(true);
        add(jLabel6);
        jLabel6.setBounds(880, 110, 170, 30);

        jLabel10.setBackground(new java.awt.Color(230, 230, 230));
        jLabel10.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 173, 218));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("NOMBRES COMPLETOS");
        jLabel10.setOpaque(true);
        add(jLabel10);
        jLabel10.setBounds(40, 110, 280, 30);

        jLabel11.setBackground(new java.awt.Color(230, 230, 230));
        jLabel11.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 173, 218));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("INGRESO");
        jLabel11.setOpaque(true);
        add(jLabel11);
        jLabel11.setBounds(320, 110, 160, 30);

        jLabel12.setBackground(new java.awt.Color(230, 230, 230));
        jLabel12.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 173, 218));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("DEPARTAMENTO");
        jLabel12.setOpaque(true);
        add(jLabel12);
        jLabel12.setBounds(480, 110, 210, 30);

        jLabel13.setBackground(new java.awt.Color(230, 230, 230));
        jLabel13.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 173, 218));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("NACIMIENTO");
        jLabel13.setOpaque(true);
        add(jLabel13);
        jLabel13.setBounds(690, 110, 190, 30);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        add(jPanel1);
        jPanel1.setBounds(40, 140, 1010, 180);

        jComboBox1.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        add(jComboBox1);
        jComboBox1.setBounds(490, 50, 220, 24);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
