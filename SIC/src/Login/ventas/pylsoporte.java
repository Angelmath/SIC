/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Login.ventas;

import Login.Entidad.Clientes;
import Login.Entidad.Instalacion;
import Login.Entidad.Login;
import Login.servicio.ServiceHb;
import static Login.ventas.marco.reiniciarJTable;
import java.awt.Dimension;
import java.awt.Toolkit;
import static java.lang.Thread.sleep;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author homemig
 */
public final class pylsoporte extends javax.swing.JPanel {
    Login us;
    int breakhilo=0;
    int idcliente=0;
    int idinstalacion=0;
    String nombrecliente="";
    String nombreinstalacion="";
    /**
     * Creates new form inventario
     */
    public pylsoporte() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        initComponents();
        setVisible(false);
        setSize(d.width, d.height-95);
        jScrollPane1.setSize(d.width-70, (d.height-300)/2);
        jScrollPane2.setSize(d.width-70, (d.height-300)/2);
        jPanel2.setLocation(jPanel2.getX(), jScrollPane1.getHeight()+jScrollPane1.getY());
        jPanel1.setLocation((d.width/2)-(jPanel1.getWidth()/2), jPanel1.getY());
        jPanel3.setLocation((d.width/2)-(jPanel3.getWidth()/2), jPanel2.getHeight()+jPanel2.getY());
        jScrollPane2.setLocation(jScrollPane2.getX(), jPanel3.getHeight()+jPanel3.getY());
    }
    
    public class updateTablas extends Thread {
        int turno;
        public updateTablas(int turno){
            this.turno=turno;
        }
        
        @Override
        public void run() {
            breakhilo=1;
            try{
                sleep(800);
                breakhilo=0;
            }catch(Exception io){
            }
            
            if(turno==1){
                llenar();
            }
            if(turno==2){
                llenarcero();
            }
            if(turno==3){
                llenarsoporte();
            }
            if(turno==4){
                llenarsoportetexto();
            }
            
        }
    }
    
    public void hilollenar(){
        updateTablas up = new updateTablas(1);
        up.start();
    }
    
    public void hilollenarcero(){
        updateTablas up = new updateTablas(2);
        up.start();
    }
    
    public void hilollenarcerotexto(){
        updateTablas up = new updateTablas(4);
        up.start();
    }

    public Login getUs() {
        return us;
    }

    public void setUs(Login us) {
        this.us = us;
    }
    
    public void llenarsoportetexto(){
        int row=jTable1.getSelectedRow();
        int col=jTable1.getSelectedColumn();
        if(col==7){
            int id= Integer.parseInt(jTable1.getValueAt(row, col).toString());
            idcliente=id;
            jLabel3.setText(jTable1.getValueAt(row, 0).toString());
            try{
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                List<Instalacion> list = helper.getlistaInstalacionSoporte(id,jTextField2.getText());
                helper.cerrarSesion();
                reiniciarJTable(jTable2);
                if(list!=null){
                    DefaultTableModel temp = (DefaultTableModel) jTable2.getModel();
                    for(Instalacion x: list){
                        if(breakhilo==1){
                            break;
                        }
                        String c1=x.getDetalle();
                        String c2=formatoFecha(x.getFecha());
                        String c3=x.getProceso();
                        String c4=x.getTipo();
                        String c5=""+x.getId();
                        String c6=""+x.getId();
                        String c7=""+x.getId();
                        Object nuevo[]= {c1,c2,c3,c4,c5,c6,c7};
                        temp.addRow(nuevo);
                    }

                }
            }catch(Exception io){

            }
        }
    }
    
    public void llenarsoporte(){
        int row=jTable1.getSelectedRow();
        int col=jTable1.getSelectedColumn();
        if(col==7){
            int id= Integer.parseInt(jTable1.getValueAt(row, col).toString());
            idcliente=id;
            nombrecliente=jTable1.getValueAt(row, 0).toString();
            jLabel3.setText(jTable1.getValueAt(row, 0).toString());
            try{
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                List<Instalacion> list = helper.getlistaInstalacionSoporte(idcliente);
                helper.cerrarSesion();
                reiniciarJTable(jTable2);
                if(list!=null){
                    DefaultTableModel temp = (DefaultTableModel) jTable2.getModel();
                    for(Instalacion x: list){
                        if(breakhilo==1){
                            break;
                        }
                        String c1=x.getDetalle();
                        String c2=formatoFecha(x.getFecha());
                        String c3=x.getProceso();
                        String c4=x.getTipo();
                        String c5=""+x.getId();
                        String c6=""+x.getId();
                        String c7=""+x.getId();
                        Object nuevo[]= {c1,c2,c3,c4,c5,c6,c7};
                        temp.addRow(nuevo);
                    }

                }
            }catch(Exception io){
            }
        }
    }
    
    public String formatoFecha(String fecha){
        String cadena[]= fecha.split("/");
        if(fecha.contains("/")){
            return cadena[2]+"-"+cadena[1]+"-"+cadena[0];
        }
        return fecha;
        
    }
    
    public void llenar(){
        try{
            List<Clientes> list=null;
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            list= helper.getlistaClientes();
            helper.cerrarSesion();
            reiniciarJTable(jTable1);
                if(list!=null){
                    int i=0;
                    for(Clientes x: list){
                        if(breakhilo==1){        
                            break;}
                        String c2=x.getRuc();
                        String c1=x.getApellido();
                        String c3=x.getPersona();
                        String c4=x.getNombre();
                        String c5=x.getNumero1();
                        String c6=x.getResponsable();
                        String c7=x.getCorreo();
                        String c8=""+x.getId();
                        DefaultTableModel temp = (DefaultTableModel) jTable1.getModel();
                        Object nuevo[]= {c1,c2,c3,c4,c5,c6,c7,c8};
                        temp.addRow(nuevo);
                        
                        i++;
                    }
                }
        }catch(Exception io){
        
        }
    }
    public void llenarcero(){
        try{
            List<Clientes> list=null;
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            list= helper.getlistaClientesSearch(jTextField1.getText());
            helper.cerrarSesion();
            reiniciarJTable(jTable1);
                if(list!=null){
                    int i=0;
                    for(Clientes x: list){
                        if(breakhilo==1){        
                            break;}
                        String c2=x.getRuc();
                        String c1=x.getApellido();
                        String c3=x.getPersona();
                        String c4=x.getNombre();
                        String c5=x.getNumero1();
                        String c6=x.getResponsable();
                        String c7=x.getCorreo();
                        String c8=""+x.getId();
                        DefaultTableModel temp = (DefaultTableModel) jTable1.getModel();
                        Object nuevo[]= {c1,c2,c3,c4,c5,c6,c7,c8};
                        temp.addRow(nuevo);
                        i++;
                    }
                }
        }catch(Exception io){
        
        }
    }
    
    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
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

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

    public JTable getjTable2() {
        return jTable2;
    }

    public void setjTable2(JTable jTable2) {
        this.jTable2 = jTable2;
    }

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Razon Social", "RUC/CI", "Persona", "Contacto", "Telefono", "Responsable", "Correo", "IR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(24);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(20, 50, 910, 170);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Detalle Breve", "Fecha", "Estado", "Tipo", "Accion", "Eliminar", "Editar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowHeight(24);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        add(jScrollPane2);
        jScrollPane2.setBounds(20, 300, 910, 220);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jTextField1.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(100, 10, 210, 30);

        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Buscar:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 17, 60, 14);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-buscar.png"))); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        jPanel1.add(jLabel5);
        jLabel5.setBounds(310, 10, 30, 30);

        add(jPanel1);
        jPanel1.setBounds(380, 0, 350, 50);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel2.setText("CLIENTES SELECCIONADO:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, 0, 200, 30);

        jLabel3.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jPanel2.add(jLabel3);
        jLabel3.setBounds(220, 0, 250, 30);

        jButton1.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jButton1.setText("GENERAR SOPORTE");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(500, 0, 200, 30);

        add(jPanel2);
        jPanel2.setBounds(20, 220, 910, 30);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(null);

        jTextField2.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        jPanel3.add(jTextField2);
        jTextField2.setBounds(100, 10, 210, 30);

        jLabel6.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Buscar:");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(20, 17, 60, 14);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-buscar.png"))); // NOI18N
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        jPanel3.add(jLabel7);
        jLabel7.setBounds(310, 10, 30, 30);

        add(jPanel3);
        jPanel3.setBounds(380, 250, 350, 50);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        hilollenarcero();
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        updateTablas up = new updateTablas(3);
        up.start();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        hilollenarcerotexto();
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        ingresoSoporte ingresoU3 = new ingresoSoporte(null, null, true,null,""+idcliente,0);
        updateTablas up = new updateTablas(3);
        up.start();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int row = jTable2.getSelectedRow();
        int col = jTable2.getSelectedColumn();
        if(col==4){
            idinstalacion= Integer.parseInt(jTable2.getValueAt(row, col).toString());
            nombreinstalacion=jTable2.getValueAt(row, 0).toString();
            pylproformassoporte ppf= new pylproformassoporte(null, null, true, ""+idcliente,nombrecliente,""+idinstalacion,nombreinstalacion,us);
            updateTablas up = new updateTablas(3);
            up.start();
        }
        if(col==5){
            String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
            if(selectedSiteName.equalsIgnoreCase("cajamarcacajamarca")){
                try{
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    helper.eliminarObjeto(helper.obtenerObjeto(Instalacion.class, Integer.parseInt(jTable2.getValueAt(row, col).toString())));
                    helper.confirmarTransaccion();
                    helper.cerrarSesion();
                    JOptionPane.showMessageDialog(null, "Instalacion Eliminada");
                    updateTablas up = new updateTablas(3);
                    up.start();
                }
                catch(Exception io){

                }
            }
        }
        if(col==6){
            idinstalacion= Integer.parseInt(jTable2.getValueAt(row, col).toString());
            ingresoSoporte ingresoU3 = new ingresoSoporte(null, null, true,null,""+idinstalacion,1);
            updateTablas up = new updateTablas(3);
            up.start();
        }
    }//GEN-LAST:event_jTable2MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
