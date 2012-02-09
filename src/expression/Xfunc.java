package expression;

import java.util.Map;
import java.util.regex.Pattern;

import expression_Factory.Factory;

import model.RGBColor;
import model.util.ColorCombinations;

public class Xfunc extends Factory implements Expression {
	private final Pattern X = Pattern.compile("(x)");
    private int type = 0;
	

	public Xfunc(RGBColor value, int currentPosition) {
		super(currentPosition);
	}
	
	public Xfunc() {
		super(0);
	}

	public RGBColor evaluate(double x, double y, double t) {
		return ColorCombinations.XYfunc(x);
	}

	public Xfunc getFactory() {
		return this;
	}

	@Override
	public Expression setop(Expression[] operands, int myCurrentPosition) {
		return this;
	}

    
	public Pattern getPattern()
	{
		return X;
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
		return this;
	}
}
