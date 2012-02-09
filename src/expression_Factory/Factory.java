package expression_Factory;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import expression.Expression;


import model.Parser;
import model.ParserException;
import model.util.LittleTools;

public abstract class Factory {
	private int myCurrentPosition;
	protected Factory(int currentPosition) {
		myCurrentPosition = currentPosition;
	}

	protected Factory() {
		this(0);
	}


	public abstract Expression getFactory();



	public boolean isThisKindOfExpression(String input,
			int currentPosition, Pattern regex)
	{  
		LittleTools tool = new LittleTools(input);
		currentPosition = tool.skipWhiteSpace(currentPosition);
		Matcher patternMatcher = regex
				.matcher(input.substring(currentPosition));
		boolean result = patternMatcher.lookingAt();
		return result;
	}

	public int getPosition() {
		return myCurrentPosition;
	}

	public void setPosition(int currentPosition) {

		myCurrentPosition = currentPosition;

	}
	public Expression parseExpression(String input, int currentPosition, Map<String,Expression> map) {
		myCurrentPosition = currentPosition;
		Matcher expMatcher = getPattern().matcher(input);
		expMatcher.find(myCurrentPosition);
		myCurrentPosition = expMatcher.end();
		String numberMatch = input.substring(expMatcher.start(),
				expMatcher.end());
		Expression[] operands = genOperands(input, numofop(), map, myCurrentPosition);
		return genExpression(numberMatch,operands,myCurrentPosition, input, map);
	}
    
	

	public abstract Expression genExpression(String numberMatch, Expression[] operands,
			int myCurrentPosition, String input, Map<String, Expression> map);

	protected Expression[] genOperands(String input, int num,
			Map<String, Expression> map, int currentPosition) {
		Expression[] ops = new Expression[num];
		LittleTools tool = new LittleTools(input);
		for (int i = 0; i < num; i++) {
			ops[i] = new Parser().switchExpression(input, myCurrentPosition, map);
			myCurrentPosition = ops[i].getPosition();
			myCurrentPosition = tool.skipWhiteSpace(myCurrentPosition);
			if(myCurrentPosition > input.length())
			{
				throw new ParserException("Unknown Type of Expression is used to evaluate "
						+ input.substring(myCurrentPosition-1));
			}
			if(tool.currentCharacter(myCurrentPosition) == ')')
				return ops;
           
		}
		return ops;
	}
    public abstract Pattern getPattern();
	public abstract int numofop();
    

}
