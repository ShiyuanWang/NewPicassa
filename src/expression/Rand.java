package expression;

import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

import model.RGBColor;
import expression_Factory.Factory;

public class Rand extends Factory implements Expression{
	private RGBColor myValue;
	private final Pattern EXPRESSION_BEGIN_REGEX = Pattern
			.compile("(random)");
	
	public Rand(RGBColor value, int currentPosition) {
		super(currentPosition);
		myValue = value;
	}
	
	public Rand() {
		super(0);
	}

	public RGBColor evaluate(double x, double y, double t) {
		Random ran=new Random();
		myValue = new RGBColor(ran.nextFloat(),ran.nextFloat(),ran.nextFloat());
		return myValue;
	}

	public Rand getFactory() {
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
		return EXPRESSION_BEGIN_REGEX;
	}
    
	@Override
	public int numofop() {
		
		return 0;
	}

	@Override
	public Expression genExpression(String numberMatch, Expression[] operands,
			int myCurrentPosition, String input, Map<String,Expression> map) {
		return this;
	}
}
