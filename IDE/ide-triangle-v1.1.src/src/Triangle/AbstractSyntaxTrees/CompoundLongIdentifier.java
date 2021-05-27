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
public class CompoundLongIdentifier extends LongIdentifier {
    
    Identifier packageIdentifier;
    public Identifier identifier;

    public CompoundLongIdentifier(Identifier pPackageIdentifier,Identifier pIdentifier,SourcePosition thePosition) {
        super(thePosition);
        packageIdentifier=pPackageIdentifier;
        identifier=pIdentifier;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitCompoundLongIdentifier(this,o);
    }

  public Identifier getPackageIdentifier() {
    return packageIdentifier;
  }

  public Identifier getIdentifier() {
    return identifier;
  }
    
}
