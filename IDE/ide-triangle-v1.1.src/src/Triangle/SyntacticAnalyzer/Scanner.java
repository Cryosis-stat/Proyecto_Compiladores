/*
 * @(#)Scanner.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.SyntacticAnalyzer;

import ArchivosSalida.EscrituraFicheroHTML;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public final class Scanner {

  private SourceFile sourceFile;
  private boolean debug;

  private char currentChar;
  private StringBuffer currentSpelling; //el que agrega todos los caracteres
  private boolean currentlyScanningToken;
    //Para la creacion del HTML
  public EscrituraFicheroHTML ficheroHTML;

  private boolean isLetter(char c) {
    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
  }

  private boolean isDigit(char c) {
    return (c >= '0' && c <= '9');
  }

// isOperator returns true iff the given character is an operator character.

  private boolean isOperator(char c) {
    return (c == '+' || c == '-' || c == '*' || c == '/' ||
	    c == '=' || c == '<' || c == '>' || c == '\\' ||
	    c == '&' || c == '@' || c == '%' || c == '^' ||
	    c == '?');
  }


///////////////////////////////////////////////////////////////////////////////

  public Scanner(SourceFile source) {
      
      try {
          //inicialización del archivo => source.sourceFile.getName() es el nombre del archivo
          ficheroHTML = new EscrituraFicheroHTML(source.sourceFile.getName());
      } catch (FileNotFoundException ex) {
          Logger.getLogger(Scanner.class.getName()).log(Level.SEVERE, null, ex);
      }
    ficheroHTML.inicializarArchivo();
      
    sourceFile = source;
    currentChar = sourceFile.getSource();
    debug = false;
  }

  public void enableDebugging() {
    debug = true;
  }

  // takeIt appends the current character to the current token, and gets
  // the next character from the source program.

  private void takeIt() {
    if (currentlyScanningToken)
      currentSpelling.append(currentChar);
    currentChar = sourceFile.getSource();   
  }

  // scanSeparator skips a single separator.

  private void scanSeparator() {
    switch (currentChar) {
    case '!':
      {
        StringBuffer comentario = new StringBuffer();
        comentario.append(currentChar);
        
        takeIt();
        while ((currentChar != SourceFile.EOL) && (currentChar != SourceFile.EOT)) {
            comentario.append(currentChar);
            takeIt();
        }
        if (currentChar == SourceFile.EOL)
          takeIt();
        //Aquí toma todo lo recolectado en el StringBuffer y lo pone entre etiquetas.
        ficheroHTML.addEtiqueta("<font color='#00b300'>"+comentario.toString()+"</font><br>");
      }
      break;

    case ' ':
    {
        ficheroHTML.addEtiqueta("&nbsp;&nbsp;");
        takeIt();  
        break;
    }
    
    case '\t':
    {
        ficheroHTML.addEtiqueta("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        takeIt();  
        break;
    }
    
    case '\n': case '\r':
     {
        ficheroHTML.addEtiqueta("<br>\n");
        takeIt();  
        break;
     }
      
    }
  }

  private int scanToken() {
 
    switch (currentChar) {

    case 'a':  case 'b':  case 'c':  case 'd':  case 'e':
    case 'f':  case 'g':  case 'h':  case 'i':  case 'j':
    case 'k':  case 'l':  case 'm':  case 'n':  case 'o':
    case 'p':  case 'q':  case 'r':  case 's':  case 't':
    case 'u':  case 'v':  case 'w':  case 'x':  case 'y':
    case 'z':
    case 'A':  case 'B':  case 'C':  case 'D':  case 'E':
    case 'F':  case 'G':  case 'H':  case 'I':  case 'J':
    case 'K':  case 'L':  case 'M':  case 'N':  case 'O':
    case 'P':  case 'Q':  case 'R':  case 'S':  case 'T':
    case 'U':  case 'V':  case 'W':  case 'X':  case 'Y':
    case 'Z': 
      takeIt();       
      while (isLetter(currentChar) || isDigit(currentChar))
        takeIt();
      return Token.IDENTIFIER;
      
    case '0':  case '1':  case '2':  case '3':  case '4':
    case '5':  case '6':  case '7':  case '8':  case '9':     
      takeIt();
      while (isDigit(currentChar))
        takeIt();       
      return Token.INTLITERAL;
      
    case '+':  case '-':  case '*': case '/':  case '=':
    case '<':  case '>':  case '\\':  case '&':  case '@':
    case '%':  case '^':  case '?':
      takeIt();
      while (isOperator(currentChar))
          takeIt();
      return Token.OPERATOR;

    case '\'':
      takeIt();
      takeIt(); // the quoted character
      if (currentChar == '\'') {
      	takeIt();
        return Token.CHARLITERAL;
      } else
        return Token.ERROR;

    case '.':
      takeIt();
      return Token.DOT;

    case ':':
      takeIt();
      if (currentChar == '=') {
        takeIt();
        return Token.BECOMES;
      } else 
           return Token.COLON;

    case ';':
      takeIt();
      return Token.SEMICOLON;

    case ',':
      takeIt();
      return Token.COMMA;

    case '~':
      takeIt();
      return Token.IS;

    case '(':
      takeIt();
      return Token.LPAREN;

    case ')':
      takeIt();
      return Token.RPAREN;

    case '[':
      takeIt();
      return Token.LBRACKET;

    case ']':
      takeIt();
      return Token.RBRACKET;

    case '{':
      takeIt();
      return Token.LCURLY;

    case '}':
      takeIt();
      return Token.RCURLY;
     
    case '|':
      takeIt();
      return Token.PIPE;
      
    case '$':
      takeIt();
      return Token.DOLLAR;

    case SourceFile.EOT:
     {
       ficheroHTML.finalizarArchivo();
       return Token.EOT;
     }

    default:
        takeIt();
        return Token.ERROR;          
    }
  }

  public Token scan () {
    Token tok;
    SourcePosition pos;
    int kind;

    currentlyScanningToken = false;
    while (currentChar == '!'
           || currentChar == ' '
           || currentChar == '\n'
           || currentChar == '\r'
           || currentChar == '\t')
      scanSeparator();

    currentlyScanningToken = true;
    currentSpelling = new StringBuffer("");
    pos = new SourcePosition();
    pos.start = sourceFile.getCurrentLine();

    kind = scanToken();
    
    pos.finish = sourceFile.getCurrentLine();
    tok = new Token(kind, currentSpelling.toString(), pos);
    
    //System.out.println(tok.toString()); //aqui me devuelve el que es
    switch (tok.kind) {
        case 0: case 1: //estos son los Numeros y caracteres
            ficheroHTML.addEtiqueta("<font color='#0000cd'>"+ tok.spelling +"</font>");
            break;
        case 4: case 5: case 6: case 7: case 8: case 9: case 10: //palabras reservadas
        case 11: case 12: case 13: case 14: case 15: case 16: case 17:
        case 18: case 19: case 20: case 21: case 22: case 23: case 24:
        case 25: case 26: case 27: case 28: case 29: case 30: case 31:
            ficheroHTML.addEtiqueta("<font style='padding-left:1em'><b>"+ tok.spelling +"</b>");
            break;
        default: //todo lo demas
            ficheroHTML.addEtiqueta( tok.spelling );
            break;
    }
    
    if (debug)
      System.out.println(tok);
    return tok;
  }

}
