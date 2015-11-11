/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.ventas;

import Login.Entidad.Clientes;
import Login.Entidad.Ctecobrar;
import Login.Entidad.Factu;
import Login.Entidad.Instalacion;
import Login.Entidad.Login;
import Login.Entidad.Proyectos;
import Login.Entidad.Report;
import Login.Entidad.Retencionfactu;
import Login.Entidad.Ticket;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Login.servicio.ServiceHb;
import static Login.ventas.marco.reiniciarJTable;
import java.awt.Component;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Angelmath
 */
public final class fcuadrofechas extends javax.swing.JDialog {
    marco padre;
    instalacion empl;
    String cl;
    int toca;
    Ticket tk;
    Login usuario;
    Instalacion instalacion;
    Proyectos py;
    Clientes clientes;
    String idpy;
    String tipo;
    String nombre;
    List<Ctecobrar> ltcc=null;
    DecimalFormat df = new DecimalFormat("0.00");
    /**
     * Creates new form ingresoU
     * @param parent
     * @param padre
     * @param modal
     * @param d1
     * @param id
     * @param c1
     * @param nombre
     * @param usuario
     * @param tip
     * @param a1
     */
    public fcuadrofechas(java.awt.Frame parent, marco padre, boolean modal,String id, Login usuario,String tip, String nombre, String c1 ,String d1 ,String a1) {
        super(parent,modal);
        initComponents();
        List<Report> list4 = null;
        List<Factu> fac =null;
        this.padre=padre;
        this.usuario=usuario;
        this.nombre= nombre;
        this.tipo=tip;
        c.setText(c1);
        d.setText(d1);
        a.setText(a1);
        setSize(1025,535);
        Calendar ca = Calendar.getInstance();
        jDateChooser1.setDate(ca.getTime());
        jTable1.getColumn("Editar").setCellRenderer(new ButtonRenderer());
        jTable1.getColumn("Ver Ret.").setCellRenderer(new ButtonRenderer());
        try {
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            tk= (Ticket) helper.obtenerObjeto(Ticket.class,Integer.parseInt(id));
            instalacion = helper.getlistaInstalacionpyl(tk.getId());
            py = helper.getProyectoVt(Integer.toString(instalacion.getId()));
            clientes= (Clientes)helper.obtenerObjeto(Clientes.class, instalacion.getClientes().getId()); 
            t.setText(py.getSubtotal());
            helper.cerrarSesion();        
        } catch (Exception ex) {
        }
        setLocationRelativeTo(null);
        llenar();
        setVisible(true);
    }
    public void llenar(){
        try {
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            ltcc = helper.getListCteCobrar(clientes.getId(), py.getId());
            helper.cerrarSesion();        
        } catch (Exception io) {
        }
        reiniciarJTable(jTable1);
        if(ltcc!=null){
            for(Ctecobrar i: ltcc){
                float sub = 0;
                float iva = 0;
                float val = 0;
                float val2 = 0;
                float rett = 0;
                if(i.getSubmontos()!=null){
                    sub = Float.parseFloat(i.getSubmontos());
                }
                if(i.getIvamontos()!=null){
                    iva = Float.parseFloat(i.getIvamontos());
                }
                if(i.getMontos()!=null){
                    val = Float.parseFloat(i.getMontos());
                }
                if(i.getSaldo()!=null){
                    val2 = Float.parseFloat(i.getSaldo());
                }   
                if(i.getTotalretencion()!=null){
                    rett = Float.parseFloat(i.getTotalretencion());
                }
                float totalfact= val-rett;
                DefaultTableModel temp = (DefaultTableModel) jTable1.getModel();
                Object nuevo[]= {i.getId(),i.getFecha(),i.getFactura(),i.getAutfactura(),i.getPlanpagos(),i.getObservacion(),"$"+df.format(sub).replace(",", "."),"$"+df.format(iva).replace(",", "."),"$"+df.format(val).replace(",", "."),"$"+df.format(rett).replace(",", "."),i.getNumretencion(),i.getIdretencion(),"$"+df.format(totalfact).replace(",", "."),"$"+df.format(val2).replace(",", "."),"$"+df.format(val-val2-rett).replace(",", "."),i};
                temp.addRow(nuevo);
            }
        }
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
        c = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        d = new javax.swing.JTextField();
        a = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        t = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

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
        jButton4.setBounds(490, 460, 49, 29);

        jLabel2.setFont(new java.awt.Font("Roboto Light", 3, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Instalacion");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(366, 23, 340, 30);

        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel4.setText("Credito:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 60, 80, 30);

        c.setEditable(false);
        c.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        c.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cActionPerformed(evt);
            }
        });
        getContentPane().add(c);
        c.setBounds(110, 60, 110, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha", "N° Factura", "Aut. Factura", "Pagos", "Observacion", "SubTotal", "Iva", "Total", "Retencion T.", "N° Ret.", "Ver Ret.", "Total Factura", "Pagado", "Saldos", "Editar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true, false, true, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setRowHeight(26);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable1KeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(4).setMinWidth(200);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(5).setMinWidth(200);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(200);
        }

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 140, 976, 270);

        jLabel6.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel6.setText("Diferido:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(240, 60, 80, 30);

        d.setEditable(false);
        d.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        d.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dActionPerformed(evt);
            }
        });
        getContentPane().add(d);
        d.setBounds(340, 60, 110, 30);

        a.setEditable(false);
        a.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        a.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aActionPerformed(evt);
            }
        });
        getContentPane().add(a);
        a.setBounds(560, 60, 110, 30);

        jLabel7.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel7.setText("subTotal:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(730, 60, 80, 30);

        jButton1.setText("Generar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(522, 104, 220, 30);
        getContentPane().add(jDateChooser1);
        jDateChooser1.setBounds(292, 104, 190, 30);

        jLabel8.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel8.setText("Anticipo:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(470, 60, 80, 30);

        t.setEditable(false);
        t.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        t.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tActionPerformed(evt);
            }
        });
        getContentPane().add(t);
        t.setBounds(800, 60, 160, 30);

        jLabel1.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel1.setText("Actualizar");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(860, 420, 70, 30);

        jLabel3.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel3.setText("Presione para aplicacion de IVA.");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(100, 420, 200, 30);

        jButton2.setText("OK");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(350, 420, 60, 30);

        jButton3.setText("OK");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(30, 420, 60, 30);

        jLabel5.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel5.setText("Presione en una celda para reajustar los pagos siguientes.");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(420, 420, 380, 30);

        jButton5.setText("OK");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(940, 420, 60, 30);

        getAccessibleContext().setAccessibleParent(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        dispose(); 
    }//GEN-LAST:event_jButton4MouseClicked
    
    public void alt (Component bt, String text){
        
    }   
    
    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        alt(jButton4,"Salir");
    }//GEN-LAST:event_jButton4MouseEntered
                
    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        jLabel11.setVisible(false);
    }//GEN-LAST:event_jButton4MouseExited
    
    private void cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cActionPerformed

    private void dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dActionPerformed

    private void aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            List<Ctecobrar> list = helper.getListCteCobrar(clientes.getId(), py.getId());
            if(list!=null){
                for(Ctecobrar i: list){
                    helper.eliminarObjeto(i);
                }
                helper.confirmarTransaccion();
            }
            helper.cerrarSesion();
            
            helper = new ServiceHb();
            helper.iniciarTransaccion();
            int max= Integer.parseInt(d.getText());
            if(max==0){
                max=1;
            }
            float valor = Float.parseFloat(py.getTotal().replace("$", ""));
            float valor2 = Float.parseFloat(py.getSubtotal().replace("$", ""));
            float valor3 = Float.parseFloat(py.getIva().replace("$", ""));
            Calendar ca = jDateChooser1.getCalendar();
            for(int i=0; i<max; i++){
                Ctecobrar ce = new Ctecobrar();
                ca.add(Calendar.MONTH, 1);
                ce.setFecha( new java.sql.Date(ca.getTime().getTime()));
                ce.setCliente(""+clientes.getApellido());
                ce.setFactura("");
                ce.setAutfactura("");
                ce.setIdcliente(clientes.getId());
                ce.setIdproyecto(py.getId());
                ce.setProyecto(py.getNumero());
                ce.setObservacion(py.getObservacion1());
                ce.setIvamontos(df.format((valor3/max)).replace(",", "."));
                ce.setSubmontos(df.format((valor2/max)).replace(",", "."));
                ce.setMontos(df.format((valor/max)).replace(",", "."));
                ce.setIdretencion("");
                ce.setNumretencion("0");
                ce.setAutretencion("");
                ce.setSaldo("0");
                if(max==1){
                    ce.setPlanpagos("Pago");
                }else{
                    ce.setPlanpagos("Pago "+(i+1)+" de "+max);
                }
                helper.crearObjeto(ce);
            }
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            llenar();
        }catch(Exception io){
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        int col = jTable1.getSelectedColumn();
        if(col==11){
            String fnum = jTable1.getValueAt(row, 2).toString();
            String idret = jTable1.getValueAt(row, 11).toString();
            String idctecobrar = jTable1.getValueAt(row, 0).toString();
            Double d = Double.parseDouble(jTable1.getValueAt(row, 6).toString().replace("$",""));
            Retencionfactu retencion=null;
            try{
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                if(!idret.equalsIgnoreCase("")){
                    retencion=helper.getrentencion(idret);
                }
                helper.cerrarSesion();
            }catch(Exception io){}
            
            if(retencion!=null){
                retencionctecobrar retencion1 = new retencionctecobrar(null, null, true,retencion,idctecobrar,d);
            }else{
                retencionctecobrar retencion1 = new retencionctecobrar(null, null, true,null,idctecobrar,d);
            }
            llenar();
        }
        if(col==15){
            try{
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                Ctecobrar ce = (Ctecobrar)helper.obtenerObjeto(Ctecobrar.class, Integer.parseInt(jTable1.getValueAt(row, 0).toString()));
                ce.setFactura(jTable1.getValueAt(row, 2).toString());
                ce.setAutfactura(jTable1.getValueAt(row, 3).toString());
                ce.setPlanpagos(jTable1.getValueAt(row, 4).toString());
                ce.setObservacion(jTable1.getValueAt(row, 5).toString());
                ce.setSubmontos(jTable1.getValueAt(row, 6).toString().replace("$","").replace(",","."));
                ce.setIvamontos(jTable1.getValueAt(row, 7).toString().replace("$","").replace(",","."));
                ce.setMontos(jTable1.getValueAt(row, 8).toString().replace("$","").replace(",","."));
                ce.setSaldo(jTable1.getValueAt(row, 13).toString().replace("$","").replace(",","."));
                ce.setTotalretencion(jTable1.getValueAt(row, 9).toString().replace("$","").replace(",","."));
                ce.setNumretencion(jTable1.getValueAt(row, 10).toString());
                
                String[] cadena = jTable1.getValueAt(row, 1).toString().split("-");
                Calendar ca = Calendar.getInstance();
                ca.set(Integer.parseInt(cadena[0]), Integer.parseInt(cadena[1])-1, Integer.parseInt(cadena[2]));
                ce.setFecha( new java.sql.Date(ca.getTime().getTime()));
                
                helper.actualizarObjeto(ce);
                helper.confirmarTransaccion();
                helper.cerrarSesion();
                JOptionPane.showMessageDialog(null, "Editado");
            }catch(Exception io){}
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
        if((evt.getKeyChar()=="p".charAt(0))){
            
        }
        if((evt.getKeyChar()=="o".charAt(0))){
            
        }
    }//GEN-LAST:event_jTable1KeyTyped

    private void tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        int row = jTable1.getSelectedRow();
            int col = jTable1.getSelectedColumn();
            int subtotal=6;
            int iva=7;
            int total=8;
            int pagado=13;
            int saldo=14;
            int rett=9;
            int ttret=12;
            double ttotal= Double.parseDouble(t.getText().replace("$", ""));
            double sumatotal=0;
            for (int i=0; i<=jTable1.getModel().getRowCount()-1; i++)
            {
                try{    
                        double val= Double.parseDouble(jTable1.getValueAt(i, subtotal).toString().replace("$", "").replace(",", "."));
                        double val2= Double.parseDouble(jTable1.getValueAt(i, pagado).toString().replace("$", "").replace(",", "."));
                        double val3= Double.parseDouble(jTable1.getValueAt(i, rett).toString().replace("$", "").replace(",", "."));
                        jTable1.setValueAt("$"+df.format(val),i, subtotal);
                        jTable1.setValueAt("$"+df.format(val*0.12),i, iva);
                        jTable1.setValueAt("$"+df.format(val*1.12),i, total);
                        jTable1.setValueAt("$"+df.format(val3),i, rett);
                        jTable1.setValueAt("$"+df.format((val*1.12)-val3),i, ttret);
                        jTable1.setValueAt("$"+df.format((val*1.12)-val2-val3),i, saldo);
                } catch (Exception ex) {
                    jTable1.getModel().setValueAt("",i, 0);
                }
            }    
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        int row = jTable1.getSelectedRow();
        int col = jTable1.getSelectedColumn();
        int subtotal=6;
        int iva=7;
        int total=8;
        int pagado=13;
        int saldo=14;
        int rett=9;
        double ttotal= Double.parseDouble(t.getText().replace("$", ""));
        double sumatotal=0;
        double diference=0;
        int div=jTable1.getModel().getRowCount()-jTable1.getSelectedRow()-1;
        for (int i=0; i<=jTable1.getModel().getRowCount()-1; i++)
        {
            if(row<i){
                try{    
                    jTable1.setValueAt("$"+df.format(((diference/div))),i, subtotal);
                    jTable1.setValueAt("$"+df.format((diference/div)*0.12),i, iva);
                    jTable1.setValueAt("$"+df.format((diference/div)*1.12),i, total);
                    jTable1.setValueAt("$"+df.format("0"),i, pagado);
                    jTable1.setValueAt("$"+df.format(((diference/div)*1.12)),i, saldo);
                } catch (Exception ex) {
                }
            }else{
                sumatotal=sumatotal+ Double.parseDouble(jTable1.getValueAt(i, subtotal).toString().replace("$", "").replace(",", "."));
                diference=ttotal-sumatotal;
            }
        }    
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        llenar();
    }//GEN-LAST:event_jButton5MouseClicked
    
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
        return null;
    }
    
    public void setjTextField5(JTextField jTextField5) {
        //this.jTextField5 = jTextField5;
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
    
    public JTextField getjTextField3() {
        return c;
    }
    
    public void setjTextField3(JTextField jTextField3) {
        this.c = jTextField3;
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
            java.util.logging.Logger.getLogger(fcuadrofechas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
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
    private javax.swing.JTextField a;
    private javax.swing.JTextField c;
    private javax.swing.JTextField d;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField t;
    // End of variables declaration//GEN-END:variables
}

