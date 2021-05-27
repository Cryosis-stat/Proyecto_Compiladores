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
public class SingleProgram extends Program{
    
    public Command C;
    
    public SingleProgram(Command cAST, SourcePosition thePosition) {
        super(thePosition);
        C=cAST;
    }

    public Command getC() {
        return C;
    }
    
   public Object visit(Visitor v, Object o) {
    return v.visitSingleProgram(this, o);
  }
    
}
