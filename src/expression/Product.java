package expression;

import java.util.regex.Pattern;

import model.RGBColor;
import model.util.ColorCombinations;




public class Product extends ParenExpression implements Expression {
	private Expression[] opList;
	private int numofop = 1024;
	private static final Pattern

	EXPRESSION_BEGIN_REGEX = Pattern.compile("\\((product)");


	public Product() {
		super(0);
	}

	public Product(Expression[] operands, int currentPosition) {
		super(currentPosition);
		opList = operands;
	}

	public Product setop(Expression[] operands, int currentPosition) {
		return new Product(operands, currentPosition);
	}

	public RGBColor evaluate(double x, double y, double t) {

		return ColorCombinations.product(opList, x, y, t);
	}

	public int numofop() {
		return numofop;
	}
	
	public Product getFactory() {
		return this;
	}
	public Pattern getPattern()
	{
		return EXPRESSION_BEGIN_REGEX;
	}

}

