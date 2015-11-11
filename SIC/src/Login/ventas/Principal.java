package Login.ventas;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import javax.swing.*;
import com.sun.pdfview.*;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import rrhh.sic_rrhh.JavaMail;


public class Principal extends JFrame {
 
 PagePanel panelpdf;
 JFileChooser selector;
 PDFFile pdffile;
 int indice=0;
 int max=0;
 
 public Principal(String direccion){
    JavaMail mail = new JavaMail();
        //mail.email("ivan.puero@cajamarca.ec","Rol Diciembre 2014","Saludos, Se adjunta su Rol del mes de Diciembre 2014.");
    setBounds(0, 0, 700, 800);
    dispose();
    setUndecorated(true);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    panelpdf=new PagePanel();
    indice=1;
    try{
        
    File file = new File(direccion);
    if(!file.exists()){
        direccion = direccion.toLowerCase();
        direccion = direccion.replace(' ', '-');
        direccion = direccion.replace('ñ', 'n');
        
        file = new File(direccion);
    }
    RandomAccessFile raf = new RandomAccessFile(file, "r");
    
    byte[] b = new byte[(int) raf.length()];
    raf.readFully(b);
    ByteBuffer buf = ByteBuffer.wrap(b);
    
    pdffile = new PDFFile(buf);
    panelpdf.setSize(WIDTH, HEIGHT);
    max=pdffile.getNumPages();
    PDFPage page = pdffile.getPage(indice);
    panelpdf.showPage(page);
    repaint();
    }catch(Exception ex){
     JOptionPane.showMessageDialog(null, "Pdf con Errores");
     dispose();
    }
  JPanel pabajo=new JPanel();
  final JLabel bsiguiente=new JLabel();
  bsiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-flechader-lightblue.png"))); // NOI18N
  bsiguiente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
  bsiguiente.setSize(30, 24);
  bsiguiente.addMouseListener(new java.awt.event.MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e) {
            if(indice!=max){
            indice++;
            }
            PDFPage page = pdffile.getPage(indice);
            panelpdf.showPage(page);
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            bsiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-flechader-blue.png"))); // NOI18N
        }

        @Override
        public void mouseExited(MouseEvent e) {
            bsiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-flechader-lightblue.png"))); // NOI18N
        }
  });
  final JLabel banterior=new JLabel();
  banterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-flechaizq-lightblue.png"))); // NOI18N
  banterior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
  banterior.setSize(30, 24);
  banterior.addMouseListener(new java.awt.event.MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e) {
            indice--;
            if(indice==0){
            indice++;
            }
            PDFPage page = pdffile.getPage(indice);
               panelpdf.showPage(page);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            banterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-flechaizq-blue.png"))); // NOI18N
        }

        @Override
        public void mouseExited(MouseEvent e) {
            banterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-flechaizq-lightblue.png"))); // NOI18N
        }
        
  });
  KeyboardFocusManager.getCurrentKeyboardFocusManager().
                addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == java.awt.event.KeyEvent.KEY_RELEASED &&
                        e.getKeyCode() == java.awt.event.KeyEvent.VK_ESCAPE) {
                    dispose();
                }
                return false;
            }
        });


  
  
  add(panelpdf);
  add(banterior,BorderLayout.WEST);
  add(bsiguiente,BorderLayout.EAST);
  
 }
 
 public static void main(String arg[]){
  Principal p=new Principal("");
  p.setDefaultCloseOperation(EXIT_ON_CLOSE);
  p.setVisible(true);
  p.setBounds(0, 0, 500, 500);
  p.setLocationRelativeTo(null);
 }
 public void next(){
    
 }
}