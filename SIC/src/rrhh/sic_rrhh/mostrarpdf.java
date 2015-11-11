/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.sic_rrhh;



import java.io.File;
import java.nio.ByteBuffer;
import javax.swing.*;
import com.sun.pdfview.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class mostrarpdf extends JPanel {
 
 PagePanel panelpdf;
 JFileChooser selector;
 PDFFile pdffile;
 int indice=0;
 int max=0;
    private JLabel banterior;
    private JLabel bsiguiente;
 
 public mostrarpdf(String direccion, JPanel pane){
    setVisible(true);
    panelpdf=new PagePanel();
    indice=0;
    try{
    byte[] b = loadFile(direccion);
    ByteBuffer buf = ByteBuffer.wrap(b);
    panelpdf.setBackground(Color.white);
    pdffile = new PDFFile(buf);
    panelpdf.setSize(WIDTH, HEIGHT);
    max=pdffile.getNumPages();
    PDFPage page = pdffile.getPage(indice);
    panelpdf.showPage(page);
    repaint();
    }catch(Exception ex){
     JOptionPane.showMessageDialog(null, "Pdf con Errores" + ex);
    }
  bsiguiente=new JLabel();
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
  banterior=new JLabel();
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

  pane.add(this.panelpdf);
//  pane.add(this.banterior,BorderLayout.WEST);
//  pane.add(this.bsiguiente,BorderLayout.EAST);
  
 }
 public void next(){
    
 }
 public byte[] readFully(InputStream stream) throws IOException
{
    byte[] buffer = new byte[8192];
    ByteArrayOutputStream baos = new ByteArrayOutputStream();

    int bytesRead;
    while ((bytesRead = stream.read(buffer)) != -1)
    {
        baos.write(buffer, 0, bytesRead);
    }
    return baos.toByteArray();
}
 
public byte[] loadFile(String direccion) throws IOException
{
    File file = new File(direccion);
    if(!file.exists()){
        direccion = direccion.toLowerCase();
        direccion = direccion.replace(' ', '-');
        direccion = direccion.replace('ñ', 'n');
        file = new File(direccion);
    }
    
    InputStream inputStream = null;
    try 
    {
        inputStream = new FileInputStream(direccion);
        return readFully(inputStream);
    } 
    finally
    {
        if (inputStream != null)
        {
            inputStream.close();
        }
    }
}
 
}