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
public class interfasefinan extends javax.swing.JFrame {
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    /**
     * Creates new form permisos
     * @param log
     */
    public interfasefinan(final Login.Entidad.Login log) {
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
        int tam= 9;
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
        
        for(int i=0;i<9;i++){
            final JLabel cuadro = new JLabel();
            if(i==0){
                cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-balancefinanciero.png"))); // NOI18N
                cuadro.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-balancefinanciero-blue.png"))); // NOI18N
                    cuadro.setBackground(new Color(0,0,0,0));
                }
                @Override
                public void mouseClicked(MouseEvent e) {
                    log.setNivel("Contable");
                    financiero m = new financiero(log,0);
                    m.setVisible(true);
                    dispose();
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-balancefinanciero.png"))); // NOI18N
                    cuadro.setBackground(new Color(0,0,0,0));
                }
            });
            }
            if(i==1){
                cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-ctasxcobrar.png"))); // NOI18N
                cuadro.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-ctasxcobrar-blue.png"))); // NOI18N
                    cuadro.setBackground(new Color(0,0,0,0));
                }
                @Override
                public void mouseClicked(MouseEvent e) {
                    log.setNivel("Contable");
                    financiero m = new financiero(log,1);
                    m.setVisible(true);
                    dispose();
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-ctasxcobrar.png"))); // NOI18N
                    cuadro.setBackground(new Color(0,0,0,0));
                }
            });
            }
            if(i==2){
                cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-ctasxpagar.png"))); // NOI18N
                cuadro.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-ctasxpagar-blue.png"))); // NOI18N
                    cuadro.setBackground(new Color(0,0,0,0));
                }
                @Override
                public void mouseClicked(MouseEvent e) {
                    log.setNivel("Contable");
                    financiero m = new financiero(log,2);
                    m.setVisible(true);
                    dispose();
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-ctasxpagar.png"))); // NOI18N
                    cuadro.setBackground(new Color(0,0,0,0));
                }
            });
            }
            if(i==3){
                cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-presupuesto.png"))); // NOI18N
                cuadro.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-presupuesto-blue.png"))); // NOI18N
                    cuadro.setBackground(new Color(0,0,0,0));
                }
                @Override
                public void mouseClicked(MouseEvent e) {
                    log.setNivel("Contable");
                    financiero m = new financiero(log,3);
                    m.setVisible(true);
                    dispose();
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-presupuesto.png"))); // NOI18N
                    cuadro.setBackground(new Color(0,0,0,0));
                }
            });
            }
            if(i==4){
                cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-cajachica.png"))); // NOI18N
                cuadro.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-cajachica-blue.png"))); // NOI18N
                    cuadro.setBackground(new Color(0,0,0,0));
                }
                @Override
                public void mouseClicked(MouseEvent e) {
                    log.setNivel("Contable");
                    financiero m = new financiero(log,4);
                    m.setVisible(true);
                    dispose();
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-cajachica.png"))); // NOI18N
                    cuadro.setBackground(new Color(0,0,0,0));
                }
            });
            }
            if(i==5){
                cuadro.setText("Indice");
                cuadro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                cuadro.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    //cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/contable-blue.png"))); // NOI18N
                    cuadro.setBackground(new Color(0,0,0,0));
                }
                @Override
                public void mouseClicked(MouseEvent e) {
                    log.setNivel("Contable");
                    financiero m = new financiero(log,5);
                    m.setVisible(true);
                    dispose();
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    //cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/contable.png"))); // NOI18N
                    cuadro.setBackground(new Color(0,0,0,0));
                }
            });
            }
            if(i==6){
                cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-analisis-financiero.png"))); // NOI18N
                cuadro.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-analisis-financiero-blue.png"))); // NOI18N
                    cuadro.setBackground(new Color(0,0,0,0));
                }
                @Override
                public void mouseClicked(MouseEvent e) {
                    log.setNivel("Contable");
                    financiero m = new financiero(log,6);
                    m.setVisible(true);
                    dispose();
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-analisis-financiero.png"))); // NOI18N
                    cuadro.setBackground(new Color(0,0,0,0));
                }
            });
            }
            if(i==7){
                cuadro.setText("Analisis Mensual");
                cuadro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                cuadro.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    //cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/contable-blue.png"))); // NOI18N
                    cuadro.setBackground(new Color(0,0,0,0));
                }
                @Override
                public void mouseClicked(MouseEvent e) {
                    log.setNivel("Contable");
                    financiero m = new financiero(log,7);
                    m.setVisible(true);
                    dispose();
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    //cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/contable.png"))); // NOI18N
                    cuadro.setBackground(new Color(0,0,0,0));
                }
            });
            }
            if(i==8){
                cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-gastos-adicionales.png"))); // NOI18N
                cuadro.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-gastos-adicionales-blue.png"))); // NOI18N
                    cuadro.setBackground(new Color(0,0,0,0));
                }
                @Override
                public void mouseClicked(MouseEvent e) {
                    log.setNivel("Contable");
                    financiero m = new financiero(log,8);
                    m.setVisible(true);
                    dispose();
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    cuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-gastos-adicionales.png"))); // NOI18N
                    cuadro.setBackground(new Color(0,0,0,0));
                }
            });
            }
            
            cuadro.setBackground(new Color(0,0,0,0));
            cuadro.setBounds(120*contX,120*contY,120, 120);
            
            //cuadro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            contX++;
            if(contX==3){
                contY++;
                contX=0;
            }
            base.add(cuadro);
        }
        
        base.setLocation((d.width/2)-(base.getWidth()/2), (d.height/2)-(base.getHeight()/2)+120);
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
                interfasecont m = new interfasecont(log);
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
            java.util.logging.Logger.getLogger(interfasefinan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfasefinan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfasefinan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfasefinan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfasefinan(null).setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
