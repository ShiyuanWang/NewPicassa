package expression;

import java.util.regex.Pattern;

import model.RGBColor;
import model.util.ColorCombinations;

public class Ceil extends ParenExpression implements Expression{
	private Expression myOperand1;
	int numofop = 1;
	private static final Pattern

	EXPRESSION_BEGIN_REGEX = Pattern.compile("\\((ceil)");

	public Ceil() {
		super(0);
	}

	public Ceil(Expression[] operands, int currentPosition) {
		super(currentPosition);
		myOperand1 = operands[0];
	}

	public Ceil setop(Expression[] operands, int currentPosition) {
		return new Ceil(operands, currentPosition);
	}

	public RGBColor evaluate(double x, double y, double t) {

		return ColorCombinations.ceil(myOperand1.evaluate(x, y, t));
	}

	public int numofop() {
		return numofop;
	}
	
	public Ceil getFactory() {
		return this;
	}
	public Pattern getPattern()
	{
		return EXPRESSION_BEGIN_REGEX;
	}

}
