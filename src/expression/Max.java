package expression;

import java.util.regex.Pattern;

import model.RGBColor;
import model.util.ColorCombinations;




public class Max extends ParenExpression implements Expression {
	private Expression[] opList;
	private int numofop = 1024;
	private static final Pattern

	EXPRESSION_BEGIN_REGEX = Pattern.compile("\\((max)");


	public Max() {
		super(0);
	}

	public Max(Expression[] operands, int currentPosition) {
		super(currentPosition);
		opList = operands;
	}

	public Max setop(Expression[] operands, int currentPosition) {
		return new Max(operands, currentPosition);
	}

	public RGBColor evaluate(double x, double y, double t) {

		return ColorCombinations.max(opList, x, y, t);
	}

	public int numofop() {
		return numofop;
	}
	
	public Max getFactory() {
		return this;
	}
	public Pattern getPattern()
	{
		return EXPRESSION_BEGIN_REGEX;
	}

}

