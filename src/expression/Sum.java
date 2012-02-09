package expression;

import java.util.regex.Pattern;

import model.RGBColor;
import model.util.ColorCombinations;




public class Sum extends ParenExpression implements Expression {
	private Expression[] opList;
	private int numofop = 1024;
	private static final Pattern
	EXPRESSION_BEGIN_REGEX = Pattern.compile("\\((sum)");

	public Sum() {
		super(0);
	}

	public Sum(Expression[] operands, int currentPosition) {
		super(currentPosition);
		opList = operands;
	}

	public Sum setop(Expression[] operands, int currentPosition) {
		return new Sum(operands, currentPosition);
	}

	public RGBColor evaluate(double x, double y, double t) {

		return ColorCombinations.sum(opList, x, y, t);
	}

	public int numofop() {
		return numofop;
	}
	
	public Sum getFactory() {
		return this;
	}
	public Pattern getPattern()
	{
		return EXPRESSION_BEGIN_REGEX;
	}
}

