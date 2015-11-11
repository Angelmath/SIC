/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bitacora.acceso;

/**
 *
 * @author Angelmath
 */
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
 
public class ReadXMLFile {
 
    public ReadXMLFile(){

    }
    
    public ArrayList<ArrayList<String>> tabla( String cadena){
        String texto= "";
        ArrayList<ArrayList<String>> tabla= new ArrayList<ArrayList<String>>();
        try {
        
	DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

        Document doc = docBuilder.parse (new File(cadena));

 
	doc.getDocumentElement ().normalize ();

        texto= texto + "\n El elemento raíz es " +  doc.getDocumentElement().getNodeName();

	NodeList listaRow = doc.getElementsByTagName("Data");

        int totalRow = listaRow.getLength();
        
        texto= texto + "\n Número total de row : " + totalRow;
        ArrayList<String> Lu= new ArrayList<String>();
        ArrayList<String> Ma= new ArrayList<String>();
        ArrayList<String> Mi= new ArrayList<String>();
        ArrayList<String> Ju= new ArrayList<String>();
        ArrayList<String> Vi= new ArrayList<String>();
        ArrayList<String> Sa= new ArrayList<String>();
        ArrayList<String> Do= new ArrayList<String>();
        String basura="";
        ArrayList<String> Lista= new ArrayList<String>();
        int temp=0;
        
	for (int i = 0; i < totalRow ; i ++) {
            Node Row = listaRow.item(i);
            if (Row.getNodeType() == Node.ELEMENT_NODE){
                    Lista.add(Row.getFirstChild().getNodeValue());
            }
        }
        for (int i = 0; i < Lista.size() ; i ++) {
                if(Lista.get(i).indexOf("PUESTO")==0){
                    i=i+7;
                }else{
                    Lu.add(Lista.get(i+1));
                    Ma.add(Lista.get(i+2));
                    Mi.add(Lista.get(i+3));
                    Ju.add(Lista.get(i+4));
                    Vi.add(Lista.get(i+5));
                    Sa.add(Lista.get(i+6));
                    Do.add(Lista.get(i+7));
                    i=i+7;
                }
                if(Lu.size()==24){
                    tabla.add(Lu);
                    tabla.add(Ma);
                    tabla.add(Mi);
                    tabla.add(Ju);
                    tabla.add(Vi);
                    tabla.add(Sa);
                    tabla.add(Do);
                    Lu= new ArrayList<String>();
                    Ma= new ArrayList<String>();
                    Mi= new ArrayList<String>();
                    Ju= new ArrayList<String>();
                    Vi= new ArrayList<String>();
                    Sa= new ArrayList<String>();
                    Do= new ArrayList<String>();
                }
        }
            tabla.toString();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error de Directorio");
	e.printStackTrace();
    }
        return tabla;
    }
    public String getTagValue(String tag, Element elemento) {

        NodeList lista = elemento.getElementsByTagName(tag).item(0).getChildNodes();

        Node valor = (Node) lista.item(0);

        return valor.getNodeValue().toString();

    }
    
    public static void main(String argv[]) {
        ReadXMLFile cadena = new ReadXMLFile();
        cadena.tabla("C:\\Users\\Angelmath\\Desktop\\Horarios.xml");
    
  }
    
}
