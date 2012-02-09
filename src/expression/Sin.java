package expression;
import java.util.regex.Pattern;



import model.RGBColor;
import model.util.ColorCombinations;

public class Sin extends ParenExpression implements Expression {
	private Expression myOperand1;
	int numofop = 1;
	private static final Pattern

	EXPRESSION_BEGIN_REGEX = Pattern.compile("\\((sin)");

	public Sin() {
		super(0);
	}

	public Sin(Expression[] operands, int currentPosition) {
		super(currentPosition);
		myOperand1 = operands[0];
	}

	public Sin setop(Expression[] operands, int currentPosition) {
		return new Sin(operands, currentPosition);
	}

	public RGBColor evaluate(double x, double y, double t) {

		return ColorCombinations.sin(myOperand1.evaluate(x, y, t));
	}


	@Override
	public Sin getFactory() {
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

