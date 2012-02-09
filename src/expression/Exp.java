package expression;

import java.util.regex.Pattern;


import model.RGBColor;
import model.util.ColorCombinations;

public class Exp extends ParenExpression implements Expression {
	private Expression myOperand1;
	private Expression myOperand2;
	private int numofop = 2;
	protected static final Pattern EXPRESSION_BEGIN_REGEX = Pattern
			.compile("(\\((exp))|(\\((\\^))");

	public Exp() {
		super(0);
	}

	public Exp(Expression[] operands, int currentPosition) {
		super(currentPosition);
		myOperand1 = operands[0];
		myOperand2 = operands[1];
	}

	public Exp setop(Expression[] operands, int currentPosition) {
		return new Exp(operands, currentPosition);
	}

	public RGBColor evaluate(double x, double y, double t) {

		return ColorCombinations.add(myOperand1.evaluate(x, y, t),
				myOperand2.evaluate(x, y, t));
	}

	public int numofop() {
		return numofop;
	}
	
	public Exp getFactory() {
		return this;
	}
	public Pattern getPattern()
	{
		return EXPRESSION_BEGIN_REGEX;
	}

}
