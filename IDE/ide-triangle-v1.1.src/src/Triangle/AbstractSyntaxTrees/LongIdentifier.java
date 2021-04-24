/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author irsac
 */
public class LongIdentifier extends AST {
    public LongIdentifier (Identifier pacIdentAST, Identifier iAST, SourcePosition thePosition) {
    super (thePosition);
    P = pacIdentAST;
    I = iAST;
  }
    
    public Object visit(Visitor v, Object o) {
        return v.visitLongIdentifier(this, o);
    }

  public Identifier P, I;
}
