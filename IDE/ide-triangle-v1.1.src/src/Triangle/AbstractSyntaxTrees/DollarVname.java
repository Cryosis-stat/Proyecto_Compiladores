/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class DollarVname extends Vname{
    
    public DollarVname (Vname vAST, Identifier iAST, SourcePosition thePosition) {
        super (thePosition);
        V = vAST;
        I = iAST;
    }
    
    public Object visit (Visitor v, Object o) {
        return v.visitDollarVname(this, o);
    }
    
    public Vname V;
    public Identifier I;
}
