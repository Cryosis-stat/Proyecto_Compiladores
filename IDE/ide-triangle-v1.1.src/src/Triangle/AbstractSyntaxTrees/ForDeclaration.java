/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author Walter
 */
public class ForDeclaration extends Declaration{

  public ForDeclaration (Identifier iAST, Expression eAST, Expression eAST1,
                    SourcePosition thePosition) {
    super (thePosition);
    I = iAST;
    E = eAST;
    E1 = eAST1;

  }

  public Object visit(Visitor v, Object o) {
    return v.visitForDeclaration(this, o);
  }

  public Identifier I;
  public Expression E,E1;
  
}
