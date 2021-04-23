/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Daar375
 */
public class HTMLGenerator {
    
    private String htmlResult= "";
    
    private String fileName;
    
    
    void ParseHtml(String code) throws IOException{
    fileName = code;
    List<String> lines = Files.readAllLines(Paths.get(code), StandardCharsets.ISO_8859_1);
    ArrayList<String[]> matrix = new ArrayList<String[]>(); // Create an ArrayList object
    String[] splited = {};

        for (String line : lines){
            if(line.contains("!")){
                 splited = new String[]{line};
            }else{
              splited = line.split("(?<=\\D)(?=\\d)|(?=[!])|(?=[+])|(?=[-])|(?=[*])|(?=[=])|(?=[)])|(?<=[(])|(?=[(\\s+)])");

            }
            matrix.add(splited);
        }
        
        
        for (String[] line: matrix){
            
            for (int i = 0; i < line.length; i++){
                if(isNumber(line[i])){
                    line[i]="<font color='#0000cd'>"+line[i]+"</font>";
                }else if(line[i].contains("!")){
                    line[i]="<p style=\"font-family: 'DejaVu Sans', monospace;\"><font color='#00b300'>"+line[i]+"</font>";

                }else if(line[i].contains("'")){
                 line[i]="<font color='#0000cd'>"+line[i]+"</font>";

                }else if(tokens.contains(line[i])){
                 line[i]="<b>"+line[i]+"</b>";

                }
                htmlResult=htmlResult+line[i];
                
            }
            htmlResult=htmlResult+"<br>";

        }

    }
    
    
   public void createFile () throws FileNotFoundException, UnsupportedEncodingException{
       PrintWriter writer = new PrintWriter(removeExtension(fileName)+".html", "UTF-8");
       writer.print(htmlResult);
       writer.close();
   }
   
  private static boolean isNumber(String str) { 
  try {  
    Double.parseDouble(str);  
    return true;
  } catch(NumberFormatException e){  
    return false;  
  }  
}
    private static String removeExtension (String str) {
        if (str == null) return null;
            int pos = str.lastIndexOf(".");
        if (pos == -1) return str;
            return str.substring(0, pos);
    }
     List<String> tokens = Arrays.asList("array",
    "choose",
    "const",
    "do",
    "else",
	  "elseif",
    "end",
  	"for",
	  "from",
    "func",
    "if",
    "in",
    "let",
	  "loop",
	  "nothing",
    "of",
	  "package",
	  "private",
    "proc",
    "record",
	  "recursive",
    "then",
	  "to",
    "type",
	  "until",
    "var",
	  "when",
    "while");
}
