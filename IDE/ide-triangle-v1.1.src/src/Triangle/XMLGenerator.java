/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle;

import Core.Visitors.TreeVisitor;
import Triangle.AbstractSyntaxTrees.Program;
import Triangle.AbstractSyntaxTrees.Visitor;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.tree.DefaultMutableTreeNode;
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
    DefaultMutableTreeNode ast;
    String element;     
    Element elem;
    void generateXML(String code, Program root) throws Exception{
        
        try {
            filename = code.substring(0, code.length()-4);
            FileWriter archivo = new FileWriter(filename+".xml");  
            
           
            
            TreeVisitor vis = new TreeVisitor(); 
            ast = (DefaultMutableTreeNode)vis.visitProgram(root, null);            
                        
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            
            
            //Element rootElement = document.createElement(ast.toString());
            //document.appendChild(rootElement);
            //rootElement.appendChild(elem);
           /* 
            DefaultMutableTreeNode current;
            DefaultMutableTreeNode currentSib;
            System.out.println(ast.toString());
            current = ast.getNextNode();
                        

            //elem = document.createElement(ast.getChildAt(c).toString());
                                
            */                       
            //elem.appendChild(document.createTextNode(data));
            //rootElement.appendChild(elem);

            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result =  new StreamResult(archivo);
            transformer.transform(source, result);   
            archivo.append("\n");
            leerArbol(ast, archivo);
            
            archivo.close();
    
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    } 
    
    void leerArbol(DefaultMutableTreeNode nodo, FileWriter archivo) throws IOException{
        if (nodo == null){
            return;            
        }
        
        archivo.append("<"+nodo.toString()+">\n");
        
        for(int i = 0; i < nodo.getChildCount(); i++){
            leerArbol((DefaultMutableTreeNode)nodo.getChildAt(i), archivo);
        }
        archivo.append("</"+nodo.toString()+">\n");
        

    }
}
