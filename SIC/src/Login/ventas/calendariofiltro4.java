/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.ventas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author Matheus
 */
public class calendariofiltro4 extends javax.swing.JPanel {
    ArrayList<Component> list = new ArrayList<>();
    ButtonGroup bg1 = null;
    int numero=0;
    String campo="";
    /**
     * Creates new form calendariofiltro1
     * @param mes
     * @param filtro
     */
    public calendariofiltro4(int mes,calendariofiltro3 filtro) {
        initComponents();
        setLayout(null);
        String[] fecha= {"Todos","Vacio"};
        int posx=0;
        int posy=0;
        final ImageIcon icon2= new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-menu-grey-2.png"));
        final JLabel lm = new JLabel(){
        @Override
        public void paintComponent(Graphics g) {
          g.drawImage(icon2.getImage(), 0, 0, null);
          super.paintComponent(g);
        }
      };
        lm.setFont(new java.awt.Font("Roboto", 1, 11));
        lm.setText("  "+fecha[0]);
        numero=mes;
        campo=fecha[0];
        lm.setVerticalTextPosition(JLabel.CENTER);
        lm.setForeground(new java.awt.Color(0, 173, 238));
        lm.setVisible(true);
        lm.setOpaque(false);
        lm.setBounds(posx, posy, 160, 35);
        add(lm);
        posy= posy+35;
        bg1 = new ButtonGroup();
        for(int i=0; i<fecha.length;i++){
            final int num= i;
            final ImageIcon icon= new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-menu-grey-1.png"));
            final JRadioButton l = new JRadioButton(fecha[i]);
            l.setVerticalTextPosition(JLabel.CENTER);
            l.setFont(new java.awt.Font("Roboto", 0, 9));
            l.setForeground(new java.awt.Color(102, 102, 102));
            l.setBounds(posx, posy, 160, 30);
            if(i==mes){
                l.setSelected(true);
            }
            l.setVisible(false);
            l.setBackground(new Color(247,247,247));
            l.setOpaque(true);
            final calendariofiltro3 filtroa=filtro;
            l.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    l.setForeground(new java.awt.Color(255, 255, 255));
                    l.setBackground(new Color(62,165,231));
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    l.setForeground(new java.awt.Color(102, 102, 102));
                    l.setBackground(new Color(247,247,247));
                }
                @Override
                public void mouseClicked(MouseEvent e) {
                    lm.setText("  "+l.getText());
                    campo=l.getText();
                    if(campo.contains("Todos")){
                        Component[] lta = filtroa.getComponents();
                        for(int i=1; i<lta.length;i++){
                            ((JCheckBox)lta[i]).setSelected(true);
                        }
                    }else{
                        Component[] lta = filtroa.getComponents();
                        for(int i=1; i<lta.length;i++){
                            ((JCheckBox)lta[i]).setSelected(false);
                        }
                    }
                }
        });
            bg1.add(l);
            add(l);
            list.add(l);
            posy= posy+30;
        }
         
        lm.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    
                }
                @Override
                public void mouseClicked(MouseEvent e) {
                    for(Component i: list){
                        i.setVisible(!i.isVisible());
                    }
                }
        });
        setSize(160,395);
        setPreferredSize(new Dimension(160,395));
        setVisible(true);
    }

    public ArrayList<Component> getList() {
        return list;
    }

    public void setList(ArrayList<Component> list) {
        this.list = list;
    }

    public ButtonGroup getBg1() {
        return bg1;
    }

    public void setBg1(ButtonGroup bg1) {
        this.bg1 = bg1;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 202, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
