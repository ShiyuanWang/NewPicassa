package expression;

import java.util.regex.Pattern;

import model.RGBColor;
import model.util.ColorCombinations;



public class Min extends ParenExpression implements Expression {
	private Expression[] opList;
	private int numofop = 1024;
	private static final Pattern

	EXPRESSION_BEGIN_REGEX = Pattern.compile("\\((min)");

	public Min() {
		super(0);
	}

	public Min(Expression[] operands, int currentPosition) {
		super(currentPosition);
		opList = operands;
	}

	public Min setop(Expression[] operands, int currentPosition) {
		return new Min(operands, currentPosition);
	}

	public RGBColor evaluate(double x, double y, double t) {

		return ColorCombinations.min(opList, x, y, t);
	}

	public int numofop() {
		return numofop;
	}
	
	public Min getFactory() {
		return this;
	}
	public Pattern getPattern()
	{
		return EXPRESSION_BEGIN_REGEX;
	}

}

