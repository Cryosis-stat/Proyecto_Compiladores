/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class DollarVname extends Vname{
    
    public DollarVname (Identifier iAST, Vname vAST, SourcePosition thePosition) {
        super (thePosition);
        I = iAST;
        V = vAST;
    }
    
    public Object visit (Visitor v, Object o) {
        return v.visitDollarVname(this, o);
    }
    
    public Identifier I;
    public Vname V;
}
