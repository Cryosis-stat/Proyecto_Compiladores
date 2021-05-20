/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArchivosSalida;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author david
 */
public class EscrituraFicheroHTML {
    //Atributos constantes
    FileReader fr = null;
    BufferedReader br = null;
    BufferedWriter bw = null;
    FileWriter fichero = null;
    PrintWriter pw = null;
    String archivo;
    
    //constructor -> inicia el archivo escribiendo el cuerpo inicial
   public EscrituraFicheroHTML(String fileName) throws FileNotFoundException{
        try {
            archivo = fileName.replace(".tri", ".html");
            fichero = new FileWriter(archivo);
            fichero.close();
            
            //System.out.println("Archivo HTML inicializado.");
        } catch (IOException e) {
            System.out.println("An error occurred HTML.");
        }
        
    }
    
    //metodos
    
    public void inicializarArchivo() {
        try {
            fichero = new FileWriter(archivo, true); //el true es para añadir al final
            pw = new PrintWriter(fichero);
            pw.println("<HTML>\n<HEAD><TITLE>Archivo HTML de salida</TITLE></HEAD>\n<BODY>\n");
            pw.println("<p style=\"font-family: 'DejaVu Sans', monospace;\">\n");
            fichero.close();
            
            //System.out.println("Se ha añadido una etiqueta.");
        } catch (IOException e) {
            System.out.println("An error occurred HTML.");
        }
    }
    
    // este metodo añadira solo al cuerpo del HTML
    public void addEtiqueta(String nuevaEtiqueta) {
        try {
            fichero = new FileWriter(archivo, true); //el true es para añadir al final
            pw = new PrintWriter(fichero);
            pw.print(nuevaEtiqueta);
            fichero.close();
            
            //System.out.println("Se ha añadido una etiqueta.");
        } catch (IOException e) {
            System.out.println("An error occurred HTML.");
        }
    }
    
    //utilizo este metodo al finalizar el archivo
    public void finalizarArchivo () {
        try {
            fichero = new FileWriter(archivo, true); //el true es para añadir al final
            pw = new PrintWriter(fichero);
            pw.println("\n</p></BODY></HTML>");
            fichero.close();
            
            //System.out.println("Archivo HTML finalizado.");
        } catch (IOException e) {
            System.out.println("An error occurred HTML.");
        }
    }
    
   public void errorArchivo (String nombreArchivo) throws IOException {
        fichero = new FileWriter(nombreArchivo);
        bw = new BufferedWriter(fichero);
        bw.write("");
        bw.close();
        
        System.out.println("Se ha borrado el archivo por un error durante el analisis.");
    }
   
   public String getNombreArchivo () {
        return this.archivo;
    }
}
