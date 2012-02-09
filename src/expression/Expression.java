package expression;

import model.RGBColor;

/**
 * An Expression represents a mathematical expression as a tree.
 * 
 * In this format, the internal nodes represent mathematical 
 * functions and the leaves represent constant values.
 *
 * @author former student solution
 * @author Robert C. Duvall (added comments, some code)
 */
public interface Expression
{


	public int getPosition();
	public void setPosition(int myCurrentPosition);
	public RGBColor evaluate(double evalX, double evalY, double myCurrentTime);
	public abstract Expression setop(Expression[] operands, int myCurrentPosition);
	
}
