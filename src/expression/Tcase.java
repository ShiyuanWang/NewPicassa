package expression;

import java.util.Map;
import java.util.regex.Pattern;

import expression_Factory.Factory;

import model.RGBColor;

public class Tcase extends Factory implements Expression {
	private final Pattern T = Pattern.compile("(t)");
	private int numofop = 0;
    public Tcase(RGBColor value, int currentPosition) {
		super(currentPosition);
	}
	
	public Tcase() {
		super(0);
	}

	public RGBColor evaluate(double x, double y, double t) {
		return new RGBColor(t, t, t);
	}

	public Tcase getFactory() {
		return this;
	}

	@Override
	public Expression setop(Expression[] operands, int myCurrentPosition) {
		return this;
	}

	@Override
	public void setPosition(int currentPosition) {
		super.setPosition(currentPosition);
	}
    
	public Pattern getPattern()
	{
		return T;
	}
    
	@Override
	public int numofop() {
		
		return numofop;
	}

	@Override
	public Expression genExpression(String numberMatch, Expression[] operands,
			int myCurrentPosition, String input, Map<String,Expression> map) {
		return this;
	}
}
