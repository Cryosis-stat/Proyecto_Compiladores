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
public abstract class LongIdentifier extends AST {
    public Identifier identifier;

    public LongIdentifier(SourcePosition thePosition) {
        
        super(thePosition);
    }
}
