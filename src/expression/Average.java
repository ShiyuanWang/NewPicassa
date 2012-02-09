package expression;


import java.util.regex.Pattern;

import model.RGBColor;
import model.util.ColorCombinations;



public class Average extends ParenExpression implements Expression {
	private Expression[] opList;
	private int numofop = 1024;
	private static final Pattern
	EXPRESSION_BEGIN_REGEX = Pattern.compile("\\((average)");
	public Average() {
		super(0);
	}

	public Average(Expression[] operands, int currentPosition) {
		super(currentPosition);
		opList = operands;
	}

	public Average setop(Expression[] operands, int currentPosition) {
		return new Average(operands, currentPosition);
	}

	public RGBColor evaluate(double x, double y, double t) {

		return ColorCombinations.average(opList, x, y, t);
	}

	public int numofop() {
		return numofop;
	}
	
	public Average getFactory() {
		return this;
	}
	public Pattern getPattern()
	{
		return EXPRESSION_BEGIN_REGEX;
	}
}

