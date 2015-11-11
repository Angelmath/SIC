/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.ventas;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Matheus
 */
public class interfasecont extends javax.swing.JFrame {
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    /**
     * Creates new form permisos
     */
    public interfasecont(final Login.Entidad.Login log) {
        initComponents();
        dispose();
        final String cedula= log.getCi();
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(d.width, d.height-1);
        URL url = getClass().getResource("/Login/imagenes/venta_icono.png");
        ImageIcon img = new ImageIcon(url);
        setIconImage(img.getImage());
        JLabel fondo = new JLabel();
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/fondo SIC.jpg")));
        fondo.setSize(d.width, d.height-1);
        fondo.setIcon(new ImageIcon(((ImageIcon) fondo.getIcon()).getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT)));
        int tam= 2;
        JPanel base = new JPanel();
        base.setBackground(new Color(0,0,0,0));
        if(tam<3){
            base.setLayout(null);
            base.setSize(120*tam,120*((tam/3)+1));
        }else{
            base.setLayout(null);
            base.setSize(120*3,120*((tam/3)+1));
        }
        int contX=0;
        int contY=0;
            final JLabel cuadro = new JLabel();
            cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/contable.png"))); // NOI18N
            cuadro.setBackground(new Color(0,0,0,0));
            cuadro.setBounds(120*contX,120*contY,120, 120);
            cuadro.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/contable-blue.png"))); // NOI18N
                    cuadro.setBackground(new Color(0,0,0,0));
                }
                @Override
                public void mouseClicked(MouseEvent e) {
                        marco m = new marco(log);
                        m.setVisible(true);
                        dispose();
                }                
                @Override
                public void mouseExited(MouseEvent e) {
                    cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/contable.png"))); // NOI18N
                    cuadro.setBackground(new Color(0,0,0,0));
                }
            });
            //cuadro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            contX++;
            if(contX==3){
                contY++;
                contX=0;
            }
            base.add(cuadro);
            
            final JLabel cuadro2 = new JLabel();
            cuadro2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-finanzas.png"))); // NOI18N
            cuadro2.setBackground(new Color(0,0,0,0));
            cuadro2.setBounds(120*contX,120*contY,120, 120);
            cuadro2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    cuadro2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-finanzas-blue.png"))); // NOI18N
                    cuadro2.setBackground(new Color(0,0,0,0));
                }
                @Override
                public void mouseClicked(MouseEvent e) {
                        interfasefinan m = new interfasefinan(log);
                        m.setVisible(true);
                        dispose();
                }                
                @Override
                public void mouseExited(MouseEvent e) {
                    cuadro2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-finanzas.png"))); // NOI18N
                    cuadro2.setBackground(new Color(0,0,0,0));
                }
            });
            base.add(cuadro2);
        
        base.setLocation((d.width/2)-(base.getWidth()/2), (d.height/2)-(base.getHeight()/2)+140);
        JLabel ico = new JLabel();
        ico.setSize(391,119);
        ico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/logo-cajamarca.png")));
        ico.setLocation((d.width/2)-(ico.getWidth()/2), (d.height/2)-(ico.getHeight()/2)-200);
        
        final JLabel salir = new JLabel();
        salir.setSize(50,50);
        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-cerrar.png")));
        salir.setLocation((d.width)-salir.getWidth()-10,10);
        salir.setBackground(Color.red);
        salir.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new permisos(log);
                    dispose();
                }
            });
        
        this.add(salir);
        this.add(ico);
        this.add(base);
        this.add(fondo);
        setVisible(true);
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
            java.util.logging.Logger.getLogger(interfasecont.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfasecont.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfasecont.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfasecont.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfasecont(null).setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
