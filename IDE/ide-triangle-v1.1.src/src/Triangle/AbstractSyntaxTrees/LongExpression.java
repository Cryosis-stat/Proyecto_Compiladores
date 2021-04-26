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
public class LongExpression extends Expression {
    
    public LongExpression (LongIdentifier lAST, ActualParameterSequence apsAST,
               SourcePosition thePosition) {
    super (thePosition);
    L = lAST;
    APS = apsAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitLongExpression(this, o);
  }

  public LongIdentifier L;
  public ActualParameterSequence APS;
}
