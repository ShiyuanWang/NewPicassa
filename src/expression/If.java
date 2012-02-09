package expression;

import java.util.regex.Pattern;

import model.RGBColor;
import model.util.ColorCombinations;


public class If extends ParenExpression implements Expression {
	private Expression[] opList;
	private int numofop = 3;
	private static final Pattern

	EXPRESSION_BEGIN_REGEX = Pattern.compile("\\((if)");

	public If() {
		super(0);
	}

	public If(Expression[] operands, int currentPosition) {
		super(currentPosition);
		opList = operands;
	}

	public If setop(Expression[] operands, int currentPosition) {
		return new If(operands, currentPosition);
	}

	public RGBColor evaluate(double x, double y, double t) {

		return ColorCombinations.ifcase(opList, x, y, t);

	}

	public If getFactory() {
		return this;
	}

	@Override
	public Pattern getPattern() {
		return EXPRESSION_BEGIN_REGEX;
	}

	@Override
	public int numofop() {
		return numofop;
	}

}
