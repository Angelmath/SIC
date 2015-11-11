/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgi.acceso;

import sgi.servicio.ServiceHb;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import sgi.tablas.Configuracion;


/**
 *
 * @author Angelmath
 */
public final class config extends javax.swing.JDialog {
    /**
     * Creates new form ingresoU
     * @param parent
     * @param modal
     * @param h1
     */
    DefaultTableModel base;
    List<Configuracion> config;
    Configuracion c=null;
    int sortColumn;
    int[] row;
    public config(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(712, 671);
        dispose();
        setUndecorated(true);
        setLocationRelativeTo(null);
        //llenar();
        tablasmodelos(jTable1,jPanel1);
        jScrollPane1.getVerticalScrollBar().setUI(new MyScrollbarUI());
        
        jTable1.getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        
        jTable1.getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        
        jTable1.getColumn("VER").setCellRenderer(new ButtonRenderer());
        
        llenarreportes();
        
        setVisible(true);
    }
    
    public void tablasmodelos(final JTable pane, final JPanel panel){
        
        JTableHeader jtableHeader = pane.getTableHeader();
        
        jtableHeader.setDefaultRenderer(new HeaderCellRenderer());
        
        pane.setTableHeader(  jtableHeader );
        
        jtableHeader.addMouseListener(new MouseAdapter() {
            
            
            
            @Override
            
            public void mouseClicked(MouseEvent e) {
                
                base = (DefaultTableModel)pane.getModel();
                
                sortColumn = pane.getSelectedColumn();
                
                
                
                int size = base.getRowCount();
                
                row = new int[size];
                
                for (int i = 0; i < size; i++) {
                    
                    row[i] = i;
                    
                }
                
                for (int i = 1; i < row.length; i++) {
                    int j = i;
                    while (j > 0 && compare(j - 1, j) > 0) {
                        int temp = row[j];
                        row[j] = row[j - 1];
                        row[j - 1] = temp;
                        j--;
                    }
                }
                ArrayList cd = new ArrayList();
                for (int i = 0; i < row.length; i++) {
                    cd.add(((Vector) base.getDataVector().elementAt(row[i])));
                }
                
                while(base.getRowCount()!=0){
                    base.removeRow(0);
                }
                for (int i = 0; i < row.length; i++) {
                    base.addRow(((Vector)cd.get(i)).toArray());
                }
                pane.setModel(base);
                pane.repaint();
                panel.validate();
                panel.repaint();
                getContentPane().repaint();
            }
        });
        
    }

    protected int compare(int i, int j) {
        
        String s1 = base.getValueAt(row[i], sortColumn).toString();
        
        String s2 = base.getValueAt(row[j], sortColumn).toString();
        
        return s1.compareTo(s2);
        
    }

    private void llenarreportes(){
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            List<Configuracion> lt = helper.getConfiguracion();
            DefaultTableModel temp2 = (DefaultTableModel) jTable1.getModel();
            for(int i=temp2.getRowCount()-1;i>=0;i--){
                temp2.removeRow(i);
            }
            if(lt!=null){
                for(Configuracion i: lt){
                    temp2 = (DefaultTableModel) jTable1.getModel();
                    Object nuevo[]= {i.getCampo(),i.getDato(),i.getId()};
                    temp2.addRow(nuevo);
                }
            }
            helper.cerrarSesion();
        }catch(Exception io){
            System.out.println(io);
        }
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

    public JTextField getjTextField2() {
        return c2;
    }

    public void setjTextField2(JTextField jTextField2) {
        this.c2 = jTextField2;
    }
    
    public JTextField getjTextField8() {
        return c1;
    }

    public void setjTextField8(JTextField jTextField8) {
        this.c1 = jTextField8;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        c1 = new javax.swing.JTextField();
        c2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso");
        setMinimumSize(new java.awt.Dimension(378, 348));
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel9.setText("jLabel8");
        jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(214, 214, 214), new java.awt.Color(214, 214, 214), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(0, 0, 70, 25);
        jLabel9.setVisible(false);

        jLabel2.setFont(new java.awt.Font("Roboto Light", 3, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("EDITAR Patrulla / Relevo");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(210, 20, 330, 30);

        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel4.setText("Campo:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(70, 70, 140, 30);

        jLabel5.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel5.setText("Dato:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(70, 100, 140, 30);

        jButton6.setText("Cerrar");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(280, 600, 140, 50);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Observacion", "Nombre", "VER"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(2).setMinWidth(200);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(200);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(60, 210, 580, 280);
        jPanel1.add(c1);
        c1.setBounds(360, 80, 280, 30);
        jPanel1.add(c2);
        c2.setBounds(360, 110, 280, 30);

        jButton1.setText("VACIAR");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(280, 160, 150, 40);

        jButton2.setText("CREAR / EDITAR");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(70, 160, 150, 40);

        jButton3.setText("ELIMINAR");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(490, 160, 150, 40);

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 710, 670);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 710, 670);

        getAccessibleContext().setAccessibleParent(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int rows = jTable1.getSelectedRow();
        int col = jTable1.getSelectedColumn();
        ServiceHb helper = null;
        try{
            if(col==2){
                helper = new ServiceHb();
                helper.iniciarTransaccion();
                c = (Configuracion)helper.obtenerObjeto(Configuracion.class,Integer.parseInt(jTable1.getValueAt(rows, col).toString()));
                helper.cerrarSesion();
                c1.setText(c.getCampo());
                c2.setText(c.getDato());
            }
        }catch(Exception io){
            JOptionPane.showMessageDialog(null, "No existe Foto");
            try{
            helper.cerrarSesion();
            }catch(Exception ios){}
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        dispose();
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        try{
            if(c==null){
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                c= new Configuracion();
                c.setCampo(c1.getText());
                c.setDato(c2.getText());
                helper.crearObjeto(c);
                helper.confirmarTransaccion();
                helper.cerrarSesion();
            }else{
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                c.setCampo(c1.getText());
                c.setDato(c2.getText());
                helper.actualizarObjeto(c);
                helper.confirmarTransaccion();
                helper.cerrarSesion();
            }
        }catch(Exception io){}
        c1.setText(null);
        c2.setText(null);
        c=null;
        llenarreportes();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        c1.setText(null);
        c2.setText(null);
        c=null;
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            helper.eliminarObjeto(c);
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            c1.setText(null);
            c2.setText(null);
            c=null;
            llenarreportes();
        }catch(Exception io){}
    }//GEN-LAST:event_jButton3MouseClicked

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

    public boolean validareditado(int row){
        String inicio = jTable1.getValueAt(row, 1).toString();
        String fin = jTable1.getValueAt(row, 2).toString();
        String [] ainicio = inicio.split(",");
        String [] afin = fin.split(",");
        if(Integer.parseInt(ainicio[0])<24 && Integer.parseInt(afin[0])<24 && Integer.parseInt(afin[0])>=0 && Integer.parseInt(ainicio[0])>=0){
            if(Integer.parseInt(ainicio[1])<60 && Integer.parseInt(afin[1])<60 && Integer.parseInt(afin[1])>=0 && Integer.parseInt(ainicio[1])>=0){
                if(Integer.parseInt(ainicio[2])<60 && Integer.parseInt(afin[2])<60 && Integer.parseInt(afin[2])>=0 && Integer.parseInt(ainicio[2])>=0){
                    Calendar ca = Calendar.getInstance();
                    Calendar ca2 = Calendar.getInstance();
                    ca.set(Calendar.HOUR_OF_DAY, Integer.parseInt(ainicio[0]));
                    ca.set(Calendar.MINUTE, Integer.parseInt(ainicio[1]));
                    ca.set(Calendar.SECOND, Integer.parseInt(ainicio[2]));
                    ca2.set(Calendar.HOUR_OF_DAY, Integer.parseInt(afin[0]));
                    ca2.set(Calendar.MINUTE, Integer.parseInt(afin[1]));
                    ca2.set(Calendar.SECOND, Integer.parseInt(afin[2]));
                    if(ca.before(ca2)){
                        return true;
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, "ERROR al respetar el formato");
        return false;
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
        } catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException io){}
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            config dialog = new config(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    public class MyScrollbarUI extends BasicScrollBarUI {
        
        
        
        private java.awt.Image imageThumb, imageTrack;
        
        private JButton b = new JButton() {
            
            
            
            @Override
            
            public Dimension getPreferredSize() {
                
                return new Dimension(0, 0);
                
            }
            
            
            
        };
        
        
        
        MyScrollbarUI() {
            
            imageThumb = FauxImage.create(32, 32, new Color(212,208,200));
            
            imageTrack = FauxImage.create(32, 32, Color.GRAY);
            
        }
        
        
        
        @Override
        
        protected void paintThumb(Graphics g, JComponent c, java.awt.Rectangle r) {
            
            g.setColor(Color.blue);
            
            ((Graphics2D) g).drawImage(imageThumb,
                    
                    r.x, r.y, r.width, r.height, null);
            
        }
        
        
        
        @Override
        
        protected void paintTrack(Graphics g, JComponent c, java.awt.Rectangle r) {
            
            ((Graphics2D) g).drawImage(imageTrack,
                    
                    r.x, r.y, r.width, r.height, null);
            
        }
        
        @Override
        
        protected JButton createDecreaseButton(int orientation) {
            
            return b;
            
        }
        
        @Override
        
        protected JButton createIncreaseButton(int orientation) {
            
            return b;
            
        }
        
    }
    
    
    
    private static class FauxImage {
        
        
        
        static public java.awt.Image create(int w, int h, Color c) {
            
            BufferedImage bi = new BufferedImage(
                    
                    w, h, BufferedImage.TYPE_INT_ARGB);
            
            Graphics2D g2d = bi.createGraphics();
            
            g2d.setPaint(c);
            
            g2d.fillRect(0, 0, w, h);
            
            g2d.dispose();
            
            return bi;
            
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField c1;
    private javax.swing.JTextField c2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
