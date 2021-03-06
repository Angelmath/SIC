/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.ventas;

import Login.Entidad.Ctecobrar;
import Login.Entidad.Factu;
import Login.Entidad.Instalacion;
import Login.Entidad.Login;
import Login.Entidad.Proyectos;
import Login.Entidad.Report;
import Login.Entidad.Ticket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import Login.servicio.ServiceHb;
import java.awt.Component;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Angelmath
 */
public final class ingresoU71 extends javax.swing.JDialog {
    marco padre;
    instalacion empl;
    String cl;
    int toca;
    Ticket tk;
    Login usuario;
    Instalacion clie;
    String tipo;
    String nombre;
    /**
     * Creates new form ingresoU
     */
    public ingresoU71(java.awt.Frame parent, marco padre, boolean modal,String id, Login usuario,String tip, String nombre) {
        super(parent,modal);
        initComponents();
        List<Report> list4 = null;
        List<Factu> fac =null;
        this.padre=padre;
        this.usuario=usuario;
        this.nombre= nombre;
        setLocationRelativeTo(null);
        this.tipo=tip;
        
        try {
            ServiceHb neo = new ServiceHb();
            neo.iniciarTransaccion();
            tk= (Ticket) neo.obtenerObjeto(Ticket.class,Integer.parseInt(id));
            clie = neo.getlistaInstalacionpyl(tk.getId());
            Proyectos proy = neo.getProyectoVt(Integer.toString(clie.getId()));
            list4= neo.getlistaReporta(Integer.toString(clie.getId()),clie.getSelectt());
            fac= neo.getlistaFactu(Integer.toString(clie.getId()));
            neo.confirmarTransaccion();
            neo.cerrarSesion();
            
            jTextField7.setText(proy.getAnticipo());
            getjTextField3().setText(tk.getCliente());//cliente
            getjTextField4().setText(tk.getContacto());//contacto
            getjTextField5().setText(tk.getProyecto());//proyecto
            getjTextField6().setText(tk.getEstado());//estado
            getjTextArea1().setText(tk.getDetalle());
            if(clie.getFechafactu()!=null){
                jDateChooser1.setDate(clie.getFechaanticipo());
            }
        } catch (Exception ex) {
            Logger.getLogger(ingresoU71.class.getName()).log(Level.SEVERE, null, ex);
        }
        setVisible(true);
    }
    
    public Ticket getTk() {
        return tk;
    }
    
    public void setTk(Ticket tk) {
        this.tk = tk;
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField5 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();

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
        jButton4.setBounds(250, 320, 49, 29);

        jLabel2.setFont(new java.awt.Font("Roboto Light", 3, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Instalacion");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(100, 10, 340, 30);

        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel4.setText("Cliente:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(80, 60, 130, 30);

        jLabel5.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel5.setText("Proyecto:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(80, 120, 130, 30);

        jLabel10.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel10.setText("Estado:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(80, 150, 120, 30);

        jLabel6.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel6.setText("Contacto:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(80, 90, 120, 30);

        jLabel8.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel8.setText("Detalle:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(80, 180, 110, 30);

        jButton2.setText("A");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(410, 270, 40, 30);
        getContentPane().add(jDateChooser1);
        jDateChooser1.setBounds(220, 270, 190, 30);

        jTextField3.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(220, 60, 190, 30);

        jTextField4.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(220, 90, 190, 30);

        jTextField6.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jTextField6);
        jTextField6.setBounds(220, 150, 190, 30);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(220, 180, 230, 60);

        jTextField5.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5);
        jTextField5.setBounds(220, 120, 190, 30);

        jLabel12.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel12.setText("Fecha de Anticipo:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(80, 270, 120, 30);

        jLabel13.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel13.setText("Anticipo:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(80, 240, 90, 30);

        jTextField7.setEditable(false);
        getContentPane().add(jTextField7);
        jTextField7.setBounds(220, 240, 190, 30);

        getAccessibleContext().setAccessibleParent(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        dispose(); 
    }//GEN-LAST:event_jButton4MouseClicked
                
    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed
    public void alt (Component bt, String text){
//        jLabel11.setVisible(true);
//        jLabel11.setText(text);
//        jLabel11.setSize((int)jLabel11.getMinimumSize().getWidth(), 25);
//        jLabel11.setLocation(bt.getX()+bt.getWidth(), bt.getY()-25);
    }             
    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        alt(jButton4,"Salir");
    }//GEN-LAST:event_jButton4MouseEntered
                
    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        jLabel11.setVisible(false);
    }//GEN-LAST:event_jButton4MouseExited
    
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

         try {
            int anticipo=0;
            if(jDateChooser1.getDate()!=null){
                ServiceHb neo = new ServiceHb();
                neo.iniciarTransaccion();
                Instalacion in = clie;
                Proyectos proy = neo.getProyectoVt(Integer.toString(in.getId()));
                Calendar data = Calendar.getInstance();
                data.setTime(jDateChooser1.getDate());
                clie.setFechaanticipo(data.getTime());
                anticipo=Integer.parseInt(proy.getAnticipo());
                
                neo.actualizarObjeto(clie);
                neo.confirmarTransaccion();
                neo.cerrarSesion();
                
                neo = new ServiceHb();
                neo.iniciarTransaccion();
                Instalacion ini = neo.getInstalacionid(Integer.toString(clie.getId()));
                Proyectos p = neo.getProyectos2(Integer.toString(clie.getId()));
                List<Ctecobrar> co = neo.getListaCteCobrar("Anticipo de Pago",ini.getId(),p.getId());
                if(co!=null){
                    for(Ctecobrar i: co){
                        neo.eliminarObjeto(i);
                    }
                }
                neo.confirmarTransaccion();
                neo.cerrarSesion();
                
                neo = new ServiceHb();
                neo.iniciarTransaccion();
                ini = neo.getInstalacionid(Integer.toString(clie.getId()));
                p = neo.getProyectos2(Integer.toString(clie.getId()));
                Calendar c1 = GregorianCalendar.getInstance();
                DecimalFormat df = new DecimalFormat("0.00");
                if(ini.getFechaanticipo()!=null){
                    c1.setTime(ini.getFechaanticipo());
                    Ctecobrar ct= new Ctecobrar();
                    ct.setFecha(new java.sql.Date(clie.getFechaanticipo().getTime()));
                    ct.setCliente(ini.getClientes().getApellido());
                    ct.setIdcliente(ini.getId());
                    ct.setProyecto(p.getObservacion1());
                    ct.setIdproyecto(p.getId());
                    ct.setObservacion(p.getObservacion1());
                    ct.setMontos(df.format(Float.parseFloat(p.getAnticipo())).replace(',', '.'));
                    ct.setPlanpagos("Anticipo de Pago");
                    neo.crearOrActualizarObjeto(ct);
                }
                neo.confirmarTransaccion();
                neo.cerrarSesion();
            }
        }catch(Exception io){
            
        }
    }//GEN-LAST:event_jButton2MouseClicked
    
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
    
    public int getToca() {
        return toca;
    }
    
    public JTextField getjTextField5() {
        return jTextField5;
    }
    
    public void setjTextField5(JTextField jTextField5) {
        this.jTextField5 = jTextField5;
    }
    
    public void setToca(int toca) {
        this.toca = toca;
    }
 
    public JButton getjButton4() {
        return jButton4;
    }
    
    public void setjButton4(JButton jButton4) {
        this.jButton4 = jButton4;
    }
    
    public JLabel getjLabel2() {
        return jLabel2;
    }
    
    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
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
    
    public JTextField getjTextField6() {
        return jTextField6;
    }
    
    public void setjTextField6(JTextField jTextField6) {
        this.jTextField6 = jTextField6;
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
            java.util.logging.Logger.getLogger(ingresoU71.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ingresoU71.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ingresoU71.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ingresoU71.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}

