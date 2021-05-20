/*
 * David Espinoza
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author david
 */
public class PrivateCompound_Declaration extends Declaration {
    
    public PrivateCompound_Declaration (Declaration d1AST, Declaration d2AST,
            SourcePosition thePosition) {
    super (thePosition);
    D1 = d1AST;
    D2 = d2AST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitPrivateCompound_Declaration(this, o);
  }

  public Declaration D1, D2;
}
