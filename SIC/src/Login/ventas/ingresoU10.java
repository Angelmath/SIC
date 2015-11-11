/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.ventas;

import Login.Entidad.Articulos;
import Login.Entidad.Factura;
import Login.Entidad.Login;
import Login.Entidad.Proveedores;
import Login.Entidad.Retencionfactu;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Login.servicio.ServiceHb;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Angelmath
 */
public final class ingresoU10 extends javax.swing.JDialog {
    marco padre;
    instalacion empl;
    String cl;
    Login Usuario;
    String razon;
    String insta;
    String cliente;
    String nombre;
    File archivoEntrada=null;
    Factura factura=null;
    Proveedores pv=null;
    List<Factura> facturas=null;
    /**
     * Creates new form ingresoU
     * @param parent
     * @param padre
     * @param modal
     * @param user
     * @param proveedor
     */
    public ingresoU10(java.awt.Frame parent, marco padre, boolean modal, Login user, Proveedores proveedor) {
        super(parent,modal);
        this.padre=padre;
        this.Usuario= user;
        this.pv=proveedor;
        initComponents();       
        setSize(800,580);
        setLocationRelativeTo(null);
        setEventoMouseClicked1(getjTable1());
        actualizar();
        getjTable1().getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        getjTable1().getColumn("Editar").setCellRenderer(new ButtonRenderer());
        setVisible(true);
        
    }
    public void actualizar(){
        if(pv!=null){
            try{
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                facturas= helper.getFactura(pv.getId());
                
                DefaultTableModel temp2 = (DefaultTableModel) getjTable1().getModel();
                    for(int i=temp2.getRowCount()-1;i>=0;i--){
                       temp2.removeRow(i);
                    }
                if(facturas!=null){
                    for(int i=0; i<facturas.size();i++){
                        if(getjTable1().getRowCount()< facturas.size()){
                            DefaultTableModel temp = (DefaultTableModel) getjTable1().getModel();
                            Object nuevo[]= {temp.getRowCount()+1,"",""};
                            temp.addRow(nuevo);
                        }
                        Factura fc= facturas.get(i);
                        getjTable1().getModel().setValueAt(fc.getIdnombre(), i, 0);
                        float fact= Float.parseFloat(fc.getSubtotal())+Float.parseFloat(fc.getSubtotal0())+Float.parseFloat(fc.getIva());
                        getjTable1().getModel().setValueAt(fact, i, 1);
                        getjTable1().getModel().setValueAt(fc.getSri(), i, 2);
                        if(fc.getIdretencion()!=null){
                            Retencionfactu rf= helper.getretencionfactu(fc.getIdretencion());
                            getjTable1().getModel().setValueAt(rf.getIdnombre(), i, 3);
                            getjTable1().getModel().setValueAt(rf.getTotal(), i, 4);
                            getjTable1().getModel().setValueAt(rf.getSri(), i, 5);
                        }else{
                            getjTable1().getModel().setValueAt("", i, 3);
                            getjTable1().getModel().setValueAt("", i, 4);
                            getjTable1().getModel().setValueAt("", i, 5);
                        }
                        getjTable1().getModel().setValueAt(fc.getTotal(), i, 6);
                        getjTable1().getModel().setValueAt(fc, i, 7);
                        getjTable1().getModel().setValueAt(fc, i, 8);
                    }
                }
                helper.cerrarSesion();
            }catch(Exception io){

            }
        }
    }
    public Login getUsuario() {
        return Usuario;
    }

    public void setUsuario(Login Usuario) {
        this.Usuario = Usuario;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    private void setEventoMouseClicked1(JTable tbl)
    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
 
        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                tblEjemploMouseClicked1(e);
            } catch (Exception ex) {
                Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        });
    }
    private void tblEjemploMouseClicked1(java.awt.event.MouseEvent evt) throws Exception {
       
       if(getjTable1().getSelectedColumn()==2){
           Principal principal = new Principal(Usuario.getDireccion()+"\\"+getjTable1().getModel().getValueAt(getjTable1().getSelectedRow(),2).toString()+".pdf");
        }
       if(getjTable1().getSelectedColumn()==5){
           Principal principal = new Principal(Usuario.getDireccion()+"\\"+getjTable1().getModel().getValueAt(getjTable1().getSelectedRow(),5).toString()+".pdf");
        }
    }    
    public marco getPadre() {
        return padre;
    }

    public void setPadre(marco padre) {
        this.padre = padre;
    }

    public String getInsta() {
        return insta;
    }

    public void setInsta(String insta) {
        this.insta = insta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public File getArchivoEntrada() {
        return archivoEntrada;
    }

    public void setArchivoEntrada(File archivoEntrada) {
        this.archivoEntrada = archivoEntrada;
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso");
        setMaximumSize(new java.awt.Dimension(800, 550));
        setMinimumSize(new java.awt.Dimension(800, 550));
        getContentPane().setLayout(null);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel8.setText("jLabel8");
        jLabel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(214, 214, 214), new java.awt.Color(214, 214, 214), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        jLabel8.setOpaque(true);
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 0, 70, 25);
        jLabel8.setVisible(false);

        jButton1.setText("Agregar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(620, 20, 150, 40);

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
        jButton4.setBounds(360, 500, 49, 29);

        jLabel2.setFont(new java.awt.Font("Roboto Light", 3, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Valores Pagados");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(210, 20, 410, 40);

        jTable1.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Factura", "Valor", "SRI", "N° Retencion", "Valor", "SRI", "Total a pagar", "Editar", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true
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
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 80, 750, 404);

        jLabel1.setBackground(new java.awt.Color(242, 242, 242));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 550);

        getAccessibleContext().setAccessibleParent(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        dispose(); 
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        alt(jButton4,"Salir");
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        jLabel8.setVisible(false);
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        //Login user, String Razon, String insta, String proforma, String prove
        factura=null;
        facturaspago u = new facturaspago(null,null,true,Usuario,"Razon", "insta", "proforma","prove",factura,pv);
        actualizar();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row= jTable1.getSelectedRow();
        int col= jTable1.getSelectedColumn();
        if(col==7){
            facturaspago u = new facturaspago(null,null,true,Usuario,"Razon", "insta", "proforma","prove",(Factura)jTable1.getModel().getValueAt(row, 7),pv);
            actualizar();
        }
        if(col==8){
            String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
            if(selectedSiteName.equalsIgnoreCase("cajamarca")){ 
                try{
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    Factura temp= (Factura)jTable1.getModel().getValueAt(row, 8);
                    List<Articulos> list = helper.getListaArticulos(temp.getIdnombre());
                    if(list!=null){
                        for(Articulos i: list){
                            helper.eliminarObjeto(i);
                        }
                    }
                    if(temp.getIdretencion()!=null){
                        Retencionfactu rt = helper.getrentencion(temp.getIdretencion());
                        helper.eliminarObjeto(rt);
                    }
                    helper.eliminarObjeto(temp);
                    helper.confirmarTransaccion();
                    helper.cerrarSesion();
                    actualizar();    
                }catch(Exception io){

                }
            }
        }
        
    }//GEN-LAST:event_jTable1MouseClicked
    public void alt (Component bt, String text){
        jLabel8.setVisible(true);
        jLabel8.setText(text);
        jLabel8.setSize((int)jLabel8.getMinimumSize().getWidth(), 25);
        jLabel8.setLocation(bt.getX()+bt.getWidth(), bt.getY()-25);
    }    
        
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
            java.util.logging.Logger.getLogger(ingresoU10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ingresoU10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ingresoU10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ingresoU10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
