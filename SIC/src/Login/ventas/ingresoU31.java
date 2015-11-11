/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.ventas;

import Login.Entidad.Instalacion;
import com.toedter.calendar.JDateChooser;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Login.servicio.Funcion;
import Login.servicio.ServiceHb;
import java.awt.Component;

/**
 *
 * @author Angelmath
 */
public final class ingresoU31 extends javax.swing.JDialog {
    marco padre;
    instalacion empl;
    String cl;
    int toca;
    Instalacion in;
    /**
     * Creates new form ingresoU
     */
    public ingresoU31(java.awt.Frame parent, marco padre, boolean modal, instalacion log,String cl,int tipo,String nivel) {
        super(parent, modal);
        initComponents();
        this.padre=padre;
        this.cl=cl;
        this.toca=tipo;
        this.empl=log;         
        setSize(510,420);
        if(!nivel.equalsIgnoreCase("Administrador")){
        getjComboBox2().setEnabled(false);
        }
        
        setLocationRelativeTo(null);
        if(toca==1){
            try {
                ServiceHb neo = new ServiceHb();
                neo.iniciarTransaccion();
                in= (Instalacion) neo.obtenerObjeto(Instalacion.class,Integer.parseInt(cl));
                neo.confirmarTransaccion();
                neo.cerrarTransaccion();
                neo.cerrarSesion();
                getjTextField1().setText(in.getDireccion());
                getjTextField2().setText(in.getCiudad());
                getjDateChooser1().setDate(Funcion.StringToDate(in.getFecha()));
                
                if(in.getTipo().equalsIgnoreCase("Instalación")){
                getjComboBox1().setSelectedIndex(0);
                }
                if(in.getTipo().equalsIgnoreCase("Soporte Técnico")){
                getjComboBox1().setSelectedIndex(1);
                }
                if(in.getTipo().equalsIgnoreCase("Venta Directa")){
                getjComboBox1().setSelectedIndex(2);
                }
                if(in.getTipo().equalsIgnoreCase("Poligrafos")){
                getjComboBox1().setSelectedIndex(3);
                }
                if(in.getTipo().equalsIgnoreCase("Guardianía")){
                getjComboBox1().setSelectedIndex(4);
                }
                
                
                if(in.getProceso().equalsIgnoreCase("En Diseño")){
                getjComboBox2().setSelectedIndex(0);
                }if(in.getProceso().equalsIgnoreCase("Espera Aprobación Tecnica")){
                getjComboBox2().setSelectedIndex(1);
                }if(in.getProceso().equalsIgnoreCase("Aprobación Tecnica")){
                getjComboBox2().setSelectedIndex(2);
                }
                if(in.getProceso().equalsIgnoreCase("Enviada a Cliente")){
                getjComboBox2().setSelectedIndex(3);
                }
                if(in.getProceso().equalsIgnoreCase("Aceptada por Cliente")){
                getjComboBox2().setSelectedIndex(4);
                }
                if(in.getProceso().equalsIgnoreCase("Rechazada por Cliente")){
                getjComboBox2().setSelectedIndex(5);
                }
                if(in.getProceso().equalsIgnoreCase("Espera Aprobación Financiera")){
                getjComboBox2().setSelectedIndex(6);
                }
                if(in.getProceso().equalsIgnoreCase("Aprobación Financiera")){
                getjComboBox2().setSelectedIndex(7);
                }
                if(in.getProceso().equalsIgnoreCase("En Curso")){
                getjComboBox2().setSelectedIndex(8);
                }
                if(in.getProceso().equalsIgnoreCase("Culminada")){
                getjComboBox2().setSelectedIndex(9);
                }
                if(in.getProceso().equalsIgnoreCase("Facturado")){
                getjComboBox2().setSelectedIndex(10);
                }
                if(in.getProceso().equalsIgnoreCase("Cancelado")){
                getjComboBox2().setSelectedIndex(11);
                }
                
            } catch (Exception ex) {
                Logger.getLogger(ingresoU31.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        setVisible(true);
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public int getToca() {
        return toca;
    }

    public void setToca(int toca) {
        this.toca = toca;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JComboBox getjComboBox2() {
        return jComboBox2;
    }

    public void setjComboBox2(JComboBox jComboBox2) {
        this.jComboBox2 = jComboBox2;
    }

    public marco getPadre() {
        return padre;
    }

    public void setPadre(marco padre) {
        this.padre = padre;
    }

    public JButton getjButton4() {
        return jButton4;
    }

    public void setjButton4(JButton jButton4) {
        this.jButton4 = jButton4;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso");
        setMinimumSize(new java.awt.Dimension(500, 400));
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
        jButton4.setBounds(300, 330, 49, 29);

        jLabel2.setFont(new java.awt.Font("Roboto Light", 3, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Seguimiento Financiero");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 20, 340, 40);

        jLabel7.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel7.setText("Tipo:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(60, 230, 110, 30);

        jLabel8.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel8.setText("Fecha:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(60, 200, 110, 30);

        jComboBox1.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Instalación", "Soporte Técnico", "Venta Directa", "Poligrafos", "Guardianía" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(230, 230, 190, 30);

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
        jButton1.setBounds(170, 330, 49, 29);

        jDateChooser1.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        getContentPane().add(jDateChooser1);
        jDateChooser1.setBounds(230, 200, 190, 30);

        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel4.setText("Estado:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 260, 80, 30);

        jComboBox2.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "En Diseño", "Espera Aprobación Tecnica", "Aprobación Tecnica", "Enviada a Cliente", "Aceptada por Cliente", "Rechazada por Cliente", "Espera Aprobación Financiera", "Aprobación Financiera", "En Curso", "Culminada", "Facturado", "Cancelado" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(230, 260, 190, 30);

        jLabel5.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel5.setText("Ciudad:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(180, 80, 80, 30);

        jTextField1.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        getContentPane().add(jTextField1);
        jTextField1.setBounds(230, 140, 190, 30);

        jTextField2.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        getContentPane().add(jTextField2);
        jTextField2.setBounds(230, 170, 190, 30);

        jLabel9.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel9.setText("Contado");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(60, 80, 110, 30);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "50% Anticipo", "50% Saldo" }));
        getContentPane().add(jComboBox3);
        jComboBox3.setBounds(60, 120, 110, 30);

        jLabel1.setBackground(new java.awt.Color(242, 242, 242));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 620, 380);

        getAccessibleContext().setAccessibleParent(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        dispose(); 
        
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
   
    }//GEN-LAST:event_jButton1MouseClicked

    public Instalacion getIn() {
        return in;
    }

    public void setIn(Instalacion in) {
        this.in = in;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
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
       
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed
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

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        jLabel11.setVisible(false);
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jLabel11.setVisible(false);
    }//GEN-LAST:event_jButton1MouseExited

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed
    
    public JButton getjButton1() {
        return jButton1;
    }

    public String getCl() {
        return cl;
    }

    public void setCl(String cl) {
        this.cl = cl;
    }

    public JComboBox getjComboBox1() {
        return jComboBox1;
    }

    public void setjComboBox1(JComboBox jComboBox1) {
        this.jComboBox1 = jComboBox1;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public instalacion getEmpl() {
        return empl;
    }

    public void setEmpl(instalacion empl) {
        this.empl = empl;
    }

    public JDateChooser getjDateChooser1() {
        return jDateChooser1;
    }

    public void setjDateChooser1(JDateChooser jDateChooser1) {
        this.jDateChooser1 = jDateChooser1;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
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
            java.util.logging.Logger.getLogger(ingresoU31.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ingresoU31.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ingresoU31.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ingresoU31.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ingresoU31 dialog = new ingresoU31(new javax.swing.JFrame(),null, true,null,null,0,"");
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
