/*
 * David Espinoza
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author david
 */
public class RecursiveCompound_Declaration extends Declaration {
    
    public RecursiveCompound_Declaration (Declaration dAST, SourcePosition thePosition) {
    super (thePosition);
    D1 = dAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitRecursiveCompound_Declaration(this, o);
  }

  public Declaration D1;
}
