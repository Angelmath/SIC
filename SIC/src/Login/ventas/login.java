/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Login.ventas;

import Login.Entidad.Clientes;
import Login.Entidad.Instalacion;
import Login.Entidad.Login;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import Login.servicio.ServiceHb;
import java.util.Calendar;
import javax.swing.JOptionPane;
import rrhh.Entidad.Empleado;
import rrhh.Entidad.Roles;
import rrhh.sic_rrhh.JavaMail;

/**
 *
 * @author homemig
 */

public class login extends javax.swing.JFrame {

    /**
     * Creates new form login2
     */
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    
    public login() {
        initComponents();
        setSize(d.width, d.height-1);
        jLabel5.setSize(d.width, d.height-1);
        jPanel2.setLocation((d.width/2)-(jPanel2.getWidth()/2),(d.height/2)-(jPanel2.getHeight()/2) );
        dispose();
        setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        URL url = getClass().getResource("/Login/imagenes/venta_icono.png");
        ImageIcon img = new ImageIcon(url);
        setIconImage(img.getImage());
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventas - Cajamarca");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(450, 500));
        getContentPane().setLayout(null);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-salir-azul.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
        jPanel2.add(jLabel1);
        jLabel1.setBounds(265, 290, 40, 28);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-user.png"))); // NOI18N
        jLabel9.setAlignmentY(0.0F);
        jPanel2.add(jLabel9);
        jLabel9.setBounds(270, 162, 34, 26);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-password.png"))); // NOI18N
        jPanel2.add(jLabel8);
        jLabel8.setBounds(270, 212, 34, 25);

        jLabel2.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel2.setText("Usuario");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(30, 160, 50, 20);

        jLabel3.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel3.setText("Constraseña");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(30, 210, 80, 20);

        jToggleButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-ingresar.png"))); // NOI18N
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseExited(evt);
            }
        });
        jPanel2.add(jToggleButton1);
        jToggleButton1.setBounds(155, 290, 99, 28);

        jTextField1.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 6, 1, 6));
        jTextField1.setMargin(new java.awt.Insets(3, 3, 3, 3));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1);
        jTextField1.setBounds(120, 160, 155, 30);

        jLabel4.setFont(new java.awt.Font("Roboto Medium", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(jLabel4);
        jLabel4.setBounds(121, 242, 170, 20);

        jPasswordField1.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jPasswordField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPasswordField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 6, 1, 6));
        jPasswordField1.setMargin(new java.awt.Insets(3, 3, 3, 3));
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyTyped(evt);
            }
        });
        jPanel2.add(jPasswordField1);
        jPasswordField1.setBounds(120, 210, 155, 29);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/cajamarca-logo.png"))); // NOI18N
        jPanel2.add(jLabel6);
        jLabel6.setBounds(70, 30, 194, 59);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-linea-separadora.png"))); // NOI18N
        jPanel2.add(jLabel7);
        jLabel7.setBounds(30, 110, 274, 1);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(470, 200, 330, 350);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setSize(d.width, d.height);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/fondo-login-1920x1080.png"))); // NOI18N
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 1330, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void logeo() throws Exception{
        JavaMail mail = new JavaMail();
        List<Login> usuario=null;
        String password="";
        String user="";
        ServiceHb helper = new ServiceHb();
        password = new String(getjPasswordField1().getPassword());
        user = getjTextField1().getText();
        try {
            helper.iniciarTransaccion();
            usuario=helper.getlistaUsuarios();
            
            
            } catch (Exception ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
            for(Login i: usuario){
                if(i.getUsuario().equalsIgnoreCase(user)&&i.getPass().equalsIgnoreCase(password)){
                    if(i.getUsuario().equalsIgnoreCase("Antonio Jurado")){
                        Calendar ca = Calendar.getInstance();
                        ca.add(Calendar.DAY_OF_YEAR, 15);
                        java.sql.Date sqlDate = new java.sql.Date(ca.getTimeInMillis());
                        List<Instalacion> lt = helper.getInstalacionnotifi(sqlDate);
                        if(lt!=null){
                            for(Instalacion x: lt){
                                mail.email("Notificacion de Instalacion con 15 Dias de Culminado","Saludos Sr. Antonio Jurado este es un Correo generado de SIC Cajamarca indicando que la Instalacion: "+x.getDetalle()+" "
                                        + "del Cliente: "+x.getClientes().getApellido()+" ha superado los 15 dias en el estado de Culminado por favor revisarlo.","antonio.jurado@cajamarca.ec");
                            }
                        }
                    }
                    new permisos(i).setVisible(true);
                    helper.cerrarSesion();
                    dispose();
                }
            }
            helper.cerrarSesion();
        
        getjLabel4().setText("Error de Usuario o Contraseña");
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }
    
    private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseClicked
//        try{
//            rrhh.servicio.ServiceHb helper = new rrhh.servicio.ServiceHb();
//            helper.iniciarTransaccion();
//            List<Roles> ltrol = helper.getRolesByTipo();
//            if(ltrol!=null){
//                for(Roles i: ltrol){
//                    Empleado emp = helper.getPersonasCid2(i.getCi());
//                    if(emp==null){
//                        
//                    }else{
//                        System.out.println(emp.getNombre1()+";"+emp.getApellido1()+";"+emp.getCid()+";"+i.getMes()+";"+i.getAnio()+";"+i.getFondos());
//                    }
//                    
//                }
//            }
//            helper.cerrarSesion();
//        }catch(Exception io){
//        
//        }
        try {
            logeo();
        } catch (Exception ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jToggleButton1MouseClicked

    private void jPasswordField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyTyped
        
    }//GEN-LAST:event_jPasswordField1KeyTyped

    public Dimension getD() {
        return d;
    }

    public void setD(Dimension d) {
        this.d = d;
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

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            try {
                logeo();
            } catch (Exception ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jPasswordField1KeyPressed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
         System.exit(0); 
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-salir-azul-hover.png"))); // NOI18N
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-salir-azul.png"))); // NOI18N
    }//GEN-LAST:event_jLabel1MouseExited

    private void jToggleButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseEntered
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-ingresar-hover.png"))); // NOI18N
    }//GEN-LAST:event_jToggleButton1MouseEntered

    private void jToggleButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseExited
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-ingresar.png"))); // NOI18N
    }//GEN-LAST:event_jToggleButton1MouseExited

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
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

    public JPasswordField getjPasswordField1() {
        return jPasswordField1;
    }

    public void setjPasswordField1(JPasswordField jPasswordField1) {
        this.jPasswordField1 = jPasswordField1;
    }

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }

    public JToggleButton getjToggleButton1() {
        return jToggleButton1;
    }

    public void setjToggleButton1(JToggleButton jToggleButton1) {
        this.jToggleButton1 = jToggleButton1;
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
