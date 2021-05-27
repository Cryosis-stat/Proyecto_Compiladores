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
public class SimpleLongIdentifier extends LongIdentifier{

    public Identifier identifier;
    
    public SimpleLongIdentifier(Identifier pIdentifier,SourcePosition thePosition) {
        super(thePosition);
        identifier=pIdentifier;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitSimpleLongIdentifier(this,o);
        
    }

    public Identifier getIdentifier() {
        return identifier;
    }
    
}
