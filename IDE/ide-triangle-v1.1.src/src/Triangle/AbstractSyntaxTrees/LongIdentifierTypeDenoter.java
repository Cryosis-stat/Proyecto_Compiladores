/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author Carlos
 */
public class LongIdentifierTypeDenoter extends TypeDenoter {
    public LongIdentifierTypeDenoter (LongIdentifier iAST, SourcePosition thePosition) {
    super (thePosition);
    I = iAST;
  }

  public Object visit (Visitor v, Object o) {
    return v.visitLongIdentifierTypeDenoter(this, o);
  }

  public boolean equals (Object obj) {
    return false; // should not happen
  }

  public LongIdentifier I;
}
