package expression;

import java.util.regex.Pattern;

import model.RGBColor;

import model.util.ColorCombinations;

public class Plus extends ParenExpression implements Expression {
	private Expression myOperand1;
	private Expression myOperand2;
	private int numofop = 2;
	private static final Pattern EXPRESSION_BEGIN_REGEX = Pattern
			.compile("(\\((plus))|(\\((\\+))");
	public Plus() {
		super(0);
	}

	public Plus(Expression[] operands, int currentPosition) {
		super(currentPosition);
		myOperand1 = operands[0];
		myOperand2 = operands[1];
	}

	public Plus setop(Expression[] operands, int currentPosition) {
		return new Plus(operands, currentPosition);
	}

	public RGBColor evaluate(double x, double y, double t) {

		return ColorCombinations.add(myOperand1.evaluate(x, y, t),
				myOperand2.evaluate(x, y, t));
	}

	public int numofop() {
		return numofop;
	}
	
	public Plus getFactory() {
		return this;
	}
	public Pattern getPattern()
	{
		return EXPRESSION_BEGIN_REGEX;
	}


/*	@Override
	public Expression genExpression(String numberMatch, Expression[] operands,
			int myCurrentPosition, String input) {
		LittleTools tool = new LittleTools(input);
		myCurrentPosition = tool.skipWhiteSpace(myCurrentPosition);
		if (myCurrentPosition == input.length()) {
			throw new ParserException("The parens are not balanced!");
		}
		if (tool.currentCharacter(myCurrentPosition) == ')') {
			myCurrentPosition++;
			return setop(operands, myCurrentPosition);

		} else {
			throw new ParserException("Expected close paren, instead found "
					+ input.substring(myCurrentPosition));
	   }
	}*/
}

