/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class SimplePackageIdentifier extends  PackageIdentifier{
    
    public SimplePackageIdentifier (Identifier iAST, SourcePosition thePosition) {
        super (thePosition);
        I = iAST;
    }

    public Object visit (Visitor v, Object o) {
        return v.visitSimplePackageIdentifier(this, o);
    }

  public Identifier I;
}
