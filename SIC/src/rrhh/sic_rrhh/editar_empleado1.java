/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.sic_rrhh;

import Login.servicio.Funcion;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import rrhh.Entidad.CvAdicional;
import rrhh.Entidad.CvEstudio;
import rrhh.Entidad.CvIdioma;
import rrhh.Entidad.CvLaboral;
import rrhh.Entidad.CvReferencia;
import rrhh.Entidad.Departamento;
import rrhh.Entidad.DeptEmpl;
import rrhh.Entidad.Empleado;
import rrhh.servicio.ServiceHb;

/**
 *
 * @author Matheus
 */
public final class editar_empleado1 extends javax.swing.JPanel {
    Dimension d;
    String direccion;
    String fotot;
    String entrefoto;
    String directoriofoto;
    String directoriocv;
    editar_empleado2 edi2;
    editar_empleado3 edi3;
    editar_empleado4 edi4;
    editar_empleado5 edi5;
    editar_empleado6 edi6;
    Empleado tempo;
    String departamento_nombre;
    int turno=1;
    float sueldot;
    float sueldo;
    float iess;
    float suple;
    int wid= 480;
    int xi=0;
    /**
     * Creates new form inicio
     * @param direccion
     */
    public editar_empleado1(String direccion) {
        initComponents();
        edi2 = new editar_empleado2(direccion);
        edi3 = new editar_empleado3(direccion);
        edi4 = new editar_empleado4(direccion);
        edi5 = new editar_empleado5(direccion);
        edi6 = new editar_empleado6(direccion);
        
        jPanel3.setVisible(false);
        this.direccion=direccion;
        this.fotot= direccion+"foto_empleados\\temporal.jpeg";
        this.directoriofoto="foto_empleados\\";
        this.directoriocv="pdf_cajamarca\\";
        d = Toolkit.getDefaultToolkit().getScreenSize();
        List<Departamento> dept=null;
        xi= jPanel1.getX();
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            dept= helper.getdepartamentosByTipo();
            helper.cerrarSesion();
        }catch(Exception io){
            
        }
        jComboBox1.removeAllItems();
        for(Departamento i: dept){
            jComboBox1.addItem(i.getNombre());
        }
        setSize(d.width-100, d.height-61);
        jSeparator1.setSize(d.width-180, 3);
        jLabel3.setLocation(jSeparator1.getX()+jSeparator1.getWidth()-jLabel3.getWidth(), jLabel3.getY());
        jButton1.setLocation((jPanel2.getWidth()/2)-jButton1.getWidth()/2, jButton1.getY());
        jLabel20.setLocation((jPanel2.getWidth()/2)-jLabel20.getWidth()/2, jLabel20.getY());
        jPanel4.setLocation((this.getWidth()/2)-jPanel4.getWidth()/2, jPanel4.getY());
        jLabel41.setLocation(jLabel3.getX()-jLabel41.getWidth()-10, jLabel41.getY());
        agregarpaneles();
        setVisible(false);
    }

    public editar_empleado2 getEdi2() {
        return edi2;
    }

    public void setEdi2(editar_empleado2 edi2) {
        this.edi2 = edi2;
    }

    public editar_empleado3 getEdi3() {
        return edi3;
    }

    public void setEdi3(editar_empleado3 edi3) {
        this.edi3 = edi3;
    }

    public editar_empleado4 getEdi4() {
        return edi4;
    }

    public void setEdi4(editar_empleado4 edi4) {
        this.edi4 = edi4;
    }

    public editar_empleado5 getEdi5() {
        return edi5;
    }

    public void setEdi5(editar_empleado5 edi5) {
        this.edi5 = edi5;
    }

    public editar_empleado6 getEdi6() {
        return edi6;
    }

    public void setEdi6(editar_empleado6 edi6) {
        this.edi6 = edi6;
    }

    public Empleado getTempo() {
        return tempo;
    }

    public JLabel getjLabel42() {
        return jLabel42;
    }

    public void setjLabel42(JLabel jLabel42) {
        this.jLabel42 = jLabel42;
    }

    public JTextField getjTextField22() {
        return jTextField22;
    }

    public void setjTextField22(JTextField jTextField22) {
        this.jTextField22 = jTextField22;
    }

    public void setTempo(Empleado tempo) {
        this.tempo = tempo;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public JComboBox getjComboBox7() {
        return jComboBox7;
    }

    public void setjComboBox7(JComboBox jComboBox7) {
        this.jComboBox7 = jComboBox7;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel34() {
        return jLabel34;
    }

    public void setjLabel34(JLabel jLabel34) {
        this.jLabel34 = jLabel34;
    }

    public JLabel getjLabel35() {
        return jLabel35;
    }

    public void setjLabel35(JLabel jLabel35) {
        this.jLabel35 = jLabel35;
    }

    public JLabel getjLabel37() {
        return jLabel37;
    }

    public void setjLabel37(JLabel jLabel37) {
        this.jLabel37 = jLabel37;
    }

    public JLabel getjLabel39() {
        return jLabel39;
    }

    public void setjLabel39(JLabel jLabel39) {
        this.jLabel39 = jLabel39;
    }

    public JLabel getjLabel40() {
        return jLabel40;
    }

    public void setjLabel40(JLabel jLabel40) {
        this.jLabel40 = jLabel40;
    }

    public JLabel getjLabel41() {
        return jLabel41;
    }

    public void setjLabel41(JLabel jLabel41) {
        this.jLabel41 = jLabel41;
    }

    public JPanel getjPanel5() {
        return jPanel5;
    }

    public void setjPanel5(JPanel jPanel5) {
        this.jPanel5 = jPanel5;
    }
    
    public void cambio(JPanel pane){
        jPanel5.setVisible(false);
        edi2.setVisible(false);
        edi3.setVisible(false);
        edi4.setVisible(false);
        edi5.setVisible(false);
        edi6.setVisible(false);
        pane.setVisible(true);
        jPanel4.setVisible(false);
    }
    
    public void agregarpaneles(){
        /*Paneles del Frame*/
        edi2.setLocation(0, jPanel5.getY());
        add(edi2);
        
        edi3.setLocation(0, jPanel5.getY());
        add(edi3);
        
        edi4.setLocation(0, jPanel5.getY());
        add(edi4);
        
        edi5.setLocation(0, jPanel5.getY());
        add(edi5);
        
        edi6.setLocation(0, jPanel5.getY());
        add(edi6);
        edi2.getjTable1().getColumn("ESTADO").setCellRenderer(new ButtonRenderer());
        edi3.getjTable1().getColumn("ESTADO").setCellRenderer(new ButtonRenderer());
        edi4.getjTable1().getColumn("ESTADO").setCellRenderer(new ButtonRenderer());
        edi5.getjTable1().getColumn("ESTADO").setCellRenderer(new ButtonRenderer());
        edi6.getjTable1().getColumn("ESTADO").setCellRenderer(new ButtonRenderer());
        
        /*Tabla edi2*/
        edi2.getjTable1().addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                if(edi2.getjTable1().getSelectedColumn()==5){
                    String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
                    if(selectedSiteName.equalsIgnoreCase("cajamarca")){ 
                        ServiceHb helper = new ServiceHb();
                        helper.iniciarTransaccion();
                        helper.eliminarObjeto(edi2.getjTable1().getValueAt(edi2.getjTable1().getSelectedRow(), 5));
                        helper.confirmarTransaccion();
                        helper.cerrarSesion();
                        tablasedi();
                        JOptionPane.showMessageDialog(null,"Eliminado");
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(Cuerpo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        });
        
        /*Tabla edi2*/
        edi3.getjTable1().addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                if(edi3.getjTable1().getSelectedColumn()==3){
                    String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
                    if(selectedSiteName.equalsIgnoreCase("cajamarca")){ 
                        ServiceHb helper = new ServiceHb();
                        helper.iniciarTransaccion();
                        helper.eliminarObjeto(edi3.getjTable1().getValueAt(edi3.getjTable1().getSelectedRow(), 3));
                        helper.confirmarTransaccion();
                        helper.cerrarSesion();
                        tablasedi();
                        JOptionPane.showMessageDialog(null,"Eliminado");
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(Cuerpo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        });
        
        /*Tabla edi2*/
        edi4.getjTable1().addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                if(edi4.getjTable1().getSelectedColumn()==8){
                    String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
                    if(selectedSiteName.equalsIgnoreCase("cajamarca")){ 
                        ServiceHb helper = new ServiceHb();
                        helper.iniciarTransaccion();
                        helper.eliminarObjeto(edi4.getjTable1().getValueAt(edi4.getjTable1().getSelectedRow(), 8));
                        helper.confirmarTransaccion();
                        helper.cerrarSesion();
                        tablasedi();
                        JOptionPane.showMessageDialog(null,"Eliminado");
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(Cuerpo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        });
        
        /*Tabla edi2*/
        edi5.getjTable1().addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                if(edi5.getjTable1().getSelectedColumn()==5){
                    String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
                    if(selectedSiteName.equalsIgnoreCase("cajamarca")){ 
                        ServiceHb helper = new ServiceHb();
                        helper.iniciarTransaccion();
                        helper.eliminarObjeto(edi5.getjTable1().getValueAt(edi5.getjTable1().getSelectedRow(), 5));
                        helper.confirmarTransaccion();
                        helper.cerrarSesion();
                        tablasedi();
                        JOptionPane.showMessageDialog(null,"Eliminado");
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(Cuerpo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        });
        
        /*Tabla edi2*/
        edi6.getjTable1().addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                if(edi6.getjTable1().getSelectedColumn()==7){
                    String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
                    if(selectedSiteName.equalsIgnoreCase("cajamarca")){ 
                        ServiceHb helper = new ServiceHb();
                        helper.iniciarTransaccion();
                        helper.eliminarObjeto(edi6.getjTable1().getValueAt(edi6.getjTable1().getSelectedRow(), 7));
                        helper.confirmarTransaccion();
                        helper.cerrarSesion();
                        tablasedi();
                        JOptionPane.showMessageDialog(null,"Eliminado");
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(Cuerpo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        });
    }
    public void rellenar(Empleado emp){
        limpiar();
        tempo=emp;
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            /*** CI  ***/
            jTextField2.setText(emp.getCid());
            /***  N° Cuenta Bancaria ***/
            jTextField25.setText(emp.getCuentanum());
            /***  CI Dueño de Cuenta ***/
            jTextField18.setText(emp.getCuentaci());
            /***  Nombre Dueño de Cuenta ***/
            jTextField19.setText(emp.getCuentadue());
            /***  Tipo de Cuenta ***/
            jTextField20.setText(emp.getCuentatipo());
            /***  Banco ***/
            jTextField21.setText(emp.getBanco());
            /***  Perfil Puesto ***/
            jComboBox7.setSelectedItem(emp.getPerfilpuesto());
            /***  Estado Cajamarca ***/
            jComboBox6.setSelectedItem(emp.getEstado());
            /***  1 Nombre ***/
            jTextField3.setText(emp.getNombre1());
            /***  2 Nombre ***/
            jTextField4.setText(emp.getNombre2());
            /***  1 Apellido ***/
            jTextField5.setText(emp.getApellido1());
            /***  2 Apellido ***/
            jTextField6.setText(emp.getApellido2());
            /***  genero ***/
            jComboBox4.setSelectedItem(emp.getFondos());
            /***  genero ***/
            if(emp.getGenero()=='M'){
                jComboBox2.setSelectedItem("Masculino");
            }else{
                jComboBox2.setSelectedItem("Femenino");
            }
            /***  fecha nacimiento ***/
            jDateChooser2.setDate(emp.getFechaNacimiento());
            /***  estado civil  ***/
            if(emp.getEstadoCivil()==('C')){jComboBox2.setSelectedItem("Casado (A");}
            if(emp.getEstadoCivil()==('D')){jComboBox2.setSelectedItem("Divorciado (A)");}
            if(emp.getEstadoCivil()==('S')){jComboBox2.setSelectedItem("Soltero (A)");}
            if(emp.getEstadoCivil()==('V')){jComboBox2.setSelectedItem("Viudo (A)");}
            if(emp.getEstadoCivil()==('U')){jComboBox2.setSelectedItem("Union Libre");}
            
            /***  email ***/
            jTextField12.setText(emp.getCorreo());
            /***  direccion ***/
            jTextField14.setText(emp.getDireccion());
            /***  celular ***/
            jTextField16.setText(emp.getCelular());
            /***  direccion ***/
            jTextField14.setText(emp.getDireccion());
            /***  descripcion ***/
            jTextField1.setText(emp.getCiudad());
            /***  fecha ingreso ***/
            jDateChooser3.setDate(emp.getFechaIngreso());
            /***  nacionalidad ***/
            jTextField11.setText(emp.getPais());
            /***  ciudad residencia ***/
            jTextField13.setText(emp.getCuidadResidencia());
            /***  telefono ***/
            jTextField15.setText(emp.getTelefono());
            /***  fecha salida ***/
            if((emp.getSalidaemp()!=null)&&(!emp.getSalidaemp().equalsIgnoreCase(""))){
                jDateChooser1.setDate(Funcion.StringToDate(emp.getSalidaemp()));
            }
            /***  Sueldo Total ***/
            jTextField7.setText(emp.getCumple2());
            /***  Sueldo ***/
            jTextField8.setText(emp.getDato1());
            /***  IESS ***/
            jTextField9.setText(emp.getDato2());
            /***  Suplementario ***/
            jTextField10.setText(emp.getDato3());
            /***  Suplementario ***/
            jTextField22.setText(emp.getDato4());
            
            /***  Foto  ***/
            entrefoto=emp.getFoto();
            String ex ="";
            try{
                ImageIcon icon = new ImageIcon(direccion+entrefoto);//Iniciamos imagen en un ImageIcon y luego la
                //redimensionamos al tamaño de la etiqueta
                ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(jLabel20.getWidth(), getjLabel20().getHeight(), Image.SCALE_DEFAULT));
                jLabel20.setIcon(icono);
            }catch(Exception io){
                
            }
            /***  CV  ***/
            jTextField17.setText(direccion+emp.getCv());
            /***  departamento tabla ***/
            
            jComboBox1.setSelectedItem(emp.getDeptEmpl().getDepartamento().getNombre());
            /***  departamento celda ***/
            departamento_nombre=jComboBox1.getSelectedItem().toString();
            jComboBox8.setSelectedItem(emp.getDecimotercero());
            jComboBox9.setSelectedItem(emp.getDecimocuarto());
            jComboBox10.setSelectedItem(emp.getAlimentacion());
            jComboBox5.setSelectedItem(emp.getActividades());
                    
            helper.cerrarSesion();
        }
        
        catch(Exception io){
            System.out.println(io);
        }
    }
    public Dimension getD() {
        return d;
    }
    
    public String getDirectoriofoto() {
        return directoriofoto;
    }
    
    public void setDirectoriofoto(String directoriofoto) {
        this.directoriofoto = directoriofoto;
    }
    
    public String getDirectoriocv() {
        return directoriocv;
    }
    
    public void setDirectoriocv(String directoriocv) {
        this.directoriocv = directoriocv;
    }
    
    public int getWid() {
        return wid;
    }
    
    public void setWid(int wid) {
        this.wid = wid;
    }
    
    public int getXi() {
        return xi;
    }
    
    public void setXi(int xi) {
        this.xi = xi;
    }
    
    public JButton getjButton2() {
        return jButton2;
    }
    
    public void setjButton2(JButton jButton2) {
        this.jButton2 = jButton2;
    }
    
    public JButton getjButton4() {
        return jButton4;
    }
    
    public void setjButton4(JButton jButton4) {
        this.jButton4 = jButton4;
    }
    
    public JButton getjButton5() {
        return jButton5;
    }
    
    public void setjButton5(JButton jButton5) {
        this.jButton5 = jButton5;
    }
    
    public JComboBox getjComboBox6() {
        return jComboBox6;
    }
    
    public void setjComboBox6(JComboBox jComboBox6) {
        this.jComboBox6 = jComboBox6;
    }
    
    public JLabel getjLabel27() {
        return jLabel27;
    }
    
    public void setjLabel27(JLabel jLabel27) {
        this.jLabel27 = jLabel27;
    }
    
    public JLabel getjLabel28() {
        return jLabel28;
    }
    
    public void setjLabel28(JLabel jLabel28) {
        this.jLabel28 = jLabel28;
    }
    
    public JLabel getjLabel29() {
        return jLabel29;
    }
    
    public void setjLabel29(JLabel jLabel29) {
        this.jLabel29 = jLabel29;
    }
    
    public JLabel getjLabel30() {
        return jLabel30;
    }
    
    public void setjLabel30(JLabel jLabel30) {
        this.jLabel30 = jLabel30;
    }
    
    public JLabel getjLabel31() {
        return jLabel31;
    }
    
    public void setjLabel31(JLabel jLabel31) {
        this.jLabel31 = jLabel31;
    }
    
    public JLabel getjLabel32() {
        return jLabel32;
    }
    
    public void setjLabel32(JLabel jLabel32) {
        this.jLabel32 = jLabel32;
    }
    
    public JLabel getjLabel33() {
        return jLabel33;
    }
    
    public void setjLabel33(JLabel jLabel33) {
        this.jLabel33 = jLabel33;
    }
    
    public JLabel getjLabel36() {
        return jLabel36;
    }
    
    public void setjLabel36(JLabel jLabel36) {
        this.jLabel36 = jLabel36;
    }
    
    public JLabel getjLabel38() {
        return jLabel38;
    }
    
    public void setjLabel38(JLabel jLabel38) {
        this.jLabel38 = jLabel38;
    }
    
    public JPanel getjPanel3() {
        return jPanel3;
    }
    
    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }
    
    public JPanel getjPanel4() {
        return jPanel4;
    }
    
    public void setjPanel4(JPanel jPanel4) {
        this.jPanel4 = jPanel4;
    }
    
    public JSeparator getjSeparator2() {
        return jSeparator2;
    }
    
    public void setjSeparator2(JSeparator jSeparator2) {
        this.jSeparator2 = jSeparator2;
    }
    
    public JTextField getjTextField17() {
        return jTextField17;
    }
    
    public void setjTextField17(JTextField jTextField17) {
        this.jTextField17 = jTextField17;
    }
    
    public JTextField getjTextField18() {
        return jTextField18;
    }
    
    public void setjTextField18(JTextField jTextField18) {
        this.jTextField18 = jTextField18;
    }
    
    public JTextField getjTextField19() {
        return jTextField19;
    }
    
    public void setjTextField19(JTextField jTextField19) {
        this.jTextField19 = jTextField19;
    }
    
    public JTextField getjTextField20() {
        return jTextField20;
    }
    
    public void setjTextField20(JTextField jTextField20) {
        this.jTextField20 = jTextField20;
    }
    
    public JTextField getjTextField21() {
        return jTextField21;
    }
    
    public void setjTextField21(JTextField jTextField21) {
        this.jTextField21 = jTextField21;
    }
    
    public JTextField getjTextField25() {
        return jTextField25;
    }
    
    public void setjTextField25(JTextField jTextField25) {
        this.jTextField25 = jTextField25;
    }
    
    public JComboBox getjComboBox1() {
        return jComboBox1;
    }
    
    public void setjComboBox1(JComboBox jComboBox1) {
        this.jComboBox1 = jComboBox1;
    }
    
    public JComboBox getjComboBox2() {
        return jComboBox2;
    }
    
    public void setjComboBox2(JComboBox jComboBox2) {
        this.jComboBox2 = jComboBox2;
    }
    
    public JComboBox getjComboBox3() {
        return jComboBox3;
    }
    
    public void setjComboBox3(JComboBox jComboBox3) {
        this.jComboBox3 = jComboBox3;
    }
    
    public JDateChooser getjDateChooser1() {
        return jDateChooser1;
    }
    
    public void setjDateChooser1(JDateChooser jDateChooser1) {
        this.jDateChooser1 = jDateChooser1;
    }
    
    public JDateChooser getjDateChooser2() {
        return jDateChooser2;
    }
    
    public void setjDateChooser2(JDateChooser jDateChooser2) {
        this.jDateChooser2 = jDateChooser2;
    }
    
    public JDateChooser getjDateChooser3() {
        return jDateChooser3;
    }
    
    public void setjDateChooser3(JDateChooser jDateChooser3) {
        this.jDateChooser3 = jDateChooser3;
    }
    
    public JLabel getjLabel21() {
        return jLabel21;
    }
    
    public void setjLabel21(JLabel jLabel21) {
        this.jLabel21 = jLabel21;
    }
    
    public JLabel getjLabel22() {
        return jLabel22;
    }
    
    public void setjLabel22(JLabel jLabel22) {
        this.jLabel22 = jLabel22;
    }
    
    public void setD(Dimension d) {
        this.d = d;
    }
    
    public JLabel getjLabel10() {
        return jLabel10;
    }
    
    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
    }
    
    public JLabel getjLabel11() {
        return jLabel11;
    }
    
    public void setjLabel11(JLabel jLabel11) {
        this.jLabel11 = jLabel11;
    }
    
    public JLabel getjLabel12() {
        return jLabel12;
    }
    
    public void setjLabel12(JLabel jLabel12) {
        this.jLabel12 = jLabel12;
    }
    
    public JLabel getjLabel13() {
        return jLabel13;
    }
    
    public void setjLabel13(JLabel jLabel13) {
        this.jLabel13 = jLabel13;
    }
    
    public JLabel getjLabel14() {
        return jLabel14;
    }
    
    public void setjLabel14(JLabel jLabel14) {
        this.jLabel14 = jLabel14;
    }
    
    public JLabel getjLabel15() {
        return jLabel15;
    }
    
    public void setjLabel15(JLabel jLabel15) {
        this.jLabel15 = jLabel15;
    }
    
    public JLabel getjLabel16() {
        return jLabel16;
    }
    
    public void setjLabel16(JLabel jLabel16) {
        this.jLabel16 = jLabel16;
    }
    
    public JLabel getjLabel17() {
        return jLabel17;
    }
    
    public void setjLabel17(JLabel jLabel17) {
        this.jLabel17 = jLabel17;
    }
    
    public JLabel getjLabel18() {
        return jLabel18;
    }
    
    public void setjLabel18(JLabel jLabel18) {
        this.jLabel18 = jLabel18;
    }
    
    public JLabel getjLabel19() {
        return jLabel19;
    }
    
    public void setjLabel19(JLabel jLabel19) {
        this.jLabel19 = jLabel19;
    }
    
    public JLabel getjLabel2() {
        return jLabel2;
    }
    
    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }
    
    public JLabel getjLabel20() {
        return jLabel20;
    }
    
    public void setjLabel20(JLabel jLabel20) {
        this.jLabel20 = jLabel20;
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
    
    public JLabel getjLabel7() {
        return jLabel7;
    }
    
    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
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
    
    public JSeparator getjSeparator1() {
        return jSeparator1;
    }
    
    public void setjSeparator1(JSeparator jSeparator1) {
        this.jSeparator1 = jSeparator1;
    }
    
    public JTextField getjTextField1() {
        return jTextField1;
    }
    
    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }
    
    public JTextField getjTextField11() {
        return jTextField11;
    }
    
    public void setjTextField11(JTextField jTextField11) {
        this.jTextField11 = jTextField11;
    }
    
    public JTextField getjTextField12() {
        return jTextField12;
    }
    
    public void setjTextField12(JTextField jTextField12) {
        this.jTextField12 = jTextField12;
    }
    
    public JTextField getjTextField13() {
        return jTextField13;
    }
    
    public void setjTextField13(JTextField jTextField13) {
        this.jTextField13 = jTextField13;
    }
    
    public JTextField getjTextField14() {
        return jTextField14;
    }
    
    public void setjTextField14(JTextField jTextField14) {
        this.jTextField14 = jTextField14;
    }
    
    public JTextField getjTextField15() {
        return jTextField15;
    }
    
    public void setjTextField15(JTextField jTextField15) {
        this.jTextField15 = jTextField15;
    }
    
    public JTextField getjTextField16() {
        return jTextField16;
    }
    
    public void setjTextField16(JTextField jTextField16) {
        this.jTextField16 = jTextField16;
    }
    
    public JTextField getjTextField2() {
        return jTextField2;
    }
    
    public void setjTextField2(JTextField jTextField2) {
        this.jTextField2 = jTextField2;
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
    
    public JTextField getjTextField5() {
        return jTextField5;
    }
    
    public void setjTextField5(JTextField jTextField5) {
        this.jTextField5 = jTextField5;
    }
    
    public JTextField getjTextField6() {
        return jTextField6;
    }
    
    public void setjTextField6(JTextField jTextField6) {
        this.jTextField6 = jTextField6;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jTextField11 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jComboBox6 = new javax.swing.JComboBox();
        jComboBox7 = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel43 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();
        jComboBox8 = new javax.swing.JComboBox();
        jLabel47 = new javax.swing.JLabel();
        jComboBox9 = new javax.swing.JComboBox();
        jLabel48 = new javax.swing.JLabel();
        jComboBox10 = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel32 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setEnabled(false);
        setLayout(null);
        add(jSeparator1);
        jSeparator1.setBounds(30, 90, 830, 10);

        jLabel2.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 74, 152));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Informacion Basica");
        add(jLabel2);
        jLabel2.setBounds(90, 50, 220, 24);

        jLabel3.setBackground(new java.awt.Color(0, 74, 152));
        jLabel3.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Guardar");
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        add(jLabel3);
        jLabel3.setBounds(850, 50, 160, 30);

        jPanel5.setOpaque(false);
        jPanel5.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel6.setText("Primer Nombre:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 60, 190, 22);

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel7.setText("Segundo Nombre:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(0, 100, 190, 22);

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel8.setText("Apellido Paterno:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(0, 140, 190, 22);

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel9.setText("Apellido Materno:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(0, 180, 190, 22);

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel10.setText("Género:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(0, 220, 190, 22);

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel11.setText("Fecha de Nacimiento:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(0, 260, 190, 22);

        jLabel13.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel13.setText("Estado Civil:");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(0, 300, 190, 22);

        jLabel15.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel15.setText("Email:");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(0, 340, 190, 22);

        jLabel17.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel17.setText("Direccion:");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(0, 380, 190, 22);

        jLabel19.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel19.setText("Celular:");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(0, 420, 190, 22);

        jTextField3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(jTextField3);
        jTextField3.setBounds(230, 60, 230, 24);

        jTextField4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(jTextField4);
        jTextField4.setBounds(230, 100, 230, 24);

        jTextField5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(jTextField5);
        jTextField5.setBounds(230, 140, 230, 24);

        jTextField6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(jTextField6);
        jTextField6.setBounds(230, 180, 230, 24);

        jTextField12.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(jTextField12);
        jTextField12.setBounds(230, 340, 230, 24);

        jTextField14.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(jTextField14);
        jTextField14.setBounds(230, 380, 230, 24);

        jTextField16.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(jTextField16);
        jTextField16.setBounds(230, 420, 230, 24);

        jDateChooser2.setPreferredSize(new java.awt.Dimension(87, 24));
        jPanel1.add(jDateChooser2);
        jDateChooser2.setBounds(230, 260, 230, 24);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));
        jComboBox2.setPreferredSize(new java.awt.Dimension(93, 24));
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(230, 220, 230, 24);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Soltero (A)", "Divorciado (A)", "Casado (A)", "Viudo (A)", "Union Libre" }));
        jComboBox3.setPreferredSize(new java.awt.Dimension(93, 24));
        jPanel1.add(jComboBox3);
        jComboBox3.setBounds(230, 300, 230, 24);

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel5.setText("Cédula de Identidad");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(0, 20, 190, 22);

        jTextField2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField2);
        jTextField2.setBounds(230, 20, 230, 24);

        jLabel23.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel23.setText("Sueldo Total:");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(0, 460, 190, 22);

        jTextField7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField7);
        jTextField7.setBounds(230, 460, 230, 24);

        jLabel24.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel24.setText("Horas Extras:");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(0, 540, 190, 22);

        jTextField8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField8KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField8);
        jTextField8.setBounds(230, 500, 230, 24);

        jLabel42.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel42.setText("Sueldo:");
        jPanel1.add(jLabel42);
        jLabel42.setBounds(0, 500, 190, 22);

        jTextField22.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jTextField22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField22KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField22KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField22);
        jTextField22.setBounds(230, 540, 230, 24);

        jPanel5.add(jPanel1);
        jPanel1.setBounds(30, 0, 480, 570);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel20.setBackground(new java.awt.Color(204, 204, 204));
        jLabel20.setOpaque(true);
        jPanel2.add(jLabel20);
        jLabel20.setBounds(60, 10, 160, 160);

        jButton1.setText("Cargar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(90, 170, 100, 30);

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel12.setText("CV:");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(0, 220, 190, 22);

        jDateChooser3.setPreferredSize(new java.awt.Dimension(87, 24));
        jPanel2.add(jDateChooser3);
        jDateChooser3.setBounds(230, 260, 230, 24);

        jTextField11.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.add(jTextField11);
        jTextField11.setBounds(230, 300, 230, 24);

        jLabel14.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel14.setText("Nacionalidad:");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(0, 300, 190, 22);

        jLabel16.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel16.setText("Cuidad de Residencia:");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(0, 340, 190, 22);

        jTextField13.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.add(jTextField13);
        jTextField13.setBounds(230, 340, 230, 24);

        jTextField15.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.add(jTextField15);
        jTextField15.setBounds(230, 380, 230, 24);

        jComboBox1.setPreferredSize(new java.awt.Dimension(93, 24));
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(230, 420, 230, 24);

        jLabel18.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel18.setText("Departamento:");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(0, 420, 190, 22);

        jLabel22.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel22.setText("Telefono:");
        jPanel2.add(jLabel22);
        jLabel22.setBounds(0, 380, 190, 22);

        jLabel26.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel26.setText("Suplementario:");
        jPanel2.add(jLabel26);
        jLabel26.setBounds(0, 500, 190, 22);

        jTextField10.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField10KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField10KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField10);
        jTextField10.setBounds(230, 500, 230, 24);

        jTextField9.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField9KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField9KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField9);
        jTextField9.setBounds(230, 460, 230, 24);

        jLabel25.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel25.setText("IESS:");
        jPanel2.add(jLabel25);
        jLabel25.setBounds(0, 460, 190, 22);

        jLabel27.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel27.setText("Fecha de Ingreso:");
        jPanel2.add(jLabel27);
        jLabel27.setBounds(0, 260, 190, 22);

        jTextField17.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jTextField17.setEnabled(false);
        jPanel2.add(jTextField17);
        jTextField17.setBounds(230, 220, 200, 24);

        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(430, 220, 30, 24);

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel4.setText("Descripcion:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(0, 540, 190, 22);

        jTextField1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.add(jTextField1);
        jTextField1.setBounds(230, 540, 230, 24);

        jPanel5.add(jPanel2);
        jPanel2.setBounds(510, 0, 480, 570);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(null);

        jLabel28.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel28.setText("CI Dueño de Cuenta:");
        jPanel3.add(jLabel28);
        jLabel28.setBounds(0, 60, 190, 22);

        jLabel29.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel29.setText("Nombre Dueño de Cuenta:");
        jPanel3.add(jLabel29);
        jLabel29.setBounds(0, 100, 190, 22);

        jLabel30.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel30.setText("Tipo de Cuenta:");
        jPanel3.add(jLabel30);
        jLabel30.setBounds(0, 140, 190, 22);

        jLabel31.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel31.setText("Banco:");
        jPanel3.add(jLabel31);
        jLabel31.setBounds(0, 180, 190, 22);

        jLabel33.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel33.setText("Perfil Puesto:");
        jPanel3.add(jLabel33);
        jLabel33.setBounds(0, 220, 190, 22);

        jLabel36.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel36.setText("Estado Cajamarca:");
        jPanel3.add(jLabel36);
        jLabel36.setBounds(0, 260, 190, 22);

        jTextField18.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField18.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.add(jTextField18);
        jTextField18.setBounds(230, 60, 230, 24);

        jTextField19.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField19.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.add(jTextField19);
        jTextField19.setBounds(230, 100, 230, 24);

        jTextField20.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.add(jTextField20);
        jTextField20.setBounds(230, 140, 230, 24);

        jTextField21.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.add(jTextField21);
        jTextField21.setBounds(230, 180, 230, 24);

        jLabel38.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel38.setText("N° Cuenta Bancaria:");
        jPanel3.add(jLabel38);
        jLabel38.setBounds(0, 20, 190, 22);

        jTextField25.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField25.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jTextField25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField25ActionPerformed(evt);
            }
        });
        jTextField25.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField25KeyTyped(evt);
            }
        });
        jPanel3.add(jTextField25);
        jTextField25.setBounds(230, 20, 230, 24);

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activo", "Inactivo" }));
        jComboBox6.setPreferredSize(new java.awt.Dimension(93, 24));
        jPanel3.add(jComboBox6);
        jComboBox6.setBounds(230, 260, 230, 24);

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Guardia", "Asistente Administrativa Contable", "Asistente Compras y Bodega", "Chofer", "Coordinadora de Instalaciones", "Coordinadora RRHH", "Diseñador Grafico", "Jefe Financiero", "Mensajero Limpieza", "Poligrafista", "Programador", "Supervisor", "Tecnico Jr", "Tecnico Sr", "Asesor Comercial", "Jefe de Operaciones", "Jefe Técnico", "Gerente General", "Poligrafista - Asistente RRHH", "Supervisores Guardianía" }));
        jComboBox7.setPreferredSize(new java.awt.Dimension(93, 24));
        jPanel3.add(jComboBox7);
        jComboBox7.setBounds(230, 220, 230, 24);

        jLabel21.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel21.setText("Actividades Comunes:");
        jPanel3.add(jLabel21);
        jLabel21.setBounds(0, 510, 190, 22);

        jDateChooser1.setPreferredSize(new java.awt.Dimension(87, 24));
        jPanel3.add(jDateChooser1);
        jDateChooser1.setBounds(230, 300, 230, 24);

        jLabel43.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel43.setText("Salida:");
        jPanel3.add(jLabel43);
        jLabel43.setBounds(0, 300, 190, 22);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Acumula", "Acumula" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox4);
        jComboBox4.setBounds(230, 340, 230, 30);

        jLabel45.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel45.setText("Fondos de Reserva:");
        jPanel3.add(jLabel45);
        jLabel45.setBounds(0, 340, 190, 22);

        jLabel46.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel46.setText("DecimoCuarto Sueldo Mensual:");
        jPanel3.add(jLabel46);
        jLabel46.setBounds(0, 430, 190, 22);

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SI", "NO" }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox5);
        jComboBox5.setBounds(230, 510, 230, 30);

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO", "SI" }));
        jComboBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox8ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox8);
        jComboBox8.setBounds(230, 390, 230, 30);

        jLabel47.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel47.setText("Alimentacion:");
        jPanel3.add(jLabel47);
        jLabel47.setBounds(0, 470, 190, 22);

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO", "SI" }));
        jComboBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox9ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox9);
        jComboBox9.setBounds(230, 430, 230, 30);

        jLabel48.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel48.setText("DecimoTercer Sueldo Mensual:");
        jPanel3.add(jLabel48);
        jLabel48.setBounds(0, 390, 190, 22);

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO", "SI" }));
        jComboBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox10ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox10);
        jComboBox10.setBounds(230, 470, 230, 30);

        jPanel5.add(jPanel3);
        jPanel3.setBounds(990, 0, 480, 570);

        add(jPanel5);
        jPanel5.setBounds(0, 92, 1630, 590);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        jButton4.setText(">");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jPanel4.add(jButton4);
        jButton4.setBounds(60, 0, 40, 30);

        jButton5.setText("<");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jPanel4.add(jButton5);
        jButton5.setBounds(10, 0, 40, 30);

        add(jPanel4);
        jPanel4.setBounds(560, 50, 110, 30);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator2);
        jSeparator2.setBounds(90, 60, 10, 20);

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-eliminar.png"))); // NOI18N
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
        });
        add(jLabel32);
        jLabel32.setBounds(30, 50, 50, 30);

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("6");
        jLabel1.setOpaque(true);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
        add(jLabel1);
        jLabel1.setBounds(460, 50, 20, 30);

        jLabel34.setBackground(new java.awt.Color(204, 204, 204));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("1");
        jLabel34.setOpaque(true);
        jLabel34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel34MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel34MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel34MouseExited(evt);
            }
        });
        add(jLabel34);
        jLabel34.setBounds(310, 50, 20, 30);

        jLabel35.setBackground(new java.awt.Color(204, 204, 204));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("2");
        jLabel35.setOpaque(true);
        jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel35MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel35MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel35MouseExited(evt);
            }
        });
        add(jLabel35);
        jLabel35.setBounds(340, 50, 20, 30);

        jLabel37.setBackground(new java.awt.Color(204, 204, 204));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("3");
        jLabel37.setOpaque(true);
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel37MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel37MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel37MouseExited(evt);
            }
        });
        add(jLabel37);
        jLabel37.setBounds(370, 50, 20, 30);

        jLabel39.setBackground(new java.awt.Color(204, 204, 204));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("4");
        jLabel39.setOpaque(true);
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel39MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel39MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel39MouseExited(evt);
            }
        });
        add(jLabel39);
        jLabel39.setBounds(400, 50, 20, 30);

        jLabel40.setBackground(new java.awt.Color(204, 204, 204));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("5");
        jLabel40.setOpaque(true);
        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel40MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel40MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel40MouseExited(evt);
            }
        });
        add(jLabel40);
        jLabel40.setBounds(430, 50, 20, 30);

        jLabel41.setBackground(new java.awt.Color(0, 74, 152));
        jLabel41.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("regresar");
        jLabel41.setOpaque(true);
        add(jLabel41);
        jLabel41.setBounds(760, 50, 70, 30);

        jLabel44.setBackground(new java.awt.Color(255, 255, 255));
        jLabel44.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel44.setText("jLabel11");
        jLabel44.setEnabled(false);
        jLabel44.setOpaque(true);
        add(jLabel44);
        jLabel44.setBounds(0, 0, 70, 25);
        jLabel44.setVisible(false);
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        JFileChooser chooser = new JFileChooser();
        
        //Mostrar la ventana para abrir archivo y recoger la respuesta
        //En el parámetro del showOpenDialog se indica la ventana
        //  al que estará asociado. Con el valor this se asocia a la
        //  ventana que la abre.
        int valido=0;
        int respuesta = chooser.showOpenDialog(this);
        File archivoEntrada=null;
        if (respuesta == JFileChooser.APPROVE_OPTION)
        {
            //Crear un objeto File con el archivo elegido
            archivoEntrada = chooser.getSelectedFile();
            //Mostrar el nombre del archvivo en un campo de texto
            
            File archivoSalida = new File(direccion+"foto_empleados\\temporal.jpeg");
            FileChannel source = null;
            
            FileChannel destination = null;
            
            try {
                if(!archivoSalida.exists()) {
                    archivoSalida.createNewFile();
                    
                }
                
                source = new FileInputStream(archivoEntrada).getChannel();
                
                destination = new FileOutputStream(archivoSalida).getChannel();
                
                destination.transferFrom(source, 0, source.size());
                
            } catch(Exception io){
                
            }
            finally {
                if(source != null) {
                    try {
                        source.close();
                    } catch (IOException ex) {
                        Logger.getLogger(editar_empleado1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                
                if(destination != null) {
                    try {
                        destination.close();
                    } catch (IOException ex) {
                        Logger.getLogger(editar_empleado1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        }
        String ex ="";
        try{
            ImageIcon icon = new ImageIcon(fotot);//Iniciamos imagen en un ImageIcon y luego la
            //redimensionamos al tamaño de la etiqueta
            ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(jLabel20.getWidth(), getjLabel20().getHeight(), Image.SCALE_DEFAULT));
            jLabel20.setIcon(icono);
            entrefoto=archivoEntrada.getPath();
        }catch(Exception io){
            
        }
        
    }//GEN-LAST:event_jButton1MouseClicked
    
    public String getEntrefoto() {
        return entrefoto;
    }
    
    public void setEntrefoto(String entrefoto) {
        this.entrefoto = entrefoto;
    }
    
    public float getSueldot() {
        return sueldot;
    }
    
    public void setSueldot(float sueldot) {
        this.sueldot = sueldot;
    }
    
    public float getSueldo() {
        return sueldo;
    }
    
    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }
    
    public float getIess() {
        return iess;
    }
    
    public void setIess(float iess) {
        this.iess = iess;
    }
    
    public float getSuple() {
        return suple;
    }
    
    public void setSuple(float suple) {
        this.suple = suple;
    }
    
    public JLabel getjLabel23() {
        return jLabel23;
    }
    
    public void setjLabel23(JLabel jLabel23) {
        this.jLabel23 = jLabel23;
    }
    
    public JLabel getjLabel24() {
        return jLabel24;
    }
    
    public void setjLabel24(JLabel jLabel24) {
        this.jLabel24 = jLabel24;
    }
    
    public JLabel getjLabel25() {
        return jLabel25;
    }
    
    public void setjLabel25(JLabel jLabel25) {
        this.jLabel25 = jLabel25;
    }
    
    public JLabel getjLabel26() {
        return jLabel26;
    }
    
    public void setjLabel26(JLabel jLabel26) {
        this.jLabel26 = jLabel26;
    }
    
    public JPanel getjPanel1() {
        return jPanel1;
    }
    
    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }
    
    public JPanel getjPanel2() {
        return jPanel2;
    }
    
    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }
    
    public JTextField getjTextField10() {
        return jTextField10;
    }
    
    public void setjTextField10(JTextField jTextField10) {
        this.jTextField10 = jTextField10;
    }
    
    public JTextField getjTextField7() {
        return jTextField7;
    }
    
    public void setjTextField7(JTextField jTextField7) {
        this.jTextField7 = jTextField7;
    }
    
    public JTextField getjTextField8() {
        return jTextField8;
    }
    
    public void setjTextField8(JTextField jTextField8) {
        this.jTextField8 = jTextField8;
    }
    
    public JTextField getjTextField9() {
        return jTextField9;
    }
    
    public void setjTextField9(JTextField jTextField9) {
        this.jTextField9 = jTextField9;
    }
    
    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        char caracter = evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)
                && (caracter !='.')){
            /* lo que deseo colocar aqui es si ya se pulso el caracter (.) el mismo no se pueda repetir*/
            evt.consume();
            
        }
    }//GEN-LAST:event_jTextField7KeyTyped
    
    private void jTextField8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyTyped
        char caracter = evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)
                && (caracter !='.')){
            /* lo que deseo colocar aqui es si ya se pulso el caracter (.) el mismo no se pueda repetir*/
            evt.consume();
        }
    }//GEN-LAST:event_jTextField8KeyTyped
    
    private void jTextField9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyTyped
        char caracter = evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)
                && (caracter !='.')){
            /* lo que deseo colocar aqui es si ya se pulso el caracter (.) el mismo no se pueda repetir*/
            evt.consume();
        }
    }//GEN-LAST:event_jTextField9KeyTyped
    
    private void jTextField10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyTyped
        char caracter = evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)
                && (caracter !='.')){
            /* lo que deseo colocar aqui es si ya se pulso el caracter (.) el mismo no se pueda repetir*/
            evt.consume();
        }
    }//GEN-LAST:event_jTextField10KeyTyped
    
    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        sueldot= Float.parseFloat(jTextField7.getText());
        sueldo= (float)(sueldot-(sueldot*0.20));
        iess= (float)(sueldo*0.0945);
        suple= (float)(sueldot*0.20);
        jTextField8.setText(Float.toString(sueldo));
        jTextField9.setText(Float.toString(iess));
        
        if(departamento_nombre.equalsIgnoreCase("Seguridad Fisica")){
            jTextField22.setText(Float.toString(suple));
            jTextField10.setText(Float.toString(0));
        }else{
            jTextField10.setText(Float.toString(suple));
            jTextField22.setText(Float.toString(0));
        }
        
    }//GEN-LAST:event_jTextField7KeyReleased
    
    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
        sueldot= Float.parseFloat(jTextField7.getText());
        sueldo= Float.parseFloat(jTextField8.getText());
        float extras= Float.parseFloat(jTextField22.getText());
        iess= (float)((sueldo+extras)*0.0945);
        suple= (float)(sueldot-sueldo);
        jTextField9.setText(Float.toString(iess));
        if(departamento_nombre.equalsIgnoreCase("Seguridad Fisica")){
            jTextField22.setText(Float.toString(suple));
            jTextField10.setText(Float.toString(0));
        }else{
            jTextField10.setText(Float.toString(suple));
            jTextField22.setText(Float.toString(0));
        }
    }//GEN-LAST:event_jTextField8KeyReleased
    public void limpiar(){
        jTextField1.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField4.setText(null);
        jTextField5.setText(null);
        jTextField6.setText(null);
        jTextField7.setText(null);
        jTextField8.setText(null);
        jTextField9.setText(null);
        jTextField10.setText(null);
        jTextField11.setText(null);
        jTextField12.setText(null);
        jTextField13.setText(null);
        jTextField14.setText(null);
        jTextField15.setText(null);
        jTextField16.setText(null);
        jTextField17.setText(null);
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        jDateChooser3.setDate(null);
        entrefoto=null;
        jTextField25.setText(null);
        jTextField18.setText(null);
        jTextField19.setText(null);
        jTextField20.setText(null);
        jTextField21.setText(null);
        
        jLabel20.setIcon(null);
    }
    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        if(turno==1){
            ServiceHb helper=null;
            
            try{
                helper = new ServiceHb();
                helper.iniciarTransaccion();
                /*** CI  ***/
                Empleado em = (Empleado)helper.obtenerObjeto(Empleado.class,tempo.getCi());
                /***  N° Cuenta Bancaria ***/
                em.setCuentanum(jTextField25.getText());
                
                em.setCid(jTextField2.getText());
                /***  CI Dueño de Cuenta ***/
                em.setCuentaci(jTextField18.getText());
                /***  Nombre Dueño de Cuenta ***/
                em.setCuentadue(jTextField19.getText());
                /***  Tipo de Cuenta ***/
                em.setCuentatipo(jTextField20.getText());
                /***  Banco ***/
                em.setBanco(jTextField21.getText());
                /***  Perfil Puesto ***/
                em.setPerfilpuesto(jComboBox7.getSelectedItem().toString());
                /***  Estado Cajamarca ***/
                em.setEstado(jComboBox6.getSelectedItem().toString());
                /***  1 Nombre ***/
                em.setNombre1(jTextField3.getText());
                /***  2 Nombre ***/
                em.setNombre2(jTextField4.getText());
                /***  1 Apellido ***/
                em.setApellido1(jTextField5.getText());
                /***  2 Apellido ***/
                em.setApellido2(jTextField6.getText());
                /***  genero ***/
                em.setFondos(jComboBox4.getSelectedItem().toString());
                if(jComboBox2.getSelectedItem().toString().equalsIgnoreCase("Masculino")){
                    em.setGenero('M');
                }else{
                    em.setGenero('F');
                }
                /***  fecha nacimiento ***/
                em.setFechaNacimiento(jDateChooser2.getDate());
                /***  estado civil  ***/
                if(jComboBox3.getSelectedItem().toString().equalsIgnoreCase("Casado (A)")){em.setEstadoCivil('C');}
                if(jComboBox3.getSelectedItem().toString().equalsIgnoreCase("Divorciado (A)")){em.setEstadoCivil('D');}
                if(jComboBox3.getSelectedItem().toString().equalsIgnoreCase("Soltero (A)")){em.setEstadoCivil('S');}
                if(jComboBox3.getSelectedItem().toString().equalsIgnoreCase("Viudo (A)")){em.setEstadoCivil('V');}
                if(jComboBox3.getSelectedItem().toString().equalsIgnoreCase("Union Libre")){em.setEstadoCivil('U');}
                /***  email ***/
                em.setCorreo(jTextField12.getText());
                /***  direccion ***/
                em.setDireccion(jTextField14.getText());
                /***  celular ***/
                em.setCelular(jTextField16.getText());
                /***  direccion ***/
                em.setDireccion(jTextField14.getText());
                /***  descripcion ***/
                em.setCiudad(jTextField1.getText());
                /***  fecha ingreso ***/
                em.setFechaIngreso(jDateChooser3.getDate());
                /***  nacionalidad ***/
                em.setPais(jTextField11.getText());
                /***  ciudad residencia ***/
                em.setCuidadResidencia(jTextField13.getText());
                /***  telefono ***/
                em.setTelefono(jTextField15.getText());
                
                /***  fecha salida ***/
                em.setSalidaemp(Funcion.DateFormat(jDateChooser1.getDate()));
                
                /***  Sueldo Total ***/
                em.setCumple2(jTextField7.getText());
                /***  Sueldo ***/
                em.setDato1(jTextField8.getText());
                /***  IESS ***/
                em.setDato2(jTextField9.getText());
                /***  Suplementario ***/
                em.setDato3(jTextField10.getText());
                /***  Horas Extras ***/
                em.setDato4(jTextField22.getText());
                /***  Decimo Tercer  ***/
                em.setDecimotercero(jComboBox8.getSelectedItem().toString());
                /***  Decimo Cuarto  ***/
                em.setDecimocuarto(jComboBox9.getSelectedItem().toString());
                /***  Alimentacion  ***/
                em.setAlimentacion(jComboBox10.getSelectedItem().toString());
                /***  Actividadees  ***/
                em.setActividades(jComboBox5.getSelectedItem().toString());
                /***  Foto  ***/
                if(entrefoto!=null){
                    File archivoEntrada = new File(entrefoto);
                    //Mostrar el nombre del archvivo en un campo de texto
                    if(archivoEntrada.exists()){
                        File archivoSalida = new File(direccion + directoriofoto+Integer.toString(Integer.parseInt(jTextField2.getText()))+".jpeg");
                        FileChannel source = null;
                        
                        FileChannel destination = null;
                        
                        try {
                            if(!archivoSalida.exists()) {
                                archivoSalida.createNewFile();
                            }
                            
                            source = new FileInputStream(archivoEntrada).getChannel();
                            
                            destination = new FileOutputStream(archivoSalida).getChannel();
                            
                            destination.transferFrom(source, 0, source.size());
                            
                        } catch(Exception io){
                            
                        }
                        finally {
                            if(source != null) {
                                try {
                                    source.close();
                                } catch (IOException ex) {
                                    Logger.getLogger(editar_empleado1.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                            }
                            
                            if(destination != null) {
                                try {
                                    destination.close();
                                } catch (IOException ex) {
                                    Logger.getLogger(editar_empleado1.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                            }
                        }
                        em.setFoto(directoriofoto+Integer.toString(Integer.parseInt(jTextField2.getText()))+".jpeg");
                    }
                    
                }
                /***  CV  ***/
                if(jTextField17.getText()!=null){
                    File archivoEntrada = new File(jTextField17.getText());
                    //Mostrar el nombre del archvivo en un campo de texto
                    if(archivoEntrada.exists()){
                        File archivoSalida = new File(direccion + directoriocv+Integer.toString(Integer.parseInt(jTextField2.getText()))+".pdf");
                        FileChannel source = null;
                        
                        FileChannel destination = null;
                        
                        try {
                            if(!archivoSalida.exists()) {
                                archivoSalida.createNewFile();
                            }
                            
                            source = new FileInputStream(archivoEntrada).getChannel();
                            
                            destination = new FileOutputStream(archivoSalida).getChannel();
                            
                            destination.transferFrom(source, 0, source.size());
                            
                        } catch(Exception io){
                            
                        }
                        finally {
                            if(source != null) {
                                try {
                                    source.close();
                                } catch (IOException ex) {
                                    Logger.getLogger(editar_empleado1.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                            }
                            
                            if(destination != null) {
                                try {
                                    destination.close();
                                } catch (IOException ex) {
                                    Logger.getLogger(editar_empleado1.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                            }
                        }
                        em.setCv(directoriocv+Integer.toString(Integer.parseInt(jTextField2.getText()))+".pdf");
                    }
                }
                /***  departamento tabla ***/
                
                String nombredepa= em.getDeptEmpl().getDepartamento().getNombre();
                DeptEmpl demp =em.getDeptEmpl();
                if(!nombredepa.equalsIgnoreCase(jComboBox1.getSelectedItem().toString())){
                    em.setDeptEmpl(null);
                }
                helper.actualizarObjeto(em);
                helper.confirmarTransaccion();
                helper.cerrarSesion();
                
                if(!nombredepa.equalsIgnoreCase(jComboBox1.getSelectedItem().toString())){
                    helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    Departamento d1 = helper.getDepartamento(jComboBox1.getSelectedItem().toString());
                    /***  departamento celda ***/
                    em.setDepartamento(d1.getNombre());
                    
                    DeptEmpl dp = new DeptEmpl();
                    dp.setDepartamento(d1);
                    dp.setEmpleado(em);
                    helper.eliminarObjeto(demp);
                    helper.crearObjeto(dp);
                    helper.confirmarTransaccion();
                    helper.cerrarSesion();
                    em.setDeptEmpl(dp);
                }
                helper= new ServiceHb();
                helper.iniciarTransaccion();
                helper.actualizarObjeto(em);
                helper.confirmarTransaccion();
                helper.cerrarSesion();
                JOptionPane.showMessageDialog(null,"Cedula: "+em.getCid()+" Modificado");
            }
            
            catch(Exception io){
                helper.cerrarSesion();
            }
        }
        if(turno==2){
            try{
                CvEstudio estudio = new CvEstudio();
                estudio.setInstitucion(edi2.getjTextField3().getText());
                estudio.setNivel(edi2.getjComboBox2().getSelectedItem().toString());
                estudio.setArea(edi2.getjTextField5().getText());
                estudio.setFechaInicio(edi2.getjDateChooser2().getDate());
                estudio.setFechaFinal(edi2.getjDateChooser1().getDate());
                estudio.setCedula(jTextField2.getText());
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                helper.crearObjeto(estudio);
                helper.confirmarTransaccion();
                helper.cerrarSesion();
                
                edi2.getjTextField3().setText(null);
                edi2.getjTextField5().setText(null);
                edi2.getjDateChooser1().setDate(null);
                edi2.getjDateChooser2().setDate(null);
                tablasedi();
                JOptionPane.showMessageDialog(null,"Cedula: "+tempo.getCid()+" Modificado");
            }catch(Exception io){
                
            }
        }
        if(turno==3){
            try{
                CvIdioma idioma = new CvIdioma();
                idioma.setIdioma(edi3.getjComboBox3().getSelectedItem().toString());
                idioma.setOral(edi3.getjComboBox5().getSelectedItem().toString());
                idioma.setEscrito(edi3.getjComboBox4().getSelectedItem().toString());
                idioma.setCedula(jTextField2.getText());
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                helper.crearObjeto(idioma);
                helper.confirmarTransaccion();
                helper.cerrarSesion();
                
                JOptionPane.showMessageDialog(null,"Cedula: "+tempo.getCid()+" Modificado");
            }catch(Exception io){
                
            }
        }
        if(turno==4){
            try{
                CvLaboral laboral = new CvLaboral();
                laboral.setInstitucion(edi4.getjTextField3().getText());
                laboral.setPuesto(edi4.getjTextField6().getText());
                laboral.setFechaInicio(edi4.getjDateChooser2().getDate());
                laboral.setFechaFinal(edi4.getjDateChooser1().getDate());
                laboral.setJefe(edi4.getjTextField9().getText());
                laboral.setCargo(edi4.getjTextField8().getText());
                laboral.setTelefono(edi4.getjTextField7().getText());
                laboral.setFunciones(edi4.getjTextArea1().getText());
                laboral.setCedula(jTextField2.getText());
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                helper.crearObjeto(laboral);
                helper.confirmarTransaccion();
                helper.cerrarSesion();
                
                edi4.getjTextField3().setText(null);
                edi4.getjTextField6().setText(null);
                edi4.getjDateChooser2().setDate(null);
                edi4.getjDateChooser1().setDate(null);
                edi4.getjTextField9().setText(null);
                edi4.getjTextField8().setText(null);
                edi4.getjTextField7().setText(null);
                edi4.getjTextArea1().setText(null);
                
                tablasedi();
                JOptionPane.showMessageDialog(null,"Cedula: "+tempo.getCid()+" Modificado");
            }catch(Exception io){
                
            }
        }
        if(turno==5){
            try{
                CvReferencia referencia = new CvReferencia();
                referencia.setNombres(edi5.getjTextField3().getText());
                referencia.setApellidos(edi5.getjTextField6().getText());
                referencia.setTelefono(edi5.getjTextField4().getText());
                referencia.setCelular(edi5.getjTextField5().getText());
                referencia.setRelacion(edi5.getjTextField7().getText());
                referencia.setCedula(jTextField2.getText());
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                helper.crearObjeto(referencia);
                helper.confirmarTransaccion();
                helper.cerrarSesion();
                
                edi5.getjTextField3().setText(null);
                edi5.getjTextField6().setText(null);
                edi5.getjTextField4().setText(null);
                edi5.getjTextField5().setText(null);
                edi5.getjTextField7().setText(null);
                tablasedi();
                JOptionPane.showMessageDialog(null,"Cedula: "+tempo.getCid()+" Modificado");
            }catch(Exception io){
                
            }
        }
        if(turno==6){
            try{
                CvAdicional adicional = new CvAdicional();
                adicional.setAspiracion(edi6.getjTextField3().getText());
                if(edi6.getjComboBox4().getSelectedItem().toString().equalsIgnoreCase("NO")){
                    adicional.setDiscapacidad(null);
                    adicional.setConadis(null);
                    adicional.setTipo(null);
                    adicional.setPorcentaje(null);
                }else{
                adicional.setDiscapacidad(edi6.getjComboBox4().getSelectedItem().toString());
                adicional.setConadis(edi6.getjTextField4().getText());
                adicional.setTipo(edi6.getjComboBox5().getSelectedItem().toString());
                adicional.setPorcentaje(edi6.getjTextField7().getText());
                }
                
                if(edi6.getjComboBox3().getSelectedItem().toString().equalsIgnoreCase("OTROS")){
                    adicional.setConocimientos(edi6.getjTextField5().getText());
                }else{
                    adicional.setConocimientos(edi6.getjComboBox3().getSelectedItem().toString());
                }
                adicional.setNivel(edi6.getjComboBox6().getSelectedItem().toString());
                adicional.setCedula(jTextField2.getText());
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                helper.crearObjeto(adicional);
                helper.confirmarTransaccion();
                helper.cerrarSesion();
                
                edi6.getjTextField3().setText(null);
                edi6.getjTextField4().setText(null);
                edi6.getjTextField5().setText(null);
                edi6.getjTextField7().setText(null);
                
                tablasedi();
                JOptionPane.showMessageDialog(null,"Cedula: "+tempo.getCid()+" Modificado");
            }catch(Exception io){
                
            }
        }
    }//GEN-LAST:event_jLabel3MouseClicked
    
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        JFileChooser chooser = new JFileChooser();
        
        //Mostrar la ventana para abrir archivo y recoger la respuesta
        //En el parámetro del showOpenDialog se indica la ventana
        //  al que estará asociado. Con el valor this se asocia a la
        //  ventana que la abre.
        int valido=0;
        int respuesta = chooser.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION)
        {
            //Crear un objeto File con el archivo elegido
            File archivoEntrada = chooser.getSelectedFile();
            //Mostrar el nombre del archvivo en un campo de texto
            jTextField17.setText(archivoEntrada.getPath());
        }
    }//GEN-LAST:event_jButton2MouseClicked
    
    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped

    }//GEN-LAST:event_jTextField2KeyTyped
    
    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        
    }//GEN-LAST:event_jTextField2ActionPerformed
    
    private void jTextField25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField25ActionPerformed
    
    private void jTextField25KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField25KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField25KeyTyped
    
    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        if(jPanel1.isVisible()){
            
        }else{
            jPanel1.setVisible(true);
            jPanel3.setVisible(false);
            jPanel1.setLocation(xi, jPanel1.getY());
            jPanel2.setLocation(xi+wid, jPanel2.getY());
            jPanel3.setLocation(xi+wid, jPanel3.getY());
        }
        
    }//GEN-LAST:event_jButton5MouseClicked
    
    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        if(jPanel1.isVisible()){
            jPanel1.setVisible(false);
            jPanel3.setVisible(true);
            jPanel1.setLocation(jPanel1.getX(), jPanel1.getY());
            jPanel2.setLocation(xi, jPanel2.getY());
            jPanel3.setLocation(xi+wid, jPanel3.getY());
        }else{
            
        }
    }//GEN-LAST:event_jButton4MouseClicked
    
    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseEntered
    
    private void jLabel34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseClicked
        turno=1;
        cambio(jPanel5);
        jLabel2.setText("Informacion Basica");
        jPanel4.setVisible(true);
    }//GEN-LAST:event_jLabel34MouseClicked
    
    private void jLabel35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseClicked
        turno=2;
        tablasedi();
        cambio(edi2);
        jLabel2.setText("Formacion Academica");
    }//GEN-LAST:event_jLabel35MouseClicked
    
    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
        turno=3;
        tablasedi();
        cambio(edi3);
        jLabel2.setText("Idioma");
    }//GEN-LAST:event_jLabel37MouseClicked
    
    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked
        turno=4;
        tablasedi();
        cambio(edi4);
        jLabel2.setText("Experiencia Laboral");
    }//GEN-LAST:event_jLabel39MouseClicked
    
    private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked
        turno=5;
        tablasedi();
        cambio(edi5);
        jLabel2.setText("Contacto de Emergencia");
    }//GEN-LAST:event_jLabel40MouseClicked
    
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        turno=6;
        tablasedi();
        cambio(edi6);
        jLabel2.setText("Informacion Adicional");
    }//GEN-LAST:event_jLabel1MouseClicked
    
    private void jLabel34MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseEntered
        alt(jLabel34,"Informacion Basica");
    }//GEN-LAST:event_jLabel34MouseEntered

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel32MouseClicked
    public void alt (Component bt, String text){
        jLabel44.setVisible(true);
        jLabel44.setText(text);
        jLabel44.setSize((int)jLabel44.getMinimumSize().getWidth(), 25);
        jLabel44.setLocation(bt.getX()+bt.getWidth(), bt.getY()-25);
    }
    private void jTextField22KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField22KeyReleased

    }//GEN-LAST:event_jTextField22KeyReleased

    private void jTextField22KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField22KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField22KeyTyped

    private void jTextField10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyReleased

    }//GEN-LAST:event_jTextField10KeyReleased

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jLabel35MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseEntered
        alt(jLabel35,"Formacion Academica");
    }//GEN-LAST:event_jLabel35MouseEntered

    private void jLabel37MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseEntered
        alt(jLabel37,"Idioma");
    }//GEN-LAST:event_jLabel37MouseEntered

    private void jLabel39MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseEntered
        alt(jLabel39,"Experiencia Laboral");
    }//GEN-LAST:event_jLabel39MouseEntered

    private void jLabel40MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseEntered
        alt(jLabel40,"Contacto de Emergencia");
        
    }//GEN-LAST:event_jLabel40MouseEntered

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        alt(jLabel1,"Informacion Adicional");
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        jLabel44.setVisible(false);
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel39MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseExited
        jLabel44.setVisible(false);
    }//GEN-LAST:event_jLabel39MouseExited

    private void jLabel37MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseExited
        jLabel44.setVisible(false);
    }//GEN-LAST:event_jLabel37MouseExited

    private void jLabel35MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseExited
        jLabel44.setVisible(false);
    }//GEN-LAST:event_jLabel35MouseExited

    private void jLabel34MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseExited
        jLabel44.setVisible(false);
    }//GEN-LAST:event_jLabel34MouseExited

    private void jLabel40MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseExited
        jLabel44.setVisible(false);
    }//GEN-LAST:event_jLabel40MouseExited

    private void jTextField9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyReleased
        sueldo= Float.parseFloat(jTextField8.getText());
        float extras= Float.parseFloat(jTextField22.getText());
        iess= (float)((sueldo+extras)*0.0945);
        jTextField9.setText(Float.toString(iess));
        
    }//GEN-LAST:event_jTextField9KeyReleased

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jComboBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox8ActionPerformed

    private void jComboBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox9ActionPerformed

    private void jComboBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox10ActionPerformed
    
    public void tablasedi(){
        List<CvEstudio> list2=null;
        List<CvIdioma> list3=null;
        List<CvLaboral> list4=null;
        List<CvReferencia> list5=null;
        List<CvAdicional> list6=null;
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            if(turno==2){
                list2= helper.getCvEstudioByTipo(jTextField2.getText());
                DefaultTableModel temp4 = (DefaultTableModel) edi2.getjTable1().getModel();
                for(int i=temp4.getRowCount()-1;i>=0;i--){
                   temp4.removeRow(i);
                }
                if(list2!=null){
                    for(CvEstudio i: list2){
                         String c1 = i.getNivel();
                         String c2 = i.getArea();
                         DefaultTableModel temp = (DefaultTableModel) edi2.getjTable1().getModel();
                         Object nuevo[]= {c1,i.getInstitucion(),c2,i.getFechaInicio(),i.getFechaFinal(),i};
                         temp.addRow(nuevo);
                     }
                }
            }
            if(turno==3){
                list3= helper.getCvIdiomaByTipo(jTextField2.getText());
                DefaultTableModel temp4 = (DefaultTableModel) edi3.getjTable1().getModel();
                for(int i=temp4.getRowCount()-1;i>=0;i--){
                   temp4.removeRow(i);
                }
                if(list3!=null){
                    for(CvIdioma i: list3){
                        DefaultTableModel temp = (DefaultTableModel) edi3.getjTable1().getModel();
                        Object nuevo[]= {i.getIdioma(),i.getOral(),i.getEscrito(),i};
                        temp.addRow(nuevo);
                     }
                }
            }
            if(turno==4){
                list4= helper.getCvLaboralByTipo(jTextField2.getText());
                DefaultTableModel temp4 = (DefaultTableModel) edi4.getjTable1().getModel();
                for(int i=temp4.getRowCount()-1;i>=0;i--){
                   temp4.removeRow(i);
                }

                if(list4!=null){
                    for(CvLaboral i: list4){
                        DefaultTableModel temp = (DefaultTableModel) edi4.getjTable1().getModel();
                        Object nuevo[]= {i.getInstitucion(),i.getPuesto(),i.getFunciones(),i.getJefe(),i.getCargo(),i.getTelefono(),i.getFechaInicio(),i.getFechaFinal(),i};
                        temp.addRow(nuevo);
                     }
                }
            }
            if(turno==5){
                list5= helper.getCvReferenciaByTipo(jTextField2.getText());
                DefaultTableModel temp4 = (DefaultTableModel) edi5.getjTable1().getModel();
                for(int i=temp4.getRowCount()-1;i>=0;i--){
                   temp4.removeRow(i);
                }

                if(list5!=null){
                    for(CvReferencia i: list5){
                        DefaultTableModel temp = (DefaultTableModel) edi5.getjTable1().getModel();
                        Object nuevo[]= {i.getNombres(),i.getApellidos(),i.getTelefono(),i.getCelular(),i.getRelacion(),i};
                        temp.addRow(nuevo);
                     }
                }
            }
            if(turno==6){
                list6 = helper.getCvAdicionalByTipo(jTextField2.getText());
                DefaultTableModel temp4 = (DefaultTableModel) edi6.getjTable1().getModel();
                for(int i=temp4.getRowCount()-1;i>=0;i--){
                   temp4.removeRow(i);
                }

                if(list6!=null){
                    for(CvAdicional i: list6){ 
                        DefaultTableModel temp = (DefaultTableModel) edi6.getjTable1().getModel();
                        Object nuevo[]= {i.getAspiracion(),i.getDiscapacidad(),i.getConadis(),i.getTipo(),i.getPorcentaje(),i.getConocimientos(),i.getNivel(),i};
                        temp.addRow(nuevo);
                     }
                }
            }
            helper.cerrarSesion();
        }catch(Exception io){
            
        }
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getFotot() {
        return fotot;
    }
    
    public void setFotot(String fotot) {
        this.fotot = fotot;
    }
    
    public JButton getjButton1() {
        return jButton1;
    }
    
    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }
    
    public JLabel getjLabel3() {
        return jLabel3;
    }
    
    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox10;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JComboBox jComboBox8;
    private javax.swing.JComboBox jComboBox9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables

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
    setText((value == null) ? "" : "");
    this.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(255, 255, 255)));
    return this;
  }
}