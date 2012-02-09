package expression;

import java.util.Map;
import java.util.regex.Pattern;

import expression_Factory.Factory;

import model.ParserException;
import model.RGBColor;

public class Value extends Factory implements Expression{
	int numofop = -1;
	private static final Pattern
	EXPRESSION_BEGIN_REGEX = Pattern.compile("(([a-q]+)|([s]+)|([r]+[a-z]+)|([u-w]+)|([z]+)|([A-Z]+)|([x]+([a-z]+))|([y]+([a-z]+)))");
	public Value(int currentPosition) {
		super(currentPosition);
	}

	public Value() {
		super(0);
	}

	@Override
	public Value getFactory() {
		return this;
	}

	public RGBColor evaluate(double x, double y, double t) {
		return null;
	}

	@Override
	public Expression setop(Expression[] operands, int myCurrentPosition) {
		return null;
	}

	@Override
	public Pattern getPattern() {
		return EXPRESSION_BEGIN_REGEX;
	}

	@Override
	public int numofop() {
		return 0;
	}

	@Override
	public Expression genExpression(String numberMatch, Expression[] operands,
			int myCurrentPosition, String input, Map<String, Expression> map) {
		if (map.containsKey(numberMatch)) {
			Expression val = map.get(numberMatch);
			val.setPosition(myCurrentPosition);
			return val;
		}
		else 
			throw new ParserException("Unknown Type of Expression is used to evaluate "
					+ input.substring(myCurrentPosition-1));
	}

}


