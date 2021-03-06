/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.ventas;

import Login.Entidad.Estatico;
import Login.Entidad.Instalacion;
import Login.Entidad.Login;
import Login.Entidad.Notificaciones;
import Login.Entidad.Proyectos;
import Login.Entidad.Report;
import Login.Entidad.Ticket;
import Login.servicio.ServiceHb;
import com.sun.pdfview.PDFFile;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Angelmath
 */
public final class pylproformassoporte extends javax.swing.JDialog {
    marco padre;
    Instalacion in;
    Login usuario;
    List<Proyectos> list2;
    List<Report> list3;
    String nombre1;
    String nombre2;
    String idrecliente;
    String idrpinsta;
    String idproyecto;
    String subproyecto;
    int pdfcarga;
    /**
     * Creates new form ingresoU
     * @param parent
     * @param padre
     * @param modal
     * @param idcliente
     * @param nombrecliente
     * @param idinsta
     * @param nombreinsta
     */
    public pylproformassoporte(java.awt.Frame parent, marco padre, boolean modal, String idcliente,String nombrecliente, String idinsta, String nombreinsta, Login us) {
        super(parent, modal);
        initComponents();
        this.padre=padre;
        nombre1=nombrecliente;
        nombre2=nombreinsta;
        this.idrecliente=idcliente;
        this.idrpinsta=idinsta;
        setSize(500,376);
        setLocationRelativeTo(null);
        usuario=us;
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            in= (Instalacion)helper.obtenerObjeto(Instalacion.class, Integer.parseInt(idinsta));
            nombre1=in.getClientes().getApellido();
            list2= helper.getlistaProyectos1a(""+in.getId(),"1");
            list3= helper.getlistaReport(idrpinsta);
            helper.cerrarSesion();
            if(list2!=null){
                jTextField5.setText(list2.get(0).getSubproyecto());
                jButton2.setVisible(true);
                jButton5.setVisible(true);
                if(list3!=null){
                    jTextField6.setText(list3.get(list3.size()-1).getNombre());
                }
            }else{
                jButton2.setVisible(false);
                jButton5.setVisible(false);
            }
            jTextField1.setText(nombre1);
            jTextField4.setText(nombreinsta);
        }catch(Exception io){
        
        }
        
        setVisible(true);
    }

    public void actualizar(){
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            list2= helper.getlistaProyectos1a(""+in.getId(),"1");
            list3= helper.getlistaReport(idrpinsta);
            helper.cerrarSesion();
        }catch(Exception io){
        }
        if(list2!=null){
            jTextField5.setText(list2.get(0).getSubproyecto());
            idproyecto=""+list2.get(0).getId();
            subproyecto=""+list2.get(0).getNumero();
            jButton2.setVisible(true);
            jButton5.setVisible(true);
            if(list3!=null){
                jTextField6.setText(list3.get(list3.size()-1).getNombre());
            }
        }else{
            jButton2.setVisible(false);
            jButton5.setVisible(false);
        }
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

        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso");
        setMinimumSize(new java.awt.Dimension(500, 325));
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
        jButton4.setBounds(280, 300, 49, 29);

        jLabel2.setFont(new java.awt.Font("Roboto Light", 3, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Proforma de Soporte:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 20, 340, 40);

        jLabel6.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel6.setText("Cliente:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 70, 80, 30);

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        getContentPane().add(jTextField1);
        jTextField1.setBounds(160, 70, 280, 30);

        jLabel9.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel9.setText("Reporte de Instalacion:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(160, 220, 150, 30);

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        getContentPane().add(jTextField4);
        jTextField4.setBounds(160, 110, 280, 30);

        jTextField5.setEditable(false);
        jTextField5.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        getContentPane().add(jTextField5);
        jTextField5.setBounds(110, 180, 270, 30);

        jLabel10.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel10.setText("Instalacion:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(40, 110, 80, 30);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-aceptar.png"))); // NOI18N
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(160, 300, 49, 29);

        jLabel12.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel12.setText("N° Soporte:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(200, 150, 100, 30);

        jTextField6.setEditable(false);
        jTextField6.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        getContentPane().add(jTextField6);
        jTextField6.setBounds(110, 250, 270, 30);

        jButton3.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-editar.png"))); // NOI18N
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(40, 180, 50, 30);

        jButton16.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-buscar.png"))); // NOI18N
        jButton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton16MouseExited(evt);
            }
        });
        getContentPane().add(jButton16);
        jButton16.setBounds(390, 250, 49, 29);

        jButton17.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-buscar.png"))); // NOI18N
        jButton17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton17MouseExited(evt);
            }
        });
        getContentPane().add(jButton17);
        jButton17.setBounds(390, 180, 49, 29);

        jButton5.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-editar.png"))); // NOI18N
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(40, 250, 50, 30);

        getAccessibleContext().setAccessibleParent(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        dispose(); 
        
    }//GEN-LAST:event_jButton4MouseClicked

    public Instalacion getIn() {
        return in;
    }

    public void setIn(Instalacion in) {
        this.in = in;
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

    public void alt (Component bt, String text){
        jLabel11.setVisible(true);
        jLabel11.setText(text);
        jLabel11.setSize((int)jLabel11.getMinimumSize().getWidth(), 25);
        jLabel11.setLocation(bt.getX()+bt.getWidth(), bt.getY()-25);
    }  
    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        alt(jButton4,"Salir");
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        jLabel11.setVisible(false);
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
        if(selectedSiteName.equalsIgnoreCase("cajamarca")){
            try{
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                Instalacion inst= (Instalacion)helper.obtenerObjeto(Instalacion.class, in.getId());
                if(inst.getProceso().equalsIgnoreCase("En Diseño")){
                    inst.setProceso("Espera Aprobación Tecnica");
                    inst.setSelectt("1");
                }else{
                    inst.setProceso("Culminada");
                    inst.setSelectt("1");
                }
                helper.actualizarObjeto(inst);
                helper.confirmarTransaccion();
                helper.cerrarSesion();
                if(inst.getProceso().equalsIgnoreCase("Espera Aprobación Tecnica")){
                    JOptionPane.showMessageDialog(null, "Instalacion enviada a Bodega");
                }else{
                    Ticket tk = new Ticket();
                    Notificaciones noti= new Notificaciones();
                    Date d = new Date();
                    noti.setFecha(d);
                    noti.setVisto("NO");
                    try {
                        ServiceHb neo = new ServiceHb();
                        neo.iniciarTransaccion();
                        in= (Instalacion) neo.obtenerObjeto(Instalacion.class,Integer.parseInt(idrpinsta));

                        noti.setResponsable(usuario.getNombre());
                        noti.setInformacion("El Cliente "+in.getClientes().getApellido()+" con proyecto "+in.getDetalle()+" cambio de estado");

                        in.setTicket_1(getjTextField1().getText());
                        tk.setCliente(in.getClientes().getApellido());
                        tk.setContacto(in.getClientes().getPersona());
                        tk.setDetalle(in.getDetalle());
                        tk.setEstado("Culminada");
                        tk.setDiseno(in.getTipo());
                        tk.setDireccion(inst.getDireccion());
                        in.setProceso("En Curso");
                        noti.setModulo("PYL");
                        noti.setInstalacion(in.getProceso());
                        tk.setNumero(getjTextField1().getText());
                        tk.setProyecto(in.getDetalle());
                        Estatico est = (Estatico) neo.obtenerObjeto(Estatico.class,1);

                        String cad1 = est.getTicket();
                        int num1 = Integer.parseInt(cad1);
                        num1++;
                        cad1= Integer.toString(num1);

                        while(cad1.length()<7){
                        cad1= "0"+cad1;
                        }

                        est.setTicket(cad1);
                        neo.crearObjeto(tk);
                        neo.confirmarTransaccion();
                        neo.cerrarSesion();

                        neo = new ServiceHb();
                        neo.iniciarTransaccion();
                        neo.actualizarObjeto(est);
                        neo.actualizarObjeto(in);
                        neo.crearObjeto(noti);
                        in.setTick(tk);
                        neo.confirmarTransaccion();


                    } catch (Exception ex) {
                        Logger.getLogger(ingresoU5.class.getName()).log(Level.SEVERE, null, ex);
                    }
                JOptionPane.showMessageDialog(null, "Instalacion Culminada");
                    
                }
                dispose();
            }catch(Exception io){
            }
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        alt(jButton2,"Aceptar");
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        jLabel11.setVisible(false);
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        pylcrearproforma pcrear = new pylcrearproforma(padre, padre, true, in, nombre1,nombre2,usuario,jTextField5.getText());
        actualizar();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseEntered
        
    }//GEN-LAST:event_jButton16MouseEntered

    private void jButton16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseExited
        
    }//GEN-LAST:event_jButton16MouseExited

    private void jButton17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton17MouseEntered
        
    }//GEN-LAST:event_jButton17MouseEntered

    private void jButton17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton17MouseExited
        
    }//GEN-LAST:event_jButton17MouseExited

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        
        JFileChooser chooser = new JFileChooser();
        //Mostrar la ventana para abrir archivo y recoger la respuesta
        //En el parámetro del showOpenDialog se indica la ventana
        //  al que estará asociado. Con el valor this se asocia a la
        //  ventana que la abre.
        List<Report> list3;
        int valido=0;
        ServiceHb helper = new ServiceHb();
        helper.iniciarTransaccion();
        int respuesta = chooser.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION)
        {
            //Crear un objeto File con el archivo elegido
            try{
                PagePanel panelpdf = null;
                JFileChooser selector;
                PDFFile pdffile;
                int indice=0;
                int max=0;
                
                File file = chooser.getSelectedFile();
                
                RandomAccessFile raf = new RandomAccessFile(file, "r");
                
                byte[] b = new byte[(int) raf.length()];
                raf.readFully(b);
                java.nio.ByteBuffer buf = java.nio.ByteBuffer.wrap(b);
                
                pdffile = new PDFFile(buf);
            }catch(Exception io){
                
            }
        }
        if(valido==0){
            Report reporte = new Report();
            reporte.setInstalacion(idrpinsta);
            reporte.setProyecto(idproyecto);
            reporte.setGrupo("1");
            reporte.setNombre(jTextField1.getText()+" Reporte "+idrpinsta+ " " +reporte.getId()+".pdf");
            try {
                helper.crearObjeto(reporte);
                pdfcarga= reporte.getId();
                list3= helper.getlistaReport(idrpinsta);
                helper.confirmarTransaccion();
                helper.cerrarSesion();
            } catch (Exception ex) {
                Logger.getLogger(pylproformassoporte.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Comprobar si se ha pulsado Aceptar
            if (respuesta == JFileChooser.APPROVE_OPTION)
            {
                //Crear un objeto File con el archivo elegido
                File archivoEntrada = chooser.getSelectedFile();
                //Mostrar el nombre del archvivo en un campo de texto
                
                File archivoSalida = new File(usuario.getDireccion()+"\\"+reporte.getNombre());
                if(!archivoSalida.exists()) {
                    
                    try {
                        archivoSalida.createNewFile();
                    } catch (IOException ex) {
                        Logger.getLogger(pylproformassoporte.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                
                
                
                FileChannel source = null;
                
                FileChannel destination = null;
                
                try {
                    
                    source = new FileInputStream(archivoEntrada).getChannel();
                    
                    destination = new FileOutputStream(archivoSalida).getChannel();
                    
                    destination.transferFrom(source, 0, source.size());
                    
                }
                catch (FileNotFoundException ex) {                
                    Logger.getLogger(pylproformassoporte.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(pylproformassoporte.class.getName()).log(Level.SEVERE, null, ex);
                }                
                finally {
                    
                    if(source != null) {
                        
                        try {
                            source.close();
                        } catch (IOException ex) {
                            Logger.getLogger(pylproformassoporte.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                    
                    if(destination != null) {
                        
                        try {
                            destination.close();
                        } catch (IOException ex) {
                            Logger.getLogger(pylproformassoporte.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                    
                }
                JOptionPane.showConfirmDialog(null, "Listo", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
            }
        }else{
            JOptionPane.showConfirmDialog(null, "Sistema Incapaz de Leer PDF... ", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
        }
        actualizar();
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton17MouseClicked
        File f = new File(usuario.getDireccion()+"/"+jTextField5.getText()+".pdf");
        if(f.exists()){
            Principal p = new Principal(usuario.getDireccion()+"/"+jTextField5.getText()+".pdf");
            p.next();
        }
    }//GEN-LAST:event_jButton17MouseClicked

    private void jButton16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseClicked
        File f = new File(usuario.getDireccion()+"/"+jTextField6.getText()+"");
        if(f.exists()){
            Principal p = new Principal(usuario.getDireccion()+"/"+jTextField6.getText()+"");
            p.next();
        }
    }//GEN-LAST:event_jButton16MouseClicked


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
            java.util.logging.Logger.getLogger(pylproformassoporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pylproformassoporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pylproformassoporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pylproformassoporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                pylproformassoporte dialog = new pylproformassoporte(new javax.swing.JFrame(),null, true,"","","","",null);
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
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
