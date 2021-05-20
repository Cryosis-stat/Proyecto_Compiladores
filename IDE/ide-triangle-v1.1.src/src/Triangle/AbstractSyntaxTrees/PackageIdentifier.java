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
public class PackageIdentifier extends Identifier{
    
    public PackageIdentifier(String theSpelling, SourcePosition thePosition) {
        super(theSpelling, thePosition);
    }
    
}
