package expression;
import java.util.regex.Pattern;
import model.RGBColor;
import model.util.ColorCombinations;

public class ConstantColor extends ParenExpression implements Expression {

	private Expression myOperand1;
	private Expression myOperand2;
	private Expression myOperand3;
	public static int myCurrentPosition;
	String myInput;
	int numofop = 3;
	protected static final Pattern

	EXPRESSION_BEGIN_REGEX = Pattern.compile("\\((color)");

	public ConstantColor() {
	        super(0);
	}

	public ConstantColor(Expression[] operands, int currentPosition) {
		super(currentPosition);
		myOperand1 = operands[0];
		myOperand2 = operands[1];
		myOperand3 = operands[2];
	}

	public ConstantColor setop(Expression[] operands, int currentPosition) {
		return new ConstantColor(operands, currentPosition);
	}

	public RGBColor evaluate(double x, double y, double t) {

		return ColorCombinations.color(myOperand1.evaluate(x, y, t),
				myOperand2.evaluate(x, y, t), myOperand3.evaluate(x, y,t));

	}



	public ConstantColor getFactory() {
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
