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
public class CompoundProgram extends Program{

    public CompoundProgram(Declaration dAST, Command cAST, SourcePosition thePosition) {
        super(thePosition);
        this.D = dAST;
        this.C = cAST;
    }

    public Declaration getD() {
        return D;
    }

    public Command getC() {
        return C;
    }
    
   
    Declaration D;
    Command C;
}
