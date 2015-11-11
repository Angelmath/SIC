/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.ventas;

import Login.Entidad.Items;
import Login.Entidad.Login;
import Login.servicio.ServiceHb;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;
import org.apache.poi.hssf.usermodel.HSSFCell;

/**
 *
 * @author Angelmath
 */
public final class presentar1materiales extends javax.swing.JDialog {
    marco padre;
    instalacion empl;
    String cl;
    Login Usuario;
    String razon;
    String insta;
    String cliente;
    String nombre;
    ArrayList lt= new ArrayList();
    File archivoEntrada=null;
    /**
     * Creates new form ingresoU
     */
    public presentar1materiales(java.awt.Frame parent, marco padre, boolean modal,String modelo,Login user) {
        super(parent,modal);
        this.padre=padre;
        initComponents();  
        Items it=null;
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            it=helper.getItems(modelo);
            helper.cerrarSesion();
        }catch(Exception io){
        
        }
        getjLabel4().setText(it.getModelo());//id
        getjLabel6().setText(it.getMarca());//tipo        
        getjLabel10().setText(it.getCat());//Categoria    
        getjTextArea1().setText(it.getDl());
        getjTextArea1().setWrapStyleWord(true);
        getjTextArea1().setLineWrap(true);
        String linea = user.getDireccion()+"\\ficha_items\\"+it.getId()+".png";
        File fichero = new File(linea);
        try{
        if(fichero.exists()){
            BufferedImage b = (BufferedImage)ImageIO.read(fichero);
            javax.swing.ImageIcon  img  = new javax.swing.ImageIcon(b.getScaledInstance(90, 90, 1));
            jLabel2.setIcon(img);
        }else{
            BufferedImage b = (BufferedImage)ImageIO.read(getClass().getResource("/Login/imagenes/no_image.jpg"));
            javax.swing.ImageIcon  img  = new javax.swing.ImageIcon(b.getScaledInstance(90, 90, 1));
            jLabel2.setIcon(img);
        }
        }catch(Exception io){
        
        }
        getjLabel1().setSize(780,250);
        setSize(780,250);
        setLocationRelativeTo(null);
        setVisible(true);   
    }       

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }
    
    class ItemChangeListener implements ItemListener{
    @Override
    public void itemStateChanged(ItemEvent event) {
       
    }
    }

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
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


    public marco getPadre() {
        return padre;
    }

    public void setPadre(marco padre) {
        this.padre = padre;
    }

    public ArrayList getLt() {
        return lt;
    }

    public void setLt(ArrayList lt) {
        this.lt = lt;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso");
        setMinimumSize(new java.awt.Dimension(780, 270));
        getContentPane().setLayout(null);

        jLabel2.setHorizontalAlignment(JLabel.CENTER);
        jLabel2.setVerticalAlignment(JLabel.CENTER);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 20, 100, 90);

        jLabel3.setFont(new java.awt.Font("Roboto Light", 3, 14)); // NOI18N
        jLabel3.setText("ID:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(170, 20, 50, 40);

        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jLabel4.setText("N/A");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(250, 20, 170, 40);

        jLabel5.setFont(new java.awt.Font("Roboto Light", 3, 14)); // NOI18N
        jLabel5.setText("TIPO:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(170, 60, 50, 40);

        jLabel6.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jLabel6.setText("N/A");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(250, 60, 170, 40);

        jLabel9.setFont(new java.awt.Font("Roboto Light", 3, 14)); // NOI18N
        jLabel9.setText("CATEGORIA:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(440, 20, 90, 40);

        jLabel10.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jLabel10.setText("N/A");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(590, 20, 170, 40);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(170, 120, 590, 91);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 780, 240);

        getAccessibleContext().setAccessibleParent(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents



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
    class ButtonRenderer extends JLabel implements TableCellRenderer {

  public ButtonRenderer() {
    setOpaque(true);
  }

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
    } else {
      setForeground(table.getForeground());
      if(row%2==0){
                this.setBackground(new Color( 245, 245 , 245));
            }else{
                this.setBackground(new Color( 220, 220 , 220));
            }
      setIcon(new ImageIcon(getClass().getResource("/Login/imagenes/boton-ir.png")));
      setHorizontalAlignment(0);
    }
    this.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(255, 255, 255)));
    return this;
  }
  
  
}

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                presentar1materiales ingresoInventario = new presentar1materiales(null, null, true,null,null);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
