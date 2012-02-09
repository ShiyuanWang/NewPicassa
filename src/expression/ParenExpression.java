package expression;

import java.util.Map;
import java.util.regex.Pattern;

import model.ParserException;
import model.RGBColor;
import model.util.LittleTools;
import expression_Factory.Factory;

public abstract class ParenExpression extends Factory implements Expression{

	public ParenExpression(int currentPosition)
	{
		super(currentPosition);
	}

	public abstract RGBColor evaluate(double evalX, double evalY, double myCurrentTime); 
	public abstract Expression getFactory();
	public abstract Pattern getPattern();
	public abstract int numofop();

	@Override
	public Expression genExpression(String numberMatch, Expression[] operands,
			int myCurrentPosition, String input, Map<String, Expression> map) {
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
	}



}
