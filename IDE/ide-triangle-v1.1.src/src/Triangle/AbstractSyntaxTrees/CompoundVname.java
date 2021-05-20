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
public class CompoundVname extends Vname{

    public CompoundVname(Identifier pI, VarName pV,SourcePosition thePosition) {
        super(thePosition);
        I=pI;
        V=pV;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitCompoundVname(this,o);
    }

    public Identifier getI() {
        return I;
    }

    public VarName getV() {
        return V;
    }
    
    
    Identifier I;
    VarName V;
}
