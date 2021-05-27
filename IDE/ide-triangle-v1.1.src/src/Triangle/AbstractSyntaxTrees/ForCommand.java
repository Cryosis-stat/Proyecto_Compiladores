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
public class ForCommand extends Command {
   public ForCommand (ForDeclaration fAST, Expression eAST, Command cAST, SourcePosition thePosition) {
    super (thePosition);
    F = fAST;
    C = cAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitForCommand(this, o);
  }

  public ForDeclaration F;
  public Command C;
}
