package expression;

import java.util.regex.Pattern;


import model.RGBColor;

import model.util.ColorCombinations;

public class PerlinBW extends ParenExpression implements Expression {
	private Expression myOperand1;
	private Expression myOperand2;
	private int numofop = 2;
	private static final Pattern EXPRESSION_BEGIN_REGEX = Pattern
			.compile("\\((perlinBW)");

	public PerlinBW() {
		super(0);
	}

	public PerlinBW(Expression[] operands, int currentPosition) {
		super(currentPosition);
		myOperand1 = operands[0];
		myOperand2 = operands[1];
	}

	public PerlinBW setop(Expression[] operands, int currentPosition) {
		return new PerlinBW(operands, currentPosition);
	}

	public RGBColor evaluate(double x, double y, double t) {

		return ColorCombinations.add(myOperand1.evaluate(x, y, t),
				myOperand2.evaluate(x, y, t));
	}

	public int numofop() {
		return numofop;
	}
	
	public PerlinBW getFactory() {
		return this;
	}
	public Pattern getPattern()
	{
		return EXPRESSION_BEGIN_REGEX;
	}
}