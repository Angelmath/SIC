package sgi.acceso;
/* 
 * @author Angelmath
 */
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;
 
public class ReadXMLFile {
 
    public ReadXMLFile(){

    }
    
    public ArrayList<ArrayList<String>> tabla( String cadena){
        String texto= "";
        ArrayList<ArrayList<String>> tabla= new ArrayList<>();
        try {
        
	DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

        Document doc = docBuilder.parse (new File(cadena));

 
	doc.getDocumentElement ().normalize ();

        texto= texto + "\n El elemento raíz es " +  doc.getDocumentElement().getNodeName();

	NodeList listaRow = doc.getElementsByTagName("Data");

        int totalRow = listaRow.getLength();
        
        texto= texto + "\n Número total de row : " + totalRow;
        ArrayList<String> Lu= new ArrayList<>();
        ArrayList<String> Ma= new ArrayList<>();
        ArrayList<String> Mi= new ArrayList<>();
        ArrayList<String> Ju= new ArrayList<>();
        ArrayList<String> Vi= new ArrayList<>();
        ArrayList<String> Sa= new ArrayList<>();
        ArrayList<String> Do= new ArrayList<>();
        String basura="";
        ArrayList<String> Lista= new ArrayList<>();
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
                    Lu= new ArrayList<>();
                    Ma= new ArrayList<>();
                    Mi= new ArrayList<>();
                    Ju= new ArrayList<>();
                    Vi= new ArrayList<>();
                    Sa= new ArrayList<>();
                    Do= new ArrayList<>();
                }
        }
            tabla.toString();
    } catch (ParserConfigurationException | SAXException | IOException | DOMException e) {
        JOptionPane.showMessageDialog(null, "Error de Directorio");
    }
        return tabla;
    }
    public String getTagValue(String tag, Element elemento) {

        NodeList lista = elemento.getElementsByTagName(tag).item(0).getChildNodes();

        Node valor = (Node) lista.item(0);

        return valor.getNodeValue();

    }
    
    public static void main(String argv[]) {
        ReadXMLFile cadena = new ReadXMLFile();
        cadena.tabla("C:\\Users\\Angelmath\\Desktop\\Horarios.xml");
    
  }
    
}
