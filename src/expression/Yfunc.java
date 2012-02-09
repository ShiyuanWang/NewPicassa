package expression;

import java.util.Map;
import java.util.regex.Pattern;

import expression_Factory.Factory;

import model.RGBColor;
import model.util.ColorCombinations;

public class Yfunc extends Factory implements Expression {
	private final Pattern Y = Pattern.compile("(y)");
	private int numofop = 0;
    private int type = 0;
    public Yfunc(RGBColor value, int currentPosition) {
		super(currentPosition);
	}
	
	public Yfunc() {
		super(0);
	}

	public RGBColor evaluate(double x, double y, double t) {
		return ColorCombinations.XYfunc(x);
	}

	public Yfunc getFactory() {
		return this;
	}

	@Override
	public Expression setop(Expression[] operands, int myCurrentPosition) {
		return this;
	}

    
	public Pattern getPattern()
	{
		return Y;
	}
    

    public int getType()
    {
    	return type;
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
