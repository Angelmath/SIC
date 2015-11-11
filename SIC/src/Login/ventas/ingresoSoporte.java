/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.ventas;

import Login.Entidad.Clientes;
import Login.Entidad.Instalacion;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import Login.servicio.Funcion;
import Login.servicio.ServiceHb;
import java.awt.Component;
import java.util.Calendar;

/**
 *
 * @author Angelmath
 */
public final class ingresoSoporte extends javax.swing.JDialog {
    marco padre;
    instalacion empl;
    String cl;
    int toca;
    Instalacion in;
    /**
     * Creates new form ingresoU
     * @param parent
     * @param padre
     * @param modal
     * @param log
     * @param tipo
     * @param cl
     */
    public ingresoSoporte(java.awt.Frame parent, marco padre, boolean modal, instalacion log,String cl,int tipo) {
        super(parent, modal);
        initComponents();
        this.padre=padre;
        this.cl=cl;
        this.toca=tipo;
        this.empl=log;         
        setSize(510,420);
        setLocationRelativeTo(null);
        Calendar cal = Calendar.getInstance();
        jDateChooser1.setDate(cal.getTime());
        getjComboBox1().setSelectedIndex(1);
        if(toca==1){
            try {
                ServiceHb neo = new ServiceHb();
                neo.iniciarTransaccion();
                in= (Instalacion) neo.obtenerObjeto(Instalacion.class,Integer.parseInt(cl));
                neo.confirmarTransaccion();
                neo.cerrarTransaccion();
                neo.cerrarSesion();
                getjTextArea1().setText(in.getDetalle());
                getjTextField1().setText(in.getDireccion());
                getjTextField2().setText(in.getCiudad());
                jDateChooser1.setDate(Funcion.StringToDate(in.getFecha()));
                
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
                }if(in.getProceso().equalsIgnoreCase("Enviada a Cliente")){
                    getjComboBox2().setSelectedIndex(3);
                }if(in.getProceso().equalsIgnoreCase("Aceptada por Cliente")){
                    getjComboBox2().setSelectedIndex(4);
                }if(in.getProceso().equalsIgnoreCase("Rechazada por Cliente")){
                    getjComboBox2().setSelectedIndex(5);
                }if(in.getProceso().equalsIgnoreCase("Espera Aprobación Financiera")){
                    getjComboBox2().setSelectedIndex(6);
                }if(in.getProceso().equalsIgnoreCase("Aprobación Financiera")){
                    getjComboBox2().setSelectedIndex(7);
                }if(in.getProceso().equalsIgnoreCase("En Curso")){
                    getjComboBox2().setSelectedIndex(8);
                }if(in.getProceso().equalsIgnoreCase("Culminada")){
                    getjComboBox2().setSelectedIndex(9);
                }if(in.getProceso().equalsIgnoreCase("Facturado")){
                    getjComboBox2().setSelectedIndex(10);
                }if(in.getProceso().equalsIgnoreCase("Cancelado")){
                    getjComboBox2().setSelectedIndex(11);
                }
            } catch (Exception ex) {
                Logger.getLogger(ingresoSoporte.class.getName()).log(Level.SEVERE, null, ex);
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

    public JLabel getjLabel3() {
        return jLabel3;
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

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
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
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
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
        jLabel2.setText("Ingreso de Nueva Instalacion:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 20, 340, 40);

        jLabel3.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel3.setText("Detalles Breves:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 80, 110, 30);

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
        jComboBox1.setEnabled(false);
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

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(230, 80, 230, 54);

        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel4.setText("Estado:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 260, 80, 30);

        jComboBox2.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "En Diseño", "Espera Aprobación Tecnica", "Aprobación Tecnica", "Enviada a Cliente", "Aceptada por Cliente", "Rechazada por Cliente", "Espera Aprobación Financiera", "Aprobación Financiera", "En Curso", "Culminada", "Facturado", "Cancelado" }));
        jComboBox2.setEnabled(false);
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
        jLabel5.setBounds(60, 170, 80, 30);

        jLabel6.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel6.setText("Direccion:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(60, 140, 80, 30);

        jTextField1.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        getContentPane().add(jTextField1);
        jTextField1.setBounds(230, 140, 190, 30);

        jTextField2.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        getContentPane().add(jTextField2);
        jTextField2.setBounds(230, 170, 190, 30);

        jDateChooser1.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        getContentPane().add(jDateChooser1);
        jDateChooser1.setBounds(230, 200, 190, 30);

        jLabel1.setBackground(new java.awt.Color(242, 242, 242));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 510, 380);

        getAccessibleContext().setAccessibleParent(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        dispose(); 
        
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if(validacion()){
        if(toca==1){
        in.setDetalle(getjTextArea1().getText());
        in.setFecha(Funcion.DateFormat(jDateChooser1.getDate()));
        in.setProceso(getjComboBox2().getSelectedItem().toString());
        in.setTipo(getjComboBox1().getSelectedItem().toString());
        in.setDireccion(getjTextField1().getText());
        in.setCiudad(getjTextField2().getText());
        try {
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            helper.actualizarObjeto(in);
            helper.confirmarTransaccion();
            helper.cerrarSesion();
           
        } catch (Exception ex) {
            Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
        }
        else{
        if(empl==null){
        Clientes mod;
        Instalacion nuevo = new Instalacion();
        nuevo.setDetalle(getjTextArea1().getText());
        nuevo.setFecha(Funcion.DateFormat(jDateChooser1.getDate()));
        nuevo.setProceso(getjComboBox2().getSelectedItem().toString());
        nuevo.setTipo(getjComboBox1().getSelectedItem().toString());
        nuevo.setDireccion(getjTextField1().getText());
        nuevo.setCiudad(getjTextField2().getText());
        nuevo.setGrupo("1");
        //
        try {
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            mod= (Clientes)helper.obtenerObjeto(Clientes.class,Integer.parseInt(cl));
            nuevo.setClientes(mod);
            helper.crearObjeto(nuevo);
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            JOptionPane.showMessageDialog(null, "Instalacion Agregada");
        } catch (Exception ex) {
            Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
        }
    }}
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

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
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

    public boolean validacion(){
        if(getjTextArea1().getText().equalsIgnoreCase("")){
            JOptionPane.showConfirmDialog(null, "Detalles de la Instalacion no Ingresada", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
            return false;
        }
    return true;
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

    private void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyPressed
        
    }//GEN-LAST:event_jTextArea1KeyPressed

    private void jTextArea1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyTyped
        char caracter = evt.getKeyChar();
        if((evt.getKeyChar()=='/')||(evt.getKeyChar()=='ñ')||(evt.getKeyChar()=='&')||(evt.getKeyChar()=='#')||(evt.getKeyChar()=='#')||(evt.getKeyChar()=='!')){
            evt.consume();
        }else{
            
        }
        
    }//GEN-LAST:event_jTextArea1KeyTyped
    
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

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTextArea getjTextArea1() {
        return jTextArea1;
    }

    public void setjTextArea1(JTextArea jTextArea1) {
        this.jTextArea1 = jTextArea1;
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ingresoSoporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ingresoSoporte dialog = new ingresoSoporte(new javax.swing.JFrame(),null, true,null,null,0);
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
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
