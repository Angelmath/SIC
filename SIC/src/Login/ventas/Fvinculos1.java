/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.ventas;

import static Login.ventas.marco.reiniciarJTable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import rrhh.Entidad.Departamento;
import rrhh.Entidad.Empleado;

/**
 *
 * @author Matheus
 */
public class Fvinculos1 extends javax.swing.JDialog {
    List<Empleado> lista;
    List<Departamento> depa;
    int selected;
    String departamentoo="";
    int breakhilo=0;
    DefaultTableModel base;
    int xx;
    int yy;
    int sortColumn;
    int[] row;
    /**
     * Creates new form calendariovinculos
     * @param parent
     * @param modal
     */
    public Fvinculos1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(700,307);
        jTable1.getColumn("Agregar").setCellRenderer(new ButtonRenderer());
        setPreferredSize(new Dimension(640,307));
        dispose();
        setUndecorated(true);
        setLocationRelativeTo(null);
        tablasmodelos(jTable1,jPanel1);
        JScrollBar sb = jScrollPane1.getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        
        jTable1.getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        jTable1.getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        jTable1.getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        jTable1.getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        jTable1.getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        jTable1.getColumnModel().getColumn(5).setCellRenderer( new CellRenderer("text center") );
        
        jTable1.getColumn("Agregar").setCellRenderer(new ButtonRenderer());
        
        try{
            rrhh.servicio.ServiceHb helper = new rrhh.servicio.ServiceHb();
            helper.iniciarTransaccion();
            depa = helper.getdepartamentosByTipo2();
            helper.cerrarSesion();
        }catch(Exception io){
        
        }
        for(Departamento j: depa){
            jComboBox1.addItem(j.getNombre());
        }
        jComboBox1.addItem("Inactivo");
        jComboBox1.addActionListener(new java.awt.event.ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTablas up = new updateTablas(1);
                up.start();
            }
        });
        setVisible(true);
    }
    public void llenar(){
        try{
            rrhh.servicio.ServiceHb helper = new rrhh.servicio.ServiceHb();
            helper.iniciarTransaccion();
            lista= helper.getPersonasByTipotext2(jComboBox1.getSelectedItem().toString(),jTextField1.getText());
            reiniciarJTable(jTable1);    
            if(lista!=null){
                for(Empleado i: lista){
                    if(i.getDepartamento()!=null){
                        String c= ""+i.getCi();
                        String c1=i.getNombre1()+" "+i.getNombre2();
                        String c2=i.getApellido1()+" "+i.getApellido2();
                        String c3=i.getDeptEmpl().getDepartamento().getNombre();
                        String c4=i.getPerfilpuesto();
                        DefaultTableModel temp = (DefaultTableModel) jTable1.getModel();
                        Object nuevo[]= {i.getCid(),c1,c2,c3,c4,c};
                        temp.addRow(nuevo);
                    }
                }
            }
            helper.cerrarSesion();
        }catch(Exception io){
        
        }
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
                //llenarfinan();
            }
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jScrollPane1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N

        jTable1.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula", "Nombre", "Apellidos", "Departamento", "Cargo", "Agregar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, true
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
            jTable1.getColumnModel().getColumn(5).setMinWidth(60);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(60);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 30, 700, 240);

        jLabel1.setBackground(new java.awt.Color(153, 153, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SALIR");
        jLabel1.setOpaque(true);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 270, 700, 40);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(0, 0, 400, 30);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(400, 0, 300, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 700, 310);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        int col = jTable1.getSelectedColumn();
        if(col==5){
            selected=Integer.parseInt(jTable1.getValueAt(row, col).toString());
            departamentoo= jTable1.getValueAt(row, 3).toString();
            dispose();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        selected=0;
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        updateTablas up = new updateTablas(1);
        up.start();
    }//GEN-LAST:event_jTextField1KeyTyped

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }


    public List<Empleado> getLista() {
        return lista;
    }

    public void setLista(List<Empleado> lista) {
        this.lista = lista;
    }

    public List<Departamento> getDepa() {
        return depa;
    }

    public void setDepa(List<Departamento> depa) {
        this.depa = depa;
    }

    public String getDepartamentoo() {
        return departamentoo;
    }

    public void setDepartamentoo(String departamentoo) {
        this.departamentoo = departamentoo;
    }

    public int getBreakhilo() {
        return breakhilo;
    }

    public void setBreakhilo(int breakhilo) {
        this.breakhilo = breakhilo;
    }

    public DefaultTableModel getBase() {
        return base;
    }

    public void setBase(DefaultTableModel base) {
        this.base = base;
    }

    public int getXx() {
        return xx;
    }

    public void setXx(int xx) {
        this.xx = xx;
    }

    public int getYy() {
        return yy;
    }

    public void setYy(int yy) {
        this.yy = yy;
    }

    public int getSortColumn() {
        return sortColumn;
    }

    public void setSortColumn(int sortColumn) {
        this.sortColumn = sortColumn;
    }

    public int[] getRow() {
        return row;
    }

    public void setRow(int[] row) {
        this.row = row;
    }

    public JComboBox getjComboBox1() {
        return jComboBox1;
    }

    public void setjComboBox1(JComboBox jComboBox1) {
        this.jComboBox1 = jComboBox1;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
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
            java.util.logging.Logger.getLogger(Fvinculos1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fvinculos1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fvinculos1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fvinculos1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Fvinculos1 dialog = new Fvinculos1(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
