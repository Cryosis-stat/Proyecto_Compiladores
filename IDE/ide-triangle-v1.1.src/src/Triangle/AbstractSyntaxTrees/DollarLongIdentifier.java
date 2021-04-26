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
public class DollarLongIdentifier extends LongIdentifier{
    public DollarLongIdentifier (Identifier pAST, Identifier iAST, SourcePosition thePosition){
        super(thePosition);
        P = pAST;
        I = iAST;
    }
    
    public Object visit(Visitor v, Object o) {
        return v.visitDollarLongIdentifier(this, o);
    }
    
    public Identifier P, I;
}
