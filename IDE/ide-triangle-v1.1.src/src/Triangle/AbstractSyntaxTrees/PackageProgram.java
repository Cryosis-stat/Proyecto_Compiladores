/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;



public abstract class PackageProgram extends Program{
    
    public PackageProgram (PackageDeclaration pacDecAST, Command cAST, SourcePosition thePosition) {
    super (pacDecAST, cAST, thePosition);
    P = pacDecAST;
    C = cAST;
  }

  /*public Object visit(Visitor v, Object o) {
    return v.visitPackageProgram(this, o);
  }*/

  public PackageDeclaration P;
  public Command C;
}
