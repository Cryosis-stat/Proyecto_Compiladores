package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author Walter
 */
public abstract class VarName extends AST{
  
  public VarName(SourcePosition thePosition) {
    super (thePosition);
    variable = false;
    type = null;
  }
  
  public boolean variable, indexed;
  public int offset;
  public TypeDenoter type;
}
