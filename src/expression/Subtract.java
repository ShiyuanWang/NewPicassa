package expression;

import java.util.regex.Pattern;


import model.RGBColor;
import model.util.ColorCombinations;

public class Subtract extends ParenExpression implements Expression {
	private Expression myOperand1;
	private Expression myOperand2;
	int numofop = 2;
	protected static final Pattern EXPRESSION_BEGIN_REGEX = Pattern
			.compile("(\\((Subtract))|(\\((-))");

	public Subtract() {
		super(0);
	}

	public Subtract(Expression[] operands, int currentPosition) {
		super(currentPosition);
		myOperand1 = operands[0];
		myOperand2 = operands[1];
	}

	public Subtract setop(Expression[] operands, int currentPosition) {
		return new Subtract(operands, currentPosition);
	}

	public RGBColor evaluate(double x, double y, double t) {

		return ColorCombinations.add(myOperand1.evaluate(x, y, t),
				myOperand2.evaluate(x, y, t));
	}

	public int numofop() {
		return numofop;
	}
	
	public Subtract getFactory() {
		return this;
	}
	public Pattern getPattern()
	{
		return EXPRESSION_BEGIN_REGEX;
	}

}
