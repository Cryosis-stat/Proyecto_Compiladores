/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author WallElop
 */
public class ForWhileCommand extends Command {
  public ForWhileCommand (ForDeclaration fAST,  Expression e2AST, Command cAST, SourcePosition thePosition) {
    super (thePosition);
    F = fAST;
    E2 = e2AST;
    C = cAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitForWhileCommand(this, o);
  }

  public ForDeclaration F;
  public Expression E2;
  public Command C;
}
