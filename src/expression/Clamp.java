package expression;


import java.util.regex.Pattern;



import model.RGBColor;
import model.util.ColorCombinations;

public class Clamp extends ParenExpression implements Expression {
	private Expression myOperand1;
	int numofop = 1;
	private static final Pattern

	EXPRESSION_BEGIN_REGEX = Pattern.compile("\\((clamp)");

	public Clamp() {
		super(0);
	}

	public Clamp(Expression[] operands, int currentPosition) {
		super(currentPosition);
		myOperand1 = operands[0];
	}

	public Clamp setop(Expression[] operands, int currentPosition) {
		return new Clamp(operands, currentPosition);
	}

	public RGBColor evaluate(double x, double y, double t) {

		return ColorCombinations.clamp(myOperand1.evaluate(x, y, t));
	}

	public int numofop() {
		return numofop;
	}
	
	public Clamp getFactory() {
		return this;
	}
	public Pattern getPattern()
	{
		return EXPRESSION_BEGIN_REGEX;
	}

}
