package ArchivosSalida;

import Triangle.AbstractSyntaxTrees.Program;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * Clase recuperada de los documentos del curso 
 * Modificada por los estudiantes 
 * @Walter Lopez
 * @Carlos Vega
 * @David Espinoza
 * 
 */
public class Writer {

  private String fileName;

  public Writer(String fileName) {
    this.fileName = fileName.replace(".html", ".xml");
  }

  // Draw the AST representing a complete program.
  public void write(Program ast) {
    // Prepare the file to write
    try {
      FileWriter fileWriter = new FileWriter(fileName);

      //HTML header
      fileWriter.write("<?xml version=\"1.0\" standalone=\"yes\"?>\n");

      WriterVisitor layout = new WriterVisitor(fileWriter);
      ast.visit(layout, null);
      fileWriter.close();

    } catch (IOException e) {
      System.err.println("Error while creating file for print the AST");
      e.printStackTrace();
    }
  }

}
