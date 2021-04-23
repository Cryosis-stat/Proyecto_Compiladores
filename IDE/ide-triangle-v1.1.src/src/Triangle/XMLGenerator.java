/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle;

import Triangle.AbstractSyntaxTrees.Program;
import Triangle.AbstractSyntaxTrees.Visitor;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author JOSE PABLO MAYORGA
 */
public class XMLGenerator {
    
    private String filename;
   
    void generateXML(String code, Program root) throws Exception{
        try {
            filename = code;
            FileWriter archivo = new FileWriter(filename+".xml");  
            
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            
            //root.visit(v, bf);
            
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            /*Element rootElement = document.createElement("Program");
            document.appendChild(rootElement);
            


            String element;
            String data;
            Element em = document.createElement(element);
            em.appendChild(document.createTextNode(data));
            rootElement.appendChild(em);
*/
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result =  new StreamResult(archivo);
            transformer.transform(source, result);                
            archivo.close();
    
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    } 
}
