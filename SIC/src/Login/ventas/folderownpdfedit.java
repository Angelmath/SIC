/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.ventas;

import Login.Entidad.Login;
import Login.Entidad.Owncloud;
import Login.servicio.ServiceHb;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Angelmath
 */
public class folderownpdfedit extends javax.swing.JDialog {
    marco marc;
    Login usuario;
    File grabado;
    Owncloud ow;
    /**
     * Creates new form ingresoU
     * @param parent
     * @param modal
     * @param carpeta
     * @param us
     */
    public folderownpdfedit(java.awt.Frame parent, boolean modal, String carpeta, Login us, Owncloud ow) {
        super(parent, modal);
        initComponents();
        setSize(505,360);
        dispose();
        usuario=us;
        this.ow=ow;
        setUndecorated(true);
        setLocationRelativeTo(null);
        jTextField8.setText(ow.getNombre());
        jTextField2.setText(ow.getDireccion());
        String[] perm = ow.getPermisos().split(" , ");
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            Login logg= (Login) helper.obtenerObjeto(Login.class, Integer.parseInt(ow.getDuenio()));
            jTextField3.setText(logg.getNombre());
            if(perm.length!=0){
                for(String x: perm){
                    Login lg=null;
                    helper.iniciarTransaccion();
                    lg= (Login) helper.obtenerObjeto(Login.class, Integer.parseInt(x));
                    jTextField3.setText(logg.getNombre());
                    helper.cerrarSesion();
                    int con=0;
                    for(int i=0; i< jComboBox8.getItemCount();i++){
                        if(jComboBox8.getItemAt(i).toString().equalsIgnoreCase(lg.getNombre())){
                            con=1;
                        }
                    }
                    if(con==0){
                        jComboBox8.addItem(lg.getNombre());
                        jComboBox1.addItem(lg);
                    }
                }
            }
            helper.cerrarSesion();
        }catch(Exception io){
            
        }
        setVisible(true);
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

    public JTextField getjTextField2() {
        return jTextField2;
    }

    public void setjTextField2(JTextField jTextField2) {
        this.jTextField2 = jTextField2;
    }
    public void alt (Component bt, String text){
        jLabel9.setVisible(true);
        jLabel9.setText(text);
        jLabel9.setSize((int)jLabel9.getMinimumSize().getWidth(), 25);
        jLabel9.setLocation(bt.getX()+bt.getWidth(), bt.getY()-25);
    }
    public JTextField getjTextField3() {
        return jTextField3;
    }

    public void setjTextField3(JTextField jTextField3) {
        this.jTextField3 = jTextField3;
    }

    public JTextField getjTextField8() {
        return jTextField8;
    }

    public void setjTextField8(JTextField jTextField8) {
        this.jTextField8 = jTextField8;
    }

    public JButton getjButton4() {
        return jButton4;
    }

    public void setjButton4(JButton jButton4) {
        this.jButton4 = jButton4;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBox8 = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso");
        setBackground(new java.awt.Color(153, 153, 153));
        setMinimumSize(new java.awt.Dimension(378, 348));
        getContentPane().setLayout(null);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel9.setText("jLabel8");
        jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(214, 214, 214), new java.awt.Color(214, 214, 214), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        jLabel9.setOpaque(true);
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 0, 70, 25);
        jLabel9.setVisible(false);

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
        jButton4.setBounds(350, 260, 49, 29);

        jLabel2.setFont(new java.awt.Font("Roboto Light", 3, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("EDITAR ARCHIVO PDF");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(100, 30, 330, 30);

        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel4.setText("Nombre:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 90, 110, 30);

        jLabel5.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel5.setText("Carpeta:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 120, 110, 30);

        jLabel6.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel6.setText("Propietario:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 150, 140, 30);

        jLabel8.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel8.setText("PDF:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(40, 210, 140, 30);

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(190, 120, 240, 30);

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3);
        jTextField3.setBounds(190, 150, 240, 30);

        jTextField8.setEditable(false);
        jTextField8.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        getContentPane().add(jTextField8);
        jTextField8.setBounds(190, 90, 240, 30);

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
        jButton1.setBounds(140, 260, 49, 29);

        jComboBox8.setFont(new java.awt.Font("Roboto Medium", 0, 10)); // NOI18N
        getContentPane().add(jComboBox8);
        jComboBox8.setBounds(190, 180, 240, 30);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-addevent-lightblue.png"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
        });
        getContentPane().add(jLabel17);
        jLabel17.setBounds(440, 180, 17, 30);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-delete-lightblue.png"))); // NOI18N
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel18MouseExited(evt);
            }
        });
        getContentPane().add(jLabel18);
        jLabel18.setBounds(470, 180, 21, 30);

        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(450, 150, 40, 30);
        jComboBox1.setVisible(false);

        jLabel10.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel10.setText("Visibilidad:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(40, 180, 140, 30);

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4);
        jTextField4.setBounds(190, 210, 240, 30);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-addevent-lightblue.png"))); // NOI18N
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel19MouseExited(evt);
            }
        });
        getContentPane().add(jLabel19);
        jLabel19.setBounds(440, 210, 17, 30);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-eliminar.png"))); // NOI18N
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton5MouseExited(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(250, 260, 49, 29);

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 530, 310);

        getAccessibleContext().setAccessibleParent(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        dispose(); 
    }//GEN-LAST:event_jButton4MouseClicked

    public marco getMarc() {
        return marc;
    }

    public void setMarc(marco marc) {
        this.marc = marc;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if((grabado!=null)){
            String carpeta=nombrecarpeta(jTextField2.getText());
            try{
                ow.setDuenio(""+usuario.getId());
                ow.setNombre(jTextField8.getText());
                ow.setDireccion(jTextField2.getText());
                String cad="";
                if(jComboBox1.getItemCount()!=0){
                    for(int i=0; i<jComboBox1.getItemCount();i++){
                        cad=cad+" , "+((Login)jComboBox1.getItemAt(i)).getId();
                    }
                    cad=cad.substring(2, cad.length());
                }
                ow.setPermisos(cad);
                crearpdf(grabado,carpeta,jTextField8.getText());
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                helper.actualizarObjeto(ow);
                helper.confirmarTransaccion();
                helper.cerrarSesion();
            }catch(Exception io){
            }
            JOptionPane.showMessageDialog(null, "PDF Agregado");
            dispose(); 
        }else{
            JOptionPane.showMessageDialog(null, "Faltan Campos");
        }
        
    }//GEN-LAST:event_jButton1MouseClicked

    public String nombrecarpeta(String nombre){
        if(nombre.contains("SEG. Electrónica")){
            return "SIC PDF/Seguridad Electronica";
        }
        if(nombre.contains("SEG. Física")){
            return "SIC PDF/Seguridad Fisica";
        }
        if(nombre.contains("RRHH")){
            return "SIC PDF/RRHH";
        }
        if(nombre.contains("Comercial")){
            return "SIC PDF/Comercial";
        }
        if(nombre.contains("Varios")){
            return "SIC PDF/Varios";
        }
        
        return "";
    }
    
    public void crearpdf(File entrada,String carpeta,String nombre){
        try{
            File archivoEntrada = entrada;
            //Mostrar el nombre del archvivo en un campo de texto
            String direccion= usuario.getOwncloud();
            File archivoSalida = new File(direccion+carpeta+"/"+nombre+".pdf");
            if(!archivoSalida.exists()) {
                archivoSalida.createNewFile();
            }



            FileChannel source = null;

            FileChannel destination = null;

            try {

                source = new FileInputStream(archivoEntrada).getChannel();

                destination = new FileOutputStream(archivoSalida).getChannel();

                destination.transferFrom(source, 0, source.size());

            }

            finally {

                if(source != null) {

                    source.close();

                }

                if(destination != null) {

                    destination.close();

                }

            }
        }catch(Exception io){}
    }
    
    public boolean existpdf(String carpeta,String nombre){
        try{
            String direccion= usuario.getOwncloud();
            File archivoSalida = new File(direccion+carpeta+"/"+nombre+".pdf");
            if(archivoSalida.exists()) {
                return false;
            }
        }catch(Exception io){}
        return true;
    }
    
    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        alt(jButton1,"Aceptar");
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jLabel9.setVisible(false);
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        alt(jButton4,"Salir");
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        jLabel9.setVisible(false);
    }//GEN-LAST:event_jButton4MouseExited

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        calendariovinculos cla = new calendariovinculos(null, true);
        if(cla.getSelected()!=null){
            int con=0;
            for(int i=0; i< jComboBox8.getItemCount();i++){
                if(jComboBox8.getItemAt(i).toString().equalsIgnoreCase(cla.getSelected().getNombre())){
                    con=1;
                }
            }
            if(con==0){
                jComboBox8.addItem(cla.getSelected().getNombre());
                jComboBox1.addItem(cla.getSelected());
            }
        }
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseEntered
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-addevent-darkblue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel17MouseEntered

    private void jLabel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseExited
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-addevent-lightblue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel17MouseExited

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        if(jComboBox8.getItemCount()>0){
            jComboBox1.removeItemAt(jComboBox8.getSelectedIndex());
            jComboBox8.removeItemAt(jComboBox8.getSelectedIndex());
        }
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-delete-darkblue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel18MouseEntered

    private void jLabel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseExited
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-delete-lightblue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel18MouseExited

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        JFileChooser chooser = new JFileChooser();
        
        chooser.addChoosableFileFilter(new FileNameExtensionFilter("PDF Documents", "pdf"));
        chooser.setAcceptAllFileFilterUsed(false);
        int valido=0;
        int respuesta = chooser.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION)
        {
            File file = chooser.getSelectedFile();
            jTextField4.setText(file.getAbsolutePath());
            grabado=file;
        }
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseEntered

    private void jLabel19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseExited

    public void eliminarpdf(String carpeta,String nombre){
        try{
            String direccion= usuario.getOwncloud();
            File archivoSalida = new File(direccion+carpeta+"/"+nombre+".pdf");
            if(archivoSalida.exists()) {
                archivoSalida.delete();
            }
        }catch(Exception io){}
    }
    
    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
        if(selectedSiteName.equalsIgnoreCase("cajamarca")){
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            helper.eliminarObjeto(ow);
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            String carpeta=nombrecarpeta(jTextField2.getText());
            eliminarpdf(carpeta, jTextField8.getText());
            JOptionPane.showMessageDialog(null, "PDF eliminado");
        }catch(Exception io){
        
        }
        dispose();
        }
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseExited

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
            java.util.logging.Logger.getLogger(folderownpdfedit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(folderownpdfedit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(folderownpdfedit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(folderownpdfedit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                folderownpdfedit dialog = new folderownpdfedit(new javax.swing.JFrame(), true,"",null,null);
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
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}