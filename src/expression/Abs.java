package expression;


import java.util.regex.Pattern;
import model.RGBColor;
import model.util.ColorCombinations;

public class Abs extends ParenExpression implements Expression{
	private Expression myOperand1;
	int numofop = 1;
	private static final Pattern

	EXPRESSION_BEGIN_REGEX = Pattern.compile("\\((abs)");

	public Abs() {
		super(0);
	}

	public Abs(Expression[] operands, int currentPosition) {
		super(currentPosition);
		myOperand1 = operands[0];
	}

	public Abs setop(Expression[] operands, int currentPosition) {
		return new Abs(operands, currentPosition);
	}

	public RGBColor evaluate(double x, double y, double t) {

		return ColorCombinations.abs(myOperand1.evaluate(x, y, t));
	}

	public int numofop() {
		return numofop;
	}
	
	public Abs getFactory() {
		return this;
	}
	public Pattern getPattern()
	{
		return EXPRESSION_BEGIN_REGEX;
	}

}

