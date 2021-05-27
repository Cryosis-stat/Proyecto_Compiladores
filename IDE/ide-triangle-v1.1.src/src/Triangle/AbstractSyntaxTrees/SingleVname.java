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
public class SingleVname extends Vname{
    public VarName V;

    public SingleVname(VarName pV,SourcePosition thePosition) {
        super(thePosition);
        V=pV;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitSingleVname(this,o);
    }

        public VarName getV() {
        return V;
    }
    
    
}
