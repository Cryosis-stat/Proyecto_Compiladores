/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;



public class LongTypeDenoter extends TypeDenoter{
    public LongTypeDenoter(LongIdentifier lAST, SourcePosition thePosition){
        super(thePosition);
        L = lAST;
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visit (Visitor v, Object o) {
        return v.visitLongTypeDenoter(this, o);
    }
    
    public LongIdentifier L;
}
