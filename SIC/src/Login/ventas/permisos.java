/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.ventas;


import Login.Entidad.Noticalen;
import Login.Entidad.Permisos;
import Login.servicio.ServiceHb;
import com.itextpdf.text.DocumentException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import rrhh.sic_rrhh.Cuerpo;

/**
 *
 * @author Matheus
 */
public class permisos extends javax.swing.JFrame {
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    String log="";
    /**
     * Creates new form permisos
     * @param log
     */
    public permisos(Login.Entidad.Login log) {
        initComponents();
        dispose();
        this.log=log.getNombre();
        List<Noticalen> noti=null;
        final String cedula= log.getCi();
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(d.width, d.height-1);
        URL url = getClass().getResource("/Login/imagenes/venta_icono.png");
        ImageIcon img = new ImageIcon(url);
        setIconImage(img.getImage());
        final JLabel fondo = new JLabel();
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/fondo SIC.jpg")));
        fondo.setSize(d.width, d.height-1);
        fondo.setIcon(new ImageIcon(((ImageIcon) fondo.getIcon()).getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT)));
        List<Permisos> permiso= null;
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            permiso = helper.getlistaPermisos(log);
            noti= helper.getlistaNotiCalen(log.getNombre());
            helper.cerrarSesion();
        }catch(Exception io){
            System.out.println(io);
        }
        int tam= permiso.size();
        JPanel base = new JPanel();
        base.setBackground(new Color(0,0,0,0));
        if(tam<4){
            base.setLayout(null);
            base.setSize(120*tam,120*((tam/4)+1));
        }else{
            base.setLayout(null);
            base.setSize(120*4,120*((tam/4)+1));
        }
        int contX=0;
        int contY=0;
        for(Permisos i: permiso){
            final JLabel cuadro = new JLabel();
            cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/"+i.getAcceso()+".png"))); // NOI18N
            cuadro.setBounds(120*contX,120*contY,120, 120);
            final String nombre= i.getAcceso();
            cuadro.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/"+nombre+"-blue.png"))); // NOI18N
                    fondo.repaint();
                }
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(nombre.equalsIgnoreCase("bitacora")){
                        try {
                            sgi.acceso.paneles cuadro = new sgi.acceso.paneles(null, null, null, null, null, null);
                            dispose();
                            
                        } catch (FontFormatException | DocumentException ex) {
                            Logger.getLogger(permisos.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else if(nombre.equalsIgnoreCase("administrador")){
                        try{
                            log.setNivel("Administrador");
                            marco m = new marco(log);
                            m.setVisible(true);
                            dispose();
                        }catch(Exception io){
                            System.out.println(io);
                        }
                    }else if(nombre.equalsIgnoreCase("rrhh")){
                        try {
                            Cuerpo cuerpo = new Cuerpo(log);
                        } catch (DocumentException ex) {
                            Logger.getLogger(permisos.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        dispose();
                    }else if(nombre.equalsIgnoreCase("owncloud")){
                        folderowncloud cuerpo = new folderowncloud(log);
                        dispose();
                    }else if(nombre.equalsIgnoreCase("ventas")){
                        log.setNivel("Ventas");
                        marco m = new marco(log);
                        m.setVisible(true);
                        dispose();
                    }else if(nombre.equalsIgnoreCase("pyl")){
                        log.setNivel("PYL");
                        marco m = new marco(log);
                        m.setVisible(true);
                        dispose();
                    }else if(nombre.equalsIgnoreCase("contable")){
                        if(log.getNivel().equalsIgnoreCase("Asistente")){}
                        else{log.setNivel("Contable");}
                        interfasecont m = new interfasecont(log);
                        m.setVisible(true);
                        dispose();
                    }else if(nombre.equalsIgnoreCase("monitoreo")){
                        //log.setNivel("Monitoreo");
                        config m = new config(log);
                        m.setVisible(true);
                        dispose();
                    }else if(nombre.equalsIgnoreCase("notificaciones")){
                        //log.setNivel("Monitoreo");
                        noti m = new noti(log);
                        m.setVisible(true);
                        dispose();
                    }else if(nombre.equalsIgnoreCase("config")){
                        //log.setNivel("Monitoreo");
                        calendario m = new calendario(log);
                        m.setVisible(true);
                        dispose();
                    }else if(nombre.equalsIgnoreCase("bodega")){
                        //log.setNivel("Monitoreo");
                        bodega m = new bodega(log);
                        m.setVisible(true);
                        dispose();
                    }else{
                        enconstruccion();
                    }
                }                
                @Override
                public void mouseExited(MouseEvent e) {
                    cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/"+nombre+".png"))); // NOI18N
                    fondo.repaint();
                }
            });
            contX++;
            if(contX==4){
                contY++;
                contX=0;
            }
            base.add(cuadro);
        }
        base.setLocation((d.width/2)-(base.getWidth()/2), (d.height/2)-(base.getHeight()/2)+140);
        JLabel ico = new JLabel();
        ico.setSize(391,119);
        ico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/logo-cajamarca.png")));
        ico.setLocation((d.width/2)-(ico.getWidth()/2), (d.height/2)-(ico.getHeight()/2)-200);
        
        final JLabel salir = new JLabel();
        salir.setSize(50,50);
        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-cerrar.png")));
        salir.setLocation((d.width)-salir.getWidth()-10,10);
        salir.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    login login = new login();
                    dispose();
                }
            });
        
        this.add(salir);
        this.add(ico);
        this.add(base);
        this.add(fondo);
        setVisible(true);
        if(noti!=null){
            if(log.getNivel().contains("administrador")){
            } else {
                generarNotificaciones(noti);
            }
        }
    }
    
    public void generarNotificaciones(List<Noticalen> noti){
        notificaciones_calendario nt = new notificaciones_calendario(null,true,noti);
    }
    
    public void enconstruccion(){
        int ancho = 400;
        int alto = 400;
        JDiFondo jdiFondo = new JDiFondo(this, true);
        jdiFondo.setSize(ancho, alto);
        jdiFondo.setPreferredSize(new Dimension(ancho, alto));
        jdiFondo.configurar();
        jdiFondo.setVisible(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(permisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(permisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(permisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(permisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new permisos(null).setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
