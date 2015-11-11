package Bitacora.acceso;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
/**
 * @web http://www.jc-mouse.net
 * @author Mouse
 */
public class CellRenderer extends DefaultTableCellRenderer {
 
    private String tipo="text";
    private Font courier = new Font( "Courier New",Font.PLAIN ,12 );
    private Font normal = new Font( "Arial",Font.PLAIN ,12 );
    private Font bold = new Font( "Arial",Font.BOLD ,12 );
    private JLabel label = new JLabel();
    
    /** Constructor de clase
     * @param tipo String
     * Ej.: "text", "text center", "hour" , "num" , "icon"
     */
    public CellRenderer( String tipo )
    {
        this.tipo = tipo;
    }
    
    
    @Override
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column )
    {   
        this.setFont(new java.awt.Font("Roboto Light", 0, 11));
        this.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(255, 255, 255)));
        if (selected) {                
            this.setBackground( new Color( 150, 153 , 254) );                        
        }
        else
        {
            if(row%2==0){
                this.setBackground(new Color( 245, 245 , 245));
            }else{
                this.setBackground(new Color( 220, 220 , 220));
            }
        }
        
        if( tipo.equals("hour"))
        {
            this.setHorizontalAlignment( JLabel.CENTER );
            this.setText( (String) value );
            this.setForeground( (selected)?new Color(255,255,255):new Color(0,0,0) );                    
            return this;
        }
        if(tipo.equals("colores")){
            if(String.valueOf(table.getValueAt(row,8)).equalsIgnoreCase("X")){
                    this.setBackground(Color.BLUE);
            }
            if(value!=null){
            if(value.equals("X")||value.equals("O")){
                
            }else{
                this.setHorizontalAlignment( JLabel.LEFT );
                this.setText( (String) value.toString() );
            }
            }      
            return this;
        }
        if( tipo.equals(""))
        {
            if(value!=null){
            if(value.equals("X")){
                this.setBackground(Color.YELLOW);
                
            }else{
                this.setBackground(Color.white);
            }
            }else{
                this.setBackground(Color.white);
            }
            
            return this;
        }
        if( tipo.equals("notificacion"))
        {
            this.setHorizontalAlignment( JLabel.LEFT );
            
            if(String.valueOf(table.getValueAt(row,0)).equalsIgnoreCase("SI")){
                this.setText( (String) value );
                this.setFont(new java.awt.Font("Roboto Light", 0, 11));
            }else{
                this.setText( (String) value );
                this.setFont(new java.awt.Font("Roboto Light", 1, 11));
            }
            this.setForeground( (selected)?new Color(255,255,255):new Color(0,0,0) );            
            return this;
        }
        
        if( tipo.equals("notificacion-center"))
        {
            this.setHorizontalAlignment( JLabel.CENTER );
            
            if(String.valueOf(table.getValueAt(row,0)).equalsIgnoreCase("SI")){
                this.setText( (String) value );
                this.setFont(new java.awt.Font("Roboto Light", 0, 11));
            }else{
                this.setText( (String) value );
                this.setFont(new java.awt.Font("Roboto Light", 1, 11));
            }
            this.setForeground( (selected)?new Color(255,255,255):new Color(0,0,0) );            
            return this;
        }
        
        if( tipo.equals("text"))
        {
            this.setHorizontalAlignment( JLabel.LEFT );
            this.setText( (String) value );
            this.setForeground( (selected)?new Color(255,255,255):new Color(0,0,0) );            
            return this;
        }
        if( tipo.equals("imagen"))
        {
            
        }
        if( tipo.equals("text center"))
        {
            this.setHorizontalAlignment( JLabel.CENTER );
            if(value==null){
                this.setText("");    
            }else{
                this.setText( (String) value.toString() );    
            }
            this.setForeground( (selected)?new Color(255,255,255):new Color(0,0,0) );            
            return this;
        }
                
        if( tipo.equals("text izquierda"))
        {
            this.setHorizontalAlignment( JLabel.LEFT );
            if(value==null){
                this.setText("");    
            }else{
                this.setText( (String) value.toString() );    
            }
            this.setForeground( (selected)?new Color(255,255,255):new Color(0,0,0) );            
            return this;
        }
        if( tipo.equals("fecha-notificacion"))
        {
            this.setHorizontalAlignment( JLabel.CENTER );
            if(String.valueOf(table.getValueAt(row,0)).equalsIgnoreCase("SI")){
                this.setText( (String) value.toString() );
                this.setFont(new java.awt.Font("Roboto Light", 0, 11));
            }else{
                this.setText( (String) value.toString() );
                this.setFont(new java.awt.Font("Roboto Light", 1, 11));
            }
            this.setForeground( (selected)?new Color(255,255,255):new Color(0,0,0) );            
            return this;
        }
        if( tipo.equals("fecha"))
        {
            this.setHorizontalAlignment( JLabel.CENTER );
            this.setText( (String) value.toString() );
            this.setForeground( (selected)?new Color(255,255,255):new Color(0,0,0) );            
            return this;
        }
        if( tipo.equals("text derecha"))
        {
            this.setHorizontalAlignment( JLabel.RIGHT );
            this.setText( (String) value );
            this.setForeground( (selected)?new Color(255,255,255):new Color(0,0,0) );            
            return this;
        }
        
        if( tipo.equals("parrafo"))
        {
            String cadena = (String)value;
            String prev="";
            JTextArea jt = new JTextArea(20,30);
            jt.setWrapStyleWord(true);
            jt.setLineWrap(true);
            jt.setText(cadena);
            return jt;
        }
        
        if( tipo.equals("num"))
        {           
            this.setHorizontalAlignment( JLabel.CENTER );
            this.setText( (String) value );            
            this.setForeground( (selected)?new Color(255,255,255):new Color(32,117,32) );            
            return this;   
        }        
        
        return this;
    }
}
