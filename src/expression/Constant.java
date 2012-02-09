package expression;

import java.util.Map;
import java.util.regex.Pattern;

import expression_Factory.Factory;

import model.RGBColor;


public  class Constant extends Factory implements Expression {
	private RGBColor myValue;
	private int type = 0;
	private static final Pattern DOUBLE_REGEX = Pattern
			.compile("(\\-?[0-9]+(\\.[0-9]+)?)|(\\.[0-9]+)");


	public Constant(RGBColor value, int currentPosition) {
		super(currentPosition);
		myValue = value;
	}
	
	public Constant() {
		super(0);
	}

	public RGBColor evaluate(double x, double y, double t) {
		return myValue;
	}

	public Constant getFactory() {
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
		return DOUBLE_REGEX;
	}
    

    public int getType()
    {
    	return type;
    }

	@Override
	public int numofop() {
		
		return 0;
	}

	@Override
	public Expression genExpression(String numberMatch, Expression[] operands,
			int myCurrentPosition, String input, Map<String,Expression> map) {
		return new Constant(new RGBColor(
				Double.parseDouble(numberMatch)), myCurrentPosition);
	}



}
