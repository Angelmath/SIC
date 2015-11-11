/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.ventas;

import Login.Entidad.Factu;
import Login.Entidad.Instalacion;
import Login.Entidad.Login;
import Login.Entidad.Notificaciones;
import Login.Entidad.Proyectos;
import Login.Entidad.Report;
import Login.Entidad.Ticket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import Login.servicio.ServiceHb;
import java.awt.Component;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Angelmath
 */
public final class ingresoU7 extends javax.swing.JDialog {
    marco padre;
    instalacion empl;
    String cl;
    int toca;
    Ticket tk;
    Proyectos proy;
    Login usuario;
    Instalacion clie;
    String tipo;
    String nombre;
    int especial=0;
    String idtk;
    /**
     * Creates new form ingresoU
     * @param parent
     * @param padre
     * @param modal
     * @param tip
     * @param id
     * @param usuario
     * @param nombre
     */
    public ingresoU7(java.awt.Frame parent, marco padre, boolean modal,String id, Login usuario,String tip, String nombre) {
        super(parent,modal);
        initComponents();
        setSize(541, 545);
        List<Report> list4 = null;
        List<Factu> fac =null;
        this.padre=padre;
        this.usuario=usuario;
        this.nombre= nombre;
        setLocationRelativeTo(null);
        this.tipo=tip;
        this.idtk=id;
        try {
            ServiceHb neo = new ServiceHb();
            neo.iniciarTransaccion();
            tk= (Ticket) neo.obtenerObjeto(Ticket.class,Integer.parseInt(id));
            clie = neo.getlistaInstalacionpyl(tk.getId());
            proy = neo.getProyectoVt(Integer.toString(clie.getId()));
            list4= neo.getlistaReporta(Integer.toString(clie.getId()),clie.getSelectt());
            fac= neo.getlistaFactu(Integer.toString(clie.getId()));
            neo.cerrarSesion();
            
            jTextField7.setText(proy.getCredito());
            jTextField2.setText(proy.getDiferido());
            jTextField8.setText(proy.getAnticipo());
            getjTextField1().setText(tk.getNumero());//cliente
            getjTextField3().setText(tk.getCliente());//cliente
            getjTextField4().setText(tk.getContacto());//contacto
            getjTextField5().setText(tk.getProyecto());//proyecto
            getjTextField6().setText(tk.getEstado());//estado
            getjTextArea1().setText(tk.getDetalle());
            if(tip.equalsIgnoreCase("1")){
                if(tk.getEstado().equalsIgnoreCase("Culminada")){
                    jLabel2.setText("Culminada");
                    jLabel9.setVisible(true);
                }
            }
            if(tip.equalsIgnoreCase("2")){
                if(tk.getEstado().equalsIgnoreCase("Facturado")){
                    jLabel2.setText("Facturado");
                    jLabel9.setVisible(true);
                    jButton2.setVisible(true);
                }
                if(fac==null){
                    getjButton1().setVisible(false);
                }else{
                    getjButton1().setVisible(true);
                }
            }
            if(tip.equalsIgnoreCase("3")){
                if(tk.getEstado().equalsIgnoreCase("Cancelado")){
                    
                }
            }
            if(tip.equalsIgnoreCase("4")){
                jLabel2.setText("Facturado");
                jLabel9.setVisible(true);
                jButton2.setVisible(true);
                getjButton1().setVisible(false);
                getjButton5().setVisible(false);
                especial=1;
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(ingresoU7.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(usuario.getNivel().equalsIgnoreCase("Asistente")){
            jButton1.setVisible(false);
            jButton5.setVisible(false);
            jButton6.setVisible(false);
        }
        setVisible(true);
    }
    
    public Ticket getTk() {
        
        return tk;
    }
    
    public void setTk(Ticket tk) {
        this.tk = tk;
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField5 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso");
        setMinimumSize(new java.awt.Dimension(500, 400));
        setPreferredSize(new java.awt.Dimension(542, 545));
        setSize(new java.awt.Dimension(541, 511));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel11.setText("jLabel8");
        jLabel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(214, 214, 214), new java.awt.Color(214, 214, 214), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        jLabel11.setOpaque(true);
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 25));
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
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 460, 49, 29));

        jLabel2.setFont(new java.awt.Font("Roboto Light", 3, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Instalacion");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 340, 30));

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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, 49, 29));

        jLabel3.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel3.setText("N°:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 120, 30));

        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel4.setText("Cliente:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 130, 30));

        jLabel5.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel5.setText("Proyecto:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 130, 30));

        jLabel10.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel10.setText("Estado:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 120, 30));

        jLabel6.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel6.setText("Contacto:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 120, 30));

        jLabel8.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel8.setText("Detalle:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 110, 30));

        jButton2.setText("Fechas Facturacion");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 386, 270, 30));

        jLabel9.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel9.setText("Anticipo(Meses):");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 345, 90, 30));

        jTextField1.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("0000000");
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 190, 30));

        jTextField3.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 190, 30));

        jTextField4.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 190, 30));

        jTextField6.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 190, 30));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 230, 60));

        jTextField5.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 190, 30));

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
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 460, 49, 29));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-editar.png"))); // NOI18N
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton6MouseExited(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 460, 49, 29));

        jLabel13.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel13.setText("Credito(Meses):");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 286, 90, 30));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 315, 190, 30));
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 286, 190, 30));
        getContentPane().add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 345, 190, 30));

        jLabel14.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel14.setText("Diferido(Meses):");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 315, 90, 30));

        getAccessibleContext().setAccessibleParent(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        dispose(); 
    }//GEN-LAST:event_jButton4MouseClicked
        
    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        try {
            ServiceHb neo = new ServiceHb();
            neo.iniciarTransaccion();
            proy.setAnticipo(jTextField8.getText());
            proy.setCredito(jTextField7.getText());
            proy.setDiferido(jTextField2.getText());
            tk.setDetalle(jTextArea1.getText());
            neo.actualizarObjeto(tk);
            neo.actualizarObjeto(proy);
            neo.confirmarTransaccion();
            neo.cerrarSesion();
        } catch (Exception ex) {
            Logger.getLogger(ingresoU7.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_jButton6MouseClicked
    
    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
        if(selectedSiteName.equalsIgnoreCase("cajamarca")){
            try {
                ServiceHb neo = new ServiceHb();
                neo.iniciarTransaccion();
                neo.eliminarObjeto(tk);
                neo.confirmarTransaccion();
                neo.cerrarSesion();
            } catch (Exception ex) {
                Logger.getLogger(ingresoU7.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        dispose();
    }//GEN-LAST:event_jButton5MouseClicked
    
    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed
    public void alt (Component bt, String text){
//        jLabel11.setVisible(true);
//        jLabel11.setText(text);
//        jLabel11.setSize((int)jLabel11.getMinimumSize().getWidth(), 25);
//        jLabel11.setLocation(bt.getX()+bt.getWidth(), bt.getY()-25);
    }     
    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        alt(jButton6,"Editar Ticket");
    }//GEN-LAST:event_jButton6MouseEntered
    
    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        alt(jButton5,"Eliminar Ticket");
    }//GEN-LAST:event_jButton5MouseEntered
    
    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        alt(jButton4,"Salir");
    }//GEN-LAST:event_jButton4MouseEntered
        
    private void jButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseExited
        jLabel11.setVisible(false);
    }//GEN-LAST:event_jButton6MouseExited
    
    private void jButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseExited
        jLabel11.setVisible(false);
    }//GEN-LAST:event_jButton5MouseExited
    
    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        jLabel11.setVisible(false);
    }//GEN-LAST:event_jButton4MouseExited
    
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        String c= jTextField7.getText();        
        String d= jTextField2.getText();
        String a= jTextField8.getText();
        fcuadrofechas fc = new fcuadrofechas(null, null, true, idtk, usuario, tipo, nombre, c, d, a);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jLabel11.setVisible(false);
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        if(tk.getEstado().equalsIgnoreCase("Culminada")){
            alt(jButton1,"Facturar Ticket");
        }else if(tk.getEstado().equalsIgnoreCase("Facturado")){
            alt(jButton1,"Cancelar Ticket");
        }else{
            alt(jButton1,"Regresar Facturar Ticket");
        }
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try {
            ServiceHb neo = new ServiceHb();
            neo.iniciarTransaccion();
            Notificaciones noti= new Notificaciones();
            Instalacion in = clie;
            Proyectos proyecto = neo.getProyectoVt(Integer.toString(in.getId()));
            Date d = new Date();
            noti.setFecha(d);
            noti.setVisto("NO");

            noti.setResponsable(usuario.getNombre());
            noti.setInformacion("El Cliente "+nombre+" con proyecto "+in.getDetalle()+" cambio de estado");
            Calendar ca = Calendar.getInstance();

            tk.setCliente(getjTextField3().getText());
            tk.setContacto(getjTextField4().getText());
            tk.setDetalle(getjTextArea1().getText());

            if(tk.getEstado().equalsIgnoreCase("Culminada")){
                tk.setEstado("Facturado");
                clie.setProceso("Facturado");
                Calendar data = Calendar.getInstance();
                clie.setFechafactu(data.getTime());
                int anticipo=Integer.parseInt(proyecto.getAnticipo());
                int credito=Integer.parseInt(proyecto.getCredito());
                int diferido=Integer.parseInt(proyecto.getDiferido());
                int temp=0;
                if(anticipo==0){
                    clie.setFechaanticipo(null);
                }else{
                    clie.setFechaanticipo(data.getTime());
                    temp++;
                }
                data.add(Calendar.MONTH, temp+credito);
                clie.setFechafactu(data.getTime());
                data.add(Calendar.MONTH, diferido);
                clie.setFechafactufin(data.getTime());
            }
            else if(tk.getEstado().equalsIgnoreCase("Facturado")){
                tk.setEstado("Cancelado");
                clie.setProceso("Cancelado");
            }
            else if(tk.getEstado().equalsIgnoreCase("Cancelado")){
                tk.setEstado("Facturado");
                clie.setProceso("Facturado");
            }
            noti.setModulo("Contable");
            noti.setInstalacion(clie.getProceso());
            tk.setDiseno(clie.getTipo());
            tk.setNumero(getjTextField1().getText());
            tk.setProyecto(getjTextField5().getText());
            neo.actualizarObjeto(clie);
            neo.actualizarObjeto(tk);
            neo.crearObjeto(noti);
            neo.confirmarTransaccion();
            neo.cerrarSesion();
        } catch (Exception ex) {
            Logger.getLogger(ingresoU7.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Confirmado");
        dispose();
    }//GEN-LAST:event_jButton1MouseClicked
    
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
    
    public JLabel getjLabel9() {
        return jLabel9;
    }
    
    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
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
    
    public JTextField getjTextField1() {
        return jTextField1;
    }
    
    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ingresoU7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}

